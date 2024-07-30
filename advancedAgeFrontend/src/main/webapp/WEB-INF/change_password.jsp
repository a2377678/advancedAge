<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<script src="js/change_password/change_password.js"></script>
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
            <li class="breadcrumb-item active" aria-current="page">帳號信箱及修改密碼</li>
          </ol>
        </nav>
        <h1>帳號信箱及修改密碼</h1>
        <h2>請輸入欲修改之電子信箱或新密碼</h2>

        <!---修改密碼--->
        <h3>密碼長度至少12字元，需有英文、數字、特殊符號 ( !@#$%* ) 的組合。</h3>



        <!-------------填寫申請單位資料------------>
        <div class="form mx-auto pt-5 pb-4 w-50">

          <div class="full">
            <label for="seq">帳號統編</label>
            <input type="text" id="seq" value="${companyInfoData.get('seq')}" disabled>
          </div>

          <div class="full">
            <label for=""email"">電子信箱</label>
            <input type="text" id="email" value="<c:if test="${not empty companyInfoData.get('email')}">${companyInfoData.get('email')}</c:if>" placeholder="請填寫有效之電子信箱">
          </div>

          <div class="full">
            <label for="newPassword">新密碼</label>
            <input type="text" id="newPassword" placeholder="請輸入新密碼">
          </div>

          <div class="full">
            <label for="checkNewPassword">確認新密碼</label>
            <input type="text" id="checkNewPassword" placeholder="請再次輸入新密碼">
          </div>


        </div>


        <div class="page">
          <button onclick="changePassword()">儲存修改</button>
        </div>

      </div>
      <!------------ 申請流程 END ------------>

    </div>
    <!--- main end --->

    <!--- footer --->
    <a href="#Z" id="AZ" title="下方功能區塊" accesskey="Z" name="Z">:::</a> <!---無障礙--->
    <footer class="copyright">
      <section>
        <div>勞動力發展署：24219新北市新莊區中平路439號南棟4樓　電話代表號：(02)8995-6000　客服專線：0800-777-888</div>
        <div>本署服務時間：週一至週五　上午8時30分至12時30分，下午13時30分至17時30分</div>
        <div>最佳解析度1024x768 ，建議更新瀏覽器至以下版本：最新版本Chrome、最新版本Firefox</div>
        <div>中華民國勞動部勞動力發展署版權所有 © 2022 All rights reserved. </div>
      </section>
    </footer>
    <!--- footer end --->

  </div>

</body>

</html>