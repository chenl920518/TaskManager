package com.cn.hnust.controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.enums.TaskStatusEnum;
import com.cn.hnust.pojo.Task;
import com.cn.hnust.pojo.TaskReport;
import com.cn.hnust.service.ITaskReportService;
import com.cn.hnust.service.ITaskService;
import com.cn.hnust.util.IdGen;
import com.cn.hnust.util.JsonResult;

/***
 * 任务 Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private ITaskService taskService;
	@Autowired 
	private ITaskReportService  taskReportService;
	/**
	 * 发布部署任务
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addTask")
	@ResponseBody
	public JsonResult  addTask(HttpServletRequest request,HttpServletResponse response) {
		JsonResult JsonResult=new JsonResult();
		String projectNo =request.getParameter("projectNo");
		String taskDemand=request.getParameter("taskDemand");
		int node=Integer.parseInt(request.getParameter("node"));
		String endDate=request.getParameter("endDate");
		String operator=request.getParameter("userName");
		Task task=new Task();
		task.setId(IdGen.uuid());
		task.setProjectNo(projectNo);
		task.setTaskDemand(taskDemand);
		task.setNode(node);
		task.setStatus(0);
		task.setOperator(operator);
		task.setEndDate(java.sql.Date.valueOf(endDate));
		task.setCreateDate(new Date());
		try {
			taskService.addTask(task);
			JsonResult.setOk(true);
			JsonResult.setMessage("布置任务成功");
		} catch (Exception e) {
			JsonResult.setOk(false);
			JsonResult.setMessage("布置任务失败");
			e.printStackTrace();
		}
		return JsonResult;
	}
	/**
	 * 更新任务状态(重启任务，完成任务)
	 * @param request
	 * @param response
	 * @return
	 */
    @RequestMapping("/updateTask")
    @ResponseBody
	public JsonResult updateTask(HttpServletRequest request,HttpServletResponse response){
		JsonResult jsonResult=new JsonResult();
		String taskId=request.getParameter("taskId");
		Integer flag=Integer.parseInt(request.getParameter("flag"));//判断是完成任务,还是重启任务
		Task task=new Task();
		task.setId(taskId);
		if(flag==1){
			task.setStatus(TaskStatusEnum.FINISH.getCode());//任务完成,将任务状态更新为完成
		}else{
			task.setStatus(TaskStatusEnum.DEFAULT.getCode());//任务重启,将任务状态更新为未完成
		}
		try {
			taskService.updateTask(task);
			jsonResult.setOk(true);
			jsonResult.setMessage("更新成功");
		} catch (Exception e) {
			jsonResult.setOk(false);
			jsonResult.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return jsonResult;
	}
    
    /***
     * 显示所有部署的任务
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/showAllTask")
    public String showAllTask(HttpServletRequest request,HttpServletResponse response){
    	List<Task> taskList=taskService.selectAllTask(null); 
    	request.setAttribute("taskList", taskList);
		return "task_list";
    } 
    /**
     * 根据任务ID查询任务详情
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/taskDetails")
    public String taskDetails(HttpServletRequest request,HttpServletResponse response){
    	String id=request.getParameter("id");
    	String projectNo=request.getParameter("projectNo");
    	String roleNo=request.getParameter("roleNo");
    	String userId=request.getParameter("userId");
    	String userName=request.getParameter("userName");
    	Task task=null;
    	if(roleNo.equals("5")){//销售
    		 task=taskService.selectTaskById(id);
    	}else if(roleNo.equals("6")){//采购
    		 task=taskService.selectTaskPurchaseById(id);
    	}else{//管理员
    		 task=taskService.selectTaskById(id);
    	}
    	List<TaskReport> reportList=taskReportService.selectTaskReportByNo(id);
    	if(reportList.size()>0){
    		task.setTaskReportList(reportList);
    	}    	
    	request.setAttribute("task", task);
    	request.setAttribute("roleNo",roleNo);
    	request.setAttribute("userId",userId);
    	request.setAttribute("userName",userName);
		return "task_detail";
    }
    /***
     * 根据任务id删除任务
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/delTask")
    @ResponseBody
    public JsonResult delTask(HttpServletRequest request,HttpServletResponse response){
    	JsonResult jsonResult=new JsonResult();
		String id=request.getParameter("taskId");
		try {
			taskService.delTaskById(id);//删除任务
			taskReportService.delTaskReport(id);//删除任务汇报
			jsonResult.setOk(true);
			jsonResult.setMessage("删除成功");
		} catch (Exception e) {
			jsonResult.setOk(false);
			jsonResult.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return jsonResult;
    }
}
