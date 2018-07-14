<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
    <s:form action="userregist" method ="post" style="margin-top:100px;">
      <s:textfield name="username" label="账号"/>
      <s:radio name="sex" list="%{#{'1':'男','0':'女'}}" value="1" label="性别"/>
      <s:password name="pass" label="密码"/>            
      <s:submit value="注册"/>
    </s:form>
    <a href="login.jsp">登录</a>
    </center>
    </div>
      
  </body>
</html>
