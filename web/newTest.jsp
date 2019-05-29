<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
<head>
    <title>Test</title>
</head>
<body>
<div class="container">
    <h1>Add test</h1>
    <hr>
    <%--<form method="POST" enctype="multipart/form-data" action="cs?action=addTest">--%>
        <label for="testName"><b>Name</b></label>
        <input type="text" id="testName" placeholder="Name">
        <label for="testImage"><b>Image</b></label>
        <input type="file" id="testImage" name="testImage" placeholder="Image">
    <%--</form>--%>
    <br>
    <hr>
    <button id="addTest" class="registerbtn">Add Test</button>

</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/js/util.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>
