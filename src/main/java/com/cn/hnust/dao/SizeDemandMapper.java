package com.cn.hnust.dao;

import com.cn.hnust.pojo.SizeDemand;

public interface SizeDemandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SizeDemand record);

    int insertSelective(SizeDemand record);

    SizeDemand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SizeDemand record);

    int updateByPrimaryKey(SizeDemand record);
}