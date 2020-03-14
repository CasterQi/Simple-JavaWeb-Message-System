
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<html>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
<link rel="stylesheet" href="../assets/css/amazeui.min.css"/>


<head>
  <title>Title</title>
  <script src="../assets/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<div style="text-align: center">
<h1>iPLUS7's PRIVATE LETTER SYSTEM</h1>
<c:choose>
  <c:when test="${ empty sessionScope.sessionUser}">您还没有登录，<a href="<c:url value='/index/login.jsp'/> ">点击这里跳转到登录页面.</a> </c:when>
  <c:otherwise>你好，用户${sessionScope.sessionUser.username}
<%--    <form action="/servlet/messageServlet" method="get">--%>
<%--      <input type="submit" >--%>
<%--    </form>--%>
    <br>
    <br>
    <button
            type="button"
            class="am-btn am-btn-danger"
            data-am-modal="{target: '#my-popup'}">
      写消息
    </button>
    <br>
    <br>
</div>
<iframe height="80%" width="100%" src="/servlet/messageServlet?user=${sessionScope.sessionUser.username}&isQuery=true"></iframe>


    <div class="am-popup" id="my-popup">
      <div class="am-popup-inner">
        <div class="am-popup-hd">
          <h4 class="am-popup-title">iPLUS7's PRIVATE LETTER SYSTEM</h4>
          <span data-am-modal-close
                class="am-close">&times;</span>
        </div>
        <div class="am-popup-bd">
          <form action="/servlet/messageServlet?user=${sessionScope.sessionUser.username}&isQuery=false" method="post"  class="am-form" data-am-validator>
            <fieldset>
              <legend>发送消息</legend>

              <div class="am-form-group">
                <label for="doc-vld-ta-2">消息内容：</label>
                <textarea name="note" id="doc-vld-ta-2" minlength="3" maxlength="100" required></textarea>
              </div>
              <div class="am-form-group">
                <label for="doc-vld-email-2">接收者</label>
                <input name="receiverName" type="text" id="doc-vld-email-2" placeholder="*" required/>
              </div>


              <button class="am-btn am-btn-secondary" type="submit">提交</button>
            </fieldset>
          </form>
        </div>
      </div>
    </div>
  </c:otherwise>
</c:choose>
</body>

<script src="../assets/js/amazeui.min.js"></script>
<script src="../assets/js/amazeui.widgets.helper.min.js"></script>
</html>
