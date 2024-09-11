package com.servletdemo.servlethandler;

import com.servletdemo.dao.AppointmentsDao;
import com.servletdemo.dao.DoctorDao;
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

@WebServlet("/editAppointment")
public class EditAppointments extends HttpServlet {

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Appointment appointment = AppointmentsDao.getAppointmentById(Integer.parseInt(request.getParameter("appointmentId")));
        Patient patient = appointment.getPatient();
        Doctor doctor = appointment.getDoctor();
        List<Doctor>  doctors = DoctorDao.getAllDoctors();
        StringBuilder doctorList = new StringBuilder();
        for(Doctor d:doctors){
            String selected= "";
            if(d.getId() == doctor.getId ()){
                selected = "selected";
            }
            doctorList.append ("<option value='").append (d.getId ()).append ("' ").append (selected).append (">").append (d.getName ()).append (" - ").append (d.getSpecialization ()).append ("</option>");
        }
        request.setAttribute ("patient", patient);
        request.setAttribute ("doctors", doctorList);
        request.setAttribute ("appointment", appointment);
        getServletContext().getRequestDispatcher ("/editAppointment.jsp").forward(request, response);
    }


    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Appointment appointment = AppointmentsDao.getAppointmentById(Integer.parseInt(request.getParameter("appointmentId")));
        String doctorId = request.getParameter ("doctorId");
        String appointmentDate = request.getParameter ("appointmentDate");

        // Update db with new values
        Appointment updatedAppointment = AppointmentsDao.updateAppointment(appointment, Integer.parseInt(doctorId), Date.valueOf(appointmentDate));

        // return to list appointment page with new values
        Patient patient = updatedAppointment.getPatient ();
        Doctor doctor = updatedAppointment.getDoctor ();
        List<Appointment> appointments = AppointmentsDao.getAppointmentsByPatientId(patient.getPatientId());
        request.setAttribute ("message", "Appointment updated with doctor "+ doctor.getName ()+" successfully!");
        request.setAttribute ("patient", patient);
        request.setAttribute ("appointments", appointments);
        getServletContext().getRequestDispatcher ("/listPatientAppointments.jsp").forward (request, response);


    }


}
