package com.cy.ichendb.pj.sys.service;
import java.util.List;
import java.util.Map;

import com.cy.ichendb.pj.common.vo.Node;
import com.cy.ichendb.pj.sys.entity.SysDept;

public interface SysDeptService {
	int saveObject(SysDept entity);
	int updateObject(SysDept entity);
	
	List<Node> findZTreeNodes();
	List<Map<String,Object>> findObjects();
	
	int deleteObject(Integer id);
}
