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
        <li class="breadcrumb-item active" aria-current="page">線上申辦</li>
        <li class="breadcrumb-item active" aria-current="page">繼續僱用高齡者補助 - 申請作業</li>
      </ol>
    </nav>
    <h1>繼續僱用高齡者補助 - 申請作業</h1>
    <h2>申請流程 Step6. 送出申請</h2>
    <h3><span class="title">您申請的案件已送出</span></h3>
    
    <div>
    	<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${base.createTime}" var="createTime" />
        <div class="fs-5 fw-bolder">申請日期：${createTime.substring(0,4)-1911}/${createTime.substring(5,7)}/${createTime.substring(8,createTime.length())}</div>
      <h4>《 申辦完成不代表審核通過 》</h4>
      <p>
      如有補件或修改送件資料需求，或您有任何疑問<br>
      請於周一至周五 上班時間洽詢 <a href="https://job.taiwanjobs.gov.tw/internet/index/service_location.aspx" target="_blank">受理單位</a>
      </p>
    </div>
    <div style="display:none">
    <!--startprint-->
    <div class="form">
      <div class="title_main"><span>申請書</span></div>
    
      <div><span class="title-c">單位名稱</span>${apply.companyName}</div>
      <input type="text" id="companyName" value="${apply.companyName}" style="display:none">
        
      <div><span class="title-c">統一編號</span>${apply.seq}</div>
      <input type="text" id="seq" value="${apply.seq}" style="display:none">
        
      <div><span class="title-c">行業別</span><c:forEach items="${industryList}" var="item"><c:if test="${item.code==apply.industry}">${item.name}</c:if></c:forEach></div>
        
      <div><span class="title-c">勞保投保證號</span>${apply.guaranteeNumber.replace(";","、")}</div>
        
      <div class="full"><span class="title-c">聯絡地址</span>
      	<c:forEach items="${cityList}" var="item"><c:if test="${item.code==apply.contactCity}">${item.name}</c:if></c:forEach><c:forEach items="${areaList}" var="item"><c:if test="${item.code==apply.contactArea}">${item.name}</c:if></c:forEach>${apply.contactAddress}
      	<input type="text" id="city" value="${apply.contactCity}" style="display:none">
      </div>
        
      <div><span class="title-c">聯絡人</span>${apply.contactName}</div>
        
      <div><span class="title-c">聯絡人職稱</span>${apply.contactJobtitle}</div>
        
      <div><span class="title-c">聯絡電話</span>${apply.contactWorkPhoneAreaCode} - ${apply.contactWorkPhone} #${apply.contactWorkPhoneExtension}</div>
        
      <div><span class="title-c">行動電話</span>${apply.contactPhone}</div>
        
      <div><span class="title-c">傳真號碼</span>${apply.faxAreaCode} - ${apply.fax}</div>
        
      <div><span class="title-c">電子信箱</span>${apply.email}</div>
      <input type="text" id="email" value="${apply.email}" style="display:none">
        
    </div>
    
    
    
    <div class="form">
    
      <div class="title_main"><span>計畫書</span></div>
    
      <div class="full"><span class="title-c">主要業務/產品/服務</span>
      ${plan.items}</div>
        
      <div class="ss"><span class="title-c">目前員工人數</span>${plan.employmentNumber }</div>
        
      <div class="ss"><span class="title-c">65歲以上人數</span>${plan.highEmploymentNumber}</div>
        
      <div class="ss"><span class="title-c">45~64歲人數</span>${plan.middleEmploymentNumber }</div>
        
      <div class="ss"><span class="title-c">44歲以下人數</span>${plan.lowEmploymentNumber }</div>
        
      <div class="ss"><span class="title-c">屆齡65歲人數 (A)</span>${plan.nearHighEmploymentNumber }</div>
        
      <div class="ss"><span class="title-c">規劃繼續僱用人數 (B)</span>${plan.continueEmploymentNumber }</div>
        
      <div class="ss"><span class="title-c">繼續僱用比例 (C)</span>${plan.continueEmploymentPercentage } %
      <img src="images/icon_qu.png" class="icon_qu"
title="繼續僱用高齡者
比例須達30%以上
才符合補助資格
C=(B)/(A) x 100%">
</div>
        
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
              <span>出生日期</span>
              <span>身分證字號</span>
              <span>保險類型</span>
              <span>加保日期</span>
              <span class="s">職務類型</span>
              <span>親等關係</span>
              <span class="s">工時類型</span>
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
		              <span>${item.birthday.substring(0,3)}/${item.birthday.substring(3,5)}/${item.birthday.substring(5)}</span>
		              <span>${item.identification}</span>
		              <span>
		              	<c:if test="${item.laborProtectionTime.length()==7}">勞工保險</c:if>
		              	<c:if test="${item.occupationalAccidentProtectionTime.length()==7}">職災保險</c:if>
		              </span>
		              <span>
		              	<c:if test="${item.laborProtectionTime.length()==7}">${item.laborProtectionTime.substring(0,3)}/${item.laborProtectionTime.substring(3,5)}/${item.laborProtectionTime.substring(5)}</c:if>
			            <c:if test="${item.occupationalAccidentProtectionTime.length()==7}">${item.occupationalAccidentProtectionTime.substring(0,3)}/${item.occupationalAccidentProtectionTime.substring(3,5)}/${item.occupationalAccidentProtectionTime.substring(5)}</c:if>
		              </span>
		              <span class="s">
		              	<c:if test="${item.manager=='Y'}">主管</c:if>
			            <c:if test="${item.manager=='N'}">非主管</c:if>
			          </span>
		              <span>
		              	<c:if test="${item.relatives=='Y'}">三等親內</c:if>
			            <c:if test="${item.relatives=='N'}">非三等親</c:if>
			          </span>
		              <span class="s">
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
    
      <div class="full lh-lg">
      	<span class="title-c">設立登記證明文件：</span><br>
   		<c:choose><c:when test="${not empty registerAttachment}">
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
      <div class="full lh-lg">
	      <span class="title-c">投保勞保或職災保險證明文件:</span><br>
	      <c:choose><c:when test="${not empty insureAttachment}">
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
      <div class="full lh-lg">
	      <span class="title-c">薪資證明文件：</span><br>
	      <c:choose><c:when test="${not empty salaryAttachment}">
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
      <div class="full lh-lg">
	      <span class="title-c">出勤證明文件：</span><br>
	      <c:choose><c:when test="${not empty attendanceAttachment}">
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
      <div class="full lh-lg">
	      <span class="title-c">其他文件：</span><br>
	      <c:choose><c:when test="${not empty necessaryAttachment}">
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
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/employ_06/employ_06.js"></script>
</body>
</html>