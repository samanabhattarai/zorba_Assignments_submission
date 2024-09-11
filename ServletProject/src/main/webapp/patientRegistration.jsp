<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4><b>Patient Registration</b></h4>

<form action ="/ServletProject_war/patientServlet" method ="post">
    <label for ="name">name</label>
    <input type ="text" id ="name" name ="name"><br><br>
    <label for ="mobile">mobile</label>
    <input type ="text" id ="mobile" name ="mobile"><br><br>
    <label for ="email">email</label>
    <input type ="text" id ="email" name ="email"><br><br>
    <label for ="userName">Username</label>
    <input type ="text" id ="userName" name ="userName"><br><br>
    <label for ="password">Password</label>
    <input type ="password" id ="password" name ="password"><br><br>
    <input type ="submit" value ="submit">
</form>

<br/>
<ul>
    <li><a href="/ServletProject_war/patientLogin">Patient Login</a></li>
    <li><a href="/ServletProject_war/patientServlet">Register Patient</a></li>
    <li><a href="/ServletProject_war/doctorServlet">Register Doctor</a></li>
</ul>


</body>
</html>
