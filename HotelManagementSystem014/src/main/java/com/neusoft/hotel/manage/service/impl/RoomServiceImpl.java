package com.neusoft.hotel.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neusoft.hotel.manage.mapper.IRoomMapper;
import com.neusoft.hotel.manage.model.RoomModel;
import com.neusoft.hotel.manage.service.IRoomService;


@Service
@Transactional  //环绕事务Advice的切入点
public class RoomServiceImpl implements IRoomService{
	
	@Autowired
	private IRoomMapper roomMapper=null;

	@Override
	public void add(RoomModel room) throws Exception {
		roomMapper.insert(room);
	}

	@Override
	public void modify(RoomModel room) throws Exception {
		roomMapper.update(room);
	}

	@Override
	public void delete(RoomModel room) throws Exception {
		roomMapper.delete(room);
		
	}
	
	@Override
	public RoomModel getByRid(String rid) throws Exception {
		return roomMapper.selectByRid(rid);
	}

	@Override
	public List<RoomModel> getByFloor(int rid) throws Exception {
		return roomMapper.selectByFloor(rid);
	}

	@Override
	public List<RoomModel> getByType(String rid) throws Exception {
		return roomMapper.selectByType(rid);
	}

	@Override
	public List<RoomModel> getByStatus(String rid) throws Exception {
		return roomMapper.selectByStatus(rid);
	}

	@Override
	public List<RoomModel> getByPrice(int lowPrice, int highPrice) throws Exception {
		return roomMapper.selectByPrice(lowPrice, highPrice);
	}

	@Override
	public int getTotal() throws Exception {
		return roomMapper.selectTotal();
	}

	@Override
	public List<RoomModel> getListByAllWithPage(int rows, int page) throws Exception {
		return roomMapper.selectListByAllWithPage(rows*(page - 1), rows);
	}

	
}