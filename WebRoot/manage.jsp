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
     <s:form action="addMovie" method ="post" style="margin-top:100px;">
     	<s:textfield name="movie.name" label="电影名"/>
     	<s:textfield name="movie.director" label="导演"/>
     	<s:textfield name="movie.actor" label="主演"/>
     	<s:textfield name="movie.date" label="年份"/>
     	<s:select list="classes" listKey="id" listValue="name" name="movie.type1" headerKey="0" headerValue="--请选择--" label="类别1"/>
     	<s:select list="classes" listKey="id" listValue="name" name="movie.type2" headerKey="0" headerValue="--请选择--" label="类别2"/>
     	<s:select list="classes" listKey="id" listValue="name" name="movie.type3" headerKey="0" headerValue="--请选择--" label="类别3"/>     	
     	<s:textfield name="movie.language" label="语言"/>
		<s:textarea name="movie.profile" label="简介"/>	
      	<s:submit value="提交"  />
	</s:form>
	</center>
	</div>s
  </body>
</html>