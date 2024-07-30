<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="zh-hant-TW">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>中高齡就業相關補助計畫</title>
    <link rel="stylesheet" href="css/template.css" type="text/css">
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <script src="js/jquery-3.6.0.min.js"></script>
	<script src="js/gotop.js"></script>
    <script src="js/index/index.js"></script>
	<script src="js/bootstrap.bundle.js"></script>
</head>

<body>

    <div class="">
    
      <!--- header --->
      <%@ include file="header.jsp" %>
      <!--- header end --->
      
      
      <!--- main --->
      <div class="main">
      <a href="#C" title="中央內容區塊" id="AC" accesskey="C" name="C">:::</a> <!---無障礙--->
        <!--- plan_01 --->
        <section class="plan_01">
        
          <div class="plan_content">
            <h1>繼續僱用高齡者<br>共同創造雙贏</h1>
            <p>因應人口結構高齡化，為提升高齡者勞動參與，支持可退休之高齡者繼續就業，發揮高齡者的職場優勢，鼓勵企業雇主繼續僱用屆齡 65 歲員工，並給予補助，最高補助 18 個月。</p>
            <a href="require" class="info" title="申請條件">申請條件</a>
            <a href="teaching" class="play" title="申請教學">申請教學</a>
            <a onclick="employ()" class="go" title="線上申辦">線上申辦</a>
          </div>
        
        </section>
      
        <!--- plan_02 --->
        <section class="plan_02">
                
          <div class="plan-2_content">
            <h2>善用退休高齡者<br>
            經驗傳承無斷層</h2>
            <p>為積極鼓勵企業僱用65歲依法退休的高齡朋友，傳承專業技術及經驗，可申請補助，如傳承專業技術及經驗之實作或講師鐘點費、非自有場地費、場地公共意外險，及其他必要之費用。</p>
            <a href="require_teach" class="info" title="申請條件">申請條件</a>
            <a href="teaching" class="play" title="申請教學">申請教學</a>
            <a onclick="teach()" class="go" title="線上申辦">線上申辦</a>
          </div>
          
        </section>
      
        <!--- plan_03 --->
        <section class="plan_03">
        
          <div class="plan-3_content">
            <h3>退休協助無煩惱<br>
            用心規劃幸福到</h3>
            <p>企業雇主為64歲員工，提供退休準備、調適及再就業之相關協助措施，並辦理「退休後再就業」相關職涯發展、就業諮詢、創業諮詢及職業訓練等，可申請補助。</p>
            <a href="require_career" class="info" title="申請條件">申請條件</a>
            <a href="teaching" class="play" title="申請教學">申請教學</a>
            <a onclick="career()" class="go" title="線上申辦">線上申辦</a>
          </div>
          
        </section>
      
      </div>
      <!--- main end --->
      
      
      <!--- footer --->
      <%@ include file="footer.jsp" %>
      <!--- footer end --->
      
    </div>


	
</body>
</html>