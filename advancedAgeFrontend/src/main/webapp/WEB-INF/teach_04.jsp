<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet" href="css/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="css/jquery-confirm.min.css" type="text/css">

<script src="js/bootstrap.bundle.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/gotop.js"></script>
<script src="js/teach_04/teach_04.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/jquery-confirm.min.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
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
        <li class="breadcrumb-item active" aria-current="page">僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 申請作業</li>
      </ol>
    </nav>
    <h1>僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 申請作業</h1>
    <h2>申請流程 Step4. 填寫課程規劃</h2>
    
    <!---申辦前準備--->
    <h3>同一事由已領取政府機關相同性質之補助，不得再申請本計畫。<br>
      同一課程如有2名以上講師，請註明各自授課時數。</h3>
    
    
    <!-------------課程規劃------------>
    <div class="form">
    
      <div class="title_main pt-4">
      <span>課程規劃</span>
      <em>請視需要自行增刪欄位，若預計開設課程超過5項請下載
      【<a href="/file/SAMPLE/傳承經驗_課程規劃專用表格.xlsx" title="課程規劃專用Excel表 ( 另存新檔 )">課程規劃專用表格.xlsx</a>】
      填寫後上傳</em>
      </div>
      
      <div class="full">
        若一堂課程同時聘請 2 位以上 (含) 講師，請將課程資料分開填寫，且務必於「課程名稱」加上編號或講師名稱等資訊，以做資料區分。<br>
        <span>註：本區若使用「上傳專用表格」，課程規劃專用表格.xlsx 上傳成功後，資料內容將會直接呈現於網頁欄位。</span>
      </div>
      
      <div id="page_tab">
        <div class="tab-1" id="employed"><a class="in color-2">線上填寫資料</a></div>
        <div class="tab-1" id="list"><a>上傳專用表格</a></div>
      </div>
      
      
      <div class="staff" id="employedTable">
      	<form id="listForm">
        <ol class="staff">
        <c:choose><c:when test="${scheduleLists !='[]'}">
	        <c:forEach items="${scheduleLists}" var="item" varStatus="status">
	        	<li>
		          <div class="">
		          <label for="executionTimeStart${status.count}">預計執行期間</label>
		          <input type="text" class="short-2" id="executionStartTime${status.count}" name="executionStartTime${status.count}" placeholder="yyymmdd" value="${item.executionStartTime }" readonly> ~
		          <input type="text" class="short-2" id="executionEndTime${status.count}" name="executionEndTime${status.count}" placeholder="yyymmdd" value="${item.executionEndTime }" readonly>
		          </div>
		          
		          <div class="">
		            <label for="executionCity${status.count}">計畫執行地</label>
		            <select name="executionCity${status.count}" id="executionCity${status.count}">
			        	<option value>請選擇</option>
			        	<c:forEach  items="${cityList}"  var="cityItem"  varStatus="userStatus">
			      			<option value="${cityItem.code}" <c:if test="${item.executionCity==cityItem.code}">selected</c:if>>${cityItem.name}</option>
			      		</c:forEach>
			        </select>
		          </div>
		          
		          <div class="full">
		          <label for="subject${status.count}">課程名稱</label>
		          <input type="text" id="subject${status.count}" name="subject${status.count}" placeholder="課程名稱" value="${item.subject }">
		          </div>
		        
		          <div class="full">
		          <label for="introduction${status.count}">課程大綱</label>
		          <textarea class="s" rows="2" id="introduction${status.count}" name="introduction${status.count}" onkeyup="wordsLimit(this,100)" placeholder="課程大綱  ( 輸入框可拖曳加大範圍 )">${item.introduction.replace("\\n","&#13;&#10;") }</textarea>
		          </div>
		          
		          <div class="">
		          <label for="executionTime${status.count}">預計開課時間</label>
		          <input type="text" id="executionTime${status.count}" name="executionTime${status.count}" placeholder="00:00~00:00" value="${item.executionTime.replaceAll('=',':') }">
		          </div>
          
		          <div class="">
		          <label for="speakerName${status.count}">講師姓名</label>
		          <input type="text" id="speakerName${status.count}" name="speakerName${status.count}" placeholder="講師姓名" value="${item.speakerName }">
		          </div>
		        
		          <div class="">
		          <label for="teachingHours${status.count}">預計授課時數</label>
		          <input type="number" id="teachingHours${status.count}" name="teachingHours${status.count}" step="0.5" min="0" value="${item.teachingHours }">
		          </div>
		        
		          <div class="">
		          <label for="participateNumber${status.count}">預計參訓人數</label>
		          <input type="number" id="participateNumber${status.count}" name="participateNumber${status.count}" step="1" min="0" value="${item.participateNumber }">
		          </div>
		        
		          <div class="full">
		          <label for="participatePeople${status.count}">預計參訓學員</label>
		          <textarea class="s" rows="1" id="participatePeople${status.count}" name="participatePeople${status.count}" placeholder="預計參訓學員  ( 輸入框可拖曳加大範圍 )">${item.participatePeople }</textarea>
		          </div>
		          
		          <div class="close"><button type="button" class="close" title="移除此筆資料" onclick="listDelete(this)">X</button></div>
		          
		        </li>
	        </c:forEach>
	    </c:when><c:otherwise>
        <!---01--->
	        <li>
	
	          <div class="">
	          <label for="executionTimeStart1">預計執行期間</label>
	          <input type="text" class="short-2" id="executionStartTime1" name="executionStartTime1" placeholder="yyymmdd" required readonly> ~
	          <input type="text" class="short-2" id="executionEndTime1" name="executionEndTime1" placeholder="yyymmdd" required readonly>
	          </div>
	          
	          <div class="">
	            <label for="executionCity1">計畫執行地</label>
	            <select name="executionCity1" id="executionCity1" required>
		        	<option value>請選擇</option>
		        	<c:forEach  items="${cityList}"  var="cityItem"  varStatus="userStatus">
		      			<option value="${cityItem.code}" >${cityItem.name}</option>
		      		</c:forEach>
		        </select>
	          </div>
	          
	          <div class="full">
	          <label for="subject1">課程名稱</label>
	          <input type="text" id="subject1" name="subject1" placeholder="課程名稱" required>
	          </div>
	        
	          <div class="full">
	          <label for="introduction1">課程大綱</label>
	          <textarea class="s" rows="2" id="introduction1" name="introduction1" onkeyup="wordsLimit(this,100)" placeholder="課程大綱  ( 輸入框可拖曳加大範圍 )" required></textarea>
	          </div>
	          
	          <div class="">
	          <label for="executionTime1">預計開課時間</label>
	          <input type="text" id="executionTime1" name="executionTime1" placeholder="00:00~00:00" required>
	          </div>
          
	          <div class="">
	          <label for="speakerName1">講師姓名</label>
	          <input type="text" id="speakerName1" name="speakerName1" placeholder="講師姓名" required>
	          </div>
	        
	          <div class="">
	          <label for="teachingHours1">預計授課時數</label>
	          <input type="number" id="teachingHours1" name="teachingHours1" step="1" min="0" required>
	          </div>
	        
	          <div class="">
	          <label for="participateNumber1">預計參訓人數</label>
	          <input type="number" id="participateNumber1" name="participateNumber1" step="1" min="0" required>
	          </div>
	        
	          <div class="full">
	          <label for="participatePeopleNumber1">預計參訓學員</label>
	          <textarea class="s" rows="1" id="participatePeopleNumber1" name="participatePeopleNumber1" placeholder="預計參訓學員  ( 輸入框可拖曳加大範圍 )" required></textarea>
	          </div>
	          
	          <div class="close"><button type="button" class="close" title="移除此筆資料" onclick="listDelete(this)">X</button></div>
	          
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
            <input type="file" class="select-file" id="uploadListFile" name="uploadListFile" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <button class="upload" onclick="listFileUpload()">上傳檔案</button>
        </div>

      </div>
    
      
    </div>   
    
    <!-------------預計參訓學員------------>
    <div class="form">
    
      <div class="title_main pt-4">
      <span>預計參訓學員</span>
      <em>請視需要自行增刪欄位，若預計參訓學員超過5人請下載
      【<a href="/file/SAMPLE/傳承經驗_參訓學員專用表格.xlsx" title="參訓學員專用Excel表 ( 另存新檔 )">參訓學員專用表格.xlsx</a>】
      填寫後上傳</em>
      </div>
      
      <div class="full">註：本區若使用「上傳專用表格」，參訓學員專用表格.xlsx 上傳成功後，資料內容將會直接呈現於網頁欄位。</div>
      
      <div id="page_tab">
        <div class="tab-1" id="participate"><a class="in color-2">線上填寫資料</a></div>
        <div class="tab-1" id="participateList"><a>上傳專用表格</a></div>
      </div>
      
      
      <div class="staff" id="participateTable">
      	<form id="participateListForm">
        <ol class="staff">
        <c:choose><c:when test="${participateLists !='[]'}">
	        <c:forEach items="${participateLists}" var="item" varStatus="status">
	        	<li>
		          <div class="ss">
		          <label for="name${status.count}">學員姓名</label>
		          <input type="text" id="name${status.count}" name="name${status.count}" placeholder="學員姓名" value="${item.name }">
		          </div>
		        
		          <div class="ss">
		          <label for="insuranceType${status.count}">保險類型</label>
		          <select id="insuranceType${status.count}" name="insuranceType${status.count}">
		            <option value>請選擇</option>
		            <option value="1" <c:if test="${item.laborProtectionTime.length()==7}">selected</c:if>>勞工保險</option>
	            <option value="2" <c:if test="${item.occupationalAccidentProtectionTime.length()==7}">selected</c:if>>職災保險</option>
		          </select>
		          </div>
		        
		          <div class="ss">
		          <label for="insuranceTime${status.count}">加保日期</label>
		          <input type="text" id="insuranceTime${status.count}" name="insuranceTime${status.count}" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')" readonly value="<c:choose><c:when test="${item.laborProtectionTime.length()==7}">${item.laborProtectionTime}</c:when><c:otherwise>${item.occupationalAccidentProtectionTime}</c:otherwise></c:choose>">
		          </div>
		        
		          <div class="ss">
		          <label for="seniority${status.count}">年資</label>
		          <input type="number" step="1" min="0" class="short-3" id="seniority${status.count}" name="seniority${status.count}" value="${item.seniority }">年
          		  <input type="number" step="1" min="0" max="12" class="short-3" id="seniorityMonth${status.count}" name="seniorityMonth${status.count}" value="${item.seniorityMonth }">月
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
		          <label for="department${status.count}">部門</label>
		          <input type="text" id="department${status.count}" name="department${status.count}" placeholder=" ( 無則免填 )" value="${item.department }">
		          </div>
		        
		          <div class="ss">
		          <label for="workingHours${status.count}">工時類型</label>
		          <select id="workingHours${status.count}" name="workingHours${status.count}">
		            <option value>請選擇</option>
		            <option value="A" <c:if test="${item.workingHours=='A'}">selected</c:if>>全時</option>
	            	<option value="P" <c:if test="${item.workingHours=='P'}">selected</c:if>>部分工時</option>
		          </select>
		          </div>
		          
		          <div class="close"><button type="button" class="close" title="移除此筆資料" onclick="participateDelete(this)">X</button></div>
		          
		        </li>
	        </c:forEach>
	    </c:when><c:otherwise>
        <!---01--->
	        <li>
	          <div class="ss">
	          <label for="name1">學員姓名</label>
	          <input type="text" id="name1" name="name1" placeholder="學員姓名" required>
	          </div>
	        
	          <div class="ss">
	          <label for="insuranceType1">保險類型</label>
	          <select id="insuranceType1" name="insuranceType1" required>
	            <option value>請選擇</option>
	            <option value="1">勞工保險</option>
	            <option value="2">職災保險</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="insuranceTime1">加保日期</label>
	          <input type="text" id="insuranceTime1" name="insuranceTime1" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')" required readonly>
	          </div>
	        
	          <div class="ss">
	          <label for="seniority1">年資</label>
	          <input type="number" step="1" min="0" class="short-3" id="seniority1" name="seniority1" required>年
	          <input type="number" step="1" min="0" max="12" class="short-3" id="seniorityMonth1" name="seniorityMonth1" required>月
	          </div>
	        
	          <div class="ss">
	          <label for="manager1">職務類型</label>
	          <select id="manager1" name="manager1" required>
	            <option value>請選擇</option>
	            <option value="Y">主管</option>
	            <option value="N">非主管</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="department1">部門</label>
	          <input type="text" id="department1" name="department1" placeholder=" ( 無則免填 )">
	          </div>
	        
	          <div class="ss">
	          <label for="workingHours1">工時類型</label>
	          <select id="workingHours1" name="workingHours1" required>
	            <option value>請選擇</option>
	            <option value="A">全時</option>
	            <option value="P">部分工時</option>
	          </select>
	          </div>
	          
	          <div class="close"><button type="button" class="close" title="移除此筆資料" onclick="participateDelete(this)">X</button></div>
	          
	        </li>
	      </c:otherwise></c:choose>
        </ol>
      	</form>
      	
        <div class="btn_box">
          <button class="subjoin" onclick="participateAdd()">＋增加欄位</button>
          <button class="save" onclick="participateSave()">暫存資料</button>
        </div>
      
      </div>
      
      
      <div class="staff_excel" id="participateListTable" style="display:none">
        
        <div class="title text-center mt-3 mb-4 w-100">請上傳「最新完整資料」，每次上傳皆會覆蓋先前資料，請確認後再送出！</div>
        <div class="file_box text-center"> 
            <input type="file" class="select-file" id="uploadParticipateListFile" name="uploadParticipateListFile" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <button class="upload" onclick="participateListFileUpload()">上傳檔案</button>
        </div>

      </div>
    
    </div> 

<!------------ loading 效果 ------------>
    <div id="loader-container" style="display:none;">
    <p id="loadingText">Loading</p>
    </div>

    <div class="page">
      <button onclick="javascript:location.href='teach_03'">回上頁</button>
      <button onclick="totalSave()">暫存資料</button>
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

</body>
</html>