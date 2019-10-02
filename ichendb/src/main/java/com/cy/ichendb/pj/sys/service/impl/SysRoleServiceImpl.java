package com.cy.ichendb.pj.sys.service.impl;

import java.util.List;

import com.cy.ichendb.pj.sys.service.SysRoleService;
import com.cy.ichendb.pj.sys.vo.SysRoleMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.ichendb.pj.common.exception.ServiceException;
import com.cy.ichendb.pj.common.vo.CheckBox;
import com.cy.ichendb.pj.sys.dao.SysRoleDao;
import com.cy.ichendb.pj.sys.dao.SysRoleMenuDao;
import com.cy.ichendb.pj.sys.dao.SysUserRoleDao;
import com.cy.ichendb.pj.sys.entity.SysRole;

@Service
public class SysRoleServiceImpl extends BasePageService<SysRole> implements SysRoleService {
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	public SysRoleServiceImpl(SysRoleDao sysRoleDao) {
		super(sysRoleDao);
		this.sysRoleDao = sysRoleDao;
	}

	@Override
	public int saveObject(SysRole entity, Integer[] menuIds) {
		// 1.合法性验证
		if (entity == null) {
			throw new ServiceException("保存数据不饿能为空");
		}
		if (StringUtils.isEmpty(entity.getName())) {
			throw new ServiceException("角色名不能为空");
		}
		if (menuIds == null || menuIds.length == 0) {
			throw new ServiceException("必须为角色赋予权限");
		}
		// 2.保存数据
		int rows = sysRoleDao.insertObject(entity);
		sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
		// 3.返回结果
		return rows;
	}

	@Override
	public int deleteObject(Integer id) {
		if (id == null || id < 1)
			throw new IllegalArgumentException("id值无效");
		sysRoleMenuDao.deleteObjectsByRoleId(id);
		sysUserRoleDao.deleteObjectsByUserId(id);
		int rows = sysRoleDao.deleteObject(id);
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		return rows;

	}

	@Override
	public SysRoleMenuVo findObjectById(Integer id) {
		if (id == null || id < 1)
			throw new IllegalArgumentException("id值不正确");
		return sysRoleDao.findObjectById(id);
	}

	@Override
	public int updateObject(SysRole entity, Integer[] menuIds) {
		// 1.合法性验证
		if (entity == null)
			throw new ServiceException("更新的对象不能为空");
		if (entity.getId() == null)
			throw new ServiceException("id的值不能为空");

		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("角色名不能为空");
		if (menuIds == null || menuIds.length == 0)
			throw new ServiceException("必须为角色指定一个权限");

		// 2.更新数据
		int rows = sysRoleDao.updateObject(entity);
		if (rows == 0)
			throw new ServiceException("对象可能已经不存在");
		// 2.1更新时先删除原有关系数据
		sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		// 2.2再插入新的数据
		sysRoleMenuDao.insertObjects(entity.getId(), menuIds);

		// 3.返回结果
		return rows;

	}
	
	@Override
	public List<CheckBox> findObjects() {
		return sysRoleDao.findObjects();
	}
}
