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
import java.sql.Date;
import java.util.List;

@WebServlet("/bookAppointment")
public class BookAppointmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int patientId = Integer.parseInt(request.getParameter("patientId"));
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        String appointmentDate = request.getParameter ("appointmentDate"); // mm/dd/yyyy format from page
        Date date = Date.valueOf (appointmentDate);
        System.out.println("patientId: " + patientId + " doctorId: " + doctorId + " appointmentDate: " + appointmentDate);

        Appointment appointment = AppointmentsDao.saveAppointments(patientId, doctorId, date);

        Patient patient = PatientDao.getPatientById(patientId);
        Doctor doctor = DoctorDao.getDoctorById (doctorId);
        List<Appointment> appointments = AppointmentsDao.getAppointmentsByPatientId(patientId);
        request.setAttribute ("message", "Appointment scheduled with doctor "+doctor.getName ()+" successfully!");
        request.setAttribute ("patient", patient);
        request.setAttribute ("appointments", appointments);
        getServletContext().getRequestDispatcher ("/listPatientAppointments.jsp").forward (request, response);
    }

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute ("doctors", DoctorDao.getAllDoctors());
        getServletContext().getRequestDispatcher ("/appointmentBook.jsp").forward (req, resp);
    }
}
