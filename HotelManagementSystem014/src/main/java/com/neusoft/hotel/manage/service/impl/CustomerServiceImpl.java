package com.neusoft.hotel.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neusoft.hotel.manage.mapper.ICustomerMapper;
import com.neusoft.hotel.manage.model.CustomerModel;
import com.neusoft.hotel.manage.service.ICustomerService;

@Service
@Transactional  //环绕事务Advice的切入点
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerMapper customerMapper=null;

	@Override
	public void add(CustomerModel customer) throws Exception {
		customerMapper.insert(customer);
		
	}

	@Override
	public void modify(CustomerModel customer) throws Exception {
		customerMapper.update(customer);
		
	}

	@Override
	public void delete(String id) throws Exception {
		customerMapper.delete(id);
	}

	@Override
	public CustomerModel getInfo(String id) throws Exception {
		return customerMapper.selectById(id);
	}

	@Override
	public CustomerModel getInfoWithRoomAndProduct(String id) throws Exception {
		return customerMapper.selectByIdWithRoomAndProduct(id);
	}
	
	@Override
	public boolean verifyCustomerExist(String id) throws Exception {
		return !(customerMapper.selectById(id)==null);
	}
	
	@Override
	public List<CustomerModel> listByAllWithPages(int page, int rows) throws Exception {
	
		return customerMapper.selectListByAllWithPage((page-1)*rows, rows);
	}
	
	@Override
	public int getTotal() throws Exception {
		return customerMapper.selectTotal();
	}
	
	@Override
	public int getPageCountByAll(int rows) throws Exception {
		int count=this.getTotal();
		int pageCount=0;
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		
		return pageCount;
	}

	
}
