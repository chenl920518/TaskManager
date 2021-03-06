package com.cn.hnust.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProjectTask extends PageHelper implements Serializable {
    private Integer id;

    private String projectNo;

    private String initiator;

    private String accepter;

    private Date startTime;

    private String description;

    private String urgentReason;

    private String taskStatus; // 0:未完成,1:已完成 2.已暂停 3.已取消

    private String operator;

    private Date operatorTime;
    
    private String operatorTimeView;
    
    private String searchName;
    
    private Date finishTime;
    
    private String finish;//项目是否完成: 1.完成,未完成
    
    private String isPause;//项目是否暂停  1:暂停项目
    
    private int noFinishCount; //未完成数量
    
    private int finishCount; //完成数量
    
    private String job;  //用户表的job

    private Date createTime;
    
    private String finishRatio; //完成率
    
    private int onTimeFinish;// 按时完成数量
    
    private int allFinish;//所以完成数量
    
    private int meetingTaskNum; //会议任务数量
    
    private String userName;
    
    private String meetingNo;//会议编号
    
    private String taskType; //0:技术部任务,1:会议任务
    
    private Date expectFinishTime;//预计完成时间
    
    private String taskFlag;
    
    private float averageHours;
    
    private int triggerId;
    
    private int userId;
    
    private int sendOrReceive;
    
    private int taskId;
    
    private int indexNum;
    
    private int qualityId;
    
    private String qualityReportUrl;
    
    private String operateExplain;

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getInitiator() {
		return initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}

	public String getAccepter() {
		return accepter;
	}

	public void setAccepter(String accepter) {
		this.accepter = accepter;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getUrgentReason() {
		return urgentReason;
	}

	public void setUrgentReason(String urgentReason) {
		this.urgentReason = urgentReason;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getOperatorTime() {
		return operatorTime;
	}

	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public String getIsPause() {
		return isPause;
	}

	public void setIsPause(String isPause) {
		this.isPause = isPause;
	}

	public int getNoFinishCount() {
		return noFinishCount;
	}

	public void setNoFinishCount(int noFinishCount) {
		this.noFinishCount = noFinishCount;
	}

	public int getFinishCount() {
		return finishCount;
	}

	public void setFinishCount(int finishCount) {
		this.finishCount = finishCount;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getFinishRatio() {
		return finishRatio;
	}

	public void setFinishRatio(String finishRatio) {
		this.finishRatio = finishRatio;
	}

	public int getOnTimeFinish() {
		return onTimeFinish;
	}

	public void setOnTimeFinish(int onTimeFinish) {
		this.onTimeFinish = onTimeFinish;
	}

	public int getAllFinish() {
		return allFinish;
	}

	public void setAllFinish(int allFinish) {
		this.allFinish = allFinish;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMeetingNo() {
		return meetingNo;
	}

	public void setMeetingNo(String meetingNo) {
		this.meetingNo = meetingNo;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public int getMeetingTaskNum() {
		return meetingTaskNum;
	}

	public void setMeetingTaskNum(int meetingTaskNum) {
		this.meetingTaskNum = meetingTaskNum;
	}

	public Date getExpectFinishTime() {
		return expectFinishTime;
	}

	public void setExpectFinishTime(Date expectFinishTime) {
		this.expectFinishTime = expectFinishTime;
	}

	public String getTaskFlag() {
		return taskFlag;
	}

	public void setTaskFlag(String taskFlag) {
		this.taskFlag = taskFlag;
	}

	public float getAverageHours() {
		return averageHours;
	}

	public void setAverageHours(float averageHours) {
		this.averageHours = averageHours;
	}

	public int getTriggerId() {
		return triggerId;
	}

	public void setTriggerId(int triggerId) {
		this.triggerId = triggerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSendOrReceive() {
		return sendOrReceive;
	}

	public void setSendOrReceive(int sendOrReceive) {
		this.sendOrReceive = sendOrReceive;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getIndexNum() {
		return indexNum;
	}

	public void setIndexNum(int indexNum) {
		this.indexNum = indexNum;
	}

	public String getOperatorTimeView() {
		return operatorTimeView;
	}

	public void setOperatorTimeView(String operatorTimeView) {
		this.operatorTimeView = operatorTimeView;
	}

	public int getQualityId() {
		return qualityId;
	}

	public void setQualityId(int qualityId) {
		this.qualityId = qualityId;
	}

	public String getQualityReportUrl() {
		return qualityReportUrl;
	}

	public void setQualityReportUrl(String qualityReportUrl) {
		this.qualityReportUrl = qualityReportUrl;
	}

	public String getOperateExplain() {
		return operateExplain;
	}

	public void setOperateExplain(String operateExplain) {
		this.operateExplain = operateExplain;
	}
}