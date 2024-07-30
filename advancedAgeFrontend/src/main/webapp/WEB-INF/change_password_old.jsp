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
  <!--- header end --->  
  
  <!--- main --->
  <div class="main"> 
    <a href="#C" title="中央內容區塊" id="AC" accesskey="C" name="C">:::</a> <!---無障礙--->
  <!------------ 申請流程 ------------>
  <div class="apply_main">
    <h1>修改密碼</h1>
    <h2>請輸入帳號及新舊密碼</h2>
    
    
    <!---帳號申請--->
    <h3>密碼長度至少12字元，需有英文、數字、特殊符號 ( !@#$%* ) 的組合。</h3>
    
    
    
    <!-------------填寫申請單位資料------------>
    <div class="form mx-auto pt-5 pb-4 w-50">
        
      <div class="full">
      <label for="seq">登入帳號</label>
      <input type="text" id="seq">
      </div>
        
      <div class="full">
      <label for="password">舊密碼</label>
      <input type="password" id="password">
      </div>
        
      <div class="full">
      <label for="newPassword">新密碼</label>
      <input type="password" id="newPassword">
      </div>
        
      <div class="full">
      <label for="checkNewPassword">確認新密碼</label>
      <input type="password" id="checkNewPassword">
      </div>
      
        
    </div>
    

    <div class="page">
      <button onclick="changePassword()">修改密碼</button>
    </div>
    
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
<script src="js/change_password/change_password.js"></script>
</body>
</html>