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
          <li class="breadcrumb-item active" aria-current="page">繼續僱用高齡者補助 - 請領進度</li>
        </ol>
      </nav>
      <h1>繼續僱用高齡者補助 - 請領進度</h1>
      <h2>申請流程：請領查詢</h2>
      
      <!---申辦前準備--->
      <h3>案件已送出且資料無法修改，僅供查詢您填寫的申請資料，<br>
      若有補件需求，請等待補件通知，或洽詢<a href="https://job.taiwanjobs.gov.tw/internet/index/service_location.aspx" target="_blank">受理單位</a>
      </h3>
      
	<c:set var="startIndex" value="${fn:length(base.allowanceFrequencyRecord.split(';'))-1}"></c:set> 
    <form id="searchForm" action="schedule_employ_payment" method="post">
    <!------------選擇請領資料----------->
	  	<div class="input-group pb-4 mx-auto patmant_select">
	  		<select class="form-select rounded-pill rounded border-secondary" id="baseId" name="baseId">
	  			<c:forEach items="${baseList.toList()}" var="baseItem"  varStatus="status">
	  				<option value="${baseItem.get('id')}" <c:if test="${not empty baseId && baseId==baseItem.get('id')}">selected</c:if><c:if test="${empty baseId && status.last}">selected</c:if>>${baseItem.get("year")}年度</option>
	  			</c:forEach>
		    </select>
		    <select class="form-select rounded-pill rounded-end border-secondary" id="baseAllowanceFrequencyTime" name="baseAllowanceFrequencyTime">
		    	<option disabled>----------------------</option>
		    	<c:forEach items="${base.allowanceFrequencyRecord.split(';') }" var="eachItem"  varStatus="status">
			    	<c:set var="data_spl" value="${base.allowanceFrequencyRecord.split(';')[startIndex-status.index]}"></c:set>
			    	<c:set var="data" value="${data_spl.substring(0,data_spl.lastIndexOf('、'))}"></c:set>
			    	<option value="${startIndex-status.index+1}" <c:if test="${baseAllowanceFrequencyTime==startIndex-status.index+1}">selected</c:if>>第${data.split('、')[0]}次請領 
			    	${data.split('、')[1].substring(0,4)-1911}/${data.split('、')[1].substring(5,7)}/${data.split('、')[1].substring(8,10)}</option>
		    	</c:forEach>
		    	<option disabled>----------------------</option>
		    </select>
	    	<button class="btn rounded-pill rounded-start btn-outline-secondary w-25" type="submit">確認</button>
    	</div>
    </form>
  
      <div>
      	<c:if test="${not empty base.allowanceFileStatusRecord}">
	      	<c:set var="createTime" value="${base.allowanceFileStatusRecord.split(';')[baseAllowanceFrequencyTime-1].split('、')[6]}"></c:set>
	      	<div class="fs-5 fw-bolder">請領日期：${createTime.substring(0,4)-1911}/${createTime.substring(5,7)}/${createTime.substring(8,createTime.length())}</div>
	        <div class="fs-5 fw-bolder py-2 mb-3">請領查詢：
	          <c:if test="${base.allowanceFrequencyRecord.split(';')[baseAllowanceFrequencyTime-1].split('、')[2]==0}"><span class="text-danger">本次請領審核中</span></c:if>
	          <c:if test="${base.allowanceFrequencyRecord.split(';')[baseAllowanceFrequencyTime-1].split('、')[2]==1}"><span class="text-info">本次請領已核定</span></c:if>
	        </div>
	    </c:if>
	    <c:if test="${empty base.allowanceFileStatusRecord}">
        	<div class="fs-5 fw-bolder py-2 mb-3">請領查詢：<span class="text-danger">查無資料</span></div>
        </c:if>
      </div>
      
      <div style="display:none">
      <!--startprint-->
      <div class="form">
        <div class="title_main"><span>繼續僱用補助請領清冊</span></div>
        
        <!---填寫名單--->
		<c:choose><c:when test="${not empty advancedAgeEmploymentListReceipts}">
	        <c:forEach items="${advancedAgeEmploymentListReceipts}" var="item" varStatus="status">
		        <table class="table_05">
		          <tr>
		              <td rowspan="9">${status.count }</td>
		              <th>勞工姓名</th>
		              <th>身分證</th>
		              <th>平均薪資</th>
		              <th>計薪方式</th>
		            </tr>
		            <tr>
		              <td>${item.name}</td>
		              <td>${item.identification}</td>
		              <td>${item.salary }</td>
		              <td>
		              	<c:if test="${item.salaryMethod=='M' }">按月計</c:if>
		              	<c:if test="${item.salaryMethod=='H' }">非按月</c:if>
		              	<c:if test="${item.salaryMethod=='MH' }">部分按月，部分按時</c:if>
		              </td>
		            </tr>
		            <tr>
		              <th>退保</th>
		              <th>退保日期</th>
		              <th colspan="2">請領次數</th>
		            </tr>
		            <tr>
		              <td>
		              	<c:if test="${item.laborProtectionExpiredTime.length()==7}">勞工保險</c:if>
		              	<c:if test="${item.occupationalAccidentProtectionExpiredTime.length()==7}">職災保險</c:if>
		              </td>
		              <td>
		              	<c:if test="${item.laborProtectionExpiredTime.length()==7}">${item.laborProtectionExpiredTime}</c:if>
		              	<c:if test="${item.occupationalAccidentProtectionExpiredTime.length()==7}">${item.occupationalAccidentProtectionExpiredTime}</c:if>
		              </td>
		              <td colspan="2">
		              	<c:if test="${item.frequency==1 }">第一次</c:if>
		              	<c:if test="${item.frequency==2 }">第二次</c:if>
		              	<c:if test="${item.frequency==3 }">第三次</c:if>
		              	<c:if test="${item.frequency==4 }">第四次</c:if>
		              	<c:if test="${item.frequency==5 }">第五次</c:if>
		              </td>
		            </tr>
		            <tr>
		              <th>請領補助</th>
		              <th width="19%">請領期間</th>
		              <th>月數</th>
		              <th>請領金額</th>
		            </tr>
		            <tr>
			          <c:if test="${item.salaryMethod=='M'}">
			              <td>按月計</td>
			              <td>${item.employmentMonthStartTime }~${item.employmentMonthEndTime }</td>
			              <td>
			              	<c:if test="${item.frequency>1 }">${item.highMonthNumber }</c:if>
			              	<c:if test="${item.frequency==1 }">${item.lowMonthNumber }</c:if>
			              </td>
			              <td><c:if test="${item.frequency>1 }">${item.highMonthNumber*15000 }</c:if>
			              	<c:if test="${item.frequency==1 }">${item.lowMonthNumber*13000 }</c:if></td>
		              </c:if>
		              <c:if test="${item.salaryMethod=='H'}">
			              <td>按月計</td>
			              <td></td>
			              <td></td>
			              <td></td>
		              </c:if>
		              <c:if test="${item.salaryMethod=='MH'}">
		              	  <td>按月計</td>
			              <td>${item.employmentMonthStartTime }~${item.employmentMonthEndTime }</td>
			              <td>
			              	<c:if test="${item.frequency>1 }">${item.highMonthNumber }</c:if>
			              	<c:if test="${item.frequency==1 }">${item.lowMonthNumber }</c:if>
			              </td>
			              <td><c:if test="${item.frequency>1 }">${item.highMonthNumber*15000 }</c:if>
			              	<c:if test="${item.frequency==1 }">${item.lowMonthNumber*13000 }</c:if></td>
		              </c:if>
		            </tr>
		            <tr>
		              <th>請領補助</th>
		              <th>請領期間</th>
		              <th>時數</th>
		              <th>請領金額</th>
		            </tr>
		            <tr>
		              <c:if test="${item.salaryMethod=='M'}">
			              <td>按時計</td>
			              <td></td>
			              <td></td>
			              <td></td>
		              </c:if>
		              <c:if test="${item.salaryMethod=='H'}">
			              <td>按時計</td>
			              <td>
			              	${item.employmentHourStartTime }~${item.employmentHourEndTime }
			              </td>
			              <td>
			              	<c:if test="${item.frequency>1 }">${item.highHoursNumber}</c:if>
		              		<c:if test="${item.frequency==1 }">${item.lowHoursNumber}</c:if>
		              	  </td>
			              <td>
			              	<c:if test="${item.frequency>1 }">${item.highHoursNumber*80 }</c:if>
		              		<c:if test="${item.frequency==1 }">${item.lowHoursNumber*70 }</c:if>
			              </td>
		             </c:if>
		             <c:if test="${item.salaryMethod=='MH'}">
		              <td>按時計</td>
		              <td>
		              	${item.employmentHourStartTime }~${item.employmentHourEndTime }
		              </td>
		              <td>
		              	<c:if test="${item.frequency>1 }">${item.highHoursNumber}</c:if>
	              		<c:if test="${item.frequency==1 }">${item.lowHoursNumber}</c:if>
	              	  </td>
		              <td>
		              	<c:if test="${item.frequency>1 }">${item.highHoursNumber*80 }</c:if>
	              		<c:if test="${item.frequency==1 }">${item.lowHoursNumber*70 }</c:if>
		              </td>
		             </c:if>
		            </tr>
		            <tr>
		              <td colspan="4" style="text-align:left;">計薪備註：${item.salaryMethodRemark.replace(';','、') }</td>
		            </tr>
		          </table>
	          </c:forEach>
          </c:when></c:choose>
      </div>
      
      
      <div class="form">
        <div class="title_main"><span>檢附文件</span></div>
        <c:choose><c:when test="${not empty advancedAgeEmploymentListReceipts}">
        <div class="full">原核定函影本：<br>
        	<c:choose><c:when test="${not empty approvedAttachment}">
		      	<c:forEach items="${approvedAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='approved' && (baseAllowanceFrequencyTime)==item.fileFrequency}">
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
        <div class="full">領據：<br>
        	<c:choose><c:when test="${not empty receiptAttachment}">
		      	<c:forEach items="${receiptAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='receipt' && (baseAllowanceFrequencyTime)==item.fileFrequency}">
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
        <div class="full">僱用證明：<br>
        	<c:choose><c:when test="${not empty employmentAttachment}">
		      	<c:forEach items="${employmentAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='employment' && (baseAllowanceFrequencyTime)==item.fileFrequency}">
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
        <div class="full">薪資證明：<br>
        	<c:choose><c:when test="${not empty salaryAttachment}">
		      	<c:forEach items="${salaryAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='salary' && (baseAllowanceFrequencyTime)==item.fileFrequency}">
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
        <div class="full">出勤證明文件：<br>
        	<c:choose><c:when test="${not empty attendanceAttachment}">
		      	<c:forEach items="${attendanceAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='attendance' && (baseAllowanceFrequencyTime)==item.fileFrequency}">
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
        <div class="full">其他文件：<br>
        	<c:choose><c:when test="${not empty necessaryAttachment}">
		      	<c:forEach items="${necessaryAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='necessary' && (baseAllowanceFrequencyTime)==item.fileFrequency}">
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
	    </c:when></c:choose>
      </div>
      <!--endprint-->
      </div>
      <div class="page">
        <button type="button" onclick="doPrint()">請領資料PDF</button>
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
<script src="js/schedule_employ_payment/schedule_employ_payment.js"></script>
</body>
</html>