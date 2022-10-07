<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="zh-hant-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>中高齡就業相關補助計畫</title>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/template.css" type="text/css">
<link rel="stylesheet" href="css/main.css" type="text/css">

<link rel="stylesheet" href="css/cmxform.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
</head>

<body>
<div class=""> 
  
  <!--- header --->
  <%@ include file="header.jsp" %>
<!--   <header> -->
<!--     <div class="navigation"> -->
<!--       <div class="top_logo"><img src="images/top_logo.png"></div> -->
<!--       <nav> -->
<!--         <ul> -->
<!--         　　<li><a href="employ" title="帳號申請／登入">帳號申請／登入</a></li> -->
<!--         　　<li><a href="#" title="網站導覽">網站導覽</a></li> -->
<!--         </ul> -->
<!--       </nav> -->
<!--     </div> -->
    
<!--     - nav - -->
<!--     <nav class="main_menu"> -->
<!--       <ul> -->
<!--         <li><a href="index" title="首頁" class="m1">首頁</a></li> -->
<!--         <li><a href="require" title="補助計畫" class="m2">補助計畫</a></li> -->
<!--         <li><a href="employ" title="線上申辦" class="m3-in in">線上申辦</a></li> -->
<!--         <li><a href="#" title="案件查詢" class="m4">案件查詢</a></li> -->
<!--         <li><a href="#" title="申請教學" class="m5">申請教學</a></li> -->
<!--         <li><a href="#" title="資料下載" class="m6">資料下載</a></li> -->
<!--         <li><a href="#" title="諮詢服務" class="m7">諮詢服務</a></li> -->
<!--       </ul> -->
<!--     </nav> -->
<!--     - nav end -  -->
    
<!--   </header> -->
  <!--- header end ---> 
  
  <!--- main --->
  <div class="main"> 
    
  <!------------ 申請流程 ------------>
  <div class="apply_main">
    <h1>繼續僱用高齡者補助計畫</h1>
    <h2>申請流程 Step3. 填寫計畫書</h2>
    
    <!---申辦前準備--->
    <h3>請確實填寫資料，如有不實，主管機關可駁回<br>
    申請案或請止補貼，並負法律責任。</h3>
    
 
 
 
    <!-------------僱用資料及輔導措施------------>
    <div class="form">
      <form id="form">
      <div class="title_main"><span>僱用資料及輔導措施</span></div>
    
      <!---<div>
      <label for="">成立時間</label>
      <input type="text" placeholder="yyymmdd">
      </div>--->
        
      <div class="full">
      <label for="items">主要業務/產品/服務</label>
      <input type="text" size="86%" id="items" name="items" value="${plan.items}" required>
      </div>
      <input type="hidden" id="sid" value="${sid}"/>
      <div class="full">
      <label for="employmentNumber">目前員工人數</label>
      <input type="number" step="1" min="0" id="employmentNumber" name="employmentNumber" value="${plan.employmentNumber}" required>
      </div>
        
      <div class="full">
      <label for="highEmploymentNumber">65歲以上人數</label>
      <input type="number" step="1" min="0" id="highEmploymentNumber" name="highEmploymentNumber" value="${plan.highEmploymentNumber}" required>
      </div>
        
      <div class="full">
      <label for="middleEmploymentNumber">45~64歲人數</label>
      <input type="number" step="1" min="0" id="middleEmploymentNumber" name="middleEmploymentNumber" value="${plan.middleEmploymentNumber}" required>
      </div>
        
      <div class="full">
      <label for="lowEmploymentNumber">44歲以下人數</label>
      <input type="number" step="1" min="0" id="lowEmploymentNumber" name="lowEmploymentNumber" value="${plan.lowEmploymentNumber}" required>
      </div>
        
      <div class="full">
      <label for="nearHighEmploymentNumber">屆齡65歲人數 (A)</label>
      <input type="number" step="1" min="0" id="nearHighEmploymentNumber" name="nearHighEmploymentNumber" value="${plan.nearHighEmploymentNumber}" required>
      </div>
        
      <div class="full">
      <label for="continueEmploymentNumber">規劃繼續僱用人數 (B)</label>
      <input type="number" step="1" min="0" id="continueEmploymentNumber" name="continueEmploymentNumber" value="${plan.continueEmploymentNumber}" required>
      </div>
        
      <div class="full">
      <label for="continueEmploymentPercentage">繼續僱用比例 (C)</label>
      <input type="text" placeholder="本欄自動計算" id="continueEmploymentPercentage" name="continueEmploymentPercentage" value="${plan.continueEmploymentPercentage}"> 
      %
      <img src="images/icon_qu.png" class="icon_qu"
title="繼續僱用高齡者
比例須達30%以上
才符合補助資格
C=(B)/(A) x 100%">
</div>
        
      </form>
      
    </div>
    
    
      <div class="btn_box">
      <button class="save" onclick="planSave('Y','N')">暫存資料</button>
      </div> 
    
    
    
    
    <!-------------繼續僱用補助名單清冊------------>
    
    <div class="form">
      
      <div class="title_main">
      <span>繼續僱用補助名單清冊</span>
      <em>請視需要自行增刪欄位，若名單超過5人請下載
      【<a href="/file/SAMPLE/申請補助專用表格.xlsx" title="Excel申請專用表格(另開視窗)">申請補助專用表格.xlsx</a>】
      填寫後上傳</em>
      </div>
      
      <div id="page_tab">
        <div class="tab-1" id="employed"><a <c:if test="${plan.attachEmploymentList != 'Y'}">class="in color-2"</c:if>>線上填寫資料</a></div>
        <div class="tab-1" id="excel"><a <c:if test="${plan.attachEmploymentList == 'Y'}">class="in color-2"</c:if>>上傳專用表格</a></div>
      </div>
      
      <div class="staff" id="listStaff">
      	<form id="listForm">
	      <ol class="staff">
	      	<c:choose><c:when test="${advancedAgeEmploymentLists !='[]'}">
	        <c:forEach items="${advancedAgeEmploymentLists}" var="item" varStatus="status">
	       	<li>
	          <div class="ss">
	          <label for="name${status.count}">勞工姓名</label>
	          <input type="text" id="name${status.count}" name="name${status.count}" value="${item.name}">
	          </div>
	          
	          <div class="ss">
	          <label for="identification${status.count}">身分證字號</label>
	          <input type="text" id="identification${status.count}" name="identification${status.count}" value="${item.identification}">
	          </div>
	        
	          <!---<div class="ss">
	          <label for="">出生年月日</label>
	          <input type="text" placeholder="yyymmdd">
	          </div>--->
	        
	          <div class="ss">
	          <label for="insuranceType${status.count}">保險類型</label>
	          <select id="insuranceType${status.count}" name="insuranceType${status.count}">
	            <option value>請選擇</option>
	            <option value="1" <c:if test="${item.laborProtectionTime.length()==7}">selected</c:if>>勞工保險</option>
	            <option value="2" <c:if test="${item.occupationalAccidentProtectionTime.length()==7}">selected</c:if>>職災保險</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="insuranceTime${status.count}">加保日期</label>
	          <input type="text" id="insuranceTime${status.count}" name="insuranceTime${status.count}" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')" value="<c:choose><c:when test="${item.laborProtectionTime.length()==7}">${item.laborProtectionTime}</c:when><c:otherwise>${item.occupationalAccidentProtectionTime}</c:otherwise></c:choose>">
	          </div>
	        
	          <div class="ss">
	          <label for="manager${status.count}">職務類型</label>
	          <select id="manager${status.count}" name="manager${status.count}">
	            <option value>請選擇</option>
	            <option value="Y" <c:if test="${item.manager=='Y'}">selected</c:if>>主管</option>
	            <option value="N" <c:if test="${item.manager=='N'}">selected</c:if>>非主管</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="relatives${status.count}">親等關係</label>
	          <select id="relatives${status.count}" name="relatives${status.count}">
	            <option value>請選擇</option>
	            <option value="N" <c:if test="${item.relatives=='N'}">selected</c:if>>非三親等</option>
	            <option value="Y" <c:if test="${item.relatives=='Y'}">selected</c:if>>三親等內</option>
	          </select>
	          <img src="images/icon_qu.png" class="icon_qu"
	          title="【三親等內】之親屬包含：
	配偶、父母、子女、兄弟姊妹、
	(外)祖父母、(外)孫子女、
	伯、叔、姑、舅、姨、
	姪子(女)、外甥(女)、
	(外)曾祖父母、(外)曾孫子女">
	          </div>
	        
	          <div class="ss">
	          <label for="workingHours${status.count}">工時類型</label>
	          <select id="workingHours${status.count}" name="workingHours${status.count}">
	            <option value>請選擇</option>
	            <option value="A" <c:if test="${item.workingHours=='A'}">selected</c:if>>全時</option>
	            <option value="P" <c:if test="${item.workingHours=='P'}">selected</c:if>>部分工時</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="averageSalary${status.count}">平均薪資</label>
	          <input type="text" id="averageSalary${status.count}" name="averageSalary" class="readonly" placeholder="填寫完自動計算" value="${item.averageSalary}" readonly>
	          </div>
	        
	          <div class="m">
	          <label for="recurringSalary${status.count}">經常性薪資</label>
	          <input type="text" id="recurringSalary${status.count}" name="recurringSalary${status.count}" pattern="[0-9]*" placeholder="申請前3個月總和" value="${item.recurringSalary}"> 
	          ( 本薪 / 津貼 / 經常性獎金 )
	          <img src="images/icon_qu.png" class="icon_qu"
	          title="【經常性薪資】
	包含：本薪、交通津貼、伙食津貼、
	　　　績效獎金、全勤獎金、工作獎金；  
	不含：差旅費、差旅津貼、交際費。"></div>
	        
	          <div class="m">
	          <label for="notRecurringSalary${status.count}">非經常性薪資</label>
	          <input type="text" id="notRecurringSalary${status.count}" name="notRecurringSalary${status.count}" placeholder="申請前3個月總和" value="${item.notRecurringSalary}">
	( 加班費 / 不休假獎金 )
	          <img src="images/icon_qu.png" class="icon_qu"
	          title="【非經常性薪資】
	包含：加班費、不休假獎金；  
	不含：紅利、年終獎金、久任獎金、三節獎
	　　　金、醫療補助費、子女教育補助費。"></div>
	
	          <div class="close"><button class="close" title="移除此筆資料">X</button></div>
	          
	        </li>
			</c:forEach>
	        </c:when><c:otherwise>
	        <!---01--->
	        <li>
	          <div class="ss">
	          <label for="name1">勞工姓名</label>
	          <input type="text" id="name1" name="name">
	          </div>
	          
	          <div class="ss">
	          <label for="identification1">身分證字號</label>
	          <input type="text" id="identification1" name="identification">
	          </div>
	        
	          <!---<div class="ss">
	          <label for="">出生年月日</label>
	          <input type="text" placeholder="yyymmdd">
	          </div>--->
	        
	          <div class="ss">
	          <label for="insuranceType1">保險類型</label>
	          <select id="insuranceType1" name="insuranceType">
	            <option value>請選擇</option>
	            <option value="1">勞工保險</option>
	            <option value="2">職災保險</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="insuranceTime1">加保日期</label>
	          <input type="text" id="insuranceTime1" name="insuranceTime" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')">
	          </div>
	        
	          <div class="ss">
	          <label for="manager1">職務類型</label>
	          <select id="manager1" name="manager">
	            <option value>請選擇</option>
	            <option value="Y">主管</option>
	            <option value="N">非主管</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="relatives1">親等關係</label>
	          <select id="relatives1" name="relatives">
	            <option value>請選擇</option>
	            <option value="N">非三親等</option>
	            <option value="Y">三親等內</option>
	          </select>
	          <img src="images/icon_qu.png" class="icon_qu"
	          title="【三親等內】之親屬包含：
	配偶、父母、子女、兄弟姊妹、
	(外)祖父母、(外)孫子女、
	伯、叔、姑、舅、姨、
	姪子(女)、外甥(女)、
	(外)曾祖父母、(外)曾孫子女">
	          </div>
	        
	          <div class="ss">
	          <label for="workingHours1">工時類型</label>
	          <select id="workingHours1" name="workingHours">
	            <option value>請選擇</option>
	            <option value="A">全時</option>
	            <option value="P">部分工時</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="averageSalary1">平均薪資</label>
	          <input type="text" id="averageSalary1" name="averageSalary" class="readonly" placeholder="填寫完自動計算" readonly>
	          </div>
	        
	          <div class="m">
	          <label for="recurringSalary1">經常性薪資</label>
	          <input type="text" id="recurringSalary1" name="recurringSalary" pattern="[0-9]*" placeholder="申請前3個月總和"> 
	          ( 本薪 / 津貼 / 經常性獎金 )
	          <img src="images/icon_qu.png" class="icon_qu"
	          title="【經常性薪資】
	包含：本薪、交通津貼、伙食津貼、
	　　　績效獎金、全勤獎金、工作獎金；  
	不含：差旅費、差旅津貼、交際費。"></div>
	        
	          <div class="m">
	          <label for="notRecurringSalary1">非經常性薪資</label>
	          <input type="text" id="notRecurringSalary1" name="notRecurringSalary" placeholder="申請前3個月總和">
	( 加班費 / 不休假獎金 )
	          <img src="images/icon_qu.png" class="icon_qu"
	          title="【非經常性薪資】
	包含：加班費、不休假獎金；  
	不含：紅利、年終獎金、久任獎金、三節獎
	　　　金、醫療補助費、子女教育補助費。"></div>
	
	          <div class="close"><button class="close" title="移除此筆資料">X</button></div>
	          
	        </li>
	        
	        
	        <!---02--->
	        <li>
	          <div class="ss">
	          <label for="name2">勞工姓名</label>
	          <input type="text" id="name2" name="name">
	          </div>
	          
	          <div class="ss">
	          <label for="identification2">身分證字號</label>
	          <input type="text" id="identification2" name="identification">
	          </div>
	        
	          <!---<div class="ss">
	          <label for="">出生年月日</label>
	          <input type="text" placeholder="yyymmdd">
	          </div>--->
	        
	          <div class="ss">
	          <label for="insuranceType2">保險類型</label>
	          <select id="insuranceType2" name="insuranceType">
	            <option value>請選擇</option>
	            <option value="1">勞工保險</option>
	            <option value="2">職災保險</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="insuranceTime2">加保日期</label>
	          <input type="text" id="insuranceTime2" name="insuranceTime" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')">
	          </div>
	        
	          <div class="ss">
	          <label for="manager2">職務類型</label>
	          <select id="manager2" name="manager">
	            <option value>請選擇</option>
	            <option value="Y">主管</option>
	            <option value="N">非主管</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="relatives2">親等關係</label>
	          <select id="relatives2" name="relatives">
	            <option value>請選擇</option>
	            <option value="N">非三親等</option>
	            <option value="Y">三親等內</option>
	          </select>
	          <img src="images/icon_qu.png" class="icon_qu"
	          title="【三親等內】之親屬包含：
	配偶、父母、子女、兄弟姊妹、
	(外)祖父母、(外)孫子女、
	伯、叔、姑、舅、姨、
	姪子(女)、外甥(女)、
	(外)曾祖父母、(外)曾孫子女">
	          </div>
	        
	          <div class="ss">
	          <label for="workingHours2">工時類型</label>
	          <select id="workingHours2" name="workingHours">
	            <option value>請選擇</option>
	            <option value="A">全時</option>
	            <option value="P">部分工時</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="averageSalary2">平均薪資</label>
	          <input type="text" id="averageSalary2" name="averageSalary" class="readonly" placeholder="填寫完自動計算" readonly>
	          </div>
	        
	          <div class="m">
	          <label for="recurringSalary2">經常性薪資</label>
	          <input type="text" id="recurringSalary2" name="recurringSalary" pattern="[0-9]*" placeholder="申請前3個月總和"> 
	          ( 本薪 / 津貼 / 經常性獎金 )
	          <img src="images/icon_qu.png" class="icon_qu"
	          title="【經常性薪資】
	包含：本薪、交通津貼、伙食津貼、
	　　　績效獎金、全勤獎金、工作獎金；  
	不含：差旅費、差旅津貼、交際費。"></div>
	        
	          <div class="m">
	          <label for="notRecurringSalary2">非經常性薪資</label>
	          <input type="text" id="notRecurringSalary2" name="notRecurringSalary" placeholder="申請前3個月總和">
	( 加班費 / 不休假獎金 )
	          <img src="images/icon_qu.png" class="icon_qu"
	          title="【非經常性薪資】
	包含：加班費、不休假獎金；  
	不含：紅利、年終獎金、久任獎金、三節獎
	　　　金、醫療補助費、子女教育補助費。"></div>
	
	          <div class="close"><button class="close" title="移除此筆資料">X</button></div>
	          
	        </li>
	        
	        
	        <!---03--->
	        <li>
	          <div class="ss">
	          <label for="name3">勞工姓名</label>
	          <input type="text" id="name3" name="name">
	          </div>
	          
	          <div class="ss">
	          <label for="identification3">身分證字號</label>
	          <input type="text" id="identification3" name="identification">
	          </div>
	        
	          <!---<div class="ss">
	          <label for="">出生年月日</label>
	          <input type="text" placeholder="yyymmdd">
	          </div>--->
	        
	          <div class="ss">
	          <label for="insuranceType3">保險類型</label>
	          <select id="insuranceType3" name="insuranceType">
	            <option value>請選擇</option>
	            <option value="1">勞工保險</option>
	            <option value="2">職災保險</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="insuranceTime3">加保日期</label>
	          <input type="text" id="insuranceTime3" name="insuranceTime" placeholder="yyymmdd" maxlength="7" oninput = "value=value.replace(/[^\d]/g,'')">
	          </div>
	        
	          <div class="ss">
	          <label for="manager3">職務類型</label>
	          <select id="manager3" name="manager">
	            <option value>請選擇</option>
	            <option value="Y">主管</option>
	            <option value="N">非主管</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="relatives3">親等關係</label>
	          <select id="relatives3" name="relatives">
	            <option value>請選擇</option>
	            <option value="N">非三親等</option>
	            <option value="Y">三親等內</option>
	          </select>
	          <img src="images/icon_qu.png" class="icon_qu"
	          title="【三親等內】之親屬包含：
	配偶、父母、子女、兄弟姊妹、
	(外)祖父母、(外)孫子女、
	伯、叔、姑、舅、姨、
	姪子(女)、外甥(女)、
	(外)曾祖父母、(外)曾孫子女">
	          </div>
	        
	          <div class="ss">
	          <label for="workingHours3">工時類型</label>
	          <select id="workingHours3" name="workingHours">
	            <option value>請選擇</option>
	            <option value="A">全時</option>
	            <option value="P">部分工時</option>
	          </select>
	          </div>
	        
	          <div class="ss">
	          <label for="averageSalary3">平均薪資</label>
	          <input type="text" id="averageSalary3" name="averageSalary" class="readonly" placeholder="填寫完自動計算" readonly>
	          </div>
	        
	          <div class="m">
	          <label for="recurringSalary3">經常性薪資</label>
	          <input type="text" id="recurringSalary3" name="recurringSalary" pattern="[0-9]*" placeholder="申請前3個月總和"> 
	          ( 本薪 / 津貼 / 經常性獎金 )
	          <img src="images/icon_qu.png" class="icon_qu"
	          title="【經常性薪資】
	包含：本薪、交通津貼、伙食津貼、
	　　　績效獎金、全勤獎金、工作獎金；  
	不含：差旅費、差旅津貼、交際費。"></div>
	        
	          <div class="m">
	          <label for="notRecurringSalary3">非經常性薪資</label>
	          <input type="text" id="notRecurringSalary3" name="notRecurringSalary" placeholder="申請前3個月總和">
	( 加班費 / 不休假獎金 )
	          <img src="images/icon_qu.png" class="icon_qu"
	          title="【非經常性薪資】
	包含：加班費、不休假獎金；  
	不含：紅利、年終獎金、久任獎金、三節獎
	　　　金、醫療補助費、子女教育補助費。"></div>
	
	          <div class="close"><button class="close" title="移除此筆資料">X</button></div>
	          
	        </li>       
	        
	        </c:otherwise></c:choose>
	        
	      
	      </ol>
      
	      </form>
	      <div class="btn_box">
	      <button class="subjoin" onclick="listAdd()">＋增加欄位</button>
	<!--       <button class="delete" onclick="listDelete()">－減少欄位</button> -->
	      <button class="save" onclick="listSave('Y')">暫存資料</button>
	      </div>
      </div>
      <div class="staff_excel" id="listFile" style="display:none">
        
        <div class="title text-center mt-3 mb-4 w-100">請上傳「最新完整資料」，每次上傳皆會覆蓋先前資料，請確認後再送出！</div>
        <div class="file_box text-center"> 
            <input type="file" id="uploadFile" name="uploadFile" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <button class="upload" onclick="fileUpload('Y')">上傳檔案</button>
        </div>
		<c:choose><c:when test="${not empty employmentListAttachment}">
	      	<c:forEach items="${employmentListAttachment}" var="item" varStatus="status">
		      	<c:choose>
			      	<c:when test="${item.fileType=='employmentList' }">
			      	<br>
			      		<div class="file_box text-center" id="alreadyExist">
					        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>
					        <span class="file_progress">上傳完成</span>
					        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>
					        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
				        </div>
			      	</c:when>
		      	</c:choose>
	      	</c:forEach>
        </c:when></c:choose>
      </div>
      
    </div>
    



    <!-------------近三年申請之留任狀況------------>
<!--     <div class="form"> -->
    
<!--       <div class="title_main"><span>近三年申請之留任狀況</span> -->
<!--       <em>請視需要自行增刪欄位，若需填寫較多員工，建議下載 -->
<!--       【<a href="#" title="Excel申請專用表格(另開視窗)">留任狀況專用表格.xlsx</a>】 -->
<!--       填寫後上傳</em> -->
<!--       </div> -->
      
<!--       <ol class="staff" id="situationStaff"> -->
<%--       	<c:choose><c:when test="${advancedAgeApplyEmployedSituations != '[]'}"> --%>
<%--         <c:forEach items="${advancedAgeApplyEmployedSituations}" var="item" varStatus="status"> --%>
<!--         	<li> -->
<!-- 	          <div class="ss"> -->
<%-- 	          <label for="applyYear${status.count}">申請年度</label> --%>
<%-- 	          <input type="text" pattern="[0-9]" placeholder="yyy" maxlength="3" id="applyYear${status.count}" name="applyYear" value="${item.applyYear}"> --%>
<!-- 	          </div> -->
	        
<!-- 	          <div class="ss"> -->
<%-- 	          <label for="workName${status.count}">補助勞工姓名</label> --%>
<%-- 	          <input type="text" id="workName${status.count}" name="workName" value="${item.name}"> --%>
<!-- 	          </div> -->
	        
<!-- 	          <div class="ss"> -->
<%-- 	          <label for="workIdentification${status.count}">身分證字號</label> --%>
<%-- 	          <input type="text" id="workIdentification${status.count}" name="workIdentification" value="${item.identification}">  --%>
<!-- 	          </div> -->
	        
<!-- 	          <div class="ss"> -->
<%-- 	          <label for="employedAmong${status.count}">獲補助月數</label> --%>
<%-- 	          <input type="number" step="1" min="0" id="employedAmong${status.count}" name="employedAmong" value="${item.employedAmong}"> --%>
<!-- 	          </div> -->
	        
<!-- 	          <div class="full"> -->
<!-- 	          <label for="employedExpiredStatus1">續期滿後留任狀況：</label> -->
<!-- 	            <span> -->
<%-- 	            <input type="radio" name="employedExpiredStatus${status.count}" value="1" id="employedExpiredStatus1${status.count}" <c:if test="${item.employedExpiredStatus=='1'}">checked</c:if>> --%>
<!-- 	            於繼續僱用18個月內離職 -->
<!-- 	            </span> -->
<!-- 	            <span> -->
<%-- 	            <input type="radio" name="employedExpiredStatus${status.count}" value="2" id="employedExpiredStatus2${status.count}" <c:if test="${item.employedExpiredStatus=='2'}">checked</c:if>> --%>
<!-- 	            於繼續僱用18個月後 -->
<%-- 	            <input type="number" step="1" min="0" style="width:50px;" id="employedExpiredResign${status.count}" name="employedExpiredResign" value="${item.employedExpiredResign}"> --%>
<!-- 	            個月離職 -->
<!-- 	            </span> -->
<%-- 	            <input type="radio" name="employedExpiredStatus${status.count}" value="3" id="employedExpiredStatus3${status.count}" <c:if test="${item.employedExpiredStatus=='3'}">checked</c:if>> --%>
<!-- 	            已滿18個月在職中 -->
<!-- 	          </div> -->
	
<!-- 	          <div class="close"><button class="close" title="移除此筆資料">X</button></div> -->
	          
<!-- 	        </li> -->
<%--         </c:forEach> --%>
<%--         </c:when> --%>
<%--         <c:otherwise> --%>
<%-- 	      	<c:forEach var="i" begin="1" end="2"> --%>
<!-- 	        <li> -->
<!-- 	          <div class="ss"> -->
<%-- 	          <label for="applyYear${i}">申請年度</label> --%>
<%-- 	          <input type="text" pattern="[0-9]" placeholder="yyy" maxlength="3" id="applyYear${i}" name="applyYear"> --%>
<!-- 	          </div> -->
	        
<!-- 	          <div class="ss"> -->
<%-- 	          <label for="workName${i}">補助勞工姓名</label> --%>
<%-- 	          <input type="text" id="workName${i}" name="workName"> --%>
<!-- 	          </div> -->
	        
<!-- 	          <div class="ss"> -->
<%-- 	          <label for="workIdentification${i}">身分證字號</label> --%>
<%-- 	          <input type="text" id="workIdentification${i}" name="workIdentification">  --%>
<!-- 	          </div> -->
	        
<!-- 	          <div class="ss"> -->
<%-- 	          <label for="employedAmong${i}">獲補助月數</label> --%>
<%-- 	          <input type="number" step="1" min="0" id="employedAmong${i}" name="employedAmong"> --%>
<!-- 	          </div> -->
	        
<!-- 	          <div class="full"> -->
<%-- 	          <label for="employedExpiredStatus1${i}">續期滿後留任狀況：</label> --%>
<!-- 	            <span> -->
<%-- 	            <input type="radio" name="employedExpiredStatus${i}" value="1" id="employedExpiredStatus1${i}"> --%>
<!-- 	            於繼續僱用18個月內離職 -->
<!-- 	            </span> -->
<!-- 	            <span> -->
<%-- 	            <input type="radio" name="employedExpiredStatus${i}" value="2" id="employedExpiredStatus2${i}"> --%>
<!-- 	            於繼續僱用18個月後 -->
<%-- 	            <input type="number" step="1" min="0" style="width:50px;" id="employedExpiredResign${i}" name="employedExpiredResign"> --%>
<!-- 	            個月離職 -->
<!-- 	            </span> -->
<%-- 	            <input type="radio" name="employedExpiredStatus${i}" value="3" id="employedExpiredStatus3${i}"> --%>
<!-- 	            已滿18個月在職中 -->
<!-- 	          </div> -->
	
<!-- 	          <div class="close"><button class="close" title="移除此筆資料">X</button></div> -->
	          
<!-- 	        </li> -->
	        
<%-- 	      </c:forEach> --%>
<%-- 	    </c:otherwise></c:choose> --%>
<!--       </ol> -->
      
      
<!--       <div class="btn_box"> -->
<!--       <button class="subjoin" onclick="situationAdd()">＋增加欄位</button> -->
<!--       <button class="delete" onclick="situationDelete()">－減少欄位</button> -->
<!--       <button class="save" onclick="situationSave()">暫存資料</button> -->
<!--       </div>   -->
      
<!--     </div> -->

    <!------------ loading 效果 ------------>
    <div id="loader-container" style="display:none;">
    <p id="loadingText">Loading</p>
    </div>
   	
    <div class="page">
      <button onclick="javascript:location.href='employ_02?sid=${sid}'">回上頁</button>
      <button onclick="totalSave('Y')">暫存資料</button>
      <button onclick="next()">下一步</button>
    </div>
<!--     <div id=loading style="position:fixed; left:423px; top:261px; width:227px; height:20px; z-index:1;margin-top:5%;margin-left:20%"> -->
<!-- <p style="font-weight:bold;">正在載入中,請稍等.....</p> -->
<!-- <img src="images/loading.gif" style="width:100px;"></div> -->
<!-- 	</div> -->
    
  </div>
  <!------------ 申請流程 END ------------>
    
  </div>
  <!--- main end ---> 
  
  <!--- footer --->
  <footer class="copyright">
    <section>
      <div>勞動力發展署：24219新北市新莊區中平路439號南棟4樓　電話代表號：(02)8995-6000　客服專線：0800-777-888</div>
      <div>本署服務時間：週一至週五　上午8時30分至12時30分，下午13時30分至17時30分</div>
      <div>最佳解析度1024x768 ，建議更新瀏覽器至以下版本：最新版本Chrome、最新版本Firefox</div>
      <div>中華民國勞動部勞動力發展署版權所有 © 2021 All rights reserved. </div>
    </section>
  </footer>
  <!--- footer end ---> 
  
</div>
<script src="js/jquery-3.6.0.min.js"></script> 
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<script src="js/employ_03/employ_03.js"></script>

<script src="js/jquery.validate.min.js"></script>
<script src="js/additional-methods.min.js"></script>
<script src="js/messages_zh_TW.min.js"></script>
</body>
</html>