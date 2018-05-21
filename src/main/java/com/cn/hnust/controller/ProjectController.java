package com.cn.hnust.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cn.hnust.enums.ProjectAnalysisEnum;
import com.cn.hnust.enums.QualityStatusEnum;
import com.cn.hnust.enums.QualityTypeEnum;
import com.cn.hnust.enums.TaskStatusEnum;
import com.cn.hnust.pojo.Comment;
import com.cn.hnust.pojo.Delay;
import com.cn.hnust.pojo.ProductionPlan;
import com.cn.hnust.pojo.Project;
import com.cn.hnust.pojo.ProjectDrawing;
import com.cn.hnust.pojo.ProjectInspectionReport;
import com.cn.hnust.pojo.ProjectReport;
import com.cn.hnust.pojo.ProjectTask;
import com.cn.hnust.pojo.QualityReport;
import com.cn.hnust.pojo.StatusEnter;
import com.cn.hnust.pojo.Task;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IDelayService;
import com.cn.hnust.service.IProductionPlanService;
import com.cn.hnust.service.IProjectCommentService;
import com.cn.hnust.service.IProjectDrawingService;
import com.cn.hnust.service.IProjectInspectionReportService;
import com.cn.hnust.service.IProjectReportService;
import com.cn.hnust.service.IProjectService;
import com.cn.hnust.service.IProjectTaskService;
import com.cn.hnust.service.IQualityReportService;
import com.cn.hnust.service.IStatusEnterService;
import com.cn.hnust.service.ITaskReportService;
import com.cn.hnust.service.ITaskService;
import com.cn.hnust.service.impl.UserServiceImpl;
import com.cn.hnust.service.impl.task.ProjectDateTask;
import com.cn.hnust.util.DateFormat;
import com.cn.hnust.util.DateUtil;
import com.cn.hnust.util.IdGen;
import com.cn.hnust.util.JsonResult;
import com.cn.hnust.util.OperationFileUtil;
import com.cn.hnust.util.UploadAndDownloadPathUtil;

/**
 * 项目Controller
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

	private static final String String = null;

	private static final Log LOG = LogFactory.getLog(ProjectController.class);

	@Autowired
	private IProjectService projectService;
	@Autowired
	private IProjectReportService projectReportService;
	@Autowired
	private ITaskService taskService;
	@Autowired
	private ITaskReportService taskReportService;
	@Autowired
	private IProjectDrawingService projectDrawingService;
	@Autowired
	private IProjectInspectionReportService projectInspectionReportService;
	@Autowired
	private IProductionPlanService productionPlanService;
	@Autowired
	private IProjectCommentService projectCommentService;
	@Autowired
	private IStatusEnterService statusEnterService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private IQualityReportService qrService;
	@Autowired
	private IDelayService delayService;
	@Autowired
    private IProjectTaskService projectTaskService;
	@Autowired
	private ProjectDateTask projectDateTask;
	/**
	 * 查询登录用户所属的项目列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public JsonResult showUser(HttpServletRequest request,
			HttpServletResponse response) {

		String status = "";
		JsonResult jsonResult = new JsonResult();
		Integer operatorType = 0;
		Integer pageNumber = 1;
		Integer pageSize = 10;
		Integer userId = null;
		List<Project> list = null;
		List<Task> taskList = new ArrayList<Task>();
		List<Project> delayList = new ArrayList<Project>();
		List<Project> messageList = new ArrayList<Project>();
		List<Task> seaTaskList = new ArrayList<Task>();// 判断是否有任务
		List<Project> totalCountList = new ArrayList<Project>();// 总记录数
		Project project = new Project();

		Date today = new Date();

		String pageNumberStr = request.getParameter("pageNumber");
		String operatorTypeStr = request.getParameter("operatorType");
		String roleNo = request.getParameter("roleNo"); // 判断是管理员，销售，采购
		String userName = request.getParameter("userName");
		String userIdStr = request.getParameter("userId");
		String inputKey = request.getParameter("inputKey");// 搜索词
		String projectType = request.getParameter("projectType");// 项目状态
		String projectStage = request.getParameter("projectStage");// 项目阶段
		String plantAnalysis = request.getParameter("plantAnalysis");// 项目等级
		String projectTypeStr = request.getParameter("projectTypeS");// 项目等级
		String projectStageStr = request.getParameter("projectStageS");// 项目阶段(pc)
		String plantAnalysisStr = request.getParameter("plantAnalysisS");// 项目等级(pc)
		String purchaseName = request.getParameter("purchase_name");// 采购
		String saleName = request.getParameter("documentary_name");// 跟单、销售
		String qualityName = request.getParameter("quality_name");// 质检
		String pageSizeStr = request.getParameter("pageSize");
        String screenType=request.getParameter("screenType");
		if (StringUtils.isNotBlank(operatorTypeStr)) {
			operatorType = Integer.parseInt(operatorTypeStr);
		}
		if (StringUtils.isNotBlank(pageNumberStr)) {
			pageNumber = Integer.parseInt(pageNumberStr);// 第几页,1,2

		}
		if (StringUtils.isNotBlank(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}

		try {

			if (StringUtils.isNotBlank(inputKey)) {
				inputKey = URLDecoder.decode(inputKey, "UTF-8");
			}
			Task task = new Task();
			task.setInputKey(inputKey);
			task.setPurchaseName(purchaseName);
			task.setSellName(saleName);
			task.setUserName(userName);
			task.setRoleNo(Integer.parseInt(roleNo));
			taskList = taskService.selectTaskList(task);

			project.setPageSize(pageSize);
			project.setPageNumber(pageSize * (pageNumber - 1));

			if (StringUtils.isNotBlank(projectType)) {
				project.setProjectType(Integer.parseInt(projectType));
			}
			if (StringUtils.isNotBlank(projectStage)) {
				project.setProjectStage(Integer.parseInt(projectStage));
			}
			if (StringUtils.isNotBlank(plantAnalysis)) {
				project.setPlantAnalysis(Integer.parseInt(plantAnalysis));
			}
			//项目等级的组合(0,1,2,3) -1代表全部的
            if(StringUtils.isNotBlank(plantAnalysisStr)){//-1,0,1,2,3
            	List<Integer> plantAnalysisList=new ArrayList<Integer>();
            	String plantAnalysisS[]=plantAnalysisStr.split(",");
            	for (int i = 0; i < plantAnalysisS.length; i++) {
            		plantAnalysisList.add(Integer.parseInt(plantAnalysisS[i]));
                }
            	project.setPlantAnalysisS(plantAnalysisList);
            }
            //项目阶段组合
            if(StringUtils.isNotBlank(projectStageStr)){
            	String projectStageS[]=projectStageStr.split(","); //-1,0,1,2
            	List<Integer> projectStageList=new ArrayList<Integer>();
            	for (int i = 0; i < projectStageS.length; i++) {
            		projectStageList.add(Integer.parseInt(projectStageS[i]));
                }
            	project.setProjectStageS(projectStageList);
            }
            //项目状态组合
            if(StringUtils.isNotBlank(projectTypeStr)){
            	String projectTypeS[]=projectTypeStr.split(",");
            	List<Integer> projectTypeList=new ArrayList<Integer>();
            	for (int i = 0; i < projectTypeS.length; i++) {
            		projectTypeList.add(Integer.parseInt(projectTypeS[i]));
                }
            	project.setProjectStatusS(projectTypeList);
            }
            
			project.setSellName(saleName);
			project.setQualityName(qualityName);
			project.setPurchaseName(purchaseName);
			project.setScreenType(screenType); //pc 端页面筛选
			project.setInputKey(inputKey);
			project.setUserName(userName);
			project.setRoleNo(Integer.parseInt(roleNo));
			list = projectService.findProjectList(project);// 项目列表
			totalCountList = projectService.findProjectListCount(project);// 查询记录条数
			
			userId = Integer.parseInt(userIdStr);
			// 计算延期的项目(样品交期,或者大货交期)
			for (int i = 0; i < totalCountList.size(); i++) {
				Project pro = totalCountList.get(i);
				//1.大货没完结,大货交期,不为空，并且没暂停和取消
				if(pro.getDeliveryDate() != null){//大货交期不为空,样品交期不为空
					if (pro.getDeliveryDate() != null && pro.getDeliveryDate().getTime()+7*24*60*60*1000 < today.getTime() && pro.getFinish() == 0
							&& (pro.getIsPause() == null || "0".equals(pro.getIsPause()))) {// 交期加上7天小于当前时间,算延期
						delayList.add(pro);
					}	
				}
				//2.大货交期为空,样品交期不为空,样品没完结，没取消暂停
				else if(pro.getSampleScheduledDate() != null && pro.getDelayType()==null){
					if(pro.getSampleScheduledDate() != null && pro.getSampleScheduledDate().getTime()+7*24*60*60*1000 < today.getTime() && pro.getSampleFinish() == 0
							&& (pro.getIsPause() == null || "0".equals(pro.getIsPause()))){
						delayList.add(pro);
					}
				}
				//3.样品交期完结了大货交期没完结并且有大货交期
				else if(pro.getSampleFinish()==1 && pro.getDeliveryDate() != null){
					if (pro.getDeliveryDate() != null && pro.getDeliveryDate().getTime()+7*24*60*60*1000 < today.getTime() && pro.getFinish() == 0
							&& (pro.getIsPause() == null || "0".equals(pro.getIsPause()))) {// 交期小于当前时间,算延期
						delayList.add(pro);
					}	
				}
			}

			// 将任务列表添加到项目信息中(判断该项目是否有任务)
			for (Project seaProject : list) {
				Task serTask = new Task();
				serTask.setProjectNo(seaProject.getProjectNo());
				seaTaskList = taskService.selectTaskList(serTask);
				seaProject.setTaskList(seaTaskList);

				// 4.查询项目的图纸信息
				List<ProjectDrawing> projectDrawingList = projectDrawingService.selectProjectDrawingByProjectNo(seaProject.getProjectNo());
				// 5.质检报告信息
				List<ProjectInspectionReport> projectInspectionReportList = projectInspectionReportService.selectInspectionReportByProjectNo(seaProject.getProjectNo());
				//6.查询检验计划
				List<ProjectInspectionReport> inspectionPlanList=projectInspectionReportService.selectInspectionPlanByProjectNo(seaProject.getProjectNo());
				ProjectTask projectTask=new ProjectTask();
				projectTask.setProjectNo(seaProject.getProjectNo());
				projectTask.setTaskStatus("-1");
				projectTask.setPageSize(10);
				projectTask.setPageNumber(1);
				//7.检查这个项目是否有关联任务
				List<ProjectTask> projectTaskList=projectTaskService.selectProjectTask(projectTask);
				//8.查询项目需求图纸报告
				List<ProjectDrawing> demandReportList=projectDrawingService.selectProjectDemandReportByNo(seaProject.getProjectNo());
				seaProject.setProjectDemandReportList(demandReportList);
				seaProject.setInspectionPlanList(inspectionPlanList);
				seaProject.setProjectDrawingList(projectDrawingList);
				seaProject.setInspectionReportList(projectInspectionReportList);
				seaProject.setProjectTaskList(projectTaskList);
				// 6.查询周报更新最近的时间
				ProjectReport projectReport = projectReportService.selectProjectReportLatelyDate(seaProject.getProjectNo());
				// 7.查询本周是否上传的周报
				//判断当前时间是否是周一,是周一不是周一
				Calendar cal=Calendar.getInstance();
				cal.setTime(new Date()); 
				int week=cal.get(Calendar.DAY_OF_WEEK)-1;
				List<ProjectReport> projectReportList = projectReportService.selectProjectReportWeek(seaProject.getProjectNo(),week);
				seaProject.setProjectReportList(projectReportList);

				if (projectReport != null) {
					seaProject.setProjectReportDate(projectReport
							.getCreateDate());
					if (StringUtils.isNotBlank(projectReport.getPicUrl())) {
						seaProject.setWeekPicture(projectReport.getPicUrl());
					}
					seaProject.setWeekInfo(projectReport.getReport());

				}
				//8.查询质检上传
				QualityReport qualityReport = qrService.selectNewestReportByProjectNo(seaProject.getProjectNo());
				seaProject.setQualityReport(qualityReport);
				//9.查询该项目最近一次申请延期的信息
                Delay delay=delayService.selectApplyDelayByProjectNo(seaProject.getProjectNo());
                seaProject.setDelay(delay);
				// 判断项目状态
				if (seaProject.getFinish() == 0) {//大货没有完结
					if (seaProject.getIsPause() == null|| "0".equals(seaProject.getIsPause())) {
						List<ProjectReport> pr = projectReportService.selectProjectReport(seaProject.getProjectNo());
						 /* and (finish =0 and sample_finish =0 and (is_pause = 0 or is_pause is null ) 
								  and weekReportNum=0 and delivery_date is null and sample_scheduled_date is null) */
						if(seaProject.getSampleFinish()==0 && pr.size()==0 && 
								seaProject.getDeliveryDate() == null && seaProject.getSampleScheduledDate()==null){
							status = "新立项项目";
						}
						//正在进行的项目判断
						/*<!-- 1. 样品交期，大货交期 (大货为空 样品交期不为为空样品 大于当前时间,样品为空,大货不为空 大货交期大于当前时间 ,样品大货不为空都大于)
						2.样品交期完结(大货交期为空 或者大货交期大于 当前时间) 3.新立项项目更新了周报，在正常项目里面 -->*/
						/* AND ( (finish =0 and sample_finish =0 and (is_pause = 0 or is_pause is null ) and weekReportNum &gt; 0 and delivery_date is null and sample_scheduled_date is null)
							     or(finish =0 and sample_finish =0 and (is_pause = 0 or is_pause is null ) and ((delivery_date is NULL and sample_scheduled_date!= '' and sample_scheduled_date &gt; now())
							     or(sample_scheduled_date is NULL and delivery_date!= '' and delivery_date &gt; now())
							     or(sample_scheduled_date != '' and delivery_date != '' and delivery_date &gt; now() and sample_scheduled_date &gt; now()))) 
							     or(sample_finish=1 and finish =0 and ((delivery_date is null)or(delivery_date!='' and delivery_date &gt; now()))
							  ))*/
						if((seaProject.getFinish()==0 && seaProject.getSampleFinish() ==0 &&   pr.size()> 0 && seaProject.getDeliveryDate()==null && seaProject.getSampleScheduledDate()== null)
							     ||(seaProject.getFinish()==0 && seaProject.getSampleFinish() ==0  && ((seaProject.getDeliveryDate()==null &&  seaProject.getSampleScheduledDate()!=null && seaProject.getSampleScheduledDate().getTime()+7*24*60*60*1000>today.getTime())
							     ||(seaProject.getSampleScheduledDate()==null && seaProject.getDeliveryDate()!=null && seaProject.getDeliveryDate().getTime()+7*24*60*60*1000>today.getTime())
							     ||(seaProject.getSampleScheduledDate()!=null && seaProject.getDeliveryDate()!=null && seaProject.getDeliveryDate().getTime()+7*24*60*60*1000>today.getTime()))) 
							     ||(seaProject.getSampleFinish()==1 && seaProject.getFinish()==0 && (/*(seaProject.getDeliveryDate()==null)||*/(seaProject.getDeliveryDate()!=null && seaProject.getDeliveryDate().getTime()+7*24*60*60*1000 >today.getTime()))
							  )){
							status = "正在进行的项目";
						}
						//样品完结项目(点击样品完结,没有大货交期sortField=2 projectStatus=6 )
						if(seaProject.getSampleFinish()==1 && seaProject.getFinish()==0 && seaProject.getDeliveryDate()==null){
							status = "样品完结项目";
						}
						//样品交期或者大货交期 延期
                        if(seaProject.getDeliveryDate() != null){//大货交期不为空,样品交期不为空
        					if (seaProject.getDeliveryDate() != null && seaProject.getDeliveryDate().getTime()+7*24*60*60*1000< today.getTime() && seaProject.getFinish() == 0
        							&& (seaProject.getIsPause() == null || "0".equals(seaProject.getIsPause()))) {// 交期小于当前时间,算延期
        						status = "延期项目";
        					}	
        				}
        				//2.大货交期为空,样品交期不为空,样品没完结，没取消暂停
        				else if(seaProject.getSampleScheduledDate() != null && seaProject.getDelayType()==null){
        					if(seaProject.getSampleScheduledDate() != null && seaProject.getSampleScheduledDate().getTime()+7*24*60*60*1000< today.getTime() && seaProject.getSampleFinish() == 0
        							&& (seaProject.getIsPause() == null || "0".equals(seaProject.getIsPause()))){
        						status = "延期项目";
        					}
        				}
        				//3.样品交期完结了大货交期没完结并且有大货交期
        				else if(seaProject.getSampleFinish()==1 && seaProject.getDeliveryDate() != null){
        					if (seaProject.getDeliveryDate() != null && seaProject.getDeliveryDate().getTime() +7*24*60*60*1000 < today.getTime() && seaProject.getFinish() == 0
        							&& (seaProject.getIsPause() == null || "0".equals(seaProject.getIsPause()))) {// 交期小于当前时间,算延期
        						status = "延期项目";
        					}	
        				}
					} else if ("1".contains(seaProject.getIsPause())) {
						status = "暂停项目";

					} else if ("2".contains(seaProject.getIsPause())) {
						status = "取消项目";
					}

				} else if (seaProject.getFinish() == 1) {
					status = "完成项目";
				}
				seaProject.setStatus(status);
				if (seaProject.getPlantAnalysis()!=null && seaProject.getPlantAnalysis() != 0) {
					seaProject.setPlantAnalysisView(ProjectAnalysisEnum.getEnum(seaProject.getPlantAnalysis()).getValue());
				}
				if(seaProject.getSampleScheduledDate()!=null && seaProject.getDeliveryDate()==null){//样品交期快到期提醒
					  if (seaProject.getSampleScheduledDate() != null&& today.getTime() < seaProject.getSampleScheduledDate().getTime()
								&& seaProject.getSampleScheduledDate().getTime()- today.getTime() <= 12 * 24 * 60 * 60* 1000 && seaProject.getSampleFinish() == 0) {
						  seaProject.setFlag(1); // 快到期
					  } else if (seaProject.getSampleScheduledDate() != null&& seaProject.getSampleScheduledDate().getTime()+7*24*60*60*1000< today.getTime() && seaProject.getSampleFinish() == 0) {
						  seaProject.setFlag(2); // 已延期
					  } 
					}
					if(seaProject.getDeliveryDate()!=null){//大货交期快到期了提醒
					  if (seaProject.getDeliveryDate() != null&& today.getTime() < seaProject.getDeliveryDate().getTime()
								&& seaProject.getDeliveryDate().getTime()- today.getTime() <= 12 * 24 * 60 * 60* 1000) {
						  seaProject.setFlag(1); // 快到期
					  } else if (seaProject.getDeliveryDate() != null&& seaProject.getDeliveryDate().getTime()+7*24*60*60*1000 < today.getTime() && seaProject.getFinish() == 0) {
						  seaProject.setFlag(2); // 已延期
					  } 	
					}
			}

			// 销售进来判断采购是否提供了新的采购计划
			if ("5".equals(roleNo)) {
				messageList = projectService.findProjectReportMessage(project);
			}

		/*	if (list != null && list.size() > 0) {
				for (Project pro : list) {// 交期快到了提醒
					if(pro.getSampleScheduledDate()!=null && pro.getDeliveryDate()==null){//样品交期快到期提醒
					  if (pro.getSampleScheduledDate() != null&& today.getTime() < pro.getSampleScheduledDate().getTime()
								&& pro.getSampleScheduledDate().getTime()- today.getTime() <= 12 * 24 * 60 * 60* 1000 && pro.getSampleFinish() == 0) {
						 pro.setFlag(1); // 快到期
					  } else if (pro.getSampleScheduledDate() != null&& pro.getSampleScheduledDate().getTime()+7*24*60*60*1000< today.getTime() && pro.getSampleFinish() == 0) {
						 pro.setFlag(2); // 已延期
					  } 
					}
					if(pro.getDeliveryDate()!=null){//大货交期快到期了提醒
					  if (pro.getDeliveryDate() != null&& today.getTime() < pro.getDeliveryDate().getTime()
								&& pro.getDeliveryDate().getTime()- today.getTime() <= 12 * 24 * 60 * 60* 1000) {
						 pro.setFlag(1); // 快到期
					  } else if (pro.getDeliveryDate() != null&& pro.getDeliveryDate().getTime()+7*24*60*60*1000 < today.getTime() && pro.getFinish() == 0) {
						 pro.setFlag(2); // 已延期
					  } 	
					}	
				}
			}*/

			int projectNum = 0;
			int delayNum = 0;
			int messageNum = 0;

			if (totalCountList != null && totalCountList.size() > 0) {
				projectNum = totalCountList.size();
			}
			if (delayList != null && delayList.size() > 0) {
				delayNum = delayList.size();
			}
			if (messageList != null && messageList.size() > 0) {
				messageNum = messageList.size();
			}

			Map<String, Object> hashMap = new HashMap<String, Object>();

			hashMap.put("taskList", taskList);
			//hashMap.put("totalCountFinish",totalCountFinish);
			hashMap.put("list", list);
			hashMap.put("userId", userId);
			hashMap.put("roleNo", roleNo);
			hashMap.put("userName", userName);
			hashMap.put("projectNum", projectNum);
			hashMap.put("delayNum", delayNum);
			hashMap.put("messageNum", messageNum);
			hashMap.put("projectType", projectType);
			hashMap.put("pageSize", pageSize);
			hashMap.put("pageNumber", pageNumber);
			hashMap.put("totalCount", totalCountList.size());
			hashMap.put("operatorType", operatorType);
			jsonResult.setData(hashMap);
			jsonResult.setOk(true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setMessage(e.getMessage());
			jsonResult.setOk(false);
			LOG.error("error", e);
		} finally {
			return jsonResult;
		}

	}

	/**
	 * 查询项目详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/showDetails")
	public String showDetails(HttpServletRequest request,
			HttpServletResponse response) {
		String projectNo = request.getParameter("projectNo");
		String roleNo = request.getParameter("roleNo");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String pageNumber=request.getParameter("pageNumber");
		List<Task> taskList = new ArrayList<Task>();
		List<QualityReport> qrls = null;
		// 1.查询项目详细信息
		Project project = projectService.showDetails(projectNo);
		// 2.查询项目的任务信息
		taskList = taskService.findTaskByProjectNo(projectNo);
		for (int i = 0; i < taskList.size(); i++) {// 遍历任务根据id查询任务汇报进展
			Task task = taskList.get(i);
			// 3.查询任务的汇报进展
			task.setTaskReportList(taskReportService.selectTaskReportByNo(task
					.getId()));
		}
		// 4.查询项目的图纸信息
		List<ProjectDrawing> projectDrawingList = projectDrawingService
				.selectProjectDrawingByProjectNo(projectNo);
		// 5.质检报告信息
		List<ProjectInspectionReport> projectInspectionReportList = projectInspectionReportService
				.selectInspectionReportByProjectNo(projectNo);
		// 6.查询项目留信息
		List<Comment> commentList = projectCommentService
				.selectProjectComment(projectNo);
		// 7.查询销售输入的状态信息
		List<StatusEnter> statusEnterList = statusEnterService
				.selectProjectStatusEnter(projectNo);
		for (StatusEnter statusEnter : statusEnterList) {
			if (StringUtils.isNotBlank(statusEnter.getStatusType())) {
				String statusType = statusEnter.getStatusType();
				String[] others = statusType.split(",");
				statusEnter.setStatusTypeList(Arrays.asList(others));
			}
		}

		// 8 质检报告
		try {
			qrls = qrService.selectByProjectNo(projectNo);
			if (qrls != null && qrls.size() > 0) {
				for (QualityReport qr : qrls) {
					StringBuilder detailView = new StringBuilder("[");
					detailView.append(qr.getProjectNo()).append("]");
					detailView.append(
							QualityTypeEnum.getEnum(qr.getType()).getValue())
							.append(",");
					detailView.append(
							QualityStatusEnum.getEnum(qr.getStatus())
									.getValue()).append(",[");
					detailView.append(qr.getUser()).append("/")
							.append(DateFormat.date2String(qr.getCreatetime())).append("]");
					qr.setDetailView(detailView.toString());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
  
		project.setQrList(qrls);
		project.setTaskList(taskList);
		project.setCommentList(commentList);
		project.setProjectDrawingList(projectDrawingList);
		project.setInspectionReportList(projectInspectionReportList);
		project.setStatusEnterList(statusEnterList);
		request.setAttribute("project", project);
		request.setAttribute("roleNo", roleNo);
		request.setAttribute("userId", userId);
		request.setAttribute("userName", userName);
		request.setAttribute("pageNumber", pageNumber);

		return "project_detail";
	}

	/**
	 * 编辑项目详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/editDetails")
	public String editDetails(HttpServletRequest request,
			HttpServletResponse response) {
		String projectNo = request.getParameter("projectNo");
		String roleNo = request.getParameter("roleNo");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String purchaseNameId = request.getParameter("purchaseNameId");
		String actualStartDate = "";
		String sampleScheduledDate = "";
		String scheduledDate = "";

		try {
			// List<Task> taskList=new ArrayList<Task>();

			// 1.查询项目详细信息
			Project project = projectService.showDetails(projectNo);
			// 开工日期
			actualStartDate = DateFormat.date2String(project
					.getActualStartDate());
			// 样品交期
			sampleScheduledDate = DateFormat.date2String(project
					.getSampleScheduledDate());
			// 大货交期
			scheduledDate = DateFormat.date2String(project.getScheduledDate());

			List<ProductionPlan> planList = project.getPlanList();
			if (planList != null && planList.size() > 0) {
				for (int i = 0; i < planList.size(); i++) {
					ProductionPlan pp = planList.get(i);
					pp.setPlanDate2String(DateFormat.date2String(pp
							.getPlanDate()));
				}
			}
			List<Project> projectList=new ArrayList<Project>();
			projectList.add(project);
			projectDateTask.syncProjectDate(projectList);
			request.setAttribute("project", project);
			request.setAttribute("actualStartDate", actualStartDate);
			request.setAttribute("sampleScheduledDate", sampleScheduledDate);
			request.setAttribute("scheduledDate", scheduledDate);

			request.setAttribute("roleNo", roleNo);
			request.setAttribute("userId", userId);
			request.setAttribute("userName", userName);
			request.setAttribute("purchaseNameId", purchaseNameId);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("error", e);
		}

		return "project_plan";

	}

	/**
	 * 更新项目信息(交期)
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("finally")
	@RequestMapping("/updateProject")
	@ResponseBody
	public JsonResult updateProject(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JsonResult jsonResult = new JsonResult();
		String projectNo = request.getParameter("projectNo");
		String scheduledDate = request.getParameter("scheduledDate");// 大货交期
		String sampleScheduledDate = request
				.getParameter("sampleScheduledDate");
		String actualStartDate = request.getParameter("actualStartDate");// 开工日期
		List<ProductionPlan> planList = new ArrayList<ProductionPlan>();
		ProductionPlan productionPlan1;
		ProductionPlan productionPlan2;

		String node = request.getParameter("node");
		String nodeDate = request.getParameter("nodeDate");
		String node1 = request.getParameter("node1");
		String nodeDate1 = request.getParameter("nodeDate1");

		if (StringUtils.isNotBlank(node) && StringUtils.isNotBlank(nodeDate)) {
			productionPlan1 = new ProductionPlan();
			productionPlan1.setId(IdGen.uuid());
			productionPlan1.setPlanNode(node);
			productionPlan1.setPlanDate(java.sql.Date.valueOf(nodeDate));
			productionPlan1.setProjectNo(projectNo);
			productionPlan1.setCreateDate(new Date());
			planList.add(productionPlan1);
		}
		if (StringUtils.isNotBlank(node1) && StringUtils.isNotBlank(nodeDate1)) {
			productionPlan2 = new ProductionPlan();
			productionPlan2.setId(IdGen.uuid());
			productionPlan2.setPlanNode(node1);
			productionPlan2.setPlanDate(java.sql.Date.valueOf(nodeDate1));
			productionPlan2.setProjectNo(projectNo);
			productionPlan2.setCreateDate(new Date());
			planList.add(productionPlan2);
		}

		try {

			productionPlanService.addProductionPlanList(planList);

			Project pro = projectService.selectProjectByProjectNo(projectNo);// 查询交期是否存在
			if (pro != null) {
				if (pro.getDeliveryDate() == null) {// 判断交期是否存在，不存在就添加
					if(StringUtils.isNotBlank(scheduledDate)){
						pro.setDeliveryDate(DateUtil.StrToDate(scheduledDate));// 新交期(大货交期)
					}
				}
				if (pro.getActualStartDate() == null) {
					if(StringUtils.isNotBlank(actualStartDate)){
						pro.setActualStartDate(DateUtil.StrToDate(actualStartDate));// 实际开工日期
					}
				}
				if (pro.getSampleScheduledDate() == null) {// 样品交期
					if(StringUtils.isNotBlank(sampleScheduledDate)){
						pro.setSampleScheduledDate(DateUtil.StrToDate(sampleScheduledDate));
					}
				}
			}
			projectService.updateProjectInfo(pro);
	        //ProjectDateTask projectDateTask=new ProjectDateTask();
			List<Project> projectList=new ArrayList<Project>();
			projectList.add(pro);
			projectDateTask.syncProjectDate(projectList);
			jsonResult.setOk(true);
			jsonResult.setMessage("设置成功");
			return jsonResult;
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setOk(false);
			jsonResult.setMessage(e.getMessage());
			LOG.error("error", e);
		} finally {
			return jsonResult;
		}
	}

	/**
	 * 更新项目状态是否交货
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("finally")
	@RequestMapping("/updateProjectStatus")
	@ResponseBody
	public JsonResult updateProjectStatus(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		String projectNo = request.getParameter("projectNo");
		String type=request.getParameter("type");
		try {
			// 1.查询该项目号的项目信息(projectNo)
			Project project = projectService.selectProjctDetails(projectNo);
			if(type.equals("2")){//样品交货
				if (project.getSampleFinish() == 1 ) {
					jsonResult.setOk(false);
					jsonResult.setMessage("该项目样品已经完结 !!!");
					return jsonResult;
				}
				if (project.getSampleScheduledDate() == null) {
					jsonResult.setOk(false);
					jsonResult.setMessage("该项目样品交期还未设置 !!!");
					return jsonResult;
				}
			}else{//大货交货
				if (project.getFinish() == 1 ) {
					jsonResult.setOk(false);
					jsonResult.setMessage("该项目大货已经完结 !!!");
					return jsonResult;
				}
				if (project.getDeliveryDate() == null) {
					jsonResult.setOk(false);
					jsonResult.setMessage("该项目大货交期还未设置 !!!");
					return jsonResult;
				}
			}
			
			// 2.查询该项目所对应任务的状态(0未完成 1已完成)
			List<Task> taskList = taskService.findTaskByProjectNo(projectNo);
			Task task = null;
			if (taskList.size() > 0) {
				for (int i = 0; i < taskList.size(); i++) {
					task = taskList.get(i);
					if (task.getStatus().equals(
							TaskStatusEnum.DEFAULT.getCode())) {// 任务未完成
						jsonResult.setOk(false);
						jsonResult.setMessage("请完成该项目所对应的任务");
						return jsonResult;
					} else {
						if(type.equals("2")){//样品交货
							project.setSampleFinish(1);// 样品项目完成
							project.setFinishTime(new Date());
							projectService.updateProjectInfo(project);
						}else{//大货交货
							project.setFinish(1);// 大货项目完成
							project.setFinishTime(new Date());
							projectService.updateProjectInfo(project);
						}
						jsonResult.setOk(true);
						jsonResult.setMessage("项目完结成功");
						return jsonResult;
					}
				}
			} else {// 该项目没有任务也可以完结交货
				// 项目对应的任务完成，就可以修改项目的状态(完成状态)
				if(type.equals("2")){//样品交货
					project.setSampleFinish(1);// 样品项目完成
					project.setFinishTime(new Date());
					projectService.updateProjectInfo(project);
				}else{//大货交货
					project.setFinish(1);// 大货项目完成
					project.setFinishTime(new Date());
					projectService.updateProjectInfo(project);
				}
				
			}
			//更新状态字段
			//ProjectDateTask projectDateTask=new ProjectDateTask();
			List<Project> projectList=new ArrayList<Project>();
			projectList.add(project);
			projectDateTask.syncProjectDate(projectList);
			jsonResult.setOk(true);
			jsonResult.setMessage("项目没任务可以完结");
			return jsonResult;
		} catch (Exception e) {
			jsonResult.setOk(false);
			jsonResult.setMessage(e.getMessage());
			e.printStackTrace();
			LOG.error("error", e);
		} finally {
			return jsonResult;
		}
	}

	/**
	 * 显示公司所有的项目(可以根据采购进行筛选)
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/showAllList")
	public String showAllList(HttpServletRequest request,
			HttpServletResponse response) {
		String roleNo = request.getParameter("roleNo");
		List<Project> allList = projectService.selectAllProject();
		request.setAttribute("allList", allList);
		request.setAttribute("roleNo", roleNo);
		return "task_allocation";
	}

	/**
	 * 项目相关联的任务
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/projectTask")
	public String projectTask(HttpServletRequest request,
			HttpServletResponse response) {
		String projectNo = request.getParameter("projectNo");
		Integer roleNo = Integer.parseInt(request.getParameter("roleNo"));
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		String userName = request.getParameter("userName");

		// 将消息更新成已读状态
		Task updateTask = new Task();
		updateTask.setType(1);
		updateTask.setProjectNo(projectNo);
		taskService.updateTask(updateTask);

		List<Task> taskList = new ArrayList<Task>();
		Task task = new Task();
		if (roleNo == 100 || roleNo == 99 || roleNo == 98) {// 如果是管理员
			task.setProjectNo(projectNo);
			taskList = taskService.selectTaskList(task);// 任务列表
		} else if (roleNo == 5) {// 销售
			task.setProjectNo(projectNo);
			taskList = taskService.selectTaskByProjectNo(task);
		} else if (roleNo == 6) {// 采购
			task.setProjectNo(projectNo);
			taskList = taskService.selectTaskPurchaseByProjectNo(task);
		}

		request.setAttribute("taskList", taskList);
		request.setAttribute("roleNo", roleNo);
		request.setAttribute("userName", userName);
		request.setAttribute("userId", userId);

		return "task_info";
	}

	/**
	 * 消息中心
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/message")
	@ResponseBody
	public JsonResult projectMessageCenter(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		List<Project> messageList = new ArrayList<Project>();
		Integer roleNo = Integer.parseInt(request.getParameter("roleNo"));
		String userName = request.getParameter("userName");
		Integer userIdS = Integer.parseInt(request.getParameter("userId"));
		int emailUserId = 0;
		int purchaseId = 0;
		int pageNumber;
		if (StringUtils.isNotBlank(request.getParameter("pageNumber"))) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));// 第几页,1,2
		} else {
			pageNumber = 1;
		}
		Integer pageSize = 10;
		Project project = new Project();
		project.setPageSize(pageSize);
		project.setPageNumber(pageSize * (pageNumber - 1));
		List<Project> messageCountList = new ArrayList<Project>();
		try {
			if (roleNo == 100 || roleNo == 99 || roleNo == 98) {// 如果是管理员
				messageList = projectService.selectProjectRelationTask(project);
				messageCountList = projectService
						.selectProjectRelationTaskCount(project);
			} else if (roleNo == 5) {// 销售
				emailUserId = Integer.parseInt(request.getParameter("userId"));
				project.setEmailUserId(emailUserId);
				messageList = projectService.selectProjectRelationTask(project);
				messageCountList = projectService
						.selectProjectRelationTaskCount(project);
			} else if (roleNo == 6) {// 采购
				purchaseId = Integer.parseInt(request.getParameter("userId"));
				project.setPurchaseId(purchaseId);
				messageList = projectService
						.selectPurchaseProjectRelationTask(project);
				messageCountList = projectService
						.selectPurchaseProjectRelationTaskCount(project);
			}
			Map<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("messageList", messageList);
			hashMap.put("userId", userIdS);
			hashMap.put("roleNo", roleNo);
			hashMap.put("userName", userName);
			hashMap.put("pageSize", pageSize);
			hashMap.put("pageNumber", pageNumber);
			hashMap.put("totalCount", messageCountList.size());
			jsonResult.setData(hashMap);
			jsonResult.setOk(true);
		} catch (NumberFormatException e) {
			jsonResult.setMessage(e.getMessage());
			jsonResult.setOk(false);
			e.printStackTrace();
			LOG.error("error", e);
		}
		return jsonResult;
	}

	/**
	 * 统计两周内交期变更的项目
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/projectStatistics")
	@ResponseBody
	public JsonResult statisticsAllList(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		String start = request.getParameter("startDate");
		String end = request.getParameter("endDate");
		String value = request.getParameter("value");
		Date startDate = null;
		Date endDate = null;
		if (StringUtils.isNotBlank(start)) {
			startDate = DateUtil.StrToDate(start);
		} else {
			startDate = DateUtil.StrToDate(DateUtil.getTwoWeeksDate());// 得到前两周的时间(默认)
		}
		if (StringUtils.isNotBlank(end)) {
			endDate = DateUtil.StrToDate(end);
		} else {
			endDate = new Date();// 结束时间
		}
		int roleNo = Integer.parseInt(request.getParameter("roleNo")); // 判断是否是管理员
		Project project = new Project();
		List<Project> list = new ArrayList<Project>();
		try {
			if (value.equals("1")) { // 统计交期变更项目
				if (roleNo == 100 || roleNo == 99 || roleNo == 98) {// 判断是否是管理员
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					list = projectService.findDelayProjectList(project);
				} else if (roleNo == 5) {// 销售
					Integer emailUserId = Integer.parseInt(request
							.getParameter("userId"));// 拿到用户的userId
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					project.setEmailUserId(emailUserId);
					list = projectService.findDelayProjectList(project);
				} else if (roleNo == 6) {// 采购
					Integer purchaseId = Integer.parseInt(request
							.getParameter("userId"));// 拿到用户的userId
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					project.setPurchaseId(purchaseId);
					list = projectService.findDelayProjectPurchaseList(project);
				}
			} else if (value.equals("2")) {// 统计采购情况汇报
				if (roleNo == 100 || roleNo == 99 || roleNo == 98) {// 判断是否是管理员
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					list = projectService.findProjectReportList(project);
				} else if (roleNo == 5) {// 销售
					Integer emailUserId = Integer.parseInt(request
							.getParameter("userId"));// 拿到用户的userId
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					project.setEmailUserId(emailUserId);
					list = projectService.findProjectReportList(project);
				} else if (roleNo == 6) {// 采购
					Integer purchaseId = Integer.parseInt(request
							.getParameter("userId"));// 拿到用户的userId
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					project.setPurchaseId(purchaseId);
					list = projectService
							.findProjectReportPurchaseList(project);
				}
			} else if (value.equals("3")) {// 统计未设定实际交期项目
				if (roleNo == 100 || roleNo == 99 || roleNo == 98) {// 判断是否是管理员
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					list = projectService.findSetDeliveryTimeList(project);
				} else if (roleNo == 5) {// 销售
					Integer emailUserId = Integer.parseInt(request
							.getParameter("userId"));// 拿到用户的userId
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					project.setEmailUserId(emailUserId);
					list = projectService.findSetDeliveryTimeList(project);
				} else if (roleNo == 6) {// 采购
					Integer purchaseId = Integer.parseInt(request
							.getParameter("userId"));// 拿到用户的userId
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					project.setPurchaseId(purchaseId);
					list = projectService
							.findSetDeliveryTimePurchaseList(project);
				}
			} else if (value.equals("4")) {// 统计出货延期项目
				if (roleNo == 100 || roleNo == 99 || roleNo == 98) {// 判断是否是管理员
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					list = projectService.findProjectDelayCountList(project);
				} else if (roleNo == 5) {// 销售
					Integer emailUserId = Integer.parseInt(request
							.getParameter("userId"));// 拿到用户的userId
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					project.setEmailUserId(emailUserId);
					list = projectService.findProjectDelayCountList(project);
				} else if (roleNo == 6) {// 采购
					Integer purchaseId = Integer.parseInt(request
							.getParameter("userId"));// 拿到用户的userId
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					project.setPurchaseId(purchaseId);
					list = projectService
							.findProjectDelayPurchaseCountList(project);
				}
			} else if (value.equals("5")) {// 统计缺少开工图片项目
				if (roleNo == 100 || roleNo == 99 || roleNo == 98) {// 判断是否是管理员
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					list = projectService.findProjectReportNoPicList(project);
				} else if (roleNo == 5) {// 销售
					Integer emailUserId = Integer.parseInt(request
							.getParameter("userId"));// 拿到用户的userId
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					project.setEmailUserId(emailUserId);
					list = projectService.findProjectReportNoPicList(project);
				} else if (roleNo == 6) {// 采购
					Integer purchaseId = Integer.parseInt(request
							.getParameter("userId"));// 拿到用户的userId
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					project.setPurchaseId(purchaseId);
					list = projectService
							.findProjectReportNoPicPurchaseList(project);
				}
			} else {// 统计缺少任务汇报的项目
				if (roleNo == 100 || roleNo == 99 || roleNo == 98) {// 判断是否是管理员
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					List<Project> taskReportList = projectService
							.findProjectNoTaskReportList(project); // 有任务汇报的项目
					List<Project> allList = projectService
							.findProjectList(project); // 得到所有的项目
					list = getDiffrent(allList, taskReportList); // 对比得到没有任务汇报的项目
				} else if (roleNo == 5) {// 销售
					Integer emailUserId = Integer.parseInt(request
							.getParameter("userId"));// 拿到用户的userId
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					project.setEmailUserId(emailUserId);
					List<Project> taskReportList = projectService
							.findProjectNoTaskReportList(project); // 有任务汇报的项目
					List<Project> allList = projectService
							.findProjectList(project); // 得到该采购所有的项目
					if (taskReportList.size() > 0) {
						list = getDiffrent(allList, taskReportList); // 对比得到没有任务汇报的项目
					} else {
						list = allList;
					}
				} else if (roleNo == 6) {// 采购
					Integer purchaseId = Integer.parseInt(request
							.getParameter("userId"));// 拿到用户的userId
					project.setStartDate(startDate);
					project.setEndDate(endDate);
					project.setPurchaseId(purchaseId);
					List<Project> taskReportList = projectService
							.findProjectNoTaskReportPurchaseList(project); // 有任务汇报的项目
					List<Project> allList = projectService
							.findPurchaseProjectList(project); // 得到该采购所有的项目
					if (taskReportList.size() > 0) {
						list = getDiffrent(allList, taskReportList); // 对比得到没有任务汇报的项目
					} else {
						list = allList;
					}
				}
			}
			jsonResult.setOk(true);
			jsonResult.setData(list);
			jsonResult.setComment(String.valueOf(roleNo));
		} catch (NumberFormatException e) {
			jsonResult.setOk(false);
			jsonResult.setData(e.getMessage());
			e.printStackTrace();
			LOG.error("error", e);
		}
		return jsonResult;
	}

	/**
	 * 对比两个list集合 重新得到一个新的集合
	 * 
	 * @param allProjectList
	 * @param taskReporProjecttList
	 * @return
	 */
	private static List<Project> getDiffrent(List<Project> allProjectList,
			List<Project> taskReporProjecttList) {
		List<Project> list = new ArrayList<Project>();
		for (int i = 0; i < allProjectList.size(); i++) {
			Project allProject = allProjectList.get(i);
			Project project = null;
			boolean bool = false;
			for (int j = 0; j < taskReporProjecttList.size(); j++) {
				project = taskReporProjecttList.get(j);
				// 项目号匹配成功不做任何操作
				if (allProject.getProjectNo().equals(project.getProjectNo())) {
					bool = true;
					break;
				}
			}
			// 项目号匹配不成功,将不匹配的项目号添加到项目表里面
			if (!bool) {
				list.add(allProject);
			}
		}
		return list;
	}

	/**
	 * 文件下载
	 * 
	 * @param request
	 * @param response
	 * @param fileUrl
	 * @throws Exception
	 */
	@RequestMapping(value = "/download")
	public void download(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("fileUrl") String fileUrl) throws Exception {
		String filename = "/usr/local/apache-tomcat-7.0.72/webapps/uploadimg/"
				+ fileUrl;
		// 设置文件MIME类型
		response.setContentType(request.getServletContext().getMimeType(
				filename));
		// 设置Content-Disposition
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);
		// 读取目标文件，通过response将目标文件写到客户端
		// 获取目标文件的绝对路径
		// 读取文件
		InputStream in = new FileInputStream(fileUrl);
		OutputStream out = response.getOutputStream();
		// 写文件
		int b;
		while ((b = in.read()) != -1) {
			out.write(b);
		}
		in.close();
		out.close();
	}

	@RequestMapping("/projectComment")
	@ResponseBody
	public JsonResult projectComment(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		String userName = request.getParameter("userName");
		String projectNo = request.getParameter("projectNo");
		String comment = request.getParameter("comment");
		Comment insertComment = new Comment();
		insertComment.setId(IdGen.uuid());
		insertComment.setReviewer(userName);
		insertComment.setProjectNo(projectNo);
		insertComment.setComment(comment);
		insertComment.setCreateDate(new Date());
		try {
			projectCommentService.addProjetcComment(insertComment);
			jsonResult.setOk(true);
			jsonResult.setMessage("留言成功");
		} catch (Exception e) {
			jsonResult.setOk(false);
			jsonResult.setMessage("留言失败");
			e.printStackTrace();
			LOG.error("error", e);
		}
		return jsonResult;
	}

	/**
	 * 暂停启动项目
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/pauseProject")
	@ResponseBody
	public JsonResult pauseProject(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();
		String projectNo = request.getParameter("projectNo");
		String checked = request.getParameter("checked");
		String pauseReason = request.getParameter("pauseReason");
		Project project = new Project();
		project.setProjectNo(projectNo);
		project.setIsPause(checked);
		project.setPauseReason(pauseReason);
		if(StringUtils.isNoneBlank(checked)){
			if(checked.equals("0")){
			    project.setFinish(0);
			}
		}
		try {
			projectService.updateProjectInfo(project);
			//更新状态字段
			//ProjectDateTask projectDateTask=new ProjectDateTask();
			List<Project> projectList=new ArrayList<Project>();
			projectList.add(project);
			projectDateTask.syncProjectDate(projectList);
			jsonResult.setOk(true);
			jsonResult.setMessage("操作成功");
		} catch (Exception e) {
			jsonResult.setOk(false);
			jsonResult.setMessage("操作失败");
			e.printStackTrace();
			LOG.error("error", e);
		}
		return jsonResult;
	}

	/*
	 * 查询所有质检、采购、跟单人员
	 */
	@RequestMapping("/queryStaff")
	@ResponseBody
	public JsonResult queryStaff(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();

		try {

			Map<String, List<User>> map = new HashMap<String, List<User>>();

			User user = userService.selectUserByName("ThomasChen");
			// 采购
			List<User> purchaseList = userService.selectUserByType(6);

			// 跟单&销售
			List<User> saleList = userService.selectUserByType(5);
			saleList.add(user);
			// 质检
			List<User> qualityTestList = userService.selectUserByType(9);
			qualityTestList.add(user);

			map.put("purchase", purchaseList);
			map.put("sale", saleList);
			map.put("quality", qualityTestList);

			jsonResult.setData(map);
			jsonResult.setOk(true);
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setMessage(e.getMessage());
			jsonResult.setOk(false);
			LOG.error("error", e);

		}

		return jsonResult;
	}

	/**
	 * 查询项目详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/queryListPc")
	public String queryListPc(HttpServletRequest request,
			HttpServletResponse response) {

		String roleNo = request.getParameter("roleNo");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
        String pageNumberStr=request.getParameter("pageNumber");
        int pageNumber=1;
        if (StringUtils.isNotBlank(pageNumberStr)) {
			pageNumber = Integer.parseInt(pageNumberStr);// 第几页,1,2
		}
        String pcType="1";
		request.setAttribute("roleNo", roleNo);
		request.setAttribute("userId", userId);
		request.setAttribute("userName", userName);
		request.setAttribute("pageNumber",pageNumber);
		request.setAttribute("pcType", pcType);
		return "project_list_pc";
	}

	/*
	 * 
	 * 修改项目金额
	 */
	/*
	 * 查询所有质检、采购、跟单人员
	 */
	@RequestMapping("/editAmout")
	@ResponseBody
	public JsonResult editAmout(HttpServletRequest request,
			HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult();

		try {
			String projectNo = request.getParameter("projectNo");
			String projectAmout = request.getParameter("projectAmout");
			Project project = new Project();
			project.setProjectNo(projectNo);
			project.setProjectAmount(projectAmout);
			projectService.updateProjectInfo(project);
			jsonResult.setOk(true);
			jsonResult.setMessage("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setMessage(e.getMessage());
			jsonResult.setOk(false);
			LOG.error("error", e);
		}

		return jsonResult;
	}
	
	/**
	 * 添加产品图
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadProductFile",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addFactoryFile(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 String productImgName = request.getParameter("productImg");
		 String projectImgNo=request.getParameter("projectImgNo");
		 String path = UploadAndDownloadPathUtil.getProductImg();
		 File file = new File(path);
		 if  (!file.exists()  && !file .isDirectory())       {         
				file .mkdir();     
		 }  	
		 //调用保存文件的帮助类进行保存文件(文件上传，form表单提交)
		try {
			Map<String, String> multiFileUpload = OperationFileUtil.multiFileUpload(request, path+File.separator);
			String fileName = multiFileUpload.get(productImgName);
			Project project=new Project();
			project.setProjectNo(projectImgNo);
			project.setProductImg(fileName);
			projectService.updateProjectInfo(project);
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * 姜工同意延期
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/agreeDelayApply")
	@ResponseBody
	public JsonResult agreeDelayApply(HttpServletRequest request,HttpServletResponse response) throws Exception{
		   JsonResult jsonResult = new JsonResult();
		try {
			String projectNo = request.getParameter("projectNo");
			String type=request.getParameter("type");
			Project project=projectService.selectProjectByProjectNo(projectNo);
			Delay delay=delayService.selectApplyDelayByProjectNo(projectNo);
			if(type.equals("1")){//同意延期
				//1.判断延期哪个交期
				if(project.getDeliveryDate()!=null && project.getSampleScheduledDate()==null){
					project.setDeliveryDate(delay.getDelayDate());
				}
				if(project.getSampleScheduledDate()!=null && project.getDeliveryDate()==null){
					project.setSampleScheduledDate(delay.getDelayDate());
				}
				if(project.getSampleScheduledDate()!=null && project.getDeliveryDate()!=null){
					if(project.getSampleScheduledDate().getTime()>project.getDeliveryDate().getTime()){
						project.setSampleScheduledDate(delay.getDelayDate());
					}else{
						project.setDeliveryDate(delay.getDelayDate());
					}
				}
				project.setProjectNo(projectNo);		
				projectService.updateProjectInfo(project);
			}else if(type.equals("2")){//不同意延期
				
			}
			
			delay.setIsAgree(1);
			delayService.updateDelayFlagByProjectNo(delay);
			List<Project> projectList=new ArrayList<Project>();
			projectList.add(project);
			projectDateTask.syncProjectDate(projectList);
			jsonResult.setOk(true);
			jsonResult.setMessage("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setMessage(e.getMessage());
			jsonResult.setOk(false);
			LOG.error("error", e);
		}
		return jsonResult;
	}
	
	
	/**
	 * 添加技术指导
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addProjectTechnology")
	@ResponseBody
	public JsonResult addProjectTechnology(HttpServletRequest request,HttpServletResponse response) throws Exception{
		   JsonResult jsonResult = new JsonResult();
		try {
			String projectNo = request.getParameter("projectNo");		
			String technology=request.getParameter("technology");
			Project project=new Project();
			project.setProjectNo(projectNo);
			project.setTechnology(technology);
			projectService.updateProjectInfo(project);
			jsonResult.setOk(true);
			jsonResult.setMessage("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setMessage(e.getMessage());
			jsonResult.setOk(false);
			LOG.error("error", e);
		}
		return jsonResult;
	}
}
