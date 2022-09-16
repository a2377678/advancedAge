<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<title>繼續僱用高齡者補助計畫 - 請領補助清冊</title>
<link href="css/print.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/c01/c01_list.js"></script>
</head>

<body>
  
  
  <!--------- 報表頁面 --------->
  <div class="report_page break_before">
  
    <!--------- 標題 --------->
    <div class="report_title">
    
      <div class="t-mane">請領補助清冊</div>
      
      <div class="t-date">中華民國
        <span class="year">111</span>年
        <span class="month">12</span>月
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
            <th style="width: 8%;">請領日期</th>
            <th>請領次數</th>
            <th>屆齡65歲</th>
            <th>核定人數</th>
            <th>30%門檻</th>
            <th>本次請領</th>
            <th>請領比例</th>
            <th>本次預計金額</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>${base[0].get('aaid') }</td>
            <td>${base[0].get('companyName') }</td>
            <td>${base[0].get('seq') }</td>
            <td>${base[0].get('allowanceFrequencyRecord').split(';')[employmenyListReceipt[0].baseAllowanceFrequency].split('、')[1].substring(0,4)-1911}${base[0].get('allowanceFrequencyRecord').split(';')[employmenyListReceipt[0].baseAllowanceFrequency].split('、')[1].substring(4,10).replaceAll('-','/')}</td>
            <td>第 ${employmenyListReceipt[0].baseAllowanceFrequency} 期</td>
            <td id="nearHighEmploymentNumber">${plan.nearHighEmploymentNumber } 人</td>
            <td id="employmenyListReceiptNumber">${employmenyListReceipt.size()} 人</td>
            <td id="checkEmploymentPerson"></td>
            <td>${employmenyListReceipt.size()} 人</td>
            <td id="checkEmploymentPercentage"></td>
            <td>120000 元</td>
          </tr>
        </tbody>
      </table>
      
      
      <br><br>
      
      
      <table class="m">
        <thead>
          <tr>
            <th rowspan="2" style="width: 5%;">編號</th>
            <th rowspan="2" style="width: 8%;">勞工姓名</th>
            <th rowspan="2" style="width: 9%;">身分證字號</th>
            <th rowspan="2" style="width: 7%;">退保日期</th>
            <th rowspan="2" style="width: 5%;">類型</th>
            <th rowspan="2" style="width: 8%;">續僱每月<br>
              平均薪資</th>
            <th rowspan="2" style="width: 4%;">申請<br>
              次數</th>
            <th colspan="2" rowspan="2" style="width: 8%;">本次請領期間<br>
              ( 滿65歲次日算起 )</th>
            <th colspan="4">請領補助 ( 同期只能擇一 )</th>
            <th rowspan="2" style="width: 10%;">審核結果</th>
            <th rowspan="2">修正金額</th>
          </tr>
          <tr>
            <th>計酬</th>
            <th>月數</th>
            <th>時數</th>
            <th>合計金額</th>
          </tr>
        </thead>
        <tbody>
<%--         <c:choose> --%>
<%--         	<c:when test="${not empty employmenyListReceipt}"> --%>
<%-- 	      	<c:forEach items="${employmenyListReceipt}" var="item" varStatus="status"> --%>
<!-- 	      	  <tr> -->
<%-- 	            <td>${status.count }</td> --%>
<%-- 	            <td>${item.name }</td> --%>
<%-- 	            <td>${item.identification }</td> --%>
<%-- 	            <td><c:if test="${item.laborProtectionExpiredTime.length()==7}">${item.laborProtectionExpiredTime.substring(0,3)}/${item.laborProtectionExpiredTime.substring(3,5)}/${item.laborProtectionExpiredTime.substring(5)}</c:if> --%>
<%-- 	            <c:if test="${item.occupationalAccidentProtectionExpiredTime.length()==7}">${item.occupationalAccidentProtectionExpiredTime.substring(0,3)}/${item.occupationalAccidentProtectionExpiredTime.substring(3,5)}/${item.occupationalAccidentProtectionExpiredTime.substring(5,7)}</c:if> --%>
<!-- 	            </td> -->
<%-- 	            <td><c:if test="${item.laborProtectionExpiredTime.length()==7}">勞保</c:if> --%>
<%-- 	            <c:if test="${item.occupationalAccidentProtectionExpiredTime.length()==7}">職災</c:if> --%>
<!-- 	            </td> -->
<%-- 	            <td>${item.salary }</td> --%>
<%-- 	            <td>${item.frequency }</td> --%>
<!-- 	            <td>-</td> -->
<!-- 	            <td>-</td> -->
<!-- 	            <td>-</td> -->
<!-- 	            <td>-</td> -->
<!-- 	            <td>-</td> -->
<!-- 	            <td>-</td> -->
<!-- 	            <td> -->
<!-- 	            <select name="select3" id="select3"> -->
<!-- 	              <option selected>---</option> -->
<!-- 	              <option>符合</option> -->
<!-- 	              <option>部分符合</option> -->
<!-- 	              <option>不符合</option> -->
<!-- 	            </select></td> -->
<!-- 	            <td><input type="text" size="3"></td> -->
<!-- 	          </tr>  -->
<%-- 	      	</c:forEach> --%>
<%-- 	        </c:when> --%>
<%--         </c:choose> --%>
          <tr>
            <td>1</td>
            <td>王先生</td>
            <td>A123456789</td>
            <td>111/02/01</td>
            <td>勞保</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>
            <select name="select3" id="select3">
              <option selected>---</option>
              <option>符合</option>
              <option>部分符合</option>
              <option>不符合</option>
            </select></td>
            <td><input type="text" size="3"></td>
          </tr>
          <tr>
            <td>2</td>
            <td>陳先生</td>
            <td>A198765432</td>
            <td>&nbsp;</td>
            <td>勞保</td>
            <td>50000</td>
            <td>1</td>
            <td>111/01/24</td>
            <td>111/07/23</td>
            <td>月</td>
            <td>6</td>
            <td>&nbsp;</td>
            <td>78000</td>
            <td><select name="select" id="select">
              <option selected>---</option>
              <option>符合</option>
              <option>部分符合</option>
              <option>不符合</option>
            </select></td>
            <td><input type="text" size="3"></td>
          </tr>
          <tr>
            <td>3</td>
            <td>廖先生</td>
            <td>B123456789</td>
            <td>&nbsp;</td>
            <td>職災</td>
            <td>45000</td>
            <td>2</td>
            <td>110/12/31</td>
            <td>110/06/30</td>
            <td>時</td>
            <td>&nbsp;</td>
            <td>600</td>
            <td>46000</td>
            <td><select name="select2" id="select2">
              <option selected>---</option>
              <option>符合</option>
              <option>部分符合</option>
              <option>不符合</option>
            </select></td>
            <td><input type="text" size="3"></td>
          </tr>
        </tbody>
      </table>
       
      
      <br><br><br>
      <div class="p_btn_box-3">
      <button type="button" class="p_btn_03">列印清冊</button>
      <button type="button" class="p_btn_02">取消修改</button>
      <button type="button" class="p_btn_01">儲存修改</button>
      </div>
           
      
    </div>
    <!--------- 報表內容end --------->




  </div>
  
  
  
  
</body>
</html>
