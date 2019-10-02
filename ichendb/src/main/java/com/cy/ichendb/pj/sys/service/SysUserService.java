package com.cy.ichendb.pj.sys.service;

import java.util.Map;

import com.cy.ichendb.pj.sys.vo.SysUserDeptVo;
import com.cy.ichendb.pj.sys.entity.SysUser;

public interface SysUserService extends PageService<SysUserDeptVo> {
	int saveObject(SysUser entity, Integer[] roleIds);

	Map<String, Object> findObjectById(Integer userId);

	int updateObject(SysUser entity, Integer[] roleIds);

	int validById(Integer id, Integer valid, String modifiedUser);

}
