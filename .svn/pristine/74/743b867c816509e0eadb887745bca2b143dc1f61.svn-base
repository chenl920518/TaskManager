	package com.cn.hnust.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.component.RpcHelper;
import com.cn.hnust.pojo.ProjectTask;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IProjectTaskService;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.util.DateUtil;
import com.cn.hnust.util.JsonResult;

@Controller
@RequestMapping("/projectTask")
public class ProjectTaskController {

	@Autowired
	private IProjectTaskService projectTaskService;
	
	@Autowired
	private IUserService userService;
	

	/**
	 * 项目任务列表
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
    @RequestMapping("/projectTaskList")
    public String projectTaskList(HttpServletRequest request,HttpServletResponse response) throws ParseException{
    	String searchName=request.getParameter("searchName");
    	String taskStatus=request.getParameter("taskStatus");
    	String projectNo=request.getParameter("projectNo");
    	String userName=request.getParameter("userName");
    	String userId=request.getParameter("userId");
    	String roleNo=request.getParameter("roleNo");
    	String sendOrReceive =request.getParameter("sendOrReceive");
    	
    	int sendOrRe = 0;
    	if(StringUtils.isNotBlank(sendOrReceive)){
    		sendOrRe = Integer.parseInt(sendOrReceive);
    		
    	}
    	
    	Cookie[] cookies = request.getCookies();
  	     if(cookies!=null){
  	     for(Cookie c :cookies ){
           if(c.getName().equals("name")){
          	userName=c.getValue();
           }
  	     }
  	    }
  	    if(StringUtils.isNotBlank(taskStatus)){
  	    	taskStatus=request.getParameter("taskStatus");
  	    }else{
  	    	taskStatus="0";
  	    }
    	ProjectTask projectTask=new ProjectTask();
    	projectTask.setProjectNo(projectNo);
    	projectTask.setSendOrReceive(sendOrRe);
    	projectTask.setTaskStatus(taskStatus);
    	projectTask.setSearchName(searchName);
    	projectTask.setUserName(userName);
    	int pageNumber;
		if(StringUtils.isNotBlank(request.getParameter("pageNumber"))){
			pageNumber=Integer.parseInt(request.getParameter("pageNumber"));//第几页,1,2
		}else{
			pageNumber=1;
		}
		Integer pageSize=10;
		projectTask.setPageSize(pageSize);
		projectTask.setPageNumber(pageSize*(pageNumber-1));
		User user=userService.selectUserByName(userName);
		List<ProjectTask> projectTaskList=new ArrayList<ProjectTask>();
		Integer totalCount=0;
		if(user.getRoleNo()==100||user.getRoleNo()==99||user.getRoleNo()==98||user.getRoleNo()==97){
			if(sendOrRe==0){
				projectTask.setUserName(null);
			}
			projectTaskList=projectTaskService.selectProjectTask(projectTask);
			totalCount = projectTaskService.selectProjectTaskCount(projectTask).size();//查询记录条数
			
		}else{
		    projectTaskList=projectTaskService.selectProjectTask(projectTask);
		    totalCount = projectTaskService.selectProjectTaskCount(projectTask).size();//查询记录条数
		}
		
	    //标记任务状态
	    for (int i = 0; i < projectTaskList.size(); i++) {
	    	ProjectTask taskFlag=projectTaskList.get(i);
	    	Date nowDate=new Date();  //今天
	    	Date finishTime=taskFlag.getFinishTime(); //要求完成时间
	    	Date expectFinishTime=taskFlag.getExpectFinishTime();//预计完成时间
	    	if(expectFinishTime!=null){//如果预计完成时间不为空
	    		if(finishTime.getTime()>expectFinishTime.getTime() &&taskFlag.getTaskStatus().equals(0)){ //今天 > MAX（预计完成时间，要求完成时间）
		    		if(nowDate.getTime()>finishTime.getTime()){
		    			taskFlag.setTaskFlag("1");//不正常
		    		}else{
		    			taskFlag.setTaskFlag("0");//正常
		    		}
		    	}else{
		    		if(nowDate.getTime()>expectFinishTime.getTime()&& taskFlag.getTaskStatus().equals(0)){
		    			taskFlag.setTaskFlag("1");//不正常
		    		}else{
		    			taskFlag.setTaskFlag("0");//正常
		    		}
		    	}
	    	}else{
	    		if(nowDate.getTime()>finishTime.getTime() && taskFlag.getTaskStatus().equals(0)){
	    			taskFlag.setTaskFlag("1");//不正常
	    		}else{
	    			taskFlag.setTaskFlag("0");//正常
	    		}
	    	 }
		   }
	   
    	    String finishRatio=""; 
    	    //3另计算及时完成率  （公式是最近 90天 按时所有完成的项目/所有完成的项目)
			float ratio=0;
			int onTimeFinish=projectTaskService.statisticsProjectTaskOnTime(userName).size();
			int allFinish=projectTaskService.statisticsProjectTaskAllFinish(userName).size();
			
			//任务平均用时   按时完成任务用时
			if(allFinish!=0){
				if(onTimeFinish==0){
					ratio=0;
				}else{
					ratio=(float)onTimeFinish/(float)allFinish;
				}
			}else{
				ratio=0;
			}
			
			finishRatio=String.valueOf(ratio*100)+'%';
			//计算所有任务完成的总时间/任务完成的个数  =平均按时完成用时
			int totalHours=0;//任务完成的总用时
			float averageHours=0;
			
			
			List<ProjectTask> allFinishList=projectTaskService.statisticsProjectTaskAllFinish(userName);
			for (int j = 0; j < allFinishList.size(); j++) {
				ProjectTask allFinishTask=allFinishList.get(j);
				SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			    String currentDate = simpleFormat.format(allFinishTask.getOperatorTime());  
			    String publishDate = simpleFormat.format(allFinishTask.getCreateTime());  
			    long from = simpleFormat.parse(currentDate).getTime();  
			    long to = simpleFormat.parse(publishDate).getTime();  
			    totalHours += (int) ((from - to)/(1000 * 60 * 60));  
			}
			if(totalHours!=0 && allFinish!=0){
				averageHours=(totalHours*1.0F)/(allFinish);
			}else{
				averageHours=0;
			}
			
			
			//目前 拖得最长的任务 已经几天了（从目标完成日算起）
			float maxDate=0;
			ProjectTask maxTask=projectTaskService.selectProjectTaskMaxDate(userName);
			if(maxTask!=null){
				if(maxTask.getFinishTime().getTime()<new Date().getTime()){
					int hours = (int) ((new Date().getTime() - maxTask.getFinishTime().getTime()) / (1000*3600));
					maxDate=(hours*1.0F)/24;
				}else{
					maxDate=0;
				}
			
				
			}
		    int countPage = 0;
			if(totalCount!=null){
				 countPage=(totalCount-1)/10+1;
			}
			request.setAttribute("sendOrReceive",sendOrReceive);
			request.setAttribute("maxDate", maxDate);
			request.setAttribute("averageHours",averageHours);
			request.setAttribute("finishRatio", finishRatio);
			request.setAttribute("searchName",searchName);
			request.setAttribute("roleNo", roleNo);
		    request.setAttribute("userName", userName);
		    request.setAttribute("userId", userId);
		    request.setAttribute("pageSize", pageSize);
		    request.setAttribute("pageNumber", pageNumber);
		    request.setAttribute("totalCount", totalCount);
		    request.setAttribute("countPage", countPage);
		    request.setAttribute("projectTaskList", projectTaskList);
		    request.setAttribute("taskStatus",taskStatus);
		    request.setAttribute("searchProjectNo", projectNo);
			return "project_task";	
    }
    /**
     * 录入任务信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/addProjectTask")
    @ResponseBody
    public JsonResult addProjectTask(HttpServletRequest request,HttpServletResponse response){
    	JsonResult jsonResult=new JsonResult();
    	String projectNo=request.getParameter("projectNo");
    	String initiator=request.getParameter("initiator");
    	String accepter=request.getParameter("accepter");
    	String description=request.getParameter("description");
    	String finishTime=request.getParameter("finishTime");
    	String urgentReason=request.getParameter("urgentReason");
    	ProjectTask projectTask=new ProjectTask();
    	projectTask.setProjectNo(projectNo);
    	projectTask.setInitiator(initiator);
    	projectTask.setAccepter(accepter);
    	projectTask.setDescription(description);
    	projectTask.setUrgentReason(urgentReason);
    	projectTask.setFinishTime(DateUtil.StrToDate(finishTime));
    	projectTask.setTaskStatus("0");
    	projectTask.setTaskType("0");
    	projectTask.setStartTime(new Date());
    	projectTask.setCreateTime(new Date());
    	try {
			projectTaskService.addProjectTask(projectTask);
			jsonResult.setOk(true);
			jsonResult.setData("录入成功");
			RpcHelper.sendRequest("",projectTask);
			
			
		} catch (Exception e) {
			jsonResult.setOk(false);
			jsonResult.setData("录入失败");
			e.printStackTrace();
		}
		return jsonResult;
    }
    /**
     * 根据任务Id查询详情
     * @param request
     * @param response
     * @return
     * @throws IOException 
     */
    @RequestMapping("/selectProjectTaskById")
    public String selectProjectTaskById(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	 String userName=request.getParameter("userName");
    	 String userId=request.getParameter("userId");
    	 String roleNo=request.getParameter("roleNo");
    	 Cookie[] cookies = request.getCookies();
  	     if(cookies!=null){
  	     for(Cookie c :cookies ){
           if(c.getName().equals("name")){
          	userName=c.getValue();
           }
  	     }
  	    }
  	    if(StringUtils.isBlank(userName)){
  	    	response.sendRedirect("/test/index.jsp");
        	return null;
  	    }
    	String id=request.getParameter("id");
    	ProjectTask projectTask=projectTaskService.selectProjectTaskById(Integer.parseInt(id));
    	request.setAttribute("projectTask",projectTask);
		request.setAttribute("roleNo", roleNo);
	    request.setAttribute("userName", userName);
	    request.setAttribute("userId", userId);
		return "project_task_details";
    }
    /**
     * 更新任务状态
     * @param request
     * @param response
     * @return
     */
    /*SangCaiZheng*/
    @RequestMapping("/updateProjectTask")
    @ResponseBody
    public JsonResult updateProjectTask(HttpServletRequest request,HttpServletResponse response){
	  JsonResult jsonResult=new JsonResult();
	  String projectTaskId=request.getParameter("projectTaskId");
	  String taskStatus=request.getParameter("taskStatus");
	  String userName=request.getParameter("userName");
	  String operateExplain=request.getParameter("operateExplain");
	  Cookie[] cookies = request.getCookies();
	  if(cookies!=null){
	   for(Cookie c :cookies ){
         if(c.getName().equals("name")){
        	userName=c.getValue();
         }
	   }
	  }
	  if(StringUtils.isNotBlank(userName)){
		  userName=request.getParameter("userName"); 
	  }
      ProjectTask projectTask=projectTaskService.selectProjectTaskById(Integer.parseInt(projectTaskId));
      
      projectTask.setTaskStatus(taskStatus);
      projectTask.setOperator(userName);
      projectTask.setOperatorTime(new Date());
	  projectTask.setOperateExplain(operateExplain);
      
      try {
	//	projectTaskService.updateProjectTask(projectTask);
    	
    	projectTaskService.checkNextTask(projectTask);
    	  
    	 
		jsonResult.setOk(true);
		jsonResult.setMessage("操作成功");

		RpcHelper.sendRequest("",projectTask);
		
	} catch (Exception e) {
		jsonResult.setOk(false);
		jsonResult.setMessage("操作失败");
		e.printStackTrace();
	}
	  return jsonResult;
    }
    
    
    /**
     * 更新任务状态
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/updateExpectFinishTime")
    @ResponseBody
    public JsonResult updateExpectFinishTime(HttpServletRequest request,HttpServletResponse response){
	  JsonResult jsonResult=new JsonResult();
	  String projectTaskId=request.getParameter("id");
	  String userName=request.getParameter("userName");
	  String expectFinishTime=request.getParameter("expectFinishTime");
	  Cookie[] cookies = request.getCookies();
	  if(cookies!=null){
	   for(Cookie c :cookies ){
         if(c.getName().equals("name")){
        	userName=c.getValue();
         }
	   }
	  }
	  if(StringUtils.isNotBlank(userName)){
		  userName=request.getParameter("userName"); 
	  }
      ProjectTask projectTask=new ProjectTask();
      projectTask.setId(Integer.parseInt(projectTaskId));
      projectTask.setExpectFinishTime(DateUtil.StrToDate(expectFinishTime));
      try {
		projectTaskService.updateProjectTask(projectTask);
		
		jsonResult.setOk(true);
		jsonResult.setMessage("操作成功");
		RpcHelper.sendRequest("",projectTask);
	} catch (Exception e) {
		jsonResult.setOk(false);
		jsonResult.setMessage("操作失败");
		e.printStackTrace();
	}
	  return jsonResult;
    }
    
    @RequestMapping("/statisticsProjectTask")
    public String statisticsProjectTask(HttpServletRequest request,HttpServletResponse response) throws ParseException{
    	List<ProjectTask> noFinishList=new ArrayList<ProjectTask>();
    	List<ProjectTask> finishList=new ArrayList<ProjectTask>();
    	List<User> userList=userService.selectAllUser();
    	for (int i = 0; i < userList.size(); i++) {
    		User user=userList.get(i);
    		ProjectTask searchTask=new ProjectTask();
    		searchTask.setAccepter(user.getUserName());
    		List<ProjectTask>existList=projectTaskService.selectProjectTaskIfExist(searchTask);
			if(null == existList || existList.size() ==0 ){
				continue;
			}
			//1.每个人的未完成数量
			List<ProjectTask> noFinishCountList=projectTaskService.statisticsProjectTaskNoFinish(searchTask);
    		ProjectTask noFinish=new ProjectTask();
    		noFinish.setAccepter(user.getUserName());
    		noFinish.setNoFinishCount(noFinishCountList.size());
    		noFinishList.add(noFinish);
        	//2.统计最近30天的完成数量
    		List<ProjectTask> finishCountList=projectTaskService.statisticsProjectTaskFinish(searchTask);
        	ProjectTask finish=new ProjectTask();
        	finish.setAccepter(user.getUserName());
        	finish.setFinishCount(finishCountList.size());
    		finishList.add(finish);
		}
    	
    	List<ProjectTask> onTimeList=new ArrayList<ProjectTask>();
    	String finishRatio=""; 
    	//3另计算及时完成率  （公式是最近 90天 按时所有完成的项目/所有完成的项目） 任务平均用时
    	//4.existList
    	List<ProjectTask> existList=new ArrayList<ProjectTask>();
    	for (int i = 0; i < userList.size(); i++) {
			User user=userList.get(i);
			ProjectTask projectTask=new ProjectTask();
			float ratio=0;
			projectTask.setAccepter(user.getUserName());
			existList=projectTaskService.selectProjectTaskIfExist(projectTask);
			if(null == existList || existList.size() ==0 ){
				continue;
			}
			int onTimeFinish=projectTaskService.statisticsProjectTaskOnTime(user.getUserName()).size();
			int allFinish=projectTaskService.statisticsProjectTaskAllFinish(user.getUserName()).size();
			
			//计算完成的总时间/任务完成的个数  =平均按时完成用时(及时完成率)
			int totalHours=0;//任务完成的总用时
			float averageHours=0;
			DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
			List<ProjectTask> onTimeTaskList=projectTaskService.statisticsProjectTaskOnTime(user.getUserName());
			for (int j = 0; j < onTimeTaskList.size(); j++) {
				ProjectTask onTimeTask=onTimeTaskList.get(j);
				SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			    String currentDate = simpleFormat.format(onTimeTask.getOperatorTime());  
			    String publishDate = simpleFormat.format(onTimeTask.getCreateTime());  
			    long from = simpleFormat.parse(currentDate).getTime();  
			    long to = simpleFormat.parse(publishDate).getTime();  
			    totalHours += (int) ((from - to)/(1000 * 60 * 60));  
			}
			if(onTimeFinish!=0){
				averageHours=(totalHours*1.0F)/(onTimeFinish);	
			}
			//任务平均用时   按时完成任务用时
			if(allFinish!=0){
				if(onTimeFinish==0){
					ratio=0;
				}else{
					ratio=(float)onTimeFinish/(float)allFinish;
				}
			}else{
				ratio=0;
			}
			finishRatio=String.valueOf(Float.parseFloat(decimalFormat.format(ratio))*100)+'%';
			projectTask.setAccepter(user.getUserName());
			projectTask.setOnTimeFinish(onTimeFinish);
			projectTask.setAllFinish(allFinish);
			projectTask.setFinishRatio(finishRatio);
			
			projectTask.setAverageHours(Float.parseFloat(decimalFormat.format(averageHours)));
			onTimeList.add(projectTask);
		}
    	
    	//4.统计会议相关会完成的任务数量
    	List<ProjectTask> meetingRecordList=new ArrayList<ProjectTask>();
    	for (int i = 0; i < userList.size(); i++) {
			User user=userList.get(i);
			ProjectTask existTask=new ProjectTask();
			existTask.setAccepter(user.getUserName());
			existTask.setTaskType("1");
			existList=projectTaskService.selectProjectTaskIfExist(existTask);
			if(null == existList || existList.size() ==0 ){
				continue;
			}
			int meetingTaskNum=projectTaskService.selectMeetingRecordTaskNoFinish(user.getUserName()).size();
			ProjectTask projectTask=new ProjectTask();
			projectTask.setAccepter(user.getUserName());
		    projectTask.setMeetingTaskNum(meetingTaskNum);
		    meetingRecordList.add(projectTask);
		}
    	request.setAttribute("meetingRecordList", meetingRecordList);
    	request.setAttribute("noFinishList", noFinishList);
    	request.setAttribute("finishList", finishList);
    	request.setAttribute("onTimeList", onTimeList);
		return "statistics_project_task";
    }
}
