<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<title>促進中高齡者及高齡者就業相關補助計畫系統</title>

<link href="css/file.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/c01/c01.js"></script>
</head>



<body>


  <!---------------------- top ---------------------->
  <%@ include file="../header.jsp" %>
<!--   <div id="top"> -->
<!--     <div id="top_logo"><a href="index"><img src="images/logo.png" /></a></div> -->
<!--   </div> -->
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
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">收件與補件</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse1" class="panel-collapse collapse in"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="a01/a01">附件檢查與通知</a></li> -->
<!--                   <li><a href="a02/a02">補件回傳案件</a></li> -->
<!--                 </ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
    
<!--     -------- collapse2 -------- -->
<!-- 	<div class="panel panel-default"> -->
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">案件審查</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse2" class="panel-collapse collapse in"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="b01/b01">申請案件查詢</a></li> -->
<!--                   <li><a href="b02/b02">案件審核</a></li> -->
<!--                   <li><a href="b03/b03">停止補助名單</a></li> -->
<!--                   <li><a href="b04/b04">實地查核登錄</a></li> -->
<!--                 </ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
    
<!--     -------- collapse3 -------- -->
<!-- 	<div class="panel panel-default"> -->
<!-- 		<div class="panel-heading-in"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">請款與核銷</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse3" class="panel-collapse collapse in"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="c01/c01" class="in">請領作業</a></li> -->
<!--                   <li><a href="c02/c02">案件核銷</a></li> -->
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
<!--                   <li><a href="index" class="in">統計概況 (儀錶板)</a></li> -->
<!--                   <li><a href="#">繼續僱用申請人數</a></li> -->
<!--                   <li><a href="#">繼續僱用補助金額</a></li> -->
<!--                   <li><a href="#">原有薪資級距</a></li> -->
<!--                   <li><a href="#">申請單位行業別</a></li> -->
<!--                   <li><a href="#">申請單位補助金額</a></li> -->
<!--                   <li><a href="#">申請單位申請情形</a></li> -->
<!--                 </ul> -->
<!-- 		  </div> -->
<!-- 		</div> -->
<!-- 	</div>     -->


    
    
<!--     -------- collapse10 -------- -->
<!--     <div class="panel panel-default"> -->
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 				<a data-toggle="collapse" data-parent="#accordion" href="#collapse10">權限與系統管理</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse10" class="panel-collapse collapse"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="j01/j01">使用者資料維護</a></li> -->
<!--                   <li><a href="j02/j02">使用者帳號與權限</a></li> -->
<!--                   <li><a href="j03/j03">群組權限管理</a></li> -->
<!--                   <li><a href="j04/j04">系統登入紀錄</a></li> -->
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
      <div id="main_title">請款與核銷
        <span>請領作業</span>
        <span id="number">C01</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName}&nbsp;${name}</a>
        <a href="logout?account=${account }">登出</a>
      </div>
      

      <!------------------- search ------------------->
      <form action="c01" method="post">
      <input type="hidden" name="account" value="${account }"/>
      <div id="search_bar">
        <table class="table_01">
          <tr>
              <th width="20%">統一編號 / 扣繳編號：</th>
              <td width="20%"><input type="text" size="11" id="seq" name="seq" value="${base.seq }"></td>
              <th width="10%">案件狀態：</th>
              <td>
              <label><input name="caseStatus" type="radio" id="caseStatus5、6" class="radio" value="5、6" <c:if test="${base.caseStatus=='5、6' || base.caseStatus==null}">checked</c:if>/>
              不限</label>
              <label><input name="caseStatus" type="radio" id="caseStatus5" class="radio" value="5" <c:if test="${base.caseStatus=='5'}">checked</c:if>/>
              待核銷</label>
              <label><input name="caseStatus" type="radio" id="caseStatus6" class="radio" value="6" <c:if test="${base.caseStatus=='6'}">checked</c:if>/>
              已核銷</label>
              </td>
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
      
      </form>
      
      
      
      <!------------------- list ------------------->
      <div class="audit_list">
    
      <div class="title">
          <span class="no"></span>
          <span class="update_time">請領日期</span>
          <span class="tax_id_number">統編/扣繳</span>
          <span class="company_name">申請單位名稱</span>
          <span class="update_type">案件狀態</span>
          <span class="district">承辦單位</span>
          <span class="auditor_first">審核人員</span>
      </div>
      
      <ol>
	      <c:choose><c:when test="${not empty baseList}">
	      	<c:forEach items="${baseList}" var="item" varStatus="status">
		      	<li>
		          <a href="#" onclick="edit('${item.seq }','${item.year }','${item.id}')">
		          <span class="no">${status.count}</span>
		          <span class="update_time">${item.updateTime.substring(0,4)-1911}${item.updateTime.substring(4,10)}</span>
		          <span class="tax_id_number">${item.seq }</span>
		          <span class="company_name">${item.companyName }</span>
		          <span class="update_type"><c:choose><c:when test="${item.caseStatus=='5'}">待核銷</c:when><c:when test="${item.caseStatus=='6'}">已核銷</c:when></c:choose></span>
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
<!--         <li> -->
<!--           <a href="c01-1" target="blank"> -->
<!--           <span class="no">1</span> -->
<!--           <span class="update_time">111-12-01</span> -->
<!--           <span class="tax_id_number">85561470</span> -->
<!--           <span class="company_name">資訊科技股份有限公司</span> -->
<!--           <span class="update_type">待審</span> -->
<!--           <span class="district">勞動力發展署</span> -->
<!--           <span class="auditor_first"></span> -->
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="c01-1" target="blank"> -->
<!--           <span class="no">2</span> -->
<!--           <span class="update_time">111-12-01</span> -->
<!--           <span class="tax_id_number">66320005</span> -->
<!--           <span class="company_name">OO資訊股份有限公司</span> -->
<!--           <span class="update_type">待審</span> -->
<!--           <span class="district">勞動力發展署</span> -->
<!--           <span class="auditor_first"></span> -->
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="c01-1" target="blank"> -->
<!--           <span class="no">3</span> -->
<!--           <span class="update_time">111-12-02</span> -->
<!--           <span class="tax_id_number">79459910</span> -->
<!--           <span class="company_name">OO股份有限公司</span> -->
<!--           <span class="update_type">待審</span> -->
<!--           <span class="district">勞動力發展署</span> -->
<!--           <span class="auditor_first"></span> -->
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="c01-1" target="blank"> -->
<!--           <span class="no">4</span> -->
<!--           <span class="update_time">111-12-02</span> -->
<!--           <span class="tax_id_number">51278064</span> -->
<!--           <span class="company_name">OO股份有限公司</span> -->
<!--           <span class="update_type">審核中</span> -->
<!--           <span class="district">勞動力發展署</span> -->
<!--           <span class="auditor_first">張OO</span> -->
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="c01-1" target="blank"> -->
<!--           <span class="no">5</span> -->
<!--           <span class="update_time">111-12-02</span> -->
<!--           <span class="tax_id_number">22345678</span> -->
<!--           <span class="company_name">OOOO股份有限公司</span> -->
<!--           <span class="update_type">審核中</span> -->
<!--           <span class="district">勞動力發展署</span> -->
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
      
      <form action="c01_1" method="post" id="dataForm">
      	<input type="hidden" id="dataSeq" name="seq">
      	<input type="hidden" id="applyYear" name="applyYear">
      	<input type="hidden" id="dataId" name="id">
      	<input type="hidden" name="account" value="${account }"/>
      </form>
      
      
    </div>
      
      
      

    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  
  
  




</body>




</html>
