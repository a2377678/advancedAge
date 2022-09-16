<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="utf-8">
<title>促進中高齡者及高齡者就業相關補助計畫系統</title>

<link href="css/file.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>



<body>


  <!---------------------- top ---------------------->
<!--   <div id="top"> -->
<!--     <div id="top_logo"><a href="index.html"><img src="images/logo.png" /></a></div> -->
<!--   </div> -->
  <%@ include file="../header.jsp" %>
  <!---------------------- top end ---------------------->

    
  <div id="main_menu">
    <div><a href="#" class="menu-1 in">繼續僱用高齡者</a></div>
    <div><a href="#" class="menu-2">傳承專業技術與經驗</a></div>
    <div><a href="#" class="menu-3">退休後再就業準備協助措施</a></div>
    <div><a href="account01?account=${account }" class="account">申請帳號審核管理</a></div>
  </div>

  <!---------------------- left menu ---------------------->
  <%@ include file="../leftMenu.jsp" %>
<!--   <div id="left_menu"> -->
<!--     <div class="panel-group" id="accordion"> -->
    
<!--     -------- collapse1 -------- -->
<!-- 	<div class="panel panel-default"> -->
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">收件與補件</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse1" class="panel-collapse collapse"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="a01/a01.html">附件檢查與通知</a></li> -->
<!--                   <li><a href="a02/a02.html">補件回傳案件</a></li> -->
<!--                 </ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
    
<!--     -------- collapse2 -------- -->
<!-- 	<div class="panel panel-default"> -->
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">案件審查</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse2" class="panel-collapse collapse"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="b01/b01.html">申請案件查詢</a></li> -->
<!--                   <li><a href="b02/b02.html">案件審核</a></li> -->
<!--                   <li><a href="b03/b03.html">停止補助名單管理</a></li> -->
<!--                   <li><a href="b04/b04.html">實地查核登錄</a></li> -->
<!--                 </ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
    
<!--     -------- collapse3 -------- -->
<!-- 	<div class="panel panel-default"> -->
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 			<a data-toggle="collapse" data-parent="#accordion" href="#collapse3">請款與核銷</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse3" class="panel-collapse collapse"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="c01/c01.html">請款審核</a></li> -->
<!--                   <li><a href="c02/c02.html">案件核銷</a></li> -->
<!--                 </ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->

    
    
<!--     -------- collapse8 -------- -->
<!--     <div class="panel panel-default"> -->
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 				<a data-toggle="collapse" data-parent="#accordion" href="#collapse8">彙整與統計</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse8" class="panel-collapse collapse"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="index.html" class="in">統計概況 (儀錶板)</a></li> -->
<!--                   <li><a href="#">繼續僱用申請人數</a></li> -->
<!--                   <li><a href="#">繼續僱用補助金額</a></li> -->
<!--                   <li><a href="#">原有薪資級距</a></li> -->
<!--                   <li><a href="#">申請單位行業別</a></li> -->
<!--                   <li><a href="#">申請單位補助金額</a></li> -->
<!--                   <li><a href="#">申請單位申請情形</a></li> -->
<!--                 </ul> -->
<!-- 		  </div> -->
<!-- 		</div> -->
<!-- 	</div>     -->


    
    
<!--     -------- collapse10 -------- -->
<!--     <div class="panel panel-default"> -->
<!-- 		<div class="panel-heading-in"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 				<a data-toggle="collapse" data-parent="#accordion" href="#collapse10">權限與系統管理</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse10" class="panel-collapse collapse in"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="j01/j01.html">使用者資料維護</a></li> -->
<!--                   <li><a href="j02/j02.html" class="in">使用者帳號與權限</a></li> -->
<!--                   <li><a href="j03/j03.html">群組權限管理</a></li> -->
<!--                   <li><a href="j04/j04.html">系統登入紀錄</a></li> -->
<!--                 </ul> -->
<!-- 		  </div> -->
<!-- 		</div> -->
<!-- 	</div> -->
    
    
<!--   </div> -->
<!--   </div> -->
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">權限與系統管理
        <span>使用者帳號與權限</span>
        <span id="number">J02-1</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout?account=${account }">登出</a>
      </div>
      
		<c:if test="${jurisdiction==1 }">
<%--       <%if(Integer.valueOf(session.getAttribute("jurisdiction").toString())!=2){  %> --%>
      <!------------------- search ------------------->
      <div id="page_tab">
        <div class="tab-1"><a href="j02?account=${account }" class="in">查詢／修改</a></div>
        <div class="tab-1"><a href="j02_02?account=${account }">新建帳號</a></div>
      </div>
      <form action="j02_1" method="post" id="editForm">
      <table class="table_03">
        <tr>
          <th width="15%">所屬單位</th>
          <td width="35%">
          	<select name="unit" id="unit">
          	<c:forEach  items="${unitList}"  var="item"  varStatus="userStatus">
	      		<option value="${item.code}" <c:if test="${userInfoData.unit==item.code}">selected</c:if> >${item.name}</option>
	      	</c:forEach>
	      	</select>
		  </td>
          <th width="15%">權限群組</th>
          <td>
          	<select id="jurisdiction" name="jurisdiction">
	            <option value="1" <c:if test="${userInfoData.jurisdiction==1}">selected</c:if>>本署-管理者</option>
	            <option value="2" <c:if test="${userInfoData.jurisdiction==2}">selected</c:if>>本署-一般使用者</option>
	            <option value="3" <c:if test="${userInfoData.jurisdiction==3}">selected</c:if>>分署-管理者</option>
	            <option value="4" <c:if test="${userInfoData.jurisdiction==4}">selected</c:if>>分署-審核人員</option>
	            <option value="5" <c:if test="${userInfoData.jurisdiction==5}">selected</c:if>>分署-一般使用者</option>
            </select>
          </td>
        </tr>
        <tr>
          <th>使用者帳號</th>
          <td>${userInfoData.account }<br></td>
          <input type="hidden" id="editAccount" name="editAccount" value="${userInfoData.account }"/>
          <input type="hidden" name="account" value="${account}"/>
          <th>密碼</th>
          <td><input type="text" size="15" id="password" name="password" value="${userInfoData.password }" required/></td>
        </tr>
        <tr>
          <th>使用者姓名</th>
          <td><input type="text" size="15" id="name" name="name" value="${userInfoData.name }" required/></td>
          <th>E-mail</th>
          <td><input type="text" size="30" id="email" name="email" value="${userInfoData.email }" required/></td>
        </tr>
        <tr>
          <th>狀態</th>
          <td>
          <label>
            <input name="status" type="radio" id="status1" value="1" <c:if test="${userInfoData.status==1}">checked</c:if> />
            啟用</label>
            <label>
              <input name="status" type="radio" id="status0" value="0" <c:if test="${userInfoData.status==0}">checked</c:if> />
            停用</label>
          </td>
          <th>建立日期</th>
          <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${userInfoData.createTime}" var="createTime" />${createTime.substring(0,4)-1911}${createTime.substring(4,createTime.length())}</td>
        </tr>
      </table>
      
      
      <div id="page_number">
        <input type="reset" class="btn_02" value="取消修改" />
        <input type="button" class="btn_01" value="儲存修改" onclick="saveData()"/>
      </div>
	</form>
	</c:if>
	<c:if test="${jurisdiction!=1 }"><p>無此權限</p></c:if>
<%-- 	<%}else{ %> --%>
<!--   		<p>無此權限</p> -->
<%--   	<%} %> --%>
    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
	<script src="js/j02/j02_1.js"></script>
</body>




</html>
