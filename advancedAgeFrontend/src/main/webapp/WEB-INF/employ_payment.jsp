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
<script src="js/employ_payment/employ_payment.js"></script>
</head>
<style>
label.error {
    color: red;
    font-style: italic;
}
</style>
<body>
<div class=""> 
  
  <!--- header --->
	<%@ include file="header.jsp" %>
  <!--- header end ---> 
  
  <!--- main --->
  <div class="main"> 
    <a href="#C" title="中央內容區塊" id="AC" accesskey="C" name="C">:::</a> <!---無障礙--->
    <!------------ 申請流程 ------------>
    <div class="apply_main">
      <!---無障礙/麵包屑--->
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index" title="首頁">首頁</a></li>
          <li class="breadcrumb-item active" aria-current="page">線上申辦</li>
          <li class="breadcrumb-item active" aria-current="page">繼續僱用高齡者補助 - 請領作業</li>
        </ol>
      </nav>
      <h1>繼續僱用高齡者補助 - 請領作業</h1>
      <h2>申辦通過方可進行請領申請</h2>
      
      <!---申辦前準備--->
      <div class="notice">
        <div>【您是否已符合及備妥下列事項呢 ?】</div>
        <ol>
          <li>僱用證明文件。</li>
          <li>薪資證明文件。</li>
          <li>原核定函影本。</li>
          <li>領據 ( 須加蓋公司大小章及張貼匯款帳戶封面影本 )。</li>
          <li>請領繼續僱用補助清冊。</li>
          <li>繼續僱用之高齡者請領補助期間之出勤證明文件。</li>
          <li>其他經本署或各分署認定有必要提出之文件、資料。</li>
        </ol>
      </div>
      
      <!---申辦前準備--->
      <div class="notice">
        <div>【請領切結事項】</div>
        <p>本單位符合在職中高齡者及高齡者穩定就業辦法第20條規定，檢附必要之文件，向勞動部勞動力發展署各分署請領繼續僱用補助 ( 明細清冊如次頁填寫表單及檢附文件 ) ，如有違反中高齡者及高齡者就業促進法、在職中高齡者及高齡者穩定就業辦法及繼續僱用補助計畫相關規定之情形，願歸還已領取之款項，並負一切責任。</p>
      </div>
      <form id="form">
	      <div>
	      <label for="check"></label>
	        <input id="check" name="verify" type="checkbox" required>
	        本人已詳閱資格條件，並同意遵守上述申辦切結事項
	      </div>
	      </form>
	      <div class="page">
	        <button onclick="aVerify()">立即申辦</button>
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