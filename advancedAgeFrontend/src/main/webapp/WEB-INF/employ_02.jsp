<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<html lang="zh-hant-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>中高齡就業相關補助計畫</title>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/template.css" type="text/css">
<link rel="stylesheet" href="css/main.css" type="text/css">

<link rel="stylesheet" href="css/cmxform.css" type="text/css">

<!-- Select2 CSS --> 
<link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css" rel="stylesheet"  type="text/css"/>
</head>

<body>
<div class=""> 
  
  <!--- header --->
  <%@ include file="header.jsp" %>
<!--   <header> -->
<!--     <div class="navigation"> -->
<!--       <div class="top_logo"><img src="images/top_logo.png"></div> -->
<!--       <nav> -->
<!--         <ul> -->
<!--         　　<li><a href="employ" title="帳號申請／登入">帳號申請／登入</a></li> -->
<!--         　　<li><a href="#" title="網站導覽">網站導覽</a></li> -->
<!--         </ul> -->
<!--       </nav> -->
<!--     </div> -->
    
<!--     - nav - -->
<!--     <nav class="main_menu"> -->
<!--       <ul> -->
<!--         <li><a href="index" title="首頁" class="m1">首頁</a></li> -->
<!--         <li><a href="require" title="補助計畫" class="m2">補助計畫</a></li> -->
<!--         <li><a href="employ" title="線上申辦" class="m3-in in">線上申辦</a></li> -->
<!--         <li><a href="#" title="案件查詢" class="m4">案件查詢</a></li> -->
<!--         <li><a href="#" title="申請教學" class="m5">申請教學</a></li> -->
<!--         <li><a href="#" title="資料下載" class="m6">資料下載</a></li> -->
<!--         <li><a href="#" title="諮詢服務" class="m7">諮詢服務</a></li> -->
<!--       </ul> -->
<!--     </nav> -->
<!--     - nav end -  -->
    
<!--   </header> -->
  <!--- header end ---> 
  
  <!--- main --->
  <div class="main"> 
    
  <!------------ 申請流程 ------------>
  <div class="apply_main">
    <h1>繼續僱用高齡者補助計畫</h1>
    <h2>申請流程 Step2. 填寫申請書</h2>
    
    <!---備妥項目
    <div class="notice">
      <div>您是否已備妥下列項目了呢 ?</div>
      <ol>
        <li>工商憑證與讀卡機</li>
        <li>設立登記證明文件</li>
        <li>投保或職災保險證明文件</li>
        <li>繼續僱用者近3個月薪資證明文件</li>
      </ol>
    </div>--->
    
    <!---申辦前準備--->
    <h3>請確實填寫資料，如有不實，主管機關可駁回<br>
    申請案或停止補貼，並負法律責任。</h3>
    
    <form id="form" action="employ_03" method="post">
    <div class="form">
    
      <div class="title_main"><span>申請單位資料</span></div>
      
      <div>
      <label for="companyName">單位名稱</label>
      <input type="text" size="35" id="companyName" name="companyName" value="${apply.companyName}" required>
      </div>
        
      <div>
      <label for="seq">統一編號</label>
      <input type="text" pattern="\d{8}" minlength="8" maxlength="8" id="seq" name="seq" value="${apply.seq}" required>
      </div>
      
      <!---<div>
      <label for="">負責人</label>
      <input type="text">
      </div>--->
        
      <div>
      <label for="industry">行業別</label>
      <select name="industry" id="industry" required>
      	<option value>請選擇</option>
      	<c:forEach  items="${industryList}"  var="item"  varStatus="userStatus">
      		<option value="${item.code}" <c:if test="${apply.industry==item.code}">selected</c:if> >${item.name}</option>
      	</c:forEach>
<!--         <option>農、林、漁、牧業</option> -->
<!--         <option>礦業及土石採取業</option> -->
<!--         <option>製造業</option> -->
<!--         <option>電力及燃氣供應業</option> -->
<!--         <option>營建工程業</option> -->
<!--         <option>用水供應及汙染整治業</option> -->
<!--         <option>批發及零售業</option> -->
<!--         <option>運輸及倉儲業</option> -->
<!--         <option>住宿及餐飲業</option> -->
<!--         <option>出版、影音製作、傳播及資通訊服務業</option> -->
<!--         <option>金融及保險業</option> -->
<!--         <option>不動產業</option> -->
<!--         <option>專業、科學及技術服務業</option> -->
<!--         <option>支援服務業</option> -->
<!--         <option>公共行政及國防；強制性社會安全</option> -->
<!--         <option>教育業</option> -->
<!--         <option>醫療保健及社會工作服務業</option> -->
<!--         <option>藝術、娛樂及休閒服務業</option> -->
<!--         <option>其他服務業</option> -->
      </select>
      <a href="https://mobile.stat.gov.tw/StandardIndustrialQuery.aspx" target="_blank" title="(另開新視窗)"><img src="images/icon_qu.png" alt="行業別分類說明"></a> 
      </div>
        
      <div class="file_box">
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
      <!---  
      <div class="full">
      <label for="">登記地址</label>
      <select name="city" id="">
        <option>請選擇</option>
        <option>台北市</option>
        <option>新北市</option>
      </select>
      <select name="area" id="">
        <option>請選擇</option>
        <option>中正區</option>
        <option>松山區</option>
      </select>
      <input name="input" type="text" id="" size="65%" placeholder="請填寫詳細地址">
      </div>--->
        
      <div class="full">
      <label for="contactCity">聯絡地址</label>
      <select name="contactCity" id="contactCity" required>
        <option value>請選擇</option>
        <c:forEach  items="${cityList}"  var="item"  varStatus="userStatus">
      		<option value="${item.code}" <c:if test="${apply.contactCity==item.code}">selected</c:if>>${item.name}</option>
      	</c:forEach>
<!--         <option>台北市</option> -->
<!--         <option>新北市</option> -->
      </select>
      <select name="contactArea" id="contactArea" required>
        <option value>請選擇</option>
        <c:forEach  items="${areaList}"  var="item"  varStatus="userStatus">
      		<option value="${item.code}" <c:if test="${apply.contactArea==item.code}">selected</c:if>>${item.name}</option>
      	</c:forEach>
<!--         <option>中正區</option> -->
<!--         <option>松山區</option> -->
      </select>
      <input type="text" id="contactAddress" name="contactAddress" size="65%" placeholder="請填寫詳細地址" value="${apply.contactAddress}" required>
      </div>
        
      <div>
      <label for="contactName">聯絡人</label>
      <input type="text" id="contactName" name="contactName" value="${apply.contactName}" required>
      </div>
        
      <div>
      <label for="contactJobtitle">聯絡人職稱</label>
      <input type="text" id="contactJobtitle" name="contactJobtitle" value="${apply.contactJobtitle}" required>
      </div>
        
      <div>
      <label for="contactWorkPhoneAreaCode">聯絡電話</label>
      <input type="tel" maxlength="3" id="contactWorkPhoneAreaCode" name="contactWorkPhoneAreaCode" size="2" placeholder="區碼" value="${apply.contactWorkPhoneAreaCode}" required> -
      <input type="tel" maxlength="8" id="contactWorkPhone" name="contactWorkPhone" size="12" placeholder="電話號碼" value="${apply.contactWorkPhone}" required> #
      <input type="tel" maxlength="6" id="contactWorkPhoneExtension" name="contactWorkPhoneExtension" size="3" placeholder="分機" value="${apply.contactWorkPhoneExtension}">
      </div>
        
      <div>
      <label for="contactPhone">行動電話</label>
      <input type="tel" id="contactPhone" name="contactPhone" pattern="09\d{8}" value="${apply.contactPhone}" required>
      </div>
        
      <div>
      <label for="faxAreaCode">傳真號碼</label>
      <input type="tel" maxlength="3" id="faxAreaCode" name="faxAreaCode" size="2" placeholder="區碼" value="${apply.faxAreaCode}" > -
      <input type="tel" maxlength="8" id="fax" name="fax" size="12" placeholder="傳真號碼" value="${apply.fax}" >
      </div>
        
      <div>
      <label for="email">電子信箱</label>
      <input type="email" id="email" name="email" value="${apply.email}" required>
      </div>
      
      <div class="affidavit">
        <div>資格條件及切結事項</div>
        <ol>
          <li>
          <label class="title" for="multipleCompany0">本統一編號/非營利扣繳編號是否有總公司或其他分公司？</label>
          <label class="s"><input type="radio" name="multipleCompany" value="Y" id="multipleCompany0" <c:if test="${apply.multipleCompany=='Y'}">checked</c:if> required>有</label>
          <label class="s"><input type="radio" name="multipleCompany" value="N" id="multipleCompany1" <c:if test="${apply.multipleCompany=='N'}">checked</c:if>>無</label>
          </li>
        
          <li>
          <label class="title" for="workersEmployment0">本單位雇用勞工總人數達3人以上？ ( 配偶或三等親之內勞工不列入人數計算 )</label>
          <label class="s"><input type="radio" name="workersEmployment" value="Y" id="workersEmployment0" <c:if test="${apply.workersEmployment=='Y'}">checked</c:if> required>是</label>
          <label class="s"><input type="radio" name="workersEmployment" value="N" id="workersEmployment1" <c:if test="${apply.workersEmployment=='N'}">checked</c:if>>否</label>
          </li>
        
          <li>
          <label class="title" for="relatives0">欲繼續僱用之勞工是否為雇主之配偶或三等親內之親屬？</label>
          <label class="s"><input type="radio" name="relatives" value="Y" id="relatives0" <c:if test="${apply.relatives=='Y'}">checked</c:if> required>是</label>
          <label class="s"><input type="radio" name="relatives" value="N" id="relatives1" <c:if test="${apply.relatives=='N'}">checked</c:if>>否</label>
          </li>
        
          <li>
          <label class="title" for="relatedAmounts0">本單位申請繼續僱用補助時未曾領取政府機關與本計畫屬性相同之津貼？</label>
          <label class="s"><input type="radio" name="relatedAmounts" value="Y" id="relatedAmounts0" <c:if test="${apply.relatedAmounts=='Y'}">checked</c:if> required>有</label>
          <label class="s"><input type="radio" name="relatedAmounts" value="N" id="relatedAmounts1" <c:if test="${apply.relatedAmounts=='N'}">checked</c:if>>無</label>
          </li>
        
          <li>
          <label class="title" for="notMandatory0">本單位同意於繼續僱用期間不強制繼續僱用勞工退休、終止投保勞工保險或轉換其勞工保險投保單位。</label>
          <label class="s"><input type="radio" name="notMandatory" value="Y" id="notMandatory0" <c:if test="${apply.notMandatory=='Y'}">checked</c:if> required>同意</label>
          <label class="s"><input type="radio" name="notMandatory" value="N" id="notMandatory1" <c:if test="${apply.notMandatory=='N'}">checked</c:if>>不同意</label>
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
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/employ_02/employ_02.js"></script>
<!-- Select2 JS --> 
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
</body>
</html>