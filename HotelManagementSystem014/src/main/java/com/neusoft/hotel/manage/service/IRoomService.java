package com.neusoft.hotel.manage.service;

import java.util.List;

import com.neusoft.hotel.manage.model.RoomModel;

public interface IRoomService {

	/**
	  *   增删改操作
	 */
	
	// 增加room
	public void add(RoomModel room) throws Exception;
	
	// 更新room
	public void modify(RoomModel room) throws Exception;
	
	// 删除room
	public void delete(RoomModel room) throws Exception;
	
	/**
	  *   通过属性值进行查找
	 */
	
	// 通过房间号查找room
	public RoomModel getByRid(String rid) throws Exception;
	
	// 通过楼层查找
	public List<RoomModel> getByFloor(int floor) throws Exception;
	
	// 通过房间类型查找
	public List<RoomModel> getByType(String rid) throws Exception;
	
	// 通过房间状态查找
	public List<RoomModel> getByStatus(String rid) throws Exception;
	
	// 通过价格范围进行查找
	public List<RoomModel> getByPrice(int lowPrice, int highPrice) throws Exception;
	
	/**
	  *   查询整个表
	 */
	// 查询客房总数
	public int getTotal() throws Exception;
	
	//分页查找所有的客房
	public List<RoomModel> getListByAllWithPage(int rows, int page) throws Exception;
		
}
