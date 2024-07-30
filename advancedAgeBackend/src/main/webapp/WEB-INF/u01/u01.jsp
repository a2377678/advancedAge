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
<script type="text/javascript" src="js/jspdf.min.js"></script>
<script type="text/javascript" src="js/html2canvas.min.js"></script>

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
      <div id="main_title">審件與核定
        <span>案件審核</span>
        <span id="number">U01</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout?account=${account }">登出</a>
      </div>
      

      <!------------------- search ------------------->
      <c:if test="${functionPermission3.indexOf('U01')!=-1 }">
      <form action="u01" method="post" id="searchForm">
      <input type="text" name="account" value="${account }" style="display:none">
      <div id="search_bar">
        <table class="table_01">
          <tr>
              <th width="20%">統一編號 / 扣繳編號：</th>
              <td width="20%"><input type="text" size="11" id="seq" name="seq" value="${base.seq }"></td>
              <th width="10%">案件狀態：</th>
              <td colspan="2">
              <label><input name="caseStatus" type="radio" id="caseStatus" class="radio" value="1、2、3" <c:if test="${base.caseStatus=='1、2、3' || base.caseStatus==null}">checked</c:if>/>
              不限</label>
              <label><input name="caseStatus" type="radio" id="caseStatus1" class="radio" value="1" <c:if test="${base.caseStatus=='1' || base.caseStatus==null}">checked</c:if>/>
              待審</label>
              <label><input name="caseStatus" type="radio" id="caseStatus2" class="radio" value="2" <c:if test="${base.caseStatus=='2'}">checked</c:if>/>
              不合格</label>
              <label><input name="caseStatus" type="radio" id="caseStatus3" class="radio" value="3" <c:if test="${base.caseStatus=='3'}">checked</c:if>/>
              合格</label>
              
              </td>
          </tr>
            <tr>
              <th>承辦單位 / 行政區：</th>
              <td><select name="unit" id="unit">
                <c:if test="${unit=='F' }">
					<option value>不限</option>                
	                <c:forEach  items="${unitList}"  var="item"  varStatus="userStatus">
	                	<c:if test="${item.code!='F' }">
			      			<option value="${item.code}" <c:if test="${base.unit==item.code}">selected</c:if> >${item.name}</option>
			      		</c:if>
			      	</c:forEach>
		      	</c:if>
		      	<c:if test="${unit!='F' }">
		      		<c:forEach  items="${unitList}"  var="item"  varStatus="userStatus">
		      			<c:if test="${unit==item.code}">
		      				<option value="${item.code}" selected>${item.name}</option>
		      			</c:if>
		      		</c:forEach>
		      	</c:if>
              </select></td>
              <th>&nbsp;</th>
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
          <span class="update_type">案件狀態</span>
          <span class="district">承辦單位</span>
          <span class="auditor_first">承辦人員</span>
      </div>
      
      <ol>
        <c:choose>
	        <c:when test="${not empty baseList}">
	      	<c:forEach items="${baseList}" var="item" varStatus="status">
		      	<li>
		          <a href="#" onclick="edit('${item.seq }','${item.year }','${item.id}')">
		          <span class="no">${status.count}</span>
		          <span class="update_time">${item.createTime.substring(0,4)-1911}${item.createTime.substring(4,10)}</span>
		          <span class="tax_id_number">${item.seq }</span>
		          <span class="company_name">${item.companyName }</span>
		          <span class="update_type"><c:choose><c:when test="${item.fileStatus!='4'}">缺件</c:when><c:when test="${item.fileStatus=='4' && item.caseStatus=='1'}">待審</c:when><c:when test="${item.fileStatus=='4' && item.caseStatus=='2'}">不合格</c:when><c:when test="${item.fileStatus=='4' && item.caseStatus=='3'}">合格</c:when></c:choose></span>
	          	  <span class="district">
		          	<c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
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
      
      <form action="u01_1" method="post" id="dataForm">
      	<input type="text" id="dataSeq" name="seq" style="display:none">
      	<input type="text" id="applyYear" name="applyYear" style="display:none">
      	<input type="text" id="dataId" name="id" style="display:none">
      	<input type="text" name="account" value="${account }" style="display:none">
      </form>
    </div>
    </c:if>
    <c:if test="${functionPermission3.indexOf('U01')==-1 }"><p>無此權限</p></c:if> 
      
      

    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  
  
<script src="js/u01/u01.js"></script>  




</body>




</html>
