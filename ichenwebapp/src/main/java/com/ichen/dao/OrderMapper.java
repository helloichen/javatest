package com.ichen.dao;

import com.ichen.pojo.Order;

import java.util.List;

public interface OrderMapper {
	//查询所有订单信息
	List<Order> findAll();
	//添加订单
	void addOrder(Order order);
	//根据id删除订单
	void deleteOrder(Integer id);
	//根据id查询订单信息
	Order findById(Integer id);
	void updateById(Order order);
}
