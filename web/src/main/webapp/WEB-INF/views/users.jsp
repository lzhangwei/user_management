<%--
  Created by IntelliJ IDEA.
  User: weizhang
  Date: 7/7/15
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="lib/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="lib/js/users.js"></script>
</head>
<body>
<a href="/web/logout">退出登录</a>
<a href="/web/user">添加</a>
<table border=1>
    <thead>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>邮箱</th>
        <th>年龄</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <%--<td><c:out value="${user.gender}"/></td>--%>
            <%--<td><c:out value="${user.email}"/></td>--%>
            <%--<td><c:out value="${user.age}"/></td>--%>
            <td><button onclick="deleteUser(${user.id})">删除</button></td>
            <td><button onclick="updateUser(${user.id})">更新</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
