<%@ page import="com.servletdemo.dto.Doctor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctor view</title>
</head>
<body>
<h2><b>Doctors Details</b></h2>

<% String message = (String)request.getAttribute("message");
    if(message != null && !message.isEmpty ()){
%>
<p><%= message%></p>
<%}%>

<table border="1">
    <tr>
        <th>Doctor Name</th>
        <th>Specialization</th>
        <th>Mobile</th>
        <th>Email</th>
    </tr>
<%
    List<Doctor> doctors = (List<Doctor>) request.getAttribute("doctors");

    if(doctors != null && !doctors.isEmpty()){


        for(Doctor doctor: doctors){

%>
        <tr>
            <td><%= doctor.getName()%></td>
            <td><%= doctor.getSpecialization()%></td>
            <td><%= doctor.getMobile()%></td>
            <td><%= doctor.getEmail()%></td>
        </tr>
    <% }
    }
    %>
</table>

<br/>

<ul>
    <li><a href="/ServletProject_war/">Home</a></li>
    <li><a href="/ServletProject_war/patientLogin">Patient Login</a></li>
    <li><a href="/ServletProject_war/patientServlet">Register Patient</a></li>
    <li><a href="/ServletProject_war/doctorServlet">Register Doctor</a></li>
</ul>

</body>
</html>
