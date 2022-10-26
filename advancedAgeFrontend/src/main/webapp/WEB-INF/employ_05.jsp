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
    

  <!------------ 申請流程 ------------>
  <div class="apply_main">
    <h1>繼續僱用高齡者補助計畫</h1>
    <h2>申請流程 Step5. 核對資料</h2>
    
    <!---申辦前準備--->
    <h3>請核對您填寫的資料，確認並「送出案件」<br>
    送出案件後資料不能修改，可在案件查詢再次下載及列印</h3>
    
    <div id="pdf">
    <!--startprint-->
    <div class="form">
      <div class="title_main"><span>申請書</span></div>
    
      <div>單位名稱：${apply.companyName}</div>
      <input type="text" id="companyName" value="${apply.companyName}" style="display:none">
        
      <div>統一編號：${apply.seq}</div>
      <input type="text" id="seq" value="${apply.seq}" style="display:none">
        
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
    
      <div class="full">主要業務/產品/服務：
      ${plan.items}</div>
        
      <div class="ss">目前員工人數：${plan.employmentNumber }</div>
        
      <div class="ss">65歲以上人數：${plan.highEmploymentNumber}</div>
        
      <div class="ss">45~64歲人數：${plan.middleEmploymentNumber }</div>
        
      <div class="ss">44歲以下人數：${plan.lowEmploymentNumber }</div>
        
      <div class="ss">屆齡65歲人數 (A)：${plan.nearHighEmploymentNumber }</div>
        
      <div class="ss">規劃繼續僱用人數 (B)：${plan.continueEmploymentNumber }</div>
        
      <div class="ss">繼續僱用比例 (C)：${plan.continueEmploymentPercentage } %
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
              <span>身分證字號</span>
              <span>保險類型</span>
              <span>加保日期</span>
              <span>職務類型</span>
              <span>親等關係</span>
              <span>工時類型</span>
              <span>經常性薪資</span>
              <span>非經常薪資</span>
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
      <div class="full">
	      投保勞保或職災保險證明文件:<br>
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
      <div class="full">
	      薪資證明文件：<br>
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
      <div class="full">
	      出勤證明文件：<br>
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
      <div class="full">
	      其他文件：<br>
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
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/employ_05/employ_05.js"></script>
</body>
</html>