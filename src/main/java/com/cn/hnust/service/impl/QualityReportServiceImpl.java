package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.QualityReportMapper;
import com.cn.hnust.pojo.QualityReport;
import com.cn.hnust.service.IQualityReportService;
@Service
public class QualityReportServiceImpl implements IQualityReportService {

	@Resource
	private QualityReportMapper mapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(QualityReport record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(QualityReport record) {
		return mapper.insertSelective(record);
	}

	@Override
	public QualityReport selectByPrimaryKey(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(QualityReport record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(QualityReport record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public QualityReport selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<QualityReport> selectByProjectNo(String projectNo) {
		return mapper.selectByProjectNo(projectNo);
	}

	@Override
	public QualityReport selectNewestReportByProjectNo(String projectNo) {
		return mapper.selectNewestReportByProjectNo(projectNo);
	}

	
}
