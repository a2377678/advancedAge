<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
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

<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/gotop.js"></script>
<script src="js/teach_02/teach_02.js"></script>

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
    <h2>申請流程 Step2. 填寫申請書</h2>
    
    <!---申辦前準備--->
    <h3>請確實填寫資料，如有不實，主管機關可駁回<br>
    申請案或停止補貼，並負法律責任。</h3>
    
    <form id="form" action="teach_03" method="post">
    <div class="form">
    
      <div class="title_main"><span>申請單位資料</span></div>
      
      <div>
      <label for="companyName">單位名稱</label>
      <input type="text" size="35" id="companyName" name="companyName" <c:if test="${empty apply.companyName}">value="${companyInfoData.get('companyName')}"</c:if><c:if test="${not empty apply.companyName}">value="${apply.companyName}"</c:if> required>
      </div>
        
      <div>
      <label for="seq">統一編號</label>
      <input type="text" pattern="\d{8}" minlength="8" maxlength="8" id="seq" name="seq" <c:if test="${empty companyInfoData.get('seq')}">value="${apply.seq}"</c:if><c:if test="${not empty companyInfoData.get('seq')}">value="${companyInfoData.get('seq')}"</c:if> required>
      </div>
        
      <div>
      <label for="industry">行業別</label>
      <select name="industry" id="industry" required>
      	<option value>請選擇</option>
      	<c:if test="${not empty apply.industry}">
	      	<c:forEach  items="${industryList}"  var="item"  varStatus="userStatus">
	      		<option value="${item.code}" <c:if test="${apply.industry==item.code}">selected</c:if> >${item.name}</option>
	      	</c:forEach>
      	</c:if>
      	<c:if test="${empty apply.industry}">
      		<c:forEach  items="${industryList}"  var="item"  varStatus="userStatus">
	      		<option value="${item.code}" <c:if test="${companyInfoData.get('industry')==item.code}">selected</c:if> >${item.name}</option>
	      	</c:forEach>
      	</c:if>
      </select>
      <a href="https://www.stat.gov.tw/standardindustrialclassification.aspx?n=3144&sms=0&rid=11" target="_blank" title="(另開新視窗)"><img src="images/icon_qu.png" alt="行業別分類說明"></a>
      </div>
        
      <div>
        <label for="companyAttributes">單位屬性</label>
        <select name="companyAttributes" id="companyAttributes" required>
          <option value>請選擇</option>
          <option value="B" <c:if test="${apply.companyAttributes=='B'}">selected</c:if>>民營事業單位</option>
          <option value="G" <c:if test="${apply.companyAttributes=='G'}">selected</c:if>>民間團體</option>
          <option value="S" <c:if test="${apply.companyAttributes=='S'}">selected</c:if>>私立學校</option>
        </select>
      </div>
        
      <div class="full" id="guaranteeDiv">
      	<c:choose>
	      	<c:when test="${apply.guaranteeNumber.length()>0}">
		      	<c:forEach items="${fn:split(apply.guaranteeNumber,';')}" var="item" varStatus="status">
		      		<div class="full">
		      		<c:choose>
						<c:when test="${status.first}">
		    				<label for="guaranteeNumber${status.count}">勞保投保證號</label>
		    				<input type="text" id="guaranteeNumber${status.count}" name="guaranteeNumber" value="${item}" <c:if test="${status.first}">required</c:if>>
		    			</c:when>
						<c:otherwise>
							<label for="guaranteeNumber${status.count}"></label>
							<input type="text" id="guaranteeNumber${status.count}" name="guaranteeNumber" value="${item}" <c:if test="${status.first}">required</c:if>>
							<button type="button" class="add" onclick="delGuarantee(${status.count})">－</button>
						</c:otherwise>
				    </c:choose>
					<c:choose>
						<c:when test="${status.last}">
							<button type="button" class="add" onclick="addGuarantee(${status.count})" style>＋</button>
						</c:when>
						<c:otherwise>
				      		<button type="button" class="add" onclick="addGuarantee(${status.count})" style="display:none">＋</button>
				      	</c:otherwise>
			      	</c:choose>
			      </div>
		      	</c:forEach>
	      	</c:when>
	      	<c:otherwise>
			  <div class="full">
		    	<label for="guaranteeNumber1">勞保投保證號</label>
				<input type="text" id="guaranteeNumber1" name="guaranteeNumber" required>
		      	<button type="button" class="add" onclick="addGuarantee(1)" style>＋</button>
		      </div>
		    </c:otherwise>
	    </c:choose>
      </div>
      
      <div class="full">
	      <label for="registerCity">登記地址</label>
	      <select name="registerCity" id="registerCity" required>
	        <option value>請選擇</option>
	        <c:if test="${not empty  apply.registerCity}">
	        	<c:forEach  items="${cityList}"  var="item"  varStatus="userStatus">
		      		<option value="${item.code}" <c:if test="${apply.registerCity==item.code}">selected</c:if>>${item.name}</option>
		      	</c:forEach>
	        </c:if>
	        <c:if test="${empty apply.registerCity}">
	      		<c:forEach  items="${cityList}"  var="item"  varStatus="userStatus">
		      		<option value="${item.code}" <c:if test="${companyInfoData.get('registerCity')==item.code}">selected</c:if> >${item.name}</option>
		      	</c:forEach>
	      	</c:if>
	      </select>
	      <select name="registerArea" id="registerArea" required>
	        <option value>請選擇</option>
	        <c:if test="${not empty apply.registerArea}">
		        <c:forEach  items="${registerAreaList}"  var="item"  varStatus="userStatus">
		      		<option value="${item.code}" <c:if test="${apply.registerArea==item.code}">selected</c:if>>${item.name}</option>
		      	</c:forEach>
		    </c:if>
		    <c:if test="${empty apply.registerArea}">
		        <c:forEach  items="${companyRegisterAreaList}"  var="item"  varStatus="userStatus">
		      		<option value="${item.code}" <c:if test="${companyInfoData.get('registerArea')==item.code}">selected</c:if>>${item.name}</option>
		      	</c:forEach>
		    </c:if>
	      </select>
	      <input type="text" id="registerAddress" name="registerAddress" size="60%" placeholder="請填寫詳細地址" <c:if test="${not empty apply.registerAddress}">value="${apply.registerAddress}"</c:if><c:if test="${empty apply.registerAddress}">value="${companyInfoData.get('registerAddress')}"</c:if> required>
      </div>
      
      <div class="full">
	      <label for="contactCity">聯絡地址</label>
	      <select name="contactCity" id="contactCity" required>
	        <option value>請選擇</option>
	        <c:if test="${not empty apply.contactCity}">
		        <c:forEach  items="${cityList}"  var="item"  varStatus="userStatus">
		      		<option value="${item.code}" <c:if test="${apply.contactCity==item.code}">selected</c:if>>${item.name}</option>
		      	</c:forEach>
	      	</c:if>
	      	<c:if test="${empty apply.contactCity}">
		        <c:forEach  items="${cityList}"  var="item"  varStatus="userStatus">
		      		<option value="${item.code}" <c:if test="${companyInfoData.get('contactCity')==item.code}">selected</c:if>>${item.name}</option>
		      	</c:forEach>
	      	</c:if>
	      </select>
	      <select name="contactArea" id="contactArea" required>
	        <option value>請選擇</option>
	        <c:if test="${not empty apply.contactArea}">
		        <c:forEach  items="${contactAreaList}"  var="item"  varStatus="userStatus">
		      		<option value="${item.code}" <c:if test="${apply.contactArea==item.code}">selected</c:if>>${item.name}</option>
		      	</c:forEach>
		    </c:if>
		    <c:if test="${empty apply.contactArea}">
		        <c:forEach  items="${companyContactAreaList}"  var="item"  varStatus="userStatus">
		      		<option value="${item.code}" <c:if test="${companyInfoData.get('contactArea')==item.code}">selected</c:if>>${item.name}</option>
		      	</c:forEach>
		    </c:if>
	      </select>
	      <input type="text" id="contactAddress" name="contactAddress" size="60%" placeholder="請填寫詳細地址" <c:if test="${not empty apply.contactAddress}">value="${apply.contactAddress}"</c:if><c:if test="${empty apply.contactAddress}">value="${companyInfoData.get('contactAddress')}"</c:if> required>
	      <label for="checkbox" style="display:none"></label>
		  <input type="checkbox" name="checkbox" id="checkbox">
	      同登記地址
      </div>
        
      <div>
      <label for="contactName">聯絡人</label>
      <input type="text" id="contactName" name="contactName" <c:if test="${not empty apply.contactName}">value="${apply.contactName}"</c:if><c:if test="${empty apply.contactName}">value="${companyInfoData.get('contactName')}"</c:if> required>
      </div>
        
      <div>
      <label for="contactJobtitle">聯絡人職稱</label>
      <input type="text" id="contactJobtitle" name="contactJobtitle" <c:if test="${not empty apply.contactJobtitle}">value="${apply.contactJobtitle}"</c:if><c:if test="${empty apply.contactJobtitle}">value="${companyInfoData.get('contactJobtitle')}"</c:if> required>
      </div>
        
      <div>
      <label for="contactWorkPhoneAreaCode">聯絡電話</label>
      <input type="tel" maxlength="3" id="contactWorkPhoneAreaCode" name="contactWorkPhoneAreaCode" size="2" placeholder="區碼" <c:if test="${not empty apply.contactWorkPhoneAreaCode}">value="${apply.contactWorkPhoneAreaCode}"</c:if><c:if test="${empty apply.contactWorkPhoneAreaCode}">value="${companyInfoData.get('contactWorkPhoneAreaCode')}"</c:if> required> -
      <input type="tel" maxlength="8" id="contactWorkPhone" name="contactWorkPhone" size="12" placeholder="電話號碼" <c:if test="${not empty apply.contactWorkPhone}">value="${apply.contactWorkPhone}"</c:if><c:if test="${empty apply.contactWorkPhone}">value="${companyInfoData.get('contactWorkPhone')}"</c:if> required> #
      <input type="tel" maxlength="6" id="contactWorkPhoneExtension" name="contactWorkPhoneExtension" size="3" placeholder="分機" <c:if test="${not empty apply.contactWorkPhoneExtension}">value="${apply.contactWorkPhoneExtension}"</c:if><c:if test="${empty apply.contactWorkPhoneExtension}">value="${companyInfoData.get('contactWorkPhoneExtension')}"</c:if>>
      </div>
        
      <div>
      <label for="contactPhone">行動電話</label>
      <input type="tel" id="contactPhone" name="contactPhone" pattern="09\d{8}" <c:if test="${not empty apply.contactPhone}">value="${apply.contactPhone}"</c:if><c:if test="${empty apply.contactPhone}">value="${companyInfoData.get('contactPhone')}"</c:if> required>
      </div>
        
      <div>
      <label for="faxAreaCode">傳真號碼</label>
      <input type="tel" maxlength="3" id="faxAreaCode" name="faxAreaCode" size="2" placeholder="區碼" <c:if test="${not empty apply.faxAreaCode}">value="${apply.faxAreaCode}"</c:if><c:if test="${empty apply.faxAreaCode}">value="${companyInfoData.get('faxAreaCode')}"</c:if> > -
      <input type="tel" maxlength="8" id="fax" name="fax" size="12" placeholder="傳真號碼" <c:if test="${not empty apply.fax}">value="${apply.fax}"</c:if><c:if test="${empty apply.fax}">value="${companyInfoData.get('fax')}"</c:if> >
      </div>
        
      <div>
      <label for="email">電子信箱</label>
      <input type="email" id="email" name="email" <c:if test="${not empty apply.email}">value="${apply.email}"</c:if><c:if test="${empty apply.email}">value="${companyInfoData.get('email')}"</c:if> required>
      </div>
      
      <div class="affidavit">
        <div>資格條件及切結事項</div>
        <ol>
          <li>
          <label class="title" for="multipleCompany0">本統一編號/非營利扣繳編號是否有其他子公司或母公司？(有母子公司人數請合併計算)</label>
          <label class="s"><input type="radio" name="multipleCompany" value="Y" id="multipleCompany0" <c:if test="${apply.multipleCompany=='Y'}">checked</c:if> required>有</label>
          <label class="s"><input type="radio" name="multipleCompany" value="N" id="multipleCompany1" <c:if test="${apply.multipleCompany=='N'}">checked</c:if>>無</label>
          </li>
        
          <li>
          <label class="title" for="workersEmployment0">本單位僱用勞工總人數達3人以上？ ( 配偶或三等親之內勞工不列入人數計算 )</label>
          <label class="s"><input type="radio" name="workersEmployment" value="Y" id="workersEmployment0" <c:if test="${apply.workersEmployment=='Y'}">checked</c:if> required>是</label>
          <label class="s"><input type="radio" name="workersEmployment" value="N" id="workersEmployment1" <c:if test="${apply.workersEmployment=='N'}">checked</c:if>>否</label>
          </li>
        
          <li>
          <label class="title" for="relatives0">申請本計畫之所僱用高齡者，是否為雇主之配偶或三等親內之親屬？</label>
          <label class="s"><input type="radio" name="relatives" value="Y" id="relatives0" <c:if test="${apply.relatives=='Y'}">checked</c:if> required>是</label>
          <label class="s"><input type="radio" name="relatives" value="N" id="relatives1" <c:if test="${apply.relatives=='N'}">checked</c:if>>否</label>
          </li>
        
          <li>
          <label class="title" for="relatedAmounts0">本單位申請本計畫時曾領取政府機關與本計畫屬性相同之津貼？</label>
          <label class="s"><input type="radio" name="relatedAmounts" value="Y" id="relatedAmounts0" <c:if test="${apply.relatedAmounts=='Y'}">checked</c:if> required>有</label>
          <label class="s"><input type="radio" name="relatedAmounts" value="N" id="relatedAmounts1" <c:if test="${apply.relatedAmounts=='N'}">checked</c:if>>無</label>
          </li>
        </ol>
      </div>
        
    </div>
	</form>
    <div class="page">
      <button onclick="save()">暫存資料</button>
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