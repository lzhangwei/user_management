<%--
  Created by IntelliJ IDEA.
  User: weizhang
  Date: 7/8/15
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<a href="/web/logout">退出登录</a>

<form method="POST" action="/web/users" id="addUser">
    姓名 : <input
        type="text" value="${user.name}" name="name" id="userName"/> <br/>
    性别 : <input
        type="text" value="${user.gender}" name="gender" id="userGender"/> <br/>
    邮箱 : <input
        type="text" value="${user.email}" name="email" id="userEmail"/> <br/>
    年龄 : <input type="text" value="${user.age}" name="age" id="userAge"/> <br/>
    密码 : <input type="text" value="${user.password}" name="password" id="userPassword"/> <br/>
    <input type="text" id="userId" value="${user.id}" name="id" hidden="hidden"/>
    <input type="submit" value="提交"/>
</form>

</body>
</html>
