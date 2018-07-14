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
   <style>
 .cover::-webkit-scrollbar{width:0px;}
 </style>
  <body bgcolor="#F0FFF0">
	<div style="width:900px;height:50px; margin-left: auto; margin-right: auto;margin-top:20px" >
	<center>
	<form action="" method=post >
	<a href="index.jsp">首页</a>
	<input type="text" id="key" style="width:500px ;text-align:center;margin-left:20px" placeholder="搜索电影&nbsp&nbsp&nbsp&nbsp电影名/导演/演员"/>
	<input type="button"style="margin-left:20px" value="搜索" id="ser">
	<br><table id="type">
	<tr>
	<td><a href="#" class="s" onclick="return false">剧情</a></td>
	<td><a href="#" class="s" onclick="return false">爱情</a></td>
	<td><a href="#" class="s" onclick="return false">喜剧</a></td>
	<td><a href="#" class="s" onclick="return false">犯罪</a></td>
	<td><a href="#" class="s" onclick="return false">动作</a></td>
	<td><a href="#" class="s" onclick="return false">科幻</a></td>
	<td><a href="#" class="s" onclick="return false">悬疑</a></td>
	<td><a href="#" class="s" onclick="return false">历史</a></td>
	<td><a href="#" class="s" onclick="return false">战争</a></td>
	<td><a href="#" class="s" onclick="return false">冒险</a></td>      
	</tr>
	</table >
	
	</form>
	</center>
	
	</div>
	<div class="cover"  style="width:900px;height:400px; overflow-y:scroll;margin-left: auto; margin-right: auto;margin-top:20px;background:#F5FFFA;" >
	<center>
	<table id="img" border="0" style="border-collapse:separate; border-spacing:10px 10px;text-align:center;">
    
    </table>
	</center>
	</div>
<script src="jquery-3.3.1/jquery-3.3.1.js"></script>	
<script>

function loadimg(){
  	  $.ajax({
        type:"post",
        url:"loadImg.action",
        data: {}, 
        dataType: "json",
        success:function(list) {    
		
		var n = parseInt(list.length/5)+1;
		var m = 0;
		for(var i=0;i<n;i++){
		$("#img").append("<tr id='t"+i+"'></tr>");
		for(var j=0;j<5;j++){
	
			$("#t"+i).append("<td><a href='#' onclick='return false' class='j' value='aa' id='"+list[m][0]+"' ><img src='image/"+$.trim(list[m][1])+".jpg' height='170' width='130'/></a></td>");
			$("#img").append("<tr id='h"+i+"'></tr>");
			$("#h"+i).append("<th>"+$.trim(list[m++][1])+"</th>");
		
		}
	}			
        },
        error:function(e) {
        }
        });
}
loadimg();
$("#img").on("click", ".j", function(e) {
 	window.location = "Disdetail.action?id="+$(this).attr("id");	
})
$("#type").on("click", ".s", function(e) {
//超链
	$("#img tr").remove();
	  	  $.ajax({
        type:"post",
        url:"searchByType.action",
        data: {"type":$(this).text()}, 
        dataType: "json",
        success:function(list) {    
		
		var n = parseInt(list.length/5)+1;
		var m = 0;
		for(var i=0;i<n;i++){
		$("#img").append("<tr id='t"+i+"'></tr>");
		for(var j=0;j<5;j++){
	
			$("#t"+i).append("<td><a href='#' onclick='return false' class='j' value='aa' id='"+list[m][0]+"' ><img src='image/"+$.trim(list[m][1])+".jpg' height='170' width='130'/></a></td>");
			$("#img").append("<tr id='h"+i+"'></tr>");
			$("#h"+i).append("<th>"+$.trim(list[m++][1])+"</th>");
		
		}
	}			
        },
        error:function(e) {
        }
        });
})
$("#ser").on("click", function(e) {
//搜索
	$("#img tr").remove();
	  	  $.ajax({
        type:"post",
        url:"searchBykey.action",
        data: {"key":$("#key").val()}, 
        dataType: "json",
        success:function(list) {    
        if(list.length<1) alert("未搜索到结果")
		var n = parseInt(list.length/5)+1;
		var m = 0;
		for(var i=0;i<n;i++){
		$("#img").append("<tr id='t"+i+"'></tr>");
		for(var j=0;j<5;j++){
	
			$("#t"+i).append("<td><a href='#' onclick='return false' class='j' value='aa' id='"+list[m][0]+"' ><img src='image/"+$.trim(list[m][1])+".jpg' height='170' width='130'/></a></td>");
			$("#img").append("<tr id='h"+i+"'></tr>");
			$("#h"+i).append("<th>"+$.trim(list[m++][1])+"</th>");
		
		}
	}			
        },
        error:function(e) {
        }
        });
})
</script>
  </body>
</html>