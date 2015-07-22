<%--
  Created by IntelliJ IDEA.
  User: weizhang
  Date: 7/21/15
  Time: 5:00 PM
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

<form method="POST" action="/web/customers/${customer.id}" >
  姓名 : <input
        type="text" value="${customer.name}" name="name" /> <br/>
  教练 :
  <select name="coachId">
    <c:forEach items="${coaches}" var="coach">
      <option value="${coach.id}" selected>${coach.name}</option>
    </c:forEach>
  </select><br/>
  <input type="text" value="${customer.id}" name="id" hidden="hidden"/>
  <input type="submit" value="提交"/>
</form>

</body>
</html>
