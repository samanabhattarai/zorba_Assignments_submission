package com.servletdemo.servlethandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servletdemo.dao.DoctorDao;
import com.servletdemo.dto.Doctor;

import java.io.IOException;


@WebServlet("/doctorServlet")
public class DoctorServlet extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    String name =request.getParameter("name");
    String specialization =request.getParameter("specialization");
    String mobile =request.getParameter("mobile");
    String email =request.getParameter("email");

    Doctor doctor =new Doctor();

    doctor.setName(name);
    doctor.setSpecialization(specialization);
    doctor.setMobile(mobile);
    doctor.setEmail(email);
    DoctorDao.saveDoctor (doctor);
    System.out.println ("Doctor saved to database: " + doctor);
    request.setAttribute ("message", "Doctor Saved successfully!");
    request.setAttribute ("doctors", DoctorDao.getAllDoctors());
    getServletContext().getRequestDispatcher ("/doctorview.jsp").forward (request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.sendRedirect("doctorRegistration.jsp");
  }

}
