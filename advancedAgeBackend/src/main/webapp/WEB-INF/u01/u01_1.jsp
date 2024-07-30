<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<html>
<head>
<meta charset="utf-8">
<title>促進中高齡者及高齡者就業相關補助計畫系統</title>

<link href="css/file.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jspdf.min.js"></script>
<script type="text/javascript" src="js/html2canvas.min.js"></script>
</head>



<body>


<!---------------------- top ---------------------->
<%@ include file="../header.jsp" %>
<!---------------------- top end ---------------------->
<%@ include file="../mainMenu.jsp" %>
<!---------------------- left menu ---------------------->
<%@ include file="../leftMenuCtype.jsp" %>
<!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">審件與核定
        <span>案件審核</span>
        <span id="number">U01-1</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      

      <!------------------- 申請書 ------------------->
      <div id="page_tab">
        <div class="file_title-1">再就業申請書</div>
        <div class="tab-1" id="unitData"><a class="in">申請單位資料</a></div>
        <div class="tab-1" id="condition"><a>資格條件及切結事項</a></div>
      </div>
        
      <!------ 申請單位資料 ------> 
      <input type="text" id="aaid" name="aaid" value="${base[0].get('aaid') }" style="display:none">
      <input type="text" id="verifyUnit" value="${unit }" style="display:none">
      <input type="text" id="verifyPerson" value="${id }" style="display:none">
      <input type="text" id="updator" value="${id }" style="display:none">
      <table class="table_03" id="unitDataTable">
        <tr>
          <th width="18%">案件編號</th>
          <td width="35%">${base[0].get("aaid") }</td>
          <th width="18%">申請日期</th>
          <td>${base[0].get("createTime").substring(0,4)-1911 }${base[0].get("createTime").substring(4,10) }</td>
        </tr>
        <tr>
          <th>單位名稱</th>
          <td width="35%">${apply.companyName }</td>
          <th width="18%">負責人</th>
          <td>${companyInfoData.get("principal") }</td>
        </tr>
        <tr>
          <th>統一編號 / 扣繳編號</th>
          <td>${apply.seq }</td>
          <th>行業別</th>
          <td><c:forEach  items="${industryList}"  var="item"  varStatus="userStatus">
      		<c:if test="${apply.industry==item.code}">${item.name}</c:if>
      		</c:forEach>
      	  </td>
        </tr>
        <tr>
          <th>勞保投保證號</th>
          <td>${apply.guaranteeNumber.replace(';','、')}</td>
          <th>單位屬性</th>
          <td>${ companyAttributes }</td>
        </tr>
        <tr>
          <th>登記地址</th>
          <td colspan="3">
          	<c:forEach  items="${cityList}"  var="item"  varStatus="userStatus">
      			<c:if test="${apply.registerCity==item.code}">${item.name}</c:if>
	      	</c:forEach>
	      	<c:forEach  items="${registerAreaList}"  var="item"  varStatus="userStatus">
	      		<c:if test="${apply.registerArea==item.code}">${item.name}</c:if>
	      	</c:forEach>
          ${apply.registerAddress.replace("<", "&lt;").replace(">", "&gt;")}</td>
        </tr>
        <tr>
          <th>聯絡地址</th>
          <td colspan="3">
          	<c:forEach  items="${cityList}"  var="item"  varStatus="userStatus">
      			<c:if test="${apply.contactCity==item.code}">${item.name}</c:if>
	      	</c:forEach>
	      	<c:forEach  items="${areaList}"  var="item"  varStatus="userStatus">
	      		<c:if test="${apply.contactArea==item.code}">${item.name}</c:if>
	      	</c:forEach>
          ${apply.contactAddress.replace("<", "&lt;").replace(">", "&gt;")}</td>
        </tr>
        <tr>
          <th>聯絡人</th>
          <td>${apply.contactName}</td>
          <th>聯絡人職稱</th>
          <td>${apply.contactJobtitle}</td>
        </tr>
        <tr>
          <th>連絡電話</th>
          <td>${apply.contactWorkPhoneAreaCode}-${apply.contactWorkPhone}#${apply.contactWorkPhoneExtension}</td>
          <th>行動電話</th>
          <td>${apply.contactPhone}</td>
        </tr>
        <tr>
          <th>傳真號碼</th>
          <td>${apply.faxAreaCode}-${apply.fax}</td>
          <th>電子郵件</th>
          <td>${apply.email}</td>
        </tr>
      </table>
      
      
      <!------ 資格條件及切結事項 ------>
      <table class="table_03" id="conditionTable" style="display:none">
	    <!---<table class="table_03" id="conditionTable">--->
        <tr>
          <th colspan="2">檢核項目</th>
          <th>填寫</th>
          <th>檢核</th>
        </tr>
        <tr>
          <th width="3%">1</th>
          <td>本統一編號/非營利扣繳編號是否有其他子公司或母公司？(有母子公司人數請合併計算)</td>
          <td width="6%" class="text-center"><c:if test="${apply.multipleCompany=='Y'}">有</c:if>
          				<c:if test="${apply.multipleCompany=='N'}">無</c:if></td>
          <td width="17%">
          <label><input name="checkMultipleCompany" type="radio" class="radio" id="checkMultipleCompany_1" value="Y" <c:if test="${base[0].checkMultipleCompany=='Y'}">checked</c:if> />符合</label>
          <label><input name="checkMultipleCompany" type="radio" class="radio not" id="checkMultipleCompany_0" value="N" <c:if test="${base[0].checkMultipleCompany=='N'}">checked</c:if>/>不符</label>
          </td>
        </tr>
        <tr>
          <th>2</th>
          <td>本單位申請本計畫時曾領取政府機關與本計畫屬性相同之津貼？</td>
          <td width="6%" class="text-center"><c:if test="${apply.relatedAmounts=='Y'}">有</c:if>
          				<c:if test="${apply.relatedAmounts=='N'}">無</c:if></td>
          <td>
          <label><input name="checkRelatedAmounts" type="radio" class="radio" id="checkRelatedAmounts_1" value="Y" <c:if test="${base[0].checkRelatedAmounts=='Y'}">checked</c:if>/>符合</label>
          <label><input name="checkRelatedAmounts" type="radio" id="checkRelatedAmounts_0" class="radio not" value="N" <c:if test="${base[0].checkRelatedAmounts=='N'}">checked</c:if>/>不符</label>
          </td>
        </tr>
      </table>
      

      <!------------------- 計劃書 ------------------->
      <div id="page_tab">
          <div class="file_title-1">再就業計劃書</div>
          <div class="tab-1" id="employed"><a class="in color-2">線上申請填寫資料</a></div>
          <div class="tab-1" id="situation"><a>指標及預期效益</a></div>
          <div class="tab-1" id="list"><a>受益人員審核</a></div>
          <div class="tab-1" id="outlay"><a>經費概算審核</a></div>
          <div class="tab-1" id="class"><a>聯合辦理單位</a></div>
      </div>
      
      
      <!------ 線上申請填寫資料 ------>
      <table class="table_03" id="employedTable">
        <tr>
          <th width="18%">主要業務/產品/服務</th>
          <td colspan="3">${plan.workContent.replace("<", "&lt;").replace(">", "&gt;")}</td>
        </tr>
        <tr>
          <th>友善高齡者職場措施</th>
          <td colspan="3">${plan.friendlyMeasures.replace("<", "&lt;").replace(">", "&gt;")}</td>
        </tr>
        <tr>
          <th>員工總人數</th>
          <td width="34%">${plan.employeeNumber}</td>
          <th width="18%">計畫受益人數</th>
          <td>${plan.beneficiaryNumber}</td>
        </tr>
        <tr>
          <th>申請補助類型</th>
          <td>${ subsidyType }</td>
          <th>申請金額</th>
          <td>${plan.amounts}</td>
        </tr>
        <tr>
          <th>經費結構 (1)</th>
          <td colspan="2">同一計畫向二個以上政府機關提出申請補助之項目與金額</td>
          <td>
          	<c:if test="${plan.multipleApplications == 'Y'}">有：${plan.multipleApplicationsDescription.replace("<", "&lt;").replace(">", "&gt;")}</c:if>
          	<c:if test="${plan.multipleApplications != 'Y'}">無</c:if>
          </td>
        </tr>
        <tr>
          <th>經費結構 (2)</th>
          <td colspan="2">同年度申請中高齡者退休後再就業準備訓練補助實施計畫</td>
          <td>
          	<c:if test="${plan.applySameYear == 'Y'}">有：${plan.applySameYearDescription.replace("<", "&lt;").replace(">", "&gt;")}</c:if>
          	<c:if test="${plan.applySameYear != 'Y'}">無</c:if>
          </td>
        </tr>
        <tr>
          <th>計畫目標</th>
          <td colspan="3">${plan.planGoal.replace("<", "&lt;").replace(">", "&gt;").replace("\\n","<br>")}</td>
        </tr>
        <tr>
          <th>計畫內容</th>
          <td colspan="3">${plan.planContent.replace("<", "&lt;").replace(">", "&gt;").replace("\\n","<br>")}</td>
        </tr>
        <tr>
          <th>預計執行期間</th>
          <td colspan="3">${plan.planStartTime}~${plan.planEndTime}止</td>
        </tr>
        <tr>
          <th>計畫執行地</th>
          <td colspan="3"><ul class="pt-2">
        	<c:forEach items="${fn:split(plan.executionCity,';')}" var="item" varStatus="status">
        		<c:forEach items="${cityList}" var="cityItem">
        			<c:if test="${item==cityItem.code}">
        				<li><c:out value="${cityItem.name}"></c:out>
        				<c:out value="${fn:split(plan.executionCityAddress,';')[status.count-1]}" /></li>
        			</c:if>
        		</c:forEach>
        	</c:forEach>
        	</ul></td>
        </tr>
      </table>        
      
      
      <!------ 指標及預期效益 ------>
      <table class="table_03" id="situationTable" style="display:none">
        <tr>
          <th width="18%">質化效益</th>
          <td colspan="3">${plan.qualityBenefit.replace("<", "&lt;").replace(">", "&gt;").replace("\\n","<br>")}</td>
        </tr>
        <tr>
          <th>量化效益</th>
          <td colspan="3">${plan.quantifyBenefit.replace("<", "&lt;").replace(">", "&gt;").replace("\\n","<br>")}</td>
        </tr>
        <tr>
          <th>近三年<br>相關計畫經驗成果</th>
          <td colspan="3">${plan.planExecutionSituation.replace("<", "&lt;").replace(">", "&gt;").replace("\\n","<br>")}</td>
        </tr>
      </table>      
      

      <!------ 受益人員名單審核 ------>
      <table class="table_03" id="listTable" style="display:none">
        <tr>
          <th width="18%">受益人員人數</th>
          <td>${ benefitListSize }</td>
        </tr>
        <tr>
          <th class="point">線上申請受益人員名單</th>
          <td>
            <a href="javascript:void(0);" class="btn_05" onclick="personnelList('${base[0].get("seq")}','${base[0].get("year")}','${base[0].get("id")}')">查看名單</a>
<!--             <a href="list_personnel.html" class="btn_05" target="_blank">列印清冊</a> -->
<!--             <a href="list_personnel.html" class="btn_05" target="_blank">下載PDF</a> -->
          </td>
        </tr>
        <tr>
          <th class="point">下載名單清冊</th>
          <td><a href="javascript:void(0);" onclick="exportExcel('${base[0].get("seq")}','${base[0].get("year")}','${base[0].get("id")}')"><u>計畫受益人員名單清冊.xlsx</u></a></td>
        </tr>
        <tr>
          <th class="point">符合資格人數</th>
          <td><input type="text" size="5" id="checkEmploymentPerson" value="${base[0].checkEmploymentPerson }"></td>
        </tr>
        <tr>
          <th>審核意見</th>
          <td><textarea name="textarea" rows="3" style="width:700px" id="checkEmploymentRemark">${base[0].checkEmploymentRemark.replace("\\n","&#13;&#10;") }</textarea></td>
        </tr>
      </table>   
      
      
      <!------經費概算審核 ------>
      <table class="table_03" id="outlayTable" style="display:none">
        <tr>
          <th width="18%">申請項目數</th>
          <td width="35%">${ expenditureListSize }</td>
          <th width="18%">經費概算(總價)</th>
          <td width="29%">${ expenditureListSum }</td>
        </tr>
        <tr>
          <th class="point">線上申請經費概算</th>
          <td colspan="3">
            <a href="javascript:void(0);" class="btn_05" onclick="expenditure('${base[0].get("seq")}','${base[0].get("year")}','${base[0].get("id")}')">查看經費</a>
          </td>
        </tr>
        <tr>
          <th class="point">下載經費概算清冊</th>
          <td colspan="3">
          	<a href="javascript:void(0);" onclick="exportExpenditureExcel('${base[0].get("seq")}','${base[0].get("year")}','${base[0].get("id")}')"><u>經費概算清冊.xlsx</u></a>
          </td>
        </tr>
        <tr>
          <th>申請補助金額</th>
          <td>${ expenditureListAmountsSum }</td>
          <th class="point">審核通過金額</th>
          <td>
          	<input type="text" size="7" id="checkExpenditureAmounts" value="${base[0].checkExpenditureAmounts }">
          </td>
        </tr>
        <tr>
          <th>審核意見</th>
          <td colspan="3">
          <textarea name="textarea" rows="3" style="width:700px" id="checkExpenditureRemark">${base[0].checkExpenditureRemark.replace("\\n","&#13;&#10;") }</textarea>
          </td>
        </tr>
      </table>     
      
      
      <!------聯合辦理單位審核 ------>
      <table class="table_03" id="classTable" style="display:none">
        <tr>
          <th width="18%">聯合辦理單位總數</th>
          <td width="35%">${ basicDataListSize }</td>
          <th width="18%">預計總參訓人數</th>
          <td width="29%">${ benefitListSize }</td>
        </tr>
        <tr>
          <th class="point">聯合辦理單位清冊</th>
          <td colspan="3">
            <a href="javascript:void(0);" class="btn_05" onclick="jointUnit('${base[0].get("seq")}','${base[0].get("year")}','${base[0].get("id")}')">查看單位</a>
<!--             <a href="list_join.html" class="btn_05" target="_blank">列印清冊</a> -->
<!--             <a href="list_join.html" class="btn_05" target="_blank">下載PDF</a> -->
          </td>
        </tr>
        <tr>
          <th class="point">下載聯合辦理清冊</th>
          <td colspan="3">
          	<c:if test="${ basicDataListSize>0}">
          		<a href="javascript:void(0);" onclick="exportJointUnitExcel('${base[0].get("seq")}','${base[0].get("year")}','${base[0].get("id")}')"><u>聯合辦理單位清冊.xlsx</u></a>
          	</c:if>
          </td>
        </tr>
        <tr>
          <th>審核意見</th>
          <td colspan="3">
          <textarea name="textarea" rows="3" style="width:700px" id="checkJointAuthorizeRemark">${base[0].checkJointAuthorizeRemark.replace("\\n","&#13;&#10;") }</textarea>
          </td>
        </tr>
      </table>       
      
      <div class="btn_box-4">
        <button type="button" class="btn_01" onclick="checkData('${base[0].get("seq")}','${base[0].get("year")}','${base[0].get("id")}')">補件通知</button>
        <button type="button" class="btn_01" onclick="save()">儲存資料</button>
      </div>
      
      <!------------------- 檢附文件審核 ------------------->
      <div class="file_title-2">檢附文件審核</div>
        <table class="table_04">
          <tr>
            <th width="18%">最新日期</th>
            <th width="12%" class="point">檢核狀態</th>
            <th class="point">檢附文件</th>
            <th>審核意見</th>
          </tr>
          <c:forEach var="i" items="${base[0].get('fileStatusRecord').split(';')}"  varStatus="status">
          	<c:set var="lastDate" value="${i}"/>
          </c:forEach>
          <tr>
            <td>${lastDate.substring(lastDate.lastIndexOf('、')+1,lastDate.lastIndexOf('、')+5)-1911}${lastDate.substring(lastDate.lastIndexOf('、')+5,lastDate.lastIndexOf('、')+11).replace('-','/')}</td>
            <td>
            <c:if test="${base[0].get('fileStatus')==4}"><span class="text_pass">合格</span></c:if>
            <c:if test="${base[0].get('fileStatus')!=4}"><span class="text_warn">缺件</span></c:if>
            </td>
            <td width="14%">
            <a href="javascript:void(0);" onclick="attachment('${base[0].get("seq")}','${base[0].get("year")}','${base[0].get("id")}')"><u>查看資訊頁</u></a>
            </td>
            <td style="text-align:left">
            <input type="text" id="checkAttachmentRemark" value="${base[0].checkAttachmentRemark }" size="50">
            </td>
          </tr>
        </table>
        
        
      <!------------------- 相關檢核項目 ------------------->
      <div class="file_title-2">相關檢核項目</div>
      <table class="table_04">
          <tr>
            <th width="18%" class="point">檢核項目</th>
            <th width="12%" class="point">檢核狀態</th>
            <th width="23%" class="point">詳細資訊</th>
            <th>審核意見</th>
          </tr>
          <tr>
            <td><strong id="docs-internal-guid-611a63de-7fff-7469-2142-31146d40a613">停止補助名單</strong></td>
             <c:if test="${not empty blackList}">
	            <td><span class="text_warn" id="checkBlacklistStatus">不合格</span></td>
	            <td style="text-align:left"><a href="javascript:void(0);" onclick="blackList('${blackList[0].id}')"><u>詳細資料</u></a>&nbsp; (本系統) </td>
	            <td><input type="text" size="50" id="checkBlacklistRemark" <c:if test="${base[0].checkBlacklistRemark==''}">value="不實請領或溢領，依在職中高齡者及高齡者穩定就業辦法第24條第2項停止補助2年。"</c:if><c:if test="${base[0].checkBlacklistRemark!=''}">value="${base[0].checkBlacklistRemark}"</c:if>></td>
            </c:if>
            <c:if test="${empty blackList}">
	            <td><span class="text_pass" id="checkBlacklistStatus">合格</span></td>
	            <td style="text-align:left"><a href="javascript:void(0);"><u>尚無紀錄</u></a>&nbsp; (本系統) </td>
	            <td><input type="text" size="50" id="checkBlacklistRemark" <c:if test="${base[0].checkBlacklistRemark==''}">value="符合規定"</c:if><c:if test="${base[0].checkBlacklistRemark!=''}">value="${base[0].checkBlacklistRemark}"</c:if>></td>
            </c:if>
          </tr>
          <tr>
            <td><b>實地查核</b></td>
            <c:if test="${not empty siteInspection}">
            <td><span class="text_warn" id="checkSiteinspectionStatus">不合格</span></td>
            <td style="text-align:left"><a href="javascript:void(0);" onclick="siteInspection('${siteInspection[0].id}')"><u>詳細資料</u></a>&nbsp; (本系統) </td>
            <td><input type="text" size="50" id="checkSiteinspectionRemark" value="${base[0].checkSiteinspectionRemark }"></td>
            </c:if>
            <c:if test="${empty siteInspection}">
            <td><span class="text_pass" id="checkSiteinspectionStatus">合格</span></td>
            <td style="text-align:left"><a href="javascript:void(0);"><u>尚無紀錄</u></a>&nbsp; (本系統) </td>
            <td><input type="text" size="50" id="checkSiteinspectionRemark" <c:if test="${base[0].checkSiteinspectionRemark==''}">value="符合規定"</c:if><c:if test="${base[0].checkSiteinspectionRemark!=''}">value="${base[0].checkSiteinspectionRemark}"</c:if>></td>
            </c:if>
          </tr>
          <tr>
            <td><b>投保 / 職災</b></td>
            <td><select name="checkInsuranceStatus" id="checkInsuranceStatus">
              <option>---</option>
              <option value="Y" <c:if test="${base[0].checkInsuranceStatus=='Y'}">selected</c:if>>合格</option>
              <option value="N" <c:if test="${base[0].checkInsuranceStatus=='N'}">selected</c:if>>不合格</option>
            </select></td>
            <td style="text-align:left"><a href="https://192.168.1.62/" target="_blank"><u>詳細資料</u></a>&nbsp; (另開頁面)</td>
            <td><input type="text" size="50" id="checkInsuranceRemark" value="${base[0].checkInsuranceRemark }"></td>
          </tr>
          <tr>
            <td><b>未重複請領津貼</b></td>
            <td><select name="checkAllowanceStatus" id="checkAllowanceStatus">
              <option>---</option>
              <option value="Y" <c:if test="${base[0].checkAllowanceStatus=='Y'}">selected</c:if>>合格</option>
              <option value="N" <c:if test="${base[0].checkAllowanceStatus=='N'}">selected</c:if>>不合格</option>
            </select></td>
            <td style="text-align:left"><a href="https://3in1t.ejob.gov.tw/" target="_blank"><u>詳細資料</u></a>&nbsp; (另開頁面)</td>
            <td><input type="text" value="${base[0].checkAllowanceRemark}" size="50" id="checkAllowanceRemark"></td>
          </tr>
          <tr>
            <td><b>民間團體補(捐)助系統CGSS</b></td>
            <td><select name="checkCgssStatus" id="checkCgssStatus">
              <option>---</option>
              <option value="Y" <c:if test="${base[0].checkCgssStatus=='Y'}">selected</c:if>>合格</option>
              <option value="N" <c:if test="${base[0].checkCgssStatus=='N'}">selected</c:if>>不合格</option>
            </select></td>
            <td style="text-align:left"><a href="https://subsidy.nat.gov.tw/index.aspx" target="_blank"><u>詳細資料</u></a>&nbsp; (另開頁面)</td>
            <td><input type="text" <c:if test="${base[0].checkCgssRemark==''}">value="有/無違反民間團體補捐助規定"</c:if><c:if test="${base[0].checkCgssRemark!=''}">value="${base[0].checkCgssRemark}"</c:if> size="50" id="checkCgssRemark"></td>
          </tr>
          <tr>
            <td><b>違反勞動法令</b></td>
            <td>
            <select name="checkViolationlaborlawsStatus" id="checkViolationlaborlawsStatus">
              <option>---</option>
              <option value="Y" <c:if test="${base[0].checkViolationlaborlawsStatus=='Y'}">selected</c:if>>合格</option>
              <option value="N" <c:if test="${base[0].checkViolationlaborlawsStatus=='N'}">selected</c:if>>不合格</option>
            </select>
            </td>
            <td style="text-align:left"><a href="https://announcement.mol.gov.tw/" target="_blank"><u>查詢系統</u></a>&nbsp; (另開頁面) </td>
            <td><input type="text" size="50" id="checkViolationlaborlawsRemark" value="${base[0].checkViolationlaborlawsRemark}"></td>
          </tr>
          <!---<tr>
            <td><b>本屬補捐助</b></td>
            <td>
            <select name="select" id="select2">
              <option>---</option>
              <option>合格</option>
              <option>不合格</option>
            </select>
            </td>
            <td style="text-align:left"></td>
            <td><input type="text" size="50"></td>
          </tr>--->
        </table>
        
        
        
        
        
      <!------------------- table 3 ------------------->
      <div class="file_title-2">案件審核</div>
      <table class="table_03">
          <tr>
            <th class="point" width="18%">補捐助系統案件序號</th>
            <td><input type="text" id="allowanceId" value="${base[0].allowanceId }"></td>
            <th class="point">補助金額</th>
            <td><input type="text" id="allowanceAmounts" value="${base[0].allowanceAmounts }"></td>
          </tr>
          <tr>
            <th class="point">會簽編號</th>
            <td><input type="text" id="countersignId" value="${base[0].countersignId }"></td>
            <th class="point"><span class="point">審核結果</span></th>
            <td>
            	<label>
	                <input name="caseStatus" type="radio" id="caseStatus3" class="radio" value="3" <c:if test="${base[0].caseStatus>=3 }">checked</c:if>/>
	                通過 
                </label>
              	<label>
	                <input name="caseStatus" type="radio" id="caseStatus2" class="radio not" value="2" <c:if test="${base[0].caseStatus=='2' }">checked</c:if>/>
	            	未通過
            	</label>
              	<label>
	            	<input name="caseStatus" type="radio" id="caseStatus1" class="radio" value="1" <c:if test="${base[0].caseStatus=='1' }">checked</c:if>/>
	            	審核中
            	</label>
            </td>
          </tr>
          <tr>
            <th class="point">審核意見</th>
            <td colspan="3"><textarea name="caseDescription" id="caseDescription" rows="5" style="width:700px">${base[0].caseDescription.replace("\\n","&#13;&#10;") }</textarea></td>
          </tr>
          
          <tr>
            <th>承辦單位</th>
            <td><c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
		      		<c:if test="${base[0].verifyUnit==unitItem.code}">${unitItem.name}</c:if> 
	      	</c:forEach>
	      	</td>
            <th>承辦人員</th>
            <td>
            <c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
	      		<c:if test="${base[0].verifyPerson==userItem.id}">${userItem.name}</c:if> 
	      	</c:forEach>
            </td>
          </tr>
          <tr>
            <th>最後異動時間</th>
            <td>${base[0].updateTime.substring(0,4)-1911}${base[0].updateTime.substring(4,16)}</td>
            <th>最後異動人員</th>
            <td>
            <c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
	      		<c:if test="${base[0].updator==userItem.id}">${userItem.name}</c:if> 
	      	</c:forEach>
          </tr>
        </table>
      
      
      <div class="btn_box-3">
      <!---<input type="reset" class="btn_02" value="取消修改" />--->
      <!---<input type="submit" class="btn_01" value="儲存資料" />--->
	      <button type="button" class="btn_02" onclick="cancel()">取消修改</button>
	      <button type="button" class="btn_01" onclick="save()">儲存資料</button>
	      <button type="button" class="btn_01" onclick="print('${base[0].get("seq")}','${base[0].get("year")}','${base[0].get("id")}')">列印</button>
      </div>
      
  	  <form method="post" id="dataForm" target="_blank">
      	<input type="text" id="dataSeq" name="seq" style="display:none">
      	<input type="text" id="applyYear" name="applyYear" style="display:none">
      	<input type="text" id="dataId" name="id" style="display:none">
      </form>
  
  
    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  
  
  
<script src="js/u01/u01_1.js"></script>



</body>




</html>
