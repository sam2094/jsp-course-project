<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Samir
  Date: 1/21/2019
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:out value="${universityList}"></c:out>--%>

<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
<head>
    <title>New Schedule</title>
</head>
<body>

<div class="container">
    <h1>Register</h1>
    <hr>
    <label for="name"><b>Name</b></label>
    <input type="text" id="name" placeholder="Name">
    <label for="surname"><b>Surname</b></label>
    <input type="text" id="surname" placeholder="Surname">
    <label for="email"><b>Email</b></label>
    <input type="text" id="email" placeholder="Email">
    <label for="date"><b>Date</b></label>
    <input type="date" id="date" placeholder="Date">
    <select id="university">
    </select>
    <br>
    <br>
    <input type="radio" placeholder="Male" value="male" name="gender"> Male
    <input type="radio" placeholder="Female" value="female" name="gender"> Female
    <hr>
    <button id="addSchedule" class="registerbtn">Register</button>
</div>
<button id="showSchedule">Show Schedule </button>
<button id="hideSchedule">Hide Schedule </button>
<div id="contentSchedule">

</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>
