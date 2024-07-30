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
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/o01/o01_1.js"></script>
  
<style type="text/css">
.ui-datepicker {
	width: 20em; /*what ever width you want*/
}
</style>
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
        <span>停止補助名單管理</span>
        <span id="number">O01-1</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      

      
      <!------------------- table 1 ------------------->
        <div id="page_tab">
          <div class="tab-1"><a href="o01" class="in">查詢 / 修改紀錄</a></div>
          <div class="tab-1"><a href="o01_02">停止補助名單登錄</a></div>
        </div>
      
      
      <!------------------- search ------------------->
      <form action="o01" method="post">
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
                <c:if test="${unit=='F' }">
					<option value>不限</option>                
	                <c:forEach  items="${unitList}"  var="item"  varStatus="userStatus">
	                	<c:if test="${item.code!='F' }">
			      			<option value="${item.code}" <c:if test="${searchUnit==item.code}">selected</c:if> >${item.name}</option>
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
      <input type="text" id="id" value="${blackListData.get('id')}" style="display:none">
      <input type="text" id="updator" value="${id }" style="display:none">
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
                <input type="file" id="blackListFile1" name="blackListFile" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.tiff">
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
  

</body>




</html>
