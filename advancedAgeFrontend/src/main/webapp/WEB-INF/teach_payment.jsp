<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="zh-hant-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>中高齡及高齡者就業相關服務網</title>
<link rel="stylesheet" href="css/main.css" type="text/css">
<link rel="stylesheet" href="css/template.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<script src="js/bootstrap.bundle.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/gotop.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
<script src="js/teach_payment/teach_payment.js"></script>
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
  <div class="main clearfix" id="content"> 
    <a href="#C" title="中央內容區塊" id="AC" accesskey="C" name="C">:::</a> <!---無障礙--->
    
    <!------------ 申請流程 ------------>
    <div class="apply_main">
  
      <!---無障礙/麵包屑--->
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index" title="首頁">首頁</a></li>
          <li class="breadcrumb-item active" aria-current="page">線上申辦</li>
          <li class="breadcrumb-item active" aria-current="page">僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 請領作業</li>
        </ol>
      </nav>
      <h1>僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 請領作業</h1>
      <h2>申辦通過方可進行請領申請</h2>
      <h3>計畫執行完竣後三十日內，檢附文件、資料，送分署覈實申請補助費用</h3>
      
      <!---申辦前準備--->
      <div class="notice pb-4">
        <div>【您是否已符合及備妥下列事項呢 ?】</div>
        <ol>
          <li>本計畫核准函影本</li>
          <li>成果報告 ( 於請領流程填寫 )</li>
          <li>請款之領據及存摺封面影本</li>
          <li>內聘講師鐘點費印領清冊</li>
          <li>經費支出原始憑證及明細表</li>
          <li>其他經分署認定有必要提出之文件、資料</li>
          <li>若您不清楚請領辦法，請點此查看【<a href="require_teach" title="本計畫規定 (另開視窗)" target="_blank" class="point">本計畫規定</a>】</li>
        </ol>
      </div>
      
      <!---申辦切結事項--->
      <div class="notice">
        <div>【請領切結事項】</div>
        <p>本申請單位符合中高齡者及高齡者就業促進法、退休中高齡者及高齡者再就業補助辦法相關申請補助之規定，向勞動部勞動力發展署各分署申請僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫，<span class="point">並同意勞動部勞動力發展署及分署查詢本單位及所僱用人員之勞工保險及全民健康保險資料</span>，且如有違反前開相關規定之情形，願歸還已領取之款項及負一切法律責任，茲檢送應附書表及相關文件如附，請查照並辦理為荷。</p>
      </div>
      <form id="form">
	      <div>
	      <label for="check"></label>
	        <input id="check" name="verify" type="checkbox" required>
	        已閱讀本計畫規定，並同意上述內容及願意遵守規定</div>
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