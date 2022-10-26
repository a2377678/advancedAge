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
        <td><input type="text" size="20" name="account"></td>
      </tr>
      <tr>
        <th nowrap>密　碼：</th>
        <td><input type="password" size="18" name="password"></td>
      </tr>
      <tr>
        <th>&nbsp;</th>
        <td><%if(session.getAttribute("message")!=null){ %><span style="color:red;"><%=session.getAttribute("message") %></span> <%} %></td>
      </tr>
      <tr>
        <th>&nbsp;</th>
        <td><input type="submit" class="btn" value="登入"></td>
      </tr>
    </table>

  </div>
	</form>
</body>

</html>
