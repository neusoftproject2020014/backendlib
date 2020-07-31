package com.neusoft.hotel.info.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.hotel.info.mapper.IReportMapper;
import com.neusoft.hotel.info.model.ReportModel;
import com.neusoft.hotel.info.service.IReportService;;


@Service
@Transactional  //环绕事务Advice的切入点
public class ReportServiceImpl implements IReportService{
	@Autowired
	private IReportMapper reportMapper=null;

	@Override
	public void add(ReportModel report) throws Exception {
		reportMapper.insert(report);
		
	}

	@Override
	public void modify(ReportModel report) throws Exception {
		reportMapper.update(report);
		
	}

	@Override
	public void delete(int no) throws Exception {
		reportMapper.delete(no);
		
	}

	@Override
	public List<ReportModel> getReportByCheckInTimeRange(Date startDate, Date endDate) throws Exception {
		return reportMapper.selectByCheckInTime(startDate, endDate);
	}

	@Override
	public List<ReportModel> getReportByCheckOutTimeRange(Date startDate, Date endDate) throws Exception{
		return reportMapper.selectByCheckOutTime(startDate, endDate);
	}

	@Override
	public List<ReportModel> listAll() throws Exception{
		return reportMapper.selectListByAll();
	}

}
