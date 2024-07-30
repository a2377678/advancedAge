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
  <%@ include file="../header.jsp" %>
  <!---------------------- top end ---------------------->

  <%@ include file="../mainMenu.jsp" %>

  <!---------------------- left menu ---------------------->
  <%@ include file="../leftMenu.jsp" %>
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">權限與系統管理
        <span>使用者資料維護</span>
        <span id="number">J01</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      

      
        <!------------------- table 1 ------------------->
        <table class="table_03">
          <tr>
            <th width="15%">帳號</th>
            <td width="35%">${userInfoData.get('account') }</td>
            <input type="text" id="userAccount" value="${userInfoData.get('account') }" style="display:none">
            <th width="15%">所屬單位</th>
            <td><c:forEach  items="${unitList}"  var="item"  varStatus="userStatus">
	      		<c:if test="${userInfoData.get('unit')==item.code}">${item.name}</c:if>
	      	</c:forEach></td>
          </tr>
          <tr>
            <th>姓名</th>
            <td>${userInfoData.get('name') }</td>
            <th>E-mail</th>
            <td><input type="text" value="${userInfoData.get('email') }" size="30" disabled="disabled" /></td>
          </tr>
          <tr>
            <th>舊密碼</th>
            <td colspan="3"><input type="password" size="15" id="password" name="password"/></td>
          </tr>
          <tr>
            <th>新密碼</th>
            <td colspan="3"><input type="password" size="15" id="newPassword" name="newPassword"/>
            <span class="remark_01">密碼長度至少12字元，需有英文、數字、特殊字元的組合</span></td>
          </tr>
          <tr>
            <th>確認新密碼</th>
            <td colspan="3"><input type="password" size="15" id="checkNewPassword" name="checkNewPassword"/></td>
          </tr>
        </table>
        
        
      <div class="page_number">
        <input type="button" class="btn_02" value="取消修改" onclick="clearData()"/>
        <input type="button" class="btn_01" value="儲存資料" onclick="saveData()"/>
      </div>
      <br><br><br>
      
      
      

    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  
  
  

<script src="js/j01/j01.js"></script>


</body>




</html>
