<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>新建用户</title>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
</head>

<body><!-- #BeginLibraryItem "/Library/topbanner.lbi" -->
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<div id="logo"><img src="${pageContext.request.contextPath}/images/top.jpg" width="1002" height="258" /></div>
<!-- #EndLibraryItem --><table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="rightimg"><!-- #BeginLibraryItem "/Library/left3.lbi" -->
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<div id="left2">
       <p><a href="userSelect.do" target="_self" >用户管理</a></p>
      <p><a href="select.do" target="_self">员工管理</a></p>
      <p><a href="fuser.do" target="_self">分配人员</a></p>
      <p ><a href="loging.do" target="_self">退出系统</a></p>
</div><!-- #EndLibraryItem --><div id="right">
        <p>您现在的位置 &gt;&gt; 添加人员 &gt;&gt; 人员详细信息</p>
        <h1>人员详细信息:</h1>
	  
	  <spf:form id="form1" name="form1" modelAttribute="emp" method="post" action="userAdds.do">
          <p>用户名称：
            
            <input name="employeeName" type="text" size="16" />
          </p>
          <p>真实姓名：
            
            <input name="realName" type="text" size="16" />
          </p>
          <p>性&nbsp;&nbsp;&nbsp; 别：
          <spf:radiobuttons path="sex"  items="${sexs}"/>
           
          </p>
          <p>出生年月：
            <input name="birthday" type="text" size="16" />
          </p>
          <p>职位信息：
              <input name="duty" type="text" size="16" />
          </p>
          <p>入职时间：
            <input name="enrollDate" type="text" size="16" />
			</p>
          <p>学历信息：
            <spf:select path="edcucation">
     	<option/>请选择学历
     	<spf:options items="${edcucation}" />
     </spf:select>
            <span class="marginleft">专业信息：</span>
            <spf:select path="major">
     	<option/>请选择专业
     	<spf:options items="${major}" />
     	</spf:select>
          </p>
          <p>行业经验：
            <label>
            <textarea name="experience" cols="44"></textarea>
            </label>
          </p>
          <p>所属角色：
            <label>
            <select name="role.roleId">
              <option value="2">系统管理员</option>
              <option value="3">主管</option>
              <option value="4">员工</option>
            </select>
            </label>
          </p>
          <p>初始密码：
            <input name="password" type="password" size="16" maxlength="20" />
          </p>
          <p>确认密码：
            <input name="confirmPassword"  type="password" size="16" maxlength="20" />
          </p>
          <p>&nbsp; </p>
            <p>
              
              <input name="Submit" type="reset" class="menu2" value="重置" />
             
           &nbsp; 
              
              <input name="Submit2" type="submit" class="menu1" value="提交" />
           </p>
      </spf:form>
    </div>    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="../images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem --></body>
</html>
