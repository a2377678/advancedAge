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
        <li class="breadcrumb-item active" aria-current="page">線上申辦</li>
        <li class="breadcrumb-item active" aria-current="page">中高齡者退休後再就業準備協助措施 - 請領作業</li>
      </ol>
    </nav>
    <h1>中高齡者退休後再就業準備協助措施 - 請領作業</h1>
    <h2>請領流程 Step5. 送出申請</h2>
    <h3><span class="title">您申請的案件已送出</span></h3>
    
    <div>
    	<c:set var="createTime" value="${base.allowanceFileStatusRecord.split(';')[baseAllowanceFrequencyTime-1].split('、')[5]}"></c:set>
      	<div class="fs-5 fw-bolder">請領日期：${createTime.substring(0,4)-1911}/${createTime.substring(5,7)}/${createTime.substring(8,createTime.length())}</div>
      <h4>《 申辦完成不代表審核通過 》</h4>
      <p>
      如有補件或修改送件資料需求，或您有任何疑問<br>
      請於周一至周五 上班時間洽詢 <a href="https://job.taiwanjobs.gov.tw/internet/index/service_location.aspx" target="_blank">受理單位</a>
      </p>
    </div>
    <div style="display:none">
    <!--startprint-->
      <div class="form">
        <div class="title_main"><span>成果報告 - 基本資料</span></div>
        <input type="text" id="baseId" name="baseId" value="${baseId}" style="display:none">
        <div><span class="title-c">聯絡人</span>${result.contactName}</div>
        <div><span class="title-c">聯絡人職稱</span>${result.contactJobtitle}</div>
        <div><span class="title-c">聯絡電話</span>${result.contactWorkPhoneAreaCode} - ${result.contactWorkPhone} #${result.contactWorkPhoneExtension}</div>
        <div><span class="title-c">行動電話</span>${result.contactPhone}</div>
        <div><span class="title-c">傳真號碼</span>${result.faxAreaCode} - ${result.fax}</div>
        <div><span class="title-c">電子信箱</span>${result.email}</div>
        <div><span class="title-c">核定補助金額</span>${result.approveAmounts}</div>
        <div><span class="title-c">實支金額</span>${result.realAmounts}</div>
      </div>
      
      <div class="form">
        <div class="title_main"><span>計畫實施情形</span></div>
        <div class="full lh-lg">
          <span class="title-c">辦理情形：</span><br>
          ${result.planExecutionSituation.replace("\\n","<br>")}
        </div>
        <div class="full lh-lg">
          <span class="title-c">實施成果：</span><br>
          ${result.result.replace("\\n","<br>")}
        </div>
        <div class="full lh-lg">
          <span class="title-c">檢討與建議：</span><br>
          ${result.suggestion.replace("\\n","<br>")}
        </div>
      </div>


      <div class="form">
        <div class="title_main"><span>檢附文件</span></div>
		<div class="full lh-lg"><span class="title-c">本計畫核准函影本：</span><br>
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
		<div class="full lh-lg"><span class="title-c">請款之領據正本：</span><br>
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
		<div class="full lh-lg"><span class="title-c">成果報告之內容附件：</span><br>
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
		<div class="full lh-lg"><span class="title-c">經費支用單據正本及明細表：</span><br>
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
        <div class="full lh-lg"><span class="title-c">其他文件：</span><br>
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
      <button onclick="doPrint()">下載申請書電子檔</button>
      <button onclick="javascript:location.href='index'">回首頁</button>
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
<script src="js/career_payment_05/career_payment_05.js"></script>
</body>
</html>