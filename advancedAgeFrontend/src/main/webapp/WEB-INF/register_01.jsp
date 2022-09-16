<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>

<body>
<div class=""> 
  			<!-- Modal-1-1 -->
          <div class="modal modal-dialog-scrollable fade" id="exampleModal-1-1"
           tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg">
              <div class="modal-content">
                <img src="/file/SAMPLE/公司設立登記證明文件-1.jpg" alt="公司設立登記證明文件">
              </div>
            </div>
          </div>
          <!-- Modal-1-1 -->
          
          <!-- Modal-1-2 -->
          <div class="modal modal-dialog-scrollable fade" id="exampleModal-1-2"
           tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
              <div class="modal-content">
                <img src="/file/SAMPLE/法人登記書-1.jpg" alt="法人登記書範本">
              </div>
            </div>
          </div>
          <!-- Modal-1-2 -->
          
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
    <h1>帳號註冊 ( 無卡申請 )</h1>
    <h2>填寫資料及上傳登記證明文件</h2>
    
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
    
    <!---帳號申請--->
    <h3>請確實填寫及上傳，將由人工審核資料，<br>
    通過申請後，系統會發送帳號密碼至您填寫的信箱。</h3>
    
    
    
    <!-------------填寫申請單位資料------------>
    <form id="createForm">
    <div class="form">
    
      <div class="title_main"><span>申請單位資料</span></div>
    
      <div>
      <label for="companyName">單位名稱</label>
      <input type="text" size="35" id="companyName" name="companyName" required>
      </div>
        
      <div>
      <label for="principal">負責人</label>
      <input type="text" id="principal" name="principal" required>
      </div>
        
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
        
      <div>
      <label for="seq">統一編號</label>
      <input type="text" pattern="\d{8}" minlength="8" maxlength="8" id="seq" name="seq" required>
      </div>
        
<!--       <div> -->
<!--       <label for="">勞保投保證號</label> -->
<!--       <input type="text" id=""> -->
<!--       <button class="add">－</button> -->
<!--       <button class="add">＋</button> -->
<!--       </div> -->
        
      <div class="full">
      <label for="registerCity">登記地址</label>
      <select name="registerCity" id="registerCity" required>
        <option value>請選擇</option>
        <c:forEach  items="${cityList}"  var="item"  varStatus="userStatus">
      		<option value="${item.code}">${item.name}</option>
      	</c:forEach>
      </select>
      <select name="registerArea" id="registerArea" required>
        <option value>請選擇</option>
      </select>
      <input type="text" id="registerAddress" name="registerAddress" size="65%" placeholder="請填寫詳細地址" required>
      </div>
        
      <div class="full">
      <label for="contactCity">聯絡地址</label>
      <select name="contactCity" id="contactCity" required>
        <option value>請選擇</option>
        <c:forEach  items="${cityList}"  var="item"  varStatus="userStatus">
      		<option value="${item.code}">${item.name}</option>
      	</c:forEach>
<!--         <option>台北市</option> -->
<!--         <option>新北市</option> -->
      </select>
      <select name="contactArea" id="contactArea" required>
        <option value>請選擇</option>
<!--         <option>中正區</option> -->
<!--         <option>松山區</option> -->
      </select>
      <input type="text" id="contactAddress" name="contactAddress" size="65%" placeholder="請填寫詳細地址" value="${apply.contactAddress}" required>
      <input type="checkbox" name="checkbox" id="checkbox">
      同登記地址
      </div>
        
      <div>
      <label for="contactName">聯絡人</label>
      <input type="text" id="contactName" name="contactName" required>
      </div>
        
      <div>
      <label for="contactJobtitle">聯絡人職稱</label>
      <input type="text" id="contactJobtitle" name="contactJobtitle" required>
      </div>
        
      <div>
      <label for="contactWorkPhoneAreaCode">聯絡電話</label>
      <input type="tel" maxlength="3" id="contactWorkPhoneAreaCode" name="contactWorkPhoneAreaCode" size="2" placeholder="區碼" required> -
      <input type="tel" maxlength="8" id="contactWorkPhone" name="contactWorkPhone" size="12" placeholder="電話號碼" required> #
      <input type="tel" maxlength="6" id="contactWorkPhoneExtension" name="contactWorkPhoneExtension" size="3" placeholder="分機">
      </div>
        
      <div>
      <label for="contactPhone">行動電話</label>
      <input type="tel" id="contactPhone" name="contactPhone" pattern="09\d{8}" required>
      </div>
        
      <div>
      <label for="faxAreaCode">傳真號碼</label>
      <input type="tel" maxlength="3" id="faxAreaCode" name="faxAreaCode" size="2" placeholder="區碼"> -
      <input type="tel" maxlength="8" id="fax" name="fax" size="12" placeholder="傳真號碼">
      </div>
        
      <div>
      <label for="email">電子信箱</label>
      <input type="email" id="email" name="email" required>
      </div>
      
        
    </div>
    
    </form>
    <!-------------僱用資料及輔導措施------------>
    <div class="form">
    
      <div class="title_main">
      <span>設立登記證明文件</span>
        <em>須加蓋公司單位及負責人用印 (公司大小章)
          <!-- Button trigger modal-1 -->
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModal-1-1">範例 1</button>
          <button type="button" class="btn btn-success px-2 py-0" data-bs-toggle="modal" 
          data-bs-target="#exampleModal-1-2">範例 2</button>
        </em>
      </div>
      
      <div class="file_box" id="register">  
        <div class="full">
<!--         image/*,application/pdf,application/x-zip-compressed -->
	        <label for="registerProof1">文件(1)</label>
	        <input type="file" id="registerProof1" name="registerProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z" required>
<!-- 	        <button class="add" onclick="delRegisterProof(1)">－</button> -->
	        <button type="button" class="add" onclick="addRegisterProof(1)" style>＋</button>
        </div>
      </div>
      
      <div class="title_main">
      <span>申請單位授權書</span>
      <em>須加蓋公司單位及負責人用印 (公司大小章)
      【<a href="/file/SAMPLE/申請單位授權書.doc" title="下載申請單位授權書">下載申請單位授權書.doc</a>】</em>
      </div>
      
      <div class="file_box" id="authorize">  
        <div class="full">
        <label for="authorizeProof1">文件(1)</label>
        <input type="file" id="authorizeProof1" name="authorizeProof" accept=".jpg ,.png ,.pdf ,.rar ,.zip ,.7z" required>
<!--         <button class="add">－</button> -->
        <button class="add" onclick="addAuthorizeProof(1)" style>＋</button>
        </div>
      </div>
      
    </div>
    
	
    
    <div class="page">
      <button type="button" onclick="enroll()">送出申請</button>
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
<script src="js/register_01/register_01.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
</body>
</html>