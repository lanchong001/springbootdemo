package com.lym.springboot;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import com.lym.springboot.service.UserService;


/**
 * 用户管理模块
 * @author liuyuanming
 */
@Controller
@Namespace("com.lym.springboot")
@Results( {
	@Result(name = "list", location = "User.jsp")
	})
public class UserController extends ActionSupport {

	@Resource
	private UserService userService;

	/**
	 * è·³è½¬å°åè¡¨é¡µé¢
	 */
	@Action("User_list")
	public String list() {
		HttpServletRequest  request=ServletActionContext.getRequest();
		request.setAttribute("entityList", userService.getScrollData().getResultlist());
		return "list";
	}

}