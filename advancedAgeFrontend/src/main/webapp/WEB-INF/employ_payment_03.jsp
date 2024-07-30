<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>  
<html lang="zh-hant-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>中高齡就業相關補助計畫</title>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/template.css" type="text/css">
<link rel="stylesheet" href="css/main.css" type="text/css">
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.bundle.js"></script>
<script src="js/employ_payment_03/employ_payment_03.js"></script>
</head>

<body>
  <div class=""> 
          <!-- Modal-1 -->
          <div class="modal modal-dialog-scrollable fade" id="exampleModal-1"
           tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg">
              <div class="modal-content">
                <img src="/file/SAMPLE/公司設立登記證明文件-1.jpg" alt="公司設立登記證明文件">
              </div>
            </div>
          </div>
          <!-- Modal-1 -->
          
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
                <img src="/file/SAMPLE/員工個人投保資料.jpg" alt="員工個人投保資料">
              </div>
            </div>
          </div>
          <!-- Modal-3 -->
          
          <!-- Modal-4 -->
          <div class="modal modal-dialog-scrollable fade" id="exampleModal-4"
           tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
              <div class="modal-content">
                <img src="/file/SAMPLE/薪資證明範例.png" alt="薪資證明範本">
              </div>
            </div>
          </div>
          <!-- Modal-4 -->
          
          <!-- Modal-5 -->
          <div class="modal fade" id="exampleModal-5"
           tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-sm">
              <div class="modal-content">
                <img src="/file/SAMPLE/出勤證明文件-1.jpg" alt="出勤證明文件範本">
              </div>
            </div>
          </div>
          <!-- Modal-5 -->

  
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
        <li class="breadcrumb-item active" aria-current="page">繼續僱用高齡者補助 - 請領作業</li>
      </ol>
    </nav>
    <h1>繼續僱用高齡者補助 - 請領作業</h1>
    <h2>申請流程 Step3. 上傳證明文件</h2>
    
    <!---上傳證明文件--->
    <h3>
    上傳之檔案格式請符合以下規定，其他格式則不受理：<br>
    jpg、png、pdf 等單一檔，檔案大小以 5mb 為限，<br>
    rar、zip、7z 等壓縮檔，檔案大小以 50mb 為限。<br>
    </h3>
    
    <!------------選擇請領資料----------->
    <c:set var="startIndex" value="${fn:length(base.allowanceFrequencyRecord.split(';'))-1}"></c:set> 
    <div class="input-group pb-4 mx-auto patmant_select">
    	<select class="form-select rounded-pill rounded border-secondary" disabled id="baseId" name="baseId">
  			<c:forEach items="${baseList.toList()}" var="baseItem"  varStatus="status">
  				<c:if test="${baseItem.get('caseStatus')>=4}">
  					<option value="${baseItem.get('id')}" <c:if test="${not empty baseId && baseId==baseItem.get('id')}">selected</c:if><c:if test="${empty baseId && status.last}">selected</c:if>>${baseItem.get("year")}年度</option>
  				</c:if>
  			</c:forEach>
	    </select>
	    <select class="form-select rounded-pill rounded border-secondary" disabled id="baseAllowanceFrequencyTime" name="baseAllowanceFrequencyTime">
	    	<option value="0" <c:if test="${baseAllowanceFrequencyTime==0}">selected</c:if>>本次請領 (新)</option>
		    	<option disabled>----------------------</option>
		    	<c:forEach items="${base.allowanceFrequencyRecord.split(';') }" var="eachItem"  varStatus="status">
			    	<c:set var="data_spl" value="${base.allowanceFrequencyRecord.split(';')[startIndex-status.index]}"></c:set>
			    	<c:set var="data" value="${data_spl.substring(0,data_spl.lastIndexOf('、'))}"></c:set>
			    	<option value="${startIndex-status.index+1}" <c:if test="${baseAllowanceFrequencyTime==startIndex-status.index+1}">selected</c:if>>第${data.split('、')[0]}次請領 
			    	${data.split('、')[1].substring(0,4)-1911}/${data.split('、')[1].substring(5,7)}/${data.split('、')[1].substring(8,10)}</option>
		    	</c:forEach>
		    	<option disabled>----------------------</option>
	    </select>
    </div>
    <!-------------原核定函影本------------>
    <div class="form">
<%--     	<input type="text" id="baseId" value="${baseId }" style="display:none"> --%>
      <div class="title_main">
        <span>原核定函影本</span>
      </div>
      <div class="file_box" id="approved">
      	<c:choose><c:when test="${not empty approvedAttachment}">
      	<c:set var="approvedProofNumber" value="1"/>
      	<c:forEach items="${approvedAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='approved' && (fileFrequencyTime)==item.fileFrequency}">
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
    
    
    <!-------------領據------------>
    <div class="form">
    
      <div class="title_main">
        <span>領據</span>
        <em>須加蓋公司大小章及張貼匯款帳戶封面影本 
        【<a href="/file/SAMPLE/繼續僱用_領據.docx">下載空白領據.docx</a>】
        【<a href="/file/SAMPLE/繼續僱用_領據.odt">下載空白領據.odt</a>】</em>
      </div>
      <div class="file_box" id="receipt">
      	<c:choose><c:when test="${not empty receiptAttachment}">
      	<c:set var="receiptProofNumber" value="1"/>
      	<c:forEach items="${receiptAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='receipt' && (fileFrequencyTime)==item.fileFrequency}">
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
    
    
    <!-------------僱用證明------------>
    <div class="form">
    
    <div class="title_main">
        <span>僱用證明</span>
        <em>請檢附繼續僱用員工個人投保資料 
          <!-- Button trigger modal-2 -->
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModal-3">範例</button>
        </em>
      </div>
      
      <div class="file_box" id="employment">
      	<c:choose><c:when test="${not empty employmentAttachment}">
      	<c:set var="employmentProofNumber" value="1"/>
      	<c:forEach items="${employmentAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='employment' && (fileFrequencyTime)==item.fileFrequency}">
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
    



    <!-------------薪資證明------------>
    <div class="form">
    
      <div class="title_main">
        <span>薪資證明</span>
        <em>請檢附申請勞工最近3個月之薪資證明      
          <!-- Button trigger modal-3 -->
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModal-4">範例</button>
        </em>
      </div>
      
      <div class="file_box" id="salary">  
      	<c:choose><c:when test="${not empty salaryAttachment}">
      	<c:set var="salaryProofNumber" value="1"/>
      	<c:forEach items="${salaryAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='salary' && (fileFrequencyTime)==item.fileFrequency}">
		      		<div class="full">
				        <label for="">文件(${salaryProofNumber})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="salaryProofNumber" value="${salaryProofNumber+1}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="salaryProof<c:out value="${salaryProofNumber}"/>">文件(<c:out value="${salaryProofNumber}"/>)</label>
	        <input type="file" id="salaryProof<c:out value="${salaryProofNumber}"/>" name="salaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addSalaryProof(<c:out value="${salaryProofNumber}"/>)" style>＋</button>
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
          data-bs-target="#exampleModal-5">範例</button>
        </em>
      </div>
          
      <div class="file_box" id="attendance">  
      	<c:choose><c:when test="${not empty attendanceAttachment}">
      	<c:set var="attendanceProofNumber" value="1"/>
      	<c:forEach items="${attendanceAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='attendance' && (fileFrequencyTime)==item.fileFrequency}">
		      		<div class="full">
				        <label for="">文件(${attendanceProofNumber})</label>
				        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
				        <span class="file_progress">上傳完成</span>
				        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
				        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
			        </div>
			        <c:set var="attendanceProofNumber" value="${attendanceProofNumber+1}"/>
		      	</c:when>
	      	</c:choose>
      	</c:forEach>
        <div class="full">
	        <label for="attendanceProof<c:out value="${attendanceProofNumber}"/>">文件(<c:out value="${attendanceProofNumber}"/>)</label>
	        <input type="file" id="attendanceProof<c:out value="${attendanceProofNumber}"/>" name="attendanceProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z,.doc,.docx,.odt">
	        <button class="add" onclick="addAttendanceProof(<c:out value="${attendanceProofNumber}"/>)" style>＋</button>
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
      	<c:set var="necessaryProofNumber" value="1"/>
      	<c:forEach items="${necessaryAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='necessary' && (fileFrequencyTime)==item.fileFrequency}">
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
      <button onclick="javascript:location.href='employ_payment_02'">回上頁</button>
      
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
  <!------------ 申請流程 END ------------>>
    
  </div>
  <!--- main end ---> 
  
  <!--- footer --->
  <%@ include file="footer.jsp" %>
  <!--- footer end ---> 
  
</div>

</body>
</html>