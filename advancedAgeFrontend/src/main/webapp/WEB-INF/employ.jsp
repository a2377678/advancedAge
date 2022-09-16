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

<link rel="stylesheet" href="css/cmxform.css" type="text/css">
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
      <h2>申請前準備</h2>
      
      <!---申辦前準備--->
      <div class="notice">
        <div>【您是否已符合及備妥下列事項呢 ?】</div>
        <ol>
          <li>設立登記證明文件</li>
          <li>申請人應為合法設立登記之雇主方</li>
          <li>繼續僱用 65 歲受僱者，比例達30%</li>
          <li>繼續僱用者近3個月薪資證明文件</li>
          <li>若您不清楚補助計畫，請點此查看【<a href="require" title="申請資格條件 (另開視窗)" target="_blank" class="point">申請資格條件</a>】</li>
        </ol>
      </div>
      
      <!---申辦前準備--->
      <div class="notice">
        <div>【申辦切結事項】</div>
        <p>本單位符合中高齡者及高齡者就業促進法、在職中高齡者及高齡者穩定就業辦法及繼續僱用補助計畫有關申請繼續僱用補助相關規定，向勞動部勞動力發展署申請繼續僱用補助，<span class="point">並同意勞動力發展署查詢本單位及所僱用人員之勞工保險及全民健康保險資料</span>，且如有違反前開相關規定之情形，願歸還已領取之款項及負一切法律責任，茲檢送應附書表及相關文件如附，請查照並辦理為荷。</p>
      </div>
      <form id="form" action="employ_01" method="post">
	      <div>
	        <input id="check" type="checkbox" required>
	        本人已詳閱資格條件，並同意遵守上述申辦切結事項</div>
	      <div class="page">
	        <button onclick="check()">立即申辦</button>
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
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/employee/employee.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
</body>
</html>