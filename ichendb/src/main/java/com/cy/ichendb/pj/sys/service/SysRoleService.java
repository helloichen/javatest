package com.cy.ichendb.pj.sys.service;

import java.util.List;

import com.cy.ichendb.pj.sys.vo.SysRoleMenuVo;
import com.cy.ichendb.pj.common.vo.CheckBox;
import com.cy.ichendb.pj.sys.entity.SysRole;

public interface SysRoleService extends PageService<SysRole> {

	int saveObject(SysRole entity, Integer[] menuIds);

	int deleteObject(Integer id);

	SysRoleMenuVo findObjectById(Integer id);

	int updateObject(SysRole entity, Integer[] menuIds);

	List<CheckBox> findObjects();

	
}
