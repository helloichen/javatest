package com.cy.ichendb.pj.sys.dao;

import java.util.List;

import com.cy.ichendb.pj.common.vo.CheckBox;
import com.cy.ichendb.pj.sys.entity.SysRole;
import com.cy.ichendb.pj.sys.vo.SysRoleMenuVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysRoleDao extends PageDao<SysRole> {

	@Delete("delete from sys_roles where id=#{id}")
	int deleteObject(Integer id);

	int insertObject(SysRole entity);

	SysRoleMenuVo findObjectById(Integer id);

	int updateObject(SysRole entity);

	@Select("select id,name from sys_roles")
	List<CheckBox> findObjects();
}
