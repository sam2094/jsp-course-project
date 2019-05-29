<%@ page import="java.util.List" %>
<%@ page import="model.Student" %><%--
  Created by IntelliJ IDEA.
  User: Samir
  Date: 1/16/2019
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Student> studentList = (List<Student>) request.getAttribute("studentList");%>
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>

<head>
    <title>Student List</title>
</head>
<body>
<table id="studentTable">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Birth Date</th>
    </tr>
    <%for (Student student: studentList) {%>
        <tr>
        <td><%=student.getName()%></td>
        <td><%=student.getSurname()%></td>
        <td><%=student.getEmail()%></td>
        <td><%=student.getBirthdate()%></td>
    </tr><%}%>


<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>
