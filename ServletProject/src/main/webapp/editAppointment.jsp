<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Update Appointment</title>
    <h2><b>Update Appointment for ${patient.patientName}</b></h2>
    <form action="/ServletProject_war/editAppointment" method="post">
        <label for="doctor">Select Doctor:</label>
        <select name="doctorId" id="doctor">
            ${doctors}
        </select><br><br>

        <label for="appointmentDate">Select Date:</label>
        <input type="date" id="appointmentDate" name="appointmentDate" value="${appointment.date}"><br><br>

        <input type="hidden" id="appointmentId" name="appointmentId" value="${appointment.id}">

        <input type="submit" value="Update Appointment">
    </form>
</head>
<body>

</body>
</html>
