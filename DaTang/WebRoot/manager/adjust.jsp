<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>调整任务</title>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
</head>
<%@include file="../commons/mytaglib.jsp" %>
<body><!-- #BeginLibraryItem "/Library/topbanner.lbi" -->
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<div id="logo"><img src="${pageContext.request.contextPath}/images/top.jpg" width="1002" height="258" /></div>
<!-- #EndLibraryItem --><table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="rightimg"><!-- #BeginLibraryItem "/Library/left.lbi" --><div id="left">
      <p><a href="AllTask.do" target="_self">查看任务</a></p>
      <p><a href="taskCreate.do" target="_self">制定任务</a></p>
      <p><a href="taskundone.do" target="_self">调整任务</a></p>
      <p><a href="intendance.do" target="_self">跟踪任务</a></p>
      <p><a href="checkper.do" target="_self">查看人员</a></p>
      <p><a href="invalidate.do" target="_self">退出系统</a></p>
</div><!-- #EndLibraryItem --><div id="right">
        <p>您现在的位置 &gt;&gt; 调整任务 &gt;&gt; 调整任务信息</p>
        <h1>调整任务信息</h1>
        
        <form id="form1" name="form1" method="post" action="update1.do?id=${updateTask.taskId}">
          <p>任务名称：<label>
          <input name="taskName" type="text" size="50"  value="${updateTask.taskName}"/>
          </label></p>
          <p>任务描述：
            <label>
            <textarea name="taskDesc"  >${updateTask.taskDesc}</textarea>
            </label>
          </p>
            <p>开始时间：
              <label>
              
                <input name="beginDate" type="text" size="16" value="<fmt:formatDate value="${updateTask.beginDate}"  pattern="yyyy-MM-dd" />"/>
              </label>
             <span class="marginleft1">结束时间：
              <label>
                <input name="endDate" type="text" size="16" value="<fmt:formatDate value="${updateTask.endDate}"  pattern="yyyy-MM-dd" />"/>
              </label></span>
          </p>
          <p>实施人员：
            <label>
              <select name="select">
            <c:forEach items="${employees}" var="e">
            	<c:if test="${updateTask.implementorId.employeeId == e.employeeId}">
                <option value="${e.employeeId}" selected="selected">${e.realName}</option></c:if>
                
                <c:if test="${updateTask.implementorId.employeeId != e.employeeId}">
                <option value="${e.employeeId}">${e.realName}</option></c:if>
              </c:forEach>
              </select> 
            </label>
            <span class="marginleft">任务状态：
             ${updateTask.status}
            </span></p>
            <p>
              <label>
              <input name="Submit" type="reset" class="menu2" value="重置" />
              </label>
           &nbsp; 
              <label>
              <input name="Submit2" type="submit" class="menu1" value="提交" />
              </label>
           </p>
      </form>
        <p>&nbsp;</p>
      </div>
    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath}/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem --></body>
</html>
