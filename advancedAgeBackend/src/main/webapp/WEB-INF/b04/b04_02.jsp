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
<!--                   <li><a href="b03/b03.html">停止補助名單管理</a></li> -->
<!--                   <li><a href="b04/b04.html" class="in">實地查核登錄</a></li> -->
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
        <span>實地查核登錄</span>
        <span id="number">B04_02</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName}&nbsp;${name }</a>
        <a href="logout?account=${account }">登出</a>
      </div>
      

      
      <!------------------- table 1 ------------------->
        <div id="page_tab">
          <div class="tab-1"><a href="b04?account=${account }">查詢 / 修改紀錄</a></div>
          <div class="tab-1"><a href="b04_02?account=${account }" class="in">實地查核登錄</a></div>
          <div class="tab-1"><a href="/file/SAMPLE/訪查表1108-核定.docx">訪視表單下載</a></div>
        </div>
      
      
      <!------------------- search ------------------->
      <form action="b04_02" method="post">
      <input type="hidden" name="account" value="${account }">
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
      
      <!------------------- 設立實地查核 ------------------->
      <c:if test="${not empty searchBase.companyName}">
      <input type="hidden" name="account" value="${account }">
      <input type="hidden" id="unit" value="${searchBase.unit}">
	  <input type="hidden" id="creator" value="${id }">
	  <input type="hidden" id="updator" value="${id }">
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
                <input type="file" id="siteInspectionFile1" name="siteInspectionFile">
                <button class="add" onclick="addSiteInspectionFile(1)" style>＋</button>
              </div>
            </div>
              
<!--             <div class="btn_box-td center"> -->
<!--              <button type="button" class="search_btn" value="開始查詢">上傳檔案</button> -->
<!--             </div> -->
            
            </td>
          </tr>
          <tr>
            <th>檢附文件<br>
              ( 薪資清冊/出勤紀錄/其他 )</th>
            <td colspan="3">
            
            <!---上傳檔案--->
            <div class="file_box" id="siteInspectionOther">
              <div>
                <input type="file" id="siteInspectionOtherFile1" name="siteInspectionOtherFile">
                <button class="add" onclick="addSiteInspectionOtherFile(1)" style>＋</button>
              </div>
            </div>
              
<!--             <div class="btn_box-td center"> -->
<!--              <button type="button" class="search_btn" value="開始查詢">上傳檔案</button> -->
<!--             </div> -->
            
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
<!--           <tr> -->
<!--             <th>承辦單位</th> -->
<!--             <td>勞動力發展署</td> -->
<!--             <th>建檔人員</th> -->
<!--             <td>張OO</td> -->
<!--           </tr> -->
<!--           <tr> -->
<!--             <th>建檔日期</th> -->
<!--             <td colspan="3">111-10-18　15:06</td> -->
<!--           </tr> -->
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
