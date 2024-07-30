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
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jspdf.min.js"></script>
<script type="text/javascript" src="js/html2canvas.min.js"></script>

<script type="text/javascript" src="js/v01/v01_1.js"></script>

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
      <div id="main_title">請款與核銷
        <span>請領核銷作業</span>
        <span id="number">V01-1</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName}&nbsp;${name}</a>
        <a href="logout">登出</a>
      </div>
      

      <!------------------- table 1 ------------------->
      <div id="page_tab">
        <div class="file_title-1">申請單位資料</div>
      </div>
      <input type="text" id="aaid" value="${base[0].aaid }" style="display:none">
      <input type="text" id="verifyUnit" value="${unit }" style="display:none">
      <input type="text" id="verifyPerson" value="${id}" style="display:none">
      <input type="text" id="updator" value="${id}" style="display:none">  
      <!------ 申請單位資料 ------> 
      <table class="table_03" id="unitDataTable">
        <tr>
          <th width="18%">案件編號</th>
          <td width="35%">${base[0].aaid }</td>
          <th width="18%">申請日期</th>
          <td>${base[0].createTime.substring(0,4)-1911 }${base[0].createTime.substring(4,10) }</td>
        </tr>
        <tr>
          <th>單位名稱</th>
          <td width="35%">${apply.companyName }</td>
          <th width="18%">請領日期</th>
          <td><fmt:formatDate pattern="yyyy-MM-dd" value="${result.createTime}" var="createTime" />${createTime.substring(0,4)-1911 }${createTime.substring(4) }</td>
        </tr>
        <tr>
          <th>統一編號 / 扣繳編號</th>
          <td>${apply.seq }</td>
          <th>負責人</th>
          <td>${companyInfoData.get("principal") }</td>
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
          <th> 聯絡手機</th>
          <td>${apply.contactPhone}</td>
        </tr>
        <tr>
          <th>傳真號碼</th>
          <td>${apply.faxAreaCode}-${apply.fax}</td>
          <th>電子信箱</th>
          <td>${apply.email}</td>
        </tr>
      </table>
      

      <!------------------- 計劃書 ------------------->
      <div id="page_tab">
          <div class="file_title-1">成果報告</div>
          <div class="tab-1" id="employed"><a class="in color-2">辦理情形</a></div>
          <div class="tab-1" id="situation"><a>實施成果</a></div>
          <div class="tab-1" id="list"><a>檢討與建議</a></div>
      </div>

      <!------ 辦理情形 ------>
      <table class="table_03" id="employedTable">
        <tr>
          <th width="18%">計畫實施之辦理情形</th>
          <td>${ result.planExecutionSituation.replace("<", "&lt;").replace(">", "&gt;").replace("\\n","<br>")}</td>
        </tr>
      </table>        
      
      
      <!------ 實施成果 ------>
      <table class="table_03" id="situationTable" style="display:none">
        <tr>
          <th width="18%">計畫實施之成果</th>
          <td>${ result.result.replace("<", "&lt;").replace(">", "&gt;").replace("\\n","<br>")}</td>
        </tr>
      </table>      
      

      <!------ 檢討與建議 ------>
      <table class="table_03" id="listTable" style="display:none">
        <tr>
          <th width="18%">計畫實施之檢討與建議</th>
          <td>${ result.suggestion.replace("<", "&lt;").replace(">", "&gt;").replace("\\n","<br>")}</td>
        </tr>
      </table>     
      

      <!------------------- table 2 ------------------->


        
        
      <!------------------- 相關檢核項目 ------------------->
      <div class="file_title-2">檢附文件審核</div>
		<table class="table_04">
          <tr>
            <th width="18%">最新日期</th>
            <th width="12%" class="point">檢核狀態</th>
            <th class="point">檢附文件</th>
            <th>審核意見</th>
          </tr>
          <c:forEach var="i" items="${base[0].get('allowanceFileStatusRecord').split(';')}"  varStatus="status">
          	<c:set var="lastDate" value="${i}"/>
          </c:forEach>
          <tr>
          	<td>${lastDate.substring(lastDate.lastIndexOf('、')+1,lastDate.lastIndexOf('、')+5)-1911}${lastDate.substring(lastDate.lastIndexOf('、')+5,lastDate.lastIndexOf('、')+11).replace('-','/')}</td>
            <td><c:if test="${base[0].get('allowanceFileStatus')==4}"><span class="text_pass">合格</span></c:if>
            <c:if test="${base[0].get('allowanceFileStatus')==1}"><span class="text_warn">待審</span></c:if>
            <c:if test="${base[0].get('allowanceFileStatus')==2}"><span class="text_warn">待補件</span></c:if>
            <c:if test="${base[0].get('allowanceFileStatus')==3}"><span class="text_warn">已補件</span></c:if>
            </td>
            <td width="14%"><a href="javascript:void(0);" onclick="attachment('${base[0].get("seq")}','${base[0].get("year")}','${base[0].get("id")}')"><u>查看資訊頁</u></a></td>
            <td style="text-align:left"><input type="text" id="checkAllowanceAttachmentRemark" value="${base[0].checkAllowanceAttachmentRemark }" size="50"></td>
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
	            <td><input type="text" size="50" id="checkBlacklistRemark" <c:if test="${base[0].checkBlacklistRemark==''}">value="不實請領或溢領，依在職中高齡者及高齡者穩定就業辦法第24條第2項停止補助2年。"</c:if><c:if test="${base[0].checkBlacklistRemark!=''}">value="${base[0].checkBlacklistRemark}"</c:if> disabled></td>
            </c:if>
            <c:if test="${empty blackList}">
	            <td><span class="text_pass" id="checkBlacklistStatus">合格</span></td>
	            <td style="text-align:left"><a href="javascript:void(0);"><u>尚無紀錄</u></a>&nbsp; (本系統) </td>
	            <td><input type="text" size="50" id="checkBlacklistRemark" <c:if test="${base[0].checkBlacklistRemark==''}">value="符合規定"</c:if><c:if test="${base[0].checkBlacklistRemark!=''}">value="${base[0].checkBlacklistRemark}"</c:if> disabled></td>
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
            <td><input type="text" size="50" id="checkSiteinspectionRemark" <c:if test="${base[0].checkSiteinspectionRemark==''}">value="符合規定"</c:if><c:if test="${base[0].checkSiteinspectionRemark!=''}">value="${base[0].checkSiteinspectionRemark}"</c:if> disabled></td>
            </c:if>
          </tr>
          <tr>
            <td><b>投保 / 職災</b></td>
            <c:if test="${base[0].checkInsuranceStatus=='Y'}"><td><span class="text_pass">合格</span></td></c:if>
            <c:if test="${base[0].checkInsuranceStatus=='N'}"><td><span class="text_warn">不合格</span></td></c:if>
            <c:if test="${base[0].checkInsuranceStatus=='' || base[0].checkInsuranceStatus==null}"><td>&nbsp;</td></c:if>
            <td style="text-align:left"><a href="https://192.168.1.62/" target="_blank"><u>詳細資料</u></a>&nbsp; (另開頁面)</td>
            <td><input type="text" size="50" id="checkInsuranceRemark" disabled value="${base[0].checkInsuranceRemark }"></td>
          </tr>
          <tr>
            <td><b>未重複請領津貼</b></td>
            <c:if test="${base[0].checkAllowanceStatus=='Y'}"><td><span class="text_pass">合格</span></td></c:if>
            <c:if test="${base[0].checkAllowanceStatus=='N'}"><td><span class="text_warn">不合格</span></td></c:if>
            <c:if test="${base[0].checkAllowanceStatus=='' || base[0].checkAllowanceStatus==null}"><td>&nbsp;</td></c:if>
            <td style="text-align:left"><a href="https://3in1t.ejob.gov.tw/" target="_blank"><u>詳細資料</u></a>&nbsp; (另開頁面)</td>
            <td><input type="text" value="${base[0].checkAllowanceRemark}" size="50" id="checkAllowanceRemark" disabled></td>
          </tr>
          <tr>
            <td><b>民間團體補(捐)助系統CGSS</b></td>
            <c:if test="${base[0].checkCgssStatus=='Y'}"><td><span class="text_pass">合格</span></td></c:if>
            <c:if test="${base[0].checkCgssStatus=='N'}"><td><span class="text_warn">不合格</span></td></c:if>
            <c:if test="${base[0].checkCgssStatus=='' || base[0].checkCgssStatus==null }"><td>&nbsp;</td></c:if>
            <td style="text-align:left"><a href="https://subsidy.nat.gov.tw/index.aspx" target="_blank"><u>詳細資料</u></a>&nbsp; (另開頁面)</td>
            <td><input type="text" <c:if test="${base[0].checkCgssRemark==''}">value="有/無違反民間團體補捐助規定"</c:if><c:if test="${base[0].checkCgssRemark!=''}">value="${base[0].checkCgssRemark}"</c:if> size="50" id="checkCgssRemark" disabled></td>
          </tr>
          <tr>
            <td><b>違反勞動法令</b></td>
            <c:if test="${base[0].checkViolationlaborlawsStatus=='Y'}"><td><span class="text_pass">合格</span></td></c:if>
            <c:if test="${base[0].checkViolationlaborlawsStatus=='N'}"><td><span class="text_warn">不合格</span></td></c:if>
            <c:if test="${base[0].checkViolationlaborlawsStatus==''||base[0].checkViolationlaborlawsStatus==null}"><td>&nbsp;</td></c:if>
            <td style="text-align:left"><a href="https://announcement.mol.gov.tw/" target="_blank"><u>查詢系統</u></a>&nbsp; (另開頁面) </td>
            <td><input type="text" size="50" id="checkViolationlaborlawsRemark" disabled value="${base[0].checkViolationlaborlawsRemark}"></td>
          </tr>
        </table>
        
        
      <!------------------- table 3 ------------------->
      <div class="file_title-2">案件核定</div>
      <table class="table_03">
        <tr>
          <th class="point">補捐助系統案件序號</th>
          <td width="24%"><input type="text" id="allowanceId" value="${base[0].allowanceId }" disabled></td>
          <th width="18%" class="point">申請日期</th>
          <td><input type="text" id="allowanceApplyTime" value="${base[0].allowanceApplyTime }" disabled></td>
        </tr>
        <tr>
          <th class="point">計畫起訖期間</th>
          <td><input type="text" id="allowanceApplyStartTime" value="${base[0].allowanceApplyStartTime }" size="8" disabled>
            ~
            <input type="text" id="allowanceApplyEndTime" value="${base[0].allowanceApplyEndTime }" size="8" disabled></td>
          <th class="point">計畫總經費</th>
          <td><input type="text" id="allowanceTotalAmounts" value="${base[0].allowanceTotalAmounts }" disabled></td>
        </tr>
        <tr>
          <th class="point">申請補助金額</th>
          <td><input type="text" id="allowanceAmounts" value="${base[0].allowanceAmounts }" disabled></td>
          <th class="point">總核定金額</th>
          <td><input type="text" id="allowanceApproveAmounts" value="${base[0].allowanceApproveAmounts }" disabled></td>
        </tr>
          <tr>
            <th class="point" width="18%">核定文號</th>
            <td><input type="text" id="allowanceApproveId" value="${base[0].allowanceApproveId }" disabled></td>
            <th class="point">核定日期</th>
            <td><input type="text" id="allowanceApproveTime" value="${base[0].allowanceApproveTime }" disabled></td>
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
          <tr>
            <th>其他意見</th>
            <td colspan="3"><textarea id="allowanceRemark" name="allowanceRemark" rows="3" style="width:700px" disabled>${base[0].allowanceRemark.replace("\\n","&#13;&#10;") }</textarea></td>
          </tr>
        </table>
      <!------------------- table 3 ------------------->
      <div class="file_title-2">請領資料審核</div>
      
      <table class="table_04">
        <tr>
          <th class="point">核定補助金額</th>
          <td style="text-align:left">${ result.approveAmounts }</td>
          <th class="point">實支金額</th>
          <td style="text-align:left">${ result.realAmounts }</td>
        </tr>
        <tr>
          <th class="point">請領審核結果</th>
          <td style="text-align:left">
          <label>
                <input name="caseStatus" type="radio" id="caseStatus7" class="radio" value="7" <c:if test="${base[0].caseStatus>=7 }">checked</c:if>/>
                通過 </label>
              <label>
                <input name="caseStatus" type="radio" id="caseStatus6" class="radio not" value="6" <c:if test="${base[0].caseStatus==6 }">checked</c:if>/>
            未通過</label>
          </td>
          <th class="point">請領核撥金額</th>
          <td style="text-align:left"><input type="text" id="allowanceApprovedAmounts" value="${base[0].allowanceApprovedAmounts }" size="10"></td>
        </tr>
        <tr>
          <th class="point">核撥文號</th>
          <td style="text-align:left"><input type="text" id="allowanceApprovedId" value="${base[0].allowanceApprovedId }"></td>
          <th class="point">核撥日期</th>
          <td style="text-align:left"><input type="text" id="allowanceApprovedTime" value="${base[0].allowanceApprovedTime }" size="10"></td>
        </tr>
        <tr>
          <th width="15%">承辦單位</th>
          <td width="35%" style="text-align:left">
          	<c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
		      		<c:if test="${base[0].verifyUnit==unitItem.code}">${unitItem.name}</c:if> 
	      	</c:forEach>
          </td>
          <th width="15%">承辦人員</th>
          <td width="25" style="text-align:left">
          	<c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
	      		<c:if test="${base[0].verifyPerson==userItem.id}">${userItem.name}</c:if> 
	      	</c:forEach>
          </td>
        </tr>
        <tr>
          <th>最後異動時間</th>
          <td style="text-align:left">
          	${base[0].updateTime.substring(0,4)-1911}${base[0].updateTime.substring(4,16)}
          </td>
          <th>最後異動人員</th>
          <td style="text-align:left">
          	<c:forEach  items="${userList}"  var="userItem"  varStatus="userStatus">
	      		<c:if test="${base[0].updator==userItem.id}">${userItem.name}</c:if> 
	      	</c:forEach>
          </td>
        </tr>
      </table>


      <!------------------- table 3 ------------------->

      
      
      <div class="btn_box-3">
      	  <button type="button" class="btn_02" onclick="cancel()">取消修改</button>
	      <button type="button" class="btn_01" onclick="save()">儲存資料</button>
<!-- 	      <button type="button" class="btn_02"  onclick="save()">儲存修改</button> -->
<!-- 	      <button type="button" class="btn_01">核定案件</button> -->
      </div>
      
	  <form method="post" id="dataForm" target="_blank">
      	<input type="text" id="dataSeq" name="seq" style="display:none">
      	<input type="text" id="applyYear" name="applyYear" style="display:none">
      	<input type="text" id="dataId" name="id" style="display:none">
      </form>

      
  
  
  
    </div>
    
    
  </div>
  <!---------------------- main ---------------------->
  

</body>




</html>
