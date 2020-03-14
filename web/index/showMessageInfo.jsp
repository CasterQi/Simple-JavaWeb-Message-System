<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="../assets/css/amazeui.min.css"/>
<head>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <title>Insert title here</title>
</head>
<body>
<h1>私信信息</h1>
<% //List<Message> messageList=(ArrayList<Message>)request.getAttribute("message");
    //Message message = (Message) request.getAttribute("message");
    int i=0;
%>
<table class="am-table am-table-bordered am-table-radius am-table-striped">
    <c1:if test="${message.size()==0}">
        <c1:out value="没有查询到你的相关留言"></c1:out>
        <br>

    </c1:if>
    <c1:if test="${message.size()!=0}">
        <tr>
            <td>消息内容</td>
            <td>发送者</td>
            <td>接收者</td>
            <td>发送日期</td>
            <td>已读标记</td>

        </tr>
        <br>
    </c1:if>
<c1:forEach items="${message}" var="message" >
    <tr>
        <td>${message.getNote()}</td>
        <td>${message.getSenderName()}</td>
        <td>${message.getReceiverName()}</td>
        <td>${message.getPostTime()}</td>
        <td>${message.getReadSign()}</td>
<%--        <td>${message.iphome}</td>--%>
        <c1:set var="i" value="1"></c1:set>
    </tr>
</c1:forEach>

</table>
<%--id:<%=message.getNote() %>--%>
<%--username:<%=message.getSenderName() %>--%>
<%--password:<%=message.getReceiverName() %>--%>
<%--address:<%=message.getPostTime() %>--%>

<!--
也可以用el表达式，但是同样需要servlet先将值存放在request中，但是用el表达式的话需要在上面加上：
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
如下，获取id这样写就可以
<%--${message.getNote()}--%>
 -->
</body>
</html>