package com.servletdemo.servlethandler;


import com.servletdemo.dao.DoctorDao;
import com.servletdemo.dao.PatientDao;
import com.servletdemo.dto.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patientLogin")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Username: " + userName + " Password: " + password);
        Patient patient = PatientDao.verifyLogin (userName, password);
        if(patient != null  && patient.getUserName ().equals (userName) && patient.getPassword ().equals (password)) {
            System.out.println ("Login Successful for user " + userName);
            request.setAttribute ("doctors", DoctorDao.getAllDoctors ());
            request.setAttribute ("patient", patient);
            getServletContext().getRequestDispatcher("/appointmentBook.jsp").forward (request, response);
            return;
        }

        // failed login go back to login page
        response.sendRedirect("login.jsp?message=Invalid username or password!!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }


}
