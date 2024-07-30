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

  <%@ include file="../mainMenu.jsp" %>

  <!---------------------- left menu ---------------------->
  <div id="left_menu">
    <div class="panel-group" id="accordion">
    
    <!---------- collapse1 ---------->
	<div class="panel panel-default">
		<div class="panel-heading-in">
			<h4 class="panel-title">
			  <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">申請帳號審核</a>
			</h4>
		</div>
		<div id="collapse1" class="panel-collapse collapse in">
			<div class="panel-body">
				<ul>
          <li><a href="account01" class="in">新申請帳號</a></li>
          <li><a href="account02">帳密查詢回覆</a></li>
        </ul>
			</div>
		</div>
	</div>
    
    
    
  </div>
  </div>
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">申請帳號審核
        <span>新申請帳號</span>
        <span id="number">account01_1</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      

      <!------------------- search ------------------->
      <form action="account01" method="post" id="searchForm">
      <div id="search_bar">
        <table class="table_01">
          <tr>
              <th width="20%">統一編號 / 扣繳編號：</th>
              <td width="20%"><input type="text" size="11" id="seq" name="seq" value="${searchSeq}"></td>
              <th width="14%">申請單位名稱：</th>
              <td><input type="text" size="11" id="companyName" name="companyName" value="${searchCompanyName }"></td>
              <td width="22%">
                <div class="btn_box-td">
                  <button type="submit" class="btn_01" value="開始查詢">開始查詢</button>
                  <button type="button" class="btn_02" value="清除" onclick="clearSearchData()">清除</button>
                </div>
              </td>
          </tr>
        </table>
      </div>
      </form>
      <!------------------- 申請帳號資料 ------------------->
      <div class="file_title-2">申請帳號資料</div>
      	<input type="text" id="email" name="email" value="${companyInfoData.get('email') }" style="display:none">
        <table class="table_03">
          <tr>
            <th width="18%">事業單位名稱</th>
            <td width="30%" id="enrollCompanyName">${companyInfoData.get("companyName") }</td>
            <th width="18%">負責人</th>
            <td>${companyInfoData.get("principal") }</td>
          </tr>
          <tr>
            <th>行業別</th>
            <td><c:forEach items="${industryList}" var="item"><c:if test='${item.code==companyInfoData.get("industry")}'>${item.name}</c:if></c:forEach></td>
            <th>統一編號 / 扣繳編號</th>
            <td id="enrollSeq">${companyInfoData.get("seq") }</td>
          </tr>
          
          <tr>
            <th>登記地址</th>
            <td><c:forEach items="${cityList}" var="item"><c:if test='${item.code==companyInfoData.get("registerCity")}'>${item.name}</c:if></c:forEach>
            <c:forEach items="${registerAreaList}" var="item"><c:if test='${item.code==companyInfoData.get("registerArea")}'>${item.name}</c:if></c:forEach>
            ${companyInfoData.get("registerAddress") }
            </td>
            <th>聯絡地址</th>
            <td><c:forEach items="${cityList}" var="item"><c:if test='${item.code==companyInfoData.get("contactCity")}'>${item.name}</c:if></c:forEach>
            <c:forEach items="${contactAreaList}" var="item"><c:if test='${item.code==companyInfoData.get("contactArea")}'>${item.name}</c:if></c:forEach>
            ${companyInfoData.get("contactAddress") }
            </td>
          </tr>
          <tr>
            <th>聯絡人</th>
            <td>${companyInfoData.get("contactName") }</td>
            <th>聯絡人職稱</th>
            <td>${companyInfoData.get("contactJobtitle") }</td>
          </tr>
          <tr>
            <th>聯絡電話</th>
            <td>${companyInfoData.get("contactWorkPhoneAreaCode") } - ${companyInfoData.get("contactWorkPhone") } #${companyInfoData.get("contactWorkPhoneExtension") }
            
            </td>
            <th>行動電話</th>
            <td>${companyInfoData.get("contactPhone") }</td>
          </tr>
          <tr>
            <th>傳真號碼</th>
            <td>${companyInfoData.get("faxAreaCode") } - ${companyInfoData.get("fax") }</td>
            <th>電子信箱</th>
            <td>${companyInfoData.get("email") }</td>
          </tr>
          <tr>
            <th>設立登記證明文件</th>
            <td colspan="3">
            	<c:choose><c:when test="${not empty registerAttachment}">
		      	<c:forEach items="${registerAttachment}" var="item" varStatus="status">
		      		<div>
	                	<a href="/file${item.filePath}/${item.fileName}" class="visited" target="_blank">${item.fileName}</a>
	              	</div>
		      	</c:forEach>
		   		</c:when></c:choose>
            </td>
          </tr>
          <tr>
            <th>申請單位授權書</th>
            <td colspan="3">
            	<c:choose><c:when test="${not empty authorizeAttachment}">
		      	<c:forEach items="${authorizeAttachment}" var="item" varStatus="status">
		      		<div>
	                	<a href="/file${item.filePath}/${item.fileName}" class="visited" target="_blank">${item.fileName}</a>
	              	</div>
		      	</c:forEach>
		   		</c:when></c:choose>
            </td>
          </tr>
          <tr>
            <th>申請日期</th>
            <td>${companyInfoData.get("createTime").substring(0,4)-1911 }${companyInfoData.get("createTime").substring(4,11)}&nbsp;&nbsp;&nbsp;${companyInfoData.get("createTime").substring(11,16)}</td>
            <th>審核單位</th>
            <td>勞動力發展署</td>
          </tr>
        </table>
      <input type="text" id="verifyUnit" value="${unit }" style="display:none">
      <input type="text" id="verifyPerson" value="${id }" style="display:none">
      <input type="text" id="dataSeq" value="${companyInfoData.get('seq') }" style="display:none">
      
      <div class="text-center h5 pt-4">經人工審核(電訪)確認後，發送密碼至電子信箱</div>
      
      <div class="page_number">
      <input type="button" class="btn_02" value="取消" onclick="cancel()"/>
      <input type="button" class="btn-success btn_02" value="發送密碼" onclick="sendMail()"/>
      </div>
      <br><br><br>
      
      
      

    </div>
    
  </div>
  <!---------------------- main ---------------------->
  
  <script src="js/account/account01_1.js"></script>
</body>




</html>
