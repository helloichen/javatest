package com.cy.ichendb.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 在此controller中实现所有 页面呈现
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/")
public class PageController {
	// 返回首页
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
	}

//	// 日志列表页面
//	@RequestMapping("log/doLogUI")
//	public String doLogUI() {
//		return "sys/log_list";
//	}

	// 分页div页面
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}

//	@RequestMapping("menu/doMenuUI")
//	public String doMenuListUI() {
//		return "sys/menu_list";
//	}
	@RequestMapping("{module}/{page}")
	public String doModuleUI(@PathVariable String page) {
		return "sys/" + page;
	}

	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
	}
}
