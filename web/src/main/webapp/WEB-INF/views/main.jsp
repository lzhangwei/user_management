<%--
  Created by IntelliJ IDEA.
  User: weizhang
  Date: 7/21/15
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title></title>
</head>
<body>
<a href="/web/employees">雇员管理</a><br/>
<a href="/web/customers">顾客管理</a><br/>
<a href="/web/courses">课程管理</a> <br/>

<h2>课程安排</h2>
<table border=1>
  <thead>
  <tr>
    <th>日期</th>
    <th>课程</th>
    <th>教练</th>
    <th>顾客</th>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${arrangements}" var="arrangement">
    <tr>
      <td><c:out value="${arrangement.date}"/></td>
      <td><c:out value="${arrangement.course.name}"/></td>
      <td><c:out value="${arrangement.course.coach.name}"/></td>
      <td><c:out value="${arrangement.customer.name}"/></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
