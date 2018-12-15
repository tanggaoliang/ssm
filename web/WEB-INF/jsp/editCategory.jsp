<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2018/12/13
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<div style="width: 300px ;height: 300px;margin: 0 auto;background-color: aqua"></div>--%>
<div align="center">
    <form action="updateCategory" method="post">
        分类名称: <input type="text" value="${c.name}" name="name"> <br>
        <input type="hidden" value="${c.id}" name="id">
        <input type="submit" value="提交">
    </form>
</div>

</body>
</html>
