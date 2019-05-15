package com.lym.springboot.mockmvc.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lym.springboot.mockmvc.domain.ExceptionEntity;
import com.lym.springboot.mockmvc.domain.ResponseResult;
import com.lym.springboot.mockmvc.enums.ResultEnum;
import com.lym.springboot.mockmvc.exception.BaseException;
import com.lym.springboot.mockmvc.exception.WebApiException;
import com.lym.springboot.mockmvc.exception.WebException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @Author: in liuyuanming
 * @Description: 全局异常处理 https://blog.csdn.net/hao_kkkkk/article/details/80538955
 * @Date:Created in  2019/4/19/019 19:11
 */
@ControllerAdvice(basePackages = "com.lym.springboot.mockmvc")
public class BaseControllerAdvice {

    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(BaseControllerAdvice.class);

    /**
     * Ajax 请求头 X-Requested-With
     */
    private static final String X_REQUESTED_WITH = "X-Requested-With";

    /**
     * XMLHttpRequest 请求
     */
    private static final String XMLHTTPREQUEST = "XMLHttpRequest";

    /**
     * 默认错误页
     */
    private static final String DEFAULT_ERROR_VIEW = "/error";

    /**
     * 参数验证异常捕捉处理
     *
     * @param ex MethodArgumentNotValidException 异常
     * @return 通用结果
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        return setResponseResult(errors);
    }

    /**
     * 参数验证异常捕捉处理
     *
     * @param ex BindException 异常
     * @return 通用结果
     */
    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public ResponseResult bindExceptionHandler(BindException ex) {
        List<ObjectError> errors = ex.getAllErrors();
        return setResponseResult(errors);
    }

    /**
     * 根据异常信息返回通用结果
     *
     * @param errors 异常信息
     * @return 通用结果
     */
    private ResponseResult setResponseResult(List<ObjectError> errors) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(ResultEnum.INPUT_PARAM_ERROR.getCode());
        if (errors != null && errors.size() > 0) {
            responseResult.setMsg(errors.get(0).getDefaultMessage());
        } else {
            responseResult.setMsg(ResultEnum.INPUT_PARAM_ERROR.getMessage());
        }
        return responseResult;
    }

    /**
     * 处理 Web Api 接口相关的异常
     * @param exception 异常信息
     * @return 通用结果
     */
    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public ResponseResult webApiExceptionHandler(BaseException exception) {
        return getResponseResult(exception);
    }

    /**
     * 所有异常处理 包括 web页面异常, rest web api 接口异常,  ajax 请求接口返回异常
     *
     * @param httpServletRequest  request
     * @param exception           异常信息
     * @param httpServletResponse response
     * @return 模型实体
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView modelAndViewExcetpionHander(HttpServletRequest httpServletRequest, Exception exception, HttpServletResponse httpServletResponse) {
        ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setCode(httpServletResponse.getStatus());
        exceptionEntity.setMessage(exception.getLocalizedMessage());
        exceptionEntity.setUrl(httpServletRequest.getRequestURI());
        exceptionEntity.setErrorClass(exception.getClass().getName());
        logger.error("baseExceptionHandler", exceptionEntity);

        ResponseResult responseResult = getResponseResult(exception);
        /*
            Json 或者 WebApi请求
        */
        if (checkAjax(httpServletRequest)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                httpServletResponse.setStatus(200);
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().write(objectMapper.writeValueAsString(responseResult));
            } catch (IOException e) {
                logger.error("baseExceptionHandler response writer", e);
                e.printStackTrace();
            }
            return null;
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", responseResult);
            mav.setViewName(getViewName(httpServletResponse));
            return mav;
        }
    }

    /**
     * 根据异常类型获取不同的返回结果实体
     *
     * @param exception 异常
     * @return 返回结果
     */
    private ResponseResult getResponseResult(Exception exception) {
        ResponseResult result = new ResponseResult();
        if (exception instanceof WebException) {
            result.setMsg("WebException");
            result.setCode(10001);
        } else if (exception instanceof BaseException) {
            result.setMsg("BaseException");
            result.setCode(10002);
        } else if (exception instanceof WebApiException) {
            result.setMsg("WebApiException");
            result.setCode(10003);
        } else {
            result.setMsg("else Exception");
            result.setCode(10004);
        }
        return result;
    }

    /**
     * 根据状态码返回对应的错误实体页面
     *
     * @param httpServletResponse response
     * @return
     */
    private String getViewName(HttpServletResponse httpServletResponse) {
        int status = httpServletResponse.getStatus();
        switch (status) {
            case HttpServletResponse.SC_INTERNAL_SERVER_ERROR:
                return "/error/500.html";
            case HttpServletResponse.SC_NOT_FOUND:
                return "/error/404.html";
            default:
                return DEFAULT_ERROR_VIEW;
        }
    }

    /**
     * 验证是否是 rest web api 接口异常,  ajax
     *
     * @param request
     * @return
     */
    private boolean checkAjax(HttpServletRequest request) {
        if (request.getHeader(HttpHeaders.ACCEPT).contains(MediaType.APPLICATION_JSON_VALUE)) {
            System.out.println(MediaType.APPLICATION_JSON_VALUE);
            return true;
        } else if (request.getHeader(HttpHeaders.ACCEPT).contains(MediaType.APPLICATION_FORM_URLENCODED_VALUE)) {
            System.out.println(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
            return true;
        } else if ((request.getHeader(HttpHeaders.AUTHORIZATION) != null && request.getHeader(X_REQUESTED_WITH).contains(XMLHTTPREQUEST))) {
            return true;
        } else {
            return false;
        }
    }
}
