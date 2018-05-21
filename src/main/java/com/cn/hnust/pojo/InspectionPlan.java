package com.cn.hnust.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class InspectionPlan implements Serializable {
    private Integer id;

    private String projectNoId;

    private String projectNo;

    private String projectName;

    private String partsNo;

    private String version;

    private String fileName;

    private Date createDate;

    private Date updateDate;

    private String describes;

    private String compactor;

    private String auditor;

    private Date compactorDate;
    
    private String testType;
    
    private List<MaterialDemand> materialDemandList;
    
    private List<SizeDemand> sizeDemandList;
    
    private List<OtherDemand> otherDemandList;
    
    private List<PackageDemand> packageDemandList;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getPartsNo() {
        return partsNo;
    }

    public void setPartsNo(String partsNo) {
        this.partsNo = partsNo == null ? null : partsNo.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
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

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    public String getCompactor() {
        return compactor;
    }

    public void setCompactor(String compactor) {
        this.compactor = compactor == null ? null : compactor.trim();
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

	public List<MaterialDemand> getMaterialDemandList() {
		return materialDemandList;
	}

	public void setMaterialDemandList(List<MaterialDemand> materialDemandList) {
		this.materialDemandList = materialDemandList;
	}

	public List<SizeDemand> getSizeDemandList() {
		return sizeDemandList;
	}

	public void setSizeDemandList(List<SizeDemand> sizeDemandList) {
		this.sizeDemandList = sizeDemandList;
	}

	public List<OtherDemand> getOtherDemandList() {
		return otherDemandList;
	}

	public void setOtherDemandList(List<OtherDemand> otherDemandList) {
		this.otherDemandList = otherDemandList;
	}

	public List<PackageDemand> getPackageDemandList() {
		return packageDemandList;
	}

	public void setPackageDemandList(List<PackageDemand> packageDemandList) {
		this.packageDemandList = packageDemandList;
	}

	public Date getCompactorDate() {
		return compactorDate;
	}

	public void setCompactorDate(Date compactorDate) {
		this.compactorDate = compactorDate;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}
    
}