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
    <div><a href="a01?account=${account}" class="menu-1">繼續僱用高齡者</a></div>
    <div><a href="#" class="menu-2">傳承專業技術與經驗</a></div>
    <div><a href="#" class="menu-3">退休後再就業準備協助措施</a></div>
    <div><a href="account01" class="account in">申請帳號審核管理</a></div>
  </div>

  <!---------------------- left menu ---------------------->
  <div id="left_menu">
    <div class="panel-group" id="accordion">
    
    <!---------- collapse1 ---------->
	<div class="panel panel-default">
		<div class="panel-heading-in">
			<h4 class="panel-title">
			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">申請帳號審核</a>
			</h4>
		</div>
		<div id="collapse1" class="panel-collapse collapse in">
			<div class="panel-body">
				<ul>
          <li><a href="account01?account=${account}">新申請帳號</a></li>
          <li><a href="account02?account=${account}" class="in">帳密查詢回覆</a></li>
        </ul>
			</div>
		</div>
	</div>
    
    
    
  </div>
  </div>
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">申請帳號審核
        <span>帳密查詢回覆</span>
        <span id="number">account02</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      
      
      
      <!------------------- list ------------------->
      <div class="audit_list">
    
      <div class="title">
          <span class="no"></span>
          <span class="update_time">查詢日期</span>
          <span class="tax_id_number">統編/扣繳</span>
          <span class="company_name">申請單位名稱</span>
      </div>
      
      <ol>
      <c:choose><c:when test="${not empty infoList}">
      	<c:forEach items="${infoList}" var="item" varStatus="status">
      		<li>
	          <a href="#" onclick="openData('${item.id}','${item.seq}')">
	          <span class="no">${status.count }</span>
	          <span class="update_time">${item.updateTime.substring(0,4)-1911}${item.updateTime.substring(4,10)}</span>
	          <span class="tax_id_number">${item.seq }</span>
	          <span class="company_name">${item.companyName }</span>
	          </a>
	        </li>
        
      	</c:forEach></c:when></c:choose>
<!--         <li> -->
<!--           <a href="account02_1"> -->
<!--           <span class="no">1</span> -->
<!--           <span class="update_time">111-09-01</span> -->
<!--           <span class="tax_id_number">85561470</span> -->
<!--           <span class="company_name">資訊科技股份有限公司</span> -->
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="account_02-1.html"> -->
<!--           <span class="no">2</span> -->
<!--           <span class="update_time">111-09-01</span> -->
<!--           <span class="tax_id_number">66320005</span> -->
<!--           <span class="company_name">OO資訊股份有限公司</span> -->
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="account_02-1.html"> -->
<!--           <span class="no">3</span> -->
<!--           <span class="update_time">111-09-02</span> -->
<!--           <span class="tax_id_number">79459910</span> -->
<!--           <span class="company_name">OO股份有限公司</span> -->
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="account_02-1.html"> -->
<!--           <span class="no">4</span> -->
<!--           <span class="update_time">111-09-02</span> -->
<!--           <span class="tax_id_number">51278064</span> -->
<!--           <span class="company_name">OO股份有限公司</span> -->
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="account_02-1.html"> -->
<!--           <span class="no">5</span> -->
<!--           <span class="update_time">111-09-02</span> -->
<!--           <span class="tax_id_number">22345678</span> -->
<!--           <span class="company_name">OOOO股份有限公司</span> -->
<!--           </a> -->
<!--         </li> -->
      </ol>
      
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
      
      <form action="account02_1" method="post" id="dataForm">
      	<input type="hidden" id="dataSeq" name="seq">
      	<input type="hidden" id="id" name="id">
      	<input type="hidden" name="account" value=${account }>
      </form>
      
      
    </div>
      
      
      

    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  
  <script src="js/account/account02.js"></script>
  




</body>




</html>
