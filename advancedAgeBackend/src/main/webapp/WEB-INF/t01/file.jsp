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
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />


</head>

<body class="body">

<div class="main_box">
    
    <div class="file_title">
      <span class="number">${apply.applyYear}年度</span>
      <span class="txt">附件檢查與通知</span>
    </div>
    
    <!--- 申請者基本資料 --->
    <div class="file_info">
      <table>
        <tr>
          <th width="13%">單位名稱：</th>
          <td width="36%">${apply.companyName}</td>
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
    <input type="text" id="applyId" value="${apply.id}" style="display:none">
    <input type="text" id="baseAaid" value="${base.aaid}" style="display:none">
    <input type="text" id="verifyUnit" value="${unit}" style="display:none">
    <input type="text" id="verifyPerson" value="${id}" style="display:none">
    <!----- 檢附文件 ----->
    <div class="file_title-2">檢附文件</div>

    <c:forTokens items="${base.fileStatusRecord}" delims=";" var="recordItem" varStatus="recordStatus">
    <!---- 上傳日期做區隔 ---->
    <div class="file_group">
      <ul class="file_list">
      
        <li>
          <div class="file-name">設立登記證明</div>
          <div class="file-preview">
            <c:choose>
	            <c:when test="${not empty registerAttachment}">
	          		<c:set var="i" value="0"/>
			      	<c:forEach items="${registerAttachment}" var="item" varStatus="status">
				      	<c:choose>
					      	<c:when test="${item.fileType=='register' && item.fileFrequency == recordStatus.count}">
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
			   	</c:when>
		   	</c:choose>
          </div>
          <div class="file-check">
            <label for="registerFileStatus1${recordStatus.count}"><input type="checkbox" name="registerFileStatus1${recordStatus.count}" id="registerFileStatus1${recordStatus.count}" value="1" <c:if test="${recordItem.split('、')[0].indexOf('1')!=-1}">checked</c:if>>未附、尚有缺件</label>
            <label for="registerFileStatus2${recordStatus.count}"><input type="checkbox" name="registerFileStatus2${recordStatus.count}" id="registerFileStatus2${recordStatus.count}" value="2" <c:if test="${recordItem.split('、')[0].indexOf('2')!=-1}">checked</c:if>>不清晰、無法瀏覽</label>
            <label for="registerFileStatus3${recordStatus.count}"><input type="checkbox" name="registerFileStatus3${recordStatus.count}" id="registerFileStatus3${recordStatus.count}" value="3" <c:if test="${recordItem.split('、')[0].indexOf('3')!=-1}">checked</c:if>>格式不符、內容有誤</label>
            <label for="registerFileStatus4${recordStatus.count}"><input type="checkbox" name="registerFileStatus4${recordStatus.count}" id="registerFileStatus4${recordStatus.count}" value="4" <c:if test="${recordItem.split('、')[0].indexOf('4')!=-1}">checked</c:if>>符合</label>
          </div>
        </li>
        
        <li>
          <div class="file-name">聯合辦理單位授權書</div>
          <div class="file-preview">
            <c:choose>
	            <c:when test="${not empty jointAuthorizeAttachment}">
	            	<c:set var="i" value="0"/>
			      	<c:forEach items="${jointAuthorizeAttachment}" var="item" varStatus="status">
				      	<c:choose>
					      	<c:when test="${item.fileType=='jointAuthorize' && item.fileFrequency == recordStatus.count}">
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
			   	</c:when>
		   	</c:choose>
          </div>
          <div class="file-check">
            <label for="jointAuthorizeFileStatus1${recordStatus.count}"><input name="jointAuthorizeFileStatus1${recordStatus.count}" type="checkbox" id="jointAuthorizeFileStatus1${recordStatus.count}" value="1" <c:if test="${recordItem.split('、')[1].indexOf('1')!=-1}">checked</c:if>>未附、尚有缺件</label>
            <label for="jointAuthorizeFileStatus2${recordStatus.count}"><input name="jointAuthorizeFileStatus2${recordStatus.count}" type="checkbox" id="jointAuthorizeFileStatus2${recordStatus.count}" value="2" <c:if test="${recordItem.split('、')[1].indexOf('2')!=-1}">checked</c:if>>不清晰、無法瀏覽</label>
            <label for="jointAuthorizeFileStatus3${recordStatus.count}"><input name="jointAuthorizeFileStatus3${recordStatus.count}" type="checkbox" id="jointAuthorizeFileStatus3${recordStatus.count}" value="3" <c:if test="${recordItem.split('、')[1].indexOf('3')!=-1}">checked</c:if>>格式不符、內容有誤</label>
            <label for="jointAuthorizeFileStatus4${recordStatus.count}"><input name="jointAuthorizeFileStatus4${recordStatus.count}" type="checkbox" id="jointAuthorizeFileStatus4${recordStatus.count}" value="4" <c:if test="${recordItem.split('、')[1].indexOf('4')!=-1}">checked</c:if>>符合</label>
          </div>
        </li>
        
        <li>
          <div class="file-name">其他文件</div>
          <div class="file-preview">
            <c:choose>
	            <c:when test="${not empty necessaryAttachment}">
	            	<c:set var="i" value="0"/>
			      	<c:forEach items="${necessaryAttachment}" var="item" varStatus="status">
				      	<c:choose>
					      	<c:when test="${item.fileType=='necessary' && item.fileFrequency == recordStatus.count}">
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
			   	</c:when>
		   	</c:choose>
          </div>
          <div class="file-check">
            <label for="necessaryFileStatus1${recordStatus.count}"><input name="necessaryFileStatus1${recordStatus.count}" type="checkbox" id="necessaryFileStatus1${recordStatus.count}" value="1" <c:if test="${recordItem.split('、')[2].indexOf('1')!=-1}">checked</c:if>>未附、尚有缺件</label>
            <label for="necessaryFileStatus2${recordStatus.count}"><input name="necessaryFileStatus2${recordStatus.count}" type="checkbox" id="necessaryFileStatus2${recordStatus.count}" value="2" <c:if test="${recordItem.split('、')[2].indexOf('2')!=-1}">checked</c:if>>不清晰、無法瀏覽</label>
            <label for="necessaryFileStatus3${recordStatus.count}"><input name="necessaryFileStatus3${recordStatus.count}" type="checkbox" id="necessaryFileStatus3${recordStatus.count}" value="3" <c:if test="${recordItem.split('、')[2].indexOf('3')!=-1}">checked</c:if>>格式不符、內容有誤</label>
            <label for="necessaryFileStatus4${recordStatus.count}"><input name="necessaryFileStatus4${recordStatus.count}" type="checkbox" id="necessaryFileStatus4${recordStatus.count}" value="4" <c:if test="${recordItem.split('、')[2].indexOf('4')!=-1}">checked</c:if>>符合</label>
          </div>
        </li>
        
      </ul>
      
      <div class="upload-date">
        <span>上傳日期：
          <span class="btn">
	          <button type="button" <c:if test="${recordStatus.last}">class="btn_a1s"</c:if><c:if test="${!recordStatus.last}">class="btn_a3s"</c:if>>儲存</button>
	          <button type="button" class="btn_a2s" value="${recordStatus.count}">下載</button>
          </span>
          <span class="time">${recordItem.split('、')[3].substring(recordItem.split('、')[3].indexOf(" ")+1,recordItem.split('、')[3].length())}</span>
          <span class="date">${recordItem.split('、')[3].substring(0,4)-1911}${recordItem.split('、')[3].substring(4,recordItem.split('、')[3].indexOf(" "))}</span>
		  <input type="text" id="uploadTime${recordStatus.count}" name="uploadTime${recordStatus.count}" value="${recordItem.split('、')[3]}" style="display:none">
        </span>
      </div>
      
    </div>
    </c:forTokens>
    
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
    <div class="mail_title">補件通知 <small>( 內容將以電子郵件發送 )</small></div>
    
    <div class="mail_box">
      <div class="mail_text" id="mailHeader">
        臺端申請本部${apply.applyYear}年度中高齡者退休後再就業補助，經查核附件尚有缺件或不符規定。需補附件項目及原因如下：
      </div>
      <textarea class="textarea" rows="5" placeholder="請輸入文字" style="width:1100px" id="mailContent">${base.emailContent.replace('\\n','&#13;&#10;') }</textarea>
      <div class="mail_text" id="mailFooter">
        <a href="${mailDomain}/advancedAgeFrontend/career">${mailDomain}/advancedAgeFrontend/career</a><br>
        經通知限期補正，如逾期未補件，依規定不予受理。<br>
本項補助申請之附件檢查 "電子E-mail通知" 於 ${date} 發送，線上查詢內容與公文通知如有不同時，以公文通知為主。<br>
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
	      	</c:forEach></td>
          <th width="11%">審查人員：</th>
          <td width="14%">
          <c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
		      		<c:if test="${base.verifyPerson==userItem.id}">${userItem.name}</c:if> 
	      	</c:forEach></td>
          <th width="11%">通知日期：</th>
          <td><c:if test="${base.emailTime != null}"><fmt:formatDate pattern="yyyy-MM-dd" value="${base.emailTime}" var="emailTime" />${emailTime.substring(0,4)-1911}${emailTime.substring(4,emailTime.length())}</c:if></td>
        </tr>
        <tr>
          <th>其他備註：</th>
          <td colspan="5"><input type="text" style="width:840px"
            placeholder="審查人員可自行在此備註，如：電話聯繫...等" id="otherRemark" value="${base.fileRemark }"></td>
        </tr>
      </table>
    </div>
    
    
</div>
    
    
    
    
<div class="center">
  <button type="button" class="btn_02b" title="暫存" onclick="saveData()">暫存資料</button>
  <br><br>
</div>   
    
<div class="btn_box">
  <button type="button" class="btn_02b" title="附件齊全" onclick="finish()">附件齊全</button>
  <button type="button" class="btn_03b" title="送出補件通知" onclick="sendMail()">發送補件通知</button>
  <button type="button" class="btn_03b" title="關閉視窗" onclick="window.close();">關閉</button>   
</div>
    
<form action="downloadRar" method="post">
    	
</form>
    
<script type="text/javascript" src="js/jquery.min.js"></script>    
<script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="js/jspdf.min.js"></script>
<script type="text/javascript" src="js/html2canvas.min.js"></script>  
<script type="text/javascript" src="js/t01/file.js"></script>  
</body>


</html>
