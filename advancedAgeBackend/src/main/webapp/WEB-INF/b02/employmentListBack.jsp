<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="utf-8">
<title>繼續僱用高齡者補助計畫 - 補助名單清冊</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.4.1/jspdf.min.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.debug.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://html2canvas.hertzen.com/dist/html2canvas.js"></script>
<link href="css/print.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script type="text/javascript" src="font/msjh-normal.js"></script>

</head>
<style type="text/css">
	@page {
     size: A4 portrait; /*直式portrait 橫式landscape*/
     margin: 1cm;  /*print邊界*/
	}
</style>
<body>
  
  <!--------- 報表頁面 --------->
  <div class="report_page break_before" id="export_content">
  
    <!--------- 標題 --------->
    <!--startprint-->
    <div class="report_title">
    
      <div class="t-mane">補助名單清冊</div>
      
      <div class="t-date">中華民國
        <span class="year">${base.get("createTime").substring(0,4)-1911}</span>年
        <span class="month">${base.get("createTime").substring(5,7)}</span>月
      </div>
      
      <div class="print_info">
        <div class="p-date"><span>列印日期：</span>${time}</div>
        <div class="p-user"><span>製表人員：</span>${unitName }&nbsp;${name }</div>
      </div>
      
      <div class="item">補助項目：繼續僱用高齡者補助計畫</div>
      
    </div>
    <!--------- 標題end --------->
    
    
    <!--------- 報表內容 --------->
    <div class="report_main">
    
      <table class="m">
        <thead>
          <tr>
            <th style="width: 13%;">案件編號</th>
            <th style="width: 18%;">單位名稱</th>
            <th style="width: 8%;">申請日期</th>
            <th style="width: 8%;">統編 / 扣繳</th>
            <th style="width: 13%;">屆齡65歲人數 (A)</th>
            <th style="width: 13%;">規劃續僱人數 (B)</th>
            <th style="width: 13%;">規劃續僱比例 (C)</th>
            <th>申請計畫人數 (D) </th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>${base.get("aaid") }</td>
            <td>${base.get("companyName")}</td>
            <td>${base.get("createTime").substring(0,4)-1911}${base.get("createTime").substring(4,10).replace("-","/")}</td>
            <td>${base.get("seq")}</td>
            <td>${plan.nearHighEmploymentNumber }</td>
            <td>${plan.continueEmploymentNumber }</td>
            <td>${plan.continueEmploymentPercentage }%</td>
            <td>${employmenyListSize}</td>
          </tr>
        </tbody>
      </table>
      <br><br>
      <table class="m">
        <thead>
          <tr>
            <th style="width: 5%;">編號</th>
            <th style="width: 8%;">勞工姓名</th>
            <th style="width: 10%;">身分證字號</th>
            <th style="width: 8%;">保險類型</th>
            <th style="width: 8%;">加保日期</th>
            <th style="width: 8%;">職務類型</th>
            <th style="width: 8%;">親等關係</th>
            <th style="width: 8%;">工時類型</th>
            <th style="width: 8%;">經常性薪資</th>
            <th style="width: 10%;">非經常性薪資</th>
            <th>&nbsp;</th>
          </tr>
        </thead>
        <tbody>
        	<c:choose><c:when test="${not empty employmenyList}">
		      	<c:forEach items="${employmenyList}" var="item" varStatus="status">
	      			<tr>
			            <td>${status.count}</td>
			            <td>${item.name }</td>
			            <td>${item.identification }</td>
			            <td><c:if test="${item.laborProtectionTime.length()==7}">勞工保險</c:if>
			            <c:if test="${item.occupationalAccidentProtectionTime.length()==7}">職災保險</c:if></td>
			            <td><c:if test="${item.laborProtectionTime.length()==7}">${item.laborProtectionTime.substring(0,3)}/${item.laborProtectionTime.substring(3,5)}/${item.laborProtectionTime.substring(5)}</c:if>
			            <c:if test="${item.occupationalAccidentProtectionTime.length()==7}">${item.occupationalAccidentProtectionTime.substring(0,3)}/${item.occupationalAccidentProtectionTime.substring(3,5)}/${item.occupationalAccidentProtectionTime.substring(5)}</c:if></td>
			            <td><c:if test="${item.manager=='Y'}">主管</c:if>
			            <c:if test="${item.manager=='N'}">非主管</c:if></td>
			            <td><c:if test="${item.relatives=='Y'}">三等親內</c:if>
			            <c:if test="${item.relatives=='N'}">非三等親</c:if></td>
			            <td><c:if test="${item.workingHours=='A'}">全時</c:if>
			            <c:if test="${item.workingHours=='P'}">部分工時</c:if></td>
			            <td>${item.recurringSalary}</td>
			            <td>${item.notRecurringSalary}</td>
			            <td>&nbsp;</td>
		          	</tr>
		      	</c:forEach>
		   	</c:when></c:choose>
        </tbody>
      </table>
      
    </div>
    <!--endprint-->
    <!--------- 報表內容end --------->


	<div class="page">
      <button type="button" onclick="doPrint()">列印資料</button>
      <button id="gpdf">Generate PDF</button>
    </div>
	<canvas id="canvas" width="1800" height="842" style="border: 1px solid black;display:none;"></canvas>

  </div>
  
  
  <script src="js/b02/employmentList.js"></script>
  
</body>
</html>
