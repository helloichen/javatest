package com.cy.ichendb.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PageDao<T> {
	/**
	 * 分页查询角色信息 
	 * @param name
	 * @param startIndex 上一页的结束位置
	 * @param pageSize   每页要查询的记录i数
	 * @return
	 */
	List<T> findPageObjects(@Param("name") String name, @Param("startIndex") Integer startIndex,
                            @Param("pageSize") Integer pageSize);

	int getRowCount(@Param("name") String name);
}
