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
 #allcom::-webkit-scrollbar{width:0;}
 </style>
  <body bgcolor="#F0FFF0">
	<div style="width:900px;height:50px; margin-left: auto; margin-right: auto;margin-top:20px"class="head" >
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
	<div class="first"  style="width:900px;height:400px; overflow-y:scroll;margin-left: auto; margin-right: auto;margin-top:20px;background:#F5FFFA;display:none;" >
	<center>
	<table id="img" border="0" style="border-collapse:separate; border-spacing:10px 10px;text-align:center;">
    
    </table>
	</center>
	</div>
<div style="width:900px;height:300px;background:;margin-left: auto; margin-right: auto;margin-top:25px; " >
<div style="width:600px;height:300px;background:#AFEEEE ;float:left">
<div style="width:300px;height:300px;float:left;">
<center>
<img src="" id="cover" style="height:256px;width:180px; margin-top:20px"></img>
</center>
</div>
<div style="width:300px;height:300px;background:#E6E6FA ;float:left">
<table border="0" style="border-collapse:separate; border-spacing:20px 15px;margin-top:20px;">
<tr><td>片名：<s:property value="movieInfo.name"/></td></tr>
<tr><td>导演：<a href="###" onclick="return false" class="key"><s:property value="movieInfo.director"/></a></td></tr>
<tr><td>主演：<a href="###" onclick="return false" class="key"><s:property value="movieInfo.actor"/></a></td></tr>
<tr><td>类型：<s:property value="movieInfo.type1"/>/<s:property value="movieInfo.type2"/>/<s:property value="movieInfo.type3"/></td></tr>
<tr><td>语言：<s:property value="movieInfo.language"/></td></tr>
<tr><td>日期：<s:property value="movieInfo.date"/>年</td></tr>
</table>
</div>

</div>
<div style="width:300px;height:300px;background:#C1FFC1 ;float:left">
<div style="width:300px;height:50px;background:#C1FFC1;">
<div style="width:100px;height:30px;margin-top:20px;margin-left:20px;float:left">评分:<span id="total"></span>分</div>
<div id="dis"  style="background#C1FFC1:;margin-top:20px;float:left"></div>
</div>
<div style="width:300px;height:250px;background:#C1FFC1 ;float:left">
<table border="0" style="border-collapse:separate; border-spacing:20px 15px;margin-top:20px;">
<tr><td>5星：<span id="s5"></span>%</td></tr>
<tr><td>4星：<span id="s4"></span>%</td></tr>
<tr><td>3星：<span id="s3"></span>%</td></tr>
<tr><td>2星：<span id="s2"></span>%</td></tr>
<tr><td>1星：<span id="s1"></span>%</td></tr>
</table>
</div>
</div>
</div>
<div  style="width:900px;height:300px;background:#FFF0F5;margin-left: auto; margin-right: auto; " >
<s:property value="movieInfo.name"/>的简介......<div  style="width:900px;height:100px;background:#FFF0F5;margin-left: auto; margin-right: auto;font-size:13px;">
<div style="margin-top:10px;margin-left:20px;"><s:property value="movieInfo.profile"/></div>
</div>
<div style="width:900px;height:40px;margin-left: auto; margin-right: auto;">
<div style="width:50px;height:20px;margin-left:160px;float:left">评价:</div>
<div id="com"  style="float:left"></div><span id="point"></span>
</div>
<div style="width:900px;height:100px;margin-left: auto; margin-right: auto;flaot:right;">
<s:form>
<s:textarea id="contend" style="width:600px;height:100px;resize:none;margin-left:150px;">
</s:textarea>
<s:submit id="comment" value="评论" onclick = "return false" style="margin-left:700px"></s:submit>
</s:form>
</div>
</div>
<div id="allcom" style="width:900px;height:200px; overflow-y:scroll;margin-left: auto; margin-right: auto;font-size:12px;background:#E6E6FA" >
<ul></ul>
</div>
<div style="width:900px;height:100px;"></div>

<script src="jquery-3.3.1/jquery-3.3.1.js"></script>
<script src="raty/lib/jquery.raty.js"></script>	
<script>
var a = "image/"+$.trim("${movieInfo.name}")+".jpg";
$("#cover").attr("src",a);
$('#com').raty({
        path: 'raty/demo/img',
        size: 24,
        starHalf: 'star-half-big.png',
        starOff: 'star-off-big.png',
        starOn: 'star-on-big.png',
        targetKeep: true,
        precision: true,
        click: function(score, evt) {
        	score=score*2;
          $("#point").text(score.toFixed(1)+"分");
          $('#com').attr("datascore",score.toFixed(1));
        }
    });

    
$("#comment").click(function(){
var time = new Date();   
var m = time.getMonth() + 1;     
var pid ='<%= session.getAttribute("username")%>';
var	mid = '<s:property value="movieInfo.id"/>';
var	comment = $("#contend").val();
var rtime = time.getFullYear() + "-" + m + "-"     
+ time.getDate() + " " + time.getHours() + ":"     
+ time.getMinutes();
var point = $('#com').attr("datascore");
$.ajax({
        type:"post",
        url:"addComment.action",
        data: {"pid":pid,"mid":mid,"comment":$.trim(comment),"rtime":rtime,"point":point},
        dataType: "json",
        success:function(r) {
        if(r=="true")
        alert("评论成功");
        else
         alert("评论失败");
        loadComt();
        },
        error:function(e) {  
        alert("评论失败")
        }
      });
  	
  	
});

function loadComt(){
var	mid = '<s:property value="movieInfo.id"/>';
	$.ajax({
        type:"post",
        url:"loadComment.action",
        data: {"mid":mid,},
        dataType: "json",
        success:function(r) {
     	count(r); 	
     	 if(r.length) {
     		$("#allcom li").remove();    		
			for(var i=0;i<r.length;i++){	
		$("#allcom ul").append("<li style='width:600px;margin-left:80px;list-style:none;display:inline-block;'>"+$.trim(r[i][0])+" 评分："+r[i][3]+" 时间："+r[i][1]+"</li>");					
		$("#allcom ul ").append("<li style='width:600px;margin-left:80px;list-style:none;display:inline-block;'>"+"\n"+r[i][2]+"</li>");
		$("#allcom ul").append("<li style='width:600px;margin-left:80px;list-style:none;display:inline-block;'>_____________________________________________________________"+
				"______________________________________________________________</li>");
		$("#allcom ul").append("<li style='width:600px;height:10px;list-style:none;display:inline-block;'></li>");
	
			}
			}
        },
        error:function(e) {  

        }
      });

	
}
function count(r){
var o=0;
var t=0;
var th=0;
var f=0;
var fv=0;
var total=0;

for(var i=0;i<r.length;i++){
var n =r[i][3];
total=total+parseFloat(n);
if(n<2){
	o=o+1;
}else if(n<4){
	t=t+1;
}else if(n<6){
	th=th+1;
}
else if(n<8){
	f=f+1;
}else{
	fv=fv+1;
}

}
o=o/r.length*100;
t=t/r.length*100;
th=th/r.length*100;
f=f/r.length*100;
fv=fv/r.length*100;
total=total/r.length;
$("#s1").text(o.toFixed(2));
$("#s2").text(t.toFixed(2));
$("#s3").text(th.toFixed(2));
$("#s4").text(f.toFixed(2));
$("#s5").text(fv.toFixed(2));
$("#s5").text(fv.toFixed(2));
$("#total").text(total.toFixed(2));
$('#dis').raty({
        path: 'raty/demo/img',
        size: 24,
        starHalf: 'star-half-big.png',
        starOff: 'star-off-big.png',
        starOn: 'star-on-big.png',
        targetKeep: true,
        precision: true,
        score:total/2,
        readOnly: true, 

    });
}
loadComt();
$("#type").on("click", ".s", function(e) {
//超链
	$("#img tr").remove();
	$(".first").nextAll().remove();
 	$(".first").attr("style","width:900px;height:400px; overflow-y:scroll;margin-left: auto; margin-right: auto;margin-top:20px;background:#F5FFFA;");
	  	  $.ajax({
        type:"post",
        url:"searchByType.action",
        data: {"type":$(this).text()}, 
        dataType: "json",
        success:function(list) {    
		console.log(list);
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
$(".key").on("click", function(e) {
	//console.log();
 	//window.location = "searchBykey.action?key="+$(this).text();	
 	//$("#img tr").remove();
 	//导演演员
	$(".first").nextAll().remove();
 	$(".first").attr("style","width:900px;height:400px; overflow-y:scroll;margin-left: auto; margin-right: auto;margin-top:20px;background:#F5FFFA;");
 $("#img tr").remove();
		$(".first").nextAll().remove();
 	$(".first").attr("style","width:900px;height:400px; overflow-y:scroll;margin-left: auto; margin-right: auto;margin-top:20px;background:#F5FFFA;");
	  	  $.ajax({
        type:"post",
        url:"searchBykey.action",
        data: {"key":$(this).text()}, 
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
$("#ser").on("click", function(e) {
//搜索
	$("#img tr").remove();
		$(".first").nextAll().remove();
 	$(".first").attr("style","width:900px;height:400px; overflow-y:scroll;margin-left: auto; margin-right: auto;margin-top:20px;background:#F5FFFA;");
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
$("#img").on("click", ".j", function(e) {
 	window.location = "Disdetail.action?id="+$(this).attr("id");	
})
</script>
  </body>
</html>
