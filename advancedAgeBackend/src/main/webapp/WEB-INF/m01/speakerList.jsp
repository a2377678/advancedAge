<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="utf-8">
<title>講師名單清冊</title>

<link href="css/print.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jspdf.min.js"></script>
<script type="text/javascript" src="js/html2canvas.min.js"></script>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="font/msjh-normal.js"></script>
<script src="js/m01/speakerList.js"></script>
</head>
<style type="text/css">
	@page {
     size: A4 landscape; /*直式portrait 橫式landscape*/
     margin: 1cm;  /*print邊界*/
	}
</style>

<body>
  
  
  <!--------- 報表頁面 --------->
  <div class="report_page break_before" id="export_content">
  
    <!--------- 標題 --------->
    <!--startprint-->
    <div class="report_title">
    
      <div class="t-mane">講師名單清冊</div>
      
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
            <th style="width: 13%;">申請講師人數</th>
            <th style="width: 15%;">&nbsp;</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>${base.get("aaid") }</td>
            <td>${base.get("companyName")}</td>
            <td>${base.get("createTime").substring(0,4)-1911}${base.get("createTime").substring(4,10).replace("-","/")}</td>
            <td>${base.get("seq")}</td>
            <td>${speakerListSize }</td>
            <td>&nbsp;</td>
          </tr>
        </tbody>
      </table>
      <br><br>
      <table class="m">
        <thead>
          <tr>
            <th style="width: 5%;">編號</th>
            <th style="width: 7%;">講師姓名</th>
            <th style="width: 8%;">出生日期</th>
            <th style="width: 10%;">身分證字號</th>
            <th style="width: 7%;">保險類型</th>
            <th style="width: 8%;">加保日期</th>
            <th style="width: 7%;">職務類型</th>
            <th style="width: 8%;">親等關係</th>
            <th style="width: 7%;">工時類型</th>
            <th style="width: 12%;">計畫執行方式</th>
          </tr>
        </thead>
        <tbody>
        	<c:choose><c:when test="${not empty speakerList}">
		      	<c:forEach items="${speakerList}" var="item" varStatus="status">
	      			<tr>
			            <td>${status.count}</td>
			            <td>${item.name }</td>
			            <td><c:if test="${item.birthday.length()==7}">${item.birthday.substring(0,3)}/${item.birthday.substring(3,5)}/${item.birthday.substring(5)}</c:if></td>
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
			            <td>
			            	<c:if test="${item.executionWay=='S' }">實務技術指導</c:if>
					        <c:if test="${item.executionWay=='C' }">教育訓練課程講授</c:if>
					        <c:if test="${item.executionWay=='O' }">其他－${plan.executionWayDescription}</c:if>
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
   </div>
  
  
</body>
</html>
