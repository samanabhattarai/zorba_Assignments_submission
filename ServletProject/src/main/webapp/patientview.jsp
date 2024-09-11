<%@ page import="com.servletdemo.dto.Patient" %>
<%@ page import="java.util.List" %>
<%@ page import="com.servletdemo.dto.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient view</title>
</head>
<body>
<h2><b>Patients Details</b></h2>

<% String message = (String)request.getAttribute("message");
    if(message != null && !message.isEmpty ()){
%>
<p><%= message%></p>
<%}%>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Mobile</th>
        <th>Email</th>
        <th>Username</th>
        <th>Password</th>
        <th>Appointments</th>
    </tr>

    <%

       List<Patient> patients = (List<Patient>) request.getAttribute("patients");

       if(patients != null && !patients.isEmpty()){

           for(Patient patient : patients){
    %>
               <tr>
                   <td><%= patient.getPatientName()%></td>
                   <td><%= patient.getPatientMobile()%></td>
                   <td><%= patient.getPatientEmail()%></td>
                   <td><%= patient.getUserName()%></td>
                   <td><%= patient.getPassword()%></td>
                   <td><a href="/ServletProject_war/appointments?patientId=<%= patient.getPatientId()%>">Appointments</a></td>
              </tr>
      <% }
         }%>

</table>

<br/>

<ul>
    <li><a href="/ServletProject_war/">Home</a></li>
    <li><a href="/ServletProject_war/patientLogin">Patient Login</a></li>
</ul>


</body>
</html>
