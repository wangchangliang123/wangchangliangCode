<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>计划详细信息</title>
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
        <p>您现在的位置 &gt;&gt; 查看任务 &gt;&gt; 计划详细信息</p>
		<h1>计划详细信息：</h1>
        <form id="form1" name="form1" method="post" action="AllTask.do">
		  
		  <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">计划名称</td>
              <td width="579" colspan="3">${p.planName}</td>
            </tr>
            <tr>
              <td class="tdcolor">计划描述</td>
              <td colspan="3">&nbsp;${p.planDesc}</td>
            </tr>
            <tr>
              <td class="tdcolor">开始时间</td>
              <td width="579"><fmt:formatDate value="${p.beginDate}"  pattern="yyyy-MM-dd"/></td>
              <td width="20%" class="tdcolor">结束时间</td>
              <td width="50%"><p>&nbsp;<fmt:formatDate value="${p.endDate}"  pattern="yyyy-MM-dd"/></p></td>
            </tr>
            <tr>
              <td class="tdcolor">所属任务</td>
              <td>&nbsp;${taskName}</td>
              <td class="tdcolor">计划状态</td>
              <td>&nbsp;${p.status}</td>
            </tr>
            <tr>
              <td class="tdcolor">反馈信息</td>
              <td colspan="3">${p.feedbackInfo}</td>
            </tr>
          </table>
		  <p>
              <label>
              <input name="Submit" type="submit" class="menu4" value="返回" />
            </label>
          </p>
      </form>
      </div>
    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/copyright.lbi" --><div class="copyright">COPYRIGHT 2007 DATANG TELECOM TECHNOLOGY CO.LTD 京ICP备06071639号</div><!-- #EndLibraryItem --><!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath}/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem -->
</body>
</html>

