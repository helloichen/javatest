package com.cy.ichendb.pj.sys.dao;

import com.cy.ichendb.pj.sys.entity.SysUser;
import com.cy.ichendb.pj.sys.vo.SysUserDeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserDao extends PageDao<SysUserDeptVo> {
	/**
	 * 负责将用户信息写入到数据库
	 * 
	 * @param entity
	 * @return
	 */
	int insertObject(SysUser entity);

	SysUserDeptVo findObjectById(Integer id);

	int updateObject(SysUser entity);

	int validById(@Param("id") Integer id, @Param("valid") Integer valid, @Param("modifiedUser") String modifiedUser);

	SysUser findUserByUserName(String username);
}
