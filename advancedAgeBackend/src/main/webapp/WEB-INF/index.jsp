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
<!--   <div id="top"> -->
<!--     <div id="top_logo"><a href="index"><img src="images/logo.png" /></a></div> -->
<!--   </div> -->
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
<!--   <div id="left_menu"> -->
<!--     <div class="panel-group" id="accordion"> -->
    
<!--     -------- collapse1 -------- -->
<!-- 	<div class="panel panel-default"> -->
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">收件與補件</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse1" class="panel-collapse collapse"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="a01/a01.html">案件查詢</a></li> -->
<!--                   <li><a href="a02/a02.html">附件檢查與通知</a></li> -->
<!--                   <li><a href="a03/a03.html">回傳案件</a></li> -->
<!--                 </ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
    
<!--     -------- collapse2 -------- -->
<!-- 	<div class="panel panel-default"> -->
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">查核與撥款</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse2" class="panel-collapse collapse"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="b01/b01-1.html">案件審核</a></li> -->
<!--                   <li><a href="b02/b02.html">登錄停止補助名單</a></li> -->
<!--                   <li><a href="b03/b03.html">核定清冊／請款</a></li> -->
<!--                   <li><a href="b04/b04.html">核銷案件</a></li> -->
<!--                 </ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->

    
    
<!--     -------- collapse8 -------- -->
<!--     <div class="panel panel-default"> -->
<!-- 		<div class="panel-heading-in"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 				<a data-toggle="collapse" data-parent="#accordion" href="#collapse8">彙整與統計</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse8" class="panel-collapse collapse in"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="index.html" class="in">統計儀錶板</a></li> -->
<!--                   <li><a href="#">行業(職業)別統計</a></li> -->
<!--                   <li><a href="#">申請單位屬性統計</a></li> -->
<!--                   <li><a href="#">補助金額統計</a></li> -->
<!--                   <li><a href="#">近3年申請情形統計</a></li> -->
<!--                   <li><a href="#">繼續僱用金額統計</a></li> -->
<!--                   <li><a href="#">繼續僱用人數統計</a></li> -->
<!--                   <li><a href="#">原有薪資級距統計</a></li> -->
<!--                   <li><a href="#">年齡區間統計</a></li> -->
<!--                 </ul> -->
<!-- 		  </div> -->
<!-- 		</div> -->
<!-- 	</div>     -->


    
    
<!--     -------- collapse10 -------- -->
<!--     <div class="panel panel-default"> -->
<!-- 		<div class="panel-heading"> -->
<!-- 			<h4 class="panel-title"> -->
<!-- 				<a data-toggle="collapse" data-parent="#accordion" href="#collapse10">系統管理</a> -->
<!-- 			</h4> -->
<!-- 		</div> -->
<!-- 		<div id="collapse10" class="panel-collapse collapse"> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<ul> -->
<!--                   <li><a href="j01/j01.html">使用者資料維護</a></li> -->
<!--                   <li><a href="j02/j02.html">使用者帳號與權限</a></li> -->
<!--                   <li><a href="j03/j03.html">群組權限管理</a></li> -->
<!--                   <li><a href="j04/j04.html">系統登入紀錄</a></li> -->
<!--                 </ul> -->
<!-- 		  </div> -->
<!-- 		</div> -->
<!-- 	</div> -->
    
    
<!--   </div> -->
<!--   </div> -->
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
