package com.neusoft.hotel.manage.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

class Service {
	// 消费商品的customer
	private CustomerModel customer = null;
	
	// 消费个数
	private int count = 0;
	
}

@Alias("Product")
public class ProductModel implements Serializable{
	// 商品ID
	private String pid = null;
	
	// 商品名称
	private String name = null;
	
	// 商品价格
	private int price = 0;
	
	// 商品类型
	private String type = null;
	
	// 商品库存
	private int stock = 0;
	
	// 关联属性
	
	// 消费的房客
	private List<Service> services = null;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
}
