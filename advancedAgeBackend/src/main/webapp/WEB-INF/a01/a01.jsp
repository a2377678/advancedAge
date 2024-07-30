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
      <div id="main_title">收件與補件
        <span>附件檢查與通知</span>
        <span id="number">A01</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName}&nbsp;${name}</a>
        <a href="logout">登出</a>
      </div>
      

      <!------------------- search ------------------->
      <c:if test="${functionPermission.indexOf('A01')!=-1 }">
      <form action="a01" method="post" id="searchForm">
      <input type="text" name="year" value="${year}" style="display:none">
      <div id="search_bar">
        <table class="table_01">
          <tr>
              <th width="20%">統一編號 / 扣繳編號：</th>
              <td width="20%"><input type="text" size="11" id="seq" name="seq" value="${base.seq}"></td>
              <th width="10%">附件狀態：</th>
              <td colspan="2">
              <label>
                <input name="fileStatus" type="radio" id="fileStatus" class="radio" <c:if test="${base.fileStatus=='1、2、3' || base.fileStatus==null}">checked="checked"</c:if> value="1、2、3">
                不限</label>
              <label>
                <input name="fileStatus" type="radio" id="fileStatus_1" class="radio" <c:if test="${base.fileStatus=='1' || base.fileStatus==null}">checked="checked"</c:if> value="1">
                待審</label>
                <label>
                  <input name="fileStatus" type="radio" id="fileStatus_2" class="radio" <c:if test="${base.fileStatus=='2'}">checked="checked"</c:if> value="2">
                  須補件</label>
                <label>
                  <input name="fileStatus" type="radio" id="fileStatus_3" class="radio" <c:if test="${base.fileStatus=='3'}">checked="checked"</c:if> value="3">
                  已補件</label></td>
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
          <span class="update_type">附件狀態</span>
          <span class="district">承辦單位</span>
          <span class="auditor_first">查核人員</span>
      </div>
      
      <ol>
      <c:choose><c:when test="${not empty baseList}">
      	<c:forEach items="${baseList}" var="item" varStatus="status">
      		<c:if test="${item.fileStatus!=4}">
		      	<li>
		          <a href="#" onclick="openData('${item.seq }','${item.year }','${item.id}')">
		          <span class="no">${status.count}</span>
		          <span class="update_time">${item.createTime.substring(0,4)-1911}${item.createTime.substring(4,10)}</span>
		          <span class="tax_id_number">${item.seq }</span>
		          <span class="company_name">${item.companyName }</span>
		          <span class="update_type"><c:choose><c:when test="${item.fileStatus==1}">附件待審</c:when><c:when test="${item.fileStatus==2}">須補件</c:when><c:when test="${item.fileStatus==3}">已補件</c:when></c:choose></span>
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
      <form action="file" method="post" id="dataForm" target="_blank">
      	<input type="text" id="dataSeq" name="seq" style="display:none">
      	<input type="text" id="applyYear" name="applyYear" style="display:none">
      	<input type="text" id="dataId" name="id" style="display:none">
      </form>
      
    </div>
    </c:if>
    <c:if test="${functionPermission.indexOf('A01')==-1 }"><p>無此權限</p></c:if>  
      
    </div>
    
  </div>
  <!---------------------- main ---------------------->

<script src="js/a01/a01.js"></script>

</body>




</html>
