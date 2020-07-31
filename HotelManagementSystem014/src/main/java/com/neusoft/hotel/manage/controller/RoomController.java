package com.neusoft.hotel.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.hotel.manage.model.RoomModel;
import com.neusoft.hotel.manage.service.IRoomService;
import com.neusoft.hotel.restresult.Config;
import com.neusoft.hotel.restresult.Data;
import com.neusoft.hotel.restresult.Result;
import com.neusoft.hotel.restresult.Status;

@RestController
@RequestMapping(value="/room")
public class RoomController {

	@Autowired
	private IRoomService rs=null;
		
	@PostMapping(value="/add")
	public Result<?> add(@RequestBody RoomModel room) throws Exception{
		Result<?> result=new Result<>();
		Status status = new Status();
		rs.add(room);
		status.setStatus("OK");
		status.setMessage("增加房间成功！");
		result.setStatus(status);
		return result;
		
	}

	@GetMapping(value="/modify")
	public Result<?> modify(RoomModel room) throws Exception{
		Result<?> result=new Result<>();
		Status status = new Status();
		rs.modify(room);
		status.setStatus("OK");
		status.setMessage("更新房间成功！");
		result.setStatus(status);
		return result;
		
	}
	
	@PostMapping(value="/delete")
	public Result<?> delete(@RequestBody RoomModel room) throws Exception{
		Result<?> result=new Result<>();
		Status status = new Status();
		rs.delete(room);
		status.setStatus("OK");
		status.setMessage("删除房间成功！");
		result.setStatus(status);
		return result;
		
	}
	
	@GetMapping(value="/getByRid")
	public Result<?> getByRid(@RequestParam(required=true) String rid) throws Exception{
		Result<RoomModel> result=new Result<>();
		Data<RoomModel> data=new Data<RoomModel>();
		Status status = new Status();
		data.setObject(rs.getByRid(rid));
		status.setStatus("OK");
		status.setMessage("按照房间号查找房间成功！");
		result.setData(data);
		result.setStatus(status);
		return result;
		
	}
	
	@GetMapping(value="/getByFloor")
	public Result<?> getByFloor(@RequestParam(required=true) int floor) throws Exception{
		Result<RoomModel> result=new Result<>();
		Data<RoomModel> data=new Data<RoomModel>();
		Status status = new Status();
		data.setObjectList(rs.getByFloor(floor));
		status.setStatus("OK");
		status.setMessage("按照楼层查找房间成功！");
		result.setData(data);
		result.setStatus(status);
		return result;
		
	}
	@GetMapping(value="/getByType")
	public Result<RoomModel> getByType(@RequestParam(required=true) String type) throws Exception{
		Result<RoomModel> result=new Result<>();
		Data<RoomModel> data=new Data<RoomModel>();
		Status status = new Status();
		data.setObjectList(rs.getByType(type));
		status.setStatus("OK");
		status.setMessage("按照类型查找房间成功！");
		result.setData(data);
		result.setStatus(status);
		return result;
		
	}
	
	@GetMapping(value="/geByStatus")
	public Result<?> geByStatus(@RequestParam(required=true) String status) throws Exception{
		Result<RoomModel> result=new Result<>();
		Data<RoomModel> data=new Data<RoomModel>();
		Status newstatus = new Status();
		data.setObjectList(rs.getByStatus(status));
		newstatus.setStatus("OK");
		newstatus.setMessage("按照状态查找房间成功！");
		result.setData(data);
		result.setStatus(newstatus);
		return result;
		
	}
	
	@GetMapping(value="/getByPrice")
	public Result<?> getByPrice(@RequestParam(required=false,defaultValue="0") int lowPrice,@RequestParam(required=false,defaultValue="0") int highPrice) throws Exception{
		Result<RoomModel> result=new Result<>();
		Data<RoomModel> data=new Data<RoomModel>();
		Status status = new Status();
		data.setObjectList(rs.getByPrice(lowPrice, highPrice));
		status.setStatus("OK");
		status.setMessage("按照价格查找房间成功！");
		result.setData(data);
		result.setStatus(status);
		return result;
		
	}
	
	@GetMapping(value="/getTotal")
	public Result<?> getTotal() throws Exception{
		Result<?> result=new Result<>();
		Status status = new Status();
		Config config=new Config();
		config.setCount(rs.getTotal());
		status.setStatus("OK");
		status.setMessage("房间总数查询成功！");
		result.setStatus(status);
		result.setConfig(config);
		return result;
		
	}
	
	@GetMapping(value="/getListByAllWithPage")
	public Result<?> getListByAllWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		Result<RoomModel> result=new Result<>();
		Status status = new Status();
		Config config=new Config();
		Data<RoomModel> data=new Data<RoomModel>();
		status.setStatus("OK");
		status.setMessage("分页查找房间成功！");
		data.setObjectList(rs.getListByAllWithPage(rows, page));
		int total=rs.getTotal();
		if(total%rows==0) {
			config.setPageCount(total/rows);
		}else {
			config.setPageCount(total/rows + 1);
		}
		config.setRows(rows);
		config.setPage(page);
		config.setCount(rs.getTotal());
		result.setData(data);
		result.setStatus(status);
		result.setConfig(config);
		return result;
		
	}
	
}
