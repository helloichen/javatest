package com.cy.ichendb.pj.sys.service.impl;

import java.util.List;

import com.cy.ichendb.pj.sys.dao.PageDao;
import com.cy.ichendb.pj.sys.service.PageService;
import com.cy.ichendb.pj.common.exception.ServiceException;
import com.cy.ichendb.pj.common.vo.PageObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BasePageService<T> implements PageService<T> {

	private PageDao<T> pageDao;
	public BasePageService(PageDao<T> pageDao) {
		this.pageDao=pageDao;
	}

	public PageObject<T> findPageObjects(String name, Integer pageCurrent) {
		// 1.验证参数合法性
		// 1.1验证pageCurrent的合法性
		// 不合法抛出IllegaArgumentException异常
		if (pageCurrent == null || pageCurrent < 1) {
			throw new IllegalArgumentException("当前页码不正确");
		}
		// 2.基于条件查询总记录数
		// 2.1执行查询
		int rowCount = pageDao.getRowCount(name);
		log.info("总记录数:" + rowCount);
		// 2.2验证查询结果,假如结果为0不再执行如下操作
		if (rowCount == 0) {
			throw new ServiceException("系统没有查到对应记录");
		}
		// 3.基于条件查询当前页记录(pageSize=1)
		// 3.1 定义pageSize
		int pageSize = 3;
		// 3.2 计算startIndex
		int startIndex = (pageCurrent - 1) * pageSize;
		int pageCount = (rowCount - 1) / pageSize + 1;
		// 3.3执行当前数据的查询操作
		List<T> records = pageDao.findPageObjects(name, startIndex, pageSize);
		// 4.对分页信息以及当前页记录进行封装
		// 4.2封装数据
		return new PageObject<>(pageCurrent, pageSize, rowCount, pageCount, records);
	}
}
