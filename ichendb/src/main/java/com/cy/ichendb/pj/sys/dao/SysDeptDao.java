package com.cy.ichendb.pj.sys.dao;
import java.util.List;
import java.util.Map;

import com.cy.ichendb.pj.common.vo.Node;
import com.cy.ichendb.pj.sys.entity.SysDept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysDeptDao {
	int updateObject(SysDept entity);
	int insertObject(SysDept entity);
	List<Node> findZTreeNodes();
	List<Map<String,Object>> findObjects();
	int getChildCount(Integer id);
	int deleteObject(Integer id);
}
