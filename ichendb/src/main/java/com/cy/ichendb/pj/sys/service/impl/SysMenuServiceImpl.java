package com.cy.ichendb.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import com.cy.ichendb.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.ichendb.pj.common.exception.ServiceException;
import com.cy.ichendb.pj.common.vo.Node;
import com.cy.ichendb.pj.sys.dao.SysMenuDao;
import com.cy.ichendb.pj.sys.entity.SysMenu;

@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;

	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> list = sysMenuDao.findObjects();
		if (list == null || list.size() == 0) {
			throw new ServiceException("没有对应菜单信息");
		}
		return list;
	}

	@Override
	public List<Node> findZtreeMenuNodes() {
		List<Node> list = sysMenuDao.findZtreeMenuNodes();
		return list;
	}

	@Override
	public int saveObject(SysMenu entity) {
		// 1.合法验证
		if (entity == null) {
			throw new ServiceException("保存的对象不能是空");
		}
		if (StringUtils.isEmpty(entity.getName())) {
			throw new ServiceException("菜单名不能为空");
		}
		int rows;
		try {
				rows = sysMenuDao.insertObject(entity);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		return rows;
	}

	@Override
	public int updateObject(SysMenu entity) {
		// 1.合法验证
		if (entity == null) {
			throw new ServiceException("保存的对象不能是空");
		}
		if (StringUtils.isEmpty(entity.getName())) {
			throw new ServiceException("菜单名不能为空");
		}
		int rows;
		try {
			rows = sysMenuDao.updateObject(entity);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		return rows;
	}

}
