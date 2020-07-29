package com.neusoft.hotel.manage.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.hotel.manage.model.CustomerModel;

@Mapper
public interface ICustomerMapper {
	// 增加customer
	public void insert(CustomerModel customer) throws Exception;
	
	// 更新customer
	public void update(CustomerModel customer) throws Exception;
	
	// 删除customer
	public void delete(CustomerModel customer) throws Exception;

	public CustomerModel selectAll(String id) throws Exception;

}
