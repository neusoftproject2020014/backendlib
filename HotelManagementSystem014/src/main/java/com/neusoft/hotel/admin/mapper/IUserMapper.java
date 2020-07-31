package com.neusoft.hotel.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.hotel.admin.model.UserModel;

//管理员DAO层接口
@Mapper
public interface IUserMapper {
	
	public void insert(UserModel um) throws Exception;
	
	public void delete(int uid) throws Exception;
	
	
	public void update(UserModel um) throws Exception;
	
	//通过ID取得管理员对象
	public UserModel selectByName(String name) throws Exception;

}
