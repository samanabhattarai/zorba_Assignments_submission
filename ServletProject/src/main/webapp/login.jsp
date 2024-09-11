<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Patient Login</title>
</head>
<body>
<h2>Login</h2>

<% String message = request.getParameter("message");
    if(message != null && !message.isEmpty ()){
%>
<p><%= message%></p>
<%}%>

<form  action ="/ServletProject_war/patientLogin" method ="post">
    <label for ="userName">UserName</label>
    <input type ="text" id= "userName" name= "username" /><br> <br>
    <label for="password">Password</label>
    <input type ="password" id ="password" name ="password" /><br>
    <input type ="submit" value ="submit"/>
</form>

<ul>
    <li><a href="/ServletProject_war/">Home</a></li>
    <li><a href="/ServletProject_war/patientServlet">Register Patient</a></li>
    <li><a href="/ServletProject_war/doctorServlet">Register Doctor</a></li>
</ul>

</body>
</html>
