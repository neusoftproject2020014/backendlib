package com.neusoft.hotel.info.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.neusoft.hotel.info.model.ReportModel;

@Mapper
public interface IReportMapper {
	/**
	 * 插入report
	 * @param report
	 * @throws Exception
	 */
	public void insert(ReportModel report) throws Exception;
	
	/**
	 *  更新
	 * @param report
	 * @throws Exception
	 */
	public void update(ReportModel report) throws Exception;
	
	/**
	 * delete
	 * @param no
	 * @throws Exception
	 */
	public void delete(int no) throws Exception;
	
	public ReportModel selectByNo(int no) throws Exception;
	
	/**
	 * 查找特定时间段的入住report
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public List<ReportModel> selectByCheckInTime(@Param("startDate") Date startDate, @Param("endDate") Date endDate) throws Exception;
	
	/**
	 * 查找特定时间段的退房report
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public List<ReportModel> selectByCheckOutTime(@Param("startDate") Date startDate, @Param("endDate") Date endDate) throws Exception;
	
	/**
	  * 查询report总数
	 * @return
	 * @throws Exception
	 */
	public int selectTotal() throws Exception;
		
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ReportModel> selectListByAll() throws Exception;
		
	

}
