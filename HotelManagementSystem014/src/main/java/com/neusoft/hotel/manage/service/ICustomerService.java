package com.neusoft.hotel.manage.service;

import java.util.List;

import com.neusoft.hotel.manage.model.CustomerModel;

public interface ICustomerService {
	
	/**
	  * 增加顾客
	 * @param customer
	 * @throws Exception
	 */
	public void add(CustomerModel customer) throws Exception;
	
	/**
	  *  修改顾客信息
	 * @param customer
	 * @throws Exception
	 */
	public void modify(CustomerModel customer) throws Exception;
	
	/**
	  *  删除顾客
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	
	/**
	  * 通过id来获得顾客信息，不包括房间和商品的详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public CustomerModel getInfo(String id) throws Exception;
	
	/**
	  * 获得一个顾客的详细信息，包括房间以及商品信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public CustomerModel getInfoWithRoomAndProduct(String id) throws Exception;
	
	/**
          *   验证指定id的用户是否存在，存在返回true否则返回false，该方法主要用于判断
          *  要添加...否存在，如不存在时添加会抛出异常，该方法后面可以用异常来进行替换
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCustomerExist(String id) throws Exception; 
	
	/**
	  *  分页获得顾客信息，不包括房间和所使用商品信息,从1页开始
	 *  
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public List<CustomerModel> listByAllWithPages(int page, int rows) throws Exception;
	
	/**
	  * 获得总的顾客数
	 * @return
	 * @throws Exception
	 */
	public int getTotal() throws Exception;
	
	/**
	  * 获得列举所有顾客时需要的总页数
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public int getPageCountByAll(int rows) throws Exception;

}
