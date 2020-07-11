<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>跟踪计划信息</title>
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
        <p>您现在的位置 &gt;&gt; 跟踪任务 &gt;&gt; 跟踪计划信息</p>
		 <form id="form1" name="form1" method="post" action="update.do?id=${task.taskId}">
		<h1>任务详细信息:</h1>
          
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">任务名称</td>
              <td width="579" colspan="3">${task.taskName}</td>
            </tr>
            <tr>
              <td class="tdcolor">任务描述</td>
              <td colspan="3">&nbsp;${task.taskDesc}</td>
            </tr>
            <tr>
              <td class="tdcolor">开始时间</td>
              <td width="579">${task.beginDate}</td>
              <td width="579" class="tdcolor">结束时间</td>
              <td width="579"><p>&nbsp;${task.endDate}</p></td>
            </tr>
            
            <tr>
              <td class="tdcolor">实施人</td>
              <td>&nbsp;${task.implementorId.realName}</td>
              <td class="tdcolor">任务状态</td>
              <td>
               
                  <select name="select">
                    <option value="1">实施中</option>
                    <option value="2">已完成</option>
                  </select>              </td>
            </tr>
        </table>
		<input name="Submit" type="submit" class="menu4" value="提交" />
		</form>
		
             <form id="form2" name="form1" method="post" action="">
		  <h1>计划信息：</h1>
		  <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">计划名称</td>
              <td width="15%" class="tdcolor">完成状态</td>
              <td class="tdcolor">是否反馈</td>
              <td class="tdcolor">结束时间</td>
              <td class="tdcolor">结束时间</td>
              <td class="tdcolor">&nbsp;</td>
            </tr>
            <c:forEach items="${task.plan}" var="p">
            <tr>
              <%-- <td>${p.planName}</td>
              <td>${p.status}</td>
              <td>${p.isFeedback}</td>
              <td>${p.beginDate} </td>
              <td>${p.endDate}</td>--%>
              <td> <label>
                <input type="checkbox" name="radiobutton" value="radiobutton" />
              </label></td>
            </tr>
            
            </c:forEach>
            
          </table>
		  <p>
              <label>
              <input name="Submit" type="submit" disabled="disabled" class="menu3" value="反馈信息" />
            </label>
          </p>
      </form>
      
      </div>
    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/copyright.lbi" --><div class="copyright"></div><!-- #EndLibraryItem --><!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath}/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem -->
</body>
</html>
