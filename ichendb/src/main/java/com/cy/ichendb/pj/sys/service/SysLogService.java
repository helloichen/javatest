package com.cy.ichendb.pj.sys.service;

import org.apache.ibatis.annotations.Param;

import com.cy.ichendb.pj.sys.entity.SysLog;

public interface SysLogService extends PageService<SysLog> {
	int deleteObjects(@Param("ids") Integer... ids);

}
