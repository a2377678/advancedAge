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
		<div class="panel-heading<%if(requestURI.indexOf("/b01")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse0">申請案件查詢</a>
			</h4>
		</div>
		<div id="collapse0" class="panel-collapse collapse <%if(requestURI.indexOf("/b01")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="b01" <%if(requestURI.indexOf("/b01")!=-1 && requestURI.indexOf("/b01_division")==-1){ %>class="in"<%} %>>申請案件查詢</a></li>
                  <c:if test="${jurisdiction==1 }"><li><a href="b01_division" <%if(requestURI.indexOf("/b01_division")!=-1){ %>class="in"<%} %>>案件分案</a></li></c:if>
                </ul>
			</div>
		</div>
	</div>
    
    <!---------- collapse1 ---------->
	<div class="panel panel-default">
		<div class="panel-heading<%if(requestURI.indexOf("/a")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">收件與補件</a>
			</h4>
		</div>
		<div id="collapse1" class="panel-collapse collapse <%if(requestURI.indexOf("/a")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="a01" <%if(requestURI.indexOf("/a01")!=-1){ %>class="in"<%} %>>附件檢查與通知</a></li>
                  <li><a href="a02" <%if(requestURI.indexOf("/a02")!=-1){ %>class="in"<%} %>>補件回傳案件</a></li>
                </ul>
			</div>
		</div>
	</div>
    
    <!---------- collapse2 ---------->
	<div class="panel panel-default">
		<div class="panel-heading<%if(requestURI.indexOf("/b02")!=-1 || requestURI.indexOf("/b05")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">審件與核定</a>
			</h4>
		</div>
		<div id="collapse2" class="panel-collapse collapse <%if(requestURI.indexOf("/b02")!=-1 || requestURI.indexOf("/b05")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="b02" <%if(requestURI.indexOf("/b02")!=-1){ %>class="in"<%} %>>案件審核</a></li>
                  <li><a href="b05" <%if(requestURI.indexOf("/b05")!=-1){ %>class="in"<%} %>>核定管理</a></li>
                </ul>
			</div>
		</div>
	</div>
    
    <!---------- collapse3 ---------->
	<div class="panel panel-default">
		<div class="panel-heading<%if(requestURI.indexOf("/c01")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">請款與核銷</a>
			</h4>
		</div>
		<div id="collapse3" class="panel-collapse collapse <%if(requestURI.indexOf("/c01")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="c01" <%if(requestURI.indexOf("/c01")!=-1){ %>class="in"<%} %>>請領核銷作業</a></li>
                </ul>
			</div>
		</div>
	</div>
    
    <!---------- collapse4 ---------->
	<div class="panel panel-default">
		<div class="panel-heading<%if(requestURI.indexOf("/b03")!=-1 || requestURI.indexOf("/b04")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">案件查核管理</a>
			</h4>
		</div>
		<div id="collapse4" class="panel-collapse collapse <%if(requestURI.indexOf("/b03")!=-1 || requestURI.indexOf("/b04")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="b03" <%if(requestURI.indexOf("/b03")!=-1){ %>class="in"<%} %>>停止補助名單</a></li>
                  <li><a href="b04" <%if(requestURI.indexOf("/b04")!=-1){ %>class="in"<%} %>>實地查核登錄</a></li>
                </ul>
			</div>
		</div>
	</div>
    
    
    <!---------- collapse8 ---------->
    <div class="panel panel-default">
		<div class="panel-heading<%if(requestURI.indexOf("/i")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse8">彙整與統計</a>
			</h4>
		</div>
		<div id="collapse8" class="panel-collapse collapse <%if(requestURI.indexOf("/i")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="i01" <%if(requestURI.indexOf("/i01")!=-1){ %>class="in"<%} %>>統計概況 (儀錶板)</a></li>
		         <li><a href="i02" <%if(requestURI.indexOf("/i02")!=-1){ %>class="in"<%} %>>案件統計分析</a></li>
		         <li><a href="i03" <%if(requestURI.indexOf("/i03")!=-1){ %>class="in"<%} %>>近三年事業單位申請情形</a></li>
		         <li><a href="i04" <%if(requestURI.indexOf("/i04")!=-1){ %>class="in"<%} %>>事業單位申請金額統計</a></li>
		         <li><a href="i05" <%if(requestURI.indexOf("/i05")!=-1){ %>class="in"<%} %>>年度申請金額統計</a></li>
                </ul>
		  </div>
		</div>
	</div>    


    
    
    <!---------- collapse10 ---------->
    <div class="panel panel-default">
		<div class="panel-heading<%if(requestURI.indexOf("/j")!=-1){ %>-in<%} %>">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse10">權限與系統管理</a>
			</h4>
		</div>
		<div id="collapse10" class="panel-collapse collapse <%if(requestURI.indexOf("/j")!=-1){ %>in<%} %>">
			<div class="panel-body">
				<ul>
                  <li><a href="j01" <%if(requestURI.indexOf("/j01")!=-1){ %>class="in"<%} %>>使用者資料維護</a></li>
                  <li><a href="j02" <%if(requestURI.indexOf("/j02")!=-1){ %>class="in"<%} %>>使用者帳號與權限</a></li>
                  <li><a href="j03" <%if(requestURI.indexOf("/j03")!=-1){ %>class="in"<%} %>>群組權限管理</a></li>
                  <li><a href="j04" <%if(requestURI.indexOf("/j04")!=-1){ %>class="in"<%} %>>系統登入紀錄</a></li>
                </ul>
		  </div>
		</div>
	</div>
    
    
  </div>
  </div>
  <!---------------------- left menu end ---------------------->