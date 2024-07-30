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
      <h2>申請流程 Step5. 核對資料</h2>
    
    <!---申辦前準備--->
    <h3>請核對您填寫的資料，確認並「送出案件」<br>
    送出案件後資料不能修改，可在案件查詢再次下載及列印</h3>
    
    <div id="pdf">
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
      	<input type="text" id="city" value="${apply.registerCity}" style="display:none">
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
	</div>
    <!--endprint-->
    
    <div class="page">
      <button type="button" onclick="javascript:location.href='employ_02'">返回修改</button>
      <button type="button" onclick="doPrint()">列印資料</button>
      <!--- Button trigger modal --->
      <button type="button" class="" data-bs-toggle="modal" data-bs-target="#sure">送出案件</button>
      <!---------- Modal ---------->
      <div class="modal fade" id="sure" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" 
      aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title fw-bold" id="staticBackdropLabel">請注意 !!</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body h5 fw-bold lh-base">
              請核對您填寫的資確認並「送出案件」，送出案件<br>
後資料不能修改，可在案件查詢再次下載及列印。
            </div>
            <div class="pt-2 pb-5">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">返回修改</button>
              <button type="button" class="btn btn-primary" onclick="finish()">送出案件</button>
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
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/employ_05/employ_05.js"></script>
</body>
</html>