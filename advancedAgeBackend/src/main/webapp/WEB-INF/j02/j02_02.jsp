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

    
  <div id="main_menu">
    <div><a href="#" class="menu-1 in">繼續僱用高齡者</a></div>
    <div><a href="#" class="menu-2">傳承專業技術與經驗</a></div>
    <div><a href="#" class="menu-3">退休後再就業準備協助措施</a></div>
    <div><a href="account01" class="account">申請帳號審核管理</a></div>
  </div>

  <!---------------------- left menu ---------------------->
  <%@ include file="../leftMenu.jsp" %>
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">權限與系統管理
        <span>使用者帳號與權限</span>
        <span id="number">J02_02</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      
	<c:if test="${jurisdiction==1 }">
      <!------------------- search ------------------->
      <div id="page_tab">
        <div class="tab-1"><a href="j02">查詢／修改</a></div>
        <div class="tab-1"><a href="j02_02" class="in">新建帳號</a></div>
      </div>
      <form action="j02_02" method="post" id="addForm">
      <table class="table_03">
        <tr>
          <th width="15%">所屬單位</th>
          <td width="35%"><select name="unit" id="unit">
                <c:forEach  items="${unitList}"  var="item"  varStatus="userStatus">
		      		<option value="${item.code}" <c:if test="${base.unit==item.code}">selected</c:if> >${item.name}</option>
		      	</c:forEach>
              </select></td>
          <th width="15%">權限群組</th>
          <td><select id="jurisdiction" name="jurisdiction">
            <option value="1">本署-管理者</option>
            <option value="2">本署-一般使用者</option>
            <option value="3">分署-管理者</option>
            <option value="4">分署-審核人員</option>
            <option value="5">分署-一般使用者</option>
          </select></td>
        </tr>
        <tr>
          <th>使用者帳號</th>
          <td><input type="text" size="15" id="userAccount" name="userAccount" required/>
          <br>
          <span class="remark_01">英數字至少6位</span>
          </td>
          <th>密碼</th>
          <td><input type="password" size="15" id="password" name="password" required/>
          <br>
          <span class="remark_01">密碼長度至少6字元，需有英文、數字的組合</span></td>
        </tr>
        <tr>
          <th>使用者姓名</th>
          <td><input type="text" size="15" id="name" name="name" required/></td>
          <th>E-mail</th>
          <td><input type="text" size="30" id="email" name="email" required/></td>
        </tr>
        <tr>
          <th>狀態</th>
          <td>
          <label>
            <input type="radio" id="status1" name="status" value="1" checked />
            啟用</label>
            <label>
              <input type="radio" id="status0" name="status" value="0" />
            停用</label>
          </td>
          <th>建立日期</th>
          <td></td>
        </tr>
      </table>
      
      
      <div id="page_number">
        <input type="reset" class="btn_02" value="清除重填" />
        <input type="submit" class="btn_01" value="新增資料"/>
      </div>
      </form>
      </c:if>
      <c:if test="${jurisdiction!=1 }"><p>無此權限</p></c:if>

    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
	<script src="js/j02/j02_02.js"></script>
</body>




</html>
