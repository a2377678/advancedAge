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
<!--     <div id="top_logo"><a href="index"><img src="images/logo.png" /></a></div> -->
<!--   </div> -->
  <%@ include file="../header.jsp" %>
  <!---------------------- top end ---------------------->

    
  <div id="main_menu">
    <div><a href="#" class="menu-1 in">繼續僱用高齡者</a></div>
    <div><a href="#" class="menu-2">傳承專業技術與經驗</a></div>
    <div><a href="#" class="menu-3">退休後再就業準備協助措施</a></div>
    <div><a href="account01?account=${account }" class="account">申請帳號審核管理</a></div>
  </div>

  <!---------------------- left menu ---------------------->
  <%@ include file="../leftMenu.jsp" %>
<!--   <div id="left_menu"> -->
<!--     <div class="panel-group" id="accordion"> -->
    
<!--     -------- collapse1 -------- -->
<!-- 	<div class="panel panel-default"> -->
<!-- 		<div class="panel-heading-in"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">收件與補件</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse1" class="panel-collapse collapse in"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="../a01/a01">案件查詢</a></li> -->
<!--                   <li><a href="../a02/a02" class="in">附件檢查與通知</a></li> -->
<!--                   <li><a href="../a03/a03">回傳案件</a></li> -->
<!--                 </ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
    
<!--     -------- collapse2 -------- -->
<!-- 	<div class="panel panel-default"> -->
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">查核與撥款</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse2" class="panel-collapse collapse"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="../b01/b01-1">案件審核</a></li> -->
<!--                   <li><a href="../b02/b02">登錄停止補助名單</a></li> -->
<!--                   <li><a href="../b03/b03">核定清冊／請款</a></li> -->
<!--                   <li><a href="../b04/b04">核銷案件</a></li> -->
<!--                 </ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->

    
    
<!--     -------- collapse8 -------- -->
<!--     <div class="panel panel-default"> -->
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 				<a data-toggle="collapse" data-parent="#accordion" href="#collapse8">彙整與統計</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse8" class="panel-collapse collapse"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="../index" class="in">統計儀錶板</a></li> -->
<!--                   <li><a href="#">行業(職業)別統計</a></li> -->
<!--                   <li><a href="#">申請單位屬性統計</a></li> -->
<!--                   <li><a href="#">補助金額統計</a></li> -->
<!--                   <li><a href="#">近3年申請情形統計</a></li> -->
<!--                   <li><a href="#">繼續僱用金額統計</a></li> -->
<!--                   <li><a href="#">繼續僱用人數統計</a></li> -->
<!--                   <li><a href="#">原有薪資級距統計</a></li> -->
<!--                   <li><a href="#">年齡區間統計</a></li> -->
<!--                 </ul> -->
<!-- 		  </div> -->
<!-- 		</div> -->
<!-- 	</div>     -->


    
    
<!--     -------- collapse10 -------- -->
<!--     <div class="panel panel-default"> -->
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 				<a data-toggle="collapse" data-parent="#accordion" href="#collapse10">系統管理</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse10" class="panel-collapse collapse"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="../j01/j01">使用者資料維護</a></li> -->
<!--                   <li><a href="../j02/j02">使用者帳號與權限</a></li> -->
<!--                   <li><a href="../j03/j03">群組權限管理</a></li> -->
<!--                   <li><a href="../j04/j04">系統登入紀錄</a></li> -->
<!--                 </ul> -->
<!-- 		  </div> -->
<!-- 		</div> -->
<!-- 	</div> -->
    
    
<!--   </div> -->
<!--   </div> -->
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
        	${unitName} &nbsp;${name}</a>
        <a href="logout?account=${account }"">登出</a>
      </div>
      

      <!------------------- search ------------------->
      <c:if test="${functionPermission.indexOf('A01')!=-1 }">
<%--       <%if(String.valueOf(functionPermission).indexOf("A01")!=-1){ %> --%>
<%--       <%if(String.valueOf(session.getAttribute("functionPermission")).indexOf("A01")!=-1){ %> --%>
      <form action="a01" method="post" id="searchForm">
      <input type="hidden" name="year" value="${year}">
      <input type="hidden" name="account" value="${account}">
      <div id="search_bar">
        <table class="table_01">
          <tr>
              <th width="20%">統一編號 / 扣繳編號：</th>
              <td width="20%"><input type="text" size="11" id="seq" name="seq" value="${base.seq}"></td>
              <th width="10%">附件狀態：</th>
              <td><label>
                <input name="fileStatus" type="radio" id="fileStatus_1" class="radio" <c:if test="${base.fileStatus==1 || base.fileStatus==null}">checked="checked"</c:if> value="1">
                待審</label>
                <label>
                  <input name="fileStatus" type="radio" id="fileStatus_2" class="radio" <c:if test="${base.fileStatus==2}">checked="checked"</c:if> value="2">
                  須補件</label>
                <label>
                  <input name="fileStatus" type="radio" id="fileStatus_3" class="radio" <c:if test="${base.fileStatus==3}">checked="checked"</c:if> value="3">
                  已補件</label></td>
              <td width="22%">&nbsp;</td>
          </tr>
            <tr>
              <th>承辦單位 / 行政區：</th>
              <td><select name="unit" id="unit">
                <option value>不限</option>
                <c:forEach  items="${unitList}"  var="item"  varStatus="userStatus">
		      		<option value="${item.code}" <c:if test="${base.unit==item.code}">selected</c:if> >${item.name}</option>
		      	</c:forEach>
<!--                 <option>勞動力發展署</option> -->
<!--                 <option>台北 (市/分署)</option> -->
<!--                 <option>高雄 (市/分署)</option> -->
<!--                 <option>桃園 (市/分署)</option> -->
<!--                 <option>台中 (市/分署)</option> -->
<!--                 <option>台南 (市/分署)</option> -->
              </select></td>
              <th>&nbsp;</th>
              <td>&nbsp;</td>
              <td>
              <div class="btn_box-td">
                <button type="submit" class="btn_01" value="開始查詢">開始查詢</button>
                <button type="reset" class="btn_02" value="清除">清除</button>
              </div>
              </td>
            </tr>
        </table>
      </div>
      <input type="hidden" name="numbersOfPage" value="${pagination.numbersOfPage}"/>
      <input type="hidden" name="page" id="page" value="${pagination.page}"/>
      <input type="hidden" name="totalNumbers" value="${pagination.totalNumbers}"/>
      <input type="hidden" name="totalPages" value="${pagination.totalPages}"/>
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
		          <span class="update_time">${item.updateTime.substring(0,4)-1911}${item.updateTime.substring(4,10)}</span>
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
<!--         <li> -->
<!--           <a href="file" target="blank"> -->
<!--           <span class="no">1</span> -->
<!--           <span class="update_time">111-09-01</span> -->
<!--           <span class="tax_id_number">85561470</span> -->
<!--           <span class="company_name">資訊科技股份有限公司</span> -->
<!--           <span class="update_type">缺件</span> -->
<!--           <span class="district">勞動力發展署</span> -->
<!--           <span class="auditor_first"></span> -->
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="file" target="blank"> -->
<!--           <span class="no">2</span> -->
<!--           <span class="update_time">111-09-01</span> -->
<!--           <span class="tax_id_number">66320005</span> -->
<!--           <span class="company_name">OO資訊股份有限公司</span> -->
<!--           <span class="update_type">已附待審</span> -->
<!--           <span class="district">台北 (市/分署)</span> -->
<!--           <span class="auditor_first"></span> -->
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="file" target="blank"> -->
<!--           <span class="no">3</span> -->
<!--           <span class="update_time">111-09-02</span> -->
<!--           <span class="tax_id_number">79459910</span> -->
<!--           <span class="company_name">OO股份有限公司</span> -->
<!--           <span class="update_type">已附待審</span> -->
<!--           <span class="district">台中 (市/分署)</span> -->
<!--           <span class="auditor_first"></span> -->
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="file" target="blank"> -->
<!--           <span class="no">4</span> -->
<!--           <span class="update_time">111-09-02</span> -->
<!--           <span class="tax_id_number">51278064</span> -->
<!--           <span class="company_name">OO股份有限公司</span> -->
<!--           <span class="update_type">缺件</span> -->
<!--           <span class="district">勞動力發展署</span> -->
<!--           <span class="auditor_first">張OO</span> -->
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="file" target="blank"> -->
<!--           <span class="no">5</span> -->
<!--           <span class="update_time">111-09-02</span> -->
<!--           <span class="tax_id_number">22345678</span> -->
<!--           <span class="company_name">OOOO股份有限公司</span> -->
<!--           <span class="update_type">已附待審</span> -->
<!--           <span class="district">高雄 (市/分署)</span> -->
<!--           <span class="auditor_first">張OO</span> -->
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
<!--       <div class="page_number"> -->
<!--         <span><a href="#">|<</a></span> -->
<!--         <span><a href="#"><</a></span> -->
<!--         <span><a href="#" class="in">1</a></span> -->
<!--         <span><a href="#">2</a></span> -->
<!--         <span><a href="#">3</a></span> -->
<!--         <span><a href="#">></a></span> -->
<!--       </div> -->
      <form action="file" method="post" id="dataForm" target="_blank">
      	<input type="hidden" id="dataSeq" name="seq">
      	<input type="hidden" id="applyYear" name="applyYear">
      	<input type="hidden" id="dataId" name="id">
      	<input type="hidden" name="account" value="${account }">
      </form>
      
    </div>
    </c:if>
    <c:if test="${functionPermission.indexOf('A01')==-1 }"><p>無此權限</p></c:if>  
<%--     <%}else{ %> --%>
<!--   		<p>無此權限</p> -->
<%--   	<%} %> --%>
      
      

    </div>
    
  </div>
  <!---------------------- main ---------------------->

<script src="js/a01/a01.js"></script>

</body>




</html>
