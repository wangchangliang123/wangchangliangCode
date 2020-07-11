<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<%@include file="commons/mytaglib.jsp" %>
<title>登录页面</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
	
<div id="logo"><img src="images/logo.jpg" alt="大唐电信首页" width="1002" height="392" /></div>
<div class="login" id="middle">
  <form action="login.do" method="post" name="form001"  id="form001">
    <p>
      <label>
      用户名：<input type="text" name="employeeName"><br/>
    </label></p>
    <p>  密 码：     
      <label>
    <input type="password" name="password"><br/>
    </label></p>
    <p>角 色：
      <label>
      <select name="select">
      	<option value="1">请选择角色</option>
      	<c:forEach items="${requestScope.roles}" var="r">
      	<option value="${r.roleId}">${r.roleName}</option>
      	</c:forEach>
      </select>
      
      </label>
    </p>
    <p>
      <label class="left007-bg">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      <input name="Submit" type="submit" class="menu1" value="提交" />
      </label>
    </p>
  </form>
</div>
<div id="nutton"><img src="images/button.jpg" width="1002" height="17" /></div>
</body>
</html>
