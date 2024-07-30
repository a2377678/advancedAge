<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script src="js/teach_03/teach_03.js"></script>
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
    <h2>申請流程 Step3. 填寫計畫書</h2>
    
    <!---申辦前準備--->
    <h3>請確實填寫資料，如有不實，主管機關可駁回<br>
    申請案或請止補貼，並負法律責任。</h3>
    
    <!-------------僱用資料及計畫說明------------>
    <div class="form">
      <form id="form_step1">
      <div class="title_main"><span>僱用資料及計畫說明</span></div>
        
      <div class="full">
      <label for="items">主要業務/產品/服務</label>
      <input type="text" size="86%" id="items" name="items" value="${plan.items}" maxlength="100" placeholder="含簡述工作型態和業務內容" required>
      </div>
        
      <div class="full">
      <label for="friendlyMeasures">友善高齡者職場措施</label>
      <input type="text" size="86%" id="friendlyMeasures" name="friendlyMeasures" value="${plan.friendlyMeasures}" maxlength="100" placeholder="如：防滑止跌等友善硬體環境、就業輔具或彈性上下班等措施" required>
      </div>
        
      <div class="full">
      <label for="employmentNumber">員工總人數</label>
      <input type="number" step="1" min="0" id="employmentNumber" name="employmentNumber" value="${plan.employmentNumber}" placeholder="自動加總" required readonly>
      </div>
        
      <div class="full">
      <label for="lowerEmploymentNumber">未滿29歲人數</label>
      <input type="number" step="1" min="0" id="lowerEmploymentNumber" name="lowerEmploymentNumber" value="${plan.lowerEmploymentNumber}" required>
      </div>
        
      <div class="full">
      <label for="lowEmploymentNumber">29歲至44歲人數</label>
      <input type="number" step="1" min="0" id="lowEmploymentNumber" name="lowEmploymentNumber" value="${plan.lowEmploymentNumber}" required>
      </div>
        
      <div class="full">
      <label for="middleEmploymentNumber">45歲至64歲人數</label>
      <input type="number" step="1" min="0" id="middleEmploymentNumber" name="middleEmploymentNumber" value="${plan.middleEmploymentNumber}" required>
      </div>
        
      <div class="full">
      <label for="highEmploymentNumber">65歲以上人數</label>
      <input type="number" step="1" min="0" id="highEmploymentNumber" name="highEmploymentNumber" value="${plan.highEmploymentNumber}" required>
      </div>
        
      <div class="full">
      <label for="retirementEmploymentNumber">本計畫申請高齡講師數</label>
      <input type="number" step="1" min="0" id="retirementEmploymentNumber" name="retirementEmploymentNumber" value="${plan.retirementEmploymentNumber}" required>
      </div>
        
      <div class="full">
      <label for="">計畫之必要性 / 可行性</label>
<%--       <input type="text" size="86%" id="planDescription" name="planDescription" onkeyup="wordsLimit(this,100)" value="${plan.planDescription}" placeholder="計畫之必要性及可行性說明" required> --%>
      <textarea id="planDescription" name="planDescription" onkeyup="wordsLimit(this,100)" placeholder="計畫之必要性及可行性說明  ( 輸入框可拖曳加大範圍 )" required>${plan.planDescription.replace("\\n","&#13;&#10;") }</textarea>
      </div>
        
      <div class="full">
        <label for="executionWayS">執行方式 ( 可複選 )</label>
        <span class="px-1"><input type="checkbox" name="executionWayS" id="executionWayS" value="S" <c:if test="${not empty plan.executionWay && plan.executionWay.indexOf('S')!=-1 }">checked</c:if>> 實務技術指導</span>
        <span class="px-1"><input type="checkbox" name="executionWayC" id="executionWayC" value="C" <c:if test="${not empty plan.executionWay && plan.executionWay.indexOf('C')!=-1 }">checked</c:if>> 教育訓練課程講授</span>
        <span class="px-1"><input type="checkbox" name="executionWayO" id="executionWayO" value="O" <c:if test="${not empty plan.executionWay && plan.executionWay.indexOf('O')!=-1 }">checked</c:if>> 其他 ( 請說明 )
          <input type="text" id=executionWayDescription name="executionWayDescription" value="${plan.executionWayDescription}" placeholder=" 請填寫說明">
        </span>
      </div>
        
      <div class="full">
      <label for="planStartTime">預計執行期間</label>
      <input type="text" id="planStartTime" name="planStartTime" value="${plan.planStartTime }" placeholder="yyymmdd" required readonly> ~
      <input type="text" id="planEndTime" name="planEndTime" value="${plan.planEndTime }" placeholder="yyymmdd" required readonly> 止
      </div>
      </form>
    </div>
    
    
      <div class="btn_box">
      <button class="save" onclick="planSave()">暫存資料</button>
      </div> 
    
    <!-------------計畫達成指標及預期效益------------>
    <div class="form">
      <form id="form_step2">
      <div class="title_main"><span>計畫達成指標及預期效益</span></div>
        
      <div class="full">
      <label for="experienceInheritance">預計傳承之內容及時數</label>
      <textarea rows="2" id="experienceInheritance" name="experienceInheritance" onkeyup="wordsLimit(this,300)" placeholder="預計傳承之專業技術、經驗內容、授課時數  ( 輸入框可拖曳加大範圍 )" required>${plan.experienceInheritance.replace("\\n","&#13;&#10;") }</textarea>
      </div>
        
      <div class="full">
      <label for="participate">參加課程或接受指導人次</label>
      <input type="number" step="1" min="0" id="participate" name="participate" value="${plan.participate}" placeholder="參加課程或接受指導人次  ( 輸入框可拖曳加大範圍 )" required>
      </div>
        
      <div class="full">
      <label for="benefit">其他效益說明</label>
      <textarea rows="1" id="benefit" name="benefit" onkeyup="wordsLimit(this,100)" placeholder="無則免填  ( 輸入框可拖曳加大範圍 )">${plan.benefit.replace("\\n","&#13;&#10;") }</textarea>
      </div>
      </form>
    </div>   


    <div class="btn_box">
      <button class="save" onclick="planSave()">暫存資料</button>
    </div> 
    
    
    <!-------------傳承專業技術及經驗之講師名單------------>
    <div class="form">
    
      <div class="title_main">
      <span>傳承專業技術及經驗之講師名單</span>
      <em>請視需要自行增刪欄位，若名單超過5人請下載
      【<a href="/file/SAMPLE/傳承經驗_講師名單專用表格.xlsx" title="講師名單專用Excel表 ( 另存新檔 )">講師名單專用表格.xlsx</a>】
      填寫後上傳</em>
      </div>
      
      
      <div id="page_tab">
        <div class="tab-1" id="employed"><a <c:if test="${plan.attachSpeakerList != 'Y'}">class="in color-2"</c:if>>線上填寫資料</a></div>
        <div class="tab-1" id="list"><a <c:if test="${plan.attachSpeakerList == 'Y'}">class="in color-2"</c:if>>上傳專用表格</a></div>
      </div>
      
      
      <div class="staff" id="employedTable">
      	<form id="listForm">
        <ol class="staff">
        <c:choose><c:when test="${not empty speakerLists}">
	        <c:forEach items="${speakerLists}" var="item" varStatus="status">
	        	<li>
		          <div class="ss">
		          <label for="name${status.count}">勞工姓名</label>
		          <input type="text" id="name${status.count}" name="name${status.count}" value="${item.name }" required>
		          </div>
		          
		          <div class="ss">
		          <label for="birthday${status.count}">出生日期</label>
		          <input type="text" id="birthday${status.count}" name="birthday${status.count}" value="${item.birthday }" placeholder="yyymmdd" required readonly>
		          </div>
	          
		          <div class="ss">
		          <label for="identification${status.count}">身分證字號</label>
		          <input type="text" id="identification${status.count}" name="identification${status.count}" value="${item.identification }" required>
		          </div>
		        
		          <div class="ss">
		          <label for="insuranceType${status.count}">保險類型</label>
		          <select id="insuranceType${status.count}" name="insuranceType${status.count}" required>
		            <option value>請選擇</option>
		            <option value="1" <c:if test="${item.laborProtectionTime.length()==7}">selected</c:if>>勞工保險</option>
		            <option value="2" <c:if test="${item.occupationalAccidentProtectionTime.length()==7}">selected</c:if>>職災保險</option>
		          </select>
		          </div>
		        
		          <div class="ss">
		          <label for="insuranceTime${status.count}">加保日期</label>
		          <input type="text" id="insuranceTime${status.count}" name="insuranceTime${status.count}" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')" value="<c:choose><c:when test="${item.laborProtectionTime.length()==7}">${item.laborProtectionTime}</c:when><c:otherwise>${item.occupationalAccidentProtectionTime}</c:otherwise></c:choose>" required readonly>
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
		          <label for="relatives${status.count}">親等關係</label>
		          <select id="relatives${status.count}" name="relatives${status.count}">
		            <option value>請選擇</option>
		            <option value="N" <c:if test="${item.relatives=='N'}">selected</c:if>>非三親等</option>
		            <option value="Y" <c:if test="${item.relatives=='Y'}">selected</c:if>>三親等內</option>
		          </select>
		          <img src="images/icon_qu.png" class="icon_qu"
		          title="【三親等內】之親屬包含：
配偶、父母、子女、兄弟姊妹、
(外)祖父母、(外)孫子女、
伯、叔、姑、舅、姨、
姪子(女)、外甥(女)、
(外)曾祖父母、(外)曾孫子女">
		          </div>
	        
		          <div class="ss">
		          <label for="workingHours${status.count}">工時類型</label>
		          <select id="workingHours${status.count}" name="workingHours${status.count}">
		            <option value>請選擇</option>
		            <option value="A" <c:if test="${item.workingHours=='A'}">selected</c:if>>全時</option>
		            <option value="P" <c:if test="${item.workingHours=='P'}">selected</c:if>>部分工時</option>
		          </select>
		          </div>
		        
		          <div class="ss">
		          <label for="executionWay${status.count}">計畫執行</label>
		          <select id="executionWay${status.count}" name="executionWay${status.count}">
		            <option value>請選擇</option>
		            <option value="S" <c:if test="${item.executionWay=='S'}">selected</c:if>>教育訓練課程講授</option>
		            <option value="C" <c:if test="${item.executionWay=='C'}">selected</c:if>>實務技術指導</option>
		          </select>
		          </div>
		          <div class="close"><button type="button" class="close" title="移除此筆資料" onclick="listDelete(this)">X</button></div>
		        </li>
	        </c:forEach>
	    </c:when><c:otherwise>
	        <!---01--->
	        <li>
	          <div class="ss">
	          <label for="name1">勞工姓名</label>
	          <input type="text" id="name1" name="name1" required>
	          </div>
	          
	          <div class="ss">
	          <label for="birthday1">出生日期</label>
	          <input type="text" id="birthday1" name="birthday1" placeholder="yyymmdd" required readonly>
	          </div>
          
	          <div class="ss">
	          <label for="identification1">身分證字號</label>
	          <input type="text" id="identification1" name="identification1" maxlength="10" required>
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
	          <input type="text" id="insuranceTime1" name="insuranceTime1" placeholder="yyymmdd" required readonly>
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
	          <label for="relatives1">親等關係</label>
	          <select id="relatives1" name="relatives1" required>
	            <option value>請選擇</option>
	            <option value="N">非三親等</option>
	            <option value="Y">三親等內</option>
	          </select>
	          <img src="images/icon_qu.png" class="icon_qu"
	          title="【三親等內】之親屬包含：
配偶、父母、子女、兄弟姊妹、
(外)祖父母、(外)孫子女、
伯、叔、姑、舅、姨、
姪子(女)、外甥(女)、
(外)曾祖父母、(外)曾孫子女">
	          </div>
	        
	          <div class="ss">
	          <label for="workingHours1">工時類型</label>
	          <select id="workingHours1" name="workingHours1" required>
	            <option value>請選擇</option>
	            <option value="A">全時</option>
	            <option value="P">部分工時</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="executionWay1">計畫執行</label>
	          <select id="executionWay1" name="executionWay1" required>
	            <option value>請選擇</option>
	            <option value="C">教育訓練課程講授</option>
	            <option value="S">實務技術指導</option>
	          </select>
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
            <input type="file" id="uploadFile" name="uploadFile" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <button class="upload" onclick="fileUpload()">上傳檔案</button>
        </div>
		<c:choose><c:when test="${not empty speakerListAttachment}">
	      	<c:forEach items="${speakerListAttachment}" var="item" varStatus="status">
		      	<c:choose>
			      	<c:when test="${item.fileType=='speakerList' }">
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
      <button onclick="javascript:location.href='teach_02'">回上頁</button>
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