package com.neusoft.hotel.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.hotel.manage.model.CustomerModel;
import com.neusoft.hotel.manage.model.ProductModel;
import com.neusoft.hotel.manage.service.ICustomerService;
import com.neusoft.hotel.manage.service.IProductService;
import com.neusoft.hotel.restresult.Config;
import com.neusoft.hotel.restresult.Data;
import com.neusoft.hotel.restresult.Result;
import com.neusoft.hotel.restresult.Status;


@RestController
@RequestMapping(value="/product")
@CrossOrigin(origins = {"*", "null"})
public class ProductController {
	
	@Autowired
	private IProductService ps=null;
		
	@PostMapping(value="/add")
	public Result<?> add(@RequestBody ProductModel pm) throws Exception{
		// 首先验证要增加的商品是否存在
		Result<?> result = new Result<>();
		Status status = new Status();
		if(ps.verifyProductExist(pm.getPid())) {
			ps.add(pm);
			status.setStatus("OK");
			status.setMessage("增加商品成功");
		}
		else {
			status.setStatus("ERROR");
			status.setMessage("商品已存在, 无法增加");
		}	
		result.setStatus(status);
		return result;
		
	}
	@PostMapping(value="/modify")
	public Result<?> modify(@RequestBody ProductModel pm) throws Exception{
		Result<?> result = new Result<>();
		Status status = new Status();
		ps.modify(pm);
		status.setStatus("OK");
		status.setMessage("修改商品成功!");
		result.setStatus(status);
		return result;
	}
	@GetMapping(value="/delete")
	public Result<String> delete(@RequestParam(required=true) int pid) throws Exception{
		Status status = new Status();
		ps.delete(pid);
		Result<String> result=new Result<String>();
		status.setStatus("OK");
		status.setMessage("删除商品成功!");
		result.setStatus(status);
		return result;
	}
	//取得产品列表，分页模式
	@GetMapping(value="/list")
	public Result<?> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<ProductModel> result = new Result<>();
		Status status = new Status();
		Config config= new Config();
		Data<ProductModel> data = new Data<ProductModel>();
		config.setCount(ps.getCountByAll());
		config.setPageCount(ps.getPageCountByAll(rows));
		config.setRows(rows);
		config.setPage(page);
		data.setObjectList(ps.getListByAllWithPage(rows, page));
		status.setStatus("OK");
		status.setMessage("取得商品列表分页方式成功!");
		result.setConfig(config);
		result.setData(data);
		result.setStatus(status);
		return result;
	}
	@GetMapping(value="/getBypid")
	public Result<?> getByPid(@RequestParam(required=true) int pid) throws Exception{
		Result<ProductModel> result = new Result<>();
		Data<ProductModel> data = new Data<ProductModel>();
		Status status = new Status();
		data.setObject(ps.getByPid(pid));
		status.setStatus("OK");
		status.setMessage("通过id取得指定商品对象成功!");
		result.setData(data);
		result.setStatus(status);
		return result;
	}	
	@GetMapping(value="/getByname")
	public Result<?> getByName(@RequestParam(required=true) String name) throws Exception{
		Result<ProductModel> result = new Result<>();
		Data<ProductModel> data = new Data<ProductModel>();
		Status status = new Status();
		data.setObjectList(ps.getByName(name));
		status.setStatus("OK");
		status.setMessage("通过名称取得指定商品对象成功!");
		result.setData(data);
		result.setStatus(status);
		return result;
	}	
	@GetMapping(value="/getBytype")
	public Result<?> getByType(@RequestParam(required=true) String type) throws Exception{
		Result<ProductModel> result = new Result<>();
		Data<ProductModel> data = new Data<ProductModel>();
		Status status = new Status();
		data.setObjectList(ps.getByType(type));
		status.setStatus("OK");
		status.setMessage("通过类型取得指定商品对象成功!");
		result.setData(data);
		result.setStatus(status);
		return result;
	}	
}
