<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<html lang="zh-hant-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>中高齡及高齡者就業相關服務網</title>
<link rel="stylesheet" href="css/main.css" type="text/css">
<link rel="stylesheet" href="css/template.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">

<link rel="stylesheet" href="css/cmxform.css" type="text/css">
<link rel="stylesheet" href="css/jquery-confirm.min.css" type="text/css">

<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class=""> 
  
  <!--- header --->
  <%@ include file="header.jsp" %>
  <!--- header end ---> 
  
  
  <!--- main --->
  <div class="main clearfix" id="content"> 
    <a href="#C" title="中央內容區塊" id="AC" accesskey="C" name="C">:::</a> <!---無障礙---> 
    
  <!------------ 申請流程 ------------>
  <div class="apply_main">
  	
  	<%@ include file="countDownComponent.jsp" %>
    <!---無障礙/麵包屑--->
    <nav aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index" title="首頁">首頁</a></li>
        <li class="breadcrumb-item active" aria-current="page">線上申辦</li>
        <li class="breadcrumb-item active" aria-current="page">中高齡者退休後再就業準備協助措施 - 申請作業</li>
      </ol>
    </nav>
    <h1>中高齡者退休後再就業準備協助措施 - 申請作業</h1>
    <h2>申請流程 Step3. 填寫計畫書</h2>
    
    <!---申辦前準備--->
    <h3>請確實填寫資料，如有不實，主管機關可駁回<br>
    申請案或請止補貼，並負法律責任。</h3>
    
    <!-------------僱用資料及計畫說明------------>
    <form id="form">
    <div class="form">
      <div class="title_main"><span>單位介紹及計畫說明</span></div>
        
      <div class="full">
	      <label for="workContent">主要業務/產品/服務</label>
	      <input type="text" size="86%" id="workContent" name="workContent" value="${plan.workContent}" maxlength="100" required>
      </div>
        
      <div class="full">
	      <label for="friendlyMeasures">友善高齡者職場措施</label>
	      <input type="text" size="86%" id="friendlyMeasures" name="friendlyMeasures" value="${plan.friendlyMeasures}" maxlength="100" placeholder="如：防滑止跌等友善硬體環境、就業輔具或彈性上下班等措施" required>
      </div>
        
      <div class="full">
	      <label for="employeeNumber">目前員工人數</label>
	      <input type="number" step="1" min="0" id="employeeNumber" name="employeeNumber" value="${plan.employeeNumber}" required>
      </div>
        
      <div class="full">
	      <label for="beneficiaryNumber">計畫受益人數</label>
	      <input type="number" step="1" min="0" id="beneficiaryNumber" name="beneficiaryNumber" value="${plan.beneficiaryNumber}" size="50%" placeholder="補助期間年滿64歲人數" required>
      </div>
        
      <div class="full">
        <label for="subsidyType">申請補助類型 ( 可複選 )</label>
        <span class="px-1"><input type="checkbox" name="CheckboxGroup1" value="1" id="CheckboxGroup1_0"> 職涯諮詢</span>
        <span class="px-1"><input type="checkbox" name="CheckboxGroup1" value="2" id="CheckboxGroup1_1"> 就業諮詢</span>
        <span class="px-1"><input type="checkbox" name="CheckboxGroup1" value="4" id="CheckboxGroup1_2"> 創業諮詢</span>
        <input type="hidden" name="subsidyType" id="subsidyType" value="${plan.subsidyType}">
      </div>
        
      <div class="full">
      <label for="amounts">申請金額</label>
      <input type="number" name="amounts" id="amounts" value="${plan.amounts}" step="1" min="0" required>
      </div>
        
      <div class="full">
        <label for="multipleApplications">經費結構 (1)</label>
        <span>同一計畫向二個以上政府機關提出申請補助之項目與金額</span>
        <span class="px-2"><input type="radio" name="multipleApplications" value="N" id="q01_0" <c:if test="${plan.multipleApplications != 'Y'}">checked</c:if>> 無</span>
        <span class="px-1"><input type="radio" name="multipleApplications" value="Y" id="q01_1" <c:if test="${plan.multipleApplications == 'Y'}">checked</c:if>> 有：
          <input type="text" name="multipleApplicationsDescription" id="multipleApplicationsDescription" value="${plan.multipleApplicationsDescription}" placeholder="年度、計畫名、補助金額">
        </span>
      </div>
        
      <div class="full">
        <label for="applySameYear">經費結構 (2)</label>
        <span>同年度申請中高齡者退休後再就業準備訓練補助實施計畫</span>
        <span class="px-2"><input type="radio" name="applySameYear" value="N" id="q01_0" <c:if test="${plan.applySameYear != 'Y'}">checked</c:if>> 無</span>
        <span class="px-1"><input type="radio" name="applySameYear" value="Y" id="q01_1" <c:if test="${plan.applySameYear == 'Y'}">checked</c:if>> 有：
          <input type="text" name="applySameYearDescription" id="applySameYearDescription" value="${plan.applySameYearDescription}" placeholder="年度、補助金額">
        </span>
      </div>
         
      <div class="full">
	      <label for="planGoal">計畫目標</label>
	      <textarea rows="2" id="planGoal" name="planGoal" οnkeyup="this.value = this.value.slice(0, 100)" maxlength="100" placeholder="( 輸入框可拖曳加大範圍 )" required>${plan.planGoal}</textarea>
      </div>
        
      <div class="full">
	      <label for="planContent">計畫內容</label>
	      <textarea rows="3" id="planContent" name="planContent" οnkeyup="this.value = this.value.slice(0, 300)" maxlength="300" placeholder="敘明自辦委辦、執行方式、執行地點、流程、時數等，如辦理相關課程者，應附課程時數或內容資料( 輸入框可拖曳加大範圍 )" required>${plan.planContent}</textarea>
      </div>
        
      <div class="full">
      <label for="">執行期間</label>
      <input type="text" id="planStartTime" name="planStartTime" value="${plan.planStartTime}" placeholder="yyymmdd" required readonly> ~
      <input type="text" id="planEndTime" name="planEndTime" value="${plan.planEndTime}" placeholder="yyymmdd" required readonly> 止
      </div>
      
      <div class="file_box site">
        <c:choose>
        	<c:when test="${plan.executionCity.length()>0}">
        		<c:forEach items="${fn:split(plan.executionCity,';')}" var="item" varStatus="status">
        			<div class="full site">
        			<c:choose>
        				<c:when test="${status.first}">
        					<label for="executionCity${status.count}">計畫執行地</label>
        					<select name="executionCity" id="executionCity${status.count}" required>
        						<option value>請選擇</option>
        						<c:forEach  items="${cityList}"  var="city"  varStatus="userStatus">
						      		<option value="${city.code}" <c:if test="${item==city.code}">selected</c:if>>${city.name}</option>
						      	</c:forEach>
        					</select>
        					<input type="text" id="executionCityAddress${status.count}" name="executionCityAddress${status.count}" size="61%" placeholder="請填寫詳細地址" value="<c:out value="${fn:split(plan.executionCityAddress,';')[status.count-1]}" />" required>
        				</c:when>
        				<c:otherwise>
        					<label for="executionCity${status.count}"></label>
        					<select name="executionCity${status.count}" id="executionCity${status.count}" required>
        						<option value>請選擇</option>
        						<c:forEach  items="${cityList}"  var="city"  varStatus="userStatus">
						      		<option value="${city.code}" <c:if test="${item==city.code}">selected</c:if>>${city.name}</option>
						      	</c:forEach>
        					</select>
       						<input type="text" id="executionCityAddress${status.count}" name="executionCityAddress${status.count}" size="61%" placeholder="請填寫詳細地址" value="<c:out value="${fn:split(plan.executionCityAddress,';')[status.count-1]}" />" required>
        					<button type="button" class="add" onclick="delExecutionCity(${status.count})">－</button>
        				</c:otherwise>
        			</c:choose>
        			<c:choose>
        				<c:when test="${status.last}">
        					<button type="button" class="add" onclick="addExecutionCity(${status.count})" style>＋</button>
        				</c:when>
        				<c:otherwise>
        					<button type="button" class="add" onclick="addExecutionCity(${status.count})" style="display:none">＋</button>
        				</c:otherwise>
        			</c:choose>
        			</div>
        		</c:forEach>
        	</c:when>
        	<c:otherwise>
		      <div class="full site">
		        <label for="executionCity1">計畫執行地</label>
		        <select name="executionCity" id="executionCity1" required>
		          <option value>請選擇</option>
		          <option value="A">臺北市</option>
				  <option value="B">臺中市</option>
				  <option value="C">基隆市</option>
				  <option value="D">臺南市</option>
				  <option value="E">高雄市</option>
				  <option value="F">新北市</option>
				  <option value="G">宜蘭縣</option>
				  <option value="H">桃園市</option>
				  <option value="I">嘉義市</option>
				  <option value="J">新竹縣</option>
				  <option value="K">苗栗縣</option>
				  <option value="M">南投縣</option>
				  <option value="N">彰化縣</option>
				  <option value="O">新竹市</option>
				  <option value="P">雲林縣</option>
				  <option value="Q">嘉義縣</option>
				  <option value="T">屏東縣</option>
				  <option value="U">花蓮縣</option>
				  <option value="V">臺東縣</option>
				  <option value="W">金門縣</option>
				  <option value="X">澎湖縣</option>
				  <option value="Z">連江縣</option>
		        </select>
		        <input type="text" id="executionCityAddress1" name="executionCityAddress1" required>
		<!--         <button type="button" class="add" onclick="delExecutionCity(1)">－</button> -->
		        <button type="button" class="add" onclick="addExecutionCity(1)" style>＋</button>
		      </div>
        	</c:otherwise>
        </c:choose>
        
      </div>
      
    </div>
    
    
      <div class="btn_box">
      <button class="save" type="button" onclick="saveForm('Y')">暫存資料</button>
      </div> 
    
    <!-------------計畫達成指標及預期效益------------>
    <div class="form">
    
      <div class="title_main"><span>計畫達成指標及預期效益</span></div>
        
      <div class="full">
	      <label for="qualityBenefit">質化效益</label>
	      <textarea rows="2" id="qualityBenefit" name="qualityBenefit" οnkeyup="this.value = this.value.slice(0, 100)" maxlength="100" placeholder="含計畫執行後對單位或受益人員之助益及效果" required>${plan.qualityBenefit}</textarea>
      </div>
        
      <div class="full">
	      <label for="quantifyBenefit">量化效益</label>
	      <textarea rows="2" id="quantifyBenefit" name="quantifyBenefit" οnkeyup="this.value = this.value.slice(0, 100)" maxlength="100" placeholder="含計畫執行後對單位或受益人員之助益及效果" required>${plan.quantifyBenefit}</textarea>
      </div>
        
      <div class="full">
	      <label for="planExecutionSituation">近三年相關計畫經驗成果</label>
	      <textarea rows="2" id="planExecutionSituation" name="planExecutionSituation" οnkeyup="this.value = this.value.slice(0, 100)" maxlength="100" placeholder="近三年申請本部與中高齡者及高齡者就業相關計畫之執行成果或經驗，無則免填">${plan.planExecutionSituation}</textarea>
      </div>
      
    </div>   
	</form>

    <div class="btn_box">
      <button class="save" type="button" onclick="saveForm('Y')">暫存資料</button>
    </div> 
    
    
    <!-------------計畫受益人員------------>
    <div class="form">
    
      <div class="title_main">
      <span>計畫受益人員名單</span>
      <em>適用本計畫補助之年滿64歲員工名單，超過5人請下載
      【<a href="/file/SAMPLE/退休再就業_計畫受益人員名單專用表格.xlsx" title="計畫受益人員名單Excel表 ( 另存新檔 )">計畫受益人員名單專用表格.xlsx</a>】
      填寫後上傳</em>
      </div>
      
      
      <div id="page_tab">
        <div class="tab-1" id="employed"><a <c:if test="${plan.attachBenefitList != 'Y'}">class="in color-2"</c:if>>線上填寫資料</a></div>
        <div class="tab-1" id="excel"><a <c:if test="${plan.attachBenefitList == 'Y'}">class="in color-2"</c:if>>上傳專用表格</a></div>
      </div>
      
      
      <div class="staff" id="listStaff">
      	<form id="listForm">
        	<ol class="staff">
        	<c:choose>
        	<c:when test="${advancedAgeRetirementReemploymentBenefitLists !='[]'}">
        	<c:forEach items="${advancedAgeRetirementReemploymentBenefitLists}" var="item" varStatus="status">
        		<li>
		          <div class="ss">
			          <label for="name${status.count}">勞工姓名</label>
			          <input type="text" id="name${status.count}" name="name${status.count}" value="${item.name}">
		          </div>
		          
		          <div class="ss">
			          <label for="birthday">出生日期</label>
			          <input type="text" id="birthday${status.count}" name="birthday${status.count}" value="${item.birthday}" placeholder="yyymmdd" readonly>
		          </div>
		          
		          <div class="ss">
			          <label for="identification${status.count}">身分證字號</label>
	          	      <input type="text" id="identification${status.count}" name="identification${status.count}" value="${item.identification}">
		          </div>
		        
		          <div class="ss">
			          <label for="insuranceType${status.count}">保險類型</label>
			          <select id="insuranceType${status.count}" name="insuranceType${status.count}">
			            <option value>請選擇</option>
			            <option value="L" <c:if test="${item.insuranceType=='L'}">selected</c:if>>勞工保險</option>
			            <option value="Z" <c:if test="${item.insuranceType=='Z'}">selected</c:if>>職災保險</option>
			          </select>
		          </div>
		        
		          <div class="ss">
		          	  <label for="insuranceTime${status.count}">加保日期</label>
	          		  <input type="text" id="insuranceTime${status.count}" name="insuranceTime${status.count}" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')" 
	          		  	value="${item.insuranceTime}" readonly>
		          </div>
		          <div class="ss">
			          <label for="manager${status.count}">職務類型</label>
			          <select id="manager${status.count}" name="manager${status.count}">
			            <option value>請選擇</option>
			            <option value="Y" <c:if test="${item.manager=='Y'}">selected</c:if>>主管</option>
			            <option value="N" <c:if test="${item.manager=='N'}">selected</c:if>>非主管</option>
			          </select>
		          </div>
		        
		          <div class="ss">
			          <label for="workingHours${status.count}">工時類型</label>
			          <select id="workingHours${status.count}" name="workingHours${status.count}">
			            <option value>請選擇</option>
			            <option value="A" <c:if test="${item.workingHours=='A'}">selected</c:if>>全時</option>
			            <option value="P" <c:if test="${item.workingHours=='P'}">selected</c:if>>部分工時</option>
			          </select>
		          </div>
	        
		          <div class="close">
		          	  <button type="button" class="close" onclick="delBenefitList(this);" title="移除此筆資料">X</button>
		          </div>
		          
		        </li>
        	</c:forEach>
	        </c:when>
	        <c:otherwise>
	        	<!---01--->
		        <li>
		          <div class="ss">
			          <label for="name1">勞工姓名</label>
			          <input type="text" id="name1" name="name1">
		          </div>
		          
		          <div class="ss">
			          <label for="birthday1">出生日期</label>
			          <input type="text" id="birthday1" name="birthday1" placeholder="yyymmdd" readonly>
		          </div>
		          
		          <div class="ss">
			          <label for="identification1">身分證字號</label>
			          <input type="text" id="identification1" name="identification1">
		          </div>
		        
		          <div class="ss">
			          <label for="insuranceType1">保險類型</label>
			          <select id="insuranceType1" name="insuranceType1">
			            <option value>請選擇</option>
			            <option value="L">勞工保險</option>
			            <option value="Z">職災保險</option>
			          </select>
		          </div>
		        
		          <div class="ss">
			          <label for="insuranceTime1">加保日期</label>
			          <input type="text" id="insuranceTime1" name="insuranceTime1" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')" readonly>
		          </div>
		          
		          <div class="ss">
			          <label for="manager1">職務類型</label>
			          <select id="manager1" name="manager">
			            <option value>請選擇</option>
			            <option value="Y">主管</option>
			            <option value="N">非主管</option>
			          </select>
		          </div>
		          
		          <div class="ss">
			          <label for="workingHours1">工時類型</label>
			          <select id="workingHours1" name="workingHours">
			            <option value>請選擇</option>
			            <option value="A">全時</option>
			            <option value="P">部分工時</option>
			          </select>
		          </div>
		          
		          <div class="close"><button type="button" onclick="delBenefitList(this);" class="close" title="移除此筆資料">X</button></div>
		          
		        </li>
		        <!---02--->
<!-- 		        <li> -->
<!-- 		          <div class="ss"> -->
<!-- 			          <label for="name2">勞工姓名</label> -->
<!-- 			          <input type="text" id="name2" name="name2"> -->
<!-- 		          </div> -->
		          
<!-- 		          <div class="ss"> -->
<!-- 			          <label for="birthday2">出生日期</label> -->
<!-- 			          <input type="text" id="birthday2" name="birthday2" placeholder="yyymmdd"> -->
<!-- 		          </div> -->
		          
<!-- 		          <div class="ss"> -->
<!-- 			          <label for="identification2">身分證字號</label> -->
<!-- 			          <input type="text" id="identification2" name="identification2"> -->
<!-- 		          </div> -->
		        
<!-- 		          <div class="ss"> -->
<!-- 			          <label for="insuranceType2">保險類型</label> -->
<!-- 			          <select id="insuranceType2" name="insuranceType2"> -->
<!-- 			            <option value>請選擇</option> -->
<!-- 			            <option value="L">勞工保險</option> -->
<!-- 			            <option value="Z">職災保險</option> -->
<!-- 			          </select> -->
<!-- 		          </div> -->
		        
<!-- 		          <div class="ss"> -->
<!-- 			          <label for="insuranceTime2">加保日期</label> -->
<!-- 			          <input type="text" id="insuranceTime2" name="insuranceTime2" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')"> -->
<!-- 		          </div> -->
		          
<!-- 		          <div class="ss"> -->
<!-- 			          <label for="manager2">職務類型</label> -->
<!-- 			          <select id="manager2" name="manager"> -->
<!-- 			            <option value>請選擇</option> -->
<!-- 			            <option value="Y">主管</option> -->
<!-- 			            <option value="N">非主管</option> -->
<!-- 			          </select> -->
<!-- 		          </div> -->
		          
<!-- 		          <div class="ss"> -->
<!-- 			          <label for="workingHours2">工時類型</label> -->
<!-- 			          <select id="workingHours2" name="workingHours"> -->
<!-- 			            <option value>請選擇</option> -->
<!-- 			            <option value="A">全時</option> -->
<!-- 			            <option value="P">部分工時</option> -->
<!-- 			          </select> -->
<!-- 		          </div> -->
		          
<!-- 		          <div class="close"><button type="button" onclick="delBenefitList(this);" class="close" title="移除此筆資料">X</button></div> -->
		          
<!-- 		        </li> -->
		        <!---03--->
<!-- 		        <li> -->
<!-- 		          <div class="ss"> -->
<!-- 			          <label for="name3">勞工姓名</label> -->
<!-- 			          <input type="text" id="name3" name="name3"> -->
<!-- 		          </div> -->
		          
<!-- 		          <div class="ss"> -->
<!-- 			          <label for="birthday3">出生日期</label> -->
<!-- 			          <input type="text" id="birthday3" name="birthday3" placeholder="yyymmdd"> -->
<!-- 		          </div> -->
		          
<!-- 		          <div class="ss"> -->
<!-- 			          <label for="identification3">身分證字號</label> -->
<!-- 			          <input type="text" id="identification3" name="identification3"> -->
<!-- 		          </div> -->
		        
<!-- 		          <div class="ss"> -->
<!-- 			          <label for="insuranceType3">保險類型</label> -->
<!-- 			          <select id="insuranceType3" name="insuranceType3"> -->
<!-- 			            <option value>請選擇</option> -->
<!-- 			            <option value="L">勞工保險</option> -->
<!-- 			            <option value="Z">職災保險</option> -->
<!-- 			          </select> -->
<!-- 		          </div> -->
		        
<!-- 		          <div class="ss"> -->
<!-- 			          <label for="insuranceTime3">加保日期</label> -->
<!-- 			          <input type="text" id="insuranceTime3" name="insuranceTime3" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')"> -->
<!-- 		          </div> -->
		          
<!-- 		           <div class="ss"> -->
<!-- 			          <label for="manager3">職務類型</label> -->
<!-- 			          <select id="manager3" name="manager"> -->
<!-- 			            <option value>請選擇</option> -->
<!-- 			            <option value="Y">主管</option> -->
<!-- 			            <option value="N">非主管</option> -->
<!-- 			          </select> -->
<!-- 		          </div> -->
		          
<!-- 		          <div class="ss"> -->
<!-- 			          <label for="workingHours3">工時類型</label> -->
<!-- 			          <select id="workingHours3" name="workingHours"> -->
<!-- 			            <option value>請選擇</option> -->
<!-- 			            <option value="A">全時</option> -->
<!-- 			            <option value="P">部分工時</option> -->
<!-- 			          </select> -->
<!-- 		          </div> -->
		          
<!-- 		          <div class="close"><button type="button" onclick="delBenefitList(this);" class="close" title="移除此筆資料">X</button></div> -->
		          
<!-- 		        </li> -->
	        </c:otherwise>
	        </c:choose>
	        </ol>
      
	    </form>
      
        <div class="btn_box">
	      <button class="subjoin" onclick="listAdd()">＋增加欄位</button>
	      <button class="save" onclick="saveList('temp', 'N')">暫存資料</button>
	    </div>
      
      </div>
      
      <div class="staff_excel" id="listFile" style="display:none">
        
        <div class="title text-center mt-3 mb-4 w-100">請上傳「最新完整資料」，每次上傳皆會覆蓋先前資料，請確認後再送出！</div>
        <div class="file_box text-center"> 
            <input type="file" id="uploadFile" name="uploadFile" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <button class="upload" onclick="fileUpload('Y')">上傳檔案</button>
        </div>
		<c:choose><c:when test="${not empty advancedAgeRetirementReemploymentBenefitListAttachment}">
	      	<c:forEach items="${advancedAgeRetirementReemploymentBenefitListAttachment}" var="item" varStatus="status">
		      	<c:choose>
			      	<c:when test="${item.fileType=='advancedAgeRetirementReemploymentBenefitList' }">
			      	<br>
			      		<div class="file_box text-center" id="alreadyExist">
					        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
					        <span class="file_progress">上傳完成</span>
					        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
					        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
				        </div>
			      	</c:when>
		      	</c:choose>
	      	</c:forEach>
        </c:when></c:choose>
      </div>
    


      
      
    </div>
    
    <!------------ loading 效果 ------------>
    <div id="loader-container" style="display:none;">
    <p id="loadingText">Loading</p>
    </div>
    
    <div class="page">
      <button onclick="javascript:location.href='career_02'">回上頁</button>
      <button onclick="totalSave('total')">暫存資料</button>
      <button onclick="next()">下一步</button>
    </div>
    
  </div>
  <!------------ 申請流程 END ------------>
    
  </div>
  <!--- main end ---> 
  
  <!--- footer --->
  <%@ include file="footer.jsp" %>
  <!--- footer end ---> 
  
</div>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/jquery-confirm.min.js"></script>
<script src="js/gotop.js"></script>
<script src="js/career_03/career_03.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>

<script type="text/javascript" src="js/jquery-ui.js"></script>
</body>
</html>