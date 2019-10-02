package com.cy.ichendb.pj.sys.dao;

import java.util.List;
import java.util.Map;

import com.cy.ichendb.pj.common.vo.Node;
import com.cy.ichendb.pj.sys.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysMenuDao {
	/**
	 * 查询所有菜单以及对应的上级菜单名称 1)一条记录(菜单信息)映射为内存中一个map 2)多条记录对应多个map,
	 * 
	 * @return
	 */
	List<Map<String, Object>> findObjects();

	List<Node> findZtreeMenuNodes();

	int insertObject(SysMenu entity);

	int updateObject(SysMenu entity);
}
