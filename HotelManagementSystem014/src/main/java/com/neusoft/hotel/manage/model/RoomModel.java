package com.neusoft.hotel.manage.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("Room")
public class RoomModel implements Serializable{
	// 房号
	private String rid = null;
	
	// 楼层
	private int floor = 0;
	
	// 房间价格
	private int price = 0;
	
	// 房间类型
	private String type = null;
	
	// 房间状态
	private String status = null;
	
	// 关联属性
	
	// 关联的房客
	private List<CustomerModel> customers = null;

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CustomerModel> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerModel> customers) {
		this.customers = customers;
	}

}
