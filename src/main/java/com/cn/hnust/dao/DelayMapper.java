package com.cn.hnust.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.Delay;

public interface DelayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Delay record);

    int insertSelective(Delay record);

    Delay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Delay record);

    int updateByPrimaryKey(Delay record);
    /**
     * 查询项目延期信息
     * @param projectNo
     * @return
     */
    List<Delay> selectDelayByProjectNo(String projectNo);
    /**
     * 查询项目最大延期时间
     * @param projectNo
     * @return
     */
	Delay selectMaxDelayByProjectNo(@Param("projectNo")String projectNo);

	Delay selectApplyDelayByProjectNo(@Param("projectNo")String projectNo);
}