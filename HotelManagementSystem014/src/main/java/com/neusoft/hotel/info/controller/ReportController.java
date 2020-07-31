package com.neusoft.hotel.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.hotel.info.model.ReportModel;
import com.neusoft.hotel.info.service.IReportService;
import com.neusoft.hotel.restresult.Data;
import com.neusoft.hotel.restresult.Result;
import com.neusoft.hotel.restresult.Status;


@RestController
@RequestMapping(value="/report")
@CrossOrigin(origins = {"*", "null"})
public class ReportController {
	@Autowired
	private IReportService rs=null;
	
	@GetMapping(value="/checkinform")
	public Result<ReportModel> findCheckInFormWithRange(@RequestParam(required=false) String startDateString, 
			@RequestParam(required=false) String endDateString) throws Exception{
		Result<ReportModel> result = new Result<>();
		Status status = new Status();
		Data<ReportModel> data = new Data<>();
		data.setObjectList(rs.listAll());
		status.setStatus("OK");
		status.setMessage("查询成功成功");
		result.setData(data);
		result.setStatus(status);
		return result;
	}
	
	@GetMapping(value="/checkoutform")
	public Result<ReportModel> findCheckOutFormWithRange(@RequestParam(required=false) String startDateString, 
			@RequestParam(required=false) String endDateString) throws Exception{
		Result<ReportModel> result = new Result<>();
		Status status = new Status();
		Data<ReportModel> data = new Data<>();
		data.setObjectList(rs.listAll());
		status.setStatus("OK");
		status.setMessage("查询成功成功");
		result.setData(data);
		result.setStatus(status);
		return result;
	}
	
	@GetMapping(value="/financialform")
	public Result<ReportModel> financialForm(@RequestParam(required=false) String startDateString, 
			@RequestParam(required=false) String endDateString) throws Exception{
		Result<ReportModel> result = new Result<>();
		Status status = new Status();
		Data<ReportModel> data = new Data<>();
		data.setObjectList(rs.listAll());
		status.setStatus("OK");
		status.setMessage("查询成功成功");
		result.setData(data);
		result.setStatus(status);
		return result;
	}

}
