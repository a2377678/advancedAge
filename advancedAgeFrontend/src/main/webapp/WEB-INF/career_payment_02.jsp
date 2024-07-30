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
        <li class="breadcrumb-item active" aria-current="page">中高齡者退休後再就業準備協助措施 - 請領作業</li>
      </ol>
    </nav>
    <h1>中高齡者退休後再就業準備協助措施 - 請領作業</h1>
    <h2>請領流程 Step2. 填寫成果報告</h2>
    
    <!---申辦前準備--->
    <h3>請確實填寫資料，如有不實，主管機關可駁回<br>
    申請案或請止補貼，並負法律責任。</h3>
    <form id="form">
    <!-------------基本資料------------>
    <div class="form">
    
      <div class="title_main"><span>基本資料</span></div>
        
        <div>
        <label for="contactName">聯絡人</label>
        <input type="text" id="contactName" name="contactName" <c:if test="${not empty result.contactName}">value="${result.contactName }"</c:if> <c:if test="${empty result.contactName}">value="${apply.contactName }"</c:if> required>
        </div>
          
        <div>
        <label for="">聯絡人職稱</label>
        <input type="text" id="contactJobtitle" name="contactJobtitle" <c:if test="${not empty result.contactJobtitle}">value="${result.contactJobtitle }"</c:if> <c:if test="${empty result.contactJobtitle}">value="${apply.contactJobtitle }"</c:if> required>
        </div>
          
        <div>
        <label for="contactWorkPhoneAreaCode">聯絡電話</label>
	    <input type="tel" maxlength="3" id="contactWorkPhoneAreaCode" name="contactWorkPhoneAreaCode" size="2" placeholder="區碼"  <c:if test="${not empty result.contactWorkPhoneAreaCode}">value="${result.contactWorkPhoneAreaCode }"</c:if> <c:if test="${empty result.contactWorkPhoneAreaCode}">value="${apply.contactWorkPhoneAreaCode }"</c:if> required> -
	    <input type="tel" maxlength="8" id="contactWorkPhone" name="contactWorkPhone" size="12" placeholder="電話號碼" <c:if test="${not empty result.contactWorkPhone}">value="${result.contactWorkPhone }"</c:if> <c:if test="${empty result.contactWorkPhone}">value="${apply.contactWorkPhone }"</c:if> required> #
	    <input type="tel" maxlength="6" id="contactWorkPhoneExtension" name="contactWorkPhoneExtension" size="3" placeholder="分機" <c:if test="${not empty result.contactWorkPhoneExtension}">value="${result.contactWorkPhoneExtension }"</c:if> <c:if test="${empty result.contactWorkPhoneExtension}">value="${apply.contactWorkPhoneExtension }"</c:if>>
        </div>
          
        <div>
        <label for="contactPhone">行動電話</label>
        <input type="tel" id="contactPhone" name="contactPhone" pattern="09\d{8}" <c:if test="${not empty result.contactPhone}">value="${result.contactPhone }"</c:if> <c:if test="${empty result.contactPhone}">value="${apply.contactPhone }"</c:if> required>
      	</div>
          
        <div>
        <label for="fax">傳真號碼</label>
        <input type="tel" maxlength="3" id="faxAreaCode" name="faxAreaCode" size="2" placeholder="區碼" <c:if test="${not empty result.faxAreaCode}">value="${result.faxAreaCode }"</c:if> <c:if test="${empty result.faxAreaCode}">value="${apply.faxAreaCode }"</c:if> > -
        <input type="tel" maxlength="8" id="fax" name="fax" size="12" placeholder="傳真號碼" <c:if test="${not empty result.fax}">value="${result.fax }"</c:if> <c:if test="${empty result.fax}">value="${apply.fax }"</c:if> >
        </div>
          
        <div>
        <label for="email">電子信箱</label>
        <input type="email" id="email" name="email" <c:if test="${not empty result.email}">value="${result.email }"</c:if> <c:if test="${empty result.email}">value="${apply.email }"</c:if> required>
        </div>
        
      	<div class="">
     	<label for="approveAmounts">核定補助金額</label>
      	<input type="number" id="approveAmounts" name="approveAmounts" value="${base.allowanceApproveAmounts }" step="1" min="0" size="50%" required>
      	</div>
        
	    <div class="">
	    <label for="realAmounts">實支金額</label>
	    <input type="number" id="realAmounts" name="realAmounts" value="${result.realAmounts }" step="1" min="0" size="50%" required>
	    </div>
      
    </div>
    
    
      <div class="btn_box">
      <button class="save" type="button" onclick="save()">暫存資料</button>
      </div>  


    <!-------------計畫實施情形------------>
    <div class="form">
    
      <div class="title_main"><span>計畫實施情形</span></div>
        
      <div class="full">
      <label for="planExecutionSituation">辦理情形</label>
      <textarea rows="5" id="planExecutionSituation" name="planExecutionSituation" οnkeyup="wordsLimit(this,100)" maxlength="100" placeholder="含課程內容、時數、受益人次等  ( 輸入框可拖曳加大範圍 )">${result.planExecutionSituation.replace("\\n","&#13;&#10;") }</textarea>
      </div>
        
      <div class="full">
      <label for="result">實施成果</label>
      <textarea rows="5" id="result" name="result" οnkeyup="wordsLimit(this,100)" maxlength="100" placeholder="含效益、特色、影響、服務對象滿意度，檢視是否達成預期指標及效益  ( 輸入框可拖曳加大範圍 )">${result.result.replace("\\n","&#13;&#10;") }</textarea>
      </div>
        
      <div class="full">
      <label for="suggestion">檢討與建議</label>
      <textarea rows="5" id="suggestion" name="suggestion" οnkeyup="wordsLimit(this,100)" maxlength="100" placeholder=" ( 輸入框可拖曳加大範圍 )">${result.suggestion.replace("\\n","&#13;&#10;") }</textarea>
      </div>
      
    </div>
    </form>
    
      <div class="btn_box">
      <button class="save" type="button" onclick="save()">暫存資料</button>
      </div>    
    
    
    <div class="page">
      <button onclick="javascript:location.href='career_payment_01'">回上頁</button>
      <button type="button" onclick="save()">暫存資料</button>
      <button type="button" onclick="next()">下一步</button>
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
<script src="js/gotop.js"></script>
<script src="js/career_payment_02/career_payment_02.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
</body>
</html>