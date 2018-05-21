package com.cn.hnust.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.ProjectTask;

public interface IProjectTaskService {

	public void addProjectTask(ProjectTask projectTask);
	
	public List<ProjectTask> selectProjectTask(ProjectTask projectTask);
	
	public List<ProjectTask> selectProjectTaskCount(ProjectTask projectTask);
    /**
     * 查看详情界面
     * @param id
     */
	public ProjectTask selectProjectTaskById(Integer id);
	
	public void updateProjectTask(ProjectTask projectTask);
	
	public List<ProjectTask> statisticsProjectTaskNoFinish(ProjectTask projectTask);

	public List<ProjectTask> statisticsProjectTaskFinish(ProjectTask projectTask);
	
	public List<ProjectTask> statisticsProjectTaskOnTime(String acceptor);
	
	public List<ProjectTask> statisticsProjectTaskAllFinish(String acceptor);
	
	public List<ProjectTask> selectMeetingRecordTask(String meetingNo);
	
	/**
	 * 统计会议任务未完成的数量每个人
	 * @param acceptor
	 * @return
	 */
	public List<ProjectTask> selectMeetingRecordTaskNoFinish(String acceptor);
	/**
	 * 查询该用户是否存在
	 * @param acceptor
	 * @return
	 */
	public List<ProjectTask> selectProjectTaskIfExist(ProjectTask projectTask);
	
	public ProjectTask selectProjectTaskMaxDate(String userName);
	
	int hasAlreadyTask(int triggerId,int userId,String projectNo);
	
    int insertSelective(ProjectTask pro);
    
    void checkNextTask(ProjectTask pro);
    
	List<ProjectTask> selectByQualityId(Integer qualityId);
	
	int deleteByQualityId(Integer qualityId);
}
