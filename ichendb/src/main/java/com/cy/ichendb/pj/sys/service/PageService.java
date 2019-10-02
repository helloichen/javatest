package com.cy.ichendb.pj.sys.service;

import com.cy.ichendb.pj.common.vo.PageObject;

public interface PageService<T> {
	/**
	 * 分页查询角色信息,并查询角色总记录数据
	 * @param name
	 * @param pageCurrent 
	 * @return 封装当前实体拿数据以及分页信息
	 */
	PageObject<T> findPageObjects(String name, Integer pageCurrent);
}
