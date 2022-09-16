<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="utf-8">
<title>促進中高齡者及高齡者就業相關補助計畫系統</title>

<link href="css/file.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>



<body>


  <!---------------------- top ---------------------->
<!--   <div id="top"> -->
<!--     <div id="top_logo"><a href="index.html"><img src="images/logo.png" /></a></div> -->
<!--   </div> -->
  <%@ include file="../header.jsp" %>
  <!---------------------- top end ---------------------->

    
  <div id="main_menu">
    <div><a href="a01?account=${account}" class="menu-1">繼續僱用高齡者</a></div>
    <div><a href="#" class="menu-2">傳承專業技術與經驗</a></div>
    <div><a href="#" class="menu-3">退休後再就業準備協助措施</a></div>
    <div><a href="account01" class="account in">申請帳號審核管理</a></div>
  </div>

  <!---------------------- left menu ---------------------->
  <div id="left_menu">
    <div class="panel-group" id="accordion">
    
    <!---------- collapse1 ---------->
	<div class="panel panel-default">
		<div class="panel-heading-in">
			<h4 class="panel-title">
			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">申請帳號審核</a>
			</h4>
		</div>
		<div id="collapse1" class="panel-collapse collapse in">
			<div class="panel-body">
				<ul>
          <li><a href="account01?account=${account}">新申請帳號</a></li>
          <li><a href="account02?account=${account}" class="in">帳密查詢回覆</a></li>
        </ul>
			</div>
		</div>
	</div>
    
    
    
  </div>
  </div>
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">申請帳號審核
        <span>帳密查詢回覆</span>
        <span id="number">account02_1</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      
      
      
      <!------------------- 申請帳號資料 ------------------->
      <div class="file_title-2">查詢資料</div>
        <table class="table_03">
          <tr>
            <th width="18%">事業單位名稱</th>
            <td width="30%">OO資訊科技有限公司</td>
            <th width="18%">統一編號 / 扣繳編號</th>
            <td>66668888</td>
          </tr>
          <tr>
            <th>聯絡人</th>
            <td>林小姐</td>
            <th>聯絡人職稱</th>
            <td>經理</td>
          </tr>
          <tr>
            <th>聯絡電話</th>
            <td>02 - 66668888 #321</td>
            <th>行動電話</th>
            <td>0910234567</td>
          </tr>
          <tr>
            <th>電子信箱</th>
            <td colspan="3">abc0123@gmail.com</td>
          </tr>
          <tr>
            <th>設立登記證明文件</th>
            <td colspan="3">
              <div><a href="#">OO資訊科技有限公司登記證明文件-1</a></div>
              <div><a href="#">OO資訊科技有限公司登記證明文件-2</a></div>
              <div><a href="#">OO資訊科技有限公司登記證明文件-3</a></div>
            </td>
          </tr>
          <tr>
            <th>查詢日期</th>
            <td>111-09-01　15:06</td>
            <th>審核日期</th>
            <td>111-09-02　14:05</td>
          </tr>
        </table>
      
      
      <div class="text-center h5 pt-4">經人工審核(電訪)確認後，發送密碼至電子信箱</div>
      
      <div class="page_number">
      <input type="button" class="btn_02" value="返回列表" />
      <input type="button" class="btn-success btn_02" value="發送密碼" />
      </div>
      <br><br><br>
      
      
      

    </div>
    
  </div>
  <!---------------------- main end ---------------------->
  
  
  
  




</body>




</html>
