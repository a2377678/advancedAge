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
<script type="text/javascript" src="js/r03/r03.js"></script>
</head>



<body>


  <!---------------------- top ---------------------->
  <%@ include file="../header.jsp" %>
  <!---------------------- top end ---------------------->

  <%@ include file="../mainMenu.jsp" %>

  <!---------------------- left menu ---------------------->
  <%@ include file="../leftMenu2.jsp" %>
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">權限與系統管理
        <span>群組權限管理</span>
        <span id="number">R03</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      
	<c:if test="${jurisdiction==1 }">
      <!------------------- search ------------------->
      <div id="search_bar">
        <table class="table_01">
          <tr>
            <th width="14%">權限群組：</th>
            <td width="17%">
            <select name="jurisdiction" id="jurisdiction">
              	<option value="1">本署-管理者</option>
	            <option value="2">本署-一般使用者</option>
	            <option value="3">分署-管理者</option>
	            <option value="4">分署-審核人員</option>
	            <option value="5">分署-初審人員</option>
            </select>
            </td>
            <th>
            <!---<div class="btn_box-td">
              <button type="button" class="btn_01" value="開始查詢">開始查詢</button>
              <button type="button" class="btn_02" value="清除">清除</button>
            </div>--->
            </th>
          </tr>
        </table>
      </div>

      <!------------------- search ------------------->
     <div class="file_title-2">權限設定</div>
      
      <table class="table_07">
        <tr>
          <th width="32%">功能項目</th>
          <th width="7%">權限</th>
          <th>&nbsp;</th>
        </tr>
        <c:forEach  items="${functionList}"  var="item"  varStatus="userStatus">
        	<tr>
	          <td style="text-align:left">${item.functionName}</td>
	          <td><input type="checkbox" class="check_02" id="functionCode${userStatus.count}" name="functionCode${userStatus.count}" value="${item.functionCode}"/></td>
	          <td>&nbsp;</td>
	        </tr>
      	</c:forEach>
        
      </table>

      
      
      <div id="page_number">
        <input type="button" class="btn_02" value="取消修改" onclick="resetData()"/>
        <input type="button" class="btn_01" value="儲存修改" onclick="saveData()"/>
      </div>
      <br><br><br>
      </c:if>
      <c:if test="${jurisdiction!=1 }"><p>無此權限</p></c:if>

    </div>
    
  </div>
  <!---------------------- main ---------------------->


</body>

</html>
