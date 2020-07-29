package com.neusoft.hotel.restresult;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Data<T> {
	// 单个对象
	private T object=null;  
	
	// 一个对象列表
	private List<T> objectList=null; 
	
	// 一个整数值
	private int intVal=0;
	
	// 一个字符串值
	private String stringVal=null;

	// 一个double值
	private double doubleVal=0;
	
	// 一个日期值
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateVal=null;
	
	// 一个时间戳值
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date timeVal=null;

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public List<T> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<T> objectList) {
		this.objectList = objectList;
	}

	public int getIntVal() {
		return intVal;
	}

	public void setIntVal(int intVal) {
		this.intVal = intVal;
	}

	public String getStringVal() {
		return stringVal;
	}

	public void setStringVal(String stringVal) {
		this.stringVal = stringVal;
	}

	public double getDoubleVal() {
		return doubleVal;
	}

	public void setDoubleVal(double doubleVal) {
		this.doubleVal = doubleVal;
	}

	public Date getDateVal() {
		return dateVal;
	}

	public void setDateVal(Date dateVal) {
		this.dateVal = dateVal;
	}

	public Date getTimeVal() {
		return timeVal;
	}

	public void setTimeVal(Date timeVal) {
		this.timeVal = timeVal;
	}
	
}
