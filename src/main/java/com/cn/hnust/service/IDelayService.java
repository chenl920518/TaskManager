package com.cn.hnust.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.Delay;

/***
 * 项目交期延误 Service
 * @author Administrator
 *
 */
public interface IDelayService {
    /**
     * 插入项目交期延误的信息
     * @param delay
     */
	public void insertDelay(Delay delay);
	/**
	 * 根据项目号查询延期信息
	 * @return
	 */
	public List<Delay> selectDelayByProjectNo(String projectNo);
	/**
	 * 根据项目号查询最大的延期时间
	 * @return
	 */
	public Delay selectMaxDelayByProjectNo(String projectNo);
	
	public Delay selectApplyDelayByProjectNo(String projectNo);
	
	public void updateDelayFlagByProjectNo(Delay delay);
}
