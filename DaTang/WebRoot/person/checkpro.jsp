<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查询计划</title>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
</head>
<%@include file="../commons/mytaglib.jsp" %>
<body><!-- #BeginLibraryItem "/Library/topbanner.lbi" -->
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<div id="logo"><img src="${pageContext.request.contextPath}/images/top.jpg" width="1002" height="258" /></div>
<!-- #EndLibraryItem --><table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="rightimg"><!-- #BeginLibraryItem "/Library/left2.lbi" -->
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<div id="left">
      <p><a href="emptask.do" target="_self" >计划管理</a></p>
      <p><a href="queryPlan.do" target="_self">查询计划</a></p>
      <p><a href="emptask.do" target="_self">我的任务</a></p>
      <p ><a href="Planinvalidate.do" target="_self">退出系统</a></p>
</div><!-- #EndLibraryItem --><div id="right">
        <p>您现在的位置 &gt;&gt; 查询计划 &gt;&gt; 查询</p>
        <form id="form1" name="form1" method="post" action="advancedquery.do">
          <h1>查询信息:</h1>
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">计划名称</td>
              <td width="579"><input type="text" name="planName" value="${dto.planName}"/></td>
            </tr>
            <tr>
              <td class="tdcolor">所属任务</td>
              <td>
              
              <select name="select">
              	<c:forEach items="${mt}" var="t">
                <option value="${t.taskId}">${t.taskName}</option>
                </c:forEach>
                            </select>
                            
              </td>
            </tr>
            
            <tr>
              <td class="tdcolor">开始时间</td>
              <td>从
                <input name="beginDate1" type="text" size="15"  value="<fmt:formatDate value="${dto.beginDate1}"  pattern="yyyy-MM-dd" />"/>
              到
              <input name="beginDate2" type="text" size="15"  value="<fmt:formatDate value="${dto.beginDate2}"  pattern="yyyy-MM-dd" />"/>              </td>
            </tr>
            <tr>
              <td class="tdcolor">结束时间</td>
              <td>从
                <input name="endDate1" type="text" size="15"  value="<fmt:formatDate value="${dto.endDate1}"  pattern="yyyy-MM-dd" />"/>
到
<input name="endDate2" type="text" size="15"  value="<fmt:formatDate value="${dto.endDate2}"  pattern="yyyy-MM-dd" />"/></td>
            </tr>
            <tr>
              <td class="tdcolor">是否反馈</td>
              <td><label>
                <input name="isFeedback" type="text" size="15"  value="${dto.isFeedback}"/>
              </label></td>
            </tr>
          </table>
          <p>
            <input name="Submit" type="submit" class="menu3" value="查询计划" />
          </p>
		  
		  		  <h1>计划信息：</h1>
		  <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">计划名称</td>
              <td width="15%" class="tdcolor">所属任务</td>
              <td class="tdcolor">开始时间</td>
              <td class="tdcolor">结束时间</td>
              <td class="tdcolor">计划状态</td>
              <td class="tdcolor">是否反馈</td>
            </tr>
            
            <c:forEach items="${plans}" var="p">
            <tr>
              <td><a href="selectId.do?pid=${p.planId}" target="_self">${p.planName}</a></td>
              <td>${taskName}</td>
              <td>${p.beginDate}</td>
              <td>${p.endDate}</td>
              <td>${p.status}</td>
              <td><label>${p.isFeedback}</label></td>
            </tr>
           </c:forEach>
           
          </table>
         
        </form>
        			
      </div>    </td>
  </tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath}/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem --></body>
</html>

