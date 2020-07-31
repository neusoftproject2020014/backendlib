package com.neusoft.hotel.info.service;

import java.util.Date;
import java.util.List;

import com.neusoft.hotel.info.model.ReportModel;

public interface IReportService {
	
	/**
	  * 增加report
	 * @param report
	 * @throws Exception
	 */
	public void add(ReportModel report) throws Exception;
	
	/**
	  *  修改report信息
	 * @param report
	 * @throws Exception
	 */
	public void modify(ReportModel report) throws Exception;
	
	/**
	  *  删除report
	 * @param no
	 * @throws Exception
	 */
	public void delete(int no) throws Exception;
	
	/**
	  * 通过入住时间范围来进行查找
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ReportModel> getReportByCheckInTimeRange(Date startDate, Date endDate) throws Exception;
	
	/**
	  * 通过退房时间范围来进行查找
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ReportModel> getReportByCheckOutTimeRange(Date startDate, Date endDate) throws Exception;
	
	/**
	  * 获得所有的report
	 * @return
	 */
	public List<ReportModel> listAll() throws Exception;

}
