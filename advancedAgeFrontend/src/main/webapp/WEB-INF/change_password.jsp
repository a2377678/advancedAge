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

<!--     ---------- nav ---------- -->
<!--     <nav class="navbar navbar-expand-lg bg-gray navbar-dark fixed-top p-0"> -->
        
<!--           <div class="navigation w-100"> -->
<!--             <a class="navbar-brand" href="#"><img src="images/top_logo.png"></a> -->
<!--             <a class="sitemap text-light float-end p-3" href="change_password.html" title="網站導覽">修改密碼</a> -->
<!--             <a class="sitemap text-light float-end p-3" href="sitemap.html" title="網站導覽">網站導覽</a> -->
          
<!--             <button class="navbar-toggler" type="button" data-toggle="collapse"  -->
<!--               data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"  -->
<!--               aria-expanded="false" aria-label="Toggle navigation"> -->
<!--               <span class="navbar-toggler-icon"></span> -->
<!--             </button> -->

<!--             <div class="collapse navbar-collapse main_menu" id="navbarSupportedContent"> -->
              
<!--               <ul class="navbar-nav mr-auto"> -->
              
<!--                 <li class="nav-item"> -->
<!--                   <a href="index.html" title="首頁" class="m1">首頁</a> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="#" title="補助計畫" class="navbar-dark nav-link dropdown-toggle m2" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">補助計畫</a> -->
<!--                   <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink"> -->
<!--                     <li><a class="dropdown-item text-light" href="require.html" title="繼續僱用高齡者補助計畫說明">繼續僱用高齡者補助計畫說明</a></li> -->
<!--                   </ul> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="employ.html" title="線上申辦" class="navbar-dark nav-link dropdown-toggle m3" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">線上申辦</a> -->
<!--                   <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink"> -->
<!--                     <li><a class="dropdown-item text-light" href="employ.html" title="繼續雇用高齡者補助 - 申請作業">繼續僱用高齡者補助 - 申請作業</a></li> -->
<!--                     <li><a class="dropdown-item text-light" href="employ_patmant.html" title="繼續雇用高齡者補助 - 請領作業">繼續僱用高齡者補助 - 請領作業</a></li> -->
<!--                     -
<!--                     <li><hr class="dropdown-divider"></li> -->
<!--                     <li><a class="dropdown-item text-white-50" href="#">退休者傳承專業技術 - 尚未開放</a></li> -->
<!--                     <li><hr class="dropdown-divider"></li> -->
<!--                     <li><a class="dropdown-item text-white-50" href="#">退休後再就業準備 - 尚未開放</a></li> -->
<!--                     ---> -->
<!--                   </ul> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item text-dark"> -->
<!--                   <a href="schedule.html" title="案件查詢" class="navbar-dark nav-link dropdown-toggle m4" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">案件查詢</a> -->
<!--                   <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink"> -->
<!--                     <li><a class="dropdown-item text-light" href="schedule.html" title="繼續僱用高齡者補助 - 申請進度">繼續僱用高齡者補助 - 申請進度</a></li> -->
<!--                     <li><a class="dropdown-item text-light" href="schedule_pass.html" title="繼續僱用高齡者補助 - 請領進度">繼續僱用高齡者補助 - 請領進度</a></li> -->
<!--                   </ul> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="teaching.html" title="申請教學" class="m5">申請教學</a> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="download.html" title="資料下載" class="m6">資料下載</a> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="service.html" title="諮詢服務" class="m7">諮詢服務</a> -->
<!--                 </li>  -->
                
<!--               </ul> -->
            
<!--             </div> -->
          
<!--           </div> -->
          
<!--     </nav> -->
<!--     ---------- nav end ----------  -->
    
<!--   </header> -->
  <!--- header end --->  
  
  <!--- main --->
  <div class="main"> 
    
  <!------------ 申請流程 ------------>
  <div class="apply_main">
    <h1>修改密碼</h1>
    <h2>請輸入帳號及新舊密碼</h2>
    
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
    <h3>密碼長度至少12字元，需有英文、數字、特殊符號 ( !@#$%* ) 的組合。</h3>
    
    
    
    <!-------------填寫申請單位資料------------>
    <div class="form mx-auto pt-5 pb-4 w-50">
        
      <div class="full">
      <label for="account">登入帳號</label>
      <input type="text" id="seq">
      </div>
        
      <div class="full">
      <label for="password">舊密碼</label>
      <input type="password" id="password">
      </div>
        
      <div class="full">
      <label for="newPassword">新密碼</label>
      <input type="password" id="newPassword">
      </div>
        
      <div class="full">
      <label for="checkNewPassword">確認新密碼</label>
      <input type="password" id="checkNewPassword">
      </div>
      
        
    </div>
    

    <div class="page">
      <button onclick="changePassword()">修改密碼</button>
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
<script src="js/change_password/change_password.js"></script>
</body>
</html>