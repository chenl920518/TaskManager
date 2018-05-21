<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>功能选择</title>
	<script type="text/javascript"> 
    </script>
	<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css"/>
    <script type="text/javascript" src="${ctx}/js/jquery-1.10.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/cookie.js"></script>	
    <script type="text/javascript" src="${ctx}/js/common.js"></script>	   
	</head>
   <body class="bg">
		<div class="login-main select_fun">			
			<h2 class="login-tit">
			<img src="../img/logo.png" class="logo">
			<span>任务系统</span>
			<button class="ext">登出</button>
			</h2>
			<div class="btns">
				<h3>功能列表</h3>
				<div class="btn-list">
					<a href="${ctx}/jsp/project_list.jsp?userId=${userId}&roleNo=${roleNo}&purchaseNameId=${purchaseNameId}&userName=${userName}"><button>手机项目列表</button></a><br>
					<a href="${ctx}/project/queryListPc?userName=${userName}&userId=${userId}&roleNo=${roleNo}"><button>PC项目列表</button></a><br>
					<a href="${ctx}/projectTask/projectTaskList?roleNo=${roleNo}&userId=${userId}&userName=${userName}"><button>任务列表</button></a><br>
					<a href="${ctx}/jsp/project-summary.jsp?roleNo=${roleNo}&userId=${userId}&userName=${userName}"><button>项目汇总</button></a><br>
					<a href="${ctx}/jsp/input_project_task.jsp?roleNo=${roleNo}&userId=${userId}&userName=${userName}"><button>任务录入</button></a><br>
					<a href="${ctx}/meetingRecord/selectMeetingRecordList?roleNo=${roleNo}&userId=${userId}&userName=${userName}"><button class="btn1">会议列表</button></a>
					<a href="${ctx}/meetingRecord/inputMeetingRecord?roleNo=${roleNo}&userId=${userId}&userName=${userName}"><button>会议录入</button></a><br>
					<a href="${ctx}/qualityAnalysisTable/listItems?roleNo=${roleNo}&userId=${userId}&userName=${userName}"><button>60天质量分析表列表</button></a>
					<c:if test="${userName =='system' || userName=='ninazhao'}">
						<div class="task">
							<div class="title">任务流系统</div>
							<div class="pic"><img src="../img/kh.png"></div>
							<div class="btns">
								<a href="${ctx}/roleBind/queryList?roleNo=${roleNo}&userId=${userId}&userName=${userName}"><button>角色绑定</button></a><br>
								<a href="${ctx}/trigger/queryList?roleNo=${roleNo}&userId=${userId}&userName=${userName}"><button>触发动作</button></a><br>
								<a href="${ctx}/taskflow/queryList?roleNo=${roleNo}&userId=${userId}&userName=${userName}"><button class="btn-last">任务流</button></a>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>		
	</body>
</html>
