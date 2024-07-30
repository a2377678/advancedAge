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
</head>

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
          <li class="breadcrumb-item active" aria-current="page">僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 申請作業</li>
        </ol>
      </nav>
      <h1>僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 申請作業</h1>
      <h2>申請前準備</h2>
      
      <!---申辦前準備--->
      <div class="notice pb-4">
        <div>【您是否已符合及備妥下列事項呢 ?】</div>
        <ol>
          <li>設立登記證明文件</li>
          <li>講師為退休高齡者證明文件 <small><mark>註1</mark></small></li>
          <li>講師具專業技術及經驗證明文件 <small><mark>註2</mark></small></li>
          <li>僱用證明文件</li>
          <li>其他為審查所需必要文件</li>
          <li>若您不清楚補助計畫，請點此查看【<a href="require_teach" title="本計畫規定 (另開視窗)" target="_blank" class="point">本計畫規定</a>】</li>
        </ol>

        <ul>
          <li><small><mark>註 1</mark>：服務單位開具之退休證明文件或領取公教人員保險養老給付、公務人員退休金、教職員退休金、勞工退休金、勞工保險老年給付、軍人退休俸（退伍金）、公營事業退休金或農民退休儲金等相關給付之存簿證明影本。</small></li>
          <li><small><mark>註 2</mark>：相關證照影本或由服務單位開立之工作資歷證明文件。</small></li>
          <li><small>申請注意事項：<br>
            (1) 申請本計畫之所僱用高齡者，不得為雇主配偶或三親等以內親屬。<br>
            (2) 本計畫每位受僱用之高齡者每年最高補助雇主新臺幣十萬元，每位雇主每年最高補助新臺幣五十萬元。<br>
            (3) 同一事由已領取政府機關相同性質之補助，不得再申請本計畫。</small></li>
        </ul>
      </div>
      
      <!---申辦切結事項--->
      <div class="notice">
        <div>【申辦切結事項】</div>
        <p>本申請單位符合中高齡者及高齡者就業促進法、退休中高齡者及高齡者再就業補助辦法相關申請補助之規定，向勞動部勞動力發展署各分署申請僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫，<span class="point">並同意勞動部勞動力發展署及分署查詢本單位及所僱用人員之勞工保險、勞工職業災害保險及全民健康保險資料</span>，且如有違反前開相關規定之情形，願歸還已領取之款項及負一切法律責任，茲檢送應附書表及相關文件如附，請查照並辦理為荷。</p>
      </div>
      <form id="form" action="teach_01" method="post">
	      <div>
	      <label for="check"></label>
	        <input id="check" type="checkbox" required>
	        本人已詳閱資格條件，並同意遵守上述申辦切結事項</div>
	      <div class="page">
	        <button type="submit">立即申辦</button>
	      </div>
      </form>
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