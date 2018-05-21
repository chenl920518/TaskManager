package com.cn.hnust.dao;

import com.cn.hnust.pojo.InspectionPlan;

public interface InspectionPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InspectionPlan record);

    int insertSelective(InspectionPlan record);

    InspectionPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InspectionPlan record);

    int updateByPrimaryKey(InspectionPlan record);
}