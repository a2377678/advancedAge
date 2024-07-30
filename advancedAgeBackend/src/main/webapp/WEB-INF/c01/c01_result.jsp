<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="utf-8">
<title>繼續僱用高齡者補助計畫 - 請領補助清冊</title>

<link href="css/print.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/c01/c01_result.js"></script>
<style>
@page {
     margin: 0.3cm 0.5cm 0.1cm 0.5cm;  /*print邊界*/
}
</style>

</head>

<body>
  
  
  <!--------- 報表頁面 --------->
  <div class="report_page break_before">
  
    <!--------- 標題 --------->
    <div class="report_title">
    
      <div class="t-mane">請領補助清冊</div>
      
      <div class="t-date">中華民國
        <span class="year">${year}</span>年
        <span class="month">${month}</span>月
      </div>
      
      <div class="print_info">
        <div class="p-date"><span>列印日期：</span>${time }</div>
        <div class="p-user"><span>製表人員：</span>${unitName} ${name}</div>
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
        <c:choose>
        	<c:when test="${not empty employmenyListReceipt}">
        	<c:set var="employmenyListReceiptAmounts" value="0"/>
	      	<c:forEach items="${employmenyListReceipt}" var="item" varStatus="status">
<%-- 	      	  <c:if test="${empty item.adjustAmounts && item.approveStatus!=3}"> --%>
<%-- 		      	  <c:set var="employmenyListReceiptAmounts" value="${employmenyListReceiptAmounts+item.amounts}"/> --%>
<%-- 	      	  </c:if> --%>
	      	  <c:if test="${not empty item.adjustAmounts && item.approveStatus!=3}">
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
<%--             <td>${base[0].get('allowanceFrequencyRecord').split(';')[employmenyListReceipt[0].baseAllowanceFrequency].split('、')[1].substring(0,4)-1911}${base[0].get('allowanceFrequencyRecord').split(';')[employmenyListReceipt[0].baseAllowanceFrequency].split('、')[1].substring(4,10).replaceAll('-','/')}</td> --%>
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
      <table class="s">
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
            <th style="width: 8%;">平均薪資</th>
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
	            	<c:if test="${item.approveStatus==1 }">符合</c:if>
	            	<c:if test="${item.approveStatus==2 }">部分符合</c:if>
	            	<c:if test="${item.approveStatus==3 }">不符合</c:if>
	            </td>
	            
	          </tr> 
	          <tr>
	            <th>計薪備註：</th>
	            <td colspan="12" style=" text-align:left;"><c:if test="${item.salaryMethod!='M'}">${item.salaryMethodRemark}</c:if></td>
	            <th colspan="2">修正金額：</th>
	            <td><fmt:formatNumber type = "number" value = "${item.adjustAmounts }" /></td>
	          </tr>
	      	</c:forEach>
	        </c:when>
        </c:choose>
        </tbody>
      </table>
      <br><br>
      <c:set var="employmenyListReceiptSuccess" value="0"/>
      <c:set var="employmenyListReceiptFail" value="0"/>
      <c:set var="employmenyListReceiptAmounts" value="0"/>
      <c:choose>
        	<c:when test="${not empty employmenyListReceipt}">
	      	<c:forEach items="${employmenyListReceipt}" var="item" varStatus="status">
	      		<c:if test="${not empty item.approveStatus && item.approveStatus!=3}">
	      			<c:set var="employmenyListReceiptSuccess" value="${employmenyListReceiptSuccess+1 }"/>
	      		</c:if>
	      		<c:if test="${not empty item.approveStatus && item.approveStatus==3}">
	      			<c:set var="employmenyListReceiptFail" value="${employmenyListReceiptFail+1 }"/>
	      		</c:if>
	      		
<%-- 	      		<c:if test="${not empty item.approveStatus && item.approveStatus!=3}"> --%>
<%-- 	      			<c:set var="employmenyListReceiptAmounts" value="${employmenyListReceiptAmounts+item.amounts }"/> --%>
<%-- 	      		</c:if> --%>
	      		<c:if test="${not empty item.approveStatus && item.approveStatus!=3}">
	      			<c:set var="employmenyListReceiptAmounts" value="${employmenyListReceiptAmounts+item.adjustAmounts }"/>
	      		</c:if>
	      	</c:forEach>
	        </c:when>
        </c:choose>
      <table class="m">
        <thead>
          <tr>
            <th style="width: 5%;">本次請領審核結果</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th style="height: 60px;">經審核符合資格合計 ${employmenyListReceiptSuccess} 人，計核發繼續僱用補助 <fmt:formatNumber type = "number" value = "${employmenyListReceiptAmounts }" /> 元； 不符合資格計 ${employmenyListReceiptFail } 人。</th>
          </tr>
        </tbody>
      </table> 
     
      
      <div class="note-3">
        <div>
          <p>*按月計酬：第1-6個月每人每月補助13,000元，未滿6個月不予發給；第7-18個月每人每月補助15,000元，最長12個月。 <br>
          **非按月計酬：第1-6個月每人每小時補助70元，每月最高補助13,000元，未滿6個月不予發給；第7-18個月每人每小時補助80元，每月最高補有15,000元，最長12個月。 </p>
</div>
      </div>
      
      <div class="signature-3">
        <table>
          <tr>
            <td style="height: 60px;">承辦人員</td>
            <td style="height: 60px;">業務主管</td>
            <td style="height: 60px;">機關首長</td>
          </tr>
        </table>
      </div>    
       
      
      <div class="signature-3">
        <table>
          <tr>
            <td style="text-align:center">本署審核日期：中 華 民 國　${year}　年　${month}　月　${day}　日</td>
          </tr>
        </table>
      </div> 
           
      
    </div>
    <!--------- 報表內容end --------->




  </div>
  
  
  
  
</body>
</html>
