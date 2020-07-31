package com.neusoft.hotel.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.neusoft.hotel.manage.model.ProductModel;

@Mapper
public interface IProductMapper {
	
	/**
	  *   增删改操作
	 */
	
	// 增加product
	public void insert(ProductModel customer) throws Exception;
	
	// 更新product
	public void update(ProductModel customer) throws Exception;
	
	// 删除product
	public void delete(ProductModel customer) throws Exception;
	
	/**
	  *   通过属性值进行查找 
	 */
	
	// 通过商品id选择商品
	public ProductModel selectByPid(int pid) throws Exception;
	
	// 通过name来查找商品
	public List<ProductModel> selectByName(String name) throws Exception;
	
	// 通过type来查找商品
	public List<ProductModel> selectByType(String type) throws Exception;
	
	// 查找小于某库存的商品信息
	public List<ProductModel> selectByStockWithUpperBound(int upperBound) throws Exception;
	
	/**
	  *   查询整个表
	 */
	
	// 查询商品总数
	public List<ProductModel> selectByAll();
	
	//分页查找所有的商品
	public List<ProductModel> selectListByAllWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;
	
	
 
}
