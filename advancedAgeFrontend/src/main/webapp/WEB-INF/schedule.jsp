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
<!--   <header> -->
<!--     <div class="navigation"> -->
<!--       <div class="top_logo"><img src="images/top_logo.png"></div> -->
<!--       <nav> -->
<!--         <ul> -->
<!--           <li><a href="login.html" title="帳號申請／登入">帳號申請／登入</a></li> -->
<!--           <li><a href="sitemap.html" title="網站導覽">網站導覽</a></li> -->
<!--         </ul> -->
<!--       </nav> -->
<!--     </div> -->
    
<!--     - nav - -->
<!--     <nav class="main_menu"> -->
<!--       <ul> -->
<!--         <li><a href="index.html" title="首頁" class="m1">首頁</a></li> -->
<!--         <li><a href="require.html" title="補助計畫" class="m2">補助計畫</a></li> -->
<!--         <li><a href="employ.html" title="線上申辦" class="m3">線上申辦</a></li> -->
<!--         <li><a href="schedule.html" title="案件查詢" class="m4-in in">案件查詢</a></li> -->
<!--         <li><a href="teaching.html" title="申請教學" class="m5">申請教學</a></li> -->
<!--         <li><a href="download.html" title="資料下載" class="m6">資料下載</a></li> -->
<!--         <li><a href="service.html" title="諮詢服務" class="m7">諮詢服務</a></li> -->
<!--       </ul> -->
<!--     </nav> -->
<!--     - nav end -  -->
    
<!--   </header> -->
  <!--- header end ---> 
  
  <!--- main --->
  <div class="main"> 
    
    <!------------ 申請流程 ------------>
    <div class="apply_main">
      <h1>繼續僱用高齡者補助計畫</h1>
      <h2>申請流程：案件查詢</h2>
      
      <!---申辦前準備--->
      <h3>案件已送出且資料無法修改，僅供查詢您填寫的申請資料，<br>
      若有補件需求，請等待補件通知，或洽詢<a href="service">各縣市受理單位</a>。
      </h3>
      
      <div>
        <div class="fs-4 fw-bolder py-3">案件申請查詢：<div class="text-danger"><c:if test="${base.caseStatus<3 }">申請案件審核中</c:if><c:if test="${base.caseStatus==3 }">審核通過</c:if></div></div>
        <div class="fs-6 lh-base">9月1日 至 10月31日為申辦期間，<br>
        審核結果將陸續公布</div>
        <div class="fs-6 fw-bolder py-3">審核通過方可申請「請領作業」。</div>
      </div>
      
      <!--startprint-->
      <div class="form">
        <div class="title_main"><span>申請書</span></div>
        <div>單位名稱：${apply.companyName}</div>
        <div>統一編號：${apply.seq}</div>
        <div>行業別：<c:forEach items="${industryList}" var="item"><c:if test="${item.code==apply.industry}">${item.name}</c:if></c:forEach></div>
        <div>勞保投保證號：${apply.guaranteeNumber.replace(";","、")}</div>
        <div class="full">聯絡地址：
        	<c:forEach items="${cityList}" var="item"><c:if test="${item.code==apply.contactCity}">${item.name}</c:if></c:forEach><c:forEach items="${areaList}" var="item"><c:if test="${item.code==apply.contactArea}">${item.name}</c:if></c:forEach>${apply.contactAddress}
      		<input type="hidden" id="city" value="${apply.contactCity}">
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
      <div class="page">
      	<button type="button" onclick="doPrint()">列印資料</button>
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
<script src="js/schedule/schedule.js"></script>
</body>
</html>