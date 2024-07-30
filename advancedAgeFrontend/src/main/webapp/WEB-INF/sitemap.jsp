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
  <!---無障礙/麵包屑--->
    <nav aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index" title="首頁">首頁</a></li>
        <li class="breadcrumb-item active" aria-current="page">網站導覽</li>
      </ol>
    </nav>
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
          <li><a href="require" title="補助計畫" class="m2">補助計畫</a>
            <ul class='list-group-numbered'>
              <li><a href="require" title="繼續僱用高齡者">繼續僱用高齡者</a></li>
              <li><a href="require_teach" title="僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫">僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫</a></li>
              <li><a href="require_career" title="中高齡者退休後再就業準備協助措施">中高齡者退休後再就業準備協助措施</a></li>
            </ul>
          </li>
          <li><a href="employ" title="線上申辦" class="m3">線上申辦</a>
            <ul class='list-group-numbered'>
              <li><a href='employ' title='繼續僱用高齡者補助 - 申請作業'>繼續僱用高齡者補助 - 申請作業</a></li>
              <li><a href='employ_payment' title='繼續僱用高齡者補助 - 請領作業'>繼續僱用高齡者補助 - 請領作業</a></li>
              <li><a href='teach' title='退休者傳承專業技術經驗 - 申請作業'>退休者傳承專業技術經驗 - 申請作業</a></li>
              <li><a href='teach_payment' title='退休者傳承專業技術經驗 - 請領作業'>退休者傳承專業技術經驗 - 請領作業</a></li>
              <li><a href='career' title='再就業準備協助措施 - 申請作業'>再就業準備協助措施 - 申請作業</a></li>
              <li><a href='career_payment' title='再就業準備協助措施 - 請領作業'>再就業準備協助措施 - 請領作業</a></li>
            </ul>
          </li>
          <li><a href="schedule" title="案件查詢" class="m4">案件查詢</a>
            <ul class='list-group-numbered'>
              <li><a href="schedule" title="繼續僱用高齡者 - 申請進度">繼續僱用高齡者 - 申請進度</a></li>
              <li><a href="schedule_employ_payment" title="繼續僱用高齡者 - 請領進度">繼續僱用高齡者 - 請領進度</a></li>
              <li><a href="schedule_teach" title="退休者傳承專業技術經驗 - 申請進度">退休者傳承專業技術經驗 - 申請進度</a></li>
              <li><a href="schedule_teach_payment" title="退休者傳承專業技術經驗 - 請領進度">退休者傳承專業技術經驗 - 請領進度</a></li>
              <li><a href="schedule_career" title="再就業準備協助措施 - 申請進度">再就業準備協助措施 - 申請進度</a></li>
              <li><a href="schedule_career_payment" title="再就業準備協助措施 - 請領進度">再就業準備協助措施 - 請領進度</a></li>
            </ul>
          </li>
          <li><a href="teaching" title="申請教學" class="m5">申請教學</a></li>
          <li><a href="downloadSample" title="資料下載" class="m6">資料下載</a></li>
          <li><a href="https://job.taiwanjobs.gov.tw/internet/index/service_location.aspx" title="諮詢服務" class="m7" target="_blank">諮詢服務</a></li>
        </ul>

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
</body>
</html>