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
<link href="css/jquery-confirm.min.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jspdf.min.js"></script>
<script type="text/javascript" src="js/html2canvas.min.js"></script>
<script type="text/javascript" src="js/jquery-confirm.min.js"></script>
<script type="text/javascript" src="js/s01/s01_division.js"></script>
</head>
<style type="text/css">
	.jconfirm-buttons button {
     	color:#333!important
	}
</style>


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
      <div id="main_title">案件審查
        <span>案件分案</span>
        <span id="number">S01d</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName}&nbsp;${name}</a>
        <a href="logout">登出</a>
      </div>
      

      <!------------------- search ------------------->
      <c:if test="${jurisdiction==1 }">
      <form action="s01_division" method="post" id="searchForm">
      <div id="search_bar">
        <table class="table_01">
          <tr>
            <th width="15%">申請年度：</th>
            <td><select name="year" id="year">
                <option value>不限</option>
                <option value="113" <c:if test="${base.year=='113' }">selected</c:if>>113年</option>
                <option value="112" <c:if test="${base.year=='112' }">selected</c:if>>112年</option>
                <option value="111" <c:if test="${base.year=='111' }">selected</c:if>>111年</option>
                <option value="110" <c:if test="${base.year=='110' }">selected</c:if>>110年</option>
              </select></td>
            <th width="18%">統編 / 扣繳編號：</th>
            <td><input type="text" size="11" id="seq" name="seq" value="${base.seq}"></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <th>承辦單位：</th>
            <td><select name="unit" id="unit">
                <c:if test="${unit=='F' }">
					<option value>不限</option>                
	                <c:forEach  items="${unitList}"  var="item"  varStatus="userStatus">
	                	<c:if test="${item.code!='F' }">
			      			<option value="${item.code}" <c:if test="${base.unit==item.code}">selected</c:if> >${item.name}</option>
			      		</c:if>
			      	</c:forEach>
		      	</c:if>
              </select></td>
            <th>申請單位名稱：</th>
            <td><input type="text" size="11" id="companyName" name="companyName" value="${base.companyName}"></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <th>縣市別：</th>
            <td>
              	<select name="city" id="city">
              		<option value>不限</option>
	              	<c:forEach  items="${cityList}"  var="item"  varStatus="userStatus">
			      		<option value="${item.code}" <c:if test="${base.city==item.code}">selected</c:if>>${item.name}</option>
			      	</c:forEach>
              	</select>
            </td>
            <th>案件狀態：</th>
            <td>
              <select name="caseStatus" id="caseStatus">
                <option value>不限</option>
                <option value="1" <c:if test="${base.caseStatus=='1' }">selected</c:if>>案件待審</option>
                <option value="2" <c:if test="${base.caseStatus=='2' }">selected</c:if>>案件不合格</option>
                <option value="3" <c:if test="${base.caseStatus=='3' }">selected</c:if>>案件合格(待核定)</option>
                <option value="4" <c:if test="${base.caseStatus=='4' }">selected</c:if>>已核定</option>
                <option value="8" <c:if test="${base.caseStatus=='8' }">selected</c:if>>不于補助</option>
                <option value="5" <c:if test="${base.caseStatus=='5' }">selected</c:if>>待核銷</option>
                <option value="6" <c:if test="${base.caseStatus=='6' }">selected</c:if>>核銷不合格</option>
                <option value="7" <c:if test="${base.caseStatus=='7' }">selected</c:if>>已核銷</option>
              </select>
              </td>
            <td>
            	<div class="center btn_box-td">
                	<button type="button" class="btn_01" value="開始查詢" onclick="searchList()" >開始查詢</button>
                	<button type="reset" class="btn_02" value="清除">清除</button>
              	</div>
            </td>
          </tr>
        </table>
      </div>
      <input type="text" name="numbersOfPage" value="${pagination.numbersOfPage}" style="display:none"/>
      <input type="text" name="page" id="page" value="${pagination.page}" style="display:none"/>
      <input type="text" name="totalNumbers" value="${pagination.totalNumbers}" style="display:none"/>
      <input type="text" name="totalPages" value="${pagination.totalPages}" style="display:none"/>
      </form>
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
				      	<li>
				          <span class="no">${status.count}</span>
				          <span class="update_time">${item.createTime.substring(0,4)-1911}${item.createTime.substring(4,10)}</span>
				          <span class="tax_id_number">${item.seq }</span>
				          <span class="company_name">${item.companyName }</span>
				          <span class="case_status"><c:choose>
				          <c:when test="${item.caseStatus=='1'}">待審</c:when>
				          <c:when test="${item.caseStatus=='2'}">不合格</c:when>
				          <c:when test="${item.caseStatus=='3'}">合格</c:when>
				          <c:when test="${item.caseStatus=='4'}">已核定</c:when>
				          <c:when test="${item.caseStatus=='8'}">不予補助</c:when>
				          <c:when test="${item.caseStatus=='5'}">待核銷</c:when>
				          <c:when test="${item.caseStatus=='6'}">已核銷不合格</c:when>
				          <c:when test="${item.caseStatus=='7'}">已核銷</c:when>
				          </c:choose></span>
				          <span class="district">
				          	<input type="hidden" id="baseAaid${status.count}" value="${item.aaid}">
				          	<select name="changeUnit${status.count}" id="changeUnit${status.count}">
				          		<c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
				          			<option value="${unitItem.code}" <c:if test="${item.unit==unitItem.code}">selected</c:if>>${unitItem.name}</option>
					      		</c:forEach>
					      	</select>
					      </span>
				          <span class="auditor_first">
				          	<c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
					      		<c:if test="${item.verifyPerson==userItem.id}">${userItem.name}</c:if> 
					      	</c:forEach>
				          </span>
				        </li>
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
      
    	</div>
      </c:if>
      <c:if test="${jurisdiction!=1 }"><p>無此權限</p></c:if>

    </div>
    
  </div>
  <!---------------------- main ---------------------->
  

</body>




</html>
