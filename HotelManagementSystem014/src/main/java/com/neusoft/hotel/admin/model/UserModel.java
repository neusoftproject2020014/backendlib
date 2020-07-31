package com.neusoft.hotel.admin.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
//系统管理员用户的Model
@Alias("User")
public class UserModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int uid=0;

	private String name=null;
	
	private String passwd=null;

	public int  getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
		

}
