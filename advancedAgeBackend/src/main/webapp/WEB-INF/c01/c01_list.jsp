<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="utf-8">
<title>繼續僱用高齡者補助計畫 - 請領補助清冊</title>
<link href="css/print.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/jspdf.min.js"></script>
<script type="text/javascript" src="js/html2canvas.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/c01/c01_list.js"></script>
</head>

<body>
  
  <!--startprint-->
  <!--------- 報表頁面 --------->
  <div class="report_page break_before" id="export_content">
  
    <!--------- 標題 --------->
    <div class="report_title">
    
      <div class="t-mane">請領補助清冊</div>
      
      <div class="t-date">中華民國
        <span class="year">${year}</span>年
        <span class="month">${month}</span>月
      </div>
      
      <div class="print_info">
        <div class="p-date"><span>列印日期：</span>${time }</div>
        <div class="p-page"><span>審核單位：</span>${unitName}</div>
        <div class="p-user"><span>審核人員：</span>${name}</div>
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
            <th style="width: 8%;">統編 / 扣繳</th>
            <th style="width: 10%;">請領日期</th>
            <th>屆齡65歲</th>
            <th>核定人數</th>
            <th>30%門檻</th>
            <th>本次請領</th>
            <th>請領比例</th>
            <th>本次金額</th>
          </tr>
        </thead>
        <input type="text" id="baseId" value="${base[0].id }" style="display:none">
        
        <c:choose>
        	<c:when test="${not empty employmenyListReceipt}">
        	<c:set var="employmenyListReceiptAmounts" value="0"/>
	      	<c:forEach items="${employmenyListReceipt}" var="item" varStatus="status">
		      <c:if test="${empty item.adjustAmounts && item.approveStatus!='3'}">
		      	  <c:set var="employmenyListReceiptAmounts" value="${employmenyListReceiptAmounts+item.amounts}"/>
	      	  </c:if>
	      	  <c:if test="${not empty item.adjustAmounts && item.approveStatus!='3'}">
	      	      <c:set var="employmenyListReceiptAmounts" value="${employmenyListReceiptAmounts+item.adjustAmounts}"/>
	      	  </c:if>
	      	</c:forEach>
	        </c:when>
        </c:choose>
        <tbody>
          <tr>
            <td>${base[0].get('aaid') }</td>
            <td>${base[0].get('companyName') }</td>
            <td id="seq">${base[0].get('seq') }</td>
            <td>${base[0].get('allowanceFrequencyRecord').split(';')[employmenyListReceipt[0].baseAllowanceFrequency-1].split('、')[1].substring(0,4)-1911}${base[0].get('allowanceFrequencyRecord').split(';')[employmenyListReceipt[0].baseAllowanceFrequency-1].split('、')[1].substring(4,10).replaceAll('-','/')}</td>
            <td id="nearHighEmploymentNumber">${plan.nearHighEmploymentNumber } 人</td>
            <td id="employmenyListReceiptNumber">${employmenyListReceipt.size()} 人</td>
            <td id="checkEmploymentPerson"></td>
            <td>${employmenyListReceipt.size()} 人</td>
            <td id="checkEmploymentPercentage"></td>
            <td><fmt:formatNumber type = "number" value = "${employmenyListReceiptAmounts}" /> 元</td>
          </tr>
        </tbody>
      </table>
      
      
      <br><br>
      
      
      <table class="m">
        <thead>
          <tr>
            <th rowspan="2" style="width: 5%;">編號</th>
            <th rowspan="2" style="width: 8%;">勞工姓名</th>
            <th rowspan="2" style="width: 9%;">出生日期</th>
            <th rowspan="2" style="width: 9%;">身分證字號</th>
            <th rowspan="2" style="width: 7%;">退保日期</th>
            <th rowspan="2" style="width: 5%;">類型</th>
            <th colspan="2" style="width: 8%;">續僱期間<br></th>
            <th rowspan="2" style="width: 4%;">申請<br>
              次數</th>
            <th colspan="3" style="width: 8%;">申請補助 ( 按月計 )</th>
            <th colspan="3" style="width: 8%;">申請補助 ( 按時計 )</th>
            <th rowspan="2">本次<br>
            合計<br>
            請領</th>
            <th rowspan="2" style="width: 10%;">審核結果</th>
          </tr>
          <tr>
            <th style="width: 8%;">平均經常性薪資</th>
            <th style="width: 8%;">方式</th>
            <th colspan="2" style="width: 8%;">本次請領期間</th>
            <th>月數</th>
            <th colspan="2" style="width: 8%;">本次請領期間</th>
            <th>時數</th>
          </tr>
        </thead>
        <tbody id="listStaff">
        <c:choose>
        	<c:when test="${not empty employmenyListReceipt}">
	      	<c:forEach items="${employmenyListReceipt}" var="item" varStatus="status">
	      	  <tr>
	            <td rowspan="2">${status.count }</td>
	            <td>${item.name }</td>
	            <td>${item.birthday.substring(0,3)}/${item.birthday.substring(3,5)}/${item.birthday.substring(5,7)}</td>
	            <td name="identification" id="identification${status.count }">${item.identification }</td>
	            <td><c:if test="${item.laborProtectionExpiredTime.length()==7}">${item.laborProtectionExpiredTime.substring(0,3)}/${item.laborProtectionExpiredTime.substring(3,5)}/${item.laborProtectionExpiredTime.substring(5)}</c:if>
	            <c:if test="${item.occupationalAccidentProtectionExpiredTime.length()==7}">${item.occupationalAccidentProtectionExpiredTime.substring(0,3)}/${item.occupationalAccidentProtectionExpiredTime.substring(3,5)}/${item.occupationalAccidentProtectionExpiredTime.substring(5,7)}</c:if>
	            </td>
	            <td><c:if test="${item.laborProtectionExpiredTime.length()==7}">勞保</c:if>
	            <c:if test="${item.occupationalAccidentProtectionExpiredTime.length()==7}">職災</c:if>
	            </td>
	            <td><fmt:formatNumber type = "number" value = "${item.salary}" /></td>
	            <td><c:if test="${item.salaryMethod=='M' }">按月</c:if>
	            	<c:if test="${item.salaryMethod=='H' }">按時</c:if>
	            	<c:if test="${item.salaryMethod=='MH' }">混合</c:if>
	            </td>
	            <td name="frequency" id="frequency${status.count }">${item.frequency }</td>
	            <c:if test="${item.salaryMethod=='M' }">
		            <td>${item.employmentMonthStartTime.substring(0,3)}/${item.employmentMonthStartTime.substring(3,5)}/${item.employmentMonthStartTime.substring(5)}</td>
		            <td>${item.employmentMonthEndTime.substring(0,3)}/${item.employmentMonthEndTime.substring(3,5)}/${item.employmentMonthEndTime.substring(5)}</td>
		            <td><c:if test="${item.frequency>1 }">${item.highMonthNumber }</c:if>
		            	<c:if test="${item.frequency==1 }">${item.lowMonthNumber }</c:if>
		            </td>
		            <td>&nbsp;</td>
		            <td>&nbsp;</td>
		            <td>&nbsp;</td>
		            <td><c:if test="${item.frequency>1 }"><fmt:formatNumber type = "number" value = "${item.highMonthNumber*15000 }" /></c:if>
		            	<c:if test="${item.frequency==1 }"><fmt:formatNumber type = "number" value = "${item.lowMonthNumber*13000 }" /></c:if>
		            </td>
	            </c:if>
	            <c:if test="${item.salaryMethod=='H' }">
	            	<td>&nbsp;</td>
		            <td>&nbsp;</td>
		            <td>&nbsp;</td>
		            <td>${item.employmentHourStartTime.substring(0,3)}/${item.employmentHourStartTime.substring(3,5)}/${item.employmentHourStartTime.substring(5)}</td>
		            <td>${item.employmentHourEndTime.substring(0,3)}/${item.employmentHourEndTime.substring(3,5)}/${item.employmentHourEndTime.substring(5)}</td>
		            <td><c:if test="${item.frequency>1 }">${item.highHoursNumber }</c:if>
		            	<c:if test="${item.frequency==1 }">${item.lowHoursNumber }</c:if>
		            </td>
		            <td><c:if test="${item.frequency>1 }"><fmt:formatNumber type = "number" value = "${item.highHoursNumber*80 }" /></c:if>
		            	<c:if test="${item.frequency==1 }"><fmt:formatNumber type = "number" value = "${item.lowHoursNumber*70 }" /></c:if>
		            </td>
	            </c:if>
	            <c:if test="${item.salaryMethod=='MH' }">
	            	<td>${item.employmentMonthStartTime.substring(0,3)}/${item.employmentMonthStartTime.substring(3,5)}/${item.employmentMonthStartTime.substring(5)}</td>
		            <td>${item.employmentMonthEndTime.substring(0,3)}/${item.employmentMonthEndTime.substring(3,5)}/${item.employmentMonthEndTime.substring(5)}</td>
		            <td><c:if test="${item.frequency>1 }">${item.highMonthNumber }</c:if>
		            	<c:if test="${item.frequency==1 }">${item.lowMonthNumber }</c:if>
		            </td>
		            <td>${item.employmentHourStartTime.substring(0,3)}/${item.employmentHourStartTime.substring(3,5)}/${item.employmentHourStartTime.substring(5)}</td>
		            <td>${item.employmentHourEndTime.substring(0,3)}/${item.employmentHourEndTime.substring(3,5)}/${item.employmentHourEndTime.substring(5)}</td>
		            <td><c:if test="${item.frequency>1 }">${item.highHoursNumber }</c:if>
		            	<c:if test="${item.frequency==1 }">${item.lowHoursNumber }</c:if>
		            </td>
		            <td><c:if test="${item.frequency>1 }"><fmt:formatNumber type = "number" value = "${item.highMonthNumber*15000+item.highHoursNumber*80 }" /></c:if>
		            	<c:if test="${item.frequency==1 }"><fmt:formatNumber type = "number" value = "${item.lowMonthNumber*13000+item.lowHoursNumber*70 }" /></c:if>
		            </td>
	            </c:if>
	            <td>
	            <select name="approveStatus" id="approveStatus${status.count}">
	              <option selected value>---</option>
	              <option value="1" <c:if test="${item.approveStatus==1 }">selected</c:if>>符合</option>
	              <option value="2" <c:if test="${item.approveStatus==2 }">selected</c:if>>部分符合</option>
	              <option value="3" <c:if test="${item.approveStatus==3 }">selected</c:if>>不符合</option>
	            </select></td>
	            
	          </tr> 
	          <tr>
	            <th>計薪備註：</th>
	            <td colspan="12" style=" text-align:left;"><c:if test="${item.salaryMethod!='M'}">${item.salaryMethodRemark}</c:if></td>
	            <th colspan="2">核撥金額：</th>
	            <td><input type="text" size="5" id="adjustAmounts${status.count}" name="adjustAmounts" value="${item.adjustAmounts }"></td>
	          </tr>
	      	</c:forEach>
	        </c:when>
        </c:choose>
        </tbody>
      </table>
       
      <!--endprint-->
      <br><br><br>
      
           
      
    </div>
    
    <!--------- 報表內容end --------->
	



  </div>
  <div class="p_btn_box-3">
      <button type="button" class="p_btn_03" onclick="doPrint()">列印清冊</button>
      <button type="button" class="p_btn_03" id="gpdf" onclick="pdf()">另存PDF</button>
      <button type="button" class="p_btn_02" onclick="window.close();">取消修改</button>
      <button type="button" class="p_btn_04" onclick="save()">儲存修改</button>
      <button type="button" class="p_btn_01" onclick="openData()">補件通知</button>
  </div>
  
  <form action="c01_file_content" method="post" id="dataForm" target="_blank">
      	<input type="text" name="seq" value="${base[0].seq }" style="display:none">
      	<input type="text" name="year" value="${base[0].year }" style="display:none">
  </form>
  
  
</body>
</html>
