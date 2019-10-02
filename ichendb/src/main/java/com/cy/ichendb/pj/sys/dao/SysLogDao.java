package com.cy.ichendb.pj.sys.dao;

import com.cy.ichendb.pj.sys.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysLogDao extends PageDao<SysLog> {
//	@Delete("delete from sys_logs where id=#{id}")
//	int deleteObject(Integer id);

	int deleteObjects(@Param("ids") Integer... ids);

	int insertObject(SysLog entity);
}
