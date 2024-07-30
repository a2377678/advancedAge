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
          <li class="breadcrumb-item active" aria-current="page">繼續僱用高齡者補助 - 申請作業</li>
        </ol>
      </nav>
      <h1>繼續僱用高齡者補助 - 申請作業</h1>
      <h2>申請前準備</h2>
      
      <!---申辦前準備--->
      <div class="notice">
        <div>【您是否已符合及備妥下列事項呢 ?】</div>
        <ol>
          <li>依法設立登記之證明文件影本。</li>
          <li>最近一個月勞工保險及勞工職業災害保險投保人數或其他足資證明加保之證明文件。</li>
          <li>繼續僱用之高齡者最近三個月之薪資及出勤證明文件。</li>
          <li>其他經本署或各分署認定有必要提出之文件、資料。</li>
        </ol>
      </div>
      
      <!---申辦前準備--->
      <div class="notice">
        <div>【申辦切結事項】</div>
        <p>本單位符合中高齡者及高齡者就業促進法、在職中高齡者及高齡者穩定就業辦法及繼續僱用補助計畫有關申請繼續僱用補助相關規定，向勞動部勞動力發展署各分署申請繼續僱用補助，<span class="point">並同意勞動部勞動力發展署及分署查詢本單位及所僱用人員之勞工保險、勞工職業災害保險及全民健康保險資料</span>，且如有違反前開相關規定之情形，願歸還已領取之款項及負一切法律責任，茲檢送應附書表及相關文件如附，請查照並辦理為荷。</p>
      </div>
      <form id="form" action="employ_01" method="post">
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
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
</body>
</html>