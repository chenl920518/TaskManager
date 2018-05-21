package com.cn.hnust.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 项目实体对象
 * @author Administrator
 *
 */
public class Project extends PageHelper implements Serializable {
 
	private static final long serialVersionUID = 1L;

	private String id;

    private String projectNo;

    private String projectName;

    private Date deliveryDate;
    
    private String roleName;
    
    private String trueName;

    private int deliveryStatus;

    private int warningStatus;

    private int importance;

    private int stage;

    private int emailUserId; //销售Id
    
    private int purchaseId; //采购Id

    private Date poDate;

    private Date scheduledDate;

    private Date actualStartDate;

    private Date createDate;
    
    private int finish;
  
    private String isPause; //项目是否暂停
    
    private String pauseReason; //项目暂停原因
    
    private String  inputKey; //关键字查询
    
    private List<Delay> delayList; //项目延期信息
    
    private List<ProductionPlan> planList; //生产计划
    
    private List<ProjectReport> reportList; //项目汇报
    
    private List<ProjectDrawing> projectDrawingList;
    
    private List<ProjectInspectionReport> inspectionReportList;
    
    private List<QualityReport> qrList;
    
    private Date startDate; //开始时间
    
    private Date endDate; //结束时间
    
    private List<Task> taskList; //项目的关联任务
     
    private String reportName;
    
    private String report;
    
    private String picUrl;
    
    private Date projectReportDate;
    
    private List<Comment> commentList; //销售输入的状态信息
    
    private List<StatusEnter> statusEnterList;//销售输入的状态信息
    
    private Date sampleScheduledDate;//样品交期
    
    private int flag;
    
    private String companyName;  //工厂名称
    
    private String purchaseNameId; //采购名字查询
    
    private String delayType; //延期类型

    private List<ProjectReport> projectReportList;//查询周报的更新时间
    
    private RoleBindList roleBindList;

    private String createTime; //质量分析表时间
    
    // JASON SANG
    private Integer projectType; //根据项目状态查询
    
    private Integer projectStage; //根据项目阶段
    
    private String purchaseName; //采购
    
    private String sellName;//跟单
    
    private String qualityName;//质检
    
    private String userName;//登录用户
    
    private int roleNo;
    
    private String status;
    
    private String zhijian1;
    
    private String zhijian2;
    
    private String projectAmount;
    
    private String weekPicture;
    
    private String weekInfo;
    
    private int sortField; //排序字段优先级
    
    private Date finishTime; //完成时间
    
    //ERP过来的三个字段
    /** 样品交期*/
    private Date dateSample; //样品交期
    /** 合同交期*/
    private Date completionTime; //大货交期
    /** 上传日期*/
    private Date dateSampleUploading; //合同签订日期
    
    private String productImg;//产品图;
    
    private int sampleFinish; //样品完结;
    
    private Delay delay;//项目申请延期
    
    private List<QualityReport> qualityReportList;//项目质检报告
    
    private QualityReport qualityReport;
    
    private String operatorType;//代表操作
    
    private String screenType; //多条件组合筛选
    
    private List<Integer> plantAnalysisS;//多等级
    
    private List<Integer> projectStageS;//多阶段
    
    private List<Integer> projectStatusS;//多状态(定时任务去更新状态)
    
    private Integer projectStatus;//项目状态
    
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/** 项目等级*/
    private Integer plantAnalysis;
    
    private String plantAnalysisView;
    
    /** 项目材料属性*/
    private int projectMaterialProperties;

    private String technology;
    
    private List<ProjectInspectionReport> inspectionPlanList;
    
    private List<ProjectTask> projectTaskList;
    
    private List<ProjectDrawing> projectDemandReportList;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getSellName() {
		return sellName;
	}

	public void setSellName(String sellName) {
		this.sellName = sellName;
	}

	public int getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(int deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public int getWarningStatus() {
		return warningStatus;
	}

	public void setWarningStatus(int warningStatus) {
		this.warningStatus = warningStatus;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public int getEmailUserId() {
		return emailUserId;
	}

	public void setEmailUserId(int emailUserId) {
		this.emailUserId = emailUserId;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPurchaseName() {
		return purchaseName;
	}

	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

	public int getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(int roleNo) {
		this.roleNo = roleNo;
	}

	public String getInputKey() {
		return inputKey;
	}

	public void setInputKey(String inputKey) {
		this.inputKey = inputKey;
	}

	public List<Delay> getDelayList() {
		return delayList;
	}

	public void setDelayList(List<Delay> delayList) {
		this.delayList = delayList;
	}

	public List<ProductionPlan> getPlanList() {
		return planList;
	}

	public void setPlanList(List<ProductionPlan> planList) {
		this.planList = planList;
	}

	public List<ProjectReport> getReportList() {
		return reportList;
	}

	public void setReportList(List<ProjectReport> reportList) {
		this.reportList = reportList;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public List<ProjectDrawing> getProjectDrawingList() {
		return projectDrawingList;
	}

	public void setProjectDrawingList(List<ProjectDrawing> projectDrawingList) {
		this.projectDrawingList = projectDrawingList;
	}

	public List<ProjectInspectionReport> getInspectionReportList() {
		return inspectionReportList;
	}

	public void setInspectionReportList(List<ProjectInspectionReport> inspectionReportList) {
		this.inspectionReportList = inspectionReportList;
	}

	

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public Date getProjectReportDate() {
		return projectReportDate;
	}

	public void setProjectReportDate(Date projectReportDate) {
		this.projectReportDate = projectReportDate;
	}

	public Date getSampleScheduledDate() {
		return sampleScheduledDate;
	}

	public void setSampleScheduledDate(Date sampleScheduledDate) {
		this.sampleScheduledDate = sampleScheduledDate;
	}

	public List<StatusEnter> getStatusEnterList() {
		return statusEnterList;
	}

	public void setStatusEnterList(List<StatusEnter> statusEnterList) {
		this.statusEnterList = statusEnterList;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIsPause() {
		return isPause;
	}

	public void setIsPause(String isPause) {
		this.isPause = isPause;
	}

	public String getPauseReason() {
		return pauseReason;
	}

	public void setPauseReason(String pauseReason) {
		this.pauseReason = pauseReason;
	}

	public String getPurchaseNameId() {
		return purchaseNameId;
	}

	public void setPurchaseNameId(String purchaseNameId) {
		this.purchaseNameId = purchaseNameId;
	}

	public String getDelayType() {
		return delayType;
	}

	public void setDelayType(String delayType) {
		this.delayType = delayType;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public List<ProjectReport> getProjectReportList() {
		return projectReportList;
	}

	public void setProjectReportList(List<ProjectReport> projectReportList) {
		this.projectReportList = projectReportList;
	}

	public RoleBindList getRoleBindList() {
		return roleBindList;
	}

	public void setRoleBindList(RoleBindList roleBindList) {
		this.roleBindList = roleBindList;
	}

	public Integer getPlantAnalysis() {
		return plantAnalysis;
	}

	public void setPlantAnalysis(Integer plantAnalysis) {
		this.plantAnalysis = plantAnalysis;
	}

	public int getProjectMaterialProperties() {
		return projectMaterialProperties;
	}

	public void setProjectMaterialProperties(int projectMaterialProperties) {
		this.projectMaterialProperties = projectMaterialProperties;
	}


	public String getQualityName() {
		return qualityName;
	}

	public void setQualityName(String qualityName) {
		this.qualityName = qualityName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getProjectType() {
		return projectType;
	}

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	public Integer getProjectStage() {
		return projectStage;
	}

	public void setProjectStage(Integer projectStage) {
		this.projectStage = projectStage;
	}

	public String getPlantAnalysisView() {
		return plantAnalysisView;
	}

	public void setPlantAnalysisView(String plantAnalysisView) {
		this.plantAnalysisView = plantAnalysisView;
	}

	public String getZhijian1() {
		return zhijian1;
	}

	public void setZhijian1(String zhijian1) {
		this.zhijian1 = zhijian1;
	}

	public String getZhijian2() {
		return zhijian2;
	}

	public void setZhijian2(String zhijian2) {
		this.zhijian2 = zhijian2;
	}

	public String getProjectAmount() {
		return projectAmount;
	}

	public void setProjectAmount(String projectAmount) {
		this.projectAmount = projectAmount;
	}

	public String getWeekPicture() {
		return weekPicture;
	}

	public void setWeekPicture(String weekPicture) {
		this.weekPicture = weekPicture;
	}

	public String getWeekInfo() {
		return weekInfo;
	}

	public void setWeekInfo(String weekInfo) {
		this.weekInfo = weekInfo;
	}

	public List<QualityReport> getQrList() {
		return qrList;
	}

	public void setQrList(List<QualityReport> qrList) {
		this.qrList = qrList;
	}

	public int getSortField() {
		return sortField;
	}

	public void setSortField(int sortField) {
		this.sortField = sortField;
	}

	public Date getDateSample() {
		return dateSample;
	}

	public void setDateSample(Date dateSample) {
		this.dateSample = dateSample;
	}

	public Date getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(Date completionTime) {
		this.completionTime = completionTime;
	}

	public Date getDateSampleUploading() {
		return dateSampleUploading;
	}

	public void setDateSampleUploading(Date dateSampleUploading) {
		this.dateSampleUploading = dateSampleUploading;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public int getSampleFinish() {
		return sampleFinish;
	}

	public void setSampleFinish(int sampleFinish) {
		this.sampleFinish = sampleFinish;
	}

	public Delay getDelay() {
		return delay;
	}

	public void setDelay(Delay delay) {
		this.delay = delay;
	}

	public List<QualityReport> getQualityReportList() {
		return qualityReportList;
	}

	public void setQualityReportList(List<QualityReport> qualityReportList) {
		this.qualityReportList = qualityReportList;
	}

	public QualityReport getQualityReport() {
		return qualityReport;
	}

	public void setQualityReport(QualityReport qualityReport) {
		this.qualityReport = qualityReport;
	}

	public String getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getScreenType() {
		return screenType;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}

	public List<Integer> getPlantAnalysisS() {
		return plantAnalysisS;
	}

	public void setPlantAnalysisS(List<Integer> plantAnalysisS) {
		this.plantAnalysisS = plantAnalysisS;
	}

	public List<Integer> getProjectStageS() {
		return projectStageS;
	}

	public void setProjectStageS(List<Integer> projectStageS) {
		this.projectStageS = projectStageS;
	}

	public List<Integer> getProjectStatusS() {
		return projectStatusS;
	}

	public void setProjectStatusS(List<Integer> projectStatusS) {
		this.projectStatusS = projectStatusS;
	}

	public Integer getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}

	public List<ProjectInspectionReport> getInspectionPlanList() {
		return inspectionPlanList;
	}

	public void setInspectionPlanList(List<ProjectInspectionReport> inspectionPlanList) {
		this.inspectionPlanList = inspectionPlanList;
	}

	public List<ProjectTask> getProjectTaskList() {
		return projectTaskList;
	}

	public void setProjectTaskList(List<ProjectTask> projectTaskList) {
		this.projectTaskList = projectTaskList;
	}

	public List<ProjectDrawing> getProjectDemandReportList() {
		return projectDemandReportList;
	}

	public void setProjectDemandReportList(List<ProjectDrawing> projectDemandReportList) {
		this.projectDemandReportList = projectDemandReportList;
	}	
}