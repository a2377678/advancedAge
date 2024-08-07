<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="zh-hant-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>中高齡就業相關補助計畫</title>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/template.css" type="text/css">
<link rel="stylesheet" href="css/main.css" type="text/css">

<link rel="stylesheet" href="css/cmxform.css" type="text/css">
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
  
  <!-- Modal-2-1 -->
  <div class="modal modal-dialog-scrollable fade" id="exampleModal-2-1"
   tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <img src="/file/SAMPLE/投保證明範本.png" alt="投保證明範本">
      </div>
    </div>
  </div>
  <!-- Modal-2-1 -->
  
  <!-- Modal-2-2 -->
  <div class="modal modal-dialog-scrollable fade" id="exampleModal-2-2"
   tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg">
      <div class="modal-content">
        <img src="/file/SAMPLE/員工個人投保資料.jpg" alt="員工個人投保資料">
      </div>
    </div>
  </div>
  <!-- Modal-2-2 -->
  
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
  <div class="main"> 
    <a href="#C" title="中央內容區塊" id="AC" accesskey="C" name="C">:::</a> <!---無障礙--->
  <!------------ 申請流程 ------------>
  <div class="apply_main">
  <%@ include file="countDownComponent.jsp" %>
    <!---無障礙/麵包屑--->
    <nav aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index" title="首頁">首頁</a></li>
        <li class="breadcrumb-item active" aria-current="page">線上申辦</li>
        <li class="breadcrumb-item active" aria-current="page">繼續僱用高齡者補助 - 申請作業</li>
      </ol>
    </nav>
    <h1>繼續僱用高齡者補助 - 申請作業</h1>
    <h2>申請流程 Step4. 上傳證明文件</h2>
    
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
    
    
    
    <!-------------投保勞保或職災保險證明文件------------>
    <div class="form">
    
      <div class="title_main">
      <span>投保勞保或職災保險證明文件</span>
      	<em>請檢附最近一個月投保人數之證明及欲申請勞工之僱用證明
      	<!-- Button trigger modal-2 -->
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModal-2-1">範例 1</button>
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModal-2-2">範例 2</button>
        </em>
      </div>
      
      <div class="file_box" id="insure">  
      	<c:choose><c:when test="${not empty insureAttachment}">
      	<c:forEach items="${insureAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='insure' }">
		      		<div class="full">
				        <label for="">文件(${status.count})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="insureProofNumber" value="${status.count}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="insureProof<c:out value="${insureProofNumber+1}"/>">文件(<c:out value="${insureProofNumber+1}"/>)</label>
	        <input type="file" id="insureProof<c:out value="${insureProofNumber+1}"/>" name="insureProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
<%-- 	        <button class="add" onclick="delInsureProof(<c:out value="${insureProofNumber+1}"/>)">－</button> --%>
	        <button class="add" onclick="addInsureProof(<c:out value="${insureProofNumber+1}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="insureProof1">文件(1)</label>
	        <input type="file" id="insureProof1" name="insureProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
<!-- 	        <button class="add" onclick="delInsureProof(1)">－</button> -->
	        <button class="add" onclick="addInsureProof(1)" style>＋</button>
        </div>
        </c:otherwise></c:choose>
      </div>
      
      
    </div>
    
    <div class="btn_box">
      <button class="save" onclick="upload()">上傳檔案</button>
    </div>

    <!-------------薪資證明------------>
    <div class="form">
    
      <div class="title_main">
      <span>薪資證明文件</span>
      <em>請檢附申請勞工最近3個月之薪資證明
      <!-- Button trigger modal-3 -->
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModal-3">範例 1</button>
      </em>
      </div>
      
      <div class="file_box" id="salary">  
      	<c:choose><c:when test="${not empty salaryAttachment}">
      	<c:forEach items="${salaryAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='salary' }">
		      		<div class="full">
				        <label for="">文件(${status.count})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="salaryProofNumber" value="${status.count}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="salaryProof<c:out value="${salaryProofNumber+1}"/>">文件(<c:out value="${salaryProofNumber+1}"/>)</label>
	        <input type="file" id="salaryProof<c:out value="${salaryProofNumber+1}"/>" name="salaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
<%-- 	        <button class="add" onclick="delSalaryProof(<c:out value="${salaryProofNumber+1}"/>)">－</button> --%>
	        <button class="add" onclick="addSalaryProof(<c:out value="${salaryProofNumber+1}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="salaryProof1">文件(1)</label>
	        <input type="file" id="salaryProof1" name="salaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addSalaryProof(1)" style>＋</button>
        </div>
        </c:otherwise></c:choose>
        
      </div>
      
      
    </div>

	<div class="btn_box">
      <button class="save" onclick="upload()">上傳檔案</button>
    </div>
	<!-------------出勤證明文件------------>
    <div class="form">
    
      <div class="title_main">
      <span>出勤證明文件</span>
      <em>請檢附申請勞工最近3個月之出勤證明文件
      	<!-- Button trigger modal-3 -->
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModal-4">範例 1</button>  
      </em>
      </div>
          
      <div class="file_box" id="attendance">  
      	<c:choose><c:when test="${not empty attendanceAttachment}">
      	<c:forEach items="${attendanceAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='attendance' }">
		      		<div class="full">
				        <label for="">文件(${status.count})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="attendanceProofNumber" value="${status.count}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="attendanceProof<c:out value="${attendanceProofNumber+1}"/>">文件(<c:out value="${attendanceProofNumber+1}"/>)</label>
	        <input type="file" id="attendanceProof<c:out value="${attendanceProofNumber+1}"/>" name="attendanceProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
<%-- 	        <button class="add" onclick="delAttendanceProof(<c:out value="${attendanceProofNumber+1}"/>)">－</button> --%>
	        <button class="add" onclick="addAttendanceProof(<c:out value="${attendanceProofNumber+1}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
          <label for="attendanceProof1">文件(1)</label>
          <input type="file" id="attendanceProof1" name="attendanceProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
          <button class="add" onclick="addAttendanceProof(1)" style>＋</button>
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
      <button onclick="javascript:location.href='employ_03'">回上頁</button>
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
    </div>
    
  </div>
  <!------------ 申請流程 END ------------>
    
  </div>
  <!--- main end ---> 
  
  <!--- footer --->
  <%@ include file="footer.jsp" %>
  <!--- footer end ---> 
  
</div>
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/employ_04/employ_04.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
</body>
</html>