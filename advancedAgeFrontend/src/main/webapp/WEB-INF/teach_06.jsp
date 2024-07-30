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
<link rel="stylesheet" href="css/cmxform.css" type="text/css">

<script src="js/bootstrap.bundle.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/gotop.js"></script>
<script src="js/teach_06/teach_06.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
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
        <li class="breadcrumb-item active" aria-current="page">僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 申請作業</li>
      </ol>
    </nav>
    <h1>僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 申請作業</h1>
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
	        <button class="add" onclick="addRegisterProof(1)" style>＋</button>
        </div>
        </c:otherwise></c:choose>
      </div>
      
    </div>
    
    <div class="btn_box">
      <button class="save" onclick="upload()">上傳檔案</button>
    </div> 
    
    
    <!-------------講師為退休高齡者證明文件------------>
    <div class="form">
    
      <div class="title_main">
        <span>講師為退休高齡者證明文件</span>
        <em>
          <!-- Button trigger modal-2 
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModal-2">範例 1</button>-->
        </em>
      </div>
      
      <div class="file_box" id="speakerRetirement">  
      	<c:choose><c:when test="${not empty speakerRetirementAttachment}">
      	<c:forEach items="${speakerRetirementAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='speakerRetirement' }">
		      		<div class="full">
				        <label for="">文件(${status.count})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="speakerRetirementProofNumber" value="${status.count}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="speakerRetirementProof<c:out value="${insureProofNumber+1}"/>">文件(<c:out value="${insureProofNumber+1}"/>)</label>
	        <input type="file" id="speakerRetirementProof<c:out value="${insureProofNumber+1}"/>" name="speakerRetirementProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
<%-- 	        <button class="add" onclick="delSpeakerRetirementProof(<c:out value="${speakerRetirementProofNumber+1}"/>)">－</button> --%>
	        <button class="add" onclick="addSpeakerRetirementProof(<c:out value="${speakerRetirementProofNumber+1}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="speakerRetirementProof1">文件(1)</label>
	        <input type="file" id="speakerRetirementProof1" name="speakerRetirementProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addSpeakerRetirementProof(1)" style>＋</button>
        </div>
        </c:otherwise></c:choose>
      </div>
      
    </div>
    
    <div class="btn_box">
      <button class="save" onclick="upload()">上傳檔案</button>
    </div>
    



    <!-------------講師具專業技術及經驗證明文件------------>
    <div class="form">
    
      <div class="title_main">
        <span>講師具專業技術及經驗證明文件</span>
        <em>    
          <!-- Button trigger modal-3 
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModal-3">範例 1</button>-->
        </em>
      </div>
      
      <div class="file_box" id="speakerExperience">  
      	<c:choose><c:when test="${not empty speakerExperienceAttachment}">
      	<c:forEach items="${speakerExperienceAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='speakerExperience' }">
		      		<div class="full">
				        <label for="">文件(${status.count})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="speakerExperienceProofNumber" value="${status.count}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="speakerExperienceProof<c:out value="${insureProofNumber+1}"/>">文件(<c:out value="${insureProofNumber+1}"/>)</label>
	        <input type="file" id="speakerExperienceProof<c:out value="${insureProofNumber+1}"/>" name="speakerExperienceProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
<%-- 	        <button class="add" onclick="delSpeakerExperienceProof(<c:out value="${speakerExperienceProofNumber+1}"/>)">－</button> --%>
	        <button class="add" onclick="addSpeakerExperienceProof(<c:out value="${speakerExperienceProofNumber+1}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="speakerExperienceProof1">文件(1)</label>
	        <input type="file" id="speakerExperienceProof1" name="speakerExperienceProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addSpeakerExperienceProof(1)" style>＋</button>
        </div>
        </c:otherwise></c:choose>
      </div>
      
    </div>
    
    <div class="btn_box">
      <button class="save" onclick="upload()">上傳檔案</button>
    </div>


    <!-------------僱用證明文件------------>
    <div class="form">
    
      <div class="title_main">
        <span>僱用證明文件</span>
        <em>
          <!-- Button trigger modal-3 
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModal-4">範例 1</button>-->
        </em>
      </div>
          
      <div class="file_box" id="employment">
      	<c:choose><c:when test="${not empty employmentAttachment}">
      	<c:set var="employmentProofNumber" value="1"/>
      	<c:forEach items="${employmentAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='employment'}">
		      		<div class="full">
				        <label for="">文件(${employmentProofNumber})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="employmentProofNumber" value="${employmentProofNumber+1}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="employmentProof<c:out value="${employmentProofNumber}"/>">文件(<c:out value="${employmentProofNumber}"/>)</label>
	        <input type="file" id="employmentProof<c:out value="${employmentProofNumber}"/>" name="employmentProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addEmploymentProof(<c:out value="${employmentProofNumber}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="employmentProof1">文件(1)</label>
	        <input type="file" id="employmentProof1" name="employmentProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addEmploymentProof(1)" style>＋</button>
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
		      	<c:when test="${item.fileType=='necessary'}">
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

	<!------------ loading 效果 ------------>
    <div id="loader-container" style="display:none;">
    <p id="loadingText">Loading</p>
    </div>

    <div class="page">
      <button onclick="javascript:location.href='teach_05'">回上頁</button>
      
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


</body>
</html>