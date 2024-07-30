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
<script type="text/javascript" src="js/q03/q03.js"></script>
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
      <div id="main_title">彙整與統計
        <span>近三年事業單位申請情形</span>
        <span id="number">Q03</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName}&nbsp;${name}</a>
        <a href="logout">登出</a>
      </div>
      <c:if test="${functionPermission2.indexOf('Q03')!=-1 }">
		<!------------------- search ------------------->
		<form action="q03" method="post" id="searchForm">
      	<div id="search_bar">
	        <table class="table_01">
	            <tr>
	              <th width="14%">承辦單位：</th>
	              <td width="20%"><select name="unit" id="unit">
			      		<c:forEach items="${unitList}"  var="item"  varStatus="userStatus">
			      			<c:if test="${item.code != 'F'}">
			      				<option value="${item.code}" <c:if test="${base.unit==item.code}">selected</c:if>>${item.name}</option>
			      			</c:if>
			      		</c:forEach>
              		  </select>
              	  </td>
	              <th width="10%">&nbsp;</th>
	              <td>&nbsp;</td>
	              <td width="22%">
	              <div class="btn_box-td">
	                <button type="submit" class="btn_01" value="開始查詢">開始查詢</button>
	                <button type="reset" class="btn_02" value="清除">清除</button>
	              </div>
	              </td>
	            </tr>
	        </table>
      	</div>
      		<input type="text" name="numbersOfPage" value="${pagination.numbersOfPage}" style="display:none">
	      	<input type="text" name="page" id="page" value="${pagination.page}" style="display:none">
	      	<input type="text" name="totalNumbers" value="${pagination.totalNumbers}" style="display:none">
	      	<input type="text" name="totalPages" value="${pagination.totalPages}" style="display:none">
        </form>
        <!------------------- table 1 ------------------->
        <table class="table_04">
          <tr>
            <th style="width: 25%;">年度</th>
            <th style="width: 25%;">申請件數</th>
            <th style="width: 25%;">審核通過件數</th>
            <th>審核未通過件數</th>
          </tr>
          <c:choose><c:when test="${not empty applicationSituationList}">
      		<c:forEach items="${applicationSituationList}" var="item" varStatus="status">
	          <tr>
	            <td>${item.year }年</td>
	            <td>${item.totalCase }</td>
	            <td>${item.successCase }</td>
	            <td>${item.failCase }</td>
	          </tr>
          </c:forEach>
          </c:when></c:choose>
        </table>
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
    <c:if test="${functionPermission2.indexOf('Q03')==-1 }"><p>無此權限</p></c:if>
    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  
  
  




</body>




</html>
