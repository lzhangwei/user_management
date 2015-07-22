<%--
  Created by IntelliJ IDEA.
  User: weizhang
  Date: 7/21/15
  Time: 4:30 PM
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

<form method="POST" action="/web/employees/${employee.id}">
    姓名 : <input
        type="text" value="${employee.name}" name="name"/> <br/>
    教练 :
    <select name="role">
        <option value="coach" selected>coach</option>
        <option value="hr" selected>HR</option>
        <option value="ops" selected>Ops</option>
    </select><br/>
    <input type="text" value="${employee.id}" name="id" hidden="hidden"/>
    <input type="submit" value="提交"/>
</form>

</body>
</html>
