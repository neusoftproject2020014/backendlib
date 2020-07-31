package com.neusoft.hotel.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neusoft.hotel.manage.mapper.IProductMapper;
import com.neusoft.hotel.manage.model.ProductModel;
import com.neusoft.hotel.manage.service.IProductService;

@Service
@Transactional  //环绕事务Advice的切入点
public class ProductServiceImpl implements IProductService{
	@Autowired
	private IProductMapper productMapper=null;
	@Override
	public String add(ProductModel pm) throws Exception {
		productMapper.insert(pm);
		return pm.getPid();
	}

	@Override
	public void modify(ProductModel pm) throws Exception {
		productMapper.update(pm);
	}

	@Override
	public void delete(int pid) throws Exception {
		productMapper.delete(pid);
	}

	@Override
	public List<ProductModel> getListByAllWithPage(int rows, int page) throws Exception {
		
		return productMapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		
		int count=this.getCountByAll();
		int pageCount=0;
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		
		return pageCount;
	}

	@Override
	public ProductModel getByPid(int pid) throws Exception {
		
		return productMapper.selectByPid(pid);
	}
	
	@Override
	public List<ProductModel> getByName(String name) throws Exception {
		
		return productMapper.selectByName(name);
	}

	@Override
	public List<ProductModel> getByType(String type) throws Exception {
		
		return productMapper.selectByType(type);
	}
	
	@Override
	public int getCountByAll() throws Exception {
		return 0;
	}

	@Override
	public boolean verifyProductExist(String pid) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
