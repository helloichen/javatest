package com.ichen.controller;


import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ichen.dao.DoorMapper;
import com.ichen.pojo.Door;

/**测试类:测试mybatis的运行环境*/
public class TestMybatis {
	//查询所有门店信息
	public static void main(String[] args) throws Exception{
		//1.读取mybatis-config.xml核心配置文件
		InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		//2.获取SqlSessionFactory对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.获取SqlSession对象
		SqlSession session = factory.openSession();
		//4.获取Mapper实例,调用findALL执行sql
		DoorMapper dao = session.getMapper(DoorMapper.class);
		List<Door> list = dao.findAll();
		//5输出结果
		for (Door door : list) {
			System.out.println(door);
		}
		
	}
}
