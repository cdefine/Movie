<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<s:head/>
  </head>
  <body bgcolor="#F0FFF0">
<s:actionerror/>
<div>
<center>
    <s:form action="checklogin" method ="post" style="margin-top:100px;">
      <s:textfield name="username" label="账号"/>
      <s:password name="pass" label="密码"/> 
      <s:radio name="power" list="%{#{'0':'普通用户','1':'管理员'}}" value="0" label="用户"/>               
      
      <s:submit value="登录"  />
</s:form> 
<a href="regist.jsp">注册</a>
</center>
</div>
  </body>
</html>
