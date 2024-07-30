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

          <!-- Modal-1-1 -->
          <div class="modal modal-dialog-scrollable fade" id="exampleModal-1-1"
           tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg">
              <div class="modal-content">
                <img src="/file/SAMPLE/公司設立登記證明文件-1.jpg" alt="公司設立登記證明文件">
              </div>
            </div>
          </div>
          <!-- Modal-1-1 -->
          
          <!-- Modal-1-2 -->
          <div class="modal modal-dialog-scrollable fade" id="exampleModal-1-2"
           tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
              <div class="modal-content">
                <img src="/file/SAMPLE/法人登記書-1.jpg" alt="法人登記書範本">
              </div>
            </div>
          </div>
          <!-- Modal-1-2 -->
          
          <!-- Modal-2 -->
          <div class="modal modal-dialog-scrollable fade" id="exampleModal-2"
           tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
              <div class="modal-content">
                <img src="/file/SAMPLE/投保證明範本.png" alt="投保證明範本">
              </div>
            </div>
          </div>
          <!-- Modal-2 -->
          
          <!-- Modal-3 -->
          <div class="modal modal-dialog-scrollable fade" id="exampleModal-3"
           tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
              <div class="modal-content">
                <img src="/file/SAMPLE/薪資證明範例.png" alt="薪資證明範本">
              </div>
            </div>
          </div>
          <!-- Modal-3 -->
          
          <!-- Modal-4 -->
          <div class="modal fade" id="exampleModal-4"
           tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-sm">
              <div class="modal-content">
                <img src="/file/SAMPLE/出勤證明文件-1.jpg" alt="出勤證明文件範本">
              </div>
            </div>
          </div>
          <!-- Modal-4 -->

  
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
        <li class="breadcrumb-item active" aria-current="page">中高齡者退休後再就業準備協助措施 - 申請作業</li>
      </ol>
    </nav>
    <h1>中高齡者退休後再就業準備協助措施 - 申請作業</h1>
    <h2>申請流程 Step6. 上傳證明文件</h2>
    
    <!---上傳證明文件--->
    <h3>
    上傳之檔案格式請符合以下規定，其他格式則不受理：<br>
    jpg、png、pdf 等單一檔，檔案大小以 5mb 為限，<br>
    rar、zip、7z 等壓縮檔，檔案大小以 50mb 為限。<br>
    </h3>
    
 
 
 
    <!-------------設立登記證明文件------------>
    <div class="form">
    
      <div class="title_main">
        <span>設立登記證明文件</span>
        <em>須加蓋公司單位及負責人用印 (公司大小章)
          <!-- Button trigger modal-1 -->
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModal-1-1">範例 1</button>
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModal-1-2">範例 2</button>
        </em>
      </div>
      
       <div class="file_box" id="register">
      	<c:choose><c:when test="${not empty registerAttachment}">
      	<c:forEach items="${registerAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='register' }">
		      		<div class="full">
				        <label for="">文件(${status.count})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="registerProofNumber" value="${status.count}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="registerProof<c:out value="${registerProofNumber+1}"/>">文件(<c:out value="${registerProofNumber+1}"/>)</label>
	        <input type="file" id="registerProof<c:out value="${registerProofNumber+1}"/>" name="registerProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
<%-- 	        <button class="add" onclick="delRegisterProof(<c:out value="${registerProofNumber+1}"/>)">－</button> --%>
	        <button class="add" onclick="addRegisterProof(<c:out value="${registerProofNumber+1}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="registerProof1">文件(1)</label>
	        <input type="file" id="registerProof1" name="registerProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
<!-- 	        <button class="add" onclick="delRegisterProof(1)">－</button> -->
	        <button class="add" onclick="addRegisterProof(1)" style>＋</button>
        </div>
        </c:otherwise></c:choose>
      </div>
      
    </div>
    
    <div class="btn_box">
      <button class="save" onclick="upload()">上傳檔案</button>
    </div> 
    
    
    <!-------------聯合辦理單位授權書------------>
    <div class="form">
    
      <div class="title_main">
        <span>聯合辦理單位授權書</span>
        <em>個別辦理者免附。   
	        【<a href="/file/SAMPLE/03/退休再就業_申請_聯合辦理單位授權書.docx" title="退休再就業_聯合辦理單位授權書.docx ( 另存新檔 )">下載空白單位授權書.docx</a>】
	        【<a href="/file/SAMPLE/03/退休再就業_申請_聯合辦理單位授權書.odt" title="退休再就業_聯合辦理單位授權書.odt ( 另存新檔 )">下載空白單位授權書.odt</a>】
        </em>
      </div>
      
      <div class="file_box" id="jointAuthorize">  
      	<c:choose><c:when test="${not empty jointAuthorizeAttachment}">
      	<c:forEach items="${jointAuthorizeAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='jointAuthorize' }">
		      		<div class="full">
				        <label for="">文件(${status.count})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="jointAuthorizeNumber" value="${status.count}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="jointAuthorizeProof<c:out value="${jointAuthorizeNumber+1}"/>">文件(<c:out value="${jointAuthorizeNumber+1}"/>)</label>
	        <input type="file" id="jointAuthorizeProof<c:out value="${jointAuthorizeNumber+1}"/>" name="jointAuthorizeProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
<%-- 	        <button class="add" onclick="delJointAuthorizeProof(<c:out value="${jointAuthorizeNumber+1}"/>)">－</button> --%>
	        <button class="add" onclick="addJointAuthorizeProof(<c:out value="${jointAuthorizeNumber+1}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="jointAuthorizeProof1">文件(1)</label>
	        <input type="file" id="jointAuthorizeProof1" name="jointAuthorizeProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addJointAuthorizeProof(1)" style>＋</button>
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
      	<c:forEach items="${necessaryAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='necessary' }">
		      		<div class="full">
				        <label for="">文件(${status.count})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="necessaryProofNumber" value="${status.count}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="necessaryProof<c:out value="${necessaryProofNumber+1}"/>">文件(<c:out value="${necessaryProofNumber+1}"/>)</label>
	        <input type="file" id="necessaryProof<c:out value="${necessaryProofNumber+1}"/>" name="necessaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
<%-- 	        <button class="add" onclick="delNecessaryProof(<c:out value="${necessaryProofNumber+1}"/>)">－</button> --%>
	        <button class="add" onclick="addNecessaryProof(<c:out value="${necessaryProofNumber+1}"/>)" style>＋</button>
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

	<!------------ loading 效果 ------------>
    <div id="loader-container" style="display:none;">
    <p id="loadingText">Loading</p>
    </div>
	
    <div class="page">
      <button onclick="javascript:location.href='career_05'">回上頁</button>
      
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
<script src="js/career_06/career_06.js"></script>
</body>
</html>