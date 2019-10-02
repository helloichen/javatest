package com.cy.ichendb.pj.sys.service.impl;

import com.cy.ichendb.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.ichendb.pj.common.exception.ServiceException;
import com.cy.ichendb.pj.sys.dao.SysLogDao;
import com.cy.ichendb.pj.sys.entity.SysLog;

import lombok.extern.slf4j.Slf4j;

/**
 * 业务逻辑层对象 1)核心业务(日志分页查询,日志删除) 2)扩展业务(权限控制,事务控制)
 */
@Slf4j
@Service
public class SysLogServiceImpl extends BasePageService<SysLog> implements SysLogService {
	private SysLogDao sysLogDao;

	@Autowired
	public SysLogServiceImpl(SysLogDao sysLogDao) {
		super(sysLogDao);
		this.sysLogDao = sysLogDao;
	}

	@Override
	public int deleteObjects(Integer... ids) {
		// 1.判定参数合法性
		if (ids == null || ids.length == 0) {
			throw new IllegalArgumentException("请选择一个项目");
		}
		// 执行删除操作
		int rows;
		try {
			rows = sysLogDao.deleteObjects(ids);
			log.info("delete rows:" + rows);
		} catch (Throwable e) {
			e.printStackTrace();
			// 3.发出报警信息(例如给运维人员发短信)
			throw new ServiceException("系统故障,正在恢复中...");
		}
		// 4.验证结果
		if (rows == 0) {
			throw new ServiceException("记录已经不存在");
		}
		// 5.返回结果
		return rows;
	}

}
