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
  <div class="main"> 
    <a href="#C" title="中央內容區塊" id="AC" accesskey="C" name="C">:::</a> <!---無障礙--->
    <!------------ 申請流程 ------------>
    <div class="apply_main">
      <!---無障礙/麵包屑--->
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index" title="首頁">首頁</a></li>
          <li class="breadcrumb-item active" aria-current="page">案件查詢</li>
          <li class="breadcrumb-item active" aria-current="page">繼續僱用高齡者補助 - 申請進度</li>
        </ol>
      </nav>
      <h1>繼續僱用高齡者補助 - 申請進度</h1>
      <h2>申請流程：案件查詢</h2>
      
      <!---說明文字--->
      <h3>案件已送出且資料無法修改，僅供查詢您填寫的申請資料，<br>
      若有補件需求，請等待補件通知，或洽詢<a href="https://job.taiwanjobs.gov.tw/internet/index/service_location.aspx" target="_blank">受理單位</a>
      </h3>
      
      <div>
      	<c:if test="${not empty base.createTime}">
	      	<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${base.createTime}" var="createTime" />
	        <div class="fs-5 fw-bolder">申請日期：${createTime.substring(0,4)-1911}/${createTime.substring(5,7)}/${createTime.substring(8,createTime.length())}</div>
	        <div class="fs-5 fw-bolder py-2 mb-3">進度查詢：<span class="text-danger"><c:if test="${base.caseStatus==1 }">申請案件審核中</c:if><c:if test="${base.caseStatus==2 }">審核不通過</c:if><c:if test="${base.caseStatus>=3 }">審核通過</c:if></span></div>
        </c:if>
	    
	    <c:if test="${empty base.createTime}">
        	<div class="fs-5 fw-bolder py-2 mb-3">進度查詢：<span class="text-danger">查無資料</span></div>
        </c:if>
        <div class="fs-6 lh-base">9月1日 至 10月31日為申辦期間，審核結果將陸續公布。</div>
        <c:if test="${base.caseStatus<3 }">
        	<div class="fs-6 fw-bolder py-3">審核通過方可繼續「請領作業」。</div>
	    </c:if>
        <c:if test="${base.caseStatus>=3 }">
        	<div class="fs-6 fw-bolder py-3">審核已通過，請繼續完成「<a href="${mailDomain}/advancedAgeFrontend/employ_payment">請領作業</a>」。</div>
	    </c:if>
      </div>
<!--       <div> -->
<%--         <div class="fs-4 fw-bolder py-3">案件申請查詢：<div class="text-danger"><c:if test="${base.caseStatus==1 }">申請案件審核中</c:if><c:if test="${base.caseStatus==2 }">審核不通過</c:if><c:if test="${base.caseStatus>=3 }">審核通過</c:if></div></div> --%>
<!--         <div class="fs-6 lh-base">9月1日 至 10月31日為申辦期間，<br> -->
<!--         審核結果將陸續公布</div> -->
<!--         <div class="fs-6 fw-bolder py-3">審核通過方可申請「請領作業」。</div> -->
<!--       </div> -->
      
      <div style="display:none">
      <!--startprint-->
      <div class="form">
        <div class="title_main"><span>申請書</span></div>
        <div>單位名稱：${apply.companyName}</div>
        <div>統一編號：${apply.seq}</div>
        <div>行業別：<c:forEach items="${industryList}" var="item"><c:if test="${item.code==apply.industry}">${item.name}</c:if></c:forEach></div>
        <div>勞保投保證號：${apply.guaranteeNumber.replace(";","、")}</div>
        <div class="full">聯絡地址：
        	<c:forEach items="${cityList}" var="item"><c:if test="${item.code==apply.contactCity}">${item.name}</c:if></c:forEach><c:forEach items="${areaList}" var="item"><c:if test="${item.code==apply.contactArea}">${item.name}</c:if></c:forEach>${apply.contactAddress}
      		<input type="text" id="city" value="${apply.contactCity}" style="display:none">
		</div>
        <div>聯絡人：${apply.contactName}</div>
        <div>聯絡人職稱：${apply.contactJobtitle}</div>
        <div>聯絡電話：${apply.contactWorkPhoneAreaCode} - ${apply.contactWorkPhone} #${apply.contactWorkPhoneExtension}</div>
        <div>行動電話：${apply.contactPhone}</div>
        <div>傳真號碼：${apply.faxAreaCode} - ${apply.fax}</div>
        <div>電子信箱：${apply.email}</div>
      </div>
      <div class="form">
        <div class="title_main"><span>計畫書</span></div>
        <div class="full"> 主要業務/產品/服務：${plan.items}</div>
        <div class="ss">目前員工人數：${plan.employmentNumber }</div>
        <div class="ss">65歲以上人數：${plan.highEmploymentNumber}</div>
        <div class="ss">45~64歲人數：${plan.middleEmploymentNumber }</div>
        <div class="ss">44歲以下人數：${plan.lowEmploymentNumber }</div>
        <div class="ss">屆齡65歲人數 (A)：${plan.nearHighEmploymentNumber }</div>
        <div class="ss">規劃繼續僱用人數 (B)：${plan.continueEmploymentNumber }</div>
        <div class="ss">繼續僱用比例 (C)：${plan.continueEmploymentPercentage } % <!---<img src="images/icon_qu.png" class="icon_qu"
title="繼續僱用高齡者
比例須達30%以上
才符合補助資格
C=(B)/(A) x 100%">---> </div>
      </div>
      <div class="form">
        <div class="title_main"><span>繼續僱用補助名單清冊</span></div>
        
        <c:if test="${plan.attachEmploymentList =='Y'}">
    	<c:choose><c:when test="${not empty employmentListAttachment}">
	      	<c:forEach items="${employmentListAttachment}" var="item" varStatus="status">
		      	<c:choose>
			      	<c:when test="${item.fileType=='employmentList' }">
			      	<br>
			      		<div class="full">
					        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>&nbsp;&nbsp;
					        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>&nbsp;&nbsp;
					        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
				        </div>
			      	</c:when>
		      	</c:choose>
	      	</c:forEach>
        </c:when></c:choose>
      </c:if>
	  <c:if test="${plan.attachEmploymentList =='N'}">
	  	<div class="staff_list">
          <ul class="clearfix">
            <li>
              <span>勞工姓名</span>
              <span>身分證字號</span>
              <span>保險類型</span>
              <span>加保日期</span>
              <span>職務類型</span>
              <span>親等關係</span>
              <span>工時類型</span>
              <span>申請前3個月經常性薪資總和</span>
              <span>申請前3個月非經常性薪資總和</span>
            </li>
          </ul>
        </div>
        <div class="staff_list">
        	<ol>
       		<c:choose><c:when test="${not empty advancedAgeEmploymentLists}">
		      	<c:forEach items="${advancedAgeEmploymentLists}" var="item" varStatus="status">
			      	<li>
		              <span>${item.name}</span>
		              <span>${item.identification}</span>
		              <span>
		              	<c:if test="${item.laborProtectionTime.length()==7}">勞工保險</c:if>
		              	<c:if test="${item.occupationalAccidentProtectionTime.length()==7}">職災保險</c:if>
		              </span>
		              <span>
		              	<c:if test="${item.laborProtectionTime.length()==7}">${item.laborProtectionTime.substring(0,3)}/${item.laborProtectionTime.substring(3,5)}/${item.laborProtectionTime.substring(5)}</c:if>
			            <c:if test="${item.occupationalAccidentProtectionTime.length()==7}">${item.occupationalAccidentProtectionTime.substring(0,3)}/${item.occupationalAccidentProtectionTime.substring(3,5)}/${item.occupationalAccidentProtectionTime.substring(5)}</c:if>
		              </span>
		              <span>
		              	<c:if test="${item.manager=='Y'}">主管</c:if>
			            <c:if test="${item.manager=='N'}">非主管</c:if>
			          </span>
		              <span>
		              	<c:if test="${item.relatives=='Y'}">三等親內</c:if>
			            <c:if test="${item.relatives=='N'}">非三等親</c:if>
			          </span>
		              <span>
		              	<c:if test="${item.workingHours=='A'}">全時</c:if>
			            <c:if test="${item.workingHours=='P'}">部分工時</c:if>
			          </span>
		              <span>${item.recurringSalary}</span>
		              <span>${item.notRecurringSalary}</span>
		            </li>
		      	</c:forEach>
        	</c:when></c:choose>
          
            
            
          </ol>
        </div>
	  </c:if>
        
      </div>


      <div class="form">
        <div class="title_main"><span>檢附文件</span></div>
        <div class="full">
	      	設立登記證明文件：<br>
	   		<c:choose><c:when test="${registerAttachment != '[]'}">
	      	<c:forEach items="${registerAttachment}" var="item" varStatus="status">
		      	<c:choose>
			      	<c:when test="${item.fileType=='register' }">
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
	      <div class="full">
		      投保勞保或職災保險證明文件:<br>
		      <c:choose><c:when test="${insureAttachment != '[]'}">
		    	<c:forEach items="${insureAttachment}" var="item" varStatus="status">
		     	<c:choose>
		      	<c:when test="${item.fileType=='insure' }">
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
	      <div class="full">
		      薪資證明文件：<br>
		      <c:choose><c:when test="${salaryAttachment != '[]'}">
		    	<c:forEach items="${salaryAttachment}" var="item" varStatus="status">
		     	<c:choose>
		      	<c:when test="${item.fileType=='salary' }">
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
	      <div class="full">
		      出勤證明文件：<br>
		      <c:choose><c:when test="${attendanceAttachment != '[]'}">
		    	<c:forEach items="${attendanceAttachment}" var="item" varStatus="status">
		     	<c:choose>
		      	<c:when test="${item.fileType=='attendance' }">
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
	      <div class="full">
		      其他文件：<br>
		      <c:choose><c:when test="${necessaryAttachment != '[]'}">
		    	<c:forEach items="${necessaryAttachment}" var="item" varStatus="status">
		     	<c:choose>
		      	<c:when test="${item.fileType=='necessary' }">
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
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/schedule/schedule.js"></script>
</body>
</html>