package com.cn.hnust.pojo;

import java.io.Serializable;
import java.util.Date;

public class SizeDemand implements Serializable {
    private Integer id;

    private String projectNo;

    private String project;

    private String numberNo;

    private String standard;

    private String samplingNum;

    private String accuracy;

    private String processTest;

    private String bigGoodsTest;

    private Date updateDate;

    private Date createDate;
    
    private String projectNoId;

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
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public String getNumberNo() {
        return numberNo;
    }

    public void setNumberNo(String numberNo) {
        this.numberNo = numberNo == null ? null : numberNo.trim();
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    public String getSamplingNum() {
        return samplingNum;
    }

    public void setSamplingNum(String samplingNum) {
        this.samplingNum = samplingNum == null ? null : samplingNum.trim();
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy == null ? null : accuracy.trim();
    }

    public String getProcessTest() {
        return processTest;
    }

    public void setProcessTest(String processTest) {
        this.processTest = processTest == null ? null : processTest.trim();
    }

    public String getBigGoodsTest() {
        return bigGoodsTest;
    }

    public void setBigGoodsTest(String bigGoodsTest) {
        this.bigGoodsTest = bigGoodsTest == null ? null : bigGoodsTest.trim();
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

	public String getProjectNoId() {
		return projectNoId;
	}

	public void setProjectNoId(String projectNoId) {
		this.projectNoId = projectNoId;
	}
    
}