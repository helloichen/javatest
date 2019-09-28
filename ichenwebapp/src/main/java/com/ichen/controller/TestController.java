package com.ichen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ichen.dao.DoorMapper;
import com.ichen.pojo.Door;

/**
 * 测试类:测试springmvc开发环境
 */

@Controller
public class TestController {
	@RequestMapping("/testSpringmvc")
	public String tsetSpringmvc() {
		System.out.println("springmvc环境测试");
		return "test";
	}

	// @Autowired注解
	/*
	 * 由于前面在spring的配置了文件中配置的接口扫描器,spring会为dao包下面的所有接口提供实现类,
	 * 也会创建实现类的实例 ,再根据类型匹配,将创建好的DoorMapper接口的实例赋值给dao
	 */
	@Autowired
	private DoorMapper dao;

	@RequestMapping("/testssm")
	public String testssm() {
		System.out.println("ssm环境测试");
		// 查询所有门店信息
		List<Door> list = dao.findAll();
		for (Door door : list) {
			System.out.println(door);
		}
		return "test";
	}
}
