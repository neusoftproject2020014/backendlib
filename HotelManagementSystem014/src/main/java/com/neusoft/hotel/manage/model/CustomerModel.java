package com.neusoft.hotel.manage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

class Consume{
	// 消费的商品
	private ProductModel product= null;
	
	// 消费的个数
	private int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	} 
}


@Alias("Customer")
public class CustomerModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8308465260069300669L;

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
	
	public int calProductCost() {
		int cost = 0;
		for (Consume c : consumes) {
			cost += c.getProduct().getPrice() * c.getCount();
		}
		return cost;
		
	}
	
}
