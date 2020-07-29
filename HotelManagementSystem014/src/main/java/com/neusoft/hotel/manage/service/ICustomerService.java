package com.neusoft.hotel.manage.service;

import com.neusoft.hotel.manage.model.CustomerModel;

public interface ICustomerService {
	
	public void add(CustomerModel customer) throws Exception;
	
	public CustomerModel selectAll(String id) throws Exception;

}
