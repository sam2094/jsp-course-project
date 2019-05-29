<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Samir
  Date: 1/21/2019
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <c:forEach  items="${universityList}" var="ul">
            <option value="${ul.id}">${ul.name}</option>
        </c:forEach>
