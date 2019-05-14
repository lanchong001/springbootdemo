package com.lym.springboot.mockmvc.advice;

import com.lym.springboot.mockmvc.domain.ResponseResult;
import com.lym.springboot.mockmvc.enums.ResultEnum;
import com.lym.springboot.mockmvc.exception.BaseException;
import com.lym.springboot.mockmvc.exception.WebException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: in liuyuanming
 * @Description: 全局异常处理 https://blog.csdn.net/hao_kkkkk/article/details/80538955
 * @Date:Created in  2019/4/19/019 19:11
 */
@ControllerAdvice(basePackages = "com.lym.springboot.mockmvc")
public class BaseControllerAdvice {

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
     * @param errors 异常信息
     * @return 通用结果
     */
    private ResponseResult setResponseResult(List<ObjectError> errors){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(ResultEnum.INPUT_PARAM_ERROR.getCode());
        if (errors != null && errors.size() > 0) {
            responseResult.setMsg(errors.get(0).getDefaultMessage());
        } else {
            responseResult.setMsg(ResultEnum.INPUT_PARAM_ERROR.getMessage());
        }
        return responseResult;
    }

    @ExceptionHandler(value = WebException.class)
    public ModelAndView baseExceptionHandler(HttpServletRequest httpServletRequest, WebException webException, HttpServletResponse httpServletResponse) {
        Map<String,String> map = new HashMap<>();
        map.put("msg",webException.getMessage());
        map.put("code",String.valueOf(webException.getCode()));
        return new ModelAndView("common/error.html",map);
    }

//    /**
//     * 全局异常捕捉处理
//     *
//     * @param ex 异常信息
//     * @return 通用错误返回结果
//     */
//    @ResponseBody
//    @ExceptionHandler(value = Exception.class)
//    public ResponseResult exceptionHandler(Exception ex) {
//        ResponseResult responseResult = new ResponseResult();
//        responseResult.setCode(ResultEnum.FAILURE.getCode());
//        responseResult.setMsg(ex.getMessage());
//        return responseResult;
//    }

    /**
     * 拦截捕捉自定义异常 BaseException.class
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public ResponseResult baseExceptionHandler(BaseException ex) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(ex.getCode());
        responseResult.setMsg(ex.getMessage());
        return responseResult;
    }

    @ExceptionHandler(value = { Exception.class })
    public ModelAndView noFind(Exception exception) {
        Map<String,String> map = new HashMap<>();
        map.put("msg",exception.getMessage());
        map.put("code","500");
        return new ModelAndView("common/error.html",map);
    }
}
