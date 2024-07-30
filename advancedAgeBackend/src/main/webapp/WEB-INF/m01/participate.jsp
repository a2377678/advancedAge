<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="utf-8">
<title>預計參訓學員清冊</title>

<link href="css/print.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jspdf.min.js"></script>
<script type="text/javascript" src="js/html2canvas.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="font/msjh-normal.js"></script>
<script src="js/m01/participate.js"></script>
<style type="text/css">
	@page {
     size: A4 landscape; /*直式portrait 橫式landscape*/
     margin: 1cm;  /*print邊界*/
	}
</style>
</head>

<body>
  
  
  <!--------- 報表頁面 --------->
  <div class="report_page break_before" id="export_content">
  
    <!--------- 標題 --------->
    <!--startprint-->
    <div class="report_title">
    
      <div class="t-mane">預計參訓學員清冊</div>
      
      <div class="t-date">中華民國
        <span class="year">${year}</span>年
        <span class="month">${month}</span>月
      </div>
      
      <div class="print_info">
        <div class="p-date"><span>列印日期：</span>${time}</div>
        <div class="p-user"><span>製表人員：</span>${unitName }&nbsp;${name }</div>
      </div>
      
      <div class="item">補助項目：
        <div>僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫</div>
      </div>
      
    </div>
    <!--------- 標題end --------->
    
    
    
    <!--------- 報表內容 --------->
    <div class="report_main">
    
      <table class="m">
        <thead>
          <tr>
            <th style="width: 16%;">案件編號</th>
            <th>單位名稱</th>
            <th style="width: 10%;">申請日期</th>
            <th style="width: 10%;">統編 / 扣繳</th>
            <th style="width: 12%;">預計參訓學員數</th>
            <th style="width: 15%;">預計總參訓人數(次)</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>${base.get("aaid") }</td>
            <td>${base.get("companyName")}</td>
            <td>${base.get("createTime").substring(0,4)-1911}${base.get("createTime").substring(4,10).replace("-","/")}</td>
            <td>${base.get("seq")}</td>
            <td>${participateSize }</td>
            <td>${participateNumber }</td>
          </tr>
        </tbody>
      </table>
      <br><br>
      <table class="m">
        <thead>
          <tr>
            <th style="width: 5%;">編號</th>
            <th style="width: 7%;">學員姓名</th>
            <th style="width: 7%;">保險類型</th>
            <th style="width: 8%;">加保日期</th>
            <th style="width: 4%;">年資(年)</th>
            <th style="width: 4%;">年資(月)</th>
            <th style="width: 7%;">職務類型</th>
            <th style="width: 8%;">部門</th>
            <th style="width: 7%;">工時類型</th>
          </tr>
        </thead>
        <tbody>
        <c:choose><c:when test="${not empty participate}">
	      	<c:forEach items="${participate}" var="item" varStatus="status">
      			<tr>
		            <td>${status.count}</td>
		            <td>${item.name}</td>
		            <td>
		            	<c:if test="${item.laborProtectionTime.length()==7}">勞工保險</c:if>
			            <c:if test="${item.occupationalAccidentProtectionTime.length()==7}">職災保險</c:if>
		            </td>
		            <td>
		            	<c:if test="${item.laborProtectionTime.length()==7}">${item.laborProtectionTime.substring(0,3)}/${item.laborProtectionTime.substring(3,5)}/${item.laborProtectionTime.substring(5)}</c:if>
			            <c:if test="${item.occupationalAccidentProtectionTime.length()==7}">${item.occupationalAccidentProtectionTime.substring(0,3)}/${item.occupationalAccidentProtectionTime.substring(3,5)}/${item.occupationalAccidentProtectionTime.substring(5)}</c:if>
		            </td>
		            <td>${item.seniority}</td>
		            <td>${item.seniorityMonth}</td>
		            <td>
		            	<c:if test="${item.manager=='Y'}">主管</c:if>
			            <c:if test="${item.manager=='N'}">非主管</c:if>
		            </td>
		            <td>${item.department }</td>
		            <td>
		            	<c:if test="${item.workingHours=='A'}">全時</c:if>
			            <c:if test="${item.workingHours=='P'}">部分工時</c:if>
		            </td>
          		</tr>
	      	</c:forEach>
   		</c:when></c:choose>
        </tbody>
      </table>

	<!--endprint-->
      
      
    </div>
    <!--------- 報表內容end --------->




  </div>
  
  <br><br><br>
  <div class="p_btn_box-3">
	  <button type="button" class="p_btn_03" onclick="doPrint()">列印清冊</button>
	  <button type="button" class="p_btn_03" id="gpdf" onclick="pdf()">另存PDF</button>
  <!---<button type="button" class="p_btn_02">取消修改</button>--->
  </div>
  
  
</body>
</html>
