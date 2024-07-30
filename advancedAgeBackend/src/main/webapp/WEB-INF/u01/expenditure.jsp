<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="utf-8">
<title>經費概算清冊</title>

<link href="css/print.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jspdf.min.js"></script>
<script type="text/javascript" src="js/html2canvas.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="font/msjh-normal.js"></script>
<script src="js/u01/expenditure.js"></script>
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
    
      <div class="t-mane">經費概算清冊</div>
      
      <div class="t-date">中華民國
        <span class="year">${year}</span>年
        <span class="month">${month}</span>月
      </div>
      
      <div class="print_info">
        <div class="p-date"><span>列印日期：</span>${time}</div>
        <div class="p-user"><span>製表人員：</span>${unitName }&nbsp;${name }</div>
      </div>
      
      <div class="item">補助項目：
        <div>中高齡者退休後再就業準備協助措施補助計畫</div>
      </div>
      
    </div>
    <!--------- 標題end --------->
    
    
    
    <!--------- 報表內容 --------->
    <div class="report_main">
    
      <table class="m">
        <thead>
          <tr>
            <th style="width: 16%;">案件編號</th>
            <th style="">單位名稱</th>
            <th style="width: 10%;">申請日期</th>
            <th style="width: 10%;">統編 / 扣繳</th>
            <th style="width: 12%;">申請項目數</th>
            <th style="width: 15%;">經費概算(總價)</th>
            <th style="width: 15%;">申請補助金額</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>${base.get("aaid") }</td>
            <td>${base.get("companyName")}</td>
            <td>${base.get("createTime").substring(0,4)-1911}${base.get("createTime").substring(4,10).replace("-","/")}</td>
            <td>${base.get("seq")}</td>
            <td>${expenditureListSize }</td>
            <td>${expenditureListSum }</td>
            <td>${expenditureListAmountsSum }</td>
          </tr>
        </tbody>
      </table>
      <br><br>
      <table class="m">
        <thead>
          <tr>
            <th style="width: 5%;">編號</th>
            <th>項目</th>
            <th style="width: 8%;">單價</th>
            <th style="width: 7%;">數量</th>
            <th style="width: 10%;">總價</th>
            <th style="width: 12%;">申請本計畫補助</th>
            <th style="width: 13%;">申請其他單位補助</th>
            <th style="width: 24%;">說明</th>
          </tr>
        </thead>
        <tbody>
          	<c:choose>
          	<c:when test="${not empty expenditure}">
	      	<c:forEach items="${expenditure}" var="item" varStatus="status">
      			<tr>
		            <td>${status.count}</td>
		            <td style="text-align:left">${item.planName}</td>
		            <td>${item.unitPrice}</td>
		            <td>${item.amount}</td>
		            <td>${item.unitPrice*item.amount}</td>
		            <td>${item.amounts}</td>
		            <td>${item.otherAmounts}</td>
		            <td style="text-align:left">${item.description}</td>
          		</tr>
	      	</c:forEach>
   			</c:when>
   			</c:choose>
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
