package com.servletdemo.dao;

import com.servletdemo.dbconnection.DBConnection;
import com.servletdemo.dto.Doctor;
import org.hibernate.Query;
import org.hibernate.Session;


import java.util.List;

public class DoctorDao {


    public static void saveDoctor(Doctor doctor){
        Session session = DBConnection.getSession();
        session.beginTransaction();
        session.save(doctor);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Doctor> getAllDoctors() {
        Session session = DBConnection.getSession();
        List<Doctor> doctors = session.createQuery("from Doctor d").list ();
        session.close();
        return doctors;
    }

    public static Doctor getDoctorById(int id){
        Session session =DBConnection.getSession();
        Query query = session.createQuery("from Doctor d where d.id = :id");
        query.setInteger("id", id);
        Doctor doctor = (Doctor) query.uniqueResult();
        session.close();
        return doctor;
    }
}