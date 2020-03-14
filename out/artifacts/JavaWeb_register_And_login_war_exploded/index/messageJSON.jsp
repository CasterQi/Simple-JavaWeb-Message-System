<%--
  Created by IntelliJ IDEA.
  User: tassdar
  Date: 2020/3/13
  Time: 2:23 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>

<%
//    // 设置返回json数据并指定字符集
//    response.setContentType("application/json;charset=utf-8;");
//// 设置返回数据
//    JSONObject jo = new JSONObject();
//    jo.put("name", "Marydon");
//// 返回数据
//    response.getWriter().print(jo);

// 设置返回字符集
    response.setContentType("charset=utf-8");
    String result = "{\"name\":\"Marydon\"}";
// 返回数据
    response.getWriter().print(result);



%>
