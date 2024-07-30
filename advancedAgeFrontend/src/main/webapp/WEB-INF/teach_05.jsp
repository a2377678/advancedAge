<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-hant-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>中高齡及高齡者就業相關服務網</title>
<link rel="stylesheet" href="css/main.css" type="text/css">
<link rel="stylesheet" href="css/template.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/cmxform.css" type="text/css">
<link rel="stylesheet" href="css/jquery-confirm.min.css" type="text/css">

<script src="js/bootstrap.bundle.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/gotop.js"></script>
<script src="js/teach_05/teach_05.js"></script>
<script src="js/jquery-confirm.min.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>

</head>

<body>
<div class=""> 
  
  <!--- header --->
  <%@ include file="header.jsp" %>
  <!--- header end ---> 
  
  
  <!--- main --->
  <div class="main clearfix" id="content"> 
    <a href="#C" title="中央內容區塊" id="AC" accesskey="C" name="C">:::</a> <!---無障礙---> 
    
  <!------------ 申請流程 ------------>
  <div class="apply_main">
  <%@ include file="countDownComponent.jsp" %>
    <!---無障礙/麵包屑--->
    <nav aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index" title="首頁">首頁</a></li>
        <li class="breadcrumb-item active" aria-current="page">線上申辦</li>
        <li class="breadcrumb-item active" aria-current="page">僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 申請作業</li>
      </ol>
    </nav>
    <h1>僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 申請作業</h1>
    <h2>申請流程 Step5. 填寫經費概算</h2>
    
    <!---申辦前準備--->
    <h3>同一事由已領取政府機關相同性質之補助，不得再申請本計畫。</h3>
    
    
    <!-------------經費概算------------>
    <div class="form">
    
      <div class="title_main pt-4">
      <span>申請補助經費概算</span>
      <em>請視需要自行增刪欄位，若申請項目超過10項請下載
      【<a href="/file/SAMPLE/傳承經驗_經費概算表.xlsx" title="經費概算專用Excel表 ( 另存新檔 )">經費概算專用表格.xlsx</a>】
      填寫後上傳</em>
      </div>
      
      
      <div id="page_tab">
        <div class="tab-1" id="employed"><a class="in color-2">線上填寫資料</a></div>
        <div class="tab-1" id="list"><a>上傳專用表格</a></div>
      </div>
      
      
      <div class="staff" id="employedTable">
      	<form id="listForm">
        <ol class="staff">
        <c:choose><c:when test="${expenditureLists !='[]'}">
	        <c:forEach items="${expenditureLists}" var="item" varStatus="status">
	        	<li>
		          <div class="s">
		          <label for="planName${status.count}">項目</label>
		          <input type="text" id="planName${status.count}" name="planName${status.count}" value="${item.planName }">
		          </div>
		          
		          <div class="s">
		          <label for="unitPrice${status.count}">單價</label>
		          <input type="number" step="1" min="0" id="unitPrice${status.count}" name="unitPrice${status.count}" value="${item.unitPrice }"> 元
		          </div>
		        
		          <div class="s">
		          <label for="amount${status.count}">數量</label>
		          <input type="number" step="1" min="0" id="amount${status.count}" name="amount${status.count}" value="${item.amount }">
		          </div>
		        
		          <div class="s">
		          <label for="totalAmount${status.count}">總價</label>
		          <input type="text" id="totalAmount${status.count}" name="totalAmount${status.count}" class="readonly" placeholder="填寫完自動計算" readonly value="${item.unitPrice*item.amount }"> 元
		          </div>
		        
		          <div class="s">
		          <label for="applicationAmounts${status.count}">申請本部補助</label>
		          <input type="number" id="applicationAmounts${status.count}" name="applicationAmounts${status.count}" step="1" min="0" value="${item.amounts }"> 元
		          </div>
		        
		          <div class="s">
		          <label for="description${status.count}">說明</label>
		          <input type="text" id="description${status.count}" name="description${status.count}"  value="${item.description }">
		          </div>
		          
		          <div class="close"><button type="button" class="close" title="移除此筆資料" onclick="listDelete(this)">X</button></div>
		          
		        </li>
	        </c:forEach>
	        </c:when><c:otherwise>
	        <!---01--->
	        <li>
	          <div class="s">
	          <label for="planName1">項目</label>
	          <input type="text" id="planName1" name="planName1" required>
	          </div>
	          
	          <div class="s">
	          <label for="unitPrice1">單價</label>
	          <input type="number" step="1" min="0" id="unitPrice1" name="unitPrice1"required> 元
	          </div>
	        
	          <div class="s">
	          <label for="amount1">數量</label>
	          <input type="number" step="1" min="0" id="amount1" name="amount1"required>
	          </div>
	        
	          <div class="s">
	          <label for="totalAmount1">總價</label>
	          <input type="text" id="totalAmount1" name="totalAmount1" class="readonly" placeholder="填寫完自動計算" readonly> 元
	          </div>
	        
	          <div class="s">
	          <label for="applicationAmounts1">申請本部補助</label>
	          <input type="number" id="applicationAmounts1" name="applicationAmounts1" step="1" min="0" required> 元
	          </div>
	        
	          <div class="s">
	          <label for="description1">說明</label>
	          <input type="text" id="description1" name="description1" placeholder="">
	          </div>
	          
	          <div class="close"><button type="button" class="close" title="移除此筆資料" onclick="listDelete(this)">X</button></div>
	          
	        </li>
        </c:otherwise></c:choose>
        </ol>
      	</form>
        <div class="btn_box">
          <button class="subjoin" onclick="listAdd()">＋增加欄位</button>
          <button class="save" onclick="listSave()">暫存資料</button>
        </div>
      
      </div>
      
      
      <div class="staff_excel" id="listTable" style="display:none">
        
        <div class="title text-center mt-3 mb-4 w-100">請上傳「最新完整資料」，每次上傳皆會覆蓋先前資料，請確認後再送出！</div>
        <div class="file_box text-center"> 
            <input type="file" id="uploadFile" name="uploadFile" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <button class="upload" onclick="fileUpload()">上傳檔案</button>
        </div>
		<c:choose><c:when test="${not empty speakerListAttachment}">
	      	<c:forEach items="${speakerListAttachment}" var="item" varStatus="status">
		      	<c:choose>
			      	<c:when test="${item.fileType=='speakerList' }">
			      	<br>
			      		<div class="file_box text-center" id="alreadyExist">
					        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
					        <span class="file_progress">上傳完成</span>
					        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
					        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
				        </div>
			      	</c:when>
		      	</c:choose>
	      	</c:forEach>
        </c:when></c:choose>

      </div>
    
    </div>

	<!------------ loading 效果 ------------>
    <div id="loader-container" style="display:none;">
    <p id="loadingText">Loading</p>
    </div>
    
    <div class="page">
      <button onclick="javascript:location.href='teach_04'">回上頁</button>
      <button onclick="listSave()">暫存資料</button>
      <button onclick="next()">下一步</button>
    </div>
    
  </div>
  <!------------ 申請流程 END ------------>
    
  </div>
  <!--- main end ---> 
  
  <!--- footer --->
  <%@ include file="footer.jsp" %>
  <!--- footer end ---> 
  
</div>

</body>
</html>