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
      <div id="main_title">案件審查
        <span>申請案件查詢</span>
        <span id="number">B01</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName}&nbsp;${name}</a>
        <a href="logout">登出</a>
      </div>
      

      <!------------------- search ------------------->
      <c:if test="${functionPermission.indexOf('B01')!=-1 }">
      <form action="b01" method="post" id="searchForm">
      <div class="case_search-left" id="search_bar">
          <table class="table_01">
            <tr>
              <th width="26%">申請年度：</th>
              <td><select name="year" id="year">
                <option value>不限</option>
                <option value="111" <c:if test="${base.year=='111' }">selected</c:if>>111年</option>
                <option value="110" <c:if test="${base.year=='110' }">selected</c:if>>110年</option>
              </select></td>
              <th width="28%">統一編號 / 扣繳編號：</th>
              <td><input type="text" size="11" id="seq" name="seq" value="${base.seq}"></td>
            </tr>
            <tr>
              <th>承辦單位 / 行政區：</th>
              <td><select name="unit" id="unit">
                <option value>不限</option>
                <c:forEach  items="${unitList}"  var="item"  varStatus="userStatus">
		      		<option value="${item.code}" <c:if test="${base.unit==item.code}">selected</c:if> >${item.name}</option>
		      	</c:forEach>
              </select></td>
              <th>申請單位名稱：</th>
              <td><input type="text" size="11" id="companyName" name="companyName" value="${base.companyName}"></td>
            </tr>
            <tr>
              <th>案件狀態：</th>
              <td>
              <select name="caseStatus" id="caseStatus">
                <option value>不限</option>
                <option value="1" <c:if test="${base.caseStatus=='1' }">selected</c:if>>案件待審</option>
                <option value="2" <c:if test="${base.caseStatus=='2' }">selected</c:if>>案件不合格</option>
                <option value="3" <c:if test="${base.caseStatus=='3' }">selected</c:if>>案件合格</option>
                <option value="4" <c:if test="${base.caseStatus=='4' }">selected</c:if>>待核定</option>
                <option value="5" <c:if test="${base.caseStatus=='5' }">selected</c:if>>已核定(待核銷)</option>
                <option value="6" <c:if test="${base.caseStatus=='6' }">selected</c:if>>已核銷</option>
              </select>
              </td>
              <th>&nbsp;</th>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td height="80" colspan="4">
              <div class="center btn_box-td">
                <button type="submit" class="btn_01" value="開始查詢">開始查詢</button>
                <button type="reset" class="btn_02" value="清除">清除</button>
              </div>
              </td>
            </tr>
          </table>
          
          
      
      </div>
      </form>
      <!------------------- stats ------------------->
      <c:set var="apply" value="${totalBaseList.size()}"/>
      <c:set var="add" value="0"/>
      <c:set var="success" value="0"/>
      <c:forEach items="${totalBaseList}" var="item" varStatus="status">
      	<c:if test="${item.fileStatus != '4' }"><c:set var="add" value="${add+1 }"/></c:if>
      	<c:if test="${item.fileStatus == '4' }"><c:set var="success" value="${success+1 }"/></c:if>
      </c:forEach>
      <div class="stats">
        <div class="title">
        ${year}年度申辦概況</div>
        <div>申請件數<span class="t1">${apply }</span></div>
        <div>補件件數<span class="t2">${add }</span></div>
        <div>通過件數<span class="t3">${success }</span></div>
      </div>
      
      <!------------------- list ------------------->
      <div class="audit_list">
    
      <div class="title">
          <span class="no"></span>
          <span class="update_time">申請日期</span>
          <span class="tax_id_number">統編/扣繳</span>
          <span class="company_name">申請單位名稱</span>
          <span class="case_status">案件狀態</span>
          <span class="district">承辦單位</span>
          <span class="auditor_first">查核人員</span>
      </div>
      
      <ol>
      	<c:choose>
	      	<c:when test="${not empty baseList}">
		      	<c:forEach items="${baseList}" var="item" varStatus="status">
		      		<c:if test="${item.fileStatus==4 }">
				      	<li>
				          <a href="#" onclick="edit('${item.seq }','${item.year }','${item.id}')">
				          <span class="no">${status.count}</span>
				          <span class="update_time">${item.updateTime.substring(0,4)-1911}${item.updateTime.substring(4,10)}</span>
				          <span class="tax_id_number">${item.seq }</span>
				          <span class="company_name">${item.companyName }</span>
				          <span class="case_status"><c:choose><c:when test="${item.fileStatus!='4'}">缺件</c:when><c:when test="${item.fileStatus=='4' && item.caseStatus=='1'}">待審</c:when><c:when test="${item.fileStatus=='4' && item.caseStatus=='2'}">不合格</c:when><c:when test="${item.fileStatus=='4' && item.caseStatus=='3'}">合格</c:when>
				          <c:when test="${item.fileStatus=='4' && item.caseStatus=='4'}">待核定</c:when>
				          <c:when test="${item.fileStatus=='4' && item.caseStatus=='5'}">已核定(待核銷)</c:when>
				          <c:when test="${item.fileStatus=='4' && item.caseStatus=='6'}">已核銷</c:when>
				          </c:choose></span>
				          <span class="district"><c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
						      		<c:if test="${item.verifyUnit==unitItem.code}">${unitItem.name}</c:if> 
					      	</c:forEach>
					      </span>
				          <span class="auditor_first">
				          	<c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
					      		<c:if test="${item.verifyPerson==userItem.id}">${userItem.name}</c:if> 
					      	</c:forEach>
				          </span>
				          </a>
				        </li>
					</c:if>
		      	</c:forEach>
	        </c:when>
      	</c:choose>
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
      
      
      <form action="b02_1" method="post" id="dataForm">
      	<input type="text" id="dataSeq" name="seq" style="display:none">
      	<input type="text" id="applyYear" name="applyYear" style="display:none">
      	<input type="text" id="dataId" name="id" style="display:none">
      </form>
      
    	</div>
    </c:if>
    <c:if test="${functionPermission.indexOf('B01')==-1 }"><p>無此權限</p></c:if>
    </div>
    
  </div>
  <!---------------------- main ---------------------->
  

<script src="js/b01/b01.js"></script>


</body>




</html>
