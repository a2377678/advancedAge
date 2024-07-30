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
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />



</head>



<body>


  <!---------------------- top ---------------------->
  <%@ include file="../header.jsp" %>
  <!---------------------- top end ---------------------->

  <%@ include file="../mainMenu.jsp" %>

  <!---------------------- left menu ---------------------->
  <%@ include file="../leftMenuCtype.jsp" %>
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">權限與系統管理
        <span>使用者帳號與權限</span>
        <span id="number">Z02-1</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      
	  <c:if test="${jurisdiction==1 }">
      <!------------------- search ------------------->
      <div id="page_tab">
        <div class="tab-1"><a href="z02" class="in">查詢／修改</a></div>
        <div class="tab-1"><a href="z02_02">新建帳號</a></div>
      </div>
      <form action="z02_1" method="post" id="editForm">
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
	            <option value="5" <c:if test="${userInfoData.jurisdiction==5}">selected</c:if>>分署-初審人員</option>
            </select>
          </td>
        </tr>
        <tr>
          <th>使用者帳號</th>
          <td>${userInfoData.account }<br></td>
          <input type="text" id="editAccount" name="editAccount" value="${userInfoData.account }" style="display:none">
          <th>密碼</th>
          <td><input type="password" size="15" id="password" name="password" required/>
          <br>
          <span class="remark_01">密碼長度至少12字元，需有英文、數字、特殊符號的組合</span></td>
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


    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jspdf.min.js"></script>
<script type="text/javascript" src="js/html2canvas.min.js"></script>  
<script src="js/z02/z02_1.js"></script>

</body>




</html>
