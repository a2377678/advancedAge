<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="utf-8">
<title>促進中高齡者及高齡者就業相關補助計畫系統</title>

<link href="css/file.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/c01/c01_1.js"></script>

<script type="text/javascript">
$(function(){
	$('#condition').click(function(){
		$('#unitData').find('a').removeClass();
		$(this).find('a').addClass('in');
		$('#unitDataTable').hide();
		$('#conditionTable').show();
	})
	
	$('#unitData').click(function(){
		$('#condition').find('a').removeClass();
		$(this).find('a').addClass('in');
		$('#unitDataTable').show();
		$('#conditionTable').hide();
	})
	
	$('#employed').click(function(){
		$('#list').find('a').removeClass();
		$('#situation').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').show();
		$('#listTable').hide();
		$('#situationTable').hide();
	})
	
	$('#list').click(function(){
		$('#employed').find('a').removeClass();
		$('#situation').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').hide();
		$('#listTable').show();
		$('#situationTable').hide();
	})
	
	$('#situation').click(function(){
		$('#employed').find('a').removeClass();
		$('#list').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').hide();
		$('#listTable').hide();
		$('#situationTable').show();
	})
	
	$('#protection').click(function(){
		$('#approve').find('a').removeClass();
		$('#allowance').find('a').removeClass();
		$('#grant').find('a').removeClass();
		$(this).find('a').addClass('in color-3');
		$('#protectionTable').show();
		$('#approveTable').hide();
		$('#allowanceTable').hide();
		$('#grantTable').hide();
	})
	
	$('#approve').click(function(){
		$('#protection').find('a').removeClass();
		$('#allowance').find('a').removeClass();
		$('#grant').find('a').removeClass();
		$(this).find('a').addClass('in color-3');
		$('#protectionTable').hide();
		$('#approveTable').show();
		$('#allowanceTable').hide();
		$('#grantTable').hide();
	})
	$('#allowance').click(function(){
		$('#protection').find('a').removeClass();
		$('#approve').find('a').removeClass();
		$('#grant').find('a').removeClass();
		$(this).find('a').addClass('in color-3');
		$('#protectionTable').hide();
		$('#approveTable').hide();
		$('#allowanceTable').show();
		$('#grantTable').hide();
	})
	$('#grant').click(function(){
		$('#protection').find('a').removeClass();
		$('#approve').find('a').removeClass();
		$('#allowance').find('a').removeClass();
		$(this).find('a').addClass('in color-3');
		$('#protectionTable').hide();
		$('#approveTable').hide();
		$('#allowanceTable').hide();
		$('#grantTable').show();
	})
})

</script>
</head>



<body>


  <!---------------------- top ---------------------->
  <%@ include file="../header.jsp" %>
  <!---------------------- top end ---------------------->

    
  <div id="main_menu">
    <div><a href="#" class="menu-1 in">繼續僱用高齡者</a></div>
    <div><a href="#" class="menu-2">傳承專業技術與經驗</a></div>
    <div><a href="#" class="menu-3">退休後再就業準備協助措施</a></div>
    <div><a href="account01" class="account">申請帳號審核管理</a></div>
  </div>

  <!---------------------- left menu ---------------------->
  <%@ include file="../leftMenu.jsp" %>
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">請款與核銷
        <span>請領核銷作業</span>
        <span id="number">C01-1</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName}&nbsp;${name}</a>
        <a href="logout">登出</a>
      </div>
      

      <!------------------- table 1 ------------------->
      <div id="page_tab">
        <div class="file_title-1">申請單位資料</div>
      </div>
      <input type="text" id="aaid" value="${base[0].aaid }" style="display:none">
      <input type="text" id="verifyUnit" value="${unit }" style="display:none">
      <input type="text" id="verifyPerson" value="${id}" style="display:none">
      <input type="text" id="updator" value="${id}" style="display:none">
      <!------ 申請單位資料 ------> 
      <table class="table_03" id="unitDataTable">
        <tr>
          <th width="18%">案件編號</th>
          <td width="35%">${base[0].aaid }</td>
          <th width="18%">申請日期</th>
          <td>${base[0].createTime.substring(0,4)-1911 }${base[0].createTime.substring(4,10) }</td>
        </tr>
        <tr>
          <th>單位名稱</th>
          <td width="35%">${apply.companyName }</td>
          <th width="18%">負責人</th>
          <td>${apply.principal }</td>
        </tr>
        <tr>
          <th>統一編號 / 扣繳編號</th>
          <td>${apply.seq }</td>
          <th>連絡電話 / 手機</th>
          <td>${apply.contactPhone }</td>
        </tr>
        <tr>
          <th>聯絡人</th>
          <td>${apply.contactName}</td>
          <th>聯絡人職稱</th>
          <td>${apply.contactJobtitle}</td>
        </tr>
        <tr>
          <th>勞保投保證號</th>
          <td colspan="3">${apply.guaranteeNumber.replace(';','、')}</td>
        </tr>
      </table>
      
      

      <!------------------- table 2 ------------------->

      <!------ 申請名單資格審核 ------>
      <table class="table_03" id="listTable" style="display:none">
        <tr>
          <th width="18%">屆齡65歲人數 (A)</th>
          <td>5</td>
        </tr>
        <tr>
          <th width="18%">申請計畫人數 (D)</th>
          <td>3</td>
        </tr>
        <tr>
          <th class="point">線上申請名單</th>
          <td><a href="list"><u>查看申請名單清冊</u></a> ( 另開報表html頁面 )</td>
        </tr>
        <tr>
          <th class="point">下載名單清冊</th>
          <td><a href="list.xlsx"><u>申請補助專用表格_案A1F1111F6180001_系統匯出資料.xlsx</u></a></td>
        </tr>
        <tr>
          <th class="point">審查合格人數 (E)</th>
          <td><input type="text" size="5" value="2"></td>
        </tr>
        <tr>
          <th class="point">合格人數比率 (F)</th>
          <td><b>66%</b>　(F) = (E) / (D) x 100%</td>
        </tr>
        <tr>
          <th class="point">檢核狀態</th>
          <td><span class="text_pass">合格</span></td>
        </tr>
        <tr>
          <th>備註</th>
          <td><input type="text" size="95"></td>
        </tr>
      </table>      
      
      
      <!------------------- table 3 ------------------->
      <div class="file_title-2">請領資料審核</div>
      <table class="table_04">
        <tr>
          <th colspan="2">核定</th>
          <th colspan="4" class="point">請領審核</th>
          <th colspan="5" class="point">請領審核結果</th>
          <th colspan="2" class="point">請領核發</th>
        </tr>
        <tr>
          <th width="6%">屆齡</th>
          <th width="6%">核定</th>
          <th width="11%" class="point">請領日期</th>
          <th width="6%" class="point">人數</th>
          <th width="7%" class="point">清冊</th>
          <th width="7%" class="point">附件</th>
          <th width="6%" class="point">符合</th>
          <th width="6%" class="point">不符</th>
          <th width="7%" class="point">比率</th>
          <th width="7%" class="point">報表</th>
          <th width="8%" class="point">結果</th>
          <th width="12%" class="point">本次金額</th>
          <th class="point">核定</th>
        </tr>
        <c:forEach items="${base[0].get('allowanceFrequencyRecord').split(';') }" var="item" varStatus="status">
       		<c:set var="employmenyListReceiptSize" value="0"/>
       		<c:set var="employmenyListReceiptSuccess" value="0"/>
       		<c:set var="employmenyListReceiptFail" value="0"/>
       		<c:set var="employmenyListReceiptAmounts" value="0"/>
       		<c:forEach items="${employmenyListReceipt}" var="i">
       			<c:if test="${status.count==i.baseAllowanceFrequency}">
       				<c:set var="employmenyListReceiptSize" value="${employmenyListReceiptSize+1 }"/>
       			</c:if>
       			<c:if test="${status.count==i.baseAllowanceFrequency && not empty i.approveStatus && i.approveStatus!=3 }">
       				<c:set var="employmenyListReceiptSuccess" value="${employmenyListReceiptSuccess+1 }"/>
       			</c:if>
       			<c:if test="${status.count==i.baseAllowanceFrequency && not empty i.approveStatus && i.approveStatus==3 }">
       				<c:set var="employmenyListReceiptFail" value="${employmenyListReceiptFail+1 }"/>
       			</c:if>
       			<c:if test="${status.count==i.baseAllowanceFrequency && not empty i.adjustAmounts}">
       				<c:set var="employmenyListReceiptAmounts" value="${employmenyListReceiptAmounts+i.adjustAmounts }"/>
       			</c:if>
       			<c:if test="${status.count==i.baseAllowanceFrequency && empty i.adjustAmounts}">
       				<c:set var="employmenyListReceiptAmounts" value="${employmenyListReceiptAmounts+i.amounts }"/>
       			</c:if>
       		</c:forEach>
       		
       		<tr>
	       		<td>${plan.nearHighEmploymentNumber }</td>
		        <td>${base[0].get("checkEmploymentPerson") }</td>
		        <td>${item.split('、')[1].substring(0,4)-1911}${item.split('、')[1].substring(4)}</td>
		        <td>${employmenyListReceiptSize }</td>
		        <td><a href="#" onclick="openData('${base[0].get('seq')}',${base[0].get('id')},${base[0].get('year')},${status.count},'1')"><u>審核</u></a></td>
		        <td><a href="#"><u>檢視</u></a></td>
		        
		        <td>${employmenyListReceiptSuccess}</td>
		        <td>${employmenyListReceiptFail}</td>
		        <td><fmt:formatNumber type = "number" 
         maxFractionDigits = "1" value = "${employmenyListReceiptSuccess/employmenyListReceiptSize*100}" />%</td>
		        <td><a href="#" onclick="openData('${base[0].get('seq')}',${base[0].get('id')},${base[0].get('year')},${status.count},'2')"><u>檢視</u></a></td>
		        <td>
		        	<c:if test="${employmenyListReceiptSuccess/employmenyListReceiptSize*100>30}"><span class="text_pass">符合</span></c:if>
		        	<c:if test="${employmenyListReceiptSuccess/employmenyListReceiptSize*100<30}"><span class="text_warn">不符合</span></c:if>
		        </td>
		        
		        <td><fmt:formatNumber type = "number" value = "${employmenyListReceiptAmounts}" /></td>
		        <td>
		        	<c:if test="${item.split('、')[2]==0}"><button type="button" class="btn_05" onclick="verify('${base[0].get('allowanceFrequencyRecord')}','${item.split('、')[0] }')">核定</button></c:if>
		        	<c:if test="${item.split('、')[2]==1}">已核定</c:if>
		        </td>
	        </tr>
       	</c:forEach>
      </table>
      
      <br>
      
      <table class="table_04">
        <tr>
          <th width="12%">承辦單位</th>
          <td width="37%" style="text-align:left">
          	<c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
		      		<c:if test="${base[0].verifyUnit==unitItem.code}">${unitItem.name}</c:if> 
	      	</c:forEach>
          </td>
          <th width="13%">承辦人員</th>
          <td width="27" style="text-align:left">
          	<c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
	      		<c:if test="${base[0].verifyPerson==userItem.id}">${userItem.name}</c:if> 
	      	</c:forEach>
          </td>
        </tr>
        <tr>
          <th>最後異動時間</th>
          <td style="text-align:left">
          	${base[0].updateTime.substring(0,4)-1911}${base[0].updateTime.substring(4,16)}
          </td>
          <th>最後異動人員</th>
          <td style="text-align:left">
          	<c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
	      		<c:if test="${base[0].updator==userItem.id}">${userItem.name}</c:if> 
	      	</c:forEach>
          </td>
        </tr>
      </table>

      <!------------------- table 3 ------------------->

      
      
      <div class="btn_box-3">
      <button type="button" class="btn_02" onclick="cancel()">返回列表</button>
      </div>
      

	  <form action="c01_list" method="post" id="dataForm" target="_blank">
      	<input type="text" id="dataSeq" name="seq" style="display:none">
      	<input type="text" id="year" name="year" style="display:none">
      	<input type="text" id="baseAllowanceFrequency" name="baseAllowanceFrequency" style="display:none">
      	<input type="text" id="advancedAgeBaseId" name="advancedAgeBaseId" style="display:none">
      </form>
      
  
  
  
    </div>
    
  </div>
  <!---------------------- main ---------------------->
  

</body>




</html>
