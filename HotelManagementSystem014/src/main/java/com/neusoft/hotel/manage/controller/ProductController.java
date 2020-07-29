package com.neusoft.hotel.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.hotel.manage.model.CustomerModel;
import com.neusoft.hotel.manage.model.ProductModel;
import com.neusoft.hotel.manage.service.ICustomerService;
import com.neusoft.hotel.manage.service.IProductService;
import com.neusoft.hotel.restresult.Result;


@RestController
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	private IProductService ps=null;
		
	@PostMapping(value="/add")
	public Result<String> add(ProductModel pm) throws Exception{
		ps.add(pm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加商品成功!");
		return result;
		
	}
	@PostMapping(value="/modify")
	public Result<String> modify(ProductModel pm) throws Exception{
		ps.modify(pm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改商品成功!");
		return result;
	}
	@PostMapping(value="/delete")
	public Result<String> delete(ProductModel pm) throws Exception{
		ps.delete(pm);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除商品成功!");
		return result;
	}
	//取得产品列表，分页模式
	@GetMapping(value="/list/all/page")
	public Result<ProductModel> getListByAllWitgPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<ProductModel> result=new Result<ProductModel>();
		result.setCount(ps.getCountByAll());
		result.setPageCount(ps.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(ps.getListByAllWithPage(rows, page));
		
		result.setStatus("OK");
		result.setMessage("取得商品列表分页方式成功!");
		return result;
	}
	@GetMapping(value="/get")
	public Result<ProductModel> getByPid(@RequestParam(required=true) int pid) throws Exception{
		Result<ProductModel> result=new Result<ProductModel>();
		result.setResult(ps.getByPid(pid));
		
		result.setStatus("OK");
		result.setMessage("通过id取得指定商品对象成功!");
		return result;
	}	
	@GetMapping(value="/get")
	public Result<ProductModel> getByName(@RequestParam(required=true) String name) throws Exception{
		Result<ProductModel> result=new Result<ProductModel>();
		result.setResult(ps.getByName(name));
		
		result.setStatus("OK");
		result.setMessage("通过名称取得指定商品对象成功!");
		return result;
	}	
	@GetMapping(value="/get")
	public Result<ProductModel> getByPid(@RequestParam(required=true) String type) throws Exception{
		Result<ProductModel> result=new Result<ProductModel>();
		result.setResult(ps.getByType(type));
		
		result.setStatus("OK");
		result.setMessage("通过类型取得指定商品对象成功!");
		return result;
	}	
}
