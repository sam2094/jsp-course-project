<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="studentTable">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Birth Date</th>
        <th>University</th>
    </tr>
        <c:forEach items="${scheduleList}" var="sl">
    <tr onclick="selectedSchedule(${sl.id},${sl.student.name},${sl.student.surname},${sl.student.email},
            ${sl.student.birthdate},${sl.university.id})">
        <%--при клике вызываем функцию в js и отправляем нужные данные (на данный  момент параметры здесь и в файле main.js отличаются)--%>
        <td>${sl.student.name}</td>
        <td>${sl.student.surname}</td>
        <td>${sl.student.email}</td>
        <td>${sl.student.birthdate}</td>
        <td>${sl.university.name}</td>
    </tr>
    </c:forEach>
</table>
