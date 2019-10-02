package com.cy.ichendb.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysRoleMenuDao {
	@Delete("delete from sys_role_menus where role_id=#{id}")
	int deleteObjectsByRoleId(Integer id);

	@Select("select menu_id from sys_role_menus where role_id=#{id}")
	List<Integer> findMenuIdsByRoleId(Integer id);

	int insertObjects(@Param("roleId") Integer roleId, @Param("menuIds") Integer[] menuId);

}
