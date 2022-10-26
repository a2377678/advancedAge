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
    <div><a href="#" class="menu-1 in">繼續僱用高齡者</a></div>
    <div><a href="#" class="menu-2">傳承專業技術與經驗</a></div>
    <div><a href="#" class="menu-3">退休後再就業準備協助措施</a></div>
    <div><a href="account01" class="account">申請帳號審核管理</a></div>
  </div>

  <!---------------------- left menu ---------------------->
  <%@ include file="../leftMenu.jsp" %>
  <!---------------------- left menu end ---------------------->




  <!---------------------- main ---------------------->
  <div id="main">
  
    <div id="content">
      <div id="main_title">權限與系統管理
        <span>使用者帳號與權限</span>
        <span id="number">J02</span>
      </div>
        
      <div id="account">
        <a>登入單位：
        	${unitName }&nbsp;${name }</a>
        <a href="logout">登出</a>
      </div>
      
		<c:if test="${jurisdiction==1 }">
      <!------------------- search ------------------->
      <div id="page_tab">
        <div class="tab-1"><a href="j02" class="in">查詢／修改</a></div>
        <div class="tab-1"><a href="j02_02">新建帳號</a></div>
      </div>
      <form action="j02" method="post" id="searchForm">
      <div id="search_bar">
        <table class="table_01">
          <tr>
            <th width="12%">所屬單位：</th>
            <td width="2%">
            <select name="unit" id="unit">
            	<option value>全部</option>
                <c:forEach  items="${unitList}"  var="item"  varStatus="userStatus">
		      		<option value="${item.code}" <c:if test="${searchUserInfo.unit==item.code}">selected</c:if> >${item.name}</option>
		      	</c:forEach>
              </select>
            </td>
            <th width="14%">權限群組：</th>
            <td width="17%">
            <select id="jurisdiction" name="jurisdiction">
            <option value>全部</option>
	            <option value="1" <c:if test="${searchUserInfo.jurisdiction==1}">selected</c:if>>本署-管理者</option>
	            <option value="2" <c:if test="${searchUserInfo.jurisdiction==2}">selected</c:if>>本署-一般使用者</option>
	            <option value="3" <c:if test="${searchUserInfo.jurisdiction==3}">selected</c:if>>分署-管理者</option>
	            <option value="4" <c:if test="${searchUserInfo.jurisdiction==4}">selected</c:if>>分署-審核人員</option>
	            <option value="5" <c:if test="${searchUserInfo.jurisdiction==5}">selected</c:if>>分署-一般使用者</option>
          	</select>
            </td>
            <th width="8%">狀態：</th>
            <td>
            <label>
              <input name="status" type="radio" id="status" class="radio" checked="checked" value/>
              全部
            </label>
            <label>
              <input name="status" type="radio" id="status1" class="radio" value="1" <c:if test="${searchUserInfo.status==1}">checked</c:if>/>
              啟用
            </label>
            <label>
              <input name="status" type="radio" id="status0" class="radio" value="0" <c:if test="${searchUserInfo.status==0}">checked</c:if>/>
              停用
            </label>
            </td>
          </tr>
          <tr>
            <th>使用者帳號：</th>
            <td><input type="text" size="11" id="userAccount" name="userAccount" value="${searchUserInfo.account}"/></td>
            <th>使用者姓名：</th>
            <td><input type="text" size="11" id="name" name="name" value="${searchUserInfo.name}"/></td>
            <td colspan="2"><div class="btn_box-td">
              <button type="submit" class="btn_01" value="開始查詢">開始查詢</button>
              <button type="button" class="btn_02" value="清除" onclick="clearData()">清除</button>
            </div></td>
          </tr>
        </table>
      </div>
      <input type="text" name="numbersOfPage" value="${pagination.numbersOfPage}" style="display:none">
      <input type="text" name="page" id="page" value="${pagination.page}" style="display:none">
      <input type="text" name="totalNumbers" value="${pagination.totalNumbers}" style="display:none">
      <input type="text" name="totalPages" value="${pagination.totalPages}" style="display:none">
      </form>
	
      <!------------------- search ------------------->
      <h3>搜尋結果：</h3>
      
      <table class="table_07">
        <tr>
          <th width="20%">所屬單位</th>
          <th width="20%">權限群組</th>
          <th width="20%">使用者帳號</th>
          <th width="20%">使用者姓名</th>
          <th>狀態</th>
        </tr>
        <c:choose><c:when test="${not empty userInfoData}">
      	<c:forEach items="${userInfoData}" var="item" varStatus="status">
	      	<tr>
	          <td>
	          	<c:forEach  items="${unitList}"  var="unitItem"  varStatus="userStatus">
		      		<c:if test="${item.unit==unitItem.code}">${unitItem.name}</c:if>	
		      	</c:forEach>
		      </td>
	          <td><c:if test="${item.jurisdiction==1}">本署-管理者</c:if><c:if test="${item.jurisdiction==2}">本署-一般使用者</c:if><c:if test="${item.jurisdiction==3}">分署-管理者</c:if><c:if test="${item.jurisdiction==4}">分署-審核人員</c:if><c:if test="${item.jurisdiction==5}">分署-初審人員</c:if></td>
	          <td><a href="#" onclick="openData('${item.account}')">${item.account}</a></td>
	          <td><a href="#" onclick="openData('${item.account}')">${item.name}</a></td>
	          <td><c:if test="${item.status==1}">啟用</c:if><c:if test="${item.status==0}">停用</c:if></td>
	        </tr>
      	</c:forEach>
        </c:when>
      </c:choose>
        
      </table>

　　　　 <br />

      <div class="page_number">
      	<c:if test="${pagination.page!=null}">
			<span><a href="javascript:void(0)" onclick="changePage('1')">|<</a></span>
			<c:if test="${pagination.page!=1}">
				<span><a href="javascript:void(0)" onclick="changePage('-1')"><</a></span>
			</c:if>
			<c:choose>
				<c:when test="${pagination.totalPages>=4 && pagination.page>2}">
					<c:forEach begin="${pagination.page-2}" end="${pagination.page+2<pagination.totalPages?pagination.page+2:pagination.totalPages}" var="p">
						<span><a href="javascript:void(0)"<c:if test="${pagination.page==p}"> class="in"</c:if> onclick="changePage('${p}')">${p}</a></span>
					</c:forEach>
				</c:when>
				<c:when test="${pagination.totalPages>=4}">
					<c:forEach begin="1" end="3" var="p">
						<span><a href="javascript:void(0)"<c:if test="${pagination.page==p}"> class="in"</c:if> onclick="changePage('${p}')">${p}</a></span>
					</c:forEach>
				</c:when>
				<c:when test="${pagination.totalPages<=3 }">
					<c:forEach begin="1" end="${pagination.totalPages}" var="p">
						<span><a href="javascript:void(0)"<c:if test="${pagination.page==p}"> class="in"</c:if> onclick="changePage('${p}')">${p}</a></span>
					</c:forEach>
				</c:when>
			</c:choose>
			<c:if test="${pagination.totalPages!=pagination.page}">
				<span><a href="javascript:void(0)" onclick="changePage('+1')">></a></span>
			</c:if>
	        <c:if test="${pagination.totalPages>=4 && pagination.page<pagination.totalPages}">
				<span><a href="javascript:void(0)" onclick="changePage(${pagination.totalPages})">>|</a></span>
			</c:if>
		</c:if>
      </div>
      <form action="j02_1" method="post" id="dataForm">
      	<input type="text" id="editAccount" name="editAccount" style="display:none">
      </form>
      </c:if>
      <c:if test="${jurisdiction!=1 }"><p>無此權限</p></c:if>

    </div>
    
  </div>
  <!---------------------- main ---------------------->

<script src="js/j02/j02.js"></script>

</body>




</html>
