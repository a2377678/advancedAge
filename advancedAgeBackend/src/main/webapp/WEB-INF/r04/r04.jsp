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

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/r04/r04.js"></script>

<style type="text/css">
.ui-datepicker {
	width: 20em; /*what ever width you want*/
}
</style>
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
        <span>系統登入紀錄</span>
        <span id="number">R04</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      
		<c:if test="${jurisdiction==1 }">
      <!------------------- search ------------------->
      <form action="r04" method="post" id="searchForm">
      <div id="search_bar">
        <table class="table_01">
          <tr>
            <th width="12%">所屬單位：</th>
            <td width="2%">
            	<select name="unit" id="unit">
		           	<option value>全部</option>
		               <c:forEach  items="${unitList}"  var="item"  varStatus="userStatus">
			      		<option value="${item.code}" <c:if test="${userLoginRecord.unit==item.code}">selected</c:if> >${item.name}</option>
			      	</c:forEach>
             	</select>
            </td>
            <th width="14%">登入日期：</th>
            <td>
            <input type="text" size="11" id="loginStartDate" name="loginStartDate" value="${loginStartDate }"/>
            ～
            <input type="text" size="11" id="loginEndDate" name="loginEndDate" value="${loginEndDate }"/>
            </td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <th>權限群組：</th>
            <td><select name="jurisdiction" id="jurisdiction">
            	<option value>全部</option>
              	<option value="1" <c:if test="${userLoginRecord.jurisdiction==1 }">selected</c:if>>本署-管理者</option>
	            <option value="2" <c:if test="${userLoginRecord.jurisdiction==2 }">selected</c:if>>本署-一般使用者</option>
	            <option value="3" <c:if test="${userLoginRecord.jurisdiction==3 }">selected</c:if>>分署-管理者</option>
	            <option value="4" <c:if test="${userLoginRecord.jurisdiction==4 }">selected</c:if>>分署-審核人員</option>
	            <option value="5" <c:if test="${userLoginRecord.jurisdiction==5 }">selected</c:if>>分署-初審人員</option>
            </select></td>
            <th>使用者姓名：</th>
            <td><input type="text" size="11" id="username" name="username" value="${userLoginRecord.username}"/></td>
            <td><div class="btn_box-td">
              <button type="submit" class="btn_01" value="開始查詢">開始查詢</button>
              <button type="button" class="btn_02" value="清除" onclick="clearData()">清除</button>
            </div></td>
          </tr>
        </table>
      </div>
	  <input type="text" name="numbersOfPage" value="${pagination.numbersOfPage}" style="display:none">
      <input type="text" name="page" id="page" value="${pagination.page}" style="display:none">
      <input type="text" name="totalNumbers" value="${pagination.totalNumbers}" style="display:none">
      <input type="text" name="totalPages" value="${pagination.totalPages}" style="display:none">
      
	  </form>
      <!------------------- search ------------------->
      <div class="file_title-2">登入紀錄</div>
      <table class="table_07">
        <tr>
          <th width="20%">所屬單位</th>
          <th width="20%">使用者群組</th>
          <th width="20%">使用者帳號</th>
          <th width="20%">使用者姓名</th>
          <th>登入日期</th>
        </tr>
        <c:choose><c:when test="${not empty userLoginRecordDate}">
      	<c:forEach items="${userLoginRecordDate}" var="item" varStatus="status">
	      	<tr>
	          <td><c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
		      		<c:if test="${item.unit==unitItem.code}">${unitItem.name}</c:if>	
		      	</c:forEach></td>
		      <td><c:if test="${item.jurisdiction==1}">本署-管理者</c:if>
		      		<c:if test="${item.jurisdiction==2}">本署-管理者</c:if>
		      		<c:if test="${item.jurisdiction==3}">分署-管理者</c:if>
		      		<c:if test="${item.jurisdiction==4}">分署-審核人員</c:if>
		      		<c:if test="${item.jurisdiction==5}">分署-初審人員</c:if>
		      </td>
	          <td>${item.account }</td>
	          <td>${item.username }</td>
	          <td>${item.loginTime.substring(0,4)-1911}${item.loginTime.substring(4,item.loginTime.length()-3)}</td>
	        </tr>
			        
      	</c:forEach>
        </c:when>
      </c:choose>
      </table>
　　　　 <br />

      <div class="page_number">
      	<c:if test="${pagination.page!=null}">
			<span><a href="javascript:void(0)" onclick="changePage('1')">|<</a></span>
			<c:if test="${pagination.page!=1}">
				<span><a href="javascript:void(0)" onclick="changePage('-1')"><</a></span>
			</c:if>
			<c:choose>
				<c:when test="${pagination.totalPages>=4 && pagination.page>2}">
					<c:forEach begin="${pagination.page-2}" end="${pagination.page+2<pagination.totalPages?pagination.page+2:pagination.totalPages}" var="p">
						<span><a href="javascript:void(0)"<c:if test="${pagination.page==p}"> class="in"</c:if> onclick="changePage('${p}')">${p}</a></span>
					</c:forEach>
				</c:when>
				<c:when test="${pagination.totalPages>=4}">
					<c:forEach begin="1" end="3" var="p">
						<span><a href="javascript:void(0)"<c:if test="${pagination.page==p}"> class="in"</c:if> onclick="changePage('${p}')">${p}</a></span>
					</c:forEach>
				</c:when>
				<c:when test="${pagination.totalPages<=3 }">
					<c:forEach begin="1" end="${pagination.totalPages}" var="p">
						<span><a href="javascript:void(0)"<c:if test="${pagination.page==p}"> class="in"</c:if> onclick="changePage('${p}')">${p}</a></span>
					</c:forEach>
				</c:when>
			</c:choose>
			<c:if test="${pagination.totalPages!=pagination.page}">
				<span><a href="javascript:void(0)" onclick="changePage('+1')">></a></span>
			</c:if>
	        <c:if test="${pagination.totalPages>=4 && pagination.page<pagination.totalPages}">
				<span><a href="javascript:void(0)" onclick="changePage(${pagination.totalPages})">>|</a></span>
			</c:if>
		</c:if>
      </div>
      </c:if>
      <c:if test="${jurisdiction!=1 }"><p>無此權限</p></c:if>
      

    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  
  
  




</body>




</html>
