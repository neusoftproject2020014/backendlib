package com.neusoft.hotel.manage.service;

import java.util.List;

import com.neusoft.hotel.manage.model.ProductModel;

//商品的业务接口
public interface IProductService {

	//增加商品
	public String add(ProductModel pm) throws Exception;
	//修改商品
	public void modify(ProductModel pm) throws Exception;
	//删除商品
	public void delete(ProductModel pm) throws Exception;
	//取得所有商品列表
	int getCountByAll() throws Exception;
	//取得所有商品列表,分页模式
	public List<ProductModel> getListByAllWithPage(int rows, int page) throws Exception;
	//取得商品的显示页数
	public int getPageCountByAll(int rows) throws Exception;
	//根据商品的id取得指定的商品部门对象
	ProductModel getByPid(int pid) throws Exception;
	//根据商品的名称取得指定的商品对象
	List<ProductModel> getByName(String name) throws Exception;
	//根据商品的类型取得指定的商品对象
	List<ProductModel> getByType(String type) throws Exception;


}
