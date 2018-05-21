package com.cn.hnust.controller;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cn.hnust.pojo.Project;
import com.cn.hnust.pojo.ProjectERP;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IProjectERPService;
import com.cn.hnust.service.IProjectService;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.util.DateUtil;
import com.cn.hnust.util.HttpClient;
import com.cn.hnust.util.IdGen;
import com.cn.hnust.util.JsonResult;

/**
 * CRM项目Controller
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/project")
public class ProjectERPController {

	@Autowired
	private IProjectERPService projectERPService;
	
	@Autowired 
	private IProjectService projectService;
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 同步ERP数据(项目信息)
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/synchERPProject", method = RequestMethod.POST)
	@ResponseBody
	public String updateCRMProject(HttpServletRequest request,HttpServletRequest response,@RequestParam Map<String,String> map)
			throws Exception {
		 String jsonStr = map.get("EmailClient");
		  
//		    BufferedReader reader = null;
//		    String jsonStr = "";
//			reader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\1.text"));
//			String tempString = "";
//
//			int line = 1;
//		
//			while ((tempString = reader.readLine()) != null) {
//				jsonStr+=tempString;
//				line++;
//			}
		
		 JSONArray json = JSONArray.fromObject(jsonStr);
		 // 首先把字符串转成 JSONArray  对象
		 if(json.size()>0){
		  for(int i=0;i<json.size();i++){
		    JSONObject obj = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
		    String projectNo = (String) obj.get("caseNo");
		    String projectNameC=""; 
		    
		    if(obj.get("projectDescc")!="" && obj.get("projectDescc")!=null){
		    	projectNameC = obj.get("projectDescc").toString();
		    }
		    
		    String projectNameE="";
		    if(obj.get("projectDesce")!="" && obj.get("projectDesce")!=null){
		    	projectNameE =obj.get("projectDesce").toString();
		    }
		    
		    String zhijian1="";
		    if(obj.get("zhijian1")!="" && obj.get("zhijian1")!=null){
		    	zhijian1 = obj.get("zhijian1").toString();
		    }
            
		    String zhijian2="";
		    if(obj.get("zhijian2")!="" && obj.get("zhijian2")!=null){
		    	zhijian2 = obj.get("zhijian2").toString();
		    }
	        
		    String customerManager="";
		    if(obj.get("customerManager")!="" && obj.get("customerManager")!=null){
		    	customerManager =obj.get("customerManager").toString();
		    }
		    
		    String merchandManager1="";
		    if(obj.get("merchandManager1")!="" && obj.get("merchandManager1")!=null){
		    	merchandManager1 = obj.get("merchandManager1").toString();
		    }
		    
		    String merchandManager2="";
		    if(obj.get("merchandManager2")!="" && obj.get("merchandManager2")!=null){
		    	merchandManager2 =obj.get("merchandManager2").toString();
		    }
            
		    String engineer1="";
		    if(obj.get("engineer1")!="" && obj.get("engineer1")!=null){
		    	engineer1 = obj.get("engineer1").toString();
		    }
		    
		    String engineer2="";
		    if(obj.get("engineer2")!="" && obj.get("engineer2")!=null){
		    	engineer2 =obj.get("engineer2").toString();
		    }
		    
		    String engineer3="";
		    if(obj.get("engineer1")!="" && obj.get("engineer3")!=null){
		    	engineer3 = obj.get("engineer3").toString();
		    } 
		    
		    String companyName="";
		    if(obj.get("factoryName")!="" && obj.get("factoryName")!=null){
		    	companyName = obj.get("factoryName").toString();
		    } 
		    
		    String plantAnalysis="";
		    if(obj.get("plantAnalysis")!="" && obj.get("plantAnalysis")!=null){
		    	plantAnalysis = obj.get("plantAnalysis").toString();
		    } 
		    
		    String projectMaterialProperties="";
		    if(obj.get("projectMaterialProperties")!="" && obj.get("projectMaterialProperties")!=null){
		    	projectMaterialProperties = obj.get("projectMaterialProperties").toString();
		    } 
		    
		    String dateSample="";
		    if(obj.get("dateSample")!="" && obj.get("dateSample")!=null){
		    	dateSample = obj.get("dateSample").toString();
		    } 
		    	    
		    String completionTime="";
		    if(obj.get("completionTime")!="" && obj.get("completionTime")!=null){
		    	completionTime = obj.get("completionTime").toString();
		    } 
		    
		    String dateSampleUploading="";
		    if(obj.get("dateSampleUploading")!="" && obj.get("dateSampleUploading")!=null){
		    	dateSampleUploading = obj.get("dateSampleUploading").toString();
		    } 
		    
		    
			ProjectERP project = new ProjectERP();
			project.setId(IdGen.uuid());
			project.setProjectNo(projectNo);
			project.setProjectNameC(projectNameC);
	        project.setProjectNameE(projectNameE);
	        project.setZhijian1(zhijian1);
	        project.setZhijian2(zhijian2);
	        project.setCustomerManager(customerManager);
	        project.setMerchandManager1(merchandManager1);
	        project.setMerchandManager2(merchandManager2);
	        project.setEngineer1(engineer1);
	        project.setEngineer2(engineer2);
			project.setEngineer3(engineer3);
			project.setCompanyName(companyName);
			project.setPlantAnalysis(Integer.parseInt(plantAnalysis));
			project.setProjectMaterialProperties(Integer.parseInt(projectMaterialProperties));
			
			if(StringUtils.isNotBlank(dateSample)){
				Calendar c = Calendar.getInstance();
				c.setTime(DateUtil.StrToDate(dateSample));
				int year=c.get(Calendar.YEAR);
				if(year>2000){
					project.setDateSample(DateUtil.StrToDate(dateSample));
				}
				
			}
			if(StringUtils.isNotBlank(completionTime)){
				Calendar c = Calendar.getInstance();
				c.setTime(DateUtil.StrToDate(completionTime));
				int year=c.get(Calendar.YEAR);
				if(year>2000){
					project.setCompletionTime(DateUtil.StrToDate(completionTime));
				}
			}
			if(StringUtils.isNotBlank(dateSampleUploading)){
				Calendar c = Calendar.getInstance();
				c.setTime(DateUtil.StrToDate(dateSampleUploading));
				int year=c.get(Calendar.YEAR);
				if(year>2000){
					project.setDateSampleUploading(DateUtil.StrToDate(dateSampleUploading));
				}
			}
			project.setCreateDate(new Date());
			
		    ProjectERP projectErp=projectERPService.selectProjectErpByNo(project.getProjectNo());
			if(projectErp == null){
				projectERPService.addProjectERP(project);
			}else{
				projectERPService.updateProjectErp(project);
			}
			
			//查询插入的项目是否存在
			Project projectInfo=projectService.selectProjectByProjectNo(project.getProjectNo());
			if(projectInfo!=null){//存在就更新
				Project updateProject=new Project();
				User user=new User();
				User purchaseUser =new User();
				if(StringUtils.isNotBlank(project.getMerchandManager1())){
					user=userService.selectUserByName(project.getMerchandManager1());
					if(user!=null){
						if(projectInfo.getEmailUserId()==0){
							updateProject.setEmailUserId(user.getId());
						}
			    	}
				}
				if(StringUtils.isNoneBlank(project.getMerchandManager2())){
					purchaseUser=userService.selectUserByName(project.getMerchandManager2());
					if(purchaseUser!=null){
						if(projectInfo.getEmailUserId()==0){
							updateProject.setPurchaseId(purchaseUser.getId());
						}
			    	}	
				}
				updateProject.setProjectNo(project.getProjectNo());
				updateProject.setCompanyName(project.getCompanyName());
				updateProject.setPlantAnalysis(project.getPlantAnalysis());
				updateProject.setProjectMaterialProperties(project.getProjectMaterialProperties());
			
				if(!projectInfo.getOperatorType().equals("1")){
					if(projectInfo.getDeliveryDate()==null){//大货交期
						updateProject.setDeliveryDate(project.getCompletionTime());
					}
					if(projectInfo.getSampleScheduledDate()==null){//样品交期
						updateProject.setSampleScheduledDate(project.getDateSample());
					}
				}
				
				if(projectInfo.getDateSampleUploading()==null){//合同上传日期
					updateProject.setActualStartDate(project.getDateSampleUploading());
				}
				projectService.updateProjectInfo(updateProject);
			}else{//不存在就插入操作
				Project insertProject=new Project();
				User user=new User();
				User purchaseUser =new User();
				//1.MerchandManager1 跟单销售,MerchandManager2 采购
				if(StringUtils.isNotBlank(project.getMerchandManager1())){
					user=userService.selectUserByName(project.getMerchandManager1());
					if(user!=null){
						insertProject.setEmailUserId(user.getId());
			    	}
				}
				if(StringUtils.isNotBlank(project.getMerchandManager2())){
					purchaseUser=userService.selectUserByName(project.getMerchandManager2());
					if(purchaseUser!=null){
						insertProject.setPurchaseId(purchaseUser.getId());
			    	}	
				}
				insertProject.setId(IdGen.uuid());
			    insertProject.setProjectNo(project.getProjectNo());
			    insertProject.setProjectName(project.getProjectNameC());
			    insertProject.setDeliveryDate(project.getCompletionTime()); //交期
			    insertProject.setDeliveryStatus(0);
			    insertProject.setWarningStatus(0);
			    insertProject.setImportance(0);
			    insertProject.setFinish(0);
			    insertProject.setStage(0);
			    insertProject.setPoDate(null);  //PO日期
			    insertProject.setActualStartDate(project.getDateSampleUploading());  //开工日期
			    insertProject.setScheduledDate(null);
			    insertProject.setSampleScheduledDate(project.getDateSample());
			    insertProject.setCompanyName(project.getCompanyName());
			    insertProject.setCreateDate(new Date());
			    insertProject.setPlantAnalysis(project.getPlantAnalysis());
			    
			    insertProject.setProjectMaterialProperties(project.getProjectMaterialProperties());
			    if(StringUtils.isNotBlank(dateSample)){
			    	insertProject.setDateSample(DateUtil.StrToDate(dateSample));
				}
				if(StringUtils.isNotBlank(completionTime)){
					insertProject.setCompletionTime(DateUtil.StrToDate(completionTime));
				}
				if(StringUtils.isNotBlank(dateSampleUploading)){
					insertProject.setDateSampleUploading(DateUtil.StrToDate(dateSampleUploading));
				}
			    projectService.addProject(insertProject);
			}
		  }
		 }
		 return "YES";
	}
	
	/**
	 * 同步时间和项目等级
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/synchUpdateProjectDate")
	@ResponseBody
	public JsonResult updateCRMProject(HttpServletRequest request,@RequestParam Map<String,String> map)
			throws Exception {
		JsonResult jsonResult=new JsonResult();
		Map<String, String> parameters=new HashMap<String, String>();

		List<ProjectERP> projectERPList=projectERPService.selectAllProjectERP();
		StringBuffer stringBuffer=new StringBuffer();
		for (int i = 0; i < projectERPList.size(); i++) {
			 ProjectERP projectERP=projectERPList.get(i);
			if(StringUtils.isNotBlank(projectERP.getProjectNo())){
				stringBuffer.append(projectERP.getProjectNo()).append(",");
	 		}
		 }
		 //stringBuffer.append("SHS06769-15").append(",");
		 parameters.put("projectIdList", stringBuffer.toString());
		 String result=HttpClient.sendPost("http://112.64.174.34:33169/ERP-NBEmail/helpServlet?action=inspectionReport&className=ExternalinterfaceServlet", parameters);
 		 JSONArray json = JSONArray.fromObject(result); // 首先把字符串转成 JSONArray  对象
		 if(json.size()>0){
			  for(int i=0;i<json.size();i++){
			    JSONObject obj = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
			    if(obj== null && obj.isNullObject()){
                	continue;
                }
			    String projectNo = (String) obj.get("caseNo");
			    String projectNameC=""; 
			    
			    if(obj.get("projectDescc")!="" && obj.get("projectDescc")!=null){
			    	projectNameC = obj.get("projectDescc").toString();
			    }
			    
			    String projectNameE="";
			    if(obj.get("projectDesce")!="" && obj.get("projectDesce")!=null){
			    	projectNameE =obj.get("projectDesce").toString();
			    }
			    
			    String zhijian1="";
			    if(obj.get("zhijian1")!="" && obj.get("zhijian1")!=null){
			    	zhijian1 = obj.get("zhijian1").toString();
			    }
	            
			    String zhijian2="";
			    if(obj.get("zhijian2")!="" && obj.get("zhijian2")!=null){
			    	zhijian2 = obj.get("zhijian2").toString();
			    }
		        
			    String customerManager="";
			    if(obj.get("customerManager")!="" && obj.get("customerManager")!=null){
			    	customerManager =obj.get("customerManager").toString();
			    }
			    
			    String merchandManager1="";
			    if(obj.get("merchandManager1")!="" && obj.get("merchandManager1")!=null){
			    	merchandManager1 = obj.get("merchandManager1").toString();
			    }
			    
			    String merchandManager2="";
			    if(obj.get("merchandManager2")!="" && obj.get("merchandManager2")!=null){
			    	merchandManager2 =obj.get("merchandManager2").toString();
			    }
	            
			    String engineer1="";
			    if(obj.get("engineer1")!="" && obj.get("engineer1")!=null){
			    	engineer1 = obj.get("engineer1").toString();
			    }
			    
			    String engineer2="";
			    if(obj.get("engineer2")!="" && obj.get("engineer2")!=null){
			    	engineer2 =obj.get("engineer2").toString();
			    }
			    
			    String engineer3="";
			    if(obj.get("engineer1")!="" && obj.get("engineer3")!=null){
			    	engineer3 = obj.get("engineer3").toString();
			    } 
			    
			    String companyName="";
			    if(obj.get("factoryName")!="" && obj.get("factoryName")!=null){
			    	companyName = obj.get("factoryName").toString();
			    } 
			    
			    String plantAnalysis="";
			    if(obj.get("plantAnalysis")!="" && obj.get("plantAnalysis")!=null){
			    	plantAnalysis = obj.get("plantAnalysis").toString();
			    } 
			    
			    String projectMaterialProperties="";
			    if(obj.get("projectMaterialProperties")!="" && obj.get("projectMaterialProperties")!=null){
			    	projectMaterialProperties = obj.get("projectMaterialProperties").toString();
			    } 
			    
			    String dateSample="";
			    if(obj.get("dateSample")!="" && obj.get("dateSample")!=null){
			    	dateSample = obj.get("dateSample").toString();
			    } 
			    	    
			    String completionTime="";
			    if(obj.get("completionTime")!="" && obj.get("completionTime")!=null){
			    	completionTime = obj.get("completionTime").toString();
			    } 
			    
			    String dateSampleUploading="";
			    if(obj.get("dateSampleUploading")!="" && obj.get("dateSampleUploading")!=null){
			    	dateSampleUploading = obj.get("dateSampleUploading").toString();
			    } 
			    
			    
				ProjectERP project = new ProjectERP();
				project.setId(IdGen.uuid());
				project.setProjectNo(projectNo);
				/*project.setProjectNameC(projectNameC);
		        project.setProjectNameE(projectNameE);
		        project.setZhijian1(zhijian1);
		        project.setZhijian2(zhijian2);
		        project.setCustomerManager(customerManager);
		        project.setMerchandManager1(merchandManager1);
		        project.setMerchandManager2(merchandManager2);
		        project.setEngineer1(engineer1);
		        project.setEngineer2(engineer2);
				project.setEngineer3(engineer3);
				project.setCompanyName(companyName);*/
				project.setPlantAnalysis(Integer.parseInt(plantAnalysis));
				project.setProjectMaterialProperties(Integer.parseInt(projectMaterialProperties));
				
				
				/*if(StringUtils.isNotBlank(dateSample)){
					Calendar c = Calendar.getInstance();
					c.setTime(DateUtil.StrToDate(dateSample));
					int year=c.get(Calendar.YEAR);
					if(year>2000){
						project.setDateSample(DateUtil.StrToDate(dateSample));
					}
					
				}
				if(StringUtils.isNotBlank(completionTime)){
					Calendar c = Calendar.getInstance();
					c.setTime(DateUtil.StrToDate(completionTime));
					int year=c.get(Calendar.YEAR);
					if(year>2000){
						project.setCompletionTime(DateUtil.StrToDate(completionTime));
					}
				}
				if(StringUtils.isNotBlank(dateSampleUploading)){
					Calendar c = Calendar.getInstance();
					c.setTime(DateUtil.StrToDate(dateSampleUploading));
					int year=c.get(Calendar.YEAR);
					if(year>2000){
						project.setDateSampleUploading(DateUtil.StrToDate(dateSampleUploading));
					}
					project.setDateSampleUploading(DateUtil.StrToDate(dateSampleUploading));
				}*/
				
			    ProjectERP projectErp=projectERPService.selectProjectErpByNo(project.getProjectNo());
			    projectERPService.updateProjectErp(project);
				if(projectErp == null){
					//project.setCreateDate(new Date());
					//projectERPService.addProjectERP(project);
				}else{
					//projectERPService.updateProjectErp(project);
				}
				
				/*//查询插入的项目是否存在
				Project projectInfo=projectService.selectProjectByProjectNo(project.getProjectNo());
				if(projectInfo!=null){//存在就更新
					Project updateProject=new Project();
					User user=new User();
					User purchaseUser =new User();
					if(StringUtils.isNotBlank(project.getMerchandManager1())){
						user=userService.selectUserByName(project.getMerchandManager1());
						if(user!=null){
							updateProject.setEmailUserId(user.getId());
				    	}
					}
					if(StringUtils.isNoneBlank(project.getMerchandManager2())){
						purchaseUser=userService.selectUserByName(project.getMerchandManager2());
						if(purchaseUser!=null){
							updateProject.setPurchaseId(purchaseUser.getId());
				    	}	
					}
					updateProject.setProjectNo(project.getProjectNo());
					updateProject.setCompanyName(project.getCompanyName());
					updateProject.setPlantAnalysis(project.getPlantAnalysis());
					updateProject.setProjectMaterialProperties(project.getProjectMaterialProperties());
					
					if(projectInfo.getDeliveryDate()==null){//大货交期
						updateProject.setDeliveryDate(project.getCompletionTime());
					}
					
					if(projectInfo.getSampleScheduledDate()==null){//样品交期
						updateProject.setSampleScheduledDate(project.getDateSample());
					}
					if(projectInfo.getDateSampleUploading()==null){//合同上传日期,开工日期
						updateProject.setActualStartDate(project.getDateSampleUploading());
					}
					projectService.updateProjectInfo(updateProject);
				}else{//不存在就插入操作
					Project insertProject=new Project();
					User user=new User();
					User purchaseUser =new User();
					//1.MerchandManager1 跟单销售,MerchandManager2 采购
					if(StringUtils.isNotBlank(project.getMerchandManager1())){
						user=userService.selectUserByName(project.getMerchandManager1());
						if(user!=null){
							insertProject.setEmailUserId(user.getId());
				    	}
					}
					if(StringUtils.isNotBlank(project.getMerchandManager2())){
						purchaseUser=userService.selectUserByName(project.getMerchandManager2());
						if(purchaseUser!=null){
							insertProject.setPurchaseId(purchaseUser.getId());
				    	}	
					}
					insertProject.setId(IdGen.uuid());
				    insertProject.setProjectNo(project.getProjectNo());
				    insertProject.setProjectName(project.getProjectNameC());
				    insertProject.setDeliveryDate(project.getCompletionTime()); //交期
				    insertProject.setDeliveryStatus(0);
				    insertProject.setWarningStatus(0);
				    insertProject.setImportance(0);
				    insertProject.setFinish(0);
				    insertProject.setStage(0);
				    insertProject.setPoDate(null);  //PO日期
				    insertProject.setActualStartDate(project.getDateSampleUploading());  //开工日期
				    insertProject.setScheduledDate(null);
				    insertProject.setSampleScheduledDate(project.getDateSample());
				    insertProject.setCompanyName(project.getCompanyName());
				    insertProject.setCreateDate(new Date());
				    insertProject.setPlantAnalysis(project.getPlantAnalysis());
				    
				    insertProject.setProjectMaterialProperties(project.getProjectMaterialProperties());
				    if(StringUtils.isNotBlank(dateSample)){
				    	insertProject.setDateSample(DateUtil.StrToDate(dateSample));
					}
					if(StringUtils.isNotBlank(completionTime)){
						insertProject.setCompletionTime(DateUtil.StrToDate(completionTime));
					}
					if(StringUtils.isNotBlank(dateSampleUploading)){
						insertProject.setDateSampleUploading(DateUtil.StrToDate(dateSampleUploading));
					}
				    projectService.addProject(insertProject);
				}*/
			  }
			 }
		 return jsonResult;
	}
	/**
	 * 同步开工日期,样品交期,大货交期
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/synchProjectTime")
	@ResponseBody
	public JsonResult synchProjectTime(HttpServletRequest request,@RequestParam Map<String,String> map)
			throws Exception {
		   JsonResult jsonResult=new JsonResult();
	
            String projectId=request.getParameter("projectId");
            String poDate=request.getParameter("poDate");
            String dateSampleUploading=request.getParameter("projectStartDate");//开工日期
            String dateSample=request.getParameter("dateSampleCompletion");//样品交期
            String completionTime =request.getParameter("completionDateBigGoods");//大货交期
            String ProjectLevel=request.getParameter("ProjectLevel");
            String ProjectMaterial=request.getParameter("ProjectMaterial");
			ProjectERP project = new ProjectERP();
			
			project.setProjectNo(projectId);
            if(StringUtils.isNotBlank(poDate)){//po日期
            	
            }
			if(StringUtils.isNotBlank(dateSample)){//样品日期
				project.setDateSample(DateUtil.StrToDate(dateSample));
			}
			if(StringUtils.isNotBlank(completionTime)){//大货交期
				project.setCompletionTime(DateUtil.StrToDate(completionTime));
			}
			if(StringUtils.isNotBlank(dateSampleUploading)){//开工日期
				project.setDateSampleUploading(DateUtil.StrToDate(dateSampleUploading));
			}
		    ProjectERP projectErp=projectERPService.selectProjectErpByNo(project.getProjectNo());
		    project.setPlantAnalysis(Integer.parseInt(ProjectLevel));
		    project.setProjectMaterialProperties(Integer.parseInt(ProjectMaterial));
	        if(projectErp!=null){
	        	projectERPService.updateProjectErp(project);
	        }
	        //查询插入的项目是否存在
			Project projectInfo=projectService.selectProjectByProjectNo(project.getProjectNo());
			if(projectInfo!=null){//存在就更新
				Project updateProject=new Project();
				updateProject.setProjectNo(project.getProjectNo());
				updateProject.setCompanyName(project.getCompanyName());
				updateProject.setPlantAnalysis(project.getPlantAnalysis());
				updateProject.setProjectMaterialProperties(project.getProjectMaterialProperties());
				if(poDate!=null){
					if(projectInfo.getPoDate()==null){//po日期
						updateProject.setPoDate(DateUtil.StrToDate(poDate));
					}
				}
				
				//大货交期
				if(project.getCompletionTime()!=null){
					updateProject.setDeliveryDate(project.getCompletionTime());	
				}
				
				//样品交期
				updateProject.setSampleScheduledDate(project.getDateSample());
				if(project.getDateSampleUploading()!=null){
					if(projectInfo.getDateSampleUploading()==null){//合同上传日期,开工日期
						updateProject.setActualStartDate(project.getDateSampleUploading());
					}
				}
				projectService.updateProjectInfo(updateProject);
			}
		 return jsonResult;
	}
	 
	
}
