<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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
<link rel="stylesheet" href="css/jquery-confirm.min.css" type="text/css">
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
    <h2>申請流程 Step5. 聯合辦理單位</h2>
    
    <!---申辦前準備--->
    <h3>各項目建議可分由各單位填寫，<br>
      主要營業項目等資料可至經濟部商業司全國商工行政服務入口網查詢。</h3>
    
    
    
    <!-------------經費概算表------------>
    <div class="form">
    
      <div class="title_main">
      <span>聯合辦理單位</span>
      <em>請視需要自行增刪欄位，若申請單位超過2家請下載
      【<a href="/file/SAMPLE/退休再就業_聯合辦理單位專用表格.xlsx" title="聯合辦理單位專用Excel表 ( 另存新檔 )">聯合辦理單位專用表格.xlsx</a>】
      填寫後上傳</em>
      </div>
      
      <div class="full">
        <label><input type="radio" name="hasJointUnit" id="hasJointUnit1" value="N" <c:if test="${plan.hasJointUnit=='N'}">checked</c:if>> 無聯合辦理單位</label>
        <label><input type="radio" name="hasJointUnit" id="hasJointUnit2" value="Y" <c:if test="${plan.hasJointUnit=='Y'}">checked</c:if>> 有聯合辦理單位</label>
      </div>
      
      
      <div id="page_tab">
        <div class="tab-1" id="employed"><a <c:if test="${plan.attachBasicData != 'Y'}">class="in color-2"</c:if>>線上填寫資料</a></div>
        <div class="tab-1" id="list"><a <c:if test="${plan.attachBasicData == 'Y'}">class="in color-2"</c:if>>上傳專用表格</a></div>
      </div>
      
      
      <div class="staff" id="listStaff">
      <form id="listForm">
      	<input type="hidden" name="planID" id="planID" value="${plan.id}">
        <ol class="staff">
        <c:choose>
	    <c:when test="${not empty basicDataList}">
	    <c:forEach items="${basicDataList}" var="basicData" varStatus="status">
	        <li>
	          
	          <div>
		          <label for="companyName${status.count}">單位名稱</label>
		          <input type="text" name="companyName${status.count}" id="companyName${status.count}" value="${basicData.companyName}">
	          </div>
	        
	          <div>
		          <label for="seq${status.count}">統一編號</label>
		          <input type="text" name="seq${status.count}" id="seq${status.count}" step="1" min="0" value="${basicData.seq}">
	          </div>

	          <div class="full">
		          <label for="businessItem${status.count}">主要營業項目</label>
		          <textarea class="s" name="businessItem${status.count}" id="businessItem${status.count}" rows="1" placeholder="主要業務、產品、服務項目 ( 輸入框可拖曳加大範圍 )">${basicData.businessItem}</textarea>
	          </div>
	        
	          <div>
	              <label for="industry${status.count}">行業別</label>
	              <select name="industry${status.count}" id="industry${status.count}">
	                <option value>請選擇</option>
		      	    <c:forEach  items="${industryList}"  var="item"  varStatus="userStatus">
		      		  <option value="${item.code}"<c:if test="${basicData.industry==item.code}"> selected</c:if>>${item.name}</option>
		      	    </c:forEach>
	              </select>
	              <a href="https://www.stat.gov.tw/standardindustrialclassification.aspx?n=3144&sms=0&rid=11" target="_blank" title="(另開新視窗)"><img src="images/icon_qu.png" alt="行業別分類說明"></a>
	          </div>
	        
	          <div>
	              <label for="unitSize${status.count}">單位規模</label>
	              <select name="unitSize${status.count}" id="unitSize${status.count}">
	                <option value>請選擇</option>
	                <option value="29人以下" <c:if test="${basicData.unitSize=='29人以下'}">selected</c:if>>29人以下</option>
	                <option value="30~99人" <c:if test="${basicData.unitSize=='30~99人'}">selected</c:if>>30~99人</option>
	                <option value="100~499人" <c:if test="${basicData.unitSize=='100~499人'}">selected</c:if>>100~499人</option>
	                <option value="500人以上" <c:if test="${basicData.unitSize=='500人以上'}">selected</c:if>>500人以上</option>
	                <option value="不明" <c:if test="${basicData.unitSize=='不明'}">selected</c:if>>不明</option>
	              </select>
	          </div>
	        
	          <div class="file_box" id="file_box${status.count}">
		          <c:choose>
			      	<c:when test="${basicData.guaranteeNumber.length()>0}">
				      	<c:forEach items="${fn:split(basicData.guaranteeNumber,';')}" var="item" varStatus="gStatus">
				      		<div class="full">
				      		<c:choose>
								<c:when test="${gStatus.first}">
				    				<label for="guaranteeNumber${status.count}_${gStatus.count}">勞保投保證號</label>
				    				<input type="text" id="guaranteeNumber${status.count}_${gStatus.count}" name="guaranteeNumber${status.count}" value="${item}" <c:if test="${gStatus.first}">required</c:if>>
				    			</c:when>
								<c:otherwise>
									<label for="guaranteeNumber${status.count}_${gStatus.count}"></label>
									<input type="text" id="guaranteeNumber${status.count}_${gStatus.count}" name="guaranteeNumber${status.count}_" value="${item}" <c:if test="${gStatus.first}">required</c:if>>
									<button type="button" class="add" onclick="delGuarantee(${gStatus.count})">－</button>
								</c:otherwise>
						    </c:choose>
							<c:choose>
								<c:when test="${gStatus.last}">
									<button type="button" class="add" onclick="addGuarantee(${gStatus.count})" style>＋</button>
								</c:when>
								<c:otherwise>
						      		<button type="button" class="add" onclick="addGuarantee(${gStatus.count})" style="display:none">＋</button>
						      	</c:otherwise>
					      	</c:choose>
					      </div>
				      	</c:forEach>
			      	</c:when>
			      	<c:otherwise>
					  <div class="full">
				    	<label for="guaranteeNumber${status.count}_1">勞保投保證號</label>
						<input type="text" id="guaranteeNumber${status.count}_1" name="guaranteeNumber${status.count}" required>
				      	<button type="button" class="add" onclick="addGuarantee(this,1)" style>＋</button>
				      </div>
				    </c:otherwise>
			    </c:choose>
	          </div>
	        
	          <div>
		          <label for="principal${status.count}">負責人</label>
		          <input type="text" name="principal${status.count}" id="principal${status.count}" value="${basicData.principal}">
	          </div>
	        
	          <div>
		          <label for="contactName${status.count}">聯絡人</label>
		          <input type="text" name="contactName${status.count}" id="contactName${status.count}" value="${basicData.contactName}">
	          </div>
	        
	          <div>
	          	  <label for="contactPhone${status.count}">聯絡電話</label>
		          <input type="tel" maxlength="3" id="contactWorkPhoneAreaCode${status.count}" name="contactWorkPhoneAreaCode${status.count}" size="2" placeholder="區碼" value="${basicData.contactWorkPhoneAreaCode}"> -
			      <input type="tel" maxlength="8" id="contactWorkPhone${status.count}" name="contactWorkPhone${status.count}" size="12" placeholder="電話號碼" value="${basicData.contactWorkPhone}"> #
			      <input type="tel" maxlength="6" id="contactWorkPhoneExtension${status.count}" name="contactWorkPhoneExtension${status.count}" size="3" placeholder="分機" value="${basicData.contactWorkPhoneExtension}">
	          </div>
	        
	          <div>
		          <label for="">聯絡手機</label>
		          <input type="tel" name="contactPhone${status.count}" id="contactPhone${status.count}" value="${basicData.contactPhone}" pattern="09\d{8}" placeholder="聯絡手機號碼">
	          </div>
	        
	          <div class="full">
		          <label for="email${status.count}">電子信箱</label>
		          <input type="email" name="email${status.count}" id="email${status.count}" value="${basicData.email}">
	          </div>
	        
	        
	          <div>
		          <label for="employeeNumber${status.count}">員工人數</label>
		          <input type="number" name="employeeNumber${status.count}" id="employeeNumber${status.count}" step="1" min="0" value="${basicData.employeeNumber}">
	          </div>
	        
	          <div>
		          <label for="participateNumber${status.count}">預計參與人數</label>
		          <input type="number" name="participateNumber${status.count}" id="participateNumber${status.count}" step="1" min="0" value="${basicData.participateNumber}">
	          </div>
	          
	          <div class="close"><button type="button" class="close" onclick="delItem(this)" title="移除此筆資料">X</button></div>
	          
	        </li>
		</c:forEach>
		</c:when>
		<c:otherwise>
	        <!---01--->
	        <li>
	          
	          <div>
		          <label for="companyName1">單位名稱</label>
		          <input type="text" name="companyName1" id="companyName1">
	          </div>
	        
	          <div>
		          <label for="seq1">統一編號</label>
		          <input type="text" name="seq1" id="seq1" step="1" min="0">
	          </div>

	          <div class="full">
		          <label for="businessItem1">主要營業項目</label>
		          <textarea class="s" name="businessItem1" id="businessItem1" rows="1" placeholder="主要業務、產品、服務項目 ( 輸入框可拖曳加大範圍 )"></textarea>
	          </div>
	        
	          <div>
	              <label for="industry1">行業別</label>
	              <select name="industry1" id="industry1">
	                <option value>請選擇</option>
		      	    <c:forEach  items="${industryList}"  var="item"  varStatus="userStatus">
		      		  <option value="${item.code}">${item.name}</option>
		      	    </c:forEach>
	              </select>
	              <a href="https://www.stat.gov.tw/standardindustrialclassification.aspx?n=3144&sms=0&rid=11" target="_blank" title="(另開新視窗)"><img src="images/icon_qu.png" alt="行業別分類說明"></a>
	          </div>
	        
	          <div>
	              <label for="unitSize1">單位規模</label>
	              <select name="unitSize1" id="unitSize1">
	                <option value>請選擇</option>
	                <option value="29人以下">29人以下</option>
	                <option value="30~99人">30~99人</option>
	                <option value="100~499人">100~499人</option>
	                <option value="500人以上">500人以上</option>
	                <option value="不明">不明</option>
	              </select>
	          </div>
	          <div class="file_box" id="file_box1">
		          <div class="full">
			          <label for="guaranteeNumber1_1">勞保投保證號</label>
					  <input type="text" id="guaranteeNumber1_1" name="guaranteeNumber1" required>
					  <button type="button" class="add" onclick="addGuarantee(this,1)" style>＋</button>
		          </div>
	          </div>
	          <div>
		          <label for="principal1">負責人</label>
		          <input type="text" name="principal1" id="principal1">
	          </div>
	        
	          <div>
		          <label for="contactName1">聯絡人</label>
		          <input type="text" name="contactName1" id="contactName1">
	          </div>
	        
	          <div>
	          	  <label for="contactWorkPhone1">聯絡電話</label>
				  <input type="tel" maxlength="3" id="contactWorkPhoneAreaCode1" name="contactWorkPhoneAreaCode1" size="2" placeholder="區碼"> -
			      <input type="tel" maxlength="8" id="contactWorkPhone1" name="contactWorkPhone1" size="12" placeholder="電話號碼"> #
			      <input type="tel" maxlength="6" id="contactWorkPhoneExtension1" name="contactWorkPhoneExtension1" size="3" placeholder="分機">
	          </div>
	          
	          <div>
		          <label for="contactPhone1">聯絡手機</label>
		          <input type="tel" name="contactPhone1" id="contactPhone1" pattern="09\d{8}" placeholder="聯絡手機號碼">
	          </div>
	        
	          <div class="full">
		          <label for="email1">電子信箱</label>
		          <input type="email" name="email1" id="email1">
	          </div>
	        
	        
	          <div>
		          <label for="employeeNumber1">員工人數</label>
		          <input type="number" name="employeeNumber1" id="employeeNumber1" step="1" min="0">
	          </div>
	        
	          <div>
		          <label for="participateNumber1">預計參與人數</label>
		          <input type="number" name="participateNumber1" id="participateNumber1" step="1" min="0">
	          </div>
	          
	          <div class="close"><button type="button" class="close" onclick="delItem(this)" title="移除此筆資料">X</button></div>
	          
	        </li>
		</c:otherwise>
		</c:choose>


        </ol>
      	</form>
        <div class="btn_box">
          <button class="subjoin" onclick="listAdd();">＋增加欄位</button>
          <button class="save" onclick="saveList('temp','N');">暫存資料</button>
        </div>
      
      </div>
      
      
      <div class="staff_excel" id="listTable" style="display:none">
        
        <div class="title text-center mt-3 mb-4 w-100">請上傳「最新完整資料」，每次上傳皆會覆蓋先前資料，請確認後再送出！</div>
        <div class="file_box text-center"> 
            <input type="file" id="uploadFile" name="uploadFile" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <button class="upload" onclick="fileUpload('Y')">上傳檔案</button>
        </div>
		<c:choose><c:when test="${not empty advancedAgeRetirementReemploymentBasicDataListAttachment}">
	      	<c:forEach items="${advancedAgeRetirementReemploymentBasicDataListAttachment}" var="item" varStatus="status">
		      	<c:choose>
			      	<c:when test="${item.fileType=='advancedAgeRetirementReemploymentBasicDataList' }">
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
      <button onclick="javascript:location.href='career_04'">回上頁</button>
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
<script src="js/career_05/career_05.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
</body>
</html>