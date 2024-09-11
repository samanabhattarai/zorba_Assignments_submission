<%@ page import="java.util.List" %>
<%@ page import="com.servletdemo.dto.Appointment" %>
<%@ page import="com.servletdemo.dto.Doctor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>List Patient Appointments</title>
</head>
<body>
<h2><b>Appointments for patient ${patient.patientName}</b></h2>

<% String message = (String)request.getAttribute("message");
    if(message != null && !message.isEmpty ()){
%>
<p><%= message%></p>
<%}%>

<table border="1">
    <tr>
        <th>Booking Date</th>
        <th>Doctor Name</th>
        <th>Speciality</th>
        <th>Action</th>
    </tr>
<%
    List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");

    if(appointments != null && !appointments.isEmpty()){

        for(Appointment appointment: appointments){
            Doctor doctor = appointment.getDoctor ();
%>
        <tr>
            <td><%= appointment.getDate()%></td>
            <td><%= doctor.getName()%></td>
            <td><%= doctor.getSpecialization()%></td>
            <td>
                <span><a href="/ServletProject_war/editAppointment?appointmentId=<%= appointment.getId()%>">Edit</a>&nbsp;</span>
                <span><a href="/ServletProject_war/cancelAppointment?appointmentId=<%= appointment.getId()%>">Cancel</a>&nbsp;</span>
            </td>
        </tr>
    <% }
    }
    %>
</table>

<br/>

<ul>
    <li><a href="/ServletProject_war/">Home</a></li>
    <li><a href="/ServletProject_war/patientServlet">Register Patient</a></li>
    <li><a href="/ServletProject_war/doctorServlet">Register Doctor</a></li>
</ul>

</body>
</html>
