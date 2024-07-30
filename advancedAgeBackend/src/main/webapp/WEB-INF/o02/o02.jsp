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
<script type="text/javascript" src="js/o02/o02.js"></script>

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
      <div id="main_title">案件審查
        <span>實地查核登錄</span>
        <span id="number">O02</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      
		<c:if test="${functionPermission2.indexOf('O02')!=-1 }">
      <!------------------- table 1 ------------------->
        <div id="page_tab">
          <div class="tab-1"><a href="o02" class="in">查詢 / 修改紀錄</a></div>
          <div class="tab-1"><a href="o02_02">實地查核登錄</a></div>
          <div class="tab-1"><a href="/file/SAMPLE/傳承經驗_查核計畫.docx">訪視表單下載</a></div>
        </div>
      
      
      <!------------------- search ------------------->
      <form action="o02" method="post" id="searchForm">
      <div id="search_bar">
        <table class="table_01">
          <tr>
            <th width="20%">統一編號 / 扣繳編號：</th>
            <td width="20%"><input type="text" size="11" id="seq" name="seq" value="${siteInspection.seq}"></td>
            <th width="10%">訪視結果：</th>
            <td><label>
              <input name="result" type="radio" id="result0" class="radio" value="" <c:if test="${empty siteInspection.result}">checked</c:if>/>
                全部</label>
              <label>
                <input name="result" type="radio" id="result1" class="radio" value="1" <c:if test="${not empty siteInspection.result && siteInspection.result!='3'}">checked</c:if>/>
                符合</label>
              <label>
                <input name="result" type="radio" id="result2" class="radio" value="3" <c:if test="${siteInspection.result=='3'}">checked</c:if>/>
                未符合</label></td>
            <td width="22%">&nbsp;</td>
          </tr>
          <tr>
            <th>承辦單位 / 行政區：</th>
            <td><select name="unit" id="unit">
            	<c:if test="${unit=='F' }">
					<option value>不限</option>                
	                <c:forEach  items="${unitList}"  var="item"  varStatus="userStatus">
	                	<c:if test="${item.code!='F' }">
			      			<option value="${item.code}" <c:if test="${siteInspection.unit==item.code}">selected</c:if> >${item.name}</option>
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
            <td><div class="btn_box-td">
              <button type="submit" class="btn_01" value="開始查詢">開始查詢</button>
              <button type="reset" class="btn_02" value="清除">清除</button>
            </div></td>
          </tr>
        </table>
      </div>
      <input type="text" name="numbersOfPage" value="${pagination.numbersOfPage}" style="display:none">
      <input type="text" name="page" id="page" value="${pagination.page}" style="display:none">
      <input type="text" name="totalNumbers" value="${pagination.totalNumbers}" style="display:none">
      <input type="text" name="totalPages" value="${pagination.totalPages}" style="display:none">
      </form>
      <!------------------- list ------------------->
      <div class="audit_list">
    
        <div class="title">
          <span class="no"></span>
          <span class="update_time">訪視日期</span>
          <span class="tax_id_number">統編/扣繳</span>
          <span class="company_name">申請單位名稱</span>
          <span class="update_type">訪視結果</span>
          <span class="district">承辦單位</span>
       </div>
      
      <ol>
	      <c:choose><c:when test="${not empty siteInspectionData}">
	      	<c:forEach items="${siteInspectionData}" var="item" varStatus="status">
		      	<li>
		          <a href="#" onclick="edit('${item.id}')">
		          <span class="no">${status.count}</span>
		          <span class="update_time">${item.inspectDate}</span>
		          <span class="tax_id_number">${item.seq }</span>
		          <span class="company_name">${item.companyName }</span>
		          <span class="update_type">
		          	<c:if test="${not empty item.result}">${item.result==3?'未符合':'符合'}</c:if>
			        <c:if test="${empty item.result}"></c:if>
		          </span>
		          <span class="district">
		          	<c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
			      		<c:if test="${item.unit==unitItem.code}">${unitItem.name}</c:if> 
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
      
      <form action="o02_1" method="post" id="dataForm">
      	<input type="text" id="id" name="id" style="display:none">
      	<input type="text" id="searchSeq" name="searchSeq" style="display:none">
      	<input type="text" id="searchResult" name="searchResult" style="display:none">
      	<input type="text" id="searchUnit" name="searchUnit" style="display:none">
      </form>
      
      
    </div>
    </c:if>
      <c:if test="${functionPermission2.indexOf('O02')==-1 }"><p>無此權限</p></c:if>
      

    </div>
    
  </div>
  <!---------------------- main ---------------------->
  

</body>




</html>
