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
<!--   <header> -->
<!--     <div class="navigation"> -->
<!--       <div class="top_logo"><img src="images/top_logo.png"></div> -->
<!--       <nav> -->
<!--         <ul> -->
<!--         　　<li><a href="employ" title="帳號申請／登入">帳號申請／登入</a></li> -->
<!--         　　<li><a href="#" title="網站導覽">網站導覽</a></li> -->
<!--         </ul> -->
<!--       </nav> -->
<!--     </div> -->
    
<!--     - nav - -->
<!--     <nav class="main_menu"> -->
<!--       <ul> -->
<!--         <li><a href="index" title="首頁" class="m1">首頁</a></li> -->
<!--         <li><a href="require" title="補助計畫" class="m2">補助計畫</a></li> -->
<!--         <li><a href="employ" title="線上申辦" class="m3-in in">線上申辦</a></li> -->
<!--         <li><a href="#" title="案件查詢" class="m4">案件查詢</a></li> -->
<!--         <li><a href="#" title="申請教學" class="m5">申請教學</a></li> -->
<!--         <li><a href="#" title="資料下載" class="m6">資料下載</a></li> -->
<!--         <li><a href="#" title="諮詢服務" class="m7">諮詢服務</a></li> -->
<!--       </ul> -->
<!--     </nav> -->
<!--     - nav end -  -->
    
<!--   </header> -->
  <!--- header end ---> 
  
  <!--- main --->
  <div class="main"> 
    
  <!------------ 申請流程 ------------>
  <div class="apply_main">
    <h1>繼續僱用高齡者補助計畫</h1>
    <h2>申請流程 Step1. 驗證登入</h2>
    
    <!---申辦前準備--->
    <h3>請先「註冊帳號」或使用「工商憑證」進行登入，<br>
    若您忘記密碼請聯繫我們，將由人工查詢及回覆。</h3>
    
    
    <div class="login">
    
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
          <input type="password" pattern="[a-zA-Z0-9]{12,16}" id="password" placeholder="12~16位英數的密碼">
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
        
          <!---<li>
            <div>( 需檢附文件註冊及查詢 )</div>
          </li>--->
        
          <li>
          	<div><button onclick="aVerify()">登入</button></div>
<!--             <div><button onclick="javascript:location.href='employ_02'">登入</button></div> -->
          </li>
        
        </ul>
      </div>
      
          
      <div class="mode style-1">
        <div class="title_line">實體卡申請</div>
        <div class="title_word">工商憑證登入</div>
        <ul>
        
          <li>
          
          <label for="">密碼</label>
          <input type="password" pattern="[a-zA-Z0-9]{8,16}" name="pin" id="pin" placeholder="工商憑證卡片PIN碼" value="82798010">
				<INPUT type="hidden" name="tbs" id="tbs" value="TBS"/>
<SELECT name="tbsEncoding" id="tbsEncoding" style="display:none"><OPTION value="NONE" selected>NONE</OPTION><OPTION value="base64" >base64</OPTION></SELECT>
<SELECT name="hashAlgorithm" id="hashAlgorithm" style="display:none"><OPTION value="SHA1">SHA1</OPTION>
  	   <OPTION value="SHA256" selected>SHA256</OPTION>	   <OPTION value="SHA384">SHA384</OPTION>
  	   <OPTION value="SHA512">SHA512</OPTION>	   </SELECT><BR>
<INPUT type="hidden" name="nonce" id="nonce"/><BR>
<SELECT name="withCardSN" id="withCardSN" style="display:none"><OPTION value="true">true</OPTION>	   <OPTION value="false" 
  selected>false</OPTION>	   </SELECT>

<TEXTAREA name="b64SignedData" id="ResultSignedData" rows="8" cols="65" style="display:none"></TEXTAREA><br/>
<input type="hidden" name="returnCode" id="returnCode"/>
          </li>
          
          <li><div><a href="https://moeaca.nat.gov.tw/download/download_4.html">讀卡元件</a>　<a href="https://moeacaweb.nat.gov.tw/MoeaeeWeb/function/cert_3.aspx" target="_blank">忘記密碼</a></div></li>
        
          <li><div><a href="http://localhost:61161/selfTest.htm" target="_blank">使用環境建議與檢測</a></div></li>
        
        
          <li>
            <div>
<!--             	<button onclick="javascript:location.href='employ_02'">登入</button> -->
            	<button type="button" id="MakeSignature" onclick="makeSignature()">登入</button>
            </div>
          </li>
        
        </ul>
      </div>
      
    </div>
    
    
    <div class="page"></div>
    
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
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script> 
<script src="js/bootstrap.min.js"></script>
<script src="js/employ_01/employ_01.js"></script>
<script src="js/employ_01/CaCheck.js"></script>
<script src="js/employ_01/errorcode.js"></script>
</body>
</html>