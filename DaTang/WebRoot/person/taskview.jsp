<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>计划信息</title>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="js/jquery-1.12.0.js"></script>
		<script type="text/javascript">
			$(function() {
				$("input[type='submit']").attr('disabled', "true");
				$("input[type='checkbox']").click(function () {
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
        <p>您现在的位置 &gt;&gt; 计划管理 &gt;&gt; 计划信息</p>
        <form id="form1" name="form1" method="post" action="deletenewpro.do">
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
              <td width="579"><fmt:formatDate value="${task.beginDate}"  pattern="yyyy-MM-dd"/></td>
              <td width="579" class="tdcolor">结束时间</td>
              <td width="579"><p>&nbsp;<fmt:formatDate value="${task.endDate}"  pattern="yyyy-MM-dd"/></p>              </td>
            </tr>
            
            <tr>
              <td class="tdcolor">实施人</td>
              <td>&nbsp;${task.implementorId.realName}</td>
              <td class="tdcolor">任务状态</td>
              <td>
               
                  <select name="select">
                  	<c:if test="${task.status eq '待实施'}">
	                    <option value="待实施" selected="selected">待实施</option>
	                    <option value="实施中">实施中</option>
	                    <option value="已完成">已完成</option>
                  	</c:if>
                  	<c:if test="${task.status eq '实施中'}">
	                    <option value="待实施" >待实施</option>
	                    <option value="实施中" selected="selected">实施中</option>
	                    <option value="已完成">已完成</option>
                  	</c:if>
                  	<c:if test="${task.status eq '已完成'}">
	                    <option value="待实施">待实施</option>
	                    <option value="实施中">实施中</option>
	                    <option value="已完成" selected="selected">已完成</option>
                  	</c:if>
                  </select>              </td>
            </tr>
        </table>

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
              <td><a href="selectId.do?pid=${p.planId}" target="_self">${p.planName}</a></td>
              <td>${p.status}</td>
              <td>${p.isFeedback}</td>
              <td><fmt:formatDate value="${p.beginDate}"  pattern="yyyy-MM-dd"/></td>
              <td><fmt:formatDate value="${p.endDate}"  pattern="yyyy-MM-dd"/></td>
              <td>&nbsp;<input type="checkbox" name="chebox" value="${p.planId}"></td>
            </tr>
            </c:forEach>
          </table>
          			
		  <p>
		    <a href="person/newpro.jsp"  class="menu2">新建</a>
		    <input name="Submit" type="submit" class="menu1" value="删除" />
          </p>
      </form>
    </div>    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath}/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem --></body>
</html>

