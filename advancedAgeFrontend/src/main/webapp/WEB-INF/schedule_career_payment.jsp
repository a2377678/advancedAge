<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="zh-hant-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>中高齡及高齡者就業相關服務網</title>
<link rel="stylesheet" href="css/main.css" type="text/css">
<link rel="stylesheet" href="css/template.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">

</head>
<style type="text/css">
	@page {
     size: A4 landscape; /*直式portrait 橫式landscape*/
     margin: 1cm;  /*print邊界*/
	}
</style>
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
  
      <!---無障礙/麵包屑--->
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index" title="首頁">首頁</a></li>
          <li class="breadcrumb-item active" aria-current="page">案件查詢</li>
          <li class="breadcrumb-item active" aria-current="page">中高齡者退休後再就業準備協助措施 - 請領進度</li>
        </ol>
      </nav>
      <h1>中高齡者退休後再就業準備協助措施 - 請領進度</h1>
      <h2>申請流程：請領查詢</h2>
      
      <!---說明文字--->
      <h3>案件已送出無法修改，僅供查詢您填寫的申請資料，<br>
      若有補件需求，請等待補件通知，或洽詢<a href="https://job.taiwanjobs.gov.tw/internet/index/service_location.aspx" target="_blank">受理單位</a>
      </h3>
        
      <div>
      	<c:if test="${not empty base.allowanceFileStatusRecord}">
	        <c:set var="createTime" value="${base.allowanceFileStatusRecord.split(';')[baseAllowanceFrequencyTime-1].split('、')[5]}"></c:set>
	      	<div class="fs-5 fw-bolder">請領日期：${createTime.substring(0,4)-1911}/${createTime.substring(5,7)}/${createTime.substring(8,createTime.length())}</div>
	        <div class="fs-5 fw-bolder py-2 mb-3">請領查詢：
	        	<c:if test="${base.caseStatus==5 }"><div class="text-danger">本次請領審核中</div></c:if>
	          	<c:if test="${base.caseStatus==6 }"><div class="text-danger">本次請領不合格</div></c:if>
	          	<c:if test="${base.caseStatus==7}"><div class="text-info">本次請領已核定</div></c:if>
	        </div>
	    </c:if>
	    <c:if test="${empty base.allowanceFileStatusRecord}">
        	<div class="fs-5 fw-bolder py-2 mb-3">請領查詢：<span class="text-danger">查無資料</span></div>
        </c:if>
      </div>
      
      <div style="display:none">
      <!--startprint-->
      <div class="form">
        <div class="title_main"><span>成果報告 - 基本資料</span></div>
        <div>聯絡人：${result.contactName}</div>
        <div>聯絡人職稱：${result.contactJobtitle}</div>
        <div>聯絡電話：${result.contactWorkPhoneAreaCode} - ${result.contactPhone} #${result.contactWorkPhoneExtension}</div>
        <div>行動電話：${result.contactPhone}</div>
        <div>傳真號碼：${result.faxAreaCode} - ${result.fax}</div>
        <div>電子信箱：${result.email}</div>
        <div>核定補助金額：${result.approveAmounts}</div>
        <div>實支金額：${result.realAmounts}</div>
      </div>
      
      <div class="form">
        <div class="title_main"><span>計畫實施情形</span></div>
        <div class="full"><b>辦理情形：</b><br>
          ${result.planExecutionSituation.replace("\\n","<br>")}
        </div>
        <div class="full"><b>實施成果：</b><br>
          ${result.result.replace("\\n","<br>")}
        </div>
        <div class="full"><b>檢討與建議：</b><br>
          ${result.suggestion.replace("\\n","<br>")}
        </div>
      </div>


      <div class="form">
        <div class="title_main"><span>檢附文件</span></div>

        <div class="full">本計畫核准函影本：<br>
        	<c:choose><c:when test="${not empty approvedAttachment}">
		      	<c:forEach items="${approvedAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='approved'}">
					        <a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a>&nbsp;&nbsp;
					        ${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}&nbsp;&nbsp;
					        <fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB
					        <br/>
				      	</c:when>
			      	</c:choose>
		      	</c:forEach>
	        </c:when>
	        </c:choose>
        </div>
		<div class="full">請款之領據正本：<br>
        	<c:choose><c:when test="${not empty receiptAttachment}">
		      	<c:forEach items="${receiptAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='receipt'}">
					        <a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a>&nbsp;&nbsp;
					        ${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}&nbsp;&nbsp;
					        <fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB
					        <br/>
				      	</c:when>
			      	</c:choose>
		      	</c:forEach>
	        </c:when>
	        </c:choose>
	    </div>
		<div class="full">成果報告之內容附件：<br>
        	<c:choose><c:when test="${not empty resultAttachment}">
		      	<c:forEach items="${resultAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='result'}">
					        <a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a>&nbsp;&nbsp;
					        ${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}&nbsp;&nbsp;
					        <fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB
					        <br/>
				      	</c:when>
			      	</c:choose>
		      	</c:forEach>
	        </c:when>
	        </c:choose>
	    </div>
		<div class="full">經費支用單據正本及明細表：<br>
        	<c:choose><c:when test="${not empty expenditureDetailsAttachment}">
		      	<c:forEach items="${expenditureDetailsAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='expenditureDetails'}">
					        <a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a>&nbsp;&nbsp;
					        ${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}&nbsp;&nbsp;
					        <fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB
					        <br/>
				      	</c:when>
			      	</c:choose>
		      	</c:forEach>
	        </c:when>
	        </c:choose>
	    </div>
        <div class="full">其他文件：<br>
        	<c:choose><c:when test="${not empty necessaryAttachment}">
		      	<c:forEach items="${necessaryAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='necessary'}">
					        <a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a>&nbsp;&nbsp;
					        ${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}&nbsp;&nbsp;
					        <fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB
					        <br/>
				      	</c:when>
			      	</c:choose>
		      	</c:forEach>
	        </c:when>
	        </c:choose>
	    </div>

      </div>
	  <!--endprint-->
	  </div>
      <div class="page">
        <button type="button" onclick="doPrint()">申請資料PDF</button>
      </div>
    </div>
    <!------------ 申請流程 END ------------> 
    
  </div>
  <!--- main end ---> 
  
  <!--- footer --->
  <%@ include file="footer.jsp" %>
  <!--- footer end ---> 
  
</div>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/gotop.js"></script>
<script src="js/schedule_career_payment/schedule_career_payment.js"></script>
</body>
</html>