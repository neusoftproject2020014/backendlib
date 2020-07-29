package com.neusoft.hotel.restresult;

public class Status {
	// 服务器返回的状态
	// OK， ERROR， WARN
	private String status = null;
	
	//服务器返回的相关提示信息
	private String message = null;

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

}
