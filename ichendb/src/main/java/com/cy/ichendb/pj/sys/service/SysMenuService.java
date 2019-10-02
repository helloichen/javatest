package com.cy.ichendb.pj.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.ichendb.pj.common.vo.Node;
import com.cy.ichendb.pj.sys.entity.SysMenu;

public interface SysMenuService {
	List<Map<String, Object>> findObjects();

	List<Node> findZtreeMenuNodes();

	int saveObject(SysMenu entity);

	int updateObject(SysMenu entity);
}
