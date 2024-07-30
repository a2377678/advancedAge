<%@ page contentType="text/html; charset=UTF-8" %>

<%
String mainRequestURI=request.getRequestURI().replace(request.getContextPath(),"").replace("/WEB-INF",""); 
%>

<div id="main_menu">
    <div><a href="b01" class="menu-1 <%if(mainRequestURI.indexOf("/a0")!=-1 || mainRequestURI.indexOf("/b")!=-1 || mainRequestURI.indexOf("/c")!=-1 || mainRequestURI.indexOf("/i")!=-1 || mainRequestURI.indexOf("/j")!=-1){ %>in<%} %>">繼續僱用高齡者</a></div>
    <div><a href="k01" class="menu-2 <%if(mainRequestURI.indexOf("/k")!=-1 || mainRequestURI.indexOf("/l")!=-1 || mainRequestURI.indexOf("/m")!=-1 || mainRequestURI.indexOf("/n")!=-1 || mainRequestURI.indexOf("/o")!=-1 || mainRequestURI.indexOf("/q")!=-1 || mainRequestURI.indexOf("/r")!=-1){ %>in<%} %>">傳承專業技術與經驗</a></div>
    <div><a href="s01" class="menu-3 <%if(mainRequestURI.indexOf("/s")!=-1 || mainRequestURI.indexOf("/t")!=-1 || mainRequestURI.indexOf("/u")!=-1 || mainRequestURI.indexOf("/v")!=-1 || mainRequestURI.indexOf("/w")!=-1 || mainRequestURI.indexOf("/y")!=-1 || mainRequestURI.indexOf("/z")!=-1){ %>in<%} %>">退休後再就業準備協助措施</a></div>
    <c:if test="${jurisdiction==1 || jurisdiction==2}">
    	<div><a href="account01" class="account <%if(mainRequestURI.indexOf("/account")!=-1){ %>in<%} %>">申請帳號審核管理</a></div>
    </c:if>
  </div>