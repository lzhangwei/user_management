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

    <script type="text/javascript" src="lib/js/add_course.js"></script>
    <script type="text/javascript" src="lib/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="lib/js/jquery-ui.min.js"></script>
    <style>
        .datepicker {

        }
    </style>

    <script type="text/javascript">
        $(function () {
            $(".datepicker").datepicker({});
        });
    </script>
</head>

<body>

<h2>添加私教课程</h2>

<form name="addCourse" method="POST" action="/web/courses">
    顾客 :
    <select id="customer" name="customerId" onchange="getCoach()">
        <c:forEach items="${customers}" var="customer">
            <option value="${customer.id}" coachName="${customer.coach.name}" coachId="${customer.coach.id}"
                    selected>${customer.name}</option>
        </c:forEach>
    </select><br/>
    <%--教练 :--%>
    <%--<select name="coachId">--%>
    <%--<c:forEach items="${coaches}" var="coach">--%>
    <%--<c:set value="${coach.customers}" target="${customers}"/>--%>
    <%--<option value="${coach.id}" selected>${coach.name}</option>--%>
    <%--</c:forEach>--%>
    <%--</select><br/>--%>
    教练 :
    <input type="text" id="coachName" name="coach" readonly="readonly" value="${coach.name}"/> <br/>
    <input type="text" id="coachId" value="${coach.id}" name="coachId" hidden="hidden"/>
    时间 :
    <input type="text" name="time" class="datepicker"/> <br/>

    <%--课程 :--%>
    <%--<select name="courseId">--%>
    <%--<c:forEach items="${courses}" var="course">--%>
    <%--<option value="${course.id}" selected>${course.name}</option>--%>
    <%--</c:forEach>--%>
    <%--</select><br/>--%>
    <input type="submit" value="添加"/>
</form>

<h2>添加公共课程</h2>

<form name="addPublicCourse" method="POST" action="/web/courses/public">
    课程 :
    <select name="courseId" id="publicCourse" onchange="getPublicCoach()">
        <c:forEach items="${courses}" var="course">
            <option value="${course.id}" coachName="${course.coach.name}" coachId="${course.coach.id}"
                    selected>${course.name}</option>
        </c:forEach>
    </select><br/>

    教练 :
    <input type="text" id="publicCoachName" name="coach" readonly="readonly" value="${coach.name}"/> <br/>
    <input type="text" id="publicCoachId" value="${coach.id}" name="coachId" hidden="hidden"/>
    <%--<select name="coachId">--%>
    <%--<c:forEach items="${coaches}" var="coach">--%>
    <%--<option value="${coach.id}" selected>${coach.name}</option>--%>
    <%--</c:forEach>--%>
    <%--</select><br/>--%>
    时间 :
    <input type="text" name="time" class="datepicker"/> <br/>
    <input type="submit" value="添加"/>
</form>

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
