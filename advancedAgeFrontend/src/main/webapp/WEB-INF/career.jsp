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

<link rel="stylesheet" href="css/cmxform.css" type="text/css">
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
          <li class="breadcrumb-item active" aria-current="page">中高齡者退休後再就業準備協助措施 - 申請作業</li>
        </ol>
      </nav>
      <h1>中高齡者退休後再就業準備協助措施 - 申請作業</h1>
      <h2>申請前準備</h2>
      
      <!---申辦前準備--->
      <div class="notice pb-4">
        <div>【您是否已符合及備妥下列事項呢 ?】</div>
        <ol>
          <li>設立登記證明文件</li>
          <li>聯合辦理單位授權書 <small><mark>( 個別辦理者免附 )</mark></small></li>
          <li>經費概算表</li>
          <li>其他為審查所需必要文件</li>
          <li>若您不清楚補助計畫，請點此查看【<a href="require_career" title="本計畫規定 (另開視窗)" target="_blank" class="point">本計畫規定</a>】</li>
        </ol>

        <ul>
          <li><small><mark>個別辦理</mark>：由一家雇主申請及辦理本計畫所列補助措施。</small></li>
          <li><small><mark>聯合辦理</mark>：由一家雇主統籌協助申請及辦理本計畫所列補助措施，並結合其他雇主共同參與。</small></li>
          <li><small>申請注意事項：<br>
            (1) 採聯合辦理者，應檢附聯合辦理單位授權書及單位基本資料表。<br>
            (2) 計畫執行所在地跨二個分署時，應向雇主登記地之分署提出申請。<br>
            </small>
          </li>
        </ul>
      </div>
      
      <!---申辦前準備--->
      <div class="notice">
        <div>【申辦切結事項】</div>
        <p>本申請單位符合中高齡者及高齡者就業促進法、退休中高齡者及高齡者再就業補助辦法相關申請補助之規定，向勞動部勞動力發展署各分署，<span class="point">並同意勞動部勞動力發展署及分署查詢本單位及所僱用人員之勞工保險及全民健康保險資料</span>，且如有違反前開相關規定之情形，願歸還已領取之款項及負一切法律責任，茲檢送應附書表及相關文件如附，請查照並辦理為荷。</p>
      </div>
      <form id="form" action="career_01" method="post">
	      <div>
	      <label for="check"></label>
	        <input id="check" type="checkbox" required>
	        已閱讀本計畫規定，並同意上述內容及願意遵守規定</div>
	      <div class="page">
	        <button onclick="check()">立即申辦</button>
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
<script src="js/bootstrap.bundle.js"></script>
<script src="js/gotop.js"></script>
<script src="js/career/career.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
</body>
</html>