package com.servletdemo.servlethandler;

import com.servletdemo.dao.AppointmentsDao;
import com.servletdemo.dao.DoctorDao;
import com.servletdemo.dao.PatientDao;
import com.servletdemo.dto.Appointment;
import com.servletdemo.dto.Doctor;
import com.servletdemo.dto.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/cancelAppointment")
public class CancelAppointment extends HttpServlet {

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("appointmentId"));
        Appointment appointment = AppointmentsDao.getAppointmentById(id);
        Patient patient = appointment.getPatient();
        AppointmentsDao.deleteAppointment(id);

        List<Appointment> appointments = AppointmentsDao.getAppointmentsByPatientId(patient.getPatientId());
        request.setAttribute ("message", "Appointment cancelled successfully!");
        request.setAttribute ("patient", patient);
        request.setAttribute ("appointments", appointments);
        getServletContext().getRequestDispatcher ("/listPatientAppointments.jsp").forward (request, response);

    }

}
