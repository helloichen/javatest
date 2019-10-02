package com.cy.ichendb.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserRoleDao {
	@Delete("delete from sys_user_roles where role_id=#{id}")
	int deleteObjectsByUserId(Integer id);

	/**
	 * 负责将用户与角色的关系写入到数据库
	 * 
	 * @param userId  用户id
	 * @param roleIds 多个角色id
	 * @return
	 */
	int insertObjects(@Param("userId") Integer userId, @Param("roleIds") Integer[] roleIds);

	@Select("select role_id from sys_user_roles where user_id=#{id}")
	List<Integer> findRoleIdsByUserId(Integer id);
	
	
}
