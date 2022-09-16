<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="zh-hant-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>中高齡就業相關補助計畫</title>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/template.css" type="text/css">
<link rel="stylesheet" href="css/main.css" type="text/css">
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
    <h1>查詢帳號密碼</h1>
    <h2>填寫信箱及上傳登記證明文件</h2>
    
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
    <h3>請填寫註冊時所登記之e-mail 及上傳證明文件，<br>
    我們將由專人與您聯繫與核對資料。</h3>
    
    
    
    <!-------------填寫申請單位資料------------>
    <div class="form">
    
      <div class="title_main"><span>申請單位資料</span></div>
        
      <div>
      <label for="companyName">單位名稱</label>
      <input type="text" id="companyName">
      </div>
        
      <div>
      <label for="seq">統一編號</label>
      <input type="text" id="seq">
      </div>
        
      <div>
      <label for="contactName">聯絡人</label>
      <input type="text" id="contactName">
      </div>
        
      <div>
      <label for="contactJobtitle">聯絡人職稱</label>
      <input type="text" id="contactJobtitle">
      </div>
        
      <div>
      <label for="contactWorkPhoneAreaCode">聯絡電話</label>
      <input type="tel" maxlength="3" id="contactWorkPhoneAreaCode" size="2" placeholder="區碼"> -
      <input type="tel" maxlength="8" id="contactWorkPhone" size="12" placeholder="電話號碼"> #
      <input type="tel" maxlength="6" id="contactWorkPhoneExtension" size="3" placeholder="分機">
      </div>
        
      <div>
      <label for="contactPhone">行動電話</label>
      <input type="tel" id="contactPhone" pattern="09\d{8}">
      </div>

        
      <div class="full">
      <label for="email">電子信箱</label>
      <input type="email" id="email"> 
      ( 請填寫註冊時所登記之e-mail )</div>
      
        
    </div>
    
    
    <!-------------僱用資料及輔導措施------------>
    <div class="form">
    
      <div class="title_main">
      <span>設立登記證明文件</span>
      <em>須加蓋公司單位及負責人用印 (公司大小章)
      【<a href="#" title="上傳檔案範例 (另開視窗)">範例</a>】</em>
      </div>
      
      <div class="file_box">  
        <div class="full">
        <label for="">文件(1)</label>
        <input type="file" id="">
        <button class="add">－</button>
        <button class="add">＋</button>
        </div>
      </div>
      
    </div>
    

    
    <div class="page">
      <button onclick="apply()">送出查詢申請</button>
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

<script src="js/password_01/password_01.js"></script>
</body>
</html>