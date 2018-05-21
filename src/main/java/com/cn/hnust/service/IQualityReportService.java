package com.cn.hnust.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.QualityReport;

public interface IQualityReportService {
	
	
	    int deleteByPrimaryKey(Integer id);

	    int insert(QualityReport record);

	    int insertSelective(QualityReport record);

	    QualityReport selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(QualityReport record);

	    int updateByPrimaryKey(QualityReport record);
	    
	    QualityReport selectByPrimaryKey(int id);
	    
	    List<QualityReport> selectByProjectNo(@Param("projectNo")String projectNo);

		QualityReport selectNewestReportByProjectNo(@Param("projectNo")String projectNo);

}
