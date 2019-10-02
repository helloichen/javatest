package com.cy.ichendb.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.ichendb.pj.common.exception.ServiceException;
import com.cy.ichendb.pj.common.vo.JsonResult;
import com.cy.ichendb.pj.common.vo.PageObject;
import com.cy.ichendb.pj.sys.entity.SysLog;
import com.cy.ichendb.pj.sys.service.SysLogService;

@RestController // @RestController=@Controller+@ResponseBody
@RequestMapping("/log/")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;

	@RequestMapping("doFindPageObjects")
	public JsonResult findPageObjects(String username, Integer pageCurrent) throws ServiceException {
		PageObject<SysLog> pageObjects = sysLogService.findPageObjects(username, pageCurrent);
		return new JsonResult(pageObjects);// 默认jackson转换 json string
	}

	@RequestMapping("doDeleteObjects")
	public JsonResult deleteObjects(Integer... ids) {
		sysLogService.deleteObjects(ids);
		return new JsonResult("delete OK");
	}
}
