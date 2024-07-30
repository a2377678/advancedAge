<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="utf-8">
<title>促進中高齡者及高齡者就業相關補助計畫系統</title>


<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/document.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="js/c01/c01_file.js"></script>
</head>

<body class="body">

<div class="main_box">
    
    <div class="file_title">
      <span class="number">${apply.applyYear}年度</span>
      <span class="txt">請領作業-附件檢查</span>
    </div>
    <input type="text" id="baseId" value="${base.id}" style="display:none">
    <!--- 申請者基本資料 --->
    <div class="file_info">
      <table>
        <tr>
          <th width="13%">單位名稱：</th>
          <td width="36%" id="companyName">${apply.companyName}</td>
          <th width="18%">負責人：</th>
          <td>${companyInfoData.get("principal") }</td>
        </tr>
        <tr>
          <th>行業別：</th>
          <td><c:forEach items="${industryList}" var="item"><c:if test="${item.code==apply.industry}">${item.name}</c:if></c:forEach></td>
          <th>統一編號：</th>
          <td>${apply.seq}</td>
        </tr>
        <tr>
          <th>聯絡人：</th>
          <td>${apply.contactName}</td>
          <th>聯絡人職稱：</th>
          <td>${apply.contactJobtitle}</td>
        </tr>
        <tr>
          <th>聯絡電話：</th>
          <td>${apply.contactWorkPhoneAreaCode} - ${apply.contactWorkPhone} #${apply.contactWorkPhoneExtension}</td>
          <th>行動電話：</th>
          <td>${apply.contactPhone}</td>
        </tr>
        <tr>
          <th>傳真號碼：</th>
          <td>${apply.faxAreaCode} - ${apply.fax}</td>
          <th>電子信箱：</th>
          <td>${apply.email}</td>
        </tr>
      </table>
    </div>
    <input type="text" id="email" value="${apply.email}" style="display:none">
    <input type="text" id="baseId" value="${base.id}" style="display:none">
    <input type="text" id="baseAaid" value="${base.aaid}" style="display:none">
    <input type="text" id="verifyUnit" value="${unit}" style="display:none">
    <input type="text" id="verifyPerson" value="${id}" style="display:none">
    <!----- 檢附文件 ----->
    <div class="file_title-2">請領檢附文件</div>

    
    <!---- 上傳日期做區隔 ---->
    <div class="file_group">
      <ul class="file_list-2">
      
        <li>
          <div class="file-name">原核定函影本</div>
          <div class="file-preview">
          		<c:choose><c:when test="${not empty approvedAttachment}">
	          		<c:set var="i" value="0"/>
			      	<c:forEach items="${approvedAttachment}" var="item" varStatus="status">
				      	<c:choose>
					      	<c:when test="${item.fileType=='approved'}">
					      		<c:set var="i" value="${i+1}"/>
					      		<div class="full">
			      			 		<a href="/file${item.filePath}/${item.fileName}" class="visited" target="_blank">
		      			 				<c:if test="${i<10}">0${i}</c:if>
		      			 				<c:if test="${i>10}">${i}</c:if>
						            </a> 
						        </div>
					      	</c:when>
				      	</c:choose>
			      	</c:forEach>
			   	</c:when></c:choose>
          </div>
        </li>
        
        <li>
          <div class="file-name">領據</div>
          <div class="file-preview">
            <c:choose><c:when test="${not empty receiptAttachment}">
          		<c:set var="i" value="0"/>
		      	<c:forEach items="${receiptAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='receipt'}">
				      		<c:set var="i" value="${i+1}"/>
				      		<div class="full">
		      			 		<a href="/file${item.filePath}/${item.fileName}" class="visited" target="_blank">
	      			 				<c:if test="${i<10}">0${i}</c:if>
	      			 				<c:if test="${i>10}">${i}</c:if>
					            </a> 
					        </div>
				      	</c:when>
			      	</c:choose>
		      	</c:forEach>
		   	</c:when></c:choose>
          </div>
        </li>
      
        <li>
          <div class="file-name">僱用證明</div>
          <div class="file-preview">
            <c:choose><c:when test="${not empty employmentAttachment}">
          		<c:set var="i" value="0"/>
		      	<c:forEach items="${employmentAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='employment'}">
				      		<c:set var="i" value="${i+1}"/>
				      		<div class="full">
		      			 		<a href="/file${item.filePath}/${item.fileName}" class="visited" target="_blank">
	      			 				<c:if test="${i<10}">0${i}</c:if>
	      			 				<c:if test="${i>10}">${i}</c:if>
					            </a> 
					        </div>
				      	</c:when>
			      	</c:choose>
		      	</c:forEach>
		   	</c:when></c:choose>
          </div>
        </li>
        
        <li>
          <div class="file-name">薪資證明</div>
          <div class="file-preview">
            <c:choose><c:when test="${not empty salaryAttachment}">
          		<c:set var="i" value="0"/>
		      	<c:forEach items="${salaryAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='salary'}">
				      		<c:set var="i" value="${i+1}"/>
				      		<div class="full">
		      			 		<a href="/file${item.filePath}/${item.fileName}" class="visited" target="_blank">
	      			 				<c:if test="${i<10}">0${i}</c:if>
	      			 				<c:if test="${i>10}">${i}</c:if>
					            </a> 
					        </div>
				      	</c:when>
			      	</c:choose>
		      	</c:forEach>
		   	</c:when></c:choose>
          </div>
        </li>
        
        <li>
          <div class="file-name">出勤證明文件</div>
          <div class="file-preview">
            <c:choose><c:when test="${not empty attendanceAttachment}">
          		<c:set var="i" value="0"/>
		      	<c:forEach items="${attendanceAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='attendance'}">
				      		<c:set var="i" value="${i+1}"/>
				      		<div class="full">
		      			 		<a href="/file${item.filePath}/${item.fileName}" class="visited" target="_blank">
	      			 				<c:if test="${i<10}">0${i}</c:if>
	      			 				<c:if test="${i>10}">${i}</c:if>
					            </a> 
					        </div>
				      	</c:when>
			      	</c:choose>
		      	</c:forEach>
		   	</c:when></c:choose>
          </div>
        </li>
        
        <li>
          <div class="file-name">其他文件</div>
          <div class="file-preview">
            <c:choose><c:when test="${not empty necessaryAttachment}">
          		<c:set var="i" value="0"/>
		      	<c:forEach items="${necessaryAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='necessary'}">
				      		<c:set var="i" value="${i+1}"/>
				      		<div class="full">
		      			 		<a href="/file${item.filePath}/${item.fileName}" class="visited" target="_blank">
	      			 				<c:if test="${i<10}">0${i}</c:if>
	      			 				<c:if test="${i>10}">${i}</c:if>
					            </a> 
					        </div>
				      	</c:when>
			      	</c:choose>
		      	</c:forEach>
		   	</c:when></c:choose>
          </div>
        </li>
        
      </ul>
      
      <div class="upload-date">
        <span>
<!--         上傳日期： -->
        	<span class="btn">
<!-- 	        <button type="button" class="btn_a3s">儲存</button> -->
	        <button type="button" class="btn_a2s" value="${frequency}">下載</button>
	        </span>
<%-- 	        <span class="time">${base.allowanceFileStatusRecord.split(';')[frequency-1].split('、')[6].substring(11)}</span> --%>
<%-- 	        <span class="date">${base.allowanceFileStatusRecord.split(';')[frequency-1].split('、')[6].substring(0,4)-1911}${base.allowanceFileStatusRecord.split(';')[frequency-1].split('、')[6].substring(4,10) }</span> --%>
        </span>
      </div>
      
    </div>
    <!---------- 歷次補件通知紀錄 ---------->
    <div class="mail_title">歷次補件通知紀錄</div>
    
    <div class="mail_box mb-4 py-4">

      <div class="accordion" id="">
        <c:choose><c:when test="${not empty mailRecord}">
        	<c:forEach items="${mailRecord}" var="item" varStatus="status">
        		<div class="accordion-item">
		          <h2 class="accordion-header" id="flush-heading-${status.count }">
		            <button class="accordion-button fs-6 bg-light" type="button" data-bs-toggle="collapse" 
		              data-bs-target="#flush-collapse-${status.count }" aria-expanded="false" aria-controls="flush-collapsefa-stack-${status.count }">
		              <span class="text-success fw-bold">通知日期：${item.createTime.substring(0,4)-1911}${item.createTime.substring(4)}</span>
		              <span class="text-muted px-5">審查單位：
		              <c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
				      		<c:if test="${base.verifyUnit==unitItem.code}">${unitItem.name}</c:if> 
				      	</c:forEach>
		              </span>
		              <span class="text-muted">審查人員：<c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
				      		<c:if test="${base.verifyPerson==userItem.id}">${userItem.name}</c:if> 
				      	</c:forEach>
				      	</span>
		            </button>
		          </h2>
		          <div id="flush-collapse-${status.count }" class="accordion-collapse collapse" 
		            aria-labelledby="flush-heading-${status.count }" data-bs-parent="#accordionFlushExample">
		            <div class="accordion-body fs-6">
		            	${item.mailContent.replace('\\n','<br>').replace('\\','"')}
		            </div>
		          </div>
		        </div>
        	</c:forEach>
        </c:when></c:choose>

      </div>

    </div>
    
  <!------- 補件通知 ------->
    <div class="mail_title"><span class="txt">請領</span>作業補件通知 <small>( 內容將以電子郵件發送 )</small></div>
    
    <div class="mail_box">
      <div class="mail_text" id="mailHeader">
        臺端申請本部${apply.applyYear}年度繼續僱用高齡者補助，經查核 第${frequency}次請領附件 尚有缺件或不符規定。需補附件項目及原因如下：
      </div>
      <textarea class="textarea" rows="5" placeholder="請輸入文字" style="width:1100px" id="mailContent">${base.allowanceEmailContent.replace('\\n','&#13;&#10;') }</textarea>
      <div class="mail_text" id="mailFooter">
        補件網址：<a href="${mailDomain}/advancedAgeFrontend/employ_payment">${mailDomain}/advancedAgeFrontend/employ_payment</a><br>
        經通知限期補正，如逾期未補件，依規定不予受理。<br>
本項補助申請之附件檢查 "電子E-mail通知" 於 ${today.substring(0,4)-1911}年${today.substring(4,6)}月${today.substring(6,8)}日 發送，線上查詢內容與公文通知如有不同時，以公文通知為主。<br>
祝福您　健康如意　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　勞動部敬上
      </div>
    </div>
    
    
    
    <!--- 審核資料 --->
    <div class="">
      <table class="table_01">
        <tr>
          <th width="11%" nowrap>審查單位：</th>
          <td width="20%">
          	<c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
	      		<c:if test="${base.verifyUnit==unitItem.code}">${unitItem.name}</c:if> 
	      	</c:forEach>
          </td>
          <th width="11%">審查人員：</th>
          <td width="14%">
          	<c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
	      		<c:if test="${base.verifyPerson==userItem.id}">${userItem.name}</c:if> 
	      	</c:forEach>
          </td>
          <th width="11%">更新日期：</th>
          <td><c:if test="${base.allowanceEmailTime != null}"><fmt:formatDate pattern="yyyy-MM-dd" value="${base.allowanceEmailTime}" var="emailTime" />${emailTime.substring(0,4)-1911}${emailTime.substring(4,emailTime.length())}</c:if></td>
        </tr>
        <tr>
          <th>其他備註：</th>
          <td colspan="5"><input type="text" style="width:840px" placeholder="審查人員可自行在此備註，如：電話聯繫...等" id="otherRemark" value="${base.allowanceFileRemark }"></td>
        </tr>
      </table>
    </div>
    
    
</div>
    
<div class="center">
  <button type="button" class="btn_02b" title="暫存" onclick="saveData()">暫存資料</button>
  <br><br>
</div>   
    
<div class="btn_box">
  <button type="button" class="btn_03b" title="送出補件通知" onclick="sendMail()">發送補件通知</button>
  <button type="button" class="btn_03b" title="關閉頁面" onclick="window.close()">關閉頁面</button>   
</div>
    
    
  
  
</body>


</html>
