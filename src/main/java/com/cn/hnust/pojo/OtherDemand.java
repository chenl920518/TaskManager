package com.cn.hnust.pojo;

import java.io.Serializable;
import java.util.Date;

public class OtherDemand implements Serializable {
    private Integer id;

    private String projectNoId;

    private String projectNo;

    private String demandExplain;

    private Date createDate;

    private Date updateDate;

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

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public String getDemandExplain() {
        return demandExplain;
    }

    public void setDemandExplain(String demandExplain) {
        this.demandExplain = demandExplain == null ? null : demandExplain.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}