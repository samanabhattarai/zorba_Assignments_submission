package com.servletdemo.dao;

import com.servletdemo.dbconnection.DBConnection;
import com.servletdemo.dto.Patient;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class PatientDao {

    public static void savePatient(Patient patient){
       Session session =  DBConnection.getSession();
       session.beginTransaction();
       session.persist(patient);
       session.getTransaction().commit();
       session.close();
    }

    public static List<Patient> getAllPatients() {
        Session session =  DBConnection.getSession();
        List<Patient> patients = session.createQuery("select p from Patient p").list();
        session.close();
        return patients;
    }

    public static Patient getPatientById(int patientId) {
        Session session =  DBConnection.getSession();
        Query query = session.createQuery ("from Patient p where p.patientId= :patientId");
        query.setInteger ("patientId", patientId);
        Patient patient = (Patient) query.uniqueResult();
        session.close();
        return patient;
    }

    public static Patient verifyLogin(String userName, String password) {
        Session session = DBConnection.getSession ();
        session.beginTransaction ();
        Query query = session.createQuery ("from Patient p where p.userName = :userName and p.password = :password");
        query.setParameter ("userName", userName);
        query.setParameter ("password", password);
        Patient patient = (Patient) query.uniqueResult ();
        session.close ();
        return patient;
    }


}
