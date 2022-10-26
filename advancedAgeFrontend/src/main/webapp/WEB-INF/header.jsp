<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
String path = request.getContextPath();
String requestURI=request.getRequestURI().replace(path,"").replace("/WEB-INF",""); 
%>

<header>

    <!------------ nav ------------>
    <nav class="navbar navbar-expand-lg bg-gray navbar-dark fixed-top p-0">
        
          <div class="navigation w-100">
            <a class="navbar-brand" href="#"><img src="images/top_logo.png"></a>
            <a class="sitemap text-light float-end p-3" href="change_password" title="網站導覽">修改密碼</a>
            <a class="sitemap text-light float-end p-3" href="sitemap" title="網站導覽">網站導覽</a>
          
            <button class="navbar-toggler" type="button" data-toggle="collapse" 
              data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
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
                    <li><a class="dropdown-item text-light" href="require" title="繼續僱用高齡者補助計畫說明">繼續僱用高齡者補助計畫說明</a></li>
                  </ul>
                </li>
                
                <li class="nav-item">
                  <a href="#" title="線上申辦" class="navbar-dark nav-link dropdown-toggle m3<%if(requestURI.indexOf("/employ")!=-1 || requestURI.indexOf("/register")!=-1 || requestURI.indexOf("/password")!=-1){ %>-in in<%}%>" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">線上申辦</a>
                  <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink">
                    <li><a class="dropdown-item text-light" href="employ" title="繼續雇用高齡者補助 - 申請作業">繼續僱用高齡者補助 - 申請作業</a></li>
                    <li><a class="dropdown-item text-light" href="employ_payment" title="繼續雇用高齡者補助 - 請領作業">繼續僱用高齡者補助 - 請領作業</a></li>
                  </ul>
                </li>
                
                <li class="nav-item text-dark">
                  <a href="#" title="案件查詢" class="navbar-dark nav-link dropdown-toggle m4<%if(requestURI.indexOf("/login")!=-1 || requestURI.indexOf("/schedule")!=-1 ){ %>-in in<%}%>" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">案件查詢</a>
                  <ul class="dropdown-menu rounded" aria-labelledby="navbarDropdownMenuLink">
                    <li><a class="dropdown-item text-light" href="schedule" title="繼續僱用高齡者補助 - 申請進度">繼續僱用高齡者補助 - 申請進度</a></li>
                    <li><a class="dropdown-item text-light" href="schedule_pass" title="繼續僱用高齡者補助 - 請領進度">繼續僱用高齡者補助 - 請領進度</a></li>
                  </ul>
                </li>
                
                <li class="nav-item">
                  <a href="teaching" title="申請教學" class="m5<%if(requestURI.indexOf("/teaching")!=-1){ %>-in in<%}%>">申請教學</a>
                </li>
                
                <li class="nav-item">
                  <a href="downloadSample" title="資料下載" class="m6<%if(requestURI.indexOf("/download")!=-1){ %>-in in<%}%>">資料下載</a>
                </li>
                
                <li class="nav-item">
                  <a href="service" title="諮詢服務" class="m7<%if(requestURI.indexOf("/service")!=-1){ %>-in in<%}%>">諮詢服務</a>
                </li> 
                
              </ul>
            
            </div>
          
          </div>
          
    </nav>
    <!------------ nav end ------------> 
    
  </header>