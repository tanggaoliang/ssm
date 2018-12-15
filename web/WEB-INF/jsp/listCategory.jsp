<%--
  Created by IntelliJ IDEA.
  User: Tanggl
  Date: 2018/12/11
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>LIST CATEGORY</title>
</head>
<body>
<div align="center">
    <table border="1" cellspacing="0">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${cs}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="editCategory?id=${c.id}">编辑</a></td>
                <td><a href="deleteCategory?id=${c.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <div align="center">
        <a href="?start=0">首页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末页</a>
    </div>
    <div style="margin: 50px auto ">
        <form action="addCategory" method="post">
            分类名称: <input type="text" name="name"> <br>
            <input type="submit" value="提交">
        </form>
    </div>


</div>
</body>
</html>
