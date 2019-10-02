package com.cy.ichendb.pj.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cy.ichendb.pj.common.vo.JsonResult;
import com.cy.ichendb.pj.common.vo.Node;
import com.cy.ichendb.pj.sys.entity.SysMenu;
import com.cy.ichendb.pj.sys.service.SysMenuService;

@RestController
@RequestMapping("/menu/")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;

	@RequestMapping("doFindObjects")
	public JsonResult doFindObjects() {
		List<Map<String, Object>> list = sysMenuService.findObjects();
		return new JsonResult(list);
	}
	
	@RequestMapping("doFindZtreeMenuNodes")
	public JsonResult doFindZtreeMenuNodes() {
		List<Node> list = sysMenuService.findZtreeMenuNodes();
		return new JsonResult(list);
	}
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysMenu entity) {
		sysMenuService.saveObject(entity);
		return new JsonResult("save ok");
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysMenu entity) {
		sysMenuService.saveObject(entity);
		return new JsonResult("save ok");
	}
}
