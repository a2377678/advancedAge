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
    
  <!------------ 申請流程 ------------>
  <div class="apply_main">
    <h1>網站導覽</h1>

    <div class="require">

      <p>本網站依無障礙網頁設計原則建置，網站的主要內容分為三大區塊：<br />
        1. 上方功能區塊、2. 中央內容區塊、3.下方功能區塊。
        本網站的快速鍵﹝Accesskey﹞設定如下：
      </p>

      <ul>
        <li><kbd>Alt</kbd>+<kbd> U </kbd>：右上方功能區塊，包括回首頁、網站導覽、網站搜尋、字體選擇等。</li>
        <li><kbd>Alt</kbd>+<kbd> C </kbd>：中央內容區塊，為本頁主要內容區。</li>
        <li><kbd>Alt</kbd>+<kbd> Z </kbd>：下方功能區塊。</li>
      </ul>
      
      <p>
        ※當本網站項目頁籤無法以滑鼠點選時，您可利用以下鍵盤操作方式瀏覽資料<br />
        <kbd>&larr;</kbd> <kbd>&rarr;</kbd> or <kbd>&uarr;</kbd> <kbd>&darr;</kbd>：按左右鍵或上下鍵移動標籤順序。<br />
        <kbd>Home</kbd> or <kbd>End &rarr;</kbd>：可直接跳至標籤第一項或者最後一項。<br />
        <kbd>Tab </kbd>：停留於該標籤後，可利用 Tab 鍵跳至內容瀏覽該筆資料，遇到 radio 按鈕時請配合使&larr; &rarr; or&uarr;&darr;鍵移動項目順序。<br />
        <kbd>Tab </kbd> + <kbd>Shift</kbd>：按 Tab + Shift 可往回跳至上一筆資料；當跳回至標籤項目時您可繼續利用&larr; &rarr; or&uarr;&darr;鍵移動標籤順序。<br />
      </p>
        
        <ul class='list-group-numbered pb-4'>
          <li><a href="index" title="首頁" class="m1-in in">首頁</a></li>
          <li><a href="require" title="補助計畫" class="m2">補助計畫</a></li>
          <li><a href="employ" title="線上申辦" class="m3">線上申辦</a>
            <ul class='list-group-numbered'>
              <li><a href='employ' title='繼續僱用高齡者補助計畫申請'>繼續僱用高齡者補助計畫申請</a></li>
            </ul>
          </li>
          <li><a href="schedule" title="案件查詢" class="m4">案件查詢</a>
            <ul class='list-group-numbered'>
              <li><a href='schedule' title='申請案件進度查詢'>申請案件進度查詢</a></li>
              <li><a href='schedule_pass' title='申請案件請領 (審核通過)'>申請案件請領 (審核通過)</a></li>
            </ul>
          </li>
          <li><a href="teaching" title="申請教學" class="m5">申請教學</a></li>
          <li><a href="downloadSample" title="資料下載" class="m6">資料下載</a></li>
          <li><a href="service" title="諮詢服務" class="m7">諮詢服務</a></li>
        </ul>

    </div>
        
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
</body>
</html>