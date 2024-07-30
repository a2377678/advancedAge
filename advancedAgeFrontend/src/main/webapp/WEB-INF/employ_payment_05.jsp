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
<script src="js/employ_payment_05/employ_payment_05.js"></script>
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
        <li class="breadcrumb-item active" aria-current="page">繼續僱用高齡者補助 - 請領作業</li>
      </ol>
    </nav>
    <h1>繼續僱用高齡者補助 - 請領作業</h1>
    <h2>申請流程 Step5. 送出請領申請</h2>
    <h3><span class="title">您申請的資料已送出</span></h3>
    
    <div>
    	<c:set var="createTime" value="${base.allowanceFileStatusRecord.split(';')[baseAllowanceFrequencyTime-1].split('、')[6]}"></c:set>
      	<div class="fs-5 fw-bolder">請領日期：${createTime.substring(0,4)-1911}/${createTime.substring(5,7)}/${createTime.substring(8,createTime.length())}</div>
      <h4>《 請領資料送出不代表審核通過 》</h4>
      <p>
      如有補件或修改送件資料需求，或您有任何疑問<br>
      請於周一至周五 上班時間洽詢 <a href="https://job.taiwanjobs.gov.tw/internet/index/service_location.aspx" target="_blank">受理單位</a>
      </p>
    </div>
    <div style="display:none">
    	<!--startprint-->
	      <div class="form">
	        <div class="title_main"><span>繼續僱用補助請領清冊</span></div>
	        
	        <input type="text" id="baseId" name="baseId" value="${baseId}" style="display:none">
	        <!---填寫名單--->
	        <c:choose><c:when test="${not empty advancedAgeEmploymentListReceipts}">
		        <c:forEach items="${advancedAgeEmploymentListReceipts}" var="item" varStatus="status">
<%-- 		        <c:if test="${item.baseAllowanceFrequency==0 }"> --%>
		            <table class="table_05">
			            <tr>
			              <td rowspan="9">${status.count }</td>
			              <th>勞工姓名</th>
			              <th>出生日期</th>
			              <th>身分證</th>
			              <th>平均薪資</th>
			            </tr>
			            <tr>
			              <td>${item.name }</td>
			              <td>${item.birthday }</td>
			              <td>${item.identification }</td>
			              <td>${item.salary }</td>
			            </tr>
			            <tr>
			              <th>退保</th>
			              <th>退保日期</th>
			              <th>計薪方式</th>
			              <th>請領次數</th>
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
			              <td>
			              	<c:if test="${item.salaryMethod=='M' }">按月計</c:if>
			              	<c:if test="${item.salaryMethod=='H' }">非按月</c:if>
			              	<c:if test="${item.salaryMethod=='MH' }">部分按月，部分按時</c:if>
			              </td>
			              <td>
			              	<c:if test="${item.frequency==1 }">第一期</c:if>
			              	<c:if test="${item.frequency==2 }">第二期</c:if>
			              	<c:if test="${item.frequency==3 }">第三期</c:if>
			              	<c:if test="${item.frequency==4 }">第四期</c:if>
			              	<c:if test="${item.frequency==5 }">第五期</c:if>
			              </td>
			            </tr>
			            <tr>
			              <th>請領補助</th>
			              <th width="19%">請領期間</th>
			              <th>月數</th>
			              <th>請領金額</th>
			            </tr>
			            <tr>
			              <td>按月計</td>
			              <c:if test="${item.salaryMethod=='M' || item.salaryMethod=='MH'}">
			              <td>${item.employmentMonthStartTime }~${item.employmentMonthEndTime }</td>
			              <td>
			              	<c:if test="${item.frequency>1 }">${item.highMonthNumber }</c:if>
			              	<c:if test="${item.frequency==1 }">${item.lowMonthNumber }</c:if>
			              </td>
			              <td><c:if test="${item.frequency>1 }">${item.highMonthNumber*15000 }</c:if>
			              	<c:if test="${item.frequency==1 }">${item.lowMonthNumber*13000 }</c:if></td>
			              </c:if>
			              <c:if test="${item.salaryMethod=='H'}">
			              <td></td>
			              <td></td>
			              <td></td>
			              </c:if>
			            </tr>
			            
			            <tr>
			              <th>請領補助</th>
			              <th width="19%">請領期間</th>
			              <th>月數</th>
			              <th>請領金額</th>
			            </tr>
			            <tr>
			              <td>按時計</td>
			              <c:if test="${item.salaryMethod=='H' || item.salaryMethod=='MH' }">
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
			              <c:if test="${item.salaryMethod=='M' }">
			              	<td></td>
				              <td></td>
				              <td></td>
			              </c:if>
			            </tr>
			            <tr>
			              <td colspan="8" style="text-align:left;">計薪備註：${item.salaryMethodRemark.replace(';','、') }</td>
			            </tr>
			          </table>
<%-- 				</c:if> --%>
	       	</c:forEach></c:when></c:choose>
	      </div>
	
	
	      <div class="form">
	        <div class="title_main"><span>檢附文件</span></div>
	        <div class="full lh-lg"><span class="title-c mb-5">原核定函影本：</span><br>
	        	<c:choose><c:when test="${not empty approvedAttachment}">
			      	<c:forEach items="${approvedAttachment}" var="item" varStatus="status">
				      	<c:choose>
					      	<c:when test="${item.fileType=='approved' && baseAllowanceFrequencyTime==item.fileFrequency}">
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
	        <div class="full lh-lg"><span class="title-c mb-5">領據：</span><br>
	        	<c:choose><c:when test="${not empty receiptAttachment}">
			      	<c:forEach items="${receiptAttachment}" var="item" varStatus="status">
				      	<c:choose>
					      	<c:when test="${item.fileType=='receipt' && baseAllowanceFrequencyTime==item.fileFrequency}">
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
	        <div class="full lh-lg"><span class="title-c mb-5">僱用證明：</span><br>
	        	<c:choose><c:when test="${not empty employmentAttachment}">
			      	<c:forEach items="${employmentAttachment}" var="item" varStatus="status">
				      	<c:choose>
					      	<c:when test="${item.fileType=='employment' && baseAllowanceFrequencyTime==item.fileFrequency}">
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
	        <div class="full lh-lg"><span class="title-c mb-5">薪資證明：</span><br>
	        	<c:choose><c:when test="${not empty salaryAttachment}">
			      	<c:forEach items="${salaryAttachment}" var="item" varStatus="status">
				      	<c:choose>
					      	<c:when test="${item.fileType=='salary' && baseAllowanceFrequencyTime==item.fileFrequency}">
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
	        <div class="full lh-lg"><span class="title-c mb-5">出勤證明文件：</span><br>
	        	<c:choose><c:when test="${not empty attendanceAttachment}">
			      	<c:forEach items="${attendanceAttachment}" var="item" varStatus="status">
				      	<c:choose>
					      	<c:when test="${item.fileType=='attendance' && baseAllowanceFrequencyTime==item.fileFrequency}">
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
	        <div class="full lh-lg"><span class="title-c mb-5">其他文件：</span><br>
	        	<c:choose><c:when test="${not empty necessaryAttachment}">
			      	<c:forEach items="${necessaryAttachment}" var="item" varStatus="status">
				      	<c:choose>
					      	<c:when test="${item.fileType=='necessary' && baseAllowanceFrequencyTime==item.fileFrequency}">
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
</body>
</html>