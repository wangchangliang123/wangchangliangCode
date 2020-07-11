<%@page import="com.newer.tang.data.dao.IEmployeeDAO"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>我的任务</title>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="js/jquery-1.12.0.js"></script>
		<script type="text/javascript">
			$(function() {
				$("input[type='submit']").attr('disabled', "true");
				$("input[type='radio']").click(function () {
				$("input[type='submit']").removeAttr("disabled");
				});
			});
		</script>
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
        <p>您现在的位置 &gt;&gt; 我的任务 &gt;&gt; 任务信息</p>
        <h1>任务信息:</h1>
        <form id="form1" name="form1" method="post" action="taskview1.do">
        <input type="hidden" name="flag" value="1"/>
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">任务名称</td>
              <td width="15%" class="tdcolor">制定人</td>
              <td width="15%" class="tdcolor">开始时间</td>
              <td width="15%" class="tdcolor">结束时间</td>
              <td width="15%" class="tdcolor">任务状态</td>
              <td width="15%" class="tdcolor">计划数目</td>
              <td width="10%" class="tdcolor">&nbsp;</td>
            </tr>
            <c:forEach items="${taskAll}" var="t">
            <tr>
              <td>${t.taskName}</td>
              <td>${t.implementorId.realName}</td>
              <td><fmt:formatDate value="${t.beginDate}"  pattern="yyyy-MM-dd"/></td>
              <td><fmt:formatDate value="${t.endDate}"  pattern="yyyy-MM-dd"/></td>
              <td>${t.status}</td>
              <td>${t.plan.size()}</td>
              <td><input type="radio" name="radiobutton" value="${t.taskId}" /></td>
            </tr>
			</c:forEach>
			
          </table>
    <p>
              <label>
              <input name="Submit" type="submit" class="menu3" value="计划管理" />
            </label>
          </p>
      </form>
      </div>
    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath}/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem --></body>
</html>
