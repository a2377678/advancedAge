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