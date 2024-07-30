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
    <h2>申請流程 Step4. 填寫經費概算</h2>
    
    <!---申辦前準備--->
    <h3>如有向本部以外之其他機關或向「中高齡者退休後再就業準備訓練補助實施計畫」申請補助應確實查填。<br>
      同時申請多種措施，建議依所申請之措施 ( 如職涯諮詢、就業諮詢、創業諮詢等 ) 分列經費或於說明欄清楚備註。</h3>
    
    
    
    <!-------------經費概算表------------>
    <div class="form">
    
      <div class="title_main">
      <span>申請補助經費概算</span>
      <em>請視需要自行增刪欄位，若申請項目超過10項請下載
      【<a href="/file/SAMPLE/退休再就業_經費概算表.xlsx" title="經費概算專用Excel表 ( 另存新檔 )">經費概算專用表格.xlsx</a>】
      填寫後上傳</em>
      </div>
      
      
      <div id="page_tab">
        <div class="tab-1" id="employed"><a <c:if test="${plan.attachExpenditure != 'Y'}">class="in color-2"</c:if>>線上填寫資料</a></div>
        <div class="tab-1" id="list"><a <c:if test="${plan.attachExpenditure == 'Y'}">class="in color-2"</c:if>>上傳專用表格</a></div>
      </div>
      
      
      <div class="staff" id="listStaff">
	      <form id="listForm">
	      	<input type="hidden" name="planID" id="planID" value="${plan.id}">
	        <ol class="staff">
	        <c:choose>
	        <c:when test="${not empty expenditures}">
	        <c:forEach items="${expenditures}" var="expenditure" varStatus="status">
		        <li>
		          <input type="hidden" name="id${status.count}" id="id${status.count}" value="${expenditure.id}">
		          <div class="s">
		          <label for="planName${status.count}">編列項目</label>
		          <select name="planName${status.count}" id="planName${status.count}" class="planName">
		            <option value>請選擇</option>
		            <option value="個別職涯諮商及輔導費" <c:if test="${expenditure.planName == '個別職涯諮商及輔導費'}">selected</c:if>>1. 諮詢費</option>
		            <option value="講師鐘點費" <c:if test="${expenditure.planName == '講師鐘點費'}">selected</c:if>>2. 講師鐘點費</option>
		            <option value="講師交通費" <c:if test="${expenditure.planName == '講師交通費'}">selected</c:if>>3. 講師交通費</option>
		            <option value="非自有場地費" <c:if test="${expenditure.planName == '非自有場地費'}">selected</c:if>>4. 場地租借費</option>
		            <option value="場地公共意外險" <c:if test="${expenditure.planName == '場地公共意外險'}">selected</c:if>>5. 公共意外險</option>
		            <option value="資料印製費" <c:if test="${expenditure.planName == '資料印製費'}">selected</c:if>>6. 資料印製費</option>
		            <option value="行政費" <c:if test="${expenditure.planName == '行政費'}">selected</c:if>>7. 行政費</option>
		          </select>
		          </div>
		          
		          <div class="s">
		          <label for="unitPrice${status.count}">單價</label>
		          <input type="number" name="unitPrice${status.count}" id="unitPrice${status.count}" value="${expenditure.unitPrice}" step="1" min="0" onchange="calTotal(this);"> 元
		          </div>
		        
		          <div class="s">
		          <label for="amount${status.count}">數量</label>
		          <input type="number" name="amount${status.count}" id="quantity${status.count}" value="${expenditure.amount}" step="1" min="0" onchange="calTotal(this);">
		          </div>
		        
		          <div class="s">
		          <label for="total${status.count}">總價</label>
		          <input type="text" name="total${status.count}" id="total${status.count}" class="readonly" placeholder="填寫完自動計算" readonly> 元
		          </div>
		        
		          <div class="s">
		          <label for="amounts${status.count}">申請本計畫補助</label>
		          <input type="number" name="amounts${status.count}" id="amounts${status.count}" value="${expenditure.amounts}" step="1" min="0"> 元
		          </div>
		        
		          <div class="s">
		          <label for="other_amounts${status.count}">申請其他單位補助</label>
		          <input type="number" name="otherAmounts${status.count}" id="otherAmounts${status.count}" value="${expenditure.otherAmounts}" step="1" min="0" placeholder=" ( 無則免填 )"> 元
		          </div>
		        
		          <div class="full">
		          <label for="description${status.count}">備註與說明</label>
		          <textarea class="s" name="description${status.count}" id="description${status.count}" rows="2" placeholder=" ( 輸入框可拖曳加大範圍 )">${expenditure.description}</textarea>
		          </div>
		          
		          <div class="close"><button type="button" class="close" onclick="delItem(this);" title="移除此筆資料">X</button></div>
		          
		        </li>
			</c:forEach>
			</c:when>
			<c:otherwise>
		        <!---01--->
		        <li>
		          <div class="s">
		          <label for="planName1">編列項目</label>
		          <select name="planName1" id="planName1" class="planName">
		            <option value>請選擇</option>
		            <option value="個別職涯諮商及輔導費">1. 諮詢費</option>
		            <option value="講師鐘點費">2. 講師鐘點費</option>
		            <option value="講師交通費">3. 講師交通費</option>
		            <option value="非自有場地費">4. 場地租借費</option>
		            <option value="場地公共意外險">5. 公共意外險</option>
		            <option value="資料印製費">6. 資料印製費</option>
		            <option value="行政費">7. 行政費</option>
		          </select>
		          </div>
		          
		          <div class="s">
		          <label for="unitPrice1">單價</label>
		          <input type="number" name="unitPrice1" id="unitPrice1" step="1" min="0" onchange="calTotal(this);"> 元
		          </div>
		        
		          <div class="s">
		          <label for="amount1">數量</label>
		          <input type="number" name="amount1" id="quantity1" step="1" min="0" onchange="calTotal(this);">
		          </div>
		        
		          <div class="s">
		          <label for="total1">總價</label>
		          <input type="text" name="total1" id="total1" class="readonly" placeholder="填寫完自動計算" readonly> 元
		          </div>
		        
		          <div class="s">
		          <label for="amounts1">申請本計畫補助</label>
		          <input type="number" name="amounts1" id="amounts1"  step="1" min="0"> 元
		          </div>
		        
		          <div class="s">
		          <label for="other_amounts1">申請其他單位補助</label>
		          <input type="number" name="otherAmounts1" id="otherAmounts1" step="1" min="0" placeholder=" ( 無則免填 )"> 元
		          </div>
		        
		          <div class="full">
		          <label for="description1">備註與說明</label>
		          <textarea class="s" name="description1" id="description1" rows="2" placeholder=" ( 輸入框可拖曳加大範圍 )"></textarea>
		          </div>
		          
		          <div class="close"><button type="button" class="close" onclick="delItem(this);" title="移除此筆資料">X</button></div>
		          
		        </li>
		        
		        <!---02--->
<!-- 		        <li> -->
<!-- 		          <div class="s"> -->
<!-- 		          <label for="planName2">編列項目</label> -->
<!-- 		          <select name="planName2" id="planName2"> -->
<!-- 		            <option value>請選擇</option> -->
<!-- 		            <option value="個別職涯諮商及輔導費">1. 諮詢費</option> -->
<!-- 		            <option value="講師鐘點費">2. 講師鐘點費</option> -->
<!-- 		            <option value="講師交通費">3. 講師交通費</option> -->
<!-- 		            <option value="非自有場地費">4. 場地租借費</option> -->
<!-- 		            <option value="場地公共意外險">5. 公共意外險</option> -->
<!-- 		            <option value="資料印製費">6. 資料印製費</option> -->
<!-- 		            <option value="行政費">7. 行政費</option> -->
<!-- 		          </select> -->
<!-- 		          </div> -->
		          
<!-- 		          <div class="s"> -->
<!-- 		          <label for="unitPrice2">單價</label> -->
<!-- 		          <input type="number" name="unitPrice2" id="unitPrice2" step="1" min="0" onchange="calTotal(this);"> 元 -->
<!-- 		          </div> -->
		        
<!-- 		          <div class="s"> -->
<!-- 		          <label for="amount2">數量</label> -->
<!-- 		          <input type="number" name="amount2" id="quantity2" step="1" min="0" onchange="calTotal(this);"> -->
<!-- 		          </div> -->
		        
<!-- 		          <div class="s"> -->
<!-- 		          <label for="total2">總價</label> -->
<!-- 		          <input type="text" name="total2" id="total2" class="readonly" placeholder="填寫完自動計算" readonly> 元 -->
<!-- 		          </div> -->
		        
<!-- 		          <div class="s"> -->
<!-- 		          <label for="amounts2">申請本計畫補助</label> -->
<!-- 		          <input type="number" name="amounts2" id="amounts2"  step="1" min="0"> 元 -->
<!-- 		          </div> -->
		        
<!-- 		          <div class="s"> -->
<!-- 		          <label for="other_amounts2">申請其他單位補助</label> -->
<!-- 		          <input type="number" name="otherAmounts2" id="otherAmounts2" step="1" min="0" placeholder=" ( 無則免填 )"> 元 -->
<!-- 		          </div> -->
		        
<!-- 		          <div class="full"> -->
<!-- 		          <label for="description2">備註與說明</label> -->
<!-- 		          <textarea class="s" name="description2" id="description2" rows="2" placeholder=" ( 輸入框可拖曳加大範圍 )"></textarea> -->
<!-- 		          </div> -->
		          
<!-- 		          <div class="close"><button type="button" class="close" onclick="delItem(this);" title="移除此筆資料">X</button></div> -->
		          
<!-- 		        </li> -->
			</c:otherwise>
			</c:choose>
	
	
	
	        </ol>
	      </form>
        <div class="btn_box">
          <button class="subjoin" onclick="listAdd();">＋增加欄位</button>
          <button class="save" onclick="saveList('temp', 'N')">暫存資料</button>
        </div>
      
      </div>
      
      
      <div class="staff_excel" id="listTable" style="display:none">
        
        <div class="title text-center mt-3 mb-4 w-100">請上傳「最新完整資料」，每次上傳皆會覆蓋先前資料，請確認後再送出！</div>
        <div class="file_box text-center"> 
            <input type="file" id="uploadFile" name="uploadFile" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <button class="upload" onclick="fileUpload('Y')">上傳檔案</button>
        </div>
		<c:choose><c:when test="${not empty advancedAgeRetirementReemploymentExpenditureAttachment}">
	      	<c:forEach items="${advancedAgeRetirementReemploymentExpenditureAttachment}" var="item" varStatus="status">
		      	<c:choose>
			      	<c:when test="${item.fileType=='advancedAgeRetirementReemploymentExpenditure'}">
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
      <button onclick="javascript:location.href='career_03'">回上頁</button>
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
<script src="js/career_04/career_04.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
</body>
</html>