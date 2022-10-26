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
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/employ_payment_03/employ_payment_03.js"></script>
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
  <div class="main"> 
    
  <!------------ 申請流程 ------------>
  <div class="apply_main">
    <h1>繼續僱用高齡者補助 - 請領作業</h1>
    <h2>申請流程 Step3. 上傳證明文件</h2>
    
    <!---上傳證明文件--->
    <h3>
    上傳之檔案格式請符合以下規定，其他格式則不受理：<br>
    jpg、png、pdf、rar、zip、7z，檔案大小以 5mb 為限。<br>
    </h3>
    
    <!-------------原核定函影本------------>
    <div class="form">
    	<input type="text" id="baseId" value="${baseId }" style="display:none">
      <div class="title_main">
        <span>原核定函影本</span>
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
	        <input type="file" id="approvedProof<c:out value="${approvedProofNumber}"/>" name="approvedProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z">
	        <button class="add" onclick="addApprovedProof(<c:out value="${approvedProofNumber}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="approvedProof1">文件(1)</label>
	        <input type="file" id="approvedProof1" name="approvedProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z">
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
        <em>須加蓋公司大小章及張貼匯款帳戶封面影本 【<a href="/file/SAMPLE/領據.doc">領據.doc</a>】 </em>
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
	        <input type="file" id="receiptProof<c:out value="${receiptProofNumber}"/>" name="receiptProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z">
	        <button class="add" onclick="addReceiptProof(<c:out value="${receiptProofNumber}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="receiptProof1">文件(1)</label>
	        <input type="file" id="receiptProof1" name="receiptProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z">
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
        <em>請檢附申請勞工最近3個月之僱用證明
          <!-- Button trigger modal-2 -->
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModa2-1">範例 1</button>
        </em>
      </div>
      
      <div class="file_box" id="employment">
      	<c:choose><c:when test="${not empty employmentAttachment}">
      	<c:set var="employmentProofNumber" value="1"/>
      	<c:forEach items="${employmentAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='employment' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
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
	        <input type="file" id="employmentProof<c:out value="${employmentProofNumber}"/>" name="employmentProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z">
	        <button class="add" onclick="addEmploymentProof(<c:out value="${employmentProofNumber}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="employmentProof1">文件(1)</label>
	        <input type="file" id="employmentProof1" name="employmentProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z">
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
          data-bs-target="#exampleModal-3">範例 1</button>
        </em>
      </div>
      
      <div class="file_box" id="salary">  
      	<c:choose><c:when test="${not empty salaryAttachment}">
      	<c:set var="salaryProofNumber" value="1"/>
      	<c:forEach items="${salaryAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='salary' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
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
	        <input type="file" id="salaryProof<c:out value="${salaryProofNumber}"/>" name="salaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z">
	        <button class="add" onclick="addSalaryProof(<c:out value="${salaryProofNumber}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
	        <label for="salaryProof1">文件(1)</label>
	        <input type="file" id="salaryProof1" name="salaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z">
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
      	<c:set var="attendanceProofNumber" value="1"/>
      	<c:forEach items="${attendanceAttachment}" var="item" varStatus="status">
	      	<c:choose>
		      	<c:when test="${item.fileType=='attendance' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
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
	        <input type="file" id="attendanceProof<c:out value="${attendanceProofNumber}"/>" name="attendanceProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z">
	        <button class="add" onclick="addAttendanceProof(<c:out value="${attendanceProofNumber}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
          <label for="attendanceProof1">文件(1)</label>
          <input type="file" id="attendanceProof1" name="attendanceProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z">
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
	        <input type="file" id="necessaryProof<c:out value="${necessaryProofNumber}"/>" name="necessaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z">
	        <button class="add" onclick="addNecessaryProof(<c:out value="${necessaryProofNumber}"/>)" style>＋</button>
        </div>
        </c:when>
        <c:otherwise>
        <div class="full">
          <label for="necessaryProof1">文件(1)</label>
          <input type="file" id="necessaryProof1" name="necessaryProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z">
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
      <button onclick="javascript:location.href='employ_payment_04'">下一步</button>
    </div>
    
  </div>
  <!------------ 申請流程 END ------------>>
    
  </div>
  <!--- main end ---> 
  
  <!--- footer --->
  <footer class="copyright">
    <section>
      <div>勞動力發展署：24219新北市新莊區中平路439號南棟4樓　電話代表號：(02)8995-6000　客服專線：0800-777-888</div>
      <div>本署服務時間：週一至週五　上午8時30分至12時30分，下午13時30分至17時30分</div>
      <div>最佳解析度1024x768 ，建議更新瀏覽器至以下版本：最新版本Chrome、最新版本Firefox</div>
      <div>中華民國勞動部勞動力發展署版權所有 © 2021 All rights reserved. </div>
    </section>
  </footer>
  <!--- footer end ---> 
  
</div>

</body>
</html>