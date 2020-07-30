package com.neusoft.hotel.manage.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.hotel.manage.model.CustomerModel;

@Mapper
public interface ICustomerMapper {
	
	/**
	  *   增删改操作
	 */
	
	// 增加customer
	public void insert(CustomerModel customer) throws Exception;
	
	// 更新customer
	public void update(CustomerModel customer) throws Exception;
	
	// 删除customer
	public void delete(String id) throws Exception;
	
	/**
	  *   通过属性查询操作
	 */

	// 通过id选择客户
	public CustomerModel selectById(String id) throws Exception;
	
	// 通过id来选择用户，用户对选中包含房间信息和所消耗的商品信息
	public CustomerModel selectByIdWithRoomAndProduct(String id) throws Exception;
	
	// 通过name选择customer
	public CustomerModel selectByName(String name) throws Exception;
	
	// 通过房间号来查找customer
	public List<CustomerModel> selectByRid(String rid) throws Exception;
	
	// 查找特定时间段的入住customer
	public List<CustomerModel> selectByCheckInTime(@Param("startDate") Date startDate, @Param("endDate") Date endDate) throws Exception;
	
	// 查找特定时间段的退房customer
	public List<CustomerModel> selectByCheckOutTime(@Param("startDate") Date startDate, @Param("endDate") Date endDate) throws Exception;
	
	/**
	  *   查询整表属性操作
	 */
	// 查询customer总数
	public int selectTotal() throws Exception;
	
	// 分页查找所有的客户
	public List<CustomerModel> selectListByAllWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;
	
	
	
	
	
	
	
	

}
