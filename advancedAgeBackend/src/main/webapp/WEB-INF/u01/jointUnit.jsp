<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="utf-8">
<title>繼續僱用高齡者補助計畫 - 補助名單清冊</title>

<link href="css/print.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jspdf.min.js"></script>
<script type="text/javascript" src="js/html2canvas.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="font/msjh-normal.js"></script>
<script src="js/u01/jointUnit.js"></script>
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
    
      <div class="t-mane">聯合辦理單位清冊</div>
      
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
            <th style="width: 15%;">聯合辦理單位總數</th>
            <th style="width: 13%;">預計總參訓人數</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>${base.get("aaid") }</td>
            <td>${base.get("companyName")}</td>
            <td>${base.get("createTime").substring(0,4)-1911}${base.get("createTime").substring(4,10).replace("-","/")}</td>
            <td>${base.get("seq")}</td>
            <td>${ basicDataListSize }</td>
            <td>${ benefitListSize }</td>
          </tr>
        </tbody>
      </table>
      <br><br>
      <c:choose>
          	<c:when test="${not empty basicData}">
          		<c:forEach items="${basicData}" var="item" varStatus="status">
			      <table class="m" style="margin-bottom:10px;">
			        <thead>
			          <tr>
			            <th style="width: 4%;">編號</th>
			            <th style="width: 18%;">單位名稱</th>
			            <th style="width: 9%;">統一編號</th>
			            <th style="width: 23%;">主要營業項目</th>
			            <th style="width: 11%;">單位規模</th>
			            <th style="width: 18%;">行業別</th>
			            <th colspan="2" style="width: 17%;">投保證號</th>
			          </tr>
			        </thead>
			        <tbody>
			          <tr>
			            <td rowspan="3">${status.count}</td>
			            <td style="text-align:left">${item.companyName}</td>
			            <td nowrap>${item.seq}</td>
			            <td>${item.businessItem}</td>
			            <td>${item.unitSize}</td>
			            <td>專業、科學及技術服務業</td>
			            <td colspan="2">${item.guaranteeNumber}</td>
			          </tr>
			          <tr>
			            <th>負責人</th>
			            <th>聯絡人</th>
			            <th>聯絡電話</th>
			            <th>聯絡手機</th>
			            <th>電子信箱</th>
			            <th><span style="width: 6%;">員工人數</span></th>
			            <th><span style="width: 6%;">參與人數</span></th>
			          </tr>
			          <tr>
			            <td>${item.principal}</td>
			            <td>${item.contactName}</td>
			            <td>(${item.contactWorkPhoneAreaCode})${item.contactWorkPhone}#${item.contactWorkPhoneExtension}</td>
			            <td>${item.contactPhone}</td>
			            <td>${item.email}</td>
			            <td>${item.employeeNumber}</td>
			            <td>${item.participateNumber}</td>
			          </tr>
			        </tbody>
			      </table>
          		</c:forEach>
          	</c:when>
          	<c:otherwise>
		      <table class="m" style="margin-bottom:10px;">
		        <thead>
		          <tr>
		            <th style="width: 4%;">編號</th>
		            <th style="width: 18%;">單位名稱</th>
		            <th style="width: 9%;">統一編號</th>
		            <th style="width: 23%;">主要營業項目</th>
		            <th style="width: 11%;">單位規模</th>
		            <th style="width: 18%;">行業別</th>
		            <th colspan="2" style="width: 17%;">投保證號</th>
		          </tr>
		        </thead>
		        <tbody>
		          <tr>
		            <td rowspan="3"></td>
		            <td style="text-align:left"></td>
		            <td nowrap></td>
		            <td></td>
		            <td></td>
		            <td></td>
		            <td colspan="2"></td>
		          </tr>
		          <tr>
		            <th>負責人</th>
		            <th>聯絡人</th>
		            <th>聯絡電話</th>
		            <th>聯絡手機</th>
		            <th>電子信箱</th>
		            <th><span style="width: 6%;">員工人數</span></th>
		            <th><span style="width: 6%;">參與人數</span></th>
		          </tr>
		          <tr>
		            <td></td>
		            <td></td>
		            <td></td>
		            <td></td>
		            <td></td>
		            <td></td>
		            <td></td>
		          </tr>
		        </tbody>
		      </table>
          	</c:otherwise>
      </c:choose>
      <!--endprint-->

      
    </div>
    <!--------- 報表內容end --------->




  </div>
      <div class="p_btn_box-3">
      	<button type="button" class="p_btn_03" onclick="doPrint()">列印清冊</button>
		<button type="button" class="p_btn_03" id="gpdf" onclick="pdf()">另存PDF</button>
      <!---<button type="button" class="p_btn_02">取消修改</button>--->
      </div>
  
  
  
  
</body>
</html>
