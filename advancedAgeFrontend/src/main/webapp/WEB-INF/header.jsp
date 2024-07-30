<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
String path = request.getContextPath();
String requestURI=request.getRequestURI().replace(path,"").replace("/WEB-INF",""); 
%>
<script src="js/header/header.js"></script>
<header>

	<a href="#content" id="gotocenter" title="移到主要內容" class="sr-only sr-only-focusable">跳到主要內容</a> <!---無障礙--->
    <!------------ nav ------------>
    <nav class="navbar navbar-expand-lg bg-gray navbar-dark fixed-top p-0">
        <noscript><div class="noscript"><strong><mark>您的瀏覽器不支援JavaScript功能，若網頁功能無法正常使用時，請開啟瀏覽器JavaScript狀態。</mark></strong></div></noscript>
          <div class="navigation w-100">
            <a href="index" class="navbar-brand" title="回首頁">首頁</a>
            <a href="#U" id="AU" name="U" title="右上方功能區塊" accesskey="U">:::</a> <!---無障礙--->
<!--             <a class="sitemap text-light float-end p-3" href="change_password" title="網站導覽">修改密碼</a> -->
            <% if (request.getSession().getAttribute(session.getId()+"seq") != null) { 
            	String seq = request.getSession().getAttribute(session.getId()+"seq").toString();%>
            <a href="logoutAccount" class="sitemap text-light float-end py-3 px-3" title="登出">登出</a>
            <a href="change_password" class="sitemap text-light float-end py-3 px-0" title="帳號及修改資料">帳號：<%=seq %></a>
            <%} %>
            <a class="sitemap text-light float-end p-3" href="sitemap" title="網站導覽">網站導覽</a>
          
            <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse" 
	            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
	            aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse main_menu" id="navbarSupportedContent">
              
              <ul class="navbar-nav mr-auto">
              
                <li class="nav-item">
                	<a href="index" title="首頁" class="m1<%if(requestURI.indexOf("/index")!=-1){ %>-in in<%}%>">首頁</a>
                </li>
                
                <li class="nav-item">
                  <a href="#" title="補助計畫" class="navbar-dark nav-link dropdown-toggle m2<%if(requestURI.indexOf("/require")!=-1){ %>-in in<%}%>" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">補助計畫</a>
                  <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink">
                    <li><a class="dropdown-item text-light" href="require" title="繼續僱用高齡者">繼續僱用高齡者</a></li>
                    <li><a class="dropdown-item text-light" href="require_teach" title="僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫">僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫</a></li>
                    <li><a class="dropdown-item text-light" href="require_career" title="中高齡者退休後再就業準備協助措施">中高齡者退休後再就業準備協助措施</a></li>
                  </ul>
                </li>
                
                <li class="nav-item">
                  <a href="#" title="線上申辦" class="navbar-dark nav-link dropdown-toggle m3<%if(requestURI.indexOf("/employ")!=-1 || requestURI.indexOf("/register")!=-1 || requestURI.indexOf("/password")!=-1 || requestURI.indexOf("/teach")!=-1 || requestURI.indexOf("/career")!=-1){ %>-in in<%}%>" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">線上申辦</a>
                  <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink">
<!--                     <li><a class="dropdown-item text-light" href="employ" title="繼續僱用高齡者補助 - 申請作業">繼續僱用高齡者補助 - 申請作業</a></li> -->
                    <li><a class="dropdown-item text-light" onclick="employ()" title="繼續僱用高齡者補助 - 申請作業">繼續僱用高齡者補助 - 申請作業</a></li>
                    <li><a class="dropdown-item text-light" href="employ_payment" title="繼續僱用高齡者補助 - 請領作業">繼續僱用高齡者補助 - 請領作業</a></li>
<!--                     <li><a class="dropdown-item text-light" href="teach" title="退休者傳承專業技術經驗 - 申請作業">退休者傳承專業技術經驗 - 申請作業</a></li> -->
                    <li><a class="dropdown-item text-light" onclick="teach()" title="退休者傳承專業技術經驗 - 申請作業">退休者傳承專業技術經驗 - 申請作業</a></li>
                    <li><a class="dropdown-item text-light" href="teach_payment" title="退休者傳承專業技術經驗 - 請領作業">退休者傳承專業技術經驗 - 請領作業</a></li>
<!--                     <li><a class="dropdown-item text-light" href="career" title="再就業準備協助措施 - 申請作業">再就業準備協助措施 - 申請作業</a></li> -->
                    <li><a class="dropdown-item text-light" onclick="career()" title="再就業準備協助措施 - 申請作業">再就業準備協助措施 - 申請作業</a></li>
                    <li><a class="dropdown-item text-light" href="career_payment" title="再就業準備協助措施 - 請領作業">再就業準備協助措施 - 請領作業</a></li>
                  </ul>
                </li>
                
                <li class="nav-item text-dark">
                  <a href="#" title="案件查詢" class="navbar-dark nav-link dropdown-toggle m4<%if(requestURI.indexOf("/schedule")!=-1){ %>-in in<%}%>" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">案件查詢</a>
                  <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink">
                    <li><a class="dropdown-item text-light" href="schedule_login" title="繼續僱用高齡者補助 - 申請進度">繼續僱用高齡者補助 - 申請進度</a></li>
                    <li><a class="dropdown-item text-light" href="schedule_employ_payment_login" title="繼續僱用高齡者補助 - 請領進度">繼續僱用高齡者補助 - 請領進度</a></li>
                    <li><a class="dropdown-item text-light" href="schedule_teach_login" title="退休者傳承專業技術經驗 - 申請進度">退休者傳承專業技術經驗 - 申請進度</a></li>
                    <li><a class="dropdown-item text-light" href="schedule_teach_payment_login" title="退休者傳承專業技術經驗 - 請領進度">退休者傳承專業技術經驗 - 請領進度</a></li>
                    <li><a class="dropdown-item text-light" href="schedule_career_login" title="再就業準備協助措施 - 申請進度">再就業準備協助措施 - 申請進度</a></li>
					<li><a class="dropdown-item text-light" href="schedule_career_payment_login" title="再就業準備協助措施 - 請領進度">再就業準備協助措施 - 請領進度</a></li>
                  </ul>
                </li>
                
                <li class="nav-item">
                  <a href="teaching" title="申請教學" class="m5<%if(requestURI.indexOf("/teaching")!=-1){ %>-in in<%}%>">申請教學</a>
                </li>
                
                <li class="nav-item">
                  <a href="downloadSample" title="資料下載" class="m6<%if(requestURI.indexOf("/download")!=-1){ %>-in in<%}%>">資料下載</a>
                </li>
                
                <li class="nav-item">
                  <a href="https://job.taiwanjobs.gov.tw/internet/index/service_location.aspx" title="諮詢服務(另開新視窗)" class="m7" target="_blank">諮詢服務</a>
                </li> 
                
              </ul>
            
            </div>
          
          </div>
          
    </nav>
    <!------------ nav end ------------> 
    
  </header>