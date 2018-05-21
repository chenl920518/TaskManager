package com.cn.hnust.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.component.RpcReportHelper;
import com.cn.hnust.enums.QualityStatusEnum;
import com.cn.hnust.enums.QualityTypeEnum;
import com.cn.hnust.pojo.ProjectERP;
import com.cn.hnust.pojo.ProjectTask;
import com.cn.hnust.pojo.QualityReport;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IProjectERPService;
import com.cn.hnust.service.IProjectTaskService;
import com.cn.hnust.service.IQualityReportService;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.util.DateFormat;
import com.cn.hnust.util.JsonResult;
import com.cn.hnust.util.OperationFileUtil;
import com.cn.hnust.util.UploadAndDownloadPathUtil;
import com.cn.hnust.util.ZipUtils;

/**
 * 项目Controller
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/quality")
public class QualityController {

	private static final String String = null;

	private static final Log LOG = LogFactory.getLog(QualityController.class);

	@Resource
	private IProjectERPService projectErpService;

	@Resource
	private IProjectTaskService projectTaskService;

	@Resource
	private IQualityReportService qualityReportService;
	
	@Resource
	private IUserService userService;

	@RequestMapping("/addQuality")
	public String showDetails(HttpServletRequest request,
			HttpServletResponse response) {
		String projectNo = request.getParameter("projectNo");
		String roleNo = request.getParameter("roleNo");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");

		ProjectERP proErp = projectErpService.selectProjectErpByNo(projectNo);

		if (proErp != null) {
			if (StringUtils.isNotBlank(proErp.getMerchandManager2())) {
				request.setAttribute("purchase", proErp.getMerchandManager2());
			}
		}

		request.setAttribute("roleNo", roleNo);
		request.setAttribute("userId", userId);
		request.setAttribute("userName", userName);
		request.setAttribute("projectNo", projectNo);

		return "detail";
	}

	@RequestMapping("/saveQuality")
	@ResponseBody
	public JsonResult saveQuality(HttpServletRequest request,
			HttpServletResponse response) {

		JsonResult jsonResult = new JsonResult();

		String projectNo = request.getParameter("projectNo");
		String userName = request.getParameter("userName");
		String picUrl = request.getParameter("picUrl");
		String typeStr = request.getParameter("type");
		String stateStr = request.getParameter("state");
		String taskDetail = request.getParameter("taskDetail");
		String purchaseName = request.getParameter("purchaseName");
		String explain=request.getParameter("explain");
		Integer type = 0;
		try {
			if (StringUtils.isNotBlank(typeStr)) {
				type = Integer.parseInt(typeStr);
			}
			Integer state = Integer.parseInt(stateStr);

			QualityReport qr = new QualityReport();
			qr.setPicUrl(picUrl);
			qr.setProjectNo(projectNo);
			qr.setUser(userName);
			qr.setStatus(state);
			qr.setType(type);
			qr.setExplainCause(explain);
			qr.setCreatetime(new Date());
			
			qualityReportService.insertSelective(qr);
			if(state == 2){
				ProjectTask pt = new ProjectTask();
				pt.setAccepter(purchaseName);
				pt.setInitiator(userName);
				pt.setProjectNo(projectNo);
				pt.setDescription(taskDetail);
				pt.setTaskStatus("0");
				pt.setStartTime(new Date());
				pt.setCreateTime(new Date());
				pt.setFinishTime(getFinishDate());
				pt.setQualityId(qr.getId());			
				projectTaskService.addProjectTask(pt);//有问题需要给采购布置任务	
			}
			
			qr.setQualityReportUrl("http://112.64.174.34:10010/quality/download?id="+qr.getId());
			//将质检报告信息同步到ERP
			RpcReportHelper.sendRequest("", qr);//同步到ERP系统上
		

			jsonResult.setOk(true);
			jsonResult.setData("录入成功");

		} catch (Exception e) {
			jsonResult.setOk(false);
			jsonResult.setData("录入失败");
			jsonResult.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return jsonResult;
	}

	private Date getFinishDate() {

		Calendar ca = Calendar.getInstance();

		ca.add(Calendar.DATE, 2);

		int day = ca.get(Calendar.DAY_OF_WEEK);

		if (day == 7 || day == 1) {
			ca.add(Calendar.DATE, 2);
		}
		Date finishTime = ca.getTime();

		return finishTime;

	}
	
	@RequestMapping("/deleteQuality")
	@ResponseBody
	public JsonResult deleteQuality(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		try {
            
			String idStr = request.getParameter("id");
			String userName=request.getParameter("userName");
			User user=userService.selectUserByName(userName);
			if(user.getRoleNo()== 100 ||user.getRoleNo()==99 
					||user.getRoleNo()==98 ||user.getRoleNo()==97){
				int id = Integer.parseInt(idStr);
				qualityReportService.deleteByPrimaryKey(id);
				projectTaskService.deleteByQualityId(id);
				jsonResult.setOk(true);
				jsonResult.setMessage("删除成功");
			}else{
				jsonResult.setOk(false);
				jsonResult.setMessage("你无权限删除");
			}
			return jsonResult;
		} catch (Exception e) {
			jsonResult.setOk(false);
			jsonResult.setMessage("删除失败");
			e.printStackTrace();
			return jsonResult;
		}

	}
	
	
	@RequestMapping("/viewQuality")
	public String viewQuality(HttpServletRequest request,
			HttpServletResponse response) {
		try {

			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
			QualityReport qr =  qualityReportService.selectByPrimaryKey(id);
			List<ProjectTask> ptList =  projectTaskService.selectByQualityId(id);
			if(ptList!=null){
				qr.setProjectTaskList(ptList);
			}
			qr.setTypeView(QualityTypeEnum.getEnum(qr.getType()).getValue());
			qr.setStatusView(QualityStatusEnum.getEnum(qr.getStatus()).getValue());
			
			qr.setPicUrls(qr.getPicUrl().split(";"));
			
			qr.setCreatetimeView(DateFormat.date2String(qr.getCreatetime()));
			
			
			request.setAttribute("qualityReport", qr);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "quality_report";

	}

	 @RequestMapping(value = "download")
	    public ResponseEntity<byte[]> drawingFileDownload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException{
	    	
	    	
	    	ResponseEntity<byte[]> download =null;
			try {
				String idStr = request.getParameter("id");
				int id = Integer.parseInt(idStr);
				QualityReport qr =  qualityReportService.selectByPrimaryKey(id);
				String[] imgurls = qr.getPicUrl().split(";");
			    
				ZipUtils.doZip(imgurls,UploadAndDownloadPathUtil.getFilePath(),qr.getProjectNo()+".zip");
			    download = OperationFileUtil.download(UploadAndDownloadPathUtil.getFilePath()+qr.getProjectNo()+".zip");	
			    
			} catch (Exception e) {
				e.printStackTrace();
			}
			return download;

	    }
	    
	    
	    @RequestMapping("/deletePic")
		@ResponseBody
		public JsonResult deletePic(HttpServletRequest request,
				HttpServletResponse response) {
			JsonResult jsonResult = new JsonResult();
			try {

				String idStr = request.getParameter("id");
				int id = Integer.parseInt(idStr);
				String url = request.getParameter("url");
			    QualityReport qr = new QualityReport();
			    qr.setId(id);
			    qr.setPicUrl(url);
			    qualityReportService.updateByPrimaryKeySelective(qr);
				jsonResult.setOk(true);
				jsonResult.setMessage("更新成功");
				return jsonResult;

			} catch (Exception e) {
				jsonResult.setOk(false);
				jsonResult.setMessage("更新失败");
				e.printStackTrace();
				return jsonResult;

			}

		}
		
	    	
	

	
	

}
