<!DOCTYPE HTML>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="utf-8">
<title>促進中高齡者及高齡者就業相關補助計畫系統</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
</head>

<body id="login_bg">

  <div id="login_logo"><img src="images/logo.png"></div>
  <form action="login" method="post">
  <div id="login">
    <table width="100%" border="0" cellspacing="0" class="login_tb">
      <tr>
        <th nowrap>帳　號：</th>
        <td><input type="text" size="20" name="account" style="width:190px"></td>
      </tr>
      <tr>
        <th nowrap>密　碼：</th>
        <td><input type="password" size="18" name="password" autocomplete="off" style="width:190px"></td>
      </tr>
      <tr>
        <th>&nbsp;</th>
        <td><%if(session.getAttribute("message")!=null){ %><span style="color:red;"><%=session.getAttribute("message") %></span> <%} %></td>
      </tr>
      <tr>
        <th>&nbsp;</th>
        <td><input type="submit" class="btn" value="登入"></td>
      </tr>
      <tr>
        <th>&nbsp;</th>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <th nowrap>諮詢專線：</th>
        <td>( 02 ) 2731 - 6520</td>
      </tr>
      <tr>
        <th>&nbsp;</th>
        <td>( 上班日9:00~12:00，13:00~17:00 )</td>
      </tr>
      <tr>
        <th>諮詢信箱：</th>
        <td><a href="mailto:service@heroic.com.tw"><u>service@heroic.com.tw</u></a></td>
      </tr>
    </table>

  </div>
	</form>
</body>

</html>
