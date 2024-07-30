<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String requestURI=request.getRequestURI().replace(path,"").replace("/WEB-INF",""); 
%>
	<!---------------------- left menu ---------------------->
  <div id="left_menu">
    <div class="panel-group" id="accordion">
    
    <!---------- collapse0 ---------->
	<div class="panel panel-default">
		<div class="panel-heading<%if(requestURI.indexOf("/s01")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse0">申請案件查詢</a>
			</h4>
		</div>
		<div id="collapse0" class="panel-collapse collapse <%if(requestURI.indexOf("/s01")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="s01" <%if(requestURI.indexOf("/s01")!=-1 && requestURI.indexOf("/s01_division")==-1){ %>class="in"<%} %>>申請案件查詢</a></li>
                  <c:if test="${jurisdiction==1 }"><li><a href="s01_division" <%if(requestURI.indexOf("/s01_division")!=-1){ %>class="in"<%} %>>案件分案</a></li></c:if>
                </ul>
			</div>
		</div>
	</div>
    
    <!---------- collapse1 ---------->
	<div class="panel panel-default">
		<div class="panel-heading<%if(requestURI.indexOf("/t")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">收件與補件</a>
			</h4>
		</div>
		<div id="collapse1" class="panel-collapse collapse <%if(requestURI.indexOf("/t")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="t01" <%if(requestURI.indexOf("/t01")!=-1){ %>class="in"<%} %>>附件檢查與通知</a></li>
                  <li><a href="t02" <%if(requestURI.indexOf("/t02")!=-1){ %>class="in"<%} %>>補件回傳案件</a></li>
                </ul>
			</div>
		</div>
	</div>
    
    <!---------- collapse2 ---------->
	<div class="panel panel-default">
		<div class="panel-heading<%if(requestURI.indexOf("/u")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">審件與核定</a>
			</h4>
		</div>
		<div id="collapse2" class="panel-collapse collapse <%if(requestURI.indexOf("/u")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="u01" <%if(requestURI.indexOf("/u01")!=-1){ %>class="in"<%} %>>案件審核</a></li>
                  <li><a href="u02" <%if(requestURI.indexOf("/u02")!=-1){ %>class="in"<%} %>>核定管理</a></li>
                </ul>
			</div>
		</div>
	</div>
    
    <!---------- collapse3 ---------->
	<div class="panel panel-default">
		<div class="panel-heading<%if(requestURI.indexOf("/v01")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">請款與核銷</a>
			</h4>
		</div>
		<div id="collapse3" class="panel-collapse collapse <%if(requestURI.indexOf("/v01")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="v01" <%if(requestURI.indexOf("/v01")!=-1){ %>class="in"<%} %>>請領核銷作業</a></li>
                </ul>
			</div>
		</div>
	</div>
    
    <!---------- collapse4 ---------->
	<div class="panel panel-default">
		<div class="panel-heading<%if(requestURI.indexOf("/w")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">案件查核管理</a>
			</h4>
		</div>
		<div id="collapse4" class="panel-collapse collapse <%if(requestURI.indexOf("/w")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="w01" <%if(requestURI.indexOf("/w01")!=-1){ %>class="in"<%} %>>停止補助名單</a></li>
                  <li><a href="w02" <%if(requestURI.indexOf("/w02")!=-1){ %>class="in"<%} %>>實地查核登錄</a></li>
                </ul>
			</div>
		</div>
	</div>
    
    
    <!---------- collapse8 ---------->
    <div class="panel panel-default">
		<div class="panel-heading<%if(requestURI.indexOf("/y")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse8">彙整與統計</a>
			</h4>
		</div>
		<div id="collapse8" class="panel-collapse collapse <%if(requestURI.indexOf("/y")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="y01" <%if(requestURI.indexOf("/y01")!=-1){ %>class="in"<%} %>>統計概況 (儀錶板)</a></li>
		          <li><a href="y02" <%if(requestURI.indexOf("/y02")!=-1){ %>class="in"<%} %>>案件統計分析</a></li>
		          <li><a href="y03" <%if(requestURI.indexOf("/y03")!=-1){ %>class="in"<%} %>>近三年事業單位申請情形</a></li>
		          <li><a href="y04" <%if(requestURI.indexOf("/y04")!=-1){ %>class="in"<%} %>>事業單位申請金額統計</a></li>
		          <li><a href="y05" <%if(requestURI.indexOf("/y05")!=-1){ %>class="in"<%} %>>年度申請金額統計</a></li>
                </ul>
		  </div>
		</div>
	</div>    


    
    
    <!---------- collapse10 ---------->
    <div class="panel panel-default">
		<div class="panel-heading<%if(requestURI.indexOf("/z")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse10">權限與系統管理</a>
			</h4>
		</div>
		<div id="collapse10" class="panel-collapse collapse <%if(requestURI.indexOf("/z")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="z01" <%if(requestURI.indexOf("/z01")!=-1){ %>class="in"<%} %>>使用者資料維護</a></li>
                  <li><a href="z02" <%if(requestURI.indexOf("/z02")!=-1){ %>class="in"<%} %>>使用者帳號與權限</a></li>
                  <li><a href="z03" <%if(requestURI.indexOf("/z03")!=-1){ %>class="in"<%} %>>群組權限管理</a></li>
                  <li><a href="z04" <%if(requestURI.indexOf("/z04")!=-1){ %>class="in"<%} %>>系統登入紀錄</a></li>
                </ul>
		  </div>
		</div>
	</div>
    
    
  </div>
  </div>
  <!---------------------- left menu end ---------------------->