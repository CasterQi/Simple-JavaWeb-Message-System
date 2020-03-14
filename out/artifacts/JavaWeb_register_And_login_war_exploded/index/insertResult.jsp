<%--
  Created by IntelliJ IDEA.
  User: tassdar
  Date: 2020/3/13
  Time: 10:57 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<span style="font-size:18px;">

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<script>
 //使用匿名函数方法
 function countDown(){

     var time = document.getElementById("Time");
     //alert(time.innerHTML);
     //获取到id为time标签中的内容，现进行判断
     if(time.innerHTML == 0){
         //等于0时清除计时
         //window.location.href="https://www.baidu.com" rel="external nofollow" ;
     }else{
         time.innerHTML = time.innerHTML-1;
     }
 }
 //1000毫秒调用一次
 window.setInterval("countDown()",1000);
</script>
<HEAD>
<meta http-equiv='refresh' content='3;url=../index/index.jsp'><!--content='页面停留时间(这里单位是秒);url=跳转至另一页面'  -->

<TITLE></TITLE></HEAD>
<BODY>
	<br>
	<div style="text-align: center">
		<h2>
            <c:if test="${result==1}" >
                <h1>发送成功!</h1>
                <c:out value="发送成功!"></c:out>
            </c:if>
            <c:if test="${result==0}" >
                <h1>发送失败!</h1>
                <c:out value="发送失败!"></c:out>
            </c:if>

			注意!!页面将在<span id='Time' style="display: inline;color: #0bb59b">3</span>秒后跳转回主页
		</h2>
	</div>
</BODY>
</HTML> </span>