<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="zh-hant-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>中高齡就業相關補助計畫</title>
<link rel="stylesheet" href="css/main.css" type="text/css">
<link rel="stylesheet" href="css/template.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/popper.min.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
</head>

<body>
<div class=""> 
  
  <!--- header --->
<!--   <header> -->
	<%@ include file="header.jsp" %>
<!--     ---------- nav ---------- -->
<!--     <nav class="navbar navbar-expand-lg bg-gray navbar-dark fixed-top p-0"> -->
        
<!--           <div class="navigation w-100"> -->
<!--             <a class="navbar-brand" href="#"><img src="images/top_logo.png"></a> -->
<!--             <a class="sitemap text-light float-end p-3" href="sitemap" title="網站導覽">網站導覽</a> -->
          
<!--             <button class="navbar-toggler" type="button" data-toggle="collapse"  -->
<!--               data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"  -->
<!--               aria-expanded="false" aria-label="Toggle navigation"> -->
<!--               <span class="navbar-toggler-icon"></span> -->
<!--             </button> -->

<!--             <div class="collapse navbar-collapse main_menu" id="navbarSupportedContent"> -->
              
<!--               <ul class="navbar-nav mr-auto"> -->
              
<!--                 <li class="nav-item"> -->
<!--                   <a href="index" title="首頁" class="m1">首頁</a> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="#" title="補助計畫" class="navbar-dark nav-link dropdown-toggle m2" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">補助計畫</a> -->
<!--                   <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink"> -->
<!--                     <li><a class="dropdown-item text-light" href="require" title="繼續僱用高齡者補助計畫說明">繼續僱用高齡者補助計畫說明</a></li> -->
<!--                   </ul> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="employ" title="線上申辦" class="navbar-dark nav-link dropdown-toggle m3-in in" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">線上申辦</a> -->
<!--                   <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink"> -->
<!--                     <li><a class="dropdown-item text-light" href="employ" title="繼續雇用高齡者補助 - 申請作業">繼續僱用高齡者補助 - 申請作業</a></li> -->
<!--                     <li><a class="dropdown-item text-light" href="employ_payment" title="繼續雇用高齡者補助 - 請領作業">繼續僱用高齡者補助 - 請領作業</a></li> -->
<!--                     -
<!--                     <li><hr class="dropdown-divider"></li> -->
<!--                     <li><a class="dropdown-item text-white-50" href="#">退休者傳承專業技術 - 尚未開放</a></li> -->
<!--                     <li><hr class="dropdown-divider"></li> -->
<!--                     <li><a class="dropdown-item text-white-50" href="#">退休後再就業準備 - 尚未開放</a></li> -->
<!--                     ---> -->
<!--                   </ul> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item text-dark"> -->
<!--                   <a href="schedule" title="案件查詢" class="navbar-dark nav-link dropdown-toggle m4" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">案件查詢</a> -->
<!--                   <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink"> -->
<!--                     <li><a class="dropdown-item text-light" href="schedule" title="繼續僱用高齡者補助 - 申請進度">繼續僱用高齡者補助 - 申請進度</a></li> -->
<!--                     <li><a class="dropdown-item text-light" href="schedule_pass" title="繼續僱用高齡者補助 - 請領進度">繼續僱用高齡者補助 - 請領進度</a></li> -->
<!--                   </ul> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="teaching" title="申請教學" class="m5">申請教學</a> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="download" title="資料下載" class="m6">資料下載</a> -->
<!--                 </li> -->
                
<!--                 <li class="nav-item"> -->
<!--                   <a href="service" title="諮詢服務" class="m7">諮詢服務</a> -->
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
      <h1>繼續僱用高齡者補助 - 請領作業</h1>
      <h2>申辦通過方可進行請領申請</h2>
      
      <!---申辦前準備--->
      <div class="notice">
        <div>【您是否已符合及備妥下列事項呢 ?】</div>
        <ol>
          <li>原核定函影本</li>
          <li>領據 ( 須加蓋公司大小章及張貼匯款帳戶封面影本 )</li>
          <li>僱用證明文件</li>
          <li>薪資證明文件</li>
          <li>出勤證明文件</li>
          <li>其他經審查之必要文件</li>
        </ol>
      </div>
      
      <!---申辦前準備--->
      <div class="notice">
        <div>【請領切結事項】</div>
        <p>本單位符合在職中高齡者及高齡者穩定就業辦法第20條規定，檢附必要之文件，向勞動部勞動力發展署 ( 含分署 ) 請領繼續僱用補助 ( 明細清冊如次頁填寫表單及檢附文件 ) ，如有違反中高齡者及高齡者就業促進法、在職中高齡者及高齡者穩定就業辦法及繼續僱用補助計畫相關規定之情形，願歸還已領取之款項，並負一切責任。</p>
      </div>
      <form id="form" action="employ_payment_01" method="post">
	      <div>
	        <input id="check" type="checkbox" required>
	        本人已詳閱資格條件，並同意遵守上述申辦切結事項
	      </div>
	      <div class="page">
	        <button type="submit">立即申辦</button>
	      </div>
	  </form>
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
</body>
</html>