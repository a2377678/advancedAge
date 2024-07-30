<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="utf-8">
<title>規劃課程清冊</title>

<link href="css/print.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jspdf.min.js"></script>
<script type="text/javascript" src="js/html2canvas.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="font/msjh-normal.js"></script>
<script src="js/m01/schedule.js"></script>
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
    
      <div class="t-mane">規劃課程清冊</div>
      
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
            <th style="width: 13%;">規劃課程數</th>
            <th style="width: 15%;">預計總授課時數</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>${base.get("aaid") }</td>
            <td>${base.get("companyName")}</td>
            <td>${base.get("createTime").substring(0,4)-1911}${base.get("createTime").substring(4,10).replace("-","/")}</td>
            <td>${base.get("seq")}</td>
            <td>${scheduleSize }</td>
            <td>${scheduleTime }</td>
          </tr>
        </tbody>
      </table>
      <br><br>
      <table class="m">
        <thead>
          <tr>
          	<th style="width: 5%;">編號</th>
            <th style="width: 8%;">預計執行<br>期間 (起)</th>
            <th style="width: 8%;">預計執行<br>期間 (迄)</th>
            <th style="width: 8%;"><span style="width: 8%;">計畫執行地</span></th>
            <th style="width: 12%;"><span style="width: 12%;">預計開課時間</span></th>
            <th>課程名稱</th>
            <th style="width: 6%;">講師<br>姓名</th>
            <th style="width: 6%;">預計授<br>課時數</th>
            <th style="width: 6%;">預計參<br>訓人數</th>
          </tr>
        </thead>
        <tbody>
        	<c:choose><c:when test="${not empty schedule}">
		      	<c:forEach items="${schedule}" var="item" varStatus="status">
	      			<tr>
			            <td rowspan="3">${status.count}</td>
			            <td>${item.executionStartTime.substring(0,3)}/${item.executionStartTime.substring(3,5)}/${item.executionStartTime.substring(5)}</td>
			            <td>${item.executionEndTime.substring(0,3)}/${item.executionEndTime.substring(3,5)}/${item.executionEndTime.substring(5)}</td>
			            <td>
			            	<c:forEach  items="${cityList}"  var="cityItem"  varStatus="userStatus">
				      			<c:if test="${item.executionCity==cityItem.code}">${cityItem.name}</c:if>
					      	</c:forEach>
			            </td>
			            <td>${item.executionTime}</td>
			            <td>${item.subject }</td>
			            <td>${item.speakerName }</td>
			            <td>${item.teachingHours }</td>
			            <td>${item.participateNumber }</td>
	          		</tr>
	          		<tr>
	            		<td colspan="8" style="text-align:left"><b>預計參訓學員：</b>${item.participatePeople }</td>
	          		</tr>
	      			<tr>
			            <td colspan="8" style="text-align:left"><b>課程大綱：</b>${item.introduction.replace("<", "&lt;").replace(">", "&gt;").replace("\\n","<br>")  }</td>
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
