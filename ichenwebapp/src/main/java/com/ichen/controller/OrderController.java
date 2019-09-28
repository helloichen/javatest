package com.ichen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ichen.dao.DoorMapper;
import com.ichen.dao.OrderMapper;
import com.ichen.pojo.Door;
import com.ichen.pojo.Order;

@Controller
public class OrderController {
	@Autowired
	private OrderMapper dao;
	@Autowired
	private DoorMapper doorDao;

	// 查询所有订单信息
	@RequestMapping("orderList")
	public String orderList(Model model) {
		List<Door> dList = doorDao.findAll();
		model.addAttribute("dList", dList);
		List<Order> list = dao.findAll();
		model.addAttribute("oList", list);
		return "order_list";
	}

	// 查询所有门店再跳转到新增订单页面
	@RequestMapping("toAddOrder")
	public String toAddOrder(Model model) {
		List<Door> dList = doorDao.findAll();
		model.addAttribute("dList", dList);
		return "order_add";
	}
	//新增订单信息
	@RequestMapping("orderAdd")
	public String orderAdd(Order order){
		dao.addOrder(order);
		return "redirect:orderList";
	}
	//删除订单信息
	@RequestMapping("orderDelete")
	public String orderDelete(Integer id){
		dao.deleteOrder(id);
		return "redirect:orderList";
	}
	
	//根据id查询订单信息
	@RequestMapping("orderInfo")
	public String orderInfo(Integer id,Model model){
		//根据id查询订单
		Order order=dao.findById(id);
		//订单数据存入model中
		model.addAttribute("order", order);
		//查询所有门店
		List<Door> list = doorDao.findAll();
		//门店数据存入model
		model.addAttribute("doorList", list);
		//将model及其中的数据带到jsp进行回显
		return "order_update";
	}
	
	//根据id修改订单信息
	@RequestMapping("orderUpdate")
	public String orderUpdate(Order order){
		//调用dao的updateById方法
		dao.updateById(order);
		return "redirect:orderList";
	}
}
