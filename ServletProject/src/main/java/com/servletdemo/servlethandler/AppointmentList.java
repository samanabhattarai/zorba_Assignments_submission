package com.servletdemo.servlethandler;

import com.servletdemo.dao.AppointmentsDao;
import com.servletdemo.dao.PatientDao;
import com.servletdemo.dto.Appointment;
import com.servletdemo.dto.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/appointments")
public class AppointmentList extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String patientId = request.getParameter ("patientId");
        if(patientId == null) {
            patientId = "1";
        }
        Patient patient = PatientDao.getPatientById (Integer.parseInt (patientId));
        List<Appointment> appointments = AppointmentsDao.getAppointmentsByPatientId (Integer.parseInt (patientId));
        request.setAttribute ("patient", patient);
        request.setAttribute ("appointments", appointments);
        request.getRequestDispatcher ("listPatientAppointments.jsp").forward (request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet (request, response);
    }
}