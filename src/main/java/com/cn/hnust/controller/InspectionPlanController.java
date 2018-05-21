package com.cn.hnust.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cn.hnust.pojo.InspectionPlan;
import com.cn.hnust.pojo.MaterialDemand;
import com.cn.hnust.pojo.OtherDemand;
import com.cn.hnust.pojo.PackageDemand;
import com.cn.hnust.pojo.SizeDemand;
import com.cn.hnust.service.IInspectionPlanService;
import com.cn.hnust.util.DateUtil;
import com.cn.hnust.util.IdGen;
import com.cn.hnust.util.JsonResult;
import com.sun.mail.handlers.message_rfc822;
/**
 * 检验计划添加
 * @author chenlun
 *
 */
@Controller
@RequestMapping("/plan")
public class InspectionPlanController {

	@Autowired
	private IInspectionPlanService inspectionPlanService;
	/**
	 * 添加检验计划
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addInspectionPlan")
	@ResponseBody
	public JsonResult addInspectionPlan(HttpServletRequest request,HttpServletResponse response){
		JsonResult jsonResult=new JsonResult();
		String projectNo=request.getParameter("projectNo");
		String projectName=request.getParameter("projectName");
		String partsNo=request.getParameter("partsNo");
		String version=request.getParameter("version");
		String fileName=request.getParameter("fileName");
		String describes=request.getParameter("describes");
		String compactor=request.getParameter("compactor");
		String auditor=request.getParameter("auditor");
		String testType=request.getParameter("testType");
        String compactorDate=request.getParameter("compactorDate");
        String materialDemandS=request.getParameter("MaterialDemandS");
        String sizeDemandS=request.getParameter("sizeDemandS");
        String otherDemandS=request.getParameter("otherDemandS");
        String packageDemandS=request.getParameter("packageDemandS");
        List<MaterialDemand> materialDemandList=new ArrayList<MaterialDemand>();
        List<SizeDemand> sizeDemandList=new ArrayList<SizeDemand>();
        List<OtherDemand> otherDemandList=new ArrayList<OtherDemand>();
        List<PackageDemand> packageDemandList=new ArrayList<PackageDemand>();
        String projectNoId=IdGen.uuid();
        //关键尺寸
        String sizeDemand[]=sizeDemandS.split(",");
        for (int i = 0; i < sizeDemand.length; i++) {//对前端传递过来的地址参数进行处理
			String strValue=sizeDemand[i];
			String[] strValueArray = strValue.split("&");
			SizeDemand demand=new SizeDemand();
			for (int j = 0; j < strValueArray.length; j++) {
			   if(j==0){
				   demand.setProject(strValueArray[j]); 
			   }else if(j==1){
				   demand.setStandard(strValueArray[j]);
			   }else if(j==2){
				   demand.setSamplingNum(strValueArray[j]); 
			   }else if(j==3){
				   demand.setAccuracy(strValueArray[j]); 
			   }else if(j==4){
				   demand.setProcessTest(strValueArray[j]);
			   }else if(j==5){
				   demand.setBigGoodsTest(strValueArray[j]);
			   }
			   demand.setProjectNo(projectNo);
			   demand.setProjectNoId(projectNoId);
			   demand.setCreateDate(new Date());
			   demand.setUpdateDate(new Date());
			}
			sizeDemandList.add(demand);
		}
        //主要材料
        String  materialDemand[]=materialDemandS.split(",");
        for (int i = 0; i < materialDemand.length; i++) {
        	MaterialDemand material=new MaterialDemand();
        	material.setProjectNo(projectNo);
        	material.setProjectNoId(projectNoId);
        	material.setDemandExplain(materialDemand[i]);
        	material.setCreateDate(new Date());
        	material.setUpdateDate(new Date());
        	materialDemandList.add(material);
		}
        
        //包装
        String  packageDemand[]=packageDemandS.split(",");
        for (int i = 0; i < packageDemand.length; i++) {
        	PackageDemand packageD=new PackageDemand();
        	packageD.setProjectNo(projectNo);
        	packageD.setProjectNoId(projectNoId);
        	packageD.setDemandExplain(packageDemand[i]);
        	packageD.setCreateDate(new Date());
        	packageD.setUpdateDate(new Date());
        	packageDemandList.add(packageD);
		}
        
        //其他
        String  otherDemand[]=otherDemandS.split(",");
        for (int i = 0; i < otherDemand.length; i++) {
        	OtherDemand other=new OtherDemand();
        	other.setProjectNo(projectNo);
        	other.setProjectNoId(projectNoId);
        	other.setDemandExplain(materialDemand[i]);
        	other.setCreateDate(new Date());
        	other.setUpdateDate(new Date());
        	otherDemandList.add(other);
		}
		InspectionPlan inspectionPlan=new InspectionPlan();
		inspectionPlan.setProjectNo(projectNo);
		inspectionPlan.setProjectNoId(IdGen.uuid());
		inspectionPlan.setProjectName(projectName);
		inspectionPlan.setPartsNo(partsNo);
		inspectionPlan.setVersion(version);
		inspectionPlan.setFileName(fileName);
		inspectionPlan.setDescribes(describes);
		inspectionPlan.setCompactor(compactor);
		inspectionPlan.setAuditor(auditor);
		inspectionPlan.setTestType(testType);
		if(StringUtils.isNotBlank(compactorDate)){
			inspectionPlan.setCompactorDate(DateUtil.StrToDate(compactorDate));
		}
		inspectionPlan.setCreateDate(new Date());
		inspectionPlan.setMaterialDemandList(materialDemandList);
		inspectionPlan.setPackageDemandList(packageDemandList);
		inspectionPlan.setOtherDemandList(otherDemandList);
		inspectionPlan.setSizeDemandList(sizeDemandList);
		inspectionPlanService.addInsInspectionPlan(inspectionPlan);
		jsonResult.setOk(true);
		return jsonResult;
	}
}
