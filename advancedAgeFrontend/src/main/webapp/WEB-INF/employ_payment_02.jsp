<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-hant-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>中高齡就業相關補助計畫</title>
<link rel="stylesheet" href="css/template.css" type="text/css">
<link rel="stylesheet" href="css/main.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">

<link rel="stylesheet" href="css/cmxform.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
<script src="js/employ_payment_02/employ_payment_02.js"></script>

<script type="text/javascript">
$(function(){
	
	$('#employed').click(function(){
		$('#list').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').show();
		$('#listTable').hide();
	})
	
	$('#list').click(function(){
		$('#employed').find('a').removeClass();
		$(this).find('a').addClass('in color-2');
		$('#employedTable').hide();
		$('#listTable').show();
	})
	
})

</script>


</head>

<body>
<div class=""> 
  
  <!--- header --->
  <%@ include file="header.jsp" %>
  <!--- header end ---> 
  
  <!--- main --->
  <div class="main"> 
    
  <!------------ 申請流程 ------------>
  <div class="apply_main">
    <h1>繼續僱用高齡者補助 - 請領作業</h1>
    <h2>申請流程 Step2. 填寫請領名單</h2>
    
    <!---申辦前準備--->
    <h3 class="lh-base">請確實填寫資料，如有不實，主管機關<br>
    可駁回申請案或請止補貼，並負法律責任。</h3> 
    
    <p class="lh-base fw-bold pb-3">依勞動基準法及性別工作平等法等相關法令規定請假，<br>
致雇主給付薪資低於上開核發標準，依實際獲致薪資數額發給。</p>
    
    
    <!-------------繼續僱用補助名單清冊------------>
    <div class="form">
    
      <div class="title_main">
      <span>繼續僱用請領名單清冊</span>
      <em>請視需要自行增刪欄位，若名單超過5人請下載
      【<a href="/file/SAMPLE/繼續僱用-請領專用表.xlsx" title="繼續僱用-請領專用Excel表 ( 另存新檔 )">繼續僱用-請領專用表.xlsx</a>】
      填寫後上傳</em>
      </div>
      
      <input type="text" id="seq" name="seq" value="${seq}" style="display:none">
      <input type="text" id="baseId" name="baseId" value="${baseId}" style="display:none">
      <div id="page_tab">
        <div class="tab-1" id="employed"><a class="in color-2">線上填寫資料</a></div>
        <div class="tab-1" id="list"><a>上傳專用表格</a></div>
      </div>
      
      
      <div class="staff" id="employedTable">
      	<form id="listForm" action="">
        <ol class="staff">
        <c:choose><c:when test="${not empty advancedAgeEmploymentListReceipts}">
	        <c:forEach items="${advancedAgeEmploymentListReceipts}" var="item" varStatus="status">
	        	<c:if test="${item.baseAllowanceFrequency==0 }">
	        	<li id="employedTable${status.count}">
		          <div class="ss">
		          <label for="name${status.count}">勞工姓名</label>
		          <input type="text" id="name${status.count}" name="name${status.count}" value="${item.name}">
		          </div>
		          
		          <div class="ss">
		          <label for="identification${status.count}">身分證字號</label>
		          <input type="text" id="identification${status.count}" name="identification${status.count}" value="${item.identification}">
		          </div>
		        
		          <div class="ss">
		          <label for="insuranceType${status.count}">退保(離職)</label>
		          <select id="insuranceType${status.count}" name="insuranceType${status.count}">
		            <option value>請選擇</option>
		            <option value="1" <c:if test="${item.laborProtectionExpiredTime.length()==7}">selected</c:if>>勞工保險</option>
		            <option value="2" <c:if test="${item.occupationalAccidentProtectionExpiredTime.length()==7}">selected</c:if>>職災保險</option>
		          </select>
		          <img src="images/icon_qu.png" class="icon_qu" title="仍加保中免填">
		          </div>
		        
		          <div class="ss">
		          <label for="insuranceTime${status.count}">退保日期</label>
		          <input type="text" id="insuranceTime${status.count}" name="insuranceTime${status.count}" placeholder="yyymmdd" maxlength="7" oninput="value=value.replace(/[^\d]/g,'')"
		          	<c:if test="${item.laborProtectionExpiredTime.length()==7}">value="${item.laborProtectionExpiredTime}"</c:if>
		          	<c:if test="${item.occupationalAccidentProtectionExpiredTime.length()==7}">value="${item.occupationalAccidentProtectionExpiredTime}"</c:if>>
		          </div>
		        
		          <div class="ss">
		            <label for="salary${status.count}">平均薪資</label>
		            <input type="text" id="salary${status.count}" name="salary${status.count}" placeholder="每月平均薪資" pattern="[0-9]*" value="${item.salary}">
		          </div>
		          
		          <div class="m">
		            <label for="salaryMethod${status.count}">計薪方式
		            </label>
		            <select id="salaryMethod${status.count}" name="salaryMethod${status.count}">
		              <option value>請選擇</option>
		              <option value="M" <c:if test="${item.salaryMethod=='M'}">selected</c:if>>按月計</option>
		              <option value="H" <c:if test="${item.salaryMethod=='H'}">selected</c:if>>非按月</option>
		              <option value="MH" <c:if test="${item.salaryMethod=='MH'}">selected</c:if>>部分按月，部分非按月</option>
		            </select>
		            <input type="text" class="w-50" id="salaryMethodRemark${status.count}" name="salaryMethodRemark${status.count}" placeholder="例：7月95小時, 8月106小時..." value="${item.salaryMethodRemark.replace(';',',')}">
		            <img src="images/icon_qu.png" class="icon_qu" title="
		【按月計】免填備註
		【非按月】請敘明每月時數
		 如：7月95小時, 8月106小時...">
		          </div>
		        
		          <div class="ss">
		          <label for="frequency${status.count}">請領次數</label>
		          <select id="frequency${status.count}" name="frequency${status.count}">
		            <option value>請選擇</option>
		            <option value="1" <c:if test="${item.frequency==1}">selected</c:if>>第1次</option>
		            <option value="2" <c:if test="${item.frequency==2}">selected</c:if>>第2次</option>
		            <option value="3" <c:if test="${item.frequency==3}">selected</c:if>>第3次</option>
		            <option value="4" <c:if test="${item.frequency==4}">selected</c:if>>第4次</option>
		            <option value="5" <c:if test="${item.frequency==5}">selected</c:if>>第5次</option>
		          </select>
		            <img src="images/icon_qu.png" class="icon_qu" title="
		【第1次】請領期間為前6個月
		 ，未滿6個月不予發給。
		 
		【第2~5次】請領申請期間，
		 為第7~18個月，最長12個月。">
		          </div>
		        
		        <c:if test="${item.employmentMonthStartTime.length()==7 }">
		          <div class="m w-100 point-2">
		            <label for="salaryType${status.count}1">請領補助</label>
		            <select id="salaryType${status.count}1" name="salaryType${status.count}1">
		              <option value>請選擇</option>
		              <option value="M" selected>按月計</option>
		              <option value="H">按時計</option>
		            </select>
		            <img src="images/icon_qu.png" class="icon_qu" title="
		【按月計酬】
		 第1-6個月每人每月補助 13,000 元。
		 第7-18個月每人每月補助 15,000 元。
		
		【非按月計酬】
		 第1-6個月每人每小時補助 70 元，
		 每月最高補助 13,000 元。
		 第7-18個月每人每小時補助 80 元，
		 每月最高補有 15,000 元。">
		
		            <label for="">申請期間</label>
		            <input type="text" class="short-2" id="employmentStartTime${status.count}1" name="employmentStartTime${status.count}1" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')" value="${item.employmentMonthStartTime}"> 至
		            <input type="text" class="short-2" id="employmentEndTime${status.count}1" name="employmentEndTime${status.count}1" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')" value="${item.employmentMonthEndTime}">
		
		            <label for="">月數 / 時數</label>
		            <input type="number" class="short" step="1" min="0" id="count${status.count}1" name="count${status.count}1" 
			            <c:if test="${item.frequency==1}">value="${item.lowMonthNumber }"</c:if>
			            <c:if test="${item.frequency>1}">value="${item.highMonthNumber }"</c:if>>
		            <label for="">請領金額</label>
		            <input type="text" id="amounts${status.count}1" name="amounts${status.count}1" 
		            <c:if test="${item.frequency==1}">value="${item.lowMonthNumber*13000 }"</c:if>
		            <c:if test="${item.frequency>1}">value="${item.highMonthNumber*15000 }"</c:if>
		             class="readonly" placeholder="自動計算" readonly>
		            
	            	<button type="button" class="add" onclick="showNewSalaryType('${status.count}')"<c:if test="${item.employmentHourStartTime.length()==7 }"> style="display:none;"</c:if>>＋</button>
		          </div>
		         </c:if>
		         
		         <c:if test="${item.employmentHourStartTime.length()==7 }">
		          <div class="m w-100 point-2">
		            <label for="salaryType${status.count}1">請領補助</label>
		            <select id="salaryType${status.count}1" name="salaryType${status.count}1">
		              <option value>請選擇</option>
		              <option value="M">按月計</option>
		              <option value="H" selected>按時計</option>
		            </select>
		            <img src="images/icon_qu.png" class="icon_qu" title="
		【按月計酬】
		 第1-6個月每人每月補助 13,000 元。
		 第7-18個月每人每月補助 15,000 元。
		
		【非按月計酬】
		 第1-6個月每人每小時補助 70 元，
		 每月最高補助 13,000 元。
		 第7-18個月每人每小時補助 80 元，
		 每月最高補有 15,000 元。">
		
		            <label for="">申請期間</label>
		            <input type="text" class="short-2" id="employmentStartTime${status.count}1" name="employmentStartTime${status.count}1" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')" value="${item.employmentHourStartTime}"> 至
		            <input type="text" class="short-2" id="employmentEndTime${status.count}1" name="employmentEndTime${status.count}1" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')" value="${item.employmentHourEndTime}">
		
		            <label for="">月數 / 時數</label>
		            <input type="number" class="short" step="1" min="0" id="count${status.count}1" name="count${status.count}1" 
			            <c:if test="${item.frequency==1}">value="${item.lowHoursNumber }"</c:if>
			            <c:if test="${item.frequency>1}">value="${item.highHoursNumber }"</c:if>>
		            <label for="">請領金額</label>
		            <input type="text" id="amounts${status.count}1" name="amounts${status.count}1" 
		            <c:if test="${item.frequency==1}">value="${item.lowHoursNumber*70 }"</c:if>
		            <c:if test="${item.frequency>1}">value="${item.highHoursNumber*80 }"</c:if> 
		            class="readonly" placeholder="自動計算" readonly>
		            <c:if test="${item.employmentMonthStartTime.length()==7 }">
		            	<button class="add">－</button>
		            </c:if>
		       		<c:if test="${item.employmentMonthStartTime.length()!=7 }">
		       			<button type="button" class="add" onclick="showNewSalaryType('${status.count}')">＋</button>
		       		</c:if>
		          </div>
		         </c:if>
		          
		          <div class="px-4">（請領若有2種計薪方式，請按右方+按鈕增加欄位）</div>   
		
		          <div class="close"><button class="close" title="移除此筆資料">X</button></div>
	          
	        </li>
	        </c:if>
	    	</c:forEach>
        </c:when><c:otherwise>
	        <!---01--->
	        <li id="employedTable1">
	          <div class="ss">
	          <label for="name1">勞工姓名</label>
	          <input type="text" id="name1" name="name1">
	          </div>
	          
	          <div class="ss">
	          <label for="identification1">身分證字號</label>
	          <input type="text" id="identification1" name="identification1">
	          </div>
	        
	          <div class="ss">
	          <label for="insuranceType1">退保(離職)</label>
	          <select id="insuranceType1" name="insuranceType1">
	            <option value>請選擇</option>
	            <option value="1">勞工保險</option>
	            <option value="2">職災保險</option>
	          </select>
	          <img src="images/icon_qu.png" class="icon_qu" title="仍加保中免填">
	          </div>
	        
	          <div class="ss">
	          <label for="insuranceTime1">退保日期</label>
	          <input type="text" id="insuranceTime1" name="insuranceTime1" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')">
	          </div>
	        
	          <div class="ss">
	            <label for="salary1">平均薪資</label>
	            <input type="text" id="salary1" name="salary1" placeholder="每月平均薪資" pattern="[0-9]*">
	          </div>
	          
	          <div class="m">
	            <label for="salaryMethod1">計薪方式
	            </label>
	            <select id="salaryMethod1" name="salaryMethod1">
	              <option value>請選擇</option>
	              <option value="M">按月計</option>
	              <option value="H">非按月</option>
	              <option value="MH">部分按月，部分非按月</option>
	            </select>
	            <input type="text" class="w-50" id="salaryMethodRemark1" name="salaryMethodRemark1" placeholder="例：7月95小時, 8月106小時...">
	            <img src="images/icon_qu.png" class="icon_qu" title="
	【按月計】免填備註
	【非按月】請敘明每月時數
	 如：7月95小時, 8月106小時...">
	          </div>
	        
	          <div class="ss">
	          <label for="frequency1">請領次數</label>
	          <select id="frequency1" name="frequency1">
	            <option value>請選擇</option>
	            <option value="1">第1次</option>
	            <option value="2">第2次</option>
	            <option value="3">第3次</option>
	            <option value="4">第4次</option>
	            <option value="5">第5次</option>
	          </select>
	            <img src="images/icon_qu.png" class="icon_qu" title="
	【第1次】請領期間為前6個月
	 ，未滿6個月不予發給。
	 
	【第2~5次】請領申請期間，
	 為第7~18個月，最長12個月。">
	          </div>
	        
	          <div class="m w-100 point-2">
	            <label for="salaryType11">請領補助</label>
	            <select id="salaryType11" name="salaryType11">
	              <option value>請選擇</option>
	              <option value="M">按月計</option>
	              <option value="H">按時計</option>
	            </select>
	            <img src="images/icon_qu.png" class="icon_qu" title="
	【按月計酬】
	 第1-6個月每人每月補助 13,000 元。
	 第7-18個月每人每月補助 15,000 元。
	
	【非按月計酬】
	 第1-6個月每人每小時補助 70 元，
	 每月最高補助 13,000 元。
	 第7-18個月每人每小時補助 80 元，
	 每月最高補有 15,000 元。">
	
	            <label for="">申請期間</label>
	            <input type="text" class="short-2" id="employmentStartTime11" name="employmentStartTime11" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')"> 至
	            <input type="text" class="short-2" id="employmentEndTime11" name="employmentEndTime11" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')">
	
	            <label for="">月數 / 時數</label>
	            <input type="number" class="short" step="1" min="0" id="count11" name="count11">
	            <label for="">請領金額</label>
	            <input type="text" id="amounts11" name="amounts11" class="readonly" placeholder="自動計算" readonly>
	            <button type="button" class="add" onclick="showNewSalaryType('1')">＋</button>
	       
	          </div>
	          
	          
	          <div class="px-4">（請領若有2種計薪方式，請按右方+按鈕增加欄位）</div>   
	
	
	          <div class="close"><button class="close" title="移除此筆資料">X</button></div>
	          
	        </li>
	    </c:otherwise></c:choose>
        </ol>
        </form>
        <div class="btn_box">
          <button class="subjoin" onclick="listAdd()">＋增加欄位</button>
          <button class="save" onclick="listSave()">暫存資料</button>
        </div>
      
      </div>
      
      
      <div class="staff_excel" id="listTable" style="display:none">
        
        <div class="title text-center mt-3 mb-4 w-100">請上傳「最新完整資料」，每次上傳皆會覆蓋先前資料，請確認後再送出！</div>
        <div class="file_box text-center"> 
        	<input type="file" class="select-file" id="uploadFile" name="uploadFile" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <button class="upload" onclick="fileUpload('Y')">上傳檔案</button>
        </div>

      </div>

    </div>
    
	<!------------ loading 效果 ------------>
    <div id="loader-container" style="display:none;">
    <p id="loadingText">Loading</p>
    </div>
    
    <div class="page">
      <button onclick="listSave()">暫存資料</button>
      <button onclick="next()">下一步</button>
    </div>

    
  </div>
  <!------------ 申請流程 END ------------>
    
  </div>
  <!--- main end ---> 
  
  <!--- footer --->
  <footer class="copyright">
    <section>
      <div>勞動力發展署：24219新北市新莊區中平路439號南棟4樓　電話代表號：(02)8995-6000　客服專線：0800-777-888</div>
      <div>本署服務時間：週一至週五　上午8時30分至12時30分，下午13時30分至17時30分</div>
      <div>最佳解析度1024x768 ，建議更新瀏覽器至以下版本：最新版本Chrome、最新版本Firefox</div>
      <div>中華民國勞動部勞動力發展署版權所有 © 2021 All rights reserved. </div>
    </section>
  </footer>
  <!--- footer end ---> 
  
</div>
</body>
</html>