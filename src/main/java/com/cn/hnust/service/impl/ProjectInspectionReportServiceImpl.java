package com.cn.hnust.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.hnust.dao.ProjectInspectionReportMapper;
import com.cn.hnust.pojo.ProjectInspectionReport;
import com.cn.hnust.service.IProjectInspectionReportService;

@Service
public class ProjectInspectionReportServiceImpl implements IProjectInspectionReportService {
    @Autowired
    private ProjectInspectionReportMapper projectInspectionReportMapper;
	@Override
	public List<ProjectInspectionReport> selectAllInspectionReport() {
		return projectInspectionReportMapper.selectAllInspectionReport();
	}
	@Transactional
	@Override
	public void batchAddInspectionReport(List<ProjectInspectionReport> projectInspectionReportList) {
		projectInspectionReportMapper.batchAddInspectionReport(projectInspectionReportList);
	}
	@Override
	public List<ProjectInspectionReport> selectInspectionReportByProjectNo(String projectNo) {
		return projectInspectionReportMapper.selectInspectionReportByProjectNo(projectNo);
	}
	@Override
	public List<ProjectInspectionReport> selectInspectionPlanByProjectNo(String projectNo) {
		return projectInspectionReportMapper.selectInspectionPlanByProjectNo(projectNo);
	}
	@Override
	public void addProjectInspectionReport(ProjectInspectionReport insertProject) {
		projectInspectionReportMapper.insertSelective(insertProject);
	}

}
