package com.servletdemo.servlethandler;

import com.servletdemo.dao.PatientDao;
import com.servletdemo.dto.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patientServlet")
public class PatientServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String patientName = request.getParameter ("name");
        String patientMobile =  request.getParameter("mobile");
        String patientEmail = request.getParameter("email");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        Patient patient = new Patient ();
        patient.setPatientName (patientName);
        patient.setPatientMobile (patientMobile);
        patient.setPatientEmail (patientEmail);
        patient.setUserName (userName);
        patient.setPassword (password);

        PatientDao.savePatient (patient);
        System.out.println ("Patient saved to database: " + patient);

        request.setAttribute ("message", "Patient Saved successfully!");
        request.setAttribute ("patients", PatientDao.getAllPatients());
        getServletContext().getRequestDispatcher ("/patientview.jsp").forward (request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("patientRegistration.jsp");

    }
}
