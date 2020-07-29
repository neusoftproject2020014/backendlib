package com.neusoft.hotel.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.neusoft.hotel.manage.model.RoomModel;

@Mapper
public interface IRoomMapper {
	/**
	  *   增删改操作
	 */
	
	// 增加room
	public void insert(RoomModel room) throws Exception;
	
	// 更新room
	public void update(RoomModel room) throws Exception;
	
	// 删除room
	public void delete(RoomModel room) throws Exception;
	
	/**
	  *   通过属性值进行查找
	 */
	
	// 通过房间号查找room
	public RoomModel selectByRid(String rid) throws Exception;
	
	// 通过楼层查找
	public List<RoomModel> selectByfloor(String rid) throws Exception;
	
	// 通过房间类型查找
	public List<RoomModel> selectByType(String rid) throws Exception;
	
	// 通过房间状态查找
	public List<RoomModel> selectByStatus(String rid) throws Exception;
	
	// 通过价格范围进行查找
	public List<RoomModel> selectByPrice(@Param("lowPrice") int lowPrice, @Param("highPrice") int highPrice) throws Exception;
	
	/**
	  *   查询整个表
	 */
	// 查询客房总数
	public int selectTotal() throws Exception;
	
	//分页查找所有的客房
	public List<RoomModel> selectListByAllWithPage(@Param("start") int start, @Param("row") int row) throws Exception;
	
}
