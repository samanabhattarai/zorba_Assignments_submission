<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>form</title>

</head>
<body>
<h4><b>Doctor Registration</b></h4>

<% String status = (String)request.getAttribute("status");
  if(status != null && status.equals("success")){
%>
  <p>Doctor registered successfully</p>
<%}%>

<form action ="/ServletProject_war/doctorServlet" method ="post">

  <label for ="name">name</label>
  <input type ="text" id ="name" name ="name"><br><br>
  <label for ="specialization">specialization</label>
  <input type ="text" id ="specialization" name ="specialization"><br><br>
  <label for ="mobile">mobile</label>
  <input type ="text" id ="mobile" name ="mobile"><br><br>
  <label for ="email">email</label>
  <input type ="text" id ="email" name ="email"><br><br>

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
