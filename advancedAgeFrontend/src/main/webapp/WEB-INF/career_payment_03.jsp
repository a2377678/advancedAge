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
        <li class="breadcrumb-item active" aria-current="page">中高齡者退休後再就業準備協助措施 - 請領作業</li>
      </ol>
    </nav>
    <h1>中高齡者退休後再就業準備協助措施 - 請領作業</h1>
    <h2>請領流程 Step3. 上傳證明文件</h2>
    
    <!---上傳證明文件--->
    <h3>
    上傳之檔案格式請符合以下規定，其他格式則不受理：<br>
    jpg、png、pdf 等單一檔，檔案大小以 5mb 為限，<br>
    rar、zip、7z 等壓縮檔，檔案大小以 50mb 為限。<br>
    </h3>
    
 
 
 
    <!-------------本計畫核准函影本------------>
    <div class="form">
      <input type="text" id="baseId" value="${baseId}" style="display:none">
      <div class="title_main">
        <span>本計畫核准函影本</span>
      </div>
      
      <div class="file_box" id="approved">
      	<c:choose><c:when test="${not empty approvedAttachment}">
      	<c:set var="approvedProofNumber" value="1"/>
      	<c:forEach items="${approvedAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='approved' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
		      		<div class="full">
				        <label for="">文件(${approvedProofNumber})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="approvedProofNumber" value="${approvedProofNumber+1}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="approvedProof<c:out value="${approvedProofNumber}"/>">文件(<c:out value="${approvedProofNumber}"/>)</label>
	        <input type="file" id="approvedProof<c:out value="${approvedProofNumber}"/>" name="approvedProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addApprovedProof(<c:out value="${approvedProofNumber}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="approvedProof1">文件(1)</label>
	        <input type="file" id="approvedProof1" name="approvedProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addApprovedProof(1)" style>＋</button>
        </div>
        </c:otherwise></c:choose>
      </div>
      
    </div>
    
    <div class="btn_box">
      <button class="save" onclick="upload()">上傳檔案</button>
    </div>
    
    
    <!-------------請款之領據正本------------>
    <div class="form">
    
      <div class="title_main">
        <span>請款之領據正本</span>
        <em>請張貼匯款帳戶封面影本及加蓋大小章。
        	【<a href="/file/SAMPLE/03/退休再就業_請領_領據.docx" title="退休再就業_領據.docx ( 另存新檔 )">下載空白領據.docx</a>】
        	【<a href="/file/SAMPLE/03/退休再就業_請領_領據.odt" title="退休再就業_領據.odt ( 另存新檔 )">下載空白領據.odt</a>】
        </em>
      </div>
      
      <div class="file_box" id="receipt">
      	<c:choose><c:when test="${not empty receiptAttachment}">
      	<c:set var="receiptProofNumber" value="1"/>
      	<c:forEach items="${receiptAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='receipt' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
		      		<div class="full">
				        <label for="">文件(${receiptProofNumber})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="receiptProofNumber" value="${receiptProofNumber+1}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="receiptProof<c:out value="${receiptProofNumber}"/>">文件(<c:out value="${receiptProofNumber}"/>)</label>
	        <input type="file" id="receiptProof<c:out value="${receiptProofNumber}"/>" name="receiptProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addReceiptProof(<c:out value="${receiptProofNumber}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="receiptProof1">文件(1)</label>
	        <input type="file" id="receiptProof1" name="receiptProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addReceiptProof(1)" style>＋</button>
        </div>
        </c:otherwise></c:choose>
      </div>
      
    </div>
    
    <div class="btn_box">
      <button class="save" onclick="upload()">上傳檔案</button>
    </div>
    


    <!-------------成果報告之內容附件------------>
    <div class="form">
    
      <div class="title_main">
        <span>成果報告之內容附件</span>
        <em>含簽到表、課程、活動照片等</em>
      </div>
      
      <div class="file_box" id="result">
      	<c:choose><c:when test="${not empty resultAttachment}">
      	<c:set var="resultProofNumber" value="1"/>
      	<c:forEach items="${resultAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='result' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
		      		<div class="full">
				        <label for="">文件(${resultProofNumber})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="resultProofNumber" value="${resultProofNumber+1}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="resultProof<c:out value="${resultProofNumber}"/>">文件(<c:out value="${resultProofNumber}"/>)</label>
	        <input type="file" id="resultProof<c:out value="${resultProofNumber}"/>" name="resultProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addResultProof(<c:out value="${resultProofNumber}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="resultProof1">文件(1)</label>
	        <input type="file" id="resultProof1" name="resultProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addResultProof(1)" style>＋</button>
        </div>
        </c:otherwise></c:choose>
      </div>
      
    </div>
    
    <div class="btn_box">
      <button class="save" onclick="upload()">上傳檔案</button>
    </div> 


    <!-------------經費支出原始憑證及明細表------------>
    <div class="form">
    
      <div class="title_main">
        <span>經費支用單據正本及明細表</span>
        <em>請檢附正本，若為影本請加註與正本相符字樣及原因。
        	【<a href="/file/SAMPLE/03/退休再就業_請領_經費支用單據明細表.docx" title="退休再就業_請領_經費支用單據明細表.docx ( 另存新檔 )">下載空白經費表.docx</a>】
        	【<a href="/file/SAMPLE/03/退休再就業_請領_經費支用單據明細表.odt" title="退休再就業_請領_經費支用單據明細表.odt ( 另存新檔 )">下載空白經費表.odt</a>】
        </em>
      </div>
          
      <div class="file_box" id="expenditureDetails">  
      	<c:choose><c:when test="${not empty expenditureDetailsAttachment}">
      	<c:set var="expenditureDetailsProofNumber" value="1"/>
      	<c:forEach items="${expenditureDetailsAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='expenditureDetails' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
		      		<div class="full">
				        <label for="">文件(${expenditureDetailsProofNumber})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="expenditureDetailsProofNumber" value="${expenditureDetailsProofNumber+1}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="expenditureDetailsProof<c:out value="${expenditureDetailsProofNumber}"/>">文件(<c:out value="${expenditureDetailsProofNumber}"/>)</label>
	        <input type="file" id="expenditureDetailsProof<c:out value="${expenditureDetailsProofNumber}"/>" name="expenditureDetailsProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addExpenditureDetailsProof(<c:out value="${expenditureDetailsProofNumber}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
          <label for="expenditureDetailsProof1">文件(1)</label>
          <input type="file" id="expenditureDetailsProof1" name="expenditureDetailsProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
          <button class="add" onclick="addExpenditureDetailsProof(1)" style>＋</button>
        </div>
        </c:otherwise></c:choose>
        
      </div>
          
    </div>
        
    <div class="btn_box">
      <button class="save" onclick="upload()">上傳檔案</button>
    </div>    
    
    
    <!-------------其他經本署或各分署認定有必要提出之文件------------>
    <div class="form">
    
      <div class="title_main">
      <span>其他文件</span>
      </div>
          
      <div class="file_box" id="necessary">  
      	<c:choose><c:when test="${not empty necessaryAttachment}">
      	<c:set var="necessaryProofNumber" value="1"/>
      	<c:forEach items="${necessaryAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='necessary' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
		      		<div class="full">
				        <label for="">文件(${necessaryProofNumber})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="necessaryProofNumber" value="${necessaryProofNumber+1}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="necessaryProof<c:out value="${necessaryProofNumber}"/>">文件(<c:out value="${necessaryProofNumber}"/>)</label>
	        <input type="file" id="necessaryProof<c:out value="${necessaryProofNumber}"/>" name="necessaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addNecessaryProof(<c:out value="${necessaryProofNumber}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
          <label for="necessaryProof1">文件(1)</label>
          <input type="file" id="necessaryProof1" name="necessaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
          <button class="add" onclick="addNecessaryProof(1)" style>＋</button>
        </div>
        </c:otherwise></c:choose>
        
      </div>
          
    </div>
        
    <div class="btn_box">
      <button class="save" onclick="upload()">上傳檔案</button>
    </div>




    
    <div class="page">
      <button onclick="javascript:location.href='career_payment_02'">回上頁</button>
      
      <!--- Button trigger modal --->
      <button type="button" class="" data-bs-toggle="modal" data-bs-target="#sure">下一步</button>
      <!---------- Modal ---------->
      <div class="modal fade" id="sure" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" 
      aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title fw-bold" id="staticBackdropLabel">請注意 !!</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body h5 fw-bold">
              請確認是否已按下『上傳檔案』並成功上傳
            </div>
            <div class="pt-3 pb-5">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">返回檢查</button>
              <button type="button" class="btn btn-primary" onclick="fileUploadCheck()">確認完成，下一步</button>
            </div>
          </div>
        </div>
      </div>
      <!---------- Modal end ---------->
      
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
<script src="js/career_payment_03/career_payment_03.js"></script>
</body>
</html>