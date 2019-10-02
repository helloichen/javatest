package com.cy.ichendb.pj.common.web;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.ichendb.pj.common.vo.JsonResult;

import lombok.extern.slf4j.Slf4j;

/** SpringMVC 全局异常处理类 */
@ControllerAdvice // 此类会交给spring容器管理
@Slf4j
public class GlobalExceptionHandler {
	// JDK中的自带的日志api
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(RuntimeException e) {
		e.printStackTrace();
		return new JsonResult(e);// 封装异常信息
	}

	@ExceptionHandler(BindException.class)
	@ResponseBody
	public JsonResult doHandleBindException(BindException e) {
		return null;

	}

	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doHandleShiroException(ShiroException e) {
		JsonResult r = new JsonResult();
		r.setState(0);
		if (e instanceof UnknownAccountException) {
			r.setMessage("账户不存在");
		} else if (e instanceof LockedAccountException) {
			r.setMessage("账户已被禁用");
		} else if (e instanceof IncorrectCredentialsException) {
			r.setMessage("密码不正确");
		} else if (e instanceof AuthorizationException) {
			r.setMessage("没有此操作权限");
		} else {
			r.setMessage("系统维护中");
		}
		e.printStackTrace();
		return r;
	}

}
