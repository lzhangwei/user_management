<%--
  Created by IntelliJ IDEA.
  User: weizhang
  Date: 7/19/15
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>

<head>
    <title></title>
    <link href="lib/css/jquery-ui.min.css" rel="stylesheet"/>

    <script type="text/javascript" src="lib/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="lib/js/jquery-ui.min.js"></script>
    <style>
        .datepicker {

        }
    </style>

    <script type="text/javascript">
        $(function () {
            $(".datepicker").datepicker();
        });
    </script>
</head>


<body>

<h2>添加私教课程</h2>

<form name="addCourse" method="POST" action="/web/courses">
    <input type="text" value="${coach.id}" name="coachId" hidden="hidden"/>
    教练 : <input
        type="text" name="coach" readonly="readonly" value="${coach.name}"/> <br/>
    时间 : <input
        type="text" name="time" class="datepicker"/> <br/>
    顾客 :
    <select name="customerId">
        <c:forEach items="${customers}" var="customer">
            <option value="${customer.id}" selected>${customer.name}</option>
        </c:forEach>
    </select><br/>
    课程 :
    <select name="courseId">
        <c:forEach items="${courses}" var="course">
            <option value="${course.id}" selected>${course.name}</option>
        </c:forEach>
    </select><br/>
    <input type="submit" value="添加"/>
</form>

</body>
</html>
