package com.cn.hnust.dao;

import com.cn.hnust.pojo.PackageDemand;

public interface PackageDemandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PackageDemand record);

    int insertSelective(PackageDemand record);

    PackageDemand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PackageDemand record);

    int updateByPrimaryKey(PackageDemand record);
}