<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="css/style.css">
<head>
    <title>Course</title>
</head>
<body>
<%--<form action="cs?action=getStudentList" method="post">--%>
    <div class="container">
        <h1>Register</h1>
        <hr>
        <label for="name"><b>Name</b></label>
        <input type="text" id="name" placeholder="Name" name="name">
        <label for="surname"><b>Surname</b></label>
        <input type="text" id="surname" placeholder="Surname" name="surname">
        <%--<label for="password"><b>Password</b></label>--%>
        <%--<input type="password" id="password" placeholder="Password" name="password">--%>
        <label for="email"><b>Email</b></label>
        <input type="text" id="email" placeholder="Email" name="email">
        <label for="date"><b>Date</b></label>
        <input type="date" id="date" placeholder="Date" name="date" >
        <%--<select multiple name="students" id="">--%>
            <%--<option value="Tural">Tural</option>--%>
            <%--<option value="Samir">Samir</option>--%>
            <%--<option value="Ruslan">Ruslan</option>--%>
        <%--</select>--%>
        <br>
        <br>
        <input type="radio" placeholder="Male" value="male" name="gender"> Male
        <input type="radio" placeholder="Female" value="female" name="gender"> Female
        <hr>
        <button id="addStudent" class="registerbtn">Register</button>
    </div>
<%--</form>--%>
<button id="buttonContent">Show Student </button>
<button id="hideStudent">Hide Student </button>
<a id="goToSchedule" href="newSchedule.jsp">New Schedule</a>


<div id="content">

</div>


<script src="js/jquery-3.3.1.js"></script>
<%--<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>--%>
<script src="js/main.js"></script>
</body>
</html>
