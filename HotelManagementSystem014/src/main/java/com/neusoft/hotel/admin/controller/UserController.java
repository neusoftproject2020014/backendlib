package com.neusoft.hotel.admin.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.hotel.admin.model.UserModel;
import com.neusoft.hotel.admin.service.IUserService;
import com.neusoft.hotel.restresult.Result;
import com.neusoft.hotel.restresult.Status;

@RestController
@RequestMapping(value="/user")
@CrossOrigin(origins = {"*", "null"})
public class UserController {
	@Autowired
	private IUserService us=null;
	
	
	@PostMapping(value="/login")
	public Result<?> login(@RequestBody UserModel user, HttpSession session) throws Exception{

		// 首先验证要增加的顾客是否存在
		Result<?> result = new Result<>();
		Status status = new Status();
		if(us.validate(user.getName(), user.getPasswd())){
			user = us.getByName(user.getName());
			session.setAttribute("user", user);
			status.setStatus("OK");
			status.setMessage("登陆成功");
		}
		else {
			status.setStatus("ERROR");
			status.setMessage("密码或者账号错误");
		}
		result.setStatus(status);
		return result;
	}
	
	@PostMapping(value="/register")
	public Result<?> register(@RequestBody UserModel user) throws Exception{

		// 首先验证要增加的顾客是否存在
		Result<?> result = new Result<>();
		Status status = new Status();
		if(us.getByName(user.getName()) == null){
			us.register(user.getName(), user.getPasswd());
			status.setStatus("OK");
			status.setMessage("注册成功");
		}
		else {
			status.setStatus("ERROR");
			status.setMessage("用户名已存在");
		}
		result.setStatus(status);
		return result;
	}
	@PostMapping(value="/destory")
	public Result<?> destory(@RequestBody UserModel user) throws Exception{

		// 首先验证要增加的顾客是否存在
		Result<?> result = new Result<>();
		Status status = new Status();
		if (us.getByName(user.getName()) != null) {
			us.destory(user.getName());
			status.setStatus("OK");
			status.setMessage("注销成功");
		}
		else {
			status.setStatus("ERROR");
			status.setMessage("注销失败");
		}
		result.setStatus(status);
		return result;
	}

}
