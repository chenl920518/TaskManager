package com.cn.hnust.dao;

import com.cn.hnust.pojo.InspectionPlanInfo;

public interface InspectionPlanInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InspectionPlanInfo record);

    int insertSelective(InspectionPlanInfo record);

    InspectionPlanInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InspectionPlanInfo record);

    int updateByPrimaryKey(InspectionPlanInfo record);
}