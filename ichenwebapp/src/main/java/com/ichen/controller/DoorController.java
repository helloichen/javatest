package com.ichen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ichen.dao.DoorMapper;
import com.ichen.pojo.Door;

@Controller
public class DoorController {
	/* 通过自动装配获取DoorMapper接口的实例
	 * 框架底层会为DoorMapper接口提供实现类
	 * 并自动创建实例.
	 */
	@Autowired
	private DoorMapper dao;
	/**1.查询所有门店信息
	 * 点击门店管理,查询所有门店
	 * 跳转到door_list.jsp */
	@RequestMapping("doorList")
	public String doorList(Model model) {
		//查询所有门店信息
		List<Door> list = dao.findAll();
		//将们带你集合存入model中
		model.addAttribute("list", list);
		//将model及其中的数据转发到jsp
		return "door_list";
	}
	
	/**2.新增门店
	 * 通过在方法上声明一个door对象,
	 * 用于接收浏览器发送过来的name tel addr参数的值
	 * name:door.setName(name)
	 * */
	@RequestMapping("doorAdd")
	public String doorAdd(Door door){
		//调用dao添加门店的方法
		dao.addDoor(door);
		//跳转到门店列表页面,查询最新门店列表
		return "redirect:doorList";
	}
	
	/**3.删除门店*/
	@RequestMapping("doorDelete")
	public String doorDelete(Integer id){
		dao.deleteDoor(id);
		return "redirect:doorList";
	}
	
	/**4.1根据id查询门店信息*/
	@RequestMapping("doorInfo")
	public String doorInfo(Integer id,Model model){
		Door door = dao.findById(id);
		model.addAttribute("door", door);
		return "door_update";
	}

	/**4.2 根据id修改门店信息*/
	@RequestMapping("doorUpdate")
	public String doorUpdate(Door door){
		dao.updateById(door);
		return "redirect:doorList";
	}
	/**
	 * 通用的方法,可以访问所有jsp页面
	 * 根据jsp页面的名字跳转到指定的jsp页面
	 */
	@RequestMapping("/{page}")
	public String pages(@PathVariable String page) {
		return page;
	}
}
