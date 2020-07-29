package com.neusoft.hotel.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.hotel.manage.model.RoomModel;
import com.neusoft.hotel.manage.service.IRoomService;
import com.neusoft.hotel.restresult.Result;

@RestController
@RequestMapping(value="/room")
public class RoomController {

	@Autowired
	private IRoomService rs=null;
		
	@GetMapping(value="/add")
	public Result<String> add(RoomModel room) throws Exception{
		rs.add(room);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("增加房间成功！");
		return result;
		
	}

	@PostMapping(value="/modify")
	public Result<String> modify(RoomModel room) throws Exception{
		rs.modify(room);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("更新房间成功！");
		return result;
		
	}
	
	@PostMapping(value="/delete")
	public Result<String> delete(RoomModel room) throws Exception{
		rs.delete(room);
		Result<String> result=new Result<String>();
		result.setStatus("OK");
		result.setMessage("删除房间成功！");
		return result;
		
	}
	
	@GetMapping(value="/get")
	public Result<RoomModel> getByRid(@RequestParam(required=true) String rid) throws Exception{
		Result<RoomModel> result=new Result<RoomModel>();
		result.setResult(rs.getByRid(rid));
		result.setStatus("OK");
		result.setMessage("按照房间号查找房间成功！");
		return result;
		
	}
	
	@GetMapping(value="/get")
	public Result<RoomModel> getByfloor(@RequestParam(required=true) int floor) throws Exception{
		Result<RoomModel> result=new Result<RoomModel>();
		result.setList(rs.getByFloor(floor));
		result.setStatus("OK");
		result.setMessage("按照楼层查找房间成功！");
		return result;
		
	}
	@GetMapping(value="/get")
	public Result<RoomModel> getByType(@RequestParam(required=true) String type) throws Exception{
		Result<RoomModel> result=new Result<RoomModel>();
		result.setList(rs.getByType(type));
		result.setStatus("OK");
		result.setMessage("按照类型查找房间成功！");
		return result;
		
	}
	
	@GetMapping(value="/get")
	public Result<RoomModel> geByStatus(@RequestParam(required=true) String status) throws Exception{
		Result<RoomModel> result=new Result<RoomModel>();
		result.setList(rs.getByStatus(status));
		result.setStatus("OK");
		result.setMessage("按照状态查找房间成功！");
		return result;
		
	}
	
	@GetMapping(value="/get")
	public Result<RoomModel> getByPrice(@RequestParam(required=false) int lowPrice,@RequestParam(required=false) int highPrice) throws Exception{
		Result<RoomModel> result=new Result<RoomModel>();
		result.setList(rs.getByPrice(lowPrice, highPrice));
		result.setStatus("OK");
		result.setMessage("按照价格查找房间成功！");
		return result;
		
	}
	
	@GetMapping(value="/get")
	public Result<RoomModel> getTotal() throws Exception{
		Result<RoomModel> result=new Result<RoomModel>();
		result.setTotal(rs.getTotal());
		result.setStatus("OK");
		result.setMessage("房间总数查询成功！");
		return result;
		
	}
	
	@GetMapping(value="/get")
	public Result<RoomModel> getListByAllWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<RoomModel> result=new Result<RoomModel>();
		result.setList(rs.getListByAllWithPage(rows, page));;
		result.setStatus("OK");
		result.setMessage("分页查找房间成功！");
		return result;
		
	}
	
}
