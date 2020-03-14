

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>注册</title>

  <script>

    function change(){
      let el = document.getElementById("vCode");
      el.src = "<c:url value='/verifyCode' />?xxx=" + new Date().getTime();
    }
  </script>

</head>
<body>
<h1>注册</h1>
<p style="color:red;font-weight: 900">${msg}</p>
<form action="<c:url value="/register"/>" method="post">
  <label>用户名：</label> <input type="text" name="username" value="${user.username}">${errors.username} <br/>
  <label>密&nbsp;&nbsp;码：</label>
  <input type="text" name="password" value="${user.password}">${errors.password} <br/>
  <label>验证码：</label>
  <input type="text" name="verifyCode" value="${user.verifyCode}"> ${errors.verifyCode}
  <img id="vCode" src="<c:url value="/verifyCode"/>">
  <a href="javaScript:;" onclick="change()">点击更换</a><br/>
  <button type="submit">提交</button>
</form>
</body>
</html>
