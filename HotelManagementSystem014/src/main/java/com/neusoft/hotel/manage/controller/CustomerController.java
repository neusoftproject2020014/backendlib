package com.neusoft.hotel.manage.controller;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.hotel.manage.model.CustomerModel;
import com.neusoft.hotel.manage.service.ICustomerService;
import com.neusoft.hotel.restresult.Config;
import com.neusoft.hotel.restresult.Data;
import com.neusoft.hotel.restresult.Result;
import com.neusoft.hotel.restresult.Status;

@RestController
@RequestMapping(value="/customer")
@CrossOrigin(origins = {"*", "null"})
public class CustomerController {
	@Autowired
	private ICustomerService cs=null;
		
	/**
	  *  为顾客办理入住
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value="/checkin")
	public Result<?> add(@RequestBody CustomerModel customer) throws Exception{

		// 首先验证要增加的顾客是否存在
		Result<?> result = new Result<>();
		Status status = new Status();
		if(!cs.verifyCustomerExist(customer.getId())) {
			customer.setCheckintime(new Date());
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
	@PostMapping(value="/modify")
	public Result<?> modify(@RequestBody CustomerModel customer) throws Exception{
		Result<?> result = new Result<>();
		Status status = new Status();
		if(cs.verifyCustomerExist(customer.getId())) {
			cs.modify(customer);
			status.setStatus("OK");
			status.setMessage("修改顾客信息成功");
		}
		else {
			status.setStatus("ERROR");
			status.setMessage("顾客不存在, 无法修改");
		}
		result.setStatus(status);
		return result;
	}
	/**
	  * 为顾客进行退房处理
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value="/checkout")
	public Result<?> checkout(@RequestParam(required=true) String id) throws Exception{
		Result<?> result = new Result<>();
		Status status = new Status();
		if(cs.verifyCustomerExist(id)) {
			cs.delete(id);
			status.setStatus("OK");
			status.setMessage("办理退房成功");
		}
		else {
			status.setStatus("ERROR");
			status.setMessage("顾客不存在, 无法办理退房");
		}
		result.setStatus(status);
		return result;
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
	public Result<CustomerModel> list(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<CustomerModel> result = new Result<CustomerModel>();
		Status status = new Status();
		Data<CustomerModel> data = new Data<CustomerModel>();
		Config config = new Config();
		
		// 设置data
		data.setObjectList(cs.listByAllWithPages(page, rows));
		
		// 设置status
		status.setStatus("OK");
		
		// 设置配置信息
		config.setCount(cs.getTotal());
		
		result.setData(data);
		result.setStatus(status);
		result.setConfig(config);
		
		return result;
		
	}
	
	/**
	  *  查看一个顾客的详细信息，包括房间以及消费
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value="/view")
	public Result<CustomerModel> view(String id) throws Exception{
		Result<CustomerModel> result = new Result<>();
		Status status = new Status();
		Data<CustomerModel> data = new Data<>();
		
		if(cs.verifyCustomerExist(id)) {
			data.setObject(cs.getInfoWithRoomAndProduct(id));
			status.setStatus("OK");
			status.setMessage("获得信息成功");
		}
		else {
			status.setStatus("ERROR");
			status.setMessage("顾客不存在, 无法办理退房");
		}
		result.setData(data);
		result.setStatus(status);
		return result;
	
	}
	
	/**
	  *  通过 id来获得一个顾客
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value="/get")
	public Result<CustomerModel> get(@RequestParam(required=true) String id) throws Exception{
		Result<CustomerModel> result = new Result<>();
		Status status = new Status();
		Data<CustomerModel> data = new Data<>();
		if(cs.verifyCustomerExist(id)) {
			data.setObject(cs.getInfo(id));
			status.setStatus("OK");
			status.setMessage("获得信息成功");
		}
		else {
			status.setStatus("ERROR");
			status.setMessage("顾客不存在, 无法办理退房");
		}
		result.setData(data);
		result.setStatus(status);
		return result;

	}
	
	
}
