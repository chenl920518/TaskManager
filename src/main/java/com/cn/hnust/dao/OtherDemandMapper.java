package com.cn.hnust.dao;

import com.cn.hnust.pojo.OtherDemand;

public interface OtherDemandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OtherDemand record);

    int insertSelective(OtherDemand record);

    OtherDemand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OtherDemand record);

    int updateByPrimaryKey(OtherDemand record);
}