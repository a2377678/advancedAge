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
        <li class="breadcrumb-item active" aria-current="page">僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 請領作業</li>
      </ol>
    </nav>
    <h1>僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 請領作業</h1>
    <h2>請領流程 Step1. 驗證登入</h2>
    
    <!---申辦前準備--->
    <h3>請先「註冊帳號」或使用「工商憑證」、「台灣就業通帳號」進行登入，<br>
      若您忘記本站帳號密碼請聯繫我們，將由人工查詢及回覆。</h3>
    
    
    <div class="login clearfix">
    
      <div class="mode style-2">
        <div class="title_line">無卡申請</div>
        <div class="title_word">帳號登入</div>
        <ul>
          <li>
          <label for="">帳號</label>
          <input type="text" pattern="\d{8}" maxlength="8" id="" placeholder="公司統一編號">
          </li>
        
          <li>
          <label for="">密碼</label>
          <input type="password" pattern="[a-zA-Z0-9]{8,16}" id="" placeholder="12~16位英數的密碼">
          </li>
        
          <li>
          <label for="">驗證</label>
          <input type="text" size="8">
          </li>
        
          <li>
            <div><a href="register_01">註冊帳號</a>　<a href="password_01">忘記帳密</a></div>
          </li>
        
          <li>
            <div><button onclick="javascript:location.href='teach_payment_02'">登入</button></div>
          </li>
        
        </ul>
      </div>
      
          
      <div class="mode style-1">
        <div class="title_line">實體卡申請</div>
        <div class="title_word">工商憑證登入</div>
        <ul>
        
          <li>
          <label for="">密碼</label>
          <input type="password" pattern="[a-zA-Z0-9]{8,16}" id="" placeholder="工商憑證卡片PIN碼">
          </li>
        
          <li><div><a href="#">讀卡元件</a>　<a href="#">忘記密碼</a></div></li>
        
          <li><div><a href="#">使用環境建議與檢測</a></div></li>
        
        
          <li>
            <div><button onclick="javascript:location.href='teach_patmant_02'">登入</button></div>
          </li>
        
        </ul>
      </div>
      
      
      <div class="mode style-3">
        <div class="title_line">無卡申請</div>
        <div class="title_word">就業通帳號登入</div>
        <ul>
          <li>
          <label for="">帳號</label>
          <input type="text" pattern="\d{8}" maxlength="8" id="" placeholder="公司統一編號">
          </li>
        
          <li>
          <label for="">密碼</label>
          <input type="password" pattern="[a-zA-Z0-9]{8,20}" id="" placeholder="8~20位大小寫英數字或特殊符號">
          </li>
        
          <li>
          <label for="">驗證</label>
          <input type="text" size="8">
          </li>
        
          <li>
            <div><button onclick="javascript:location.href='interface'">登入</button></div>
          </li>
        </ul>
      </div>
      
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