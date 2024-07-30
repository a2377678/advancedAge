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
  <%@ include file="../leftMenuCtype.jsp" %>
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">案件審查
        <span>實地查核登錄</span>
        <span id="number">W02-1</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName}&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      

      
      <!------------------- table 1 ------------------->
        <div id="page_tab">
          <div class="tab-1"><a href="w02" class="in">查詢 / 修改紀錄</a></div>
          <div class="tab-1"><a href="w02_02">實地查核登錄</a></div>
          <div class="tab-1"><a href="/file/SAMPLE/退休再就業_查核計畫.docx">訪視表單下載</a></div>
        </div>
      
      
      <!------------------- search ------------------->
      <form action="w02" method="post">
      <div id="search_bar">
        <table class="table_01">
          <tr>
            <th width="20%">統一編號 / 扣繳編號：</th>
            <td width="20%"><input type="text" size="11" id="seq" name="seq" value=${searchSeq}></td>
            <th width="10%">訪視結果：</th>
            <td><label>
              <input name="result" type="radio" id="result0" class="radio" value="" <c:if test="${empty searchResult}">checked</c:if>/>
              全部</label>
              <label>
                <input name="result" type="radio" id="result1" class="radio" value="1" <c:if test="${not empty searchResult && !searchResult.equals('3')}">checked</c:if>/>
                符合</label>
              <label>
                <input name="result" type="radio" id="result2" class="radio" value="3" <c:if test="${searchResult.equals('3')}">checked</c:if>/>
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
            <th>&nbsp;</th>
            <td>&nbsp;</td>
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
      <input type="text" id="id" value="${siteInspectionData.get('id')}" style="display:none">
      <input type="text" id="editUnit" value="${unit}" style="display:none">
      <input type="text" id="updator" value="${id }" style="display:none">
      <div class="file_title-2">詳細資訊</div>
      <table class="table_03">
        <tr>
          <th width="22%">事業單位名稱</th>
          <td width="25%">${siteInspectionData.get("companyName")}</td>
          <th width="18%">統一編號 / 扣繳編號</th>
          <td>${siteInspectionData.get("seq")}</td>
        </tr>
        <tr>
          <th>訪視日期</th>
          <td><input type="text" id="inspectDate" name="inspectDate" value="${siteInspectionData.get('inspectDate')}" size="24"></td>
          <th>訪視人員</th>
          <td><input type="text" id="inspector" name="inspector" value="${siteInspectionData.get('inspector')}" size="24"></td>
        </tr>
        <tr>
          <th>訪視紀錄表</th>
          <td colspan="3"><!---上傳檔案--->
            <div class="file_box" id="siteInspection">
	           	<c:choose><c:when test="${not empty siteInspectionAttachment}">
		      	<c:forEach items="${siteInspectionAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='siteInspection'}">
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
                <input type="file" id="siteInspectionFile1" name="siteInspectionFile" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.tiff">
                <button type="button" class="add" onclick="delSiteInspectionFile(1)" >－</button>
                <button type="button" class="add" onclick="addSiteInspectionFile(1)" style>＋</button>
              </div>
            </div>
            </td>
        </tr>
        <tr>
          <th>檢附文件<br>
            ( 薪資清冊/出勤紀錄/其他 )</th>
          <td colspan="3"><!---上傳檔案--->
            <div class="file_box" id="siteInspectionOther">
            	<c:choose><c:when test="${not empty siteInspectionOtherAttachment}">
		      	<c:forEach items="${siteInspectionOtherAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='siteInspectionOther'}">
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
                <input type="file" id="siteInspectionOtherFile1" name="siteInspectionOtherFile" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.tiff">
                <button type="button" class="add" onclick="delSiteInspectionOtherFile(1)" >－</button>
                <button type="button" class="add" onclick="addSiteInspectionOtherFile(1)" style>＋</button>
              </div>
            </div>
            </td>
        </tr>
        <tr>
          <th>訪視結果</th>
          <td colspan="3">
            <div>
            <label>
              <input name="dataResult" type="radio" class="radio" id="dataResult1" value="1" <c:if test="${siteInspectionData.get('result').equals('1')}">checked</c:if>/>
              符合規定 </label>
            </div>
            <div>
              <label>
                <input name="dataResult" type="radio" id="dataResult2" class="radio" value="2" <c:if test="${siteInspectionData.get('result').equals('2')}">checked</c:if>/>
                符合規定，惟建議後續加強訪視，原因：
                <input type="text" size="42" id="reason2" name="reason2" <c:if test="${siteInspectionData.get('result').equals('2')}">value="${siteInspectionData.get('reason')}"</c:if>>
              </label>
            </div>
            <div>
              <label>
                <input name="dataResult" type="radio" id="dataResult3" class="radio" value="3" <c:if test="${siteInspectionData.get('result').equals('3')}">checked</c:if>/>
                未符合規定，原因：
                <input type="text" size="59" id="reason3" name="reason3" <c:if test="${siteInspectionData.get('result').equals('3')}">value="${siteInspectionData.get('reason')}"</c:if>>
              </label>
            </div>
          </td>
        </tr>
        <tr>
          <th>承辦單位</th>
          <td>
          	<c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
      			<c:if test="${siteInspectionData.get('unit')==unitItem.code}">${unitItem.name}</c:if> 
	      	</c:forEach>
          </td>
          <th>建檔人員</th>
          <td>
          	<c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
	      		<c:if test="${siteInspectionData.get('creator')==userItem.id}">${userItem.name}</c:if> 
      		</c:forEach>	
          </td>
        </tr>
        <tr>
          <th>建檔日期</th>
          <td colspan="3">${siteInspectionData.get("createTime").substring(0,4)-1911}${siteInspectionData.get("createTime").substring(4,16).toString()}</td>
        </tr>
      </table>
      <div class="page_number">
      <input type="button" class="btn_02" value="儲存修改" onclick="save()"/>
      <input type="button" class="btn_02" value="取消" onclick="location.href='w02'"/>
      </div>
      <br><br><br>
    </form>


    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  
  <script src="js/w02/w02_1.js"></script>
</body>




</html>
