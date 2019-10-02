package com.cy.ichendb.pj.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.cy.ichendb.pj.sys.service.SysUserService;
import com.cy.ichendb.pj.sys.vo.SysUserDeptVo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cy.ichendb.pj.common.exception.ServiceException;
import com.cy.ichendb.pj.sys.dao.SysUserDao;
import com.cy.ichendb.pj.sys.dao.SysUserRoleDao;
import com.cy.ichendb.pj.sys.entity.SysUser;

@Service
public class SysUserServiceImpl extends BasePageService<SysUserDeptVo> implements SysUserService {
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Autowired
	public SysUserServiceImpl(SysUserDao sysUserDao) {
		super(sysUserDao);
		this.sysUserDao = sysUserDao;
	}

	@Transactional
	@Override
	public int saveObject(SysUser entity, Integer[] roleIds) {
		// 1.验证数据合法性
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
//		if (StringUtils.isEmpty(entity.getUsername()))
//			throw new ServiceException("用户名不能为空");
		if (StringUtils.isEmpty(entity.getPassword()))
			throw new ServiceException("密码不能为空");
		if (roleIds == null || roleIds.length == 0)
			throw new ServiceException("至少要为用户分配角色");

		// 2.将数据写入数据库
		String salt = UUID.randomUUID().toString();
		entity.setSalt(salt);
		// 加密(先了解,讲shiro时再说)
		SimpleHash sHash = new SimpleHash("MD5", entity.getPassword(), salt);
		entity.setPassword(sHash.toHex());

		int rows = sysUserDao.insertObject(entity);
		sysUserRoleDao.insertObjects(entity.getId(), roleIds);// "1,2,3,4";
		if (rows>0) {
			throw new ServiceException("保存失败");
		}
		// 3.返回结果
		return rows;
	}

	@Override
	public Map<String, Object> findObjectById(Integer userId) {
		// 1.合法性验证
		if (userId == null || userId <= 0)
			throw new ServiceException("参数数据不合法,userId=" + userId);
		// 2.业务查询
		SysUserDeptVo user = sysUserDao.findObjectById(userId);
		if (user == null)
			throw new ServiceException("此用户已经不存在");
		List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(userId);
		// 3.数据封装
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roleIds", roleIds);
		return map;
	}
	
	@Override
	public int updateObject(SysUser entity, Integer[] roleIds) {
		// 1.参数有效性验证
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getUsername()))
			throw new IllegalArgumentException("用户名不能为空");
		if (roleIds == null || roleIds.length == 0)
			throw new IllegalArgumentException("必须为其指定角色");
		// 其它验证自己实现，例如用户名已经存在，密码长度，...
		// 2.更新用户自身信息
		int rows = sysUserDao.updateObject(entity);
		// 3.保存用户与角色关系数据
		sysUserRoleDao.deleteObjectsByUserId(entity.getId());
		sysUserRoleDao.insertObjects(entity.getId(), roleIds);
		
		// 4.返回结果
		return rows;
	}

	@Override
	public int validById(Integer id, Integer valid, String modifiedUser) {
		// 1.合法性验证
		if (id == null || id <= 0)
			throw new ServiceException("参数不合法,id=" + id);
		if (valid != 1 && valid != 0)
			throw new ServiceException("参数不合法,valie=" + valid);
		if (StringUtils.isEmpty(modifiedUser))
			throw new ServiceException("修改用户不能为空");
		// 2.执行禁用或启用操作
		int rows = 0;
		try {
			rows = sysUserDao.validById(id, valid, modifiedUser);
		} catch (Throwable e) {
			e.printStackTrace();
			// 报警,给维护人员发短信
			throw new ServiceException("底层正在维护");
		}
		// 3.判定结果,并返回
		if (rows == 0)
			throw new ServiceException("此记录可能已经不存在");
		return rows;
	}
}
