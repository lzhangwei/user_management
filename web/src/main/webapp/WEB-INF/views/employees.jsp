<%--
  Created by IntelliJ IDEA.
  User: weizhang
  Date: 7/21/15
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="lib/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="lib/js/employee.js"></script>
</head>
<body>

<a href="/web/employee">添加</a>
<table border=1>
    <thead>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>ROLE</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td><c:out value="${employee.id}"/></td>
            <td><c:out value="${employee.name}"/></td>
            <td><c:out value="${employee.role}"/></td>
            <td>
                <button onclick="deleteEmployee(${employee.id})">删除</button>
            </td>
            <td>
                <button onclick="updateEmployee(${employee.id})">更新</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
