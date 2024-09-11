package com.servletdemo.servlethandler;

import com.servletdemo.dao.PatientDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.servletdemo.dto.Patient;


@WebServlet("/patientview")
public class PatientViewServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<Patient> patients = PatientDao.getAllPatients();
       request.setAttribute("patients",patients);
       request.getRequestDispatcher("patientview.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
