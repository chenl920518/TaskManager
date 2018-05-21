package com.cn.hnust.dao;

import com.cn.hnust.pojo.MaterialDemand;

public interface MaterialDemandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterialDemand record);

    int insertSelective(MaterialDemand record);

    MaterialDemand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterialDemand record);

    int updateByPrimaryKey(MaterialDemand record);
}