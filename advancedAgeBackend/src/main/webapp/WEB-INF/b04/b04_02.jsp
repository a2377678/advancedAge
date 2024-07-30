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
  <%@ include file="../leftMenu.jsp" %>
  <!---------------------- left menu end ---------------------->

  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">案件審查
        <span>實地查核登錄</span>
        <span id="number">B04_02</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName}&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      

      
      <!------------------- table 1 ------------------->
        <div id="page_tab">
          <div class="tab-1"><a href="b04">查詢 / 修改紀錄</a></div>
          <div class="tab-1"><a href="b04_02" class="in">實地查核登錄</a></div>
          <div class="tab-1"><a href="/file/SAMPLE/繼續僱用_查核計畫.docx">訪視表單下載</a></div>
        </div>
      
      
      <!------------------- search ------------------->
      <form action="b04_02" method="post">
      <div id="search_bar">
        <table class="table_01">
          <tr>
            <th width="20%">統一編號 / 扣繳編號：</th>
            <td width="10%"><input type="text" id="seq" name="seq" maxlength="8" value="${base.seq}" size="11"></td>
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
      
      <!------------------- 設立實地查核 ------------------->
      <c:if test="${not empty searchBase.companyName}">
      <input type="text" id="unit" value="${searchBase.unit}" style="display:none">
	  <input type="text" id="creator" value="${id }" style="display:none">
	  <input type="text" id="updator" value="${id }" style="display:none">
      <div class="file_title-2">建立實地查核</div>
        <table class="table_03">
          <tr>
            <th width="22%">事業單位名稱</th>
            <td width="25%" id="companyName">${searchBase.companyName}</td>
            <th width="18%">統一編號 / 扣繳編號</th>
            <td>${searchBase.seq}</td>
          </tr>
          <tr>
            <th>訪視日期</th>
            <td><input type="text" size="24" id="inspectDate" placeholder="yyy-mm-dd"></td>
            <th>訪視人員</th>
            <td><input type="text" size="24" id="inspector"></td>
          </tr>
          <tr>
            <th>訪視紀錄表</th>
            <td colspan="3">
            
            <!---上傳檔案--->
            <div class="file_box" id="siteInspection">
              <div>
                <input type="file" id="siteInspectionFile1" name="siteInspectionFile" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.tiff">
                <button class="add" onclick="addSiteInspectionFile(1)" style>＋</button>
              </div>
            </div>
              
            </td>
          </tr>
          <tr>
            <th>檢附文件<br>
              ( 薪資清冊/出勤紀錄/其他 )</th>
            <td colspan="3">
            
            <!---上傳檔案--->
            <div class="file_box" id="siteInspectionOther">
              <div>
                <input type="file" id="siteInspectionOtherFile1" name="siteInspectionOtherFile" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.tiff">
                <button class="add" onclick="addSiteInspectionOtherFile(1)" style>＋</button>
              </div>
            </div>
              
            
            </td>
          </tr>
          <tr>
            <th>訪視結果</th>
            <td colspan="3">
              <div>
                <label>
                  <input name="result" type="radio" id="result1" class="radio" value="1"/>
                  符合規定
                </label>
              </div>
              <div>
                <label>
                  <input name="result" type="radio" id="result2" class="radio" value="2"/>
                  符合規定，惟建議後續加強訪視，原因：
                  <input type="text" size="42" id="reason2">
                </label>
              </div>
              <div>
              <label>
                <input name="result" type="radio" id="result3" class="radio not" value="3"/>
                未符合規定，原因：
                <input type="text" size="59" id="reason3">
              </label>
              </div>
            </td>
          </tr>
        </table>
      

      
      <div class="page_number">
        <input type="button" class="btn_02" value="取消修改" onclick="reset()"/>
        <input type="button" class="btn_01" value="儲存資料" onclick="add()"/>
      </div>
      <br><br><br>
      </c:if>

    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  
  <script src="js/b04/b04_02.js"></script>

</body>




</html>
