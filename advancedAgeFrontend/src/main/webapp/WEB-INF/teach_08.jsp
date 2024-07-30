<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script src="js/teach_08/teach_08.js"></script>
</head>
<style type="text/css">
	@page {
     size: A4 landscape; /*直式portrait 橫式landscape*/
     margin: 1cm;  /*print邊界*/
	}
</style>
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
        <li class="breadcrumb-item active" aria-current="page">線上申辦</li>
        <li class="breadcrumb-item active" aria-current="page">僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 申請作業</li>
      </ol>
    </nav>
    <h1>僱用退休中高齡者及高齡者傳承專業技術及經驗補助計畫 - 申請作業</h1>
    <h2>申請流程 Step8. 送出申請</h2>
    <h3><span class="title">您申請的案件已送出</span></h3>
    
    <div>
    	<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${base.createTime}" var="createTime" />
        <div class="fs-5 fw-bolder">申請日期：${createTime.substring(0,4)-1911}/${createTime.substring(5,7)}/${createTime.substring(8,createTime.length())}</div>
      <h4>《 申辦完成不代表審核通過 》</h4>
      <p>
      如有補件或修改送件資料需求，或您有任何疑問<br>
      請於周一至周五 上班時間洽詢 <a href="https://job.taiwanjobs.gov.tw/internet/index/service_location.aspx" target="_blank">受理單位</a>
      </p>
    </div>
    <div style="display:none">
    <!--startprint-->
      <div class="form">
        <div class="title_main"><span>申請書</span></div>
        <div><span class="title-c">單位名稱</span>${apply.companyName}</div>
        <input type="text" id="companyName" value="${apply.companyName}" style="display:none">
        <div><span class="title-c">統一編號</span>${apply.seq}</div>
        <input type="text" id="seq" value="${apply.seq}" style="display:none">
        <div><span class="title-c">行業別</span><c:forEach items="${industryList}" var="item"><c:if test="${item.code==apply.industry}">${item.name}</c:if></c:forEach></div>
        <div><span class="title-c">單位屬性</span><c:if test="${apply.companyAttributes=='B' }">民營事業單位</c:if>
        			<c:if test="${apply.companyAttributes=='G' }">民間團體</c:if>
        			<c:if test="${apply.companyAttributes=='S' }">私立學校</c:if>
        </div>
        <div><span class="title-c">勞保投保證號</span>${apply.guaranteeNumber.replace(";","、")}</div>
        <div class="full"><span class="title-c">聯絡地址</span>
        <c:forEach items="${cityList}" var="item"><c:if test="${item.code==apply.contactCity}">${item.name}</c:if></c:forEach><c:forEach items="${areaList}" var="item"><c:if test="${item.code==apply.contactArea}">${item.name}</c:if></c:forEach>${apply.contactAddress}
      	<input type="text" id="city" value="${apply.registerCity}" style="display:none">
		</div>
        <div><span class="title-c">聯絡人</span>${apply.contactName}</div>
        <div><span class="title-c">聯絡人職稱</span>${apply.contactJobtitle}</div>
        <div><span class="title-c">聯絡電話</span>${apply.contactWorkPhoneAreaCode} - ${apply.contactWorkPhone} #${apply.contactWorkPhoneExtension}</div>
        <div><span class="title-c">行動電話</span>${apply.contactPhone}</div>
        <div><span class="title-c">傳真號碼</span>${apply.faxAreaCode} - ${apply.fax}</div>
        <div><span class="title-c">電子信箱</span>${apply.email}</div>
        <input type="text" id="email" value="${apply.email}" style="display:none">
      </div>



      <div class="form">
        <div class="title_main"><span>計畫書</span></div>
        <div class="full"> <span class="title-c">主要業務/產品/服務</span>${plan.items}</div>
        <div class="full"> <span class="title-c">友善高齡者職場措施</span>${plan.friendlyMeasures}</div>
        <div class="ss"><span class="title-c">員工總人數</span>${plan.employmentNumber}</div>
        <div class="ss"><span class="title-c">未滿29歲人數</span>${plan.lowerEmploymentNumber}</div>
        <div class="ss"><span class="title-c">29歲至44歲人數</span>${plan.lowEmploymentNumber}</div>
        <div class="ss"><span class="title-c">45歲至64歲人數</span>${plan.middleEmploymentNumber}</div>
        <div class="ss"><span class="title-c">65歲以上人數</span>${plan.highEmploymentNumber}</div>
        <div class="ss"><span class="title-c">本計畫申請高齡講師數</span>${plan.retirementEmploymentNumber}</div>
        <div class="full lh-lg"><span class="title-c">計畫之必要性 / 可行性</span>${plan.planDescription}</div>
        <div class="full"><span class="title-c">執行方式 ( 可複選 )</span>
        <c:if test="${plan.executionWay.indexOf('S')!=-1 }">實務技術指導、</c:if>
        <c:if test="${plan.executionWay.indexOf('C')!=-1 }">教育訓練課程講授、</c:if>
        <c:if test="${plan.executionWay.indexOf('O')!=-1 }">其他－${plan.executionWayDescription}</c:if>
        </div>
        <div class="full"><span class="title-c">預計執行期間</span>${plan.planStartTime }~${plan.planEndTime }止</div>
      </div>
      
      <div class="form">
        <div class="title_main"><span>計畫達成指標及預期效益</span></div>
        <div class="full lh-lg"><span class="title-c">預計傳承之內容及時數：</span><br>
          	${plan.experienceInheritance.replace("\\n","<br>") }
        </div>
        <div class="full lh-lg"><span class="title-c">參加課程或接受指導人次：</span><br>
          	${plan.participate.replace("\\n","<br>") }
        </div>
        <div class="full lh-lg"><span class="title-c">其他效益說明：</span><br>
        	${plan.benefit.replace("\\n","<br>") }
        </div>
      </div>




      <div class="form">
        <div class="title_main"><span>傳承專業技術及經驗之講師名單</span></div>
        
        <c:if test="${plan.attachSpeakerList =='Y'}">
	    	<c:choose><c:when test="${not empty speakerListAttachment}">
		      	<c:forEach items="${speakerListAttachment}" var="item" varStatus="status">
			      	<c:choose>
				      	<c:when test="${item.fileType=='speakerList' }">
				      	<br>
				      		<div class="full">
						        <span class="file_name"><a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a></span>&nbsp;&nbsp;
						        <span class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>&nbsp;&nbsp;
						        <span class="file_size"><fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB</span>
					        </div>
				      	</c:when>
			      	</c:choose>
		      	</c:forEach>
          </c:when></c:choose>
        </c:if>
        <c:if test="${plan.attachSpeakerList =='N'}">
	        <!---填寫名單--->
	        <div class="staff_list">
	          <ul class="clearfix">
	            <li>
	              <span>勞工姓名</span>
	              <span>出生日期</span>
	              <span>身分證字號</span>
	              <span>保險類型</span>
	              <span>加保日期</span>
	              <span>職務類型</span>
	              <span>親等關係</span>
	              <span>工時類型</span>
	              <span class="l">計畫執行方式</span>
	            </li>
	          </ul>
	        </div>
	        
	        <div class="staff_list">
	          <ol>
	          <c:choose><c:when test="${speakerLists !='[]'}">
	          <c:forEach items="${speakerLists}" var="item" varStatus="status">
	            <li>
	              <span>${item.name }</span>
	              <span>${item.birthday.substring(0,3)}/${item.birthday.substring(3,5)}/${item.birthday.substring(5)}</span>
	              <span>${item.identification }</span>
	              <span>
	              	<c:if test="${item.laborProtectionTime.length()==7}">勞工保險</c:if>
	              	<c:if test="${item.occupationalAccidentProtectionTime.length()==7}">職災保險</c:if>
	              </span>
	              <span>
	              	<c:if test="${item.laborProtectionTime.length()==7}">${item.laborProtectionTime.substring(0,3)}/${item.laborProtectionTime.substring(3,5)}/${item.laborProtectionTime.substring(5)}</c:if>
		            <c:if test="${item.occupationalAccidentProtectionTime.length()==7}">${item.occupationalAccidentProtectionTime.substring(0,3)}/${item.occupationalAccidentProtectionTime.substring(3,5)}/${item.occupationalAccidentProtectionTime.substring(5)}</c:if>
	              </span>
	              <span>
	              	<c:if test="${item.manager=='Y'}">主管</c:if>
		            <c:if test="${item.manager=='N'}">非主管</c:if>
	              </span>
	              <span>
	              	<c:if test="${item.relatives=='Y'}">三等親內</c:if>
		            <c:if test="${item.relatives=='N'}">非三等親</c:if>
	              </span>
	              <span>
	              	<c:if test="${item.workingHours=='A'}">全時</c:if>
		            <c:if test="${item.workingHours=='P'}">部分工時</c:if>
	              </span>
	              <span class="l">
	              	<c:if test="${item.executionWay=='S'}">教育訓練課程講授</c:if>
		            <c:if test="${item.executionWay=='C'}">實務技術指導</c:if>
	              </span>
	            </li>
	            </c:forEach>
	            </c:when></c:choose>
	          </ol>
	        </div>
	        
        </c:if>
      </div>

      <div class="form">
        <div class="title_main"><span>課程規劃</span></div>
        <c:choose><c:when test="${scheduleLists !='[]'}">
	        <c:forEach items="${scheduleLists}" var="item" varStatus="status">
	          <!---課程規劃--->
	          <table class="table_05">
	            <tr>
	              <th colspan="2">預計執行期間</th>
	              <th colspan="2">計畫執行地</th>
	            </tr>
	            <tr>
	              <td colspan="2">${item.executionStartTime.substring(0,3)}/${item.executionStartTime.substring(3,5)}/${item.executionStartTime.substring(5)}
	              ~${item.executionEndTime.substring(0,3)}/${item.executionEndTime.substring(3,5)}/${item.executionEndTime.substring(5)}</td>
	              <td colspan="2">
	              	<c:forEach items="${cityList}" var="cityItem"><c:if test="${cityItem.code==item.executionCity}">${cityItem.name}</c:if></c:forEach>
	              </td>
	            </tr>
	            <tr>
	              <th colspan="4">課程名稱</th>
	            </tr>
	            <tr>
	              <td colspan="4">${item.subject }</td>
	            </tr>
	            <tr>
	              <th>開課時間</th>
	              <th>講師姓名</th>
	              <th>預計授課時數</th>
	              <th>預計參訓人數</th>
	            </tr>
	            <tr>
	              <td>${item.executionTime.replaceAll('=',':') }</td>
	              <td>${item.speakerName }</td>
	              <td>${item.teachingHours }</td>
	              <td>${item.participateNumber }</td>
	            </tr>
	            <tr>
	              <td colspan="4" style="text-align:left;">課程大綱：${item.introduction.replace("\\n","<br>") }</td>
	            </tr>
	            <tr>
	              <td colspan="4" style="text-align:left;">預計參訓學員：${item.participatePeople }</td>
	            </tr>
	          </table>
        	</c:forEach>
        </c:when></c:choose>
      </div>

	  <div class="form">
        <div class="title_main"><span>參訓學員名單</span></div>
        
        <!---填寫名單--->
        <div class="staff_list">
          <ul class="clearfix">
            <li>
              <span>勞工姓名</span>
              <span>保險類型</span>
              <span>加保日期</span>
              <span>年資(年)</span>
              <span>年資(月)</span>
              <span>職務類型</span>
              <span>工時類型</span>
              <span class="l">部門</span>
            </li>
          </ul>
        </div>
        
        <div class="staff_list">
          <ol>
          <c:choose><c:when test="${participateLists !='[]'}">
	        <c:forEach items="${participateLists}" var="item" varStatus="status">
	            <li>
	              <span>${item.name }</span>
	              <span>
	              	<c:if test="${item.laborProtectionTime.length()==7}">勞工保險</c:if>
	              	<c:if test="${item.occupationalAccidentProtectionTime.length()==7}">職災保險</c:if>
	              </span>
	              <span>
	              	<c:if test="${item.laborProtectionTime.length()==7}">${item.laborProtectionTime.substring(0,3)}/${item.laborProtectionTime.substring(3,5)}/${item.laborProtectionTime.substring(5)}</c:if>
	              	<c:if test="${item.occupationalAccidentProtectionTime.length()==7}">${item.occupationalAccidentProtectionTime.substring(0,3)}/${item.occupationalAccidentProtectionTime.substring(3,5)}/${item.occupationalAccidentProtectionTime.substring(5)}</c:if>
	              </span>
	              <span>${item.seniority }</span>
	              <span>${item.seniorityMonth }</span>
	              <span>
	              	<c:if test="${item.manager=='Y'}">主管</c:if>
		            <c:if test="${item.manager=='N'}">非主管</c:if>
	              </span>
	              <span>
	              	<c:if test="${item.workingHours=='A'}">全時</c:if>
		            <c:if test="${item.workingHours=='P'}">部分工時</c:if>
	              </span>
	              <span class="l">
	              	${item.department }
	              </span>
	            </li>
            </c:forEach>
          </c:when></c:choose>
          </ol>
        </div>
        
      </div>
	
      <div class="form">
        <div class="title_main"><span>申請補助經費概算</span></div>
        
          <!---經費列表--->
          
        <c:choose><c:when test="${not empty expenditureLists}">
	      	<c:forEach items="${expenditureLists}" var="item" varStatus="status">
		      	<table class="table_05">
		            <tr>
		              <th style="width: 33%;">項目</th>
		              <th style="width: 33%;">單價</th>
		              <th>數量</th>
		            </tr>
		            <tr>
		              <td>${item.planName }</td>
		              <td>${item.unitPrice}</td>
		              <td>${item.amount }</td>
		            </tr>
		            <tr>
		              <th>總價</th>
		              <th>申請本部補助</th>
		              <th>說明</th>
		            </tr>
		            <tr>
		              <td>${item.unitPrice*item.amount }</td>
		              <td>${item.amounts }</td>
		              <td>${item.description }</td>
		            </tr>
		        </table>
		   	</c:forEach>
		</c:when></c:choose>
          
      </div>




      <div class="form">
        <div class="title_main"><span>檢附文件</span></div>

        <div class="full lh-lg"><span class="title-c">設立登記證明文件：</span><br>
			<c:choose><c:when test="${not empty registerAttachment}">
	      	<c:forEach items="${registerAttachment}" var="item" varStatus="status">
		      	<c:choose>
			      	<c:when test="${item.fileType=='register' }">
				        <a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a>&nbsp;&nbsp;
				        ${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}&nbsp;&nbsp;
				        <fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB
				        <br/>
			      	</c:when>
		      	</c:choose>
	      	</c:forEach>
	        </c:when>
	        </c:choose>          

		</div>

        <div class="full lh-lg"><span class="title-c">講師為退休高齡者證明文件：</span><br>
        	<c:choose><c:when test="${not empty speakerRetirementAttachment}">
	      	<c:forEach items="${speakerRetirementAttachment}" var="item" varStatus="status">
		      	<c:choose>
			      	<c:when test="${item.fileType=='speakerRetirement' }">
				        <a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a>&nbsp;&nbsp;
				        ${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}&nbsp;&nbsp;
				        <fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB
				        <br/>
			      	</c:when>
		      	</c:choose>
	      	</c:forEach>
	        </c:when>
	        </c:choose>    
        </div>

        <div class="full lh-lg"><span class="title-c">講師具專業技術及經驗證明文件：</span><br>
        	<c:choose><c:when test="${not empty speakerExperienceAttachment}">
	      	<c:forEach items="${speakerExperienceAttachment}" var="item" varStatus="status">
		      	<c:choose>
			      	<c:when test="${item.fileType=='speakerExperience' }">
				        <a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a>&nbsp;&nbsp;
				        ${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}&nbsp;&nbsp;
				        <fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB
				        <br/>
			      	</c:when>
		      	</c:choose>
	      	</c:forEach>
	        </c:when>
	        </c:choose>    
        </div>

        <div class="full lh-lg"><span class="title-c">僱用證明文件：</span><br>
        	<c:choose><c:when test="${not empty employmentAttachment}">
	      	<c:forEach items="${employmentAttachment}" var="item" varStatus="status">
		      	<c:choose>
			      	<c:when test="${item.fileType=='employment' }">
				        <a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a>&nbsp;&nbsp;
				        ${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}&nbsp;&nbsp;
				        <fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB
				        <br/>
			      	</c:when>
		      	</c:choose>
	      	</c:forEach>
	        </c:when>
	        </c:choose> 
        </div>

        <div class="full lh-lg"><span class="title-c">其他文件：</span><br>
        	<c:choose><c:when test="${not empty necessaryAttachment}">
	      	<c:forEach items="${necessaryAttachment}" var="item" varStatus="status">
		      	<c:choose>
			      	<c:when test="${item.fileType=='necessary' }">
				        <a href="download?path=${item.filePath}/${item.fileName}" target="_blank">${item.fileName}</a>&nbsp;&nbsp;
				        ${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}&nbsp;&nbsp;
				        <fmt:formatNumber value="${item.fileSize/1024}" maxFractionDigits="1"/>KB
				        <br/>
			      	</c:when>
		      	</c:choose>
	      	</c:forEach>
	        </c:when>
	        </c:choose> 
        </div>

      </div>
	  <!--endprint-->
	  </div>
    <div class="page">
      <button onclick="doPrint()">下載申請書電子檔</button>
      <button onclick="javascript:location.href='index'">回首頁</button>
    </div>
        
  </div>
  <!------------ 申請流程 END ------------>
  
    
  </div>
  <!--- main end ---> 
  
  <!--- footer --->
  <%@ include file="footer.jsp" %>
  <!--- footer end ---> 
  
</div>

</body>
</html>