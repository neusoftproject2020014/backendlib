package com.neusoft.hotel.restresult;

import java.util.List;


//统一的REST API 的结果类

public class Result<T> {

	private T result=null;//接收返回的单个Model对象
	private List<T> list=null;//接收返回的多个Model对象
	private String stringResult=null;
	private int total=0;//房间总数
	private String status=null;//返回执行的状态，OK正常，ERROR异常
	private String message=null;//返回执行的消息
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public String getStringResult() {
		return stringResult;
	}
	public void setStringResult(String stringResult) {
		this.stringResult = stringResult;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
