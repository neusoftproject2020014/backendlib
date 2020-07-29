package com.neusoft.hotel.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.hotel.manage.mapper.ICustomerMapper;
import com.neusoft.hotel.manage.service.ICustomerService;

@Service
@Transactional  //环绕事务Advice的切入点
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerMapper customerMapper=null;
}
