package com.neusoft.hotel.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.hotel.admin.mapper.IUserMapper;
import com.neusoft.hotel.admin.model.UserModel;
import com.neusoft.hotel.admin.service.IUserService;

@Service
@Transactional  //环绕事务Advice的切入点
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserMapper userMapper=null;

	@Override
	public UserModel getByName(String name) throws Exception {
		return userMapper.selectByName(name);
	}

	@Override
	public boolean validate(String name, String password) throws Exception {
		UserModel user = userMapper.selectByName(name);
		if (user!=null && user.getPasswd().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public void changePassword(String name, String password) throws Exception {
		UserModel user = userMapper.selectByName(name);
		user.setPasswd(password);
		userMapper.update(user);
		
	}

	@Override
	public void destory(String name) throws Exception {
		UserModel user = userMapper.selectByName(name);
		userMapper.delete(user.getUid());
		
	}

	@Override
	public void register(String name, String password) throws Exception {
		UserModel user = new UserModel();
		user.setName(name);
		user.setPasswd(password);
		userMapper.insert(user);
	}

	
	
	

	

}
