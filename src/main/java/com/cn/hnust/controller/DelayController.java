package com.cn.hnust.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.pojo.Delay;
import com.cn.hnust.pojo.Project;
import com.cn.hnust.service.IDelayService;
import com.cn.hnust.service.IProjectService;
import com.cn.hnust.util.DateUtil;
import com.cn.hnust.util.IdGen;
import com.cn.hnust.util.JsonResult;

/**
 * 项目延期 Controller 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/delay")
public class DelayController {

	@Autowired
	private IDelayService delayService;
	@Autowired
	private IProjectService projectService;
	/**
	 * 插入项目延误信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addDelay")
	@ResponseBody
	public JsonResult showUser(HttpServletRequest request,HttpServletResponse response){
		 JsonResult json =new JsonResult();
		 String delayDate=request.getParameter("delayDate");//延期时间
		 String delayCause=request.getParameter("delayCause"); //外部原因(客户)
		 Integer type=Integer.parseInt(request.getParameter("checked")); //原因类型(内部，外部)
		 String projectNo=request.getParameter("projectNo");
		 Project project=projectService.selectProjctDetails(projectNo);
		 if(project.getDeliveryDate() ==null && project.getSampleScheduledDate()==null){
			 json.setOk(false);
			 json.setMessage("还没有输入交期,不能延期");
			 return json;
		 }
		 if(project.getDeliveryDate() !=null && project.getSampleScheduledDate()!=null){
			 if(DateUtil.StrToDate(delayDate).getTime()<project.getDeliveryDate().getTime()){
				 json.setOk(false);
				 json.setMessage("输入的延期时间小于交期时间");
				 return json; 
			 } 
		 }else{
			 if(project.getDeliveryDate()!=null){
				 if(DateUtil.StrToDate(delayDate).getTime()<project.getDeliveryDate().getTime()){
					 json.setOk(false);
					 json.setMessage("输入的延期时间小于交期时间");
					 return json; 
				 } 
			 }
			 if(project.getSampleScheduledDate()!=null){
				 if(DateUtil.StrToDate(delayDate).getTime()<project.getSampleScheduledDate().getTime()){
					 json.setOk(false);
					 json.setMessage("输入的延期时间小于交期时间");
					 return json; 
				 } 
			 } 
		 }
		 
		 Delay delay=new Delay();
		 delay.setId(IdGen.uuid());
		 if(type==0){
			 delay.setInternalCause(delayCause); 
		 }else{
			 delay.setExternalCause(delayCause);
		 }
		 delay.setType(type);
		 delay.setProjectNo(projectNo);
		 delay.setDelayDate(java.sql.Date.valueOf(delayDate)); 
		 delay.setCreateDate(new Date());
		 try {
			 delayService.insertDelay(delay);
			 json.setOk(true);
			 json.setMessage("项目延误信息添加成功");
		} catch (Exception e) {
			json.setOk(false);
			json.setMessage("项目延误信息添加错误");
			e.printStackTrace();
		}
		return json;
	}
}
