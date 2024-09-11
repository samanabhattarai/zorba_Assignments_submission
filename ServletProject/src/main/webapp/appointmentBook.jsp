<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Patient Book Appointment</title>
</head>
<body>

<h2><b>Booking Appointment for ${patient.patientName}!</b></h2>

<form action="/ServletProject_war/bookAppointment" method="post">

    <label for="doctor">Select Doctor:</label>
    <select name="doctorId" id="doctor">
        <c:forEach var="doctor" items="${doctors}">
            <option value="${doctor.id}">${doctor.name} - ${doctor.specialization}</option>
        </c:forEach>
    </select><br><br>

    <label for="appointmentDate">Select Date:</label>
    <input type="date" id="appointmentDate" name="appointmentDate"><br><br>
    <input type="hidden" id="patientId" name="patientId" value="${patient.patientId}">

    <input type="submit" value="Book Appointment">
</form>


<ul>
    <li><a href="/ServletProject_war/">Home</a></li>
    <li><a href="/ServletProject_war/patientServlet">Register Patient</a></li>
    <li><a href="/ServletProject_war/doctorServlet">Register Doctor</a></li>
</ul>

</body>
</html>
