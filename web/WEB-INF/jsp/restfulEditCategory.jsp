<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2018/12/15
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>RESTFUL EDIT CATEGORY</title>
</head>
<body>
<div align="center">
    <form action="../category/${c.id}" method="post">
        <input type="hidden" name="_method" value="PUT">
        name: <input type="text" name="name" value="${c.name}"> <br>
        <input type="submit" value="update">
    </form>
</div>
</body>
</html>
