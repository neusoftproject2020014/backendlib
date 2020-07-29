package com.neusoft.hotel.restresult;
//统一的REST API的结果类
/**
 * Result
 * 		status
 * 			status(ok, error)
 * 			message
 * 		data
 * 			object
 * 			object
 * 		config
 * 			page
 * 			pagecount
 * @author dell
 *
 * @param <T>
 */
public class Result<T> {
	// 状态信息
	private Status status;
	
	// 有效数据
	private Data<T> data;
	
	//相应的配置
	private Config config;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Data<T> getData() {
		return data;
	}

	public void setData(Data<T> data) {
		this.data = data;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}
}
	
	
	
	

