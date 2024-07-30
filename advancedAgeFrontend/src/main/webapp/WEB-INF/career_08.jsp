<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<html lang="zh-hant-TW">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>中高齡及高齡者就業相關服務網</title>
<link rel="stylesheet" href="css/main.css" type="text/css">
<link rel="stylesheet" href="css/template.css" type="text/css">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">

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
		<%@ include file="header.jsp"%>
		<!--- header end --->


		<!--- main --->
		<div class="main clearfix" id="content">
			<a href="#C" title="中央內容區塊" id="AC" accesskey="C" name="C">:::</a>
			<!---無障礙--->


			<!------------ 申請流程 ------------>
			<div class="apply_main">

				<!---無障礙/麵包屑--->
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="index" title="首頁">首頁</a></li>
						<li class="breadcrumb-item active" aria-current="page">線上申辦</li>
						<li class="breadcrumb-item active" aria-current="page">中高齡者退休後再就業準備協助措施
							- 申請作業</li>
					</ol>
				</nav>
				<h1>中高齡者退休後再就業準備協助措施 - 申請作業</h1>
				<h2>申請流程 Step8. 送出申請</h2>
				<h3>
					<span class="title">您申請的案件已送出</span>
				</h3>

				<div>
					<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${base.createTime}" var="createTime" />
			        <div class="fs-5 fw-bolder">申請日期：${createTime.substring(0,4)-1911}/${createTime.substring(5,7)}/${createTime.substring(8,createTime.length())}</div>
			      	<h4>《 申辦完成不代表審核通過 》</h4>
					<p>
						如有補件或修改送件資料需求，或您有任何疑問<br> 請於周一至周五 上班時間洽詢 <a href="https://job.taiwanjobs.gov.tw/internet/index/service_location.aspx" target="_blank">受理單位</a>
					</p>
				</div>

			</div>
			<!------------ 申請流程 END ------------>
			<div id="pdf" style="display:none">
				<!--startprint-->
				<div class="form">
					<div class="title_main">
						<span>申請書</span>
					</div>
					<div>
						<span class="title-c">單位名稱</span>${apply.companyName}</div>
					<input type="text" id="companyName" value="${apply.companyName}"
						style="display: none">
					<div>
						<span class="title-c">統一編號</span>${apply.seq}</div>
					<input type="text" id="seq" value="${apply.seq}"
						style="display: none">
					<div>
						<span class="title-c">行業別</span>
						<c:forEach items="${industryList}" var="item">
							<c:if test="${item.code==apply.industry}">${item.name}</c:if>
						</c:forEach>
					</div>
					<div>
						<span class="title-c">單位屬性</span>${companyAttributes}</div>
					<div>
						<span class="title-c">勞保投保證號</span>${apply.guaranteeNumber.replace(";","、")}</div>
					<div class="full">
						<span class="title-c"> 聯絡地址</span>
						<c:forEach items="${cityList}" var="item">
							<c:if test="${item.code==apply.contactCity}">${item.name}</c:if>
						</c:forEach>
						<c:forEach items="${areaList}" var="item">
							<c:if test="${item.code==apply.contactArea}">${item.name}</c:if>
						</c:forEach>${apply.contactAddress}
						<input type="text" id="city" value="${apply.contactCity}"
							style="display: none">
					</div>
					<div>
						<span class="title-c">聯絡人</span>${apply.contactName}</div>
					<div>
						<span class="title-c">聯絡人職稱</span>${apply.contactJobtitle}</div>
					<div>
						<span class="title-c">聯絡電話</span>${apply.contactWorkPhoneAreaCode}
						- ${apply.contactWorkPhone} #${apply.contactWorkPhoneExtension}
					</div>
					<div>
						<span class="title-c">行動電話</span>${apply.contactPhone}</div>
					<div>
						<span class="title-c">傳真號碼</span>${apply.faxAreaCode} -
						${apply.fax}
					</div>
					<div>
						<span class="title-c">電子信箱</span>${apply.email}</div>
					<input type="text" id="email" value="${apply.email}"
						style="display: none">
				</div>

				<div class="form">
					<div class="title_main">
						<span>計畫書</span>
					</div>
					<div class="full">
						<span class="title-c">主要業務/產品/服務</span><br>
						${plan.workContent}
					</div>
					<div class="full">
						<span class="title-c">友善高齡者職場措施</span><br>
						${plan.friendlyMeasures}
					</div>
					<div class="ss">
						<span class="title-c">員工總人數</span>${plan.employeeNumber}</div>
					<div class="ss">
						<span class="title-c">計畫受益人數</span>${plan.beneficiaryNumber}</div>
					<div class="ss">
						<span class="title-c">申請金額</span>${plan.amounts}</div>
					<div class="full">
						<span class="title-c">申請補助類型</span>${subsidyType}</div>
					<div class="full">
						<span class="title-c">經費結構 (1)</span>同一計畫向二個以上政府機關提出申請補助之項目與金額－(${multipleApplications})
						${plan.multipleApplicationsDescription}
					</div>
					<div class="full">
						<span class="title-c">經費結構 (2)</span>同年度申請中高齡者退休後再就業準備訓練補助實施計畫－(${applySameYear})
						${plan.applySameYearDescription}
					</div>
					<div class="full lh-lg">
						<span class="title-c">計畫目標：</span><br> ${plan.planGoal}
					</div>
					<div class="full lh-lg">
						<span class="title-c">計畫內容：</span><br> ${plan.planContent}
					</div>
					<div class="full">
				        <span class="title-c">預計執行期間</span>
				        ${plan.planStartTime}~${plan.planEndTime}止
			        </div>
					<div class="full">
			        	<span class="title-c">計畫執行地</span>
			        	<ul class="pt-2">
			        	<c:forEach items="${fn:split(plan.executionCity,';')}" var="item" varStatus="status">
			        		<c:forEach items="${cityList}" var="cityItem">
			        			<c:if test="${item==cityItem.code}">
			        				<li><c:out value="${cityItem.name}"></c:out>
			        				<c:out value="${fn:split(plan.executionCityAddress,';')[status.count-1]}" /></li>
			        			</c:if>
			        		</c:forEach>
			        	</c:forEach>
			        	</ul>
			        </div>
				</div>

				<div class="form">
					<div class="title_main">
						<span>計畫達成指標及預期效益</span>
					</div>
					<div class="full lh-lg">
						<span class="title-c">質化效益：</span><br> ${plan.qualityBenefit}
					</div>
					<div class="full lh-lg">
						<span class="title-c">量化效益：</span><br>
						${plan.quantifyBenefit}
					</div>
					<div class="full lh-lg">
						<span class="title-c">近三年相關計畫經驗成果：</span><br>
						${plan.planExecutionSituation}
					</div>
				</div>



				<div class="form">
					<div class="title_main">
						<span>計畫受益人員名單</span>
					</div>

					<!---上傳名單
        <div class="full">繼續僱用補助名單清冊_統編66668888_1101123.xlsx　110/11/23  16:45　21KB</div>--->
					<c:if test="${plan.attachBenefitList =='Y'}">
						<c:choose>
							<c:when test="${not empty benefitListAttachment}">
								<c:forEach items="${benefitListAttachment}" var="item"
									varStatus="status">
									<c:choose>
										<c:when
											test="${item.fileType=='advancedAgeRetirementReemploymentBenefitList' }">
											<br>
											<div class="full">
												<span class="file_name"><a
													href="download?path=${item.filePath}/${item.fileName}"
													target="_blank">${item.fileName}</a></span>&nbsp;&nbsp; <span
													class="file_date">${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}</span>&nbsp;&nbsp;
												<span class="file_size"><fmt:formatNumber
														value="${item.fileSize/1024}" maxFractionDigits="1" />KB</span>
											</div>
										</c:when>
									</c:choose>
								</c:forEach>
							</c:when>
						</c:choose>
					</c:if>
					<c:if test="${plan.attachBenefitList =='N'}">
						<!---填寫名單--->
						<div class="staff_list">
							<ul class="clearfix">
								<li><span>勞工姓名</span> <span>出生日期</span> <span>身分證字號</span>
									<span>保險類型</span> <span>加保日期</span> <span>職務類型</span> <span>工時類型</span>
								</li>
							</ul>
						</div>

						<div class="staff_list">
							<ol>
								<c:if test="${not empty benefitLists}">
									<c:forEach items="${benefitLists}" var="item"
										varStatus="status">
										<li><span>${item.name}</span> <span>${item.birthday}</span>
											<span>${item.identification}</span> <span> <c:if
													test="${item.insuranceType=='L'}">勞工保險</c:if> <c:if
													test="${item.insuranceType=='Z'}">職災保險</c:if>
										</span> <span>${item.insuranceTime}</span> <span> <c:if
													test="${item.manager=='Y'}">主管</c:if> <c:if
													test="${item.manager=='N'}">非主管</c:if>
										</span> <span> <c:if test="${item.workingHours=='A'}">全時</c:if>
												<c:if test="${item.workingHours=='P'}">部分工時</c:if>
										</span></li>
									</c:forEach>
								</c:if>
							</ol>
						</div>
					</c:if>
				</div>


				<div class="form">
					<div class="title_main">
						<span>申請補助經費概算</span>
					</div>
					<c:if test="${not empty expenditures}">
						<c:forEach items="${expenditures}" var="item" varStatus="status">
							<!---經費列表--->
							<table class="table_05">
								<tr>
									<th style="width: 33%;">編列項目</th>
									<th>單價</th>
									<th>數量</th>
								</tr>
								<tr>
									<td style="width: 33%;">${status.count}.${item.planName}</td>
									<td>${item.unitPrice}元</td>
									<td>${item.amount}</td>
								</tr>
								<tr>
									<th>總價</th>
									<th>申請本計畫補助</th>
									<th>申請其他單位補助</th>
								</tr>
								<tr>
									<td><fmt:formatNumber
											value="${item.unitPrice*item.amount}" maxFractionDigits="1" />元</td>
									<td>${item.amounts}元</td>
									<td>${item.otherAmounts}元</td>
								</tr>
								<tr>
									<td colspan="3" style="text-align: left;">備註與說明：${item.description}</td>
								</tr>
							</table>
						</c:forEach>
					</c:if>

				</div>


				<div class="form">
					<div class="title_main">
						<span>聯合辦理單位</span>
					</div>

					<c:if test="${not empty basicDataList}">
						<c:forEach items="${basicDataList}" var="item" varStatus="status">
							<div class="full border rounded-3 bg-light p-3 mb-2 clearfix">
								<div class="s">
									<b>單位名稱：</b>${item.companyName}</div>
								<div class="s">
									<b>統一編號：</b>${item.seq}</div>
								<div class="s">
									<b>行業別：<c:forEach items="${industryList}" var="industry">
											<c:if test="${industry.code==item.industry}">${industry.name}</c:if>
										</c:forEach></b>
								</div>
								<div class="s">
									<b>單位規模：${item.unitSize}</b>
								</div>
								<div class="full">
									<b>勞保投保證號：${item.guaranteeNumber.replace(";","、")}</b>
								</div>
								<div class="s">
									<b>負責人：${item.principal}</b>
								</div>
								<div class="s">
									<b>聯絡人：${item.contactName}</b>
								</div>
								<div class="s">
									<b>聯絡電話：${item.contactPhone}</b>
								</div>
								<div class="s">
									<b>電子信箱：${item.email}</b>
								</div>
								<div class="s">
									<b>員工人數：${item.employeeNumber}</b>
								</div>
								<div class="s">
									<b>預計參與人數：${item.participateNumber}</b>
								</div>
								<div class="full">
									<b>主要營業項目：${item.businessItem}</b>
								</div>
							</div>
						</c:forEach>
					</c:if>

				</div>


				<div class="form">
					<div class="title_main">
						<span>檢附文件</span>
					</div>

					<div class="full lh-lg">
						<span class="title-c">設立登記證明文件：</span><br>
						<c:choose>
							<c:when test="${not empty registerAttachment}">
								<c:forEach items="${registerAttachment}" var="item"
									varStatus="status">
									<c:choose>
										<c:when test="${item.fileType=='register' }">
											<a href="download?path=${item.filePath}/${item.fileName}"
												target="_blank">${item.fileName}</a>&nbsp;&nbsp;
				        ${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}&nbsp;&nbsp;
				        <fmt:formatNumber value="${item.fileSize/1024}"
												maxFractionDigits="1" />KB
				        <br />
										</c:when>
									</c:choose>
								</c:forEach>
							</c:when>
						</c:choose>
					</div>

					<div class="full lh-lg">
						<span class="title-c">聯合辦理單位授權書：</span><br>
						<c:choose>
							<c:when test="${not empty jointAuthorizeAttachment}">
								<c:forEach items="${jointAuthorizeAttachment}" var="item"
									varStatus="status">
									<c:choose>
										<c:when test="${item.fileType=='jointAuthorize' }">
											<a href="download?path=${item.filePath}/${item.fileName}"
												target="_blank">${item.fileName}</a>&nbsp;&nbsp;
				        ${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}&nbsp;&nbsp;
				        <fmt:formatNumber value="${item.fileSize/1024}"
												maxFractionDigits="1" />KB
				        <br />
										</c:when>
									</c:choose>
								</c:forEach>
							</c:when>
						</c:choose>
					</div>

					<div class="full lh-lg">
						<span class="title-c">其他文件：</span><br>
						<c:choose>
							<c:when test="${not empty necessaryAttachment}">
								<c:forEach items="${necessaryAttachment}" var="item"
									varStatus="status">
									<c:choose>
										<c:when test="${item.fileType=='necessary' }">
											<a href="download?path=${item.filePath}/${item.fileName}"
												target="_blank">${item.fileName}</a>&nbsp;&nbsp;
		        		${item.createTime.substring(0,4)-1911}/${item.createTime.substring(5,7)}/${item.createTime.substring(8,16)}&nbsp;&nbsp;
		        		<fmt:formatNumber value="${item.fileSize/1024}"
												maxFractionDigits="1" />KB
		        		<br />
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
		<!--- main end --->

		<!--- footer --->
		<%@ include file="footer.jsp"%>
		<!--- footer end --->

	</div>
	<script src="js/bootstrap.bundle.js"></script>
	<script src="js/jquery-3.6.0.min.js"></script>
	<script src="js/gotop.js"></script>
	<script src="js/career_08/career_08.js"></script>
</body>
</html>