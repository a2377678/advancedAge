<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset="utf-8">
<title>促進中高齡者及高齡者就業相關補助計畫系統</title>

<link href="css/file.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>


</head>


<body>


  <!---------------------- top ---------------------->
  <%@ include file="../header.jsp" %>
  <!---------------------- top end ---------------------->

    
  <div id="main_menu">
    <div><a href="javascript:void(0);" class="menu-1 in">繼續僱用高齡者</a></div>
    <div><a href="javascript:void(0);" class="menu-2">傳承專業技術與經驗</a></div>
    <div><a href="javascript:void(0);" class="menu-3">退休後再就業準備協助措施</a></div>
    <div><a href="account01" class="account">申請帳號審核管理</a></div>
  </div>

  <!---------------------- left menu ---------------------->
  <%@ include file="../leftMenu.jsp" %>
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">案件審查
        <span>案件審核</span>
        <span id="number">B02-1</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      

      <!------------------- table 1 ------------------->
      <div id="page_tab">
        <div class="file_title-1">繼續僱用申請書</div>
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
          <td>${apply.principal }</td>
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
          <td colspan="3">${apply.guaranteeNumber.replace(';','、')}</td>
          </tr>
        <tr>
        <tr>
          <th>聯絡地址</th>
          <td colspan="3">
          	<c:forEach  items="${cityList}"  var="item"  varStatus="userStatus">
      			<c:if test="${apply.contactCity==item.code}">${item.name}</c:if>
	      	</c:forEach>
	      	<c:forEach  items="${areaList}"  var="item"  varStatus="userStatus">
	      		<c:if test="${apply.contactArea==item.code}">${item.name}</c:if>
	      	</c:forEach>
          ${apply.contactAddress}</td>
          </tr>
        <tr>
          <th>聯絡人</th>
          <td>${apply.contactName}</td>
          <th>聯絡人職稱</th>
          <td>${apply.contactJobtitle}</td>
        </tr>
        <tr>
          <th>連絡電話 / 手機</th>
          <td>${apply.contactPhone}</td>
          <th>傳真號碼</th>
          <td>${apply.faxAreaCode}-${apply.fax}</td>
        </tr>
        <tr>
          <th>聯絡地址</th>
          <td>
          	<c:forEach  items="${cityList}"  var="item"  varStatus="userStatus">
      			<c:if test="${apply.contactCity==item.code}">${item.name}</c:if>
	      	</c:forEach>
	      	<c:forEach  items="${areaList}"  var="item"  varStatus="userStatus">
	      		<c:if test="${apply.contactArea==item.code}">${item.name}</c:if>
	      	</c:forEach>
          	${apply.contactAddress}
          </td>
          <th>電子郵件</th>
          <td>${apply.email}</td>
        </tr>
      </table>
      
      
      <!------ 資格條件及切結事項 ------>
	  <table class="table_03" id="conditionTable" style="display:none">
        <tr>
          <th colspan="2">檢核項目</th>
          <th>填寫</th>
          <th>檢核</th>
        </tr>
        <tr>
          <th width="3%">1</th>
          <td>本統一編號/非營利扣繳編號是否有總公司或其他分公司？</td>
          <td width="6%"><c:if test="${apply.multipleCompany=='Y'}">有</c:if>
          				<c:if test="${apply.multipleCompany=='N'}">無</c:if></td>
          <td width="17%">
          <label><input name="checkMultipleCompany" type="radio" class="radio" id="checkMultipleCompany_1" value="Y" <c:if test="${base[0].checkMultipleCompany=='Y'}">checked</c:if> />符合</label>
          <label><input name="checkMultipleCompany" type="radio" class="radio not" id="checkMultipleCompany_0" value="N" <c:if test="${base[0].checkMultipleCompany=='N'}">checked</c:if>/>不符</label>
          </td>
        </tr>
        <tr>
          <th>2</th>
          <td>本單位雇用勞工總人數達3人以上？ ( 配偶或三等親之內勞工不列入人數計算 )</td>
          <td width="6%"><c:if test="${apply.workersEmployment=='Y'}">是</c:if>
          				<c:if test="${apply.workersEmployment=='N'}">否</c:if></td>
          <td>
          <label><input name="checkWorkersEmployment" type="radio" class="radio" id="checkWorkersEmployment_1" value="Y" <c:if test="${base[0].checkWorkersEmployment=='Y'}">checked</c:if>/>符合</label>
          <label><input name="checkWorkersEmployment" type="radio" id="checkWorkersEmployment_01" class="radio not" value="N" <c:if test="${base[0].checkWorkersEmployment=='N'}">checked</c:if>/>不符</label>
          </td>
        </tr>
        <tr>
          <th>3</th>
          <td>欲繼續僱用之勞工是否為雇主之配偶或三等親內之親屬？</td>
          <td width="6%"><c:if test="${apply.relatives=='Y'}">是</c:if>
          				<c:if test="${apply.relatives=='N'}">否</c:if></td>
          <td>
          <label><input name="checkRelatives" type="radio" class="radio" id="checkRelatives_1" value="Y" <c:if test="${base[0].checkRelatives=='Y'}">checked</c:if>/>符合</label>
          <label><input name="checkRelatives" type="radio" id="checkRelatives_0" class="radio not" value="N" <c:if test="${base[0].checkRelatives=='N'}">checked</c:if>/>不符</label>
          </td>
        </tr>
        <tr>
          <th>4</th>
          <td>本單位申請繼續僱用補助時未曾領取政府機關與本計畫屬性相同之津貼？</td>
          <td width="6%"><c:if test="${apply.relatedAmounts=='Y'}">是</c:if>
          				<c:if test="${apply.relatedAmounts=='N'}">否</c:if></td>
          <td>
          <label><input name="checkRelatedAmounts" type="radio" class="radio" id="checkRelatedAmounts_1" value="Y" <c:if test="${base[0].checkRelatedAmounts=='Y'}">checked</c:if>/>符合</label>
          <label><input name="checkRelatedAmounts" type="radio" id="checkRelatedAmounts_0" class="radio not" value="N" <c:if test="${base[0].checkRelatedAmounts=='N'}">checked</c:if>/>不符</label>
          </td>
        </tr>
        <tr>
          <th>5</th>
          <td>本單位同意於繼續僱用期間不強制繼續僱用勞工退休、終止投保勞工保險或轉換其勞工保險投保單位</td>
          <td width="6%"><c:if test="${apply.notMandatory=='Y'}">同意</c:if>
          				<c:if test="${apply.notMandatory=='N'}">不同意</c:if></td>
          <td>
          <label><input name="checkNotMandatory" type="radio" class="radio" id="checkNotMandatory_1" value="Y" <c:if test="${base[0].checkNotMandatory=='Y'}">checked</c:if>/>符合</label>
          <label><input name="checkNotMandatory" type="radio" id="checkNotMandatory_0" class="radio not" value="N" <c:if test="${base[0].checkNotMandatory=='N'}">checked</c:if>/>不符</label>
          </td>
        </tr>
      </table>
      

      <!------------------- table 2 ------------------->
        <div id="page_tab">
          <div class="file_title-1">繼續僱用計劃書</div>
          <div class="tab-1" id="employed"><a class="in color-2">線上申請填寫資料</a></div>
          <div class="tab-1" id="list"><a>申請名單資格審核</a></div>
      </div>
      
      
      
		<!------ 線上申請填寫資料 ------>
      <table class="table_03" id="employedTable">
        <tr>
          <th width="18%">主要業務 / 服務項目</th>
          <td colspan="3">${plan.items}</td>
        </tr>
        <tr>
          <th width="18%">目前員工人數</th>
          <td width="35%">${plan.employmentNumber}</td>
          <th width="18%">65歲以上人數</th>
          <td>${plan.highEmploymentNumber}</td>
        </tr>
        <tr>
          <th>45~64歲人數</th>
          <td>${plan.middleEmploymentNumber}</td>
          <th>44歲以下人數</th>
          <td>${plan.lowEmploymentNumber}</td>
        </tr>
        <tr>
          <th class="point">屆齡65歲人數 (A)</th>
          <td>${plan.nearHighEmploymentNumber}</td>
          <th class="point">規劃繼續僱用人數 (B)</th>
          <td>${plan.continueEmploymentNumber}</td>
        </tr>
        <tr>
          <th class="point">繼續僱用比例 (C)</th>
          <td><b id="planPercentage">${plan.continueEmploymentPercentage}</b>%　(C) = (B) / (A) x 100%</td>
          <th class="point">檢核狀態</th>
          <td><span id="planCheck"></span></td>
        </tr>     
      </table>
	<!------ 申請名單資格審核 ------>
      <table class="table_03" id="listTable" style="display:none">
        <tr>
          <th width="18%">屆齡65歲人數 (A)</th>
          <td>${plan.nearHighEmploymentNumber}</td>
        </tr>
        <tr>
          <th width="18%">申請計畫人數 (D)</th>
          <td id="employmenyListSize">${employmenyListSize}</td>
        </tr>
        <tr>
          <th class="point">線上申請名單</th>
          <td><a href="javascript:void(0);" onclick="list('${base[0].get("seq")}','${base[0].get("year")}','${base[0].get("id")}')"><u>查看申請名單清冊</u></a> ( 另開報表 )</td>
        </tr>
        <tr>
          <th class="point">下載名單清冊</th>
          <td><a href="javascript:void(0);" onclick="exportExcel('${base[0].get("seq")}','${base[0].get("year")}','${base[0].get("id")}')"><u>補助名單清冊.xlsx</u></a></td>
        </tr>
        <tr>
          <th class="point">審查合格人數 (E)</th>
          <td><input type="text" size="5" id="checkEmploymentPerson" value="${base[0].checkEmploymentPerson }"></td>
        </tr>
        <tr>
          <th class="point">合格人數比率 (F)</th>
          <td><b id="checkEmploymentPercentage"></b>%　(F) = (E) / (D) x 100%</td>
        </tr>
        <tr>
          <th class="point">檢核狀態</th>
          <td><span id="employmentCheck"></span></td>
        </tr>
        <tr>
          <th>審查意見</th>
          <td><textarea rows="5" style="width:700px" id="checkEmploymentRemark">${base[0].checkEmploymentRemark.replace("\\n","&#13;&#10;") }</textarea></td>
        </tr>
      </table> 
        
      <!------------------- table 3 ------------------->
      <div class="file_title-2">檢附文件審核</div>
        <table class="table_04">
          <tr>
            <th width="15%">最新日期</th>
            <th width="12%" class="point">檢核狀態</th>
            <th width="26%" class="point">檢附文件</th>
            <th>審查意見</th>
          </tr>
          <c:forEach var="i" items="${base[0].get('fileStatusRecord').split(';')}"  varStatus="status">
          	<c:set var="lastDate" value="${i}"/>
          </c:forEach>
          <tr>
            <td>${lastDate.substring(lastDate.lastIndexOf('、')+1,lastDate.lastIndexOf('、')+5)-1911}${lastDate.substring(lastDate.lastIndexOf('、')+5,lastDate.lastIndexOf('、')+11).replace('-','/')}</td>
            <td><c:if test="${base[0].get('fileStatus')==4}"><span class="text_pass">合格</span></c:if>
            <c:if test="${base[0].get('fileStatus')!=4}"><span class="text_warn">缺件</span></c:if></td>
            <td width="14%"><a href="javascript:void(0);" onclick="attachment('${base[0].get("seq")}','${base[0].get("year")}','${base[0].get("id")}')"><u>查看資訊頁</u></a></td>
            <td style="text-align:left"><input type="text" id="checkAttachmentRemark" value="${base[0].checkAttachmentRemark }" size="50"></td>
          </tr>
        </table>

        
        <!------------------- table ------------------->
      <div class="file_title-2">相關檢核項目</div>
      <table class="table_04">
          <tr>
            <th width="15%" class="point">檢核項目</th>
            <th width="12%" class="point">檢核狀態</th>
            <th width="26%" class="point">詳細資訊</th>
            <th>審查意見</th>
          </tr>
          <tr>
            <td><b>停止補助名單</b></td>
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
            <td style="text-align:left"><a href="javascript:void(0);" target="_blank"><u>詳細資料</u></a>&nbsp; (另開頁面)</td>
            <td><input type="text" value="${base[0].checkAllowanceRemark}" size="50" id="checkAllowanceRemark"></td>
          </tr>
          <tr>
            <td><b>CGSS</b></td>
            <td><select name="checkCgssStatus" id="checkCgssStatus">
              <option>---</option>
              <option value="Y" <c:if test="${base[0].checkCgssStatus=='Y'}">selected</c:if>>合格</option>
              <option value="N" <c:if test="${base[0].checkCgssStatus=='N'}">selected</c:if>>不合格</option>
            </select></td>
            <td style="text-align:left"><a href="javascript:void(0);" target="_blank"><u>詳細資料</u></a>&nbsp; (另開頁面)</td>
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
            <td><label>
                <input name="caseStatus" type="radio" id="caseStatus3" class="radio" value="3" <c:if test="${base[0].caseStatus=='3' }">checked</c:if>/>
                通過 </label>
              <label>
                <input name="caseStatus" type="radio" id="caseStatus2" class="radio not" value="2" <c:if test="${base[0].caseStatus=='2' }">checked</c:if>/>
            未通過</label></td>
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
      <input type="button" class="btn_02" value="取消修改" onclick="cancel()"/>
      <input type="button" class="btn_01" value="儲存資料" onclick="save()"/>
      </div>
      <br><br><br>



      <form method="post" id="dataForm" target="_blank">
      	<input type="text" id="dataSeq" name="seq" style="display:none">
      	<input type="text" id="applyYear" name="applyYear" style="display:none">
      	<input type="text" id="dataId" name="id" style="display:none">
      </form>
  
  
  
    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  <script src="js/b02/b02_1.js"></script>

</body>




</html>
