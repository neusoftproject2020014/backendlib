package com.neusoft.hotel.info.model;

import org.apache.ibatis.type.Alias;

@Alias("BasicInfo")
public class BasicInfoModel {
	// 酒店名称
	private String name;
	
	// 酒店位置
	private String location;
	
	// 酒店联系方式
	private String phone;
	
	// 酒店房间数量
	private int noRoom;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getNoRoom() {
		return noRoom;
	}

	public void setNoRoom(int noRoom) {
		this.noRoom = noRoom;
	} 
	

}
