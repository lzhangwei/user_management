<%--
  Created by IntelliJ IDEA.
  User: weizhang
  Date: 7/21/15
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="lib/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="lib/js/customer.js"></script>
</head>
<body>

<a href="/web/customer">添加</a>
<table border=1>
    <thead>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>教练</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td><c:out value="${customer.id}"/></td>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.coach.name}"/></td>
            <td>
                <button onclick="deleteCustomer(${customer.id})">删除</button>
            </td>
            <td>
                <button onclick="updateCustomer(${customer.id})">更新</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
