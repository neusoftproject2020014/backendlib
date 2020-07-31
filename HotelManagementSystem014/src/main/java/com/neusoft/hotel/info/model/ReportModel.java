package com.neusoft.hotel.info.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("Report")
public class ReportModel {
	// report编号
	private int no;
	
	// 顾客姓名
	private String name;
	
	// 顾客id
	private String id;
	
	// 顾客入住时间
	private Date checkintime;
	
	// 顾客退房时间
	private Date checkouttime;
	
	// 顾客住宿消费
	private int roomCost;
	
	// 顾客商品消费
	private int productCost;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCheckintime() {
		return checkintime;
	}

	public void setCheckintime(Date checkintime) {
		this.checkintime = checkintime;
	}

	public Date getCheckouttime() {
		return checkouttime;
	}

	public void setCheckouttime(Date checkouttime) {
		this.checkouttime = checkouttime;
	}

	public int getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(int roomCost) {
		this.roomCost = roomCost;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}
	
	
	
}
