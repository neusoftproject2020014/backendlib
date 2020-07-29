package com.neusoft.hotel.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.hotel.manage.model.CustomerModel;
import com.neusoft.hotel.manage.service.ICustomerService;
import com.neusoft.hotel.restresult.Result;
import com.neusoft.hotel.restresult.Status;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	@Autowired
	private ICustomerService cs=null;
		
	/**
	  *  为顾客办理入住
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value="/checkin")
	public Result<?> add(CustomerModel customer) throws Exception{
		// 首先验证要增加的顾客是否存在
		Result<?> result = new Result<>();
		Status status = new Status();
		if(!cs.verifyCustomerExist(customer.getId())) {
			cs.add(customer);
			status.setStatus("OK");
			status.setMessage("办理入住成功");
		}
		else {
			status.setStatus("ERROR");
			status.setMessage("顾客已存在, 无法办理");
		}	
		result.setStatus(status);
		return result;
	}
	
	/**
	  *  修改用户的信息
	 * @param id
	 * @throws Exception
	 */
	@GetMapping(value="/modify")
	public String modify(CustomerModel customer) throws Exception{
		if(cs.verifyCustomerExist(customer.getId())) {
			cs.modify(customer);
			return "ok";
		}
		else {
			return "顾客不存在";
		}
	}
	/**
	  * 为顾客进行退房处理
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value="/checkout")
	public String checkout(CustomerModel customer) throws Exception{
		if(cs.verifyCustomerExist(customer.getId())) {
			cs.delete(customer);
			return "ok";
		}
		else {
			return "顾客不存在";
		}
	}

	/**
	  *  列出当前所有的顾客信息,应该是顾客主页显示信息
	 *  
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value="/list")
	public List<CustomerModel> list(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		return cs.listByAllWithPages(page, rows);
		
	}
	
	/**
	  *  查看一个顾客的详细信息，包括房间以及消费
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value="view")
	public CustomerModel view() throws Exception{
		return null;
	}
	
	
}
