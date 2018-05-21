<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head lang="en">
<meta charset="UTF-8">
<link rel="stylesheet" href="${ctx}/css/test.css">
<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/css/easydialog.css" />
<script src="${ctx}/js/jquery-1.10.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/js/jquery-1.10.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/js/bootstrap.min.js" type="text/javascript"charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/easydialog.min.js"></script>
<script type="text/javascript" src="${ctx}/js/cookie.js"></script>
<style type="text/css">
.updown-list {
	display: none;
	width: 432px;
	height: 190px;
	overflow: hidden;
	-webkit-box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.1);
	-moz-box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.1);
	-ms-box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.1);
	-o-box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.1);
	box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.1);
}

.updown-list>div {
	font-size: 20px;
	width: 432px;
	height: 40px;
	line-height: 40px;
	background-color: #FFF;
	margin-top: 150px;
	text-align: right;
	padding: 3px 12px;
	border-top: 1px solid #ECECEC;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-o-box-sizing: border-box;
	-ms-box-sizing: border-box;
	cursor: pointer;
	position: relative;
	z-index: 30;
}

.box-executive ul {
	width: 100%;
	height: 150px;
	position: absolute;
	top: 34px;
	left: 0;
	z-index: 10;
	padding: 0;
	background-color: #FFF;
	border-right: 1px solid #ECECEC;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-o-box-sizing: border-box;
	-ms-box-sizing: border-box;
}

.box-executive .list>li, .box-executive .list>li ol li {
	/* width: 300px;
		    height: 30px;
    		line-height: 30px; */
	font-size: 13px;
	color: #666;
	padding: 1px 12px;
	cursor: pointer;
	/* position: relative; */
}

.box-executive .list>li:before {
	content: "";
	display: inline-block;
	width: 10px;
	height: 15px;
	background: url(../img/arrow-right.png) center no-repeat;
	background-size: cover;
	position: relative;
	left: 186px;
	top: 3px;
}

.box-executive .list>li:hover, .box-executive .list>li ol li:hover {
	color: #FFF;
	background-color: #027CFF;
}

.list>li.active ol {
	display: block;
}

.list>li:hover ol {
	display: block;
}

.list>li ol {
	display: none;
	width: 216px;
	height: 150px;
	position: absolute;
	top: 0;
	left: 216px;
	z-index: 20;
	padding: 0;
	background-color: #FFF;
	overflow-y: scroll;
	overflow-x: hidden;
}

#easyDialogBox {
	margin-top: -392px;
}
.big_pic{
	position:fixed;
	width:100%;
	height:100%;
	z-index:10;
	text-align:center;
	display:none;
}
.big_pic .close{	
	position:absolute;
	right:10px;
	top:10px;
	z-index:1000;
	opacity:1;
}
.big_pic .big_bg{
	position:fixed;
	width:100%;
	height:100%;
	background-color:rgba(0,0,0,.5);
	z-index:10;
	text-align:center;
	padding-top:50px;
	
}
.big_pic .big_in{
	width:1200px;
	height:720px;
	margin:0 auto;
	margin-top:50px;
	position:relative;
	z-index:100;
	text-align:center;
	padding-top:40px;
	padding:20px;
}

.tab-link {
    font-size: 18px;
    color: #666666;
    font-weight: bold;
    display: block;
    min-height: unset;
    line-height: unset;
    overflow: unset;
    text-overflow: unset;
    text-align: center;
}
.grid{overflow:hidden;}
.grid tr td{
	font-size: 18px;
    color: #666666;
    border-bottom: 1px #dddddd solid;
    border-left: 1px #dddddd solid;
    padding:4px;
    overflow: unset;
    line-height: unset;
    vertical-align: middle;
    text-overflow: unset;
    position:relative;
}
.grid tr td:first-child{
	text-align:center;
}
.grid tr th{
	padding: 4px;
	text-align: center;
	vertical-align:middle;
}
.form-horizontal .control-label{
	font-size:16px;
}
.page-box{
	font-size:16px;
}
.page-box a{
	font-size:16px;
}
.meeting-list-table .color-blocks-btn{
	font-size:16px;
	height:30px;
}
.main-container{
	position:relative;
}
.main-container label{
	float:left;
	margin-top: 8px;
}
.form-group2 label{
   margin-right: 28px;
   font-size: 16;
}
.roleform select{
	float:left;
	width:190px;
}
.form-horizontal .form-group2 {
	box-sizing:border-box;
	margin-left: 20px;
    margin-right: 8px;
}
.showHtml{
	margin-right:25px;
}
.btns{
    position: absolute;
    right: 15px;
    top: -42px;
}
.main-table{
	position:relative;
	padding-bottom:15px;
	padding-top:5px;
}
.btn2{
    margin-left: 335px;
}
.main-container{
	width:1280px;
}
.text_ell{
	display:inline-block;	
	text-overflow:ellipsis;
	white-space:nowrap;
	overflow: hidden;
	cursor:pointer;
}
.w125{
	width:125px;
	display:inline-block;
}
#tbhtml,#tbhtml *{
	box-sizing:border-box;
}
.new_add{
    padding: 1px 2px;
    font-size: 12px;
    background-color: #fff;
    outline: none;
    border:0 none;
    border: 1px solid #999;
    position: absolute;
    bottom: 0;
    right: 0;
    z-index:1;
    font-size: 14px;
    color: #333;
}
.add_tc{
	width:320px;
	height:270px;
	box-shadow:3px -2px 6px rgba(43,43,43,0.5),-3px 2px 6px rgba(43,43,43,0.5);
	position:fixed;
	top:40px;
	left:50%;
	margin-left:-160px;
	z-index:2;
	background-color:#fff;
	text-align:center;
    padding-top: 10px;
    display:none;
}
.add_tc textarea{
	width:300px;
	height:110px;
	border:1px solid #ddd;
    resize: none;
    overflow-y:auto;
}
.add_tc .btns2{
	overflow:hidden;
	padding: 10px;
}
.roleform div{
	margin-bottom:0;
}
.col-sm-4_2{
	margin-left:-125px;
	margin-right:-125px;
}
.logo{
	position:absolute;
	top:15px;
	right:0;
}
.dropdown{
	position:relative;
}
.dropdown button{
	background-color:#fff;
    width: 155px;
    height: 34px;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1.42857143;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    position:relative;
    text-align:left;
    margin-top: -8px;
    white-space:nowrap;
    text-overflow:ellipsis;
    overflow:hidden;
}
.dropdown .caret{
	position:absolute;
    right: 10px;
    top: 15px;
}
.dropdown ul{
	list-style:none;
	width:155px;
	height:227px;
	background-color:#fff;
	box-shadow: 3px -2px 6px rgba(43,43,43,0.5), -3px 2px 6px rgba(43,43,43,0.5);
	padding-left:10px;
	position:absolute;
    top: 40px;
    left: 90px;
	z-index:100;
	display:none;
}
.dropdown .ul2{
	height:120px;
}
.dropdown .ul3{
	height:140px;
}
.dropdown ul li{
	display:block;
	height:25px;
	float:left;
	width:100%;
}
.dropdown ul li input{
	float:left;
	width:auto;
	margin-right:8px;
}
.dropdown ul li label{
	margin-right:0;
	display:block;
}
.div_transparent{
	position:fixed;
	left:0;
	top:0;
	width:100%;
	height:100%;
	z-index:99;
	background-color:transparent;
	display:none;
}
.showHtml{
	width:249px;
}
#tbhtml tr{
	min-height:50px;
}
.table-wrap {
    width: 100%;
    outline: none;
    position: relative;
    font-size: 14px;
    color: #444;
    border: 1px #dddddd solid;
    margin-bottom: 12px;
}
.div_pur select{
	height:31px;
	border:1px solid #ddd;
	margin-left:5px;
	margin-right:5px;
}
.page-box a{
	padding:6px 12px;
}
.page-box a.first-padding{
	padding:6px 12px;
}
.page-box a:nth-last-child(2), .page-box a:last-child{
	padding:6px 12px;
}
.big_pic .big_in .top{
	font-size:28px;
	color:#81d0fc;
}
.big_pic .top{overflow:hidden;}
.big_pic .top button{
	color:#333;
	font-size: 32px;
	font-weight:700;
}
.big_pic .center{
	overflow:hidden;
}
.big_pic .center .imgs1{
	height:500px;
	width:560px;
	background-color:#fff;
}
.big_pic .center .p_s p{
	text-align:left;
	font-size: 28px;
    color: #81d0fc;
    text-align:left;
    width:560px;

}

.big_pic .center .imgs1 ul{
	list-style:none;
	padding:0;
}
.big_pic .center .imgs1 li{
	width:100%;
	height:500px;
	text-align:center;
	line-height:500px;
}
.big_pic .center .imgs1 li img{
	max-width:100%;
	max-height:500px;
	width:auto;
	height:auto;
}
.big_pic .center .btn span{
	font-weight:700;
	color:#333;
	font-size:16px;
}
.big_pic .btn-imgs{
	position:relative;
}
.big_pic .btn-imgs img{
	position:absolute;
	top:230px;
	
}
.big_pic .btn-imgs .img1{
	left:0;
}
.big_pic .btn-imgs .img2{
	right:0;	
}
.big_pic .imgs2 .imgs{
	width:100%;
	height:500px;
	text-align:center;
	line-height:500px;
}
.big_pic .imgs2 .imgs img{
	max-width:100%;
	max-height:500px;
	width:auto;
	height:auto;
}
.big_pic .bottom{
	font-size: 28px;
    color: #81d0fc;
    text-align:left;
    margin-top:15px;
}
.big_pic .bottom em{
	font-style:normal;
}
.big_pic li{
	width:100%;
	height:500px;
	text-align:center;
	line-height:500px;
}
.table-content{
overflow-x:hidden;
}
.add_tc button{
	width:100px;
	height:30px;
	line-height:30px;
	background-color:#fff;
	border:1px solid #ddd;
}
.add_tc .s_c{
	position:relative;
	text-align:left;
	padding-left:10px;
    margin-bottom: 10px;
}
.add_tc .s_c input{
	position:absolute;
	top:0;
	left:0;
    width: 100px;
    opacity: 0;
}
.add_tc p{
	text-align:left;
	padding-left:10px;
}
.grid tr td .imgs{
	width:190px;
	min-height:142px;
}
#reportImgHtml{
	width: 185px;
    display: inline-block;
    flaot: left;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
    margin-top: 5px;
}
.s_c button{
	float:left;
	margin-right:5px;
}
</style>
<title>项目列表</title>
</head>
<body class="list-bgcolor">
	<div class="big_pic">		
		<div class="big_bg"></div>		
		<div class="big_in" style="display:none;">
			<div class="top">
				<span class="pull-left" id="projectNoHtml"></span>
				<span class="pull-left" id="projectNameHtml"></span>
				<button class="pull-right">关闭 X</button>
			</div>
			<div class="center">
				<div class="p_s">
					<p class="pull-left">项目周报图</p>
					<p class="pull-right">项目概图</p>
				</div>
				<div class="imgs1 pull-left">					
					<div class="btn-imgs">						
						<img src="../img/left1.png" class="img1">
						<img src="../img/right1.png" class="img2">												
					</div>
					<ul>
						<li><img src="../img/logo.png" id="projectReportHtml"></li>
					</ul>
				</div>
				<div class="imgs1 imgs2 pull-right">
					
					<div class="imgs">
						<img src ="" class="img_big">						
					</div>
				</div>
			</div>
			<div class="bottom">
				<em>采购周报:</em>
				<span id="reportHtml"></span>
			</div>
		</div>
	</div>
	<input type="hidden" name="pageNumber" id="pageNumber" value="${pageNumber}">
	<input type="hidden" name="pcType" id="pcType" value="${pcType}">
	<div class="main-container page1">
		<img src="../img/logo.png" class="logo">
		<div>
			<h3></h3>
		</div>
		<form id="form" class="roleform form-horizontal" role="form"
			onsubmit="return false;">
			<div class="form-group" style="height: 40px;">
				<label for="firstname" class="col-sm-2 control-label"
					style="margin-top: 10px; margin-left: -90px;"><!-- <i
					class="ffhh">*</i> -->人员筛选</label>
				<div class="col-sm-3 showHtml">
					<select id="purchase_name" name="purchase_name" class="form-control" onchange="searchProjectData(1)">
						<option value="">全部采购</option>
					</select><span></span>
				</div>

				<div class="col-sm-3 showHtml" style="margin-left:0px;">
					<select id="documentary_name" name="documentary_name" class="form-control" onchange="searchProjectData(1)">
							<option value="">全部跟单</option>
					</select><span></span>
				</div>

				<div class="col-sm-3 showHtml" style="margin-right:80px;">
					<select id="quality_name" name="quality_name" class="form-control" onchange="searchProjectData(1)">
						<option value="">全部质检</option>
					</select><span></span>
				</div>
			</div>
			<div class="form-group form-group2" style="height: 40px;">
				<div class="col-sm-4">
					<label class="">项目状态</label>
					<!-- <select id="projectType" name="projectType" class="form-control"
						style="width: 220px;" onchange="searchProjectData(1)">
						    <option value="-1">项目状态</option>
							<option value='0'>新立项项目</option>
							<option value='1'>正常进行项目</option>
							<option value='2'>完成项目</option>
							<option value='3'>延期项目</option>
							<option value='4'>暂停项目</option>
							<option value='5'>取消项目</option>
					</select> --><span></span>
					<!-- 改变 开始-->
						<div class="dropdown dropdown1">
							  <button id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							   		全部状态
							    <span class="caret"></span>
							  </button>
							  <div class="div_transparent"></div>
							  <ul>
							   	<li class="first-li"><label><input type="checkbox" checked="checked" onchange="searchProjectData(1)"  value="-1" ><span>全部状态</span></label></li>
      							<li><label><input type="checkbox" name="projectType" onchange="searchProjectData(1)" value='0'><span>新立项项目</span></label></li>
      							<li><label><input type="checkbox" name="projectType" onchange="searchProjectData(1)" value='1'><span>正常进行项目</span></label></li>
   								<li><label><input type="checkbox" name="projectType" onchange="searchProjectData(1)" value='3'><span>延期项目</span></label></li>
   								<li><label><input type="checkbox" name="projectType" onchange="searchProjectData(1)" value='4'><span>暂停项目</span></label></li>
   								<li><label><input type="checkbox" name="projectType" onchange="searchProjectData(1)" value='5'><span>取消项目</span></label></li>
   								<li><label><input type="checkbox" name="projectType" onchange="searchProjectData(1)" value='7'><span>上周完成项目</span></label></li>
   								<li><label><input type="checkbox" name="projectType" onchange="searchProjectData(1)" value='6'><span>样品完结</span></label></li>
								<li><label><input type="checkbox" name="projectType" onchange="searchProjectData(1)" value='2'><span>大货完结</span></label></li>
							  </ul>
						</div>
					<!-- 改变 结束-->
				</div>
				<div class="col-sm-4 col-sm-4_2">
					<label>项目阶段</label>
					<!-- <select id="projectStage" name="projectStage" class="form-control"
						style="width: 220px;" onchange="searchProjectData(1)">
						    <option  value="">项目阶段</option>
							<option value='0'>样品</option>
							<option value='1'>模具</option>
							<option value='2'>大货</option>
					</select> --><span></span>
					<!-- 改变 开始-->
					<div class="dropdown dropdown2">
						  <button id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						   		全部阶段
						    <span class="caret"></span>
						  </button>
						  <div class="div_transparent"></div>
						  <ul class="ul2" >
						   	<li class="first-li"><label><input type="checkbox" checked="checked" value="" onchange="searchProjectData(1)"><span>全部阶段</span></label></li>
   							<li><label><input type="checkbox" name="projectStage" value='0' onchange="searchProjectData(1)"><span>样品</span></label></li>
   							<li><label><input type="checkbox" name="projectStage" value='1' onchange="searchProjectData(1)"><span>模具</span></label></li>
   							<li><label><input type="checkbox" name="projectStage" value='2' onchange="searchProjectData(1)"><span>大货</span></label></li> 								  								
						  </ul>
					</div>
					<!-- 改变 结束-->
				</div>
				<div class="col-sm-4">
					<label>项目等级</label>
					<!-- <select id="plantAnalysis" name="plantAnalysis" class="form-control"
						style="width: 220px;" onchange="searchProjectData(1)">
						    <option  value="">项目阶段</option>>
							<option value="">未定</option>
							<option value='1'>A</option>
							<option value='2'>B</option>
							<option value='3'>C</option>
					</select> --><span></span>
					<!-- 改变 开始-->
						<div class="dropdown dropdown3">
							  <button id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							   		全部等级
							    <span class="caret"></span>
							  </button>
							  <div class="div_transparent"></div>
							  <ul class="ul3">
							   	<li class="first-li"><label><input type="checkbox" checked="checked" onchange="searchProjectData(1)"  value=""> <span>全部等级</span></label></li>
      							<li><label><input type="checkbox" name="plantAnalysis" onchange="searchProjectData(1)" value="0"><span>未定</span></label></li>
      							<li><label><input type="checkbox" name="plantAnalysis" onchange="searchProjectData(1)" value='1'><span> A</span></label></li>
      							<li><label><input type="checkbox" name="plantAnalysis" onchange="searchProjectData(1)" value='2'><span> B</span></label></li>
   								<li><label><input type="checkbox" name="plantAnalysis" onchange="searchProjectData(1)" value='3'><span> C</span></label></li>   								
							  </ul>
						</div>
					<!-- 改变 结束-->
				</div>
			</div>
			<div class="" style="height: 40px;margin-top:15px;">
				<label for="firstname" class="col-sm-2"
					style="margin-top:5px;font-size:16px;width:90px;padding-left:0;padding-right:0;margin-left:20px;"><!-- <i
					class="ffhh">*</i> -->关键词搜索</label>
				<div class="col-sm-3" style="padding-top:0;">
					<input class="form-control" style="width: 220px;" type="text" id="inputKey" name="inputKey"
						placeholder="项目号/项目名/姓名">
				</div>
			</div>
		</form>
		<div class="main-table meeting-list-table">		
			<span> <!--<input type="text" name="searchProjectNo"
				id="searchProjectNo" placeholder="项目号" />  -->
			</span> <input type="hidden" value="${userName}" name="userName"
				id="userName"> <input type="hidden" value="${userId}"
				name="userId" id="userId"> <input type="hidden"
				value="${roleNo}" name="roleNo" id="roleNo">
				<div class="btns">
					<input id="searchBut" type="submit" value="搜索" class="color-blocks-btn"  onclick="searchProjectData(1)"/> 
					<input type="submit" value="清空所有关键词和条件" class="color-blocks-btn btn2" style="margin-left:418px;" onclick="cleanSelect()"  />
					<input type="submit" value="返回主页" class="color-blocks-btn" onClick="goBack()"/>  
					<input name="" type="submit" value="退出系统" class="color-blocks-btn"  onclick="exitlogin()"/>
				</div>
			<div class="table-wrap" style="margin-top: 0;">
			    <form id="file_upload_id" onsubmit="return false;" method="post" enctype="multipart/form-data">
			         <input type="hidden" name="reportImg" id="reportImg" value="">
			         <input type="hidden" name="projectReportNo" id="projectReportNo" value="">
			         <input type="hidden" name="addReportImg" id="addReportImg" value="">
					 <div class="add_tc">
						<p>周报图片(至少一张，最多五张)</p>
						<div class="s_c"><button>上传图片</button><a href="###" id="reportImgHtml">文件名</a><input type="file" id="file_upload" name="file_upload" onchange="uploadFileName(this)"></div>
						<p>周报说明</p>
				       <textarea id="report" name="report" value=""></textarea>
				       <div class="btns2">
					       <button class="pull-left">取消</button>
					       <button class="pull-right" onclick="addProjectReport()">保存</button>
				       </div>
				     </div>
			    </form>
				<div class="table-head">
					<div class="table-head-wrap">
						<table class="grid">
							<colgroup>
								<col>
								<col>
								<col>
								<col>
							</colgroup>
							<thead>
								<tr>
									<th style="width: 30px"><span class="tab-link">序<br>号</span></th>
									<th style="width: 30px"><span class="tab-link">等<br>级</span></th>
									<th style="width: 130px"><span class="tab-link">项目号</span></th>
									<th style="width: 85px"><span class="tab-link">项目金额<br>万/美元</span></th>
									<th style="width: 110px"><span class="tab-link">签订日期</span></th>
									<th style="width: 165px"><span class="tab-link">大货/样品交期</span></th>
									<th style="width: 190px"><span class="tab-link">产品图</span></th>
									<th style="width: 140px"><span class="tab-link">周汇报</span></th>
									<!-- <th style="width: 90px"><span class="tab-link">技术指导</span></th> -->
									<th style="width: 158px"><span class="tab-link">工厂</span></th>
									<th style="width: 120px"><span class="tab-link">质检</span></th>
									<th style="width: 120px"><span class="tab-link">链接</span></th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
				<div class="table-content">
					<table class="grid">
						<colgroup>
							<col>
							<col>
							<col>
							<col>
						</colgroup>
						<tbody id="tbhtml">	
								<tr>	
								</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="page-box">
				总数:<span id="totalCount"></span>每页:
				<select id="selectPage" name="selectPage" onchange="selectPageFunc()">
					<option value="5">5</option>
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="50">50</option>
				</select>
				条 当前页/总页:<span style='color: red' id="pageNumberSpan"></span>/<span id="countPageSpan"
					style='color: red'></span>&nbsp; <a href="#" 
					class='emanagergetpagea first-padding'
					onclick="searchProjectData(1)" title='第一页' class='a02'>首页</a> <a
					href="#" class='emanagergetpagea first-padding'
					onclick="searchProjectData(2)" title='上一页(第1页)' class='a02'>上页</a>
				<a href="#" class='emanagergetpagea' onclick="searchProjectData(3)"
					title='下一页(第3页)' class='a02'>下页</a> <a href="#"
					class='emanagergetpagea' onclick="searchProjectData(4)"
					title='最后一页' class='a02'>尾页</a>
					<div class="pull-right div_pur">
						<span>采购</span>
						<select id="purchase_name_task" name="purchase_name_task" onchange="selectPurchaseTask()">
							<option value="">全部采购</option>
						</select>
						<a href="###" target=_blank id="purchaseNameTask">任务完成情况查询</a>
					</div>
			</div>
			<input type="hidden" id="pageNumber" name="pageNumber" value=""> 
			<input type="hidden" id="countPage" name="countPage" value="">
			<input type="hidden" id="pageSize" name="pageSize" value="5">
		</div>
	</div>
</body>
<script type="text/javascript" src="${ctx}/js/jquery-form.js"></script>
<script type="text/javascript">
		Date.prototype.pattern = function(fmt) {
			var o = {
				"M+" : this.getMonth() + 1, //月份         
				"d+" : this.getDate(), //日         
				"h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时         
				"H+" : this.getHours(), //小时         
				"m+" : this.getMinutes(), //分         
				"s+" : this.getSeconds(), //秒         
				"q+" : Math.floor((this.getMonth() + 3) / 3), //季度         
				"S" : this.getMilliseconds()
			//毫秒         
			};
			var week = {
				"0" : "/u65e5",
				"1" : "/u4e00",
				"2" : "/u4e8c",
				"3" : "/u4e09",
				"4" : "/u56db",
				"5" : "/u4e94",
				"6" : "/u516d"
			};
			if (/(y+)/.test(fmt)) {
				fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
						.substr(4 - RegExp.$1.length));
			}
			if (/(E+)/.test(fmt)) {
				fmt = fmt
						.replace(
								RegExp.$1,
								((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f"
										: "/u5468")
										: "")
										+ week[this.getDay() + ""]);
			}
			for ( var k in o) {
				if (new RegExp("(" + k + ")").test(fmt)) {
					fmt = fmt.replace(RegExp.$1,
							(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
									.substr(("" + o[k]).length)));
				}
			}
			return fmt;
		}
	</script>
<script type="text/javascript">
	$(function() {
		 var roleNo = $('#roleNo').val()
		if(roleNo==6){
			$('#purchase_name').parent('.showHtml').hide()
		}
		if(roleNo==5){
			$('#documentary_name').parent('.showHtml').hide()
		}
		if(roleNo==9){
			$('#quality_name').parent('.showHtml').hide();
		} 
			
		ajaxSelectOption()
		searchProjectData(1)
		
		var userName = $("#userName").val();
		if (userName == null || userName == '' || userName == undefined) {
			$("#goBackHtml").hide();
		}
	})
	
	
	
	
	function searchProjectData(obj){
		var pageNumber = $("#pageNumber").val();
		var countPage = $("#countPage").val();
		var roleNo = $("#roleNo").val();
		var userId = $("#userId").val();
		var userName = $("#userName").val();
		var pageSize=$("#pageSize").val();
		var type = obj;
		var pcType=$("#pcType").val();
		if(pcType!=null && pcType!=''&&pcType!=undefined ){
			pageNumber=pageNumber;
		}else{
			// 1 第一页  2.上一页  3.下一页 4.尾页
			if (type == 1) {
				pageNumber = 1;
			}
			if (type == 2) {//上一页
				if (pageNumber == 1) {
					pageNumber = 1
				} else {
					pageNumber = Number(pageNumber) - 1;
				}
			}
			if (type == 3) {//下一页
				if (pageNumber == countPage) {
					pageNumber = countPage;
				} else {
					pageNumber = Number(pageNumber) + 1;
				}
			}
			if (type == 4) {//尾页
				pageNumber = countPage;
			}
		}
		var inputKey = $("#inputKey").val();//关键字查询
		var projectTypeS ="";
		var projectStageS =""; 
		var plantAnalysisS =""; 
		var purchase_name = $('#purchase_name').val()
		var documentary_name = $('#documentary_name').val()
		var quality_name = $('#quality_name').val()
		var screenType="screenType";

		$('input[name="projectStage"]:checked').each(function(){ 
			projectStageS+=$(this).val()+","; 
		}); 
		
		$('input[name="plantAnalysis"]:checked').each(function(){ 
			plantAnalysisS+=$(this).val()+","; 
		}); 
		
		$('input[name="projectType"]:checked').each(function(){ 
			projectTypeS+=$(this).val()+","; 
		}); 
		
		$('#tbhtml').html('')
		$('#pageNumber').val("")
		$('#pageNumberSpan').text("")
	    $('#countPage').val("")
	    $('#countPageSpan').text("")
		$("#pcType").val("");
			$.ajax({
						type : 'post',
						url : '${ctx}/project/showList',
						data : {
							pageNumber : pageNumber,
							roleNo : roleNo,
							userId : userId,
							userName : userName,
							inputKey : inputKey,
							projectTypeS:projectTypeS,
							projectStageS:projectStageS,
							plantAnalysisS:plantAnalysisS,
							purchase_name : purchase_name,
							documentary_name :documentary_name,
							quality_name: quality_name,
							screenType:screenType,
							pageSize:pageSize	
						},
						success : function(data) {
							var json = eval("(" + data + ")");
							var projectDataList = json.data.list;//项目数据
							var pageNumber = json.data.pageNumber
							var totalCount = json.data.totalCount
							var projectType=json.data.projectType
							var totalCountFinish=json.data.totalCountFinish
							var pageSize=json.data.pageSize
							$('#pageNumber').val(pageNumber)
							$('#pageNumberSpan').text(pageNumber)
							if(totalCount){
								var countPage = Math.ceil(totalCount/pageSize)
								$('#countPage').val(countPage);
								$('#countPageSpan').text(countPage);
								$("#totalCount").text(totalCount);
							}
							if(projectDataList&&projectDataList.length>0){
								
								var tabhtml=''
								for(var i=0;i<projectDataList.length;i++){
									var project =projectDataList[i];
									var actualStartDate="";
									if(project.actualStartDate){
										actualStartDate += '' +(new Date(project.actualStartDate).pattern("yyyy-MM-dd"))+'';
									}
									tabhtml+='<tr calss="index-list">'
									       +'<td style="width: 30px" class="first-td">'+(i+1)+'<input type="hidden" value="'+project.flag+'" class="project-flag"></td>'
									       +'<td style="width: 30px">'+(project.plantAnalysisView?project.plantAnalysisView:"")+'</td>'
									       +'<td style="width: 130px"><a target="_blank" href="${ctx}/project/showDetails?projectNo='
												+ project.projectNo
												+ '&roleNo='
												+ roleNo
												+ '&userId='
												+ userId
												+ '&userName='
												+ userName
												+ '&pageNumber='
												+pageNumber
												+ '">'+project.projectNo+'</a><br><span class="w125" title = "'+ project.projectName+'" >'+project.projectName+'</span></td>'
						       					+'<td style="width: 85px;word-break:break-all;" >'+(project.projectAmount?project.projectAmount:"")+'</td>'
									       +'<td style="width: 110px">'+actualStartDate+'</td>'
									       
									       var allTime =''
									       
									       if(project.deliveryDate){
									    	   allTime = '大货：' +(new Date(project.deliveryDate).pattern("yyyy-MM-dd"))+'<br/>'
									       }
								           if(project.sampleScheduledDate){
								    	       allTime += '样品：' +(new Date(project.sampleScheduledDate).pattern("yyyy-MM-dd"))+'<br/>'
								           }
									    tabhtml+='<td style="width: 165px">'+allTime+'</td>'
								    
								    var zhijian='';
								    if(project.zhijian1){
								    	zhijian = project.zhijian1
								    	 if(project.zhijian2){
								    		 zhijian += '<br/>'+project.zhijian2
								    	 }
								     }else{ 
								    	 if(project.zhijian2){
								    		 zhijian = project.zhijian2
								    	 }
								     }
								      pichtml=''
							          if(project.productImg){
							        	if(project.productImg){
								        	 pichtml= '<img style="max-height: 142px;max-width: 190px;" src="/product_img/'+project.productImg+'"></img>'
								        }
							          }
								      
								      var qualityReport=project.qualityReport;
								      var reportHtml='';
								      if(qualityReport!=null){
								    	  //[SHS09260-6]中期检验,有问题，但已经处理,[zuoliang/2018-04-28]
								    	var qualityType="";
								    	var qualityExplain="";
								    	if(qualityReport.type==0){
								    		qualityType="样品检验";
								    	}
							    		if(qualityReport.type==2){
							    			qualityType="中期检验";
							    		}
							    		if(qualityReport.type==3){
							    			qualityType="终期检验";
							    		}
							    		if(qualityReport.status==0){
							    			qualityExplain="没问题";
							    		}
							    		if(qualityReport.status==1){
							    			qualityExplain="有问题,但已经处理";
							    		}
							    		if(qualityReport.status==2){
							    			qualityExplain="有问题,需要采购解决";
							    		}
							    		reportHtml+='<p><a href="javaScript:void(0);" onclick="download_file('+qualityReport.id+')">'+qualityType+','+qualityExplain+'['+qualityReport.user+'/'+(new Date(qualityReport.createtime).pattern("yyyy-MM-dd"))+']'+'</a></p>'
								      }
								      var linkHtml="";
								      if(project.projectDrawingList.length > 0){
								    	  linkHtml+='<a href=\'http://112.64.174.34:33168/upload/zhongwentuzhi/'+project.projectDrawingList[0].drawingName+'\'>图纸下载</a><br>' 
								      }
								      if(project.inspectionPlanList.length > 0){
								    	  linkHtml+='<a href=\'http://112.64.174.34:33168/upload/po/upload/JIANYANJIHUAZJ/'+project.inspectionPlanList[0].reportName+'\'>检验计划</a><br>' 
								      }
								      if(project.projectTaskList.length>0){
								    	  linkHtml+='<a target="_blank" href="${ctx}/projectTask/projectTaskList?projectNo='
												+ project.projectNo+ '&roleNo='+ roleNo+ '&purchaseNameId='+ ''
												+ '&userId='+ userId+ '&userName='+ userName+ '&taskStatus='+ '-1'
												+ '&sendOrReceive='+ '0'+ '&pageNumber='+'1'+ '">任务</a><br>'
								      }
								      if(project.projectDemandReportList.length>0){
								    	  linkHtml+='<a href=\'http://112.64.174.34:33168/upload/zhongwentuzhi/'+project.projectDemandReportList[0].drawingName+'\'>需求汇总</a><br>' 
								      }
									   tabhtml+='<td style="width: 190px"><div class="imgs">'+pichtml+'</div></td>'
									   if(project.projectReportList.length > 0){
										   tabhtml+='<td style="width: 140px">'+(project.weekInfo?project.weekInfo:"")+'</span><button class="new_add" onclick="addProjectReportHtml(\''+project.projectNo+'\')">已更新</button></td>' 
									   }else{
										   tabhtml+='<td style="width: 140px;">'+(project.weekInfo?project.weekInfo:"")+'</span><button class="new_add" style="background:#ff9800;" onclick="addProjectReportHtml(\''+project.projectNo+'\')">未更新</button></td>'
									   }
									   tabhtml+='<td style="width: 158px">'+(project.companyName?project.companyName:"")+'</td>'
							        	if(qualityReport!=null){  
								    	   tabhtml+='<td style="width: 120px">'+reportHtml+'</td>'
								        }else{
								    	   tabhtml+='<td style="width: 120px">'+zhijian+'</td>'  
								        }
									    tabhtml+='<td style="width: 120px">'+linkHtml+'</td>';
										tabhtml+='<input type="hidden" name="projectName" class="projectName" value="'+project.projectName+'"><input type="hidden" name="projectNo" class="projectNo" value="'+project.projectNo+'">'
									    if(project.weekInfo!=null && project.weekInfo!=''){
									        tabhtml+='<input type="hidden" name="report" class="report" value="'+project.weekInfo+'"><input type="hidden" name="reportUrl" class="reportUrl" value="'+project.weekPicture+'"></tr>'
									    }
								}
								//项目列表延期与快到期标记
							}		
								$('#tbhtml').html(tabhtml);	
								// 新增弹窗
								$('.new_add').click(function(){
									$('.add_tc').show();
								})
								$('.add_tc .btns2 button:first-child').click(function(){
									$('.add_tc').hide();
								})
								
								
								$('#tbhtml tr').each(function() {									
									var project_flag = $(this).find('td:nth-child(1) input').val();
									if (project_flag == 2) {
										$(this).css({"background-color":"#FFFF93"});
									}
								}) 
								/* 点击图片放大到整屏，并点击关闭按钮关闭 */
								$('.grid tr td img').on('click',function(){
									$('.big_pic').show();
									$('.big_in').show();
									var $src = $(this).attr('src');
									$('.imgs .img_big').attr('src',$src);
									var picUrl=$(this).parents("tr").find(".reportUrl").val();
									var reportUrl="http://112.64.174.34:10010/uploadimg/"+picUrl;
									$("#projectNoHtml").text($(this).parents("tr").find(".projectNo").val());
									$("#projectNameHtml").text($(this).parents("tr").find(".projectName").val());
									$("#reportHtml").text($(this).parents("tr").find(".report").val());
									if(picUrl!=null && picUrl!="" && picUrl!=undefined){
										$("#projectReportHtml").attr('src',reportUrl);	
									}	
								})
								$('.big_pic .top button').on('click',function(){
									$('.big_pic').hide();
									$('.big_in').hide();
									$('#reportHtml').text('');
									$('#projectNoHtml').text('');
									$('#projectNameHtml').text('');
								})
								//根据返回的值选中
								$("#selectPage option[value='"+pageSize+"']").attr("selected","selected");
						}
	           })	
	}
	function exitlogin() {
		$.cookie('name', '', {
			path : '/'
		});
		$.cookie('pass', '', {
			path : '/'
		});
		window.location.href = "${ctx}/index.jsp";
	}

	function cleanSelect(){
		
		$("#inputKey").val("")
		$("#projectType").val("")
        $('#projectStage').val("")
        $('#plantAnalysis').val("")
        $('#purchase_name').val("")
        $('#documentary_name').val("")
        $('#quality_name').val("")
		
    	var totalCount = Number($("#totalCount").val());
		if (totalCount == 0) {
			$("#totalCount").val(1)
		}
		ajaxSelectOption()
		searchProjectData(1)
		/* queryObj.operatorType = 1;
		queryObj.preNum = 1;
		queryObj.isPre = false;
		queryObj.nextNum = 1;
		queryObj.isNext = false;
		queryObj.curNum = 0;
		showload(); */
		
		// 清空条件
		$('.form-group2 input').prop('checked',false);
		$('.form-group2 .dropdown li:first-child input').prop('checked',true);
		
	}
	function ajaxSelectOption() {

		$.ajax({
			type : "post",
			url : "${ctx}/project/queryStaff.do ",
			success : function(data) {
				var json = eval("(" + data +")");
				if (json.ok) {
					var purchaseList = json.data.purchase
					var saleList = json.data.sale
					var qualityList = json.data.quality
					var purchaseHtml ='<option value="">全部采购</option><option value="无采购">无采购</option>'
				    var purchaseTaskHtml ='<option value="">全部采购</option>'
					var saleHtml ='<option value="">全部跟单</option>'
					var qualityHtml ='<option value="">全部质检</option>'
					
					for(var i=0;i<purchaseList.length;i++){
						purchaseHtml+='<option value="'+purchaseList[i].userName+'">'+purchaseList[i].userName+'</option>'
						purchaseTaskHtml+='<option value="'+purchaseList[i].userName+'">'+purchaseList[i].userName+'</option>'
					}
					for(var i=0;i<saleList.length;i++){
						saleHtml+='<option value="'+saleList[i].userName+'">'+saleList[i].userName+'</option>'
					}
					for(var i=0;i<qualityList.length;i++){
						qualityHtml+='<option value="'+qualityList[i].userName+'">'+qualityList[i].userName+'</option>'
					}
					$('#purchase_name').html(purchaseHtml)
					$("#purchase_name_task").html(purchaseTaskHtml);
					$('#documentary_name').html(saleHtml)
					$('#quality_name').html(qualityHtml)
				}
			}
		})
	}
	function getDetail(id) {
		if (!id) {
			return false;
		}

		$.ajax({
			url : "${ctx}/trigger/selectRecordDetails.do",
			type : "post",
			async : false,
			traditional : true,
			data : {
				'triggerId' : id
			},
			datatype : "json",
			success : function(result) {
				var json = eval("(" + result + ")");
				if (json.ok) {
					addTrigger()
					$('#triggerId').val(id)
					var triggerTask = json.data
					$('#roleType').val(triggerTask.roleType)
					$('#taskTitle').val(triggerTask.taskTitle)
				} else {

				}

			}

		})

	}

	function deleteDetail(id) {
		if (!id) {
			return false;
		}

		if (window.confirm('你确定要删除吗？')) {

		} else {
			return false;
		}

		var userId = $("#userId").val();
		var userName = $("#userName").val();
		var roleNo = $("#roleNo").val();

		$.ajax({
			url : "${ctx}/trigger/deleteRecordDetails.do",
			type : "post",
			async : false,
			traditional : true,
			data : {
				'triggerId' : id
			},
			datatype : "json",
			success : function(result) {
				var json = eval("(" + result + ")");

				if (json.ok) {

					window.location.href = "${ctx}/trigger/queryList?userName="
							+ userName + "&roleNo=" + roleNo + "&userId="
							+ userId;

				} else {
					easyDialog.open({
						container : {
							header : 'Prompt message',
							content : json.message
						},
						overlay : false,
						autoClose : 12000
					});
				}

			}

		})
	}

	function saveDetail() {

		$('.page2').find('.ff4').removeClass('ff4').text('')

		if (!$('#projectNo').val()) {
			$('#projectNo').next().addClass('ff4').text('请输入项目号')
		}

		$('.page2').find('select[name=roleType]').each(function() {
			if ($(this).val() == 0) {
				$(this).next().addClass('ff4').text('请选择角色类型')
			}

		})

		$('.page2').find('input[name=taskTitle]').each(function() {
			if ($(this).is(':visible')) {
				if (!$(this).val()) {
					$(this).next().addClass('ff4').text('请输入任务标题')
				}

			}

		})

		if ($('.ff4').length > 0) {
			return false;
		}

		var userId = $("#userId").val();
		var userName = $("#userName").val();
		var roleNo = $("#roleNo").val();

		$("#submitButton").attr("disabled", true).css("background-color","#999");
		$("#triggerform")
				.ajaxSubmit(
						{
							type : "post",
							url : "${ctx}/trigger/addRecord",
							dataType : "text",
							success : function(result) {
								var json = eval("(" + result + ")");
								$("#submitButton").css("background-color",
										"#027CFF").removeAttr('disabled');
								if (json.ok) {

									window.location.href = "${ctx}/trigger/queryList?userName="
											+ userName
											+ "&roleNo="
											+ roleNo
											+ "&userId=" + userId;
								} else {

									easyDialog.open({
										container : {
											header : 'Prompt message',
											content : json.message
										},
										overlay : false,
										autoClose : 3000
									});

								}

							}
						})

	}

	
	
	function deleteRole(obj) {
		$(obj).parents('.form-group').remove()
	}
	function addProjectReportHtml(obj){
		$("#projectReportNo").val(obj);
	}
	//添加周报
	function addProjectReport() {
		var projectNo=$("#projectReportNo").val();
		var report=$("#report").val();
		var userName=$("#userName").val();
		var userId=$("#userId").val();
		var roleNo=$("#roleNo").val();
		var addReportImg=$("#addReportImg").val();
		$('.add_tc').hide();
		$.ajax({
			url : "${ctx}/report/addReportPC",
			type : "post",
			async : false,
			traditional : true,
			data : {
				projectNo : projectNo,
				report:report,
				userId:userId,
				roleNo:roleNo,
				reportName:userName,
				addReportImg:addReportImg
			},
			datatype : "json",
			success : function(result) {
				var json = eval("(" + result + ")");
				if (json.ok) {
			        $("#reportImg").val('');
			        $("#projectReportNo").val('');
			        $("#addReportImg").val('');
			        $("#reportImgHtml").text('文件名');
			        $("#report").val('');
					searchProjectData(1);
				} else {
					easyDialog.open({
						container : {
							header : 'Prompt message',
							content : json.message
						},
						overlay : false,
						autoClose : 12000
					});
				}

			}
		})
	}
		

	function goBack() {
		var roleNo = $("#roleNo").val();
		var userId = $("#userId").val();
		var userName = $("#userName").val();
		var purchaseNameId = "";
		window.location.href = "${ctx}/jsp/project_list.jsp?userId=" + userId
				+ "&roleNo=" + roleNo + "&purchaseNameId=" + purchaseNameId
				+ "&userName=" + encodeURI(encodeURI(userName));
	}


	$(".box-executive input,.box-executive em").click(
			function(event) {
				$(this).parents(".project-task-list").find(".updown-list")
						.slideUp(30).end().end().siblings(".updown-list")
						.slideDown();
				$(this).parent(".box-executive").find("em").addClass(
						"arrow-icon");
				return false;
			});

	$(".list ol li").click(function(event) {
		var game1 = $(this).text()
		console.log($(this).parents(".updown-list").siblings("input").length);
		$(this).parents(".updown-list").siblings("input").val(game1);
		foc();
	});

	function addClick() {
		$(".box-executive input,.box-executive em").click(
				function(event) {
					$(this).parents(".project-task-list").find(".updown-list")
							.slideUp(30).end().end().siblings(".updown-list")
							.slideDown();
					$(this).parent(".box-executive").find("em").addClass(
							"arrow-icon");
					return false;
				});

		$(".list ol li").click(
				function(event) {
					var game1 = $(this).text()
					console.log($(this).parents(".updown-list").siblings(
							"input").length);
					$(this).parents(".updown-list").siblings("input")
							.val(game1);
					foc();
				});

	}

	function foc() {
		$(".close-ck").parents(".updown-list").slideUp();
		$(".box-executive em").removeClass("arrow-icon");
	}

	 function download_file(obj){
         var dataid = obj
         if(dataid){
         	window.location = "${ctx}/quality/download?id="+dataid;
         }
     }
</script>
<script>
	// 项目状态，项目阶段，项目等级，等内容多选功能
	$('.dropdown button').click(function(){
		$(this).siblings('ul').toggle();
		$(this).siblings('.div_transparent').toggle();
	})
	$('.div_transparent').click(function(){
		$(this).siblings('ul').hide();
		$(this).hide();
	})
	// 框内反选
	 $('.dropdown ul .first-li input').click(function(){
	 	if($(this).prop('checked')){
	 		$(this).parent().parent().parent().find('input').prop('checked',true);
	 	}else{
	 		$(this).parent().parent().parent().find('input').prop('checked',false);
	 		$('.dropdown3 button').html("");
	 	}
	 })


	// 反选
	$('.dropdown1 input').click(function(){		
		var input_len = $('.dropdown1 li').not('.first-li').find('input:checked').length;		
		if(input_len > 5){
			$(this).parent().parent().siblings('.first-li').find('input').prop('checked',true);
		}else{
			$(this).parent().parent().siblings('.first-li').find('input').prop('checked',false);
		}
		// 获取赋值
		var s = '';
		$('.dropdown1 input[name="projectType"]').each(function(){
			if($(this).is(':checked')){
                s += $(this).siblings('span').text()+",";
			}
		});
		if(s != ''){
			s = s.substring(0,s.length-1);
			$('.dropdown1 button').html(s);
		};
	})
	$('.dropdown2 input').click(function(){		
		var input_len = $('.dropdown2 li').not('.first-li').find('input:checked').length;		
		if(input_len > 2){
			$(this).parent().parent().siblings('.first-li').find('input').prop('checked',true);
		}else{
			$(this).parent().parent().siblings('.first-li').find('input').prop('checked',false);
		}
		// 获取赋值			
		var s = '';
		$('.dropdown2 input[name="projectStage"]').each(function(){
			if($(this).is(':checked')){
                s += $(this).siblings('span').text()+",";
			}
		});
		if(s != ''){
			s = s.substring(0,s.length-1);
			$('.dropdown2 button').html(s);
		};
	})
	$('.dropdown3 input').click(function(){	
		var li_len = $('.dropdown3 li').length;
		var input_len = $('.dropdown3 li').not('.first-li').find('input:checked').length;		
		if(input_len > 3){
			$(this).parent().parent().siblings('.first-li').find('input').prop('checked',true);
		}else{
			$(this).parent().parent().siblings('.first-li').find('input').prop('checked',false);
		}
		// 获取赋值
		var s = '';
		$('.dropdown3 input[name="plantAnalysis"]').each(function(){
			if($(this).is(':checked')){
                s += $(this).siblings('span').text()+",";
			}
		});
		if(s != ''){
			s = s.substring(0,s.length-1);
			$('.dropdown3 button').html(s);
		};
	})	
	//查询采购完成任务的情况
	function selectPurchaseTask(){
	   var searchName =$("#purchase_name_task").val();
	   var userName = $("#userName").val();
	   var roleNo = $("#roleNo").val();
	   var userId = $("#userId").val();
	   var userName = $("#userName").val();
	   var purchaseNameId = "";
	   var href="${ctx}/projectTask/projectTaskList?userId="+userId+"&roleNo="+roleNo+"&purchaseNameId="+encodeURI(encodeURI(purchaseNameId))+"&userName="+encodeURI(encodeURI(userName))+"&searchName="+searchName;   
	   $("#purchaseNameTask").attr("href",href); 
    }
	//选择分页
	function selectPageFunc(){
		var selectPage =$("#selectPage").val();
		$("#pageSize").val(selectPage);
		searchProjectData(1)
	}
	
	//上传周报图
	function uploadFileName(){
		  var path =  $("#file_upload").val();
		  sppath = path.split("\\");
		  var reportImg = sppath[sppath.length-1];	
		  $('#reportImg').val(reportImg);	
		  $("#file_upload_id").ajaxSubmit({
			type : "post",
			url : "${ctx}/report/uploadReportFile.do",
			dataType : "text",
			success : function(result) {
				var json = eval("(" + result + ")");
				$('#reportImgHtml').text(json);
				$('#reportImgHtml').attr("href",'http://112.64.174.34:10010/uploadimg/'+json); 
				$('#addReportImg').val(json);
			},
			error : function() {
				easyDialog.open({
					container : {
						content : '  Upload failed'
					},
					autoClose : 1000
			  });
			}
		   });
	}
	 
</script>

</html>