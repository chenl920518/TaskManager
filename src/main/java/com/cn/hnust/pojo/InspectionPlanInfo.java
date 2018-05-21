package com.cn.hnust.pojo;

import java.io.Serializable;
import java.util.Date;

public class InspectionPlanInfo implements Serializable {
    private Integer id;

    private String projectNoId;

    private String planName;

    private String projectNo;

    private String addPlan;

    private String wAudit;

    private String isQuality;

    private String yAudit;

    private Integer updateNum;

    private Integer uploadNum;

    private Date updateDate;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectNoId() {
        return projectNoId;
    }

    public void setProjectNoId(String projectNoId) {
        this.projectNoId = projectNoId == null ? null : projectNoId.trim();
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public String getAddPlan() {
        return addPlan;
    }

    public void setAddPlan(String addPlan) {
        this.addPlan = addPlan == null ? null : addPlan.trim();
    }

    public String getwAudit() {
        return wAudit;
    }

    public void setwAudit(String wAudit) {
        this.wAudit = wAudit == null ? null : wAudit.trim();
    }

    public String getIsQuality() {
        return isQuality;
    }

    public void setIsQuality(String isQuality) {
        this.isQuality = isQuality == null ? null : isQuality.trim();
    }

    public String getyAudit() {
        return yAudit;
    }

    public void setyAudit(String yAudit) {
        this.yAudit = yAudit == null ? null : yAudit.trim();
    }

    public Integer getUpdateNum() {
        return updateNum;
    }

    public void setUpdateNum(Integer updateNum) {
        this.updateNum = updateNum;
    }

    public Integer getUploadNum() {
        return uploadNum;
    }

    public void setUploadNum(Integer uploadNum) {
        this.uploadNum = uploadNum;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}