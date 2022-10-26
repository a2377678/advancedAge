<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta charset="utf-8">
<title>促進中高齡者及高齡者就業相關補助計畫系統</title>

<link href="css/chart.css" rel="stylesheet" type="text/css">
<link href="css/file.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/chart.min.js"></script>
<script type="text/javascript" src="js/chart_style.js"></script>

</head>



<body>


  <!---------------------- top ---------------------->
	<%@ include file="header.jsp" %>
  <!---------------------- top end ---------------------->

    
    <div id="main_menu">
	    <div><a href="#" class="menu-1 in">繼續僱用高齡者</a></div>
	    <div><a href="#" class="menu-2">傳承專業技術與經驗</a></div>
	    <div><a href="#" class="menu-3">退休後再就業準備協助措施</a></div>
	    <div><a href="account01" class="account">申請帳號審核管理</a></div>
	 </div>

  <!---------------------- left menu ---------------------->
  		<%@ include file="leftMenu.jsp" %>
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div class="chart_index">

    <!--------- 繼續雇用 --------->
    <div class="chart_box-1">
      <div class="chart_title-1">繼續雇用高齡者</div>
    
         <!--------- 原薪資 --------->
         <div style="width:350px; height:350px; margin-left:10px;">
	       <canvas id="canvasBar" width="350" height="260" 
	       class="chartjs-render-monitor">
	       </canvas>
           <div class="chart_title-s1">原有薪資級距</div>
         </div>
          
          
         <!--------- 圓餅圖 --------->
	     <div style="width:380px; height:300px; margin-left:15px; pagging-bottom:30px;">
	       <canvas id="canvasPie" width="560" height="300" 
           class="chartjs-render-monitor">
           </canvas>
           <div class="chart_title-s2">行業 (職業) 別統計</div>
         </div>
         
    </div>


    <!--------- 傳承專業技術 --------->
    <div class="chart_box-2">
      <div class="chart_title-2">傳承專業技術與經驗</div>
          
         <!--------- 專業技術 --------->
	     <div style="width:350px; height:300px; margin-left:25px; margin-top:40px!important;">
	       <canvas id="canvasPie-2" width="480" height="300" 
           class="chartjs-render-monitor">
           </canvas>
           <div class="chart_title-s3">傳承技術類型</div>
         </div>
         
         <!--------- 年齡 --------->
         <div style="width:365px; height:300px; padding-left:5px;">
	       <canvas id="canvasBar-2" width="350" height="260" 
	       class="chartjs-render-monitor">
	       </canvas>
           <div class="chart_title-s4">講師年齡區間統計</div>
         </div>
         
    </div>


    <!--------- 退休後再就業準備 --------->
    <div class="chart_box-3">
      <div class="chart_title-3">退休後再就業準備協助措施</div>
    
         <!--------- 再訓練人數 --------->
         <div style="width:360px; height:320px; padding-left:30px;">
	       <canvas id="canvasBar-3" width="300" height="220" 
	       class="chartjs-render-monitor">
	       </canvas>
           <div class="chart_title-s5">再就業訓練人數</div>
         </div>
          
          
         <!--------- 申請項目 --------->
	     <div style="width:400px; height:200px;">
	       <canvas id="canvasPie-3" width="300" height="240" 
           class="chartjs-render-monitor">
           </canvas>
           <div class="chart_title-s6">申請措施類型 (109年度)</div>
      </div>
         
    </div>

    
  </div>
  <!---------------------- main ---------------------->
  
  
  
  




</body>




</html>
