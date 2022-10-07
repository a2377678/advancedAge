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

<!--     ---------- nav ---------- -->
<!--     <nav class="navbar navbar-expand-lg bg-gray navbar-dark fixed-top p-0"> -->
        
<!--           <div class="navigation w-100"> -->
<!--             <a class="navbar-brand" href="#"><img src="images/top_logo.png"></a> -->
<!--             <a class="sitemap text-light float-end p-3" href="sitemap" title="網站導覽">網站導覽</a> -->
          
<!--             <button class="navbar-toggler" type="button" data-toggle="collapse"  -->
<!--               data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"  -->
<!--               aria-expanded="false" aria-label="Toggle navigation"> -->
<!--               <span class="navbar-toggler-icon"></span> -->
<!--             </button> -->

<!--             <div class="collapse navbar-collapse main_menu" id="navbarSupportedContent"> -->
              
<!--               <ul class="navbar-nav mr-auto"> -->
              
<!--                 <li class="nav-item"> -->
<!--                   <a href="index" title="首頁" class="m1">首頁</a> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="#" title="補助計畫" class="navbar-dark nav-link dropdown-toggle m2" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">補助計畫</a> -->
<!--                   <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink"> -->
<!--                     <li><a class="dropdown-item text-light" href="require" title="繼續僱用高齡者補助計畫說明">繼續僱用高齡者補助計畫說明</a></li> -->
<!--                   </ul> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="employ" title="線上申辦" class="navbar-dark nav-link dropdown-toggle m3-in in" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">線上申辦</a> -->
<!--                   <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink"> -->
<!--                     <li><a class="dropdown-item text-light" href="employ" title="繼續雇用高齡者補助 - 申請作業">繼續僱用高齡者補助 - 申請作業</a></li> -->
<!--                     <li><a class="dropdown-item text-light" href="employ_payment" title="繼續雇用高齡者補助 - 請領作業">繼續僱用高齡者補助 - 請領作業</a></li> -->
<!--                     -
<!--                     <li><hr class="dropdown-divider"></li> -->
<!--                     <li><a class="dropdown-item text-white-50" href="#">退休者傳承專業技術 - 尚未開放</a></li> -->
<!--                     <li><hr class="dropdown-divider"></li> -->
<!--                     <li><a class="dropdown-item text-white-50" href="#">退休後再就業準備 - 尚未開放</a></li> -->
<!--                     ---> -->
<!--                   </ul> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item text-dark"> -->
<!--                   <a href="schedule" title="案件查詢" class="navbar-dark nav-link dropdown-toggle m4" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">案件查詢</a> -->
<!--                   <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink"> -->
<!--                     <li><a class="dropdown-item text-light" href="schedule" title="繼續僱用高齡者補助 - 申請進度">繼續僱用高齡者補助 - 申請進度</a></li> -->
<!--                     <li><a class="dropdown-item text-light" href="schedule_pass" title="繼續僱用高齡者補助 - 請領進度">繼續僱用高齡者補助 - 請領進度</a></li> -->
<!--                   </ul> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="teaching" title="申請教學" class="m5">申請教學</a> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="download" title="資料下載" class="m6">資料下載</a> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="service" title="諮詢服務" class="m7">諮詢服務</a> -->
<!--                 </li>  -->
                
<!--               </ul> -->
            
<!--             </div> -->
          
<!--           </div> -->
          
<!--     </nav> -->
<!--     ---------- nav end ----------  -->
    
<!--   </header> -->
  <!--- header end ---> 
  
  
  <!--- main --->
  <div class="main"> 
    
    <!------------ 申請流程 ------------>
    <div class="apply_main">
      <h1>繼續僱用高齡者補助 - 請領作業</h1>
      <h2>申請流程 Step4. 核對資料</h2>
      
      <!---申辦前準備--->
      <h3>請核對您填寫的資料，確認並「送出請領」<br>
        送出後資料不能修改，可在案件查詢再次下載及列印</h3>
	<!--startprint-->
      <div class="form">
        <div class="title_main"><span>繼續僱用補助請領清冊</span></div>
        
        <!---上傳名單
        <div class="full">繼續僱用補助名單清冊_統編66668888_1101123.xlsx　110/11/23  16:45　21KB</div>--->
        <input type="hidden" id="sid"name="sid" value="${sid}">
        <input type="hidden" id="baseId" name="baseId" value="${baseId}">
        <!---填寫名單--->
        <c:choose><c:when test="${not empty advancedAgeEmploymentListReceipts}">
	        <c:forEach items="${advancedAgeEmploymentListReceipts}" var="item" varStatus="status">
	        <c:if test="${item.baseAllowanceFrequency==0 }">
	            <table class="table_05">
		            <tr>
		              <td rowspan="5">${status.count }</td>
		              <th>勞工姓名</th>
		              <th>身分證字號</th>
		              <th>平均薪資</th>
		              <th colspan="2">計薪方式</th>
		              <th>退保(離職)</th>
		              <th>退保日期</th>
		              <th>請領次數</th>
		            </tr>
		            <tr>
		              <td>${item.name }</td>
		              <td>${item.identification }</td>
		              <td>${item.salary }</td>
		              <td colspan="2">
		              	<c:if test="${item.salaryMethod=='M' }">按月計</c:if>
		              	<c:if test="${item.salaryMethod=='H' }">非按月</c:if>
		              	<c:if test="${item.salaryMethod=='MH' }">部分按月，部分按時</c:if>
		              </td>
		              <td>
		              	<c:if test="${item.laborProtectionExpiredTime.length()==7}">勞工保險</c:if>
		              	<c:if test="${item.occupationalAccidentProtectionExpiredTime.length()==7}">職災保險</c:if>
		              </td>
		              <td>
		              	<c:if test="${item.laborProtectionExpiredTime.length()==7}">${item.laborProtectionExpiredTime}</c:if>
		              	<c:if test="${item.occupationalAccidentProtectionExpiredTime.length()==7}">${item.occupationalAccidentProtectionExpiredTime}</c:if>
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
		              <th>月/時數</th>
		              <th>請領金額</th>
		              <th>請領補助</th>
		              <th width="19%">請領期間</th>
		              <th>月/時數</th>
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
		              <td>&nbsp;</td>
		              <td>&nbsp;</td>
		              <td>&nbsp;</td>
		              <td>&nbsp;</td>
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
		              <td>&nbsp;</td>
		              <td>&nbsp;</td>
		              <td>&nbsp;</td>
		              <td>&nbsp;</td>
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
		              <td colspan="8" style="text-align:left;">計薪備註：${item.salaryMethodRemark.replace(';','、') }</td>
		            </tr>
		          </table>
			</c:if>
       	</c:forEach></c:when></c:choose>
      </div>


      <div class="form">
        <div class="title_main"><span>檢附文件</span></div>
        <div class="full">原核定函影本：<br>
        	<c:choose><c:when test="${not empty approvedAttachment}">
		      	<c:forEach items="${approvedAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='approved' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
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
				      	<c:when test="${item.fileType=='receipt' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
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
				      	<c:when test="${item.fileType=='employment' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
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
				      	<c:when test="${item.fileType=='salary' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
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
				      	<c:when test="${item.fileType=='attendance' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
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
				      	<c:when test="${item.fileType=='necessary' && (baseAllowanceFrequencyTime+1)==item.fileFrequency}">
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
        <button onclick="javascript:location.href='employ_payment_02?sid=${sid}'">返回修改</button>
        <button onclick="doPrint()">列印資料</button>
        <button onclick="finish()">送出請領資料</button>
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
<script src="js/employ_payment_04/employ_payment_04.js"></script>
</body>
</html>