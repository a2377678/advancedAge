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
    <h1>繼續僱用高齡者補助計畫</h1>
    <h2>申請流程 Step6. 送出申請</h2>

    <h3>您已完成線上申請，請等候相關單位通知審核結果。</h3>
    
    <div>
      <span class="title">您申請的案件已送出</span>
      <h4>
      您可於本網站「進度查詢」再次下載 &quot;線上申請書電子檔&quot;
      </h4>
      <p>《 申辦完成不代表審核通過 》<br>
      如有補件或修改送件資料需求，或您有任何疑問<br>
      請於周一至周五 上班時間洽詢 <a href="#">受理單位</a>
      </p>
    </div>
    
    <div class="page">
<%--     <a href="pdf?seq=${seq }" type="button">下載申請書電子檔</a> --%>
	  <button onclick="downloadPdf('${seq }')">下載申請書電子檔</button>
      <button onclick="javascript:location.href='index'">回首頁</button>
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
<script src="js/employ_06/employ_06.js"></script>
</body>
</html>