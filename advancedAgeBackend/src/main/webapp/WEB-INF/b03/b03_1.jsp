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
<script type="text/javascript" src="js/jquery-ui.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  
<style type="text/css">
.ui-datepicker {
	width: 20em; /*what ever width you want*/
}
</style>
</head>



<body>


  <!---------------------- top ---------------------->
<!--   <div id="top"> -->
<!--     <div id="top_logo"><a href="index.html"><img src="images/logo.png" /></a></div> -->
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
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">收件與補件</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse1" class="panel-collapse collapse in"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="a01/a01.html">附件檢查與通知</a></li> -->
<!--                   <li><a href="a02/a02.html">補件回傳案件</a></li> -->
<!--                 </ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
    
<!--     -------- collapse2 -------- -->
<!-- 	<div class="panel panel-default"> -->
<!-- 		<div class="panel-heading-in"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">案件審查</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse2" class="panel-collapse collapse in"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="b01/b01.html">申請案件查詢</a></li> -->
<!--                   <li><a href="b02/b02.html">案件審核</a></li> -->
<!--                   <li><a href="b03/b03.html" class="in">停止補助名單管理</a></li> -->
<!--                   <li><a href="b04/b04.html">實地查核登錄</a></li> -->
<!--                 </ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
    
<!--     -------- collapse3 -------- -->
<!-- 	<div class="panel panel-default"> -->
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">請款與核銷</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse3" class="panel-collapse collapse in"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="c01/c01.html">請款審核</a></li> -->
<!--                   <li><a href="c02/c02.html">案件核銷</a></li> -->
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
<!--                   <li><a href="index.html" class="in">統計概況 (儀錶板)</a></li> -->
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
<!--                   <li><a href="j01/j01.html">使用者資料維護</a></li> -->
<!--                   <li><a href="j02/j02.html">使用者帳號與權限</a></li> -->
<!--                   <li><a href="j03/j03.html">群組權限管理</a></li> -->
<!--                   <li><a href="j04/j04.html">系統登入紀錄</a></li> -->
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
      <div id="main_title">案件審查
        <span>停止補助名單管理</span>
        <span id="number">B03-1</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout?account=${account }">登出</a>
      </div>
      

      
      <!------------------- table 1 ------------------->
        <div id="page_tab">
          <div class="tab-1"><a href="b03?account=${account }" class="in">查詢 / 修改紀錄</a></div>
          <div class="tab-1"><a href="b03_02?account=${account }">停止補助名單登錄</a></div>
        </div>
      
      
      <!------------------- search ------------------->
      <form action="b03" method="post">
      <input type="hidden" name="account" value="${account }"/>
      <div id="search_bar">
        <table class="table_01">
          <tr>
            <th width="20%">統一編號 / 扣繳編號：</th>
            <td width="20%"><input type="text" size="11" id="seq" name="seq" value=${searchSeq}></td>
            <th width="12%">禁止起始日：</th>
            <td><input type="text" id="banStartDate" name="banStartDate" value="${searchBanStartDate}" size="11"></td>
            <td width="22%">&nbsp;</td>
          </tr>
          <tr>
            <th>承辦單位 / 行政區：</th>
            <td><select name="unit" id="unit">
                <option value>不限</option>
                <c:forEach  items="${unitList}"  var="item"  varStatus="userStatus">
		      		<option value="${item.code}" <c:if test="${searchUnit==item.code}">selected</c:if> >${item.name}</option>
		      	</c:forEach>
            </select></td>
            <th>禁止結束日：</th>
            <td><input type="text" id="banEndDate" name="banEndDate" value="${searchBanEndDate}" size="11"></td>
            <td><div class="btn_box-td">
              <button type="submit" class="btn_01" value="開始查詢">開始查詢</button>
              <button type="reset" class="btn_02" value="清除">清除</button>
            </div></td>
          </tr>
        </table>
      </div>
      </form>
      
      
      
      
      <!------------------- 設立停止補助名單 ------------------->
      <form>
      <input type="hidden" id="id" value="${blackListData.get('id')}">
      <input type="hidden" id="updator" value="${id }">
      <div class="file_title-2">詳細資訊</div>
        <table class="table_03">
          <tr>
            <th width="22%">事業單位名稱</th>
            <td width="25%">${blackListData.get("companyName")}</td>
            <th width="18%">統一編號 / 扣繳編號</th>
            <td>${blackListData.get("seq")}</td>
          </tr>
          <tr>
            <th>公文文號</th>
            <td colspan="3"><input type="text" id="officialDocumentNumber" name="officialDocumentNumber" value="${blackListData.get('officialDocumentNumber')}" size="24"></td>
          </tr>
          <tr>
            <th>上傳公文</th>
            <td colspan="3">
            
            <!---上傳檔案--->
            <div class="file_box" id="listFile">  
              <c:choose><c:when test="${not empty blackListAttachment}">
		      	<c:forEach items="${blackListAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='blackList'}">
				      		<div>
			                	<span class="file_name">
			                		<a href="/file${item.filePath}/${item.fileName}" class="visited" target="_blank">${item.fileName}</a>
			                	</span>
			              	</div>
				      	</c:when>
			      	</c:choose>
		      	</c:forEach>
		   	</c:when></c:choose>
              <div>
                <input type="file" id="blackListFile1" name="blackListFile">
                <button type="button" class="add" onclick="delBlackListFile(1)" >－</button>
                <button type="button" class="add" onclick="addBlackListFile(1)" style>＋</button>
              </div>
              
            </div>
            
            </td>
          </tr>
          <tr>
            <th>摘要說明</th>
            <td colspan="3"><textarea id="description" rows="5" style="width:700px">${blackListData.get("description").replace("\\n","&#13;&#10;")}</textarea>
              <br></td>
          </tr>
          <tr>
            <th>禁止起始日</th>
            <td><input type="text" placeholder="yyy-mm-dd" id="saveBanStartDate" value="${blackListData.get('banStartDate')}" size="20"></td>
            <th>禁止結束日</th>
            <td><input type="text" placeholder="yyy-mm-dd" id="saveBanEndDate" value="${blackListData.get('banEndDate')}" size="20"></td>
          </tr>
          <tr>
            <th>承辦單位</th>
            <td>
            	<c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
	      			<c:if test="${blackListData.get('unit')==unitItem.code}">${unitItem.name}</c:if> 
		      	</c:forEach>
            </td>
            <th>建檔人員</th>
            <td>
            <c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
		      		<c:if test="${blackListData.get('creator')==userItem.id}">${userItem.name}</c:if> 
	      	</c:forEach></td>
          </tr>
          <tr>
            <th>建檔日期</th>
            <td>${blackListData.get("createTime").substring(0,4)-1911}${blackListData.get("createTime").substring(4,16).toString()}</td>
            <th>最後異動人員</th>
            <td>
            	<c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
		      		<c:if test="${blackListData.get('updator')==userItem.id}">${userItem.name}</c:if> 
	      		</c:forEach>
            </td>
          </tr>
          <tr>
            <th>最後更新時間</th>
            <td colspan="3">${blackListData.get("updateTime").substring(0,4)-1911}${blackListData.get("updateTime").substring(4,16).toString()}</td>
          </tr>
        </table>
      

      
      <div class="page_number">
      <input type="button" class="btn_02" value="儲存修改" onclick="save()"/>
      <input type="reset" class="btn_02" value="取消" />
      </div>
      <br><br><br>
	</form>

      
      

    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  
  
  
<script src="js/b03/b03_1.js"></script>



</body>




</html>
