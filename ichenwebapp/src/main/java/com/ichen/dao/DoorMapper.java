package com.ichen.dao;

import com.ichen.pojo.Door;

import java.util.List;

/**Mapper接口:*/
public interface DoorMapper {
	/**1.查询所有门店信息*/
	public List<Door> findAll();
	
	/**2.新增门店信息*/
	public void addDoor(Door door);

	/**3.删除门店信息*/
	public void deleteDoor(Integer id);

	/**4.1根据id查询门店信息*/
	public Door findById(Integer id);

	/**4.2根据id修改门店信息*/
	public void updateById(Door door);
}
