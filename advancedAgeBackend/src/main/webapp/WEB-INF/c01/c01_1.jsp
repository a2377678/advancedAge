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

<script type="text/javascript" src="js/c01/c01_1.js"></script>

</head>



<body>


  <!---------------------- top ---------------------->
  <%@ include file="../header.jsp" %>
  <!---------------------- top end ---------------------->

  <%@ include file="../mainMenu.jsp" %>

  <!---------------------- left menu ---------------------->
  <%@ include file="../leftMenu.jsp" %>
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">請款與核銷
        <span>請領核銷作業</span>
        <span id="number">C01-1</span>
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
          <th width="18%">負責人</th>
          <td>${companyInfoData.get("principal") }</td>
        </tr>
        <tr>
          <th>統一編號 / 扣繳編號</th>
          <td>${apply.seq }</td>
          <th>連絡電話 / 手機</th>
          <td>${apply.contactPhone }</td>
        </tr>
        <tr>
          <th>聯絡人</th>
          <td>${apply.contactName}</td>
          <th>聯絡人職稱</th>
          <td>${apply.contactJobtitle}</td>
        </tr>
        <tr>
          <th>勞保投保證號</th>
          <td colspan="3">${apply.guaranteeNumber.replace(';','、')}</td>
        </tr>
      </table>
      
      <!------------------- 相關檢核項目 ------------------->
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
	            <td><input type="text" size="50" id="checkBlacklistRemark" disabled <c:if test="${base[0].checkBlacklistRemark==''}">value="不實請領或溢領，依在職中高齡者及高齡者穩定就業辦法第24條第2項停止補助2年。"</c:if><c:if test="${base[0].checkBlacklistRemark!=''}">value="${base[0].checkBlacklistRemark}"</c:if>></td>
            </c:if>
            <c:if test="${empty blackList}">
	            <td><span class="text_pass" id="checkBlacklistStatus">合格</span></td>
	            <td style="text-align:left"><a href="javascript:void(0);"><u>尚無紀錄</u></a>&nbsp; (本系統) </td>
	            <td><input type="text" size="50" id="checkBlacklistRemark" disabled <c:if test="${base[0].checkBlacklistRemark==''}">value="符合規定"</c:if><c:if test="${base[0].checkBlacklistRemark!=''}">value="${base[0].checkBlacklistRemark}"</c:if>></td>
            </c:if>
          </tr>
          <tr>
            <td><b>實地查核</b></td>
            <c:if test="${not empty siteInspection}">
            <td><span class="text_warn" id="checkSiteinspectionStatus">不合格</span></td>
            <td style="text-align:left"><a href="javascript:void(0);" onclick="siteInspection('${siteInspection[0].id}')"><u>詳細資料</u></a>&nbsp; (本系統) </td>
            <td><input type="text" size="50" id="checkSiteinspectionRemark" disabled value="${base[0].checkSiteinspectionRemark }"></td>
            </c:if>
            <c:if test="${empty siteInspection}">
            <td><span class="text_pass" id="checkSiteinspectionStatus">合格</span></td>
            <td style="text-align:left"><a href="javascript:void(0);"><u>尚無紀錄</u></a>&nbsp; (本系統) </td>
            <td><input type="text" size="50" id="checkSiteinspectionRemark" disabled <c:if test="${base[0].checkSiteinspectionRemark==''}">value="符合規定"</c:if><c:if test="${base[0].checkSiteinspectionRemark!=''}">value="${base[0].checkSiteinspectionRemark}"</c:if>></td>
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

      <!------------------- table 2 ------------------->
		
      <!------------------- 案件核定資料 ------------------->
      <div class="file_title-2">案件核定</div>
      <table class="table_03">
        <tr>
          <th class="point">補捐助系統案件序號</th>
          <td width="24%"><input type="text" id="allowanceId" name="allowanceId" value="${base[0].allowanceId }" disabled></td>
          <th width="18%" class="point">申請日期</th>
          <td><input type="text" id="allowanceApplyTime" name="allowanceApplyTime" value="${base[0].allowanceApplyTime }" disabled></td>
        </tr>
        <tr>
          <th class="point">計畫起訖期間</th>
          <td><input type="text" id="allowanceApplyStartTime" name="allowanceApplyStartTime" value="${base[0].allowanceApplyStartTime }" size="9" disabled>
~
  <input type="text" id="allowanceApplyEndTime" name="allowanceApplyEndTime" value="${base[0].allowanceApplyEndTime }" size="9" disabled></td>
          <th class="point">計畫總經費</th>
          <td><input type="text" id="allowanceTotalAmounts" name="allowanceTotalAmounts" value="${base[0].allowanceTotalAmounts }" disabled></td>
        </tr>
        <tr>
          <th class="point">申請補助金額</th>
          <td><input type="text" id="allowanceAmounts" name="allowanceAmounts" value="${base[0].allowanceAmounts }" disabled></td>
          <th class="point">總核定金額</th>
          <td><input type="text" id="allowanceApproveAmounts" name="allowanceApproveAmounts" value="${base[0].allowanceApproveAmounts }" disabled></td>
        </tr>
          <tr>
            <th class="point" width="18%">核定文號</th>
            <td><input type="text" id="allowanceApproveId" name="allowanceApproveId" value="${base[0].allowanceApproveId }" disabled></td>
            <th class="point">核定日期</th>
            <td><input type="text" id="allowanceApproveTime" name="allowanceApproveTime" value="${base[0].allowanceApproveTime }" disabled></td>
          </tr>
          <tr>
            <th>承辦單位</th>
            <td>
            	<c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
		      		<c:if test="${base[0].verifyUnit==unitItem.code}">${unitItem.name}</c:if> 
	      		</c:forEach></td>
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
	      	</td>
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
          <th colspan="2">核定</th>
          <th colspan="4" class="point">請領審核</th>
          <th colspan="5" class="point">請領審核結果</th>
          <th colspan="2" class="point">請領核發</th>
        </tr>
        <tr>
          <th width="6%">屆齡</th>
          <th width="6%">核定</th>
          <th width="11%" class="point">請領日期</th>
          <th width="6%" class="point">人數</th>
          <th width="7%" class="point">清冊</th>
          <th width="7%" class="point">附件</th>
          <th width="6%" class="point">符合</th>
          <th width="6%" class="point">不符</th>
          <th width="7%" class="point">比率</th>
          <th width="7%" class="point">報表</th>
          <th width="8%" class="point">結果</th>
          <th width="12%" class="point">本次核撥金額</th>
          <th class="point">核定</th>
        </tr>
        <c:forEach items="${base[0].get('allowanceFrequencyRecord').split(';') }" var="item" varStatus="status">
       		<c:set var="employmenyListReceiptSize" value="0"/>
       		<c:set var="employmenyListReceiptSuccess" value="0"/>
       		<c:set var="employmenyListReceiptFail" value="0"/>
       		<c:set var="employmenyListReceiptAmounts" value="0"/>
       		<c:forEach items="${employmenyListReceipt}" var="i">
       			<c:if test="${status.count==i.baseAllowanceFrequency}">
       				<c:set var="employmenyListReceiptSize" value="${employmenyListReceiptSize+1 }"/>
       			</c:if>
       			<c:if test="${status.count==i.baseAllowanceFrequency && not empty i.approveStatus && i.approveStatus!=3 }">
       				<c:set var="employmenyListReceiptSuccess" value="${employmenyListReceiptSuccess+1 }"/>
       			</c:if>
       			<c:if test="${status.count==i.baseAllowanceFrequency && not empty i.approveStatus && i.approveStatus==3 }">
       				<c:set var="employmenyListReceiptFail" value="${employmenyListReceiptFail+1 }"/>
       			</c:if>
       			<c:if test="${status.count==i.baseAllowanceFrequency && not empty i.adjustAmounts && i.approveStatus!='3'}">
       					<c:set var="employmenyListReceiptAmounts" value="${employmenyListReceiptAmounts+i.adjustAmounts }"/>
       			</c:if>
       			<c:if test="${status.count==i.baseAllowanceFrequency && empty i.adjustAmounts && i.approveStatus!='3'}">
       					<c:set var="employmenyListReceiptAmounts" value="${employmenyListReceiptAmounts+i.amounts }"/>
       			</c:if>
       		</c:forEach>
       		
       		<tr>
	       		<td>${plan.nearHighEmploymentNumber }</td>
		        <td>${base[0].get("checkEmploymentPerson") }</td>
		        <td>${item.split('、')[1].substring(0,4)-1911}${item.split('、')[1].substring(4)}</td>
		        <td>${employmenyListReceiptSize }</td>
		        <td><a href="#" onclick="openData('${base[0].get('seq')}',${base[0].get('id')},${base[0].get('year')},${status.count},'1')"><u>審核</u></a></td>
		        <td><a href="#" onclick="openData('${base[0].get('seq')}',${base[0].get('id')},${base[0].get('year')},${status.count},'3')"><u>檢視</u></a></td>
		        
		        <td>${employmenyListReceiptSuccess}</td>
		        <td>${employmenyListReceiptFail}</td>
		        <td><fmt:formatNumber type = "number" 
         maxFractionDigits = "1" value = "${employmenyListReceiptSuccess/employmenyListReceiptSize*100}" />%</td>
		        <td><a href="#" onclick="openData('${base[0].get('seq')}',${base[0].get('id')},${base[0].get('year')},${status.count},'2')"><u>檢視</u></a></td>
		        <td>
		        	<c:if test="${employmenyListReceiptSuccess/employmenyListReceiptSize*100>30}"><span class="text_pass">符合</span></c:if>
		        	<c:if test="${employmenyListReceiptSuccess/employmenyListReceiptSize*100<30}"><span class="text_warn">不符合</span></c:if>
		        </td>
		        
		        <td><fmt:formatNumber type = "number" value = "${employmenyListReceiptAmounts}" /></td>
		        <td>
		        	<c:if test="${item.split('、')[2]==0}"><button type="button" class="btn_05" onclick="verify('${base[0].get('allowanceFrequencyRecord')}','${item.split('、')[0] }')">核定</button></c:if>
		        	<c:if test="${item.split('、')[2]==1}">已核定</c:if>
		        </td>
	        </tr>
       	</c:forEach>
      </table>
      
      <br>
      
      <table class="table_04">
        <tr>
          <th width="12%">承辦單位</th>
          <td width="37%" style="text-align:left">
          	<c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
		      		<c:if test="${base[0].verifyUnit==unitItem.code}">${unitItem.name}</c:if> 
	      	</c:forEach>
          </td>
          <th width="13%">承辦人員</th>
          <td width="27" style="text-align:left">
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
      <button type="button" class="btn_02" onclick="cancel()">返回列表</button>
      </div>
      

	  <form action="c01_list" method="post" id="dataForm" target="_blank">
	  	<input type="text" id="dataId" name="id" style="display:none">
      	<input type="text" id="dataSeq" name="seq" style="display:none">
      	<input type="text" id="year" name="year" style="display:none">
      	<input type="text" id="baseAllowanceFrequency" name="baseAllowanceFrequency" style="display:none">
      	<input type="text" id="advancedAgeBaseId" name="advancedAgeBaseId" style="display:none">
      </form>
      
  
  
  
    </div>
    
  </div>
  <!---------------------- main ---------------------->
  

</body>




</html>
