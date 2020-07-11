<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>分配人员</title>
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
        <p>您现在的位置 &gt;&gt; 分配人员</p>
        <h1>用户详细信息:</h1>
		<spf:form id="form0" name="form1" method="post" modelAttribute="update" action="updateUsers.do">
        <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
          <tr>
    
            
            <td class="tdcolor">用户名称</td>
            <td>
            <input name="employeeId" type="hidden" size="16"  value="${update.employeeId }"/>
            <input name="employeeName" type="text" size="16"  value="${update.employeeName }"/>
            
            <input name="password" type="hidden" size="16"  value="${update.password }"/>
            </td>         	
      
          </tr>
          <tr>
            <td width="15%" class="tdcolor">真实姓名</td>
            <td><input name="realName" type="text" size="16" value="${update.realName }"/></td>
          
          </tr>
          <tr>
            <td class="tdcolor">行业角色</td>
            <td><select name="role.roleId">
            			<option value="2">系统管理员</option>
                        <option value="3">主管</option>
                        <option value="4">员工</option>                    
            </select></td>
          </tr>
          <tr>
            <td class="tdcolor">性&nbsp;&nbsp;&nbsp; 别</td>
            <td><spf:radiobuttons path="sex"  items="${sexs}"/></td>
          </tr>
          <tr>
            <td class="tdcolor">入职时间</td>
            <td><input name="enrollDate" type="text" size="16" value="<fmt:formatDate value="${update.enrollDate }" pattern="yyyy-MM-dd"/>"/></td>
          </tr>
          <tr>
            <td class="tdcolor">职位信息</td>
            <td><input name="duty" type="text" size="16" value="${update.duty }"/></td>
          </tr>
          <tr>
            <td class="tdcolor">出生年月</td>
            
            <td><input name="birthday" type="text" size="16" value="<fmt:formatDate value="${update.birthday }" pattern="yyyy-MM-dd" />"/></td>
          </tr>
          <tr>
            <td class="tdcolor">学历信息</td>
            <td><spf:select path="edcucation">
     	<option/>请选择学历
     	<spf:options items="${edcucation}" />
     </spf:select></td>
          </tr>
          <tr>
            <td class="tdcolor">专业信息</td>
            <td><spf:select path="major">
     	<option/>请选择专业
     	<spf:options items="${major}" />
     	</spf:select></td>
          </tr>
          <tr>
            <td class="tdcolor">行业经验</td>
            <td><input name="experience" type="text" size="16" value="${update.experience }"/></td>
          </tr>
          <!-- <tr>
            <td class="tdcolor">上级主管</td>
            <td><label>
              <select name="select">
                <option value="主管一">主管一</option>
                <option value="主管二">主管二</option>
              </select>
            </label></td>
          </tr> -->
        </table>
        <p>&nbsp;</p>

          <p>
            <input name="Submit" type="reset" class="menu2" value="取消" />
            <label>
            <input name="Submit2" type="submit" class="menu1" value="提交" />
            </label>
          </p>
      </spf:form>
    </div>    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="../images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem --></body>
</html>
