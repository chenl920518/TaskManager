package com.cn.hnust.service.impl;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.hnust.dao.InspectionPlanMapper;
import com.cn.hnust.dao.MaterialDemandMapper;
import com.cn.hnust.dao.OtherDemandMapper;
import com.cn.hnust.dao.PackageDemandMapper;
import com.cn.hnust.dao.SizeDemandMapper;
import com.cn.hnust.pojo.InspectionPlan;
import com.cn.hnust.pojo.MaterialDemand;
import com.cn.hnust.pojo.OtherDemand;
import com.cn.hnust.pojo.PackageDemand;
import com.cn.hnust.pojo.SizeDemand;
import com.cn.hnust.service.IInspectionPlanService;

@Service
public class InspectionPlanServiceImpl implements IInspectionPlanService {
    
	@Autowired
	private InspectionPlanMapper inspectionPlanMapper;
	
	@Autowired
	private SizeDemandMapper sizeDemandMapper;
	
	@Autowired
	private MaterialDemandMapper materialDemandMapper;
	
	@Autowired
	private PackageDemandMapper packageDemandMapper;
	
	@Autowired
	private OtherDemandMapper otherDemandMapper;
	/**
	 * 添加检验计划
	 */
	@Transactional
	@Override
	public void addInsInspectionPlan(InspectionPlan inspectionPlan) {
		//1.添加主表
		inspectionPlanMapper.insertSelective(inspectionPlan);
		List<MaterialDemand> materialDemandList=inspectionPlan.getMaterialDemandList();
		for (int i = 0; i < materialDemandList.size(); i++) {
			MaterialDemand materialDemand=materialDemandList.get(i);
			materialDemandMapper.insertSelective(materialDemand);
		}
		List<SizeDemand> sizeDemandList=inspectionPlan.getSizeDemandList();
		for (int i = 0; i < sizeDemandList.size(); i++) {
			SizeDemand sizeDemand=sizeDemandList.get(i);
			sizeDemandMapper.insertSelective(sizeDemand);
		}
		List<PackageDemand> packageDemandList=inspectionPlan.getPackageDemandList();
		for (int i = 0; i < packageDemandList.size(); i++) {
			PackageDemand packageDemand=packageDemandList.get(i);
			packageDemandMapper.insertSelective(packageDemand);
		}
		List<OtherDemand> otherDemandList=inspectionPlan.getOtherDemandList();
		for (int i = 0; i < otherDemandList.size(); i++) {
			OtherDemand otherDemand=otherDemandList.get(i);
			otherDemandMapper.insertSelective(otherDemand);
		}
	}

}
