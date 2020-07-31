package com.neusoft.hotel.admin.service;

import com.neusoft.hotel.admin.model.UserModel;

//管理员业务层接口
public interface IUserService {
	//取得指定的用户对象
	public UserModel getByName(String name) throws Exception;
	
	//验证用户合法性，通过id和密码与数据表相符即可
	public boolean validate(String name,String password) throws Exception;
	
	//修改自己的密码
	public void changePassword(String name,String password) throws Exception;
	
	// 注销账号
	public void destory(String name) throws Exception;
	
	// 注册账户
	public void register(String name, String password) throws Exception;
	
}
