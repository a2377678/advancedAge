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
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

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
        <span>停止補助名單管理</span>
        <span id="number">W01_02</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      

      
      <!------------------- table 1 ------------------->
        <div id="page_tab">
          <div class="tab-1"><a href="w01">查詢 / 修改紀錄</a></div>
          <div class="tab-1"><a href="w01_02" class="in">停止補助名單登錄</a></div>
        </div>
      
      
      <!------------------- search ------------------->
      <form action="w01_02" method="post">
      <div id="search_bar">
        <table class="table_01">
          <tr>
            <th width="20%">統一編號 / 扣繳編號：</th>
            <td width="10%"><input type="text" id="seq" name="seq" value="${base.seq}" size="11"></td>
            <td width="12%">
              <div class="btn_box-td">
                <button type="submit" class="search_btn" value="開始查詢">開始查詢</button>
              </div>
            </td>
            <td>&nbsp;</td>
          </tr>
        </table>
      </div>
      </form>
	  <!------------------- 設立停止補助名單 ------------------->
	  <c:if test="${not empty searchBase.companyName}">
	  <input type="text" id="unit" value="${searchBase.unit}" style="display:none">
	  <input type="text" id="creator" value="${id }" style="display:none">
	  <input type="text" id="updator" value="${id }" style="display:none">
	  <div>
      <div class="file_title-2">建立停止補助名單</div>
        <table class="table_03">
          <tr>
            <th width="22%">事業單位名稱</th>
            <td width="25%" id="companyName">${searchBase.companyName}</td>
            <th width="18%">統一編號 / 扣繳編號</th>
            <td>${searchBase.seq}</td>
          </tr>
          <tr>
            <th>公文文號</th>
            <td colspan="3"><input type="text" size="24" id="officialDocumentNumber"></td>
          </tr>
          <tr>
            <th>上傳公文</th>
            <td colspan="3">
            
            <!---上傳檔案--->
            <div class="file_box" id="listFile">  
              <div>
                <input type="file" id="blackListFile1" name="blackListFile" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.tiff">
                <button class="add" onclick="addBlackListFile(1)" style>＋</button>
              </div>
            </div>
            
            </td>
          </tr>
          <tr>
            <th>摘要說明</th>
            <td colspan="3"><textarea id="description" rows="5" style="width:700px"></textarea></td>
          </tr>
          <tr>
            <th>禁止起始日</th>
            <td><input type="text" size="20" id="banStartDate" placeholder="yyy-mm-dd"></td>
            <th>禁止結束日</th>
            <td><input type="text" size="20" id="banEndDate" placeholder="yyy-mm-dd"></td>
          </tr>
        </table>
      

      
      <div class="page_number">
        <input type="button" class="btn_02" value="取消修改" onclick="reset()"/>
        <input type="button" class="btn_01" value="儲存資料" onclick="add()"/>
      </div>
      </div>
	</c:if>

    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  
<script src="js/w01/w01_02.js"></script>


</body>


</html>
