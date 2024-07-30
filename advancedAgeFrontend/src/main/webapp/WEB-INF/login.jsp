<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<!---無障礙/麵包屑--->
    <nav aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index" title="首頁">首頁</a></li>
        <li class="breadcrumb-item active" aria-current="page">帳號申請及登入</li>
      </ol>
    </nav>
    <h1>帳號申請／登入</h1>
    <h2>驗證身分</h2>
    
    <!---申辦前準備--->
    <h3>請先「登入帳號」或使用「工商憑證」進行登入，<br>
    若您忘記密碼請聯繫我們，將由人工查詢及回覆。</h3>
    <div class="login clearfix">
    	<label for="type"></label>
    	<input type="text" id="type" name="type" value="${type }" style="display:none">
    	<label for="caseType"></label>
    	<input type="text" id="caseType" name="caseType" value="${caseType }" style="display:none">
      <div class="mode style-2">
        <div class="title_line">無卡申請</div>
        <div class="title_word">帳號登入</div>
        <ul>
          <li>
          <label for="seq">帳號</label>
          <input type="text" pattern="\d{8}" maxlength="8" id="seq" placeholder="公司統一編號">
          </li>
        
          <li>
          <label for="password">密碼</label>
          <input type="password" pattern="[a-zA-Z0-9]{8,16}" id="password" placeholder="12~16位英數的密碼">
          </li>
        
          <li>
          <label for="verifyInput">驗證</label>
          	<input type="text" size="8" id="verifyInput">
	          <a href="javascript:void(0);" title="點擊更換驗證碼">
	          	<img id="imgVerify" src="getVerify" alt="更換驗證碼" height="28" width="90" onclick="getVerify(this);">
	          </a>
          </li>
        
          <li>
            <div><a href="register_01">註冊帳號</a>　<a href="password_01">忘記帳密</a></div>
          </li>
        
        
          <li>
          	<div><button onclick="aVerify()">登入</button></div>
          </li>
        
        </ul>
      </div>
      
          
      <div class="mode style-1">
        <div class="title_line">實體卡申請</div>
        <div class="title_word">工商憑證登入</div>
        <ul>
        
          <li>
          
          <label for="pin">密碼</label>
          <input type="password" pattern="[a-zA-Z0-9]{8,16}" name="pin" id="pin" placeholder="工商憑證卡片PIN碼" value="">
          	<label for="tbs"></label>
				<INPUT type="text" name="tbs" id="tbs" value="TBS" style="display:none">
<label for="tbsEncoding"></label>
<SELECT name="tbsEncoding" id="tbsEncoding" style="display:none"><OPTION value="NONE" selected>NONE</OPTION><OPTION value="base64" >base64</OPTION></SELECT>
<label for="hashAlgorithm"></label>
<SELECT name="hashAlgorithm" id="hashAlgorithm" style="display:none"><OPTION value="SHA1">SHA1</OPTION>
  	   <OPTION value="SHA256" selected>SHA256</OPTION>	   <OPTION value="SHA384">SHA384</OPTION>
  	   <OPTION value="SHA512">SHA512</OPTION>	   </SELECT><BR>
<label for="nonce"></label>
<INPUT type="text" name="nonce" id="nonce" style="display:none"><BR>
<label for="withCardSN"></label>
<SELECT name="withCardSN" id="withCardSN" style="display:none"><OPTION value="true">true</OPTION>	   <OPTION value="false" 
  selected>false</OPTION>	   </SELECT>
<label for="ResultSignedData"></label>
<TEXTAREA name="b64SignedData" id="ResultSignedData" rows="8" cols="65" style="display:none"></TEXTAREA><br/>
<label for="returnCode"></label>
<input type="text" name="returnCode" id="returnCode" style="display:none">
          </li>
          
          <li><div><a href="https://moica.nat.gov.tw/download/File/HiCOS_Client.zip" target="_blank">讀卡元件</a>　<a href="https://moeacaweb.nat.gov.tw/MoeaeeWeb/function/cert_3.aspx" target="_blank">忘記密碼</a></div></li>
        
          <li><div><a href="http://localhost:61161/selfTest.htm" target="_blank">使用環境建議與檢測</a></div></li>
        
        
          <li>
            <div>
            	<button type="button" id="MakeSignature" onclick="makeSignature()">登入</button>
            </div>
          </li>
        
        </ul>
      </div>
      
      <div class="mode style-3">
        <div class="title_line">無卡申請</div>
        <div class="title_word">就業通帳號登入</div>
        <ul>
          <li>
          <label for="SSOseq">統編</label>
          <input type="text" pattern="\d{8}" maxlength="8" id="SSOseq" placeholder="請輸入統一編號">
          </li>
          <li>若您已有台灣就業通網站帳號，請輸入台灣就業通帳號，並點選下方登入，頁面將引導至台灣就業通網站。</li>
          <li>
            <div><button type="button" onclick="SSO()">登入</button></div>
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
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/login/login.js"></script>
<script src="js/login/CaCheck.js"></script>
<script src="js/login/errorcode.js"></script>
</body>
</html>