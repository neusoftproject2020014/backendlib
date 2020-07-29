package com.neusoft.hotel.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neusoft.hotel.manage.mapper.IProductMapper;
import com.neusoft.hotel.manage.service.IProductService;


@Service
@Transactional  //环绕事务Advice的切入点
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductMapper productMapper=null;
}
