package com.neusoft.hotel.manage.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

class Consume{
	private ProductModel product= null;
	private int count = 0; 
}


@Alias("Customer")
public class CustomerModel implements Serializable{
	// 身份证号
	private String id = null;
	
	// 姓名
	private String name = null;
	
	// 性别
	private String gender = null;
	
	// 年龄
	private int age = 0;
	
	// 电话号码
	private String phone = null;
	
	// 房间号
	private String rid = null;
	
	// 入住时间
	private Date checkintime = null;
	
	// 退房时间
	private Date checkouttime = null;
	
	// 关联属性
	
	// 关联的客房
	private RoomModel room = null;
	
	// 关联的商品（消费的商品）
	private List<Consume> consumes = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
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

	public RoomModel getRoom() {
		return room;
	}

	public void setRoom(RoomModel room) {
		this.room = room;
	}

	public List<Consume> getConsumes() {
		return consumes;
	}

	public void setConsumes(List<Consume> consumes) {
		this.consumes = consumes;
	}
	
	
}
