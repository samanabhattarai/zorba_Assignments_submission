package com.servletdemo.dao;

import com.servletdemo.dbconnection.DBConnection;
import com.servletdemo.dto.Appointment;
import com.servletdemo.dto.Doctor;
import com.servletdemo.dto.Patient;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Date;
import java.util.List;

public class AppointmentsDao {

    public static Appointment saveAppointments(int patientId, int doctorId, Date date) {
        Session session = DBConnection.getSession();
        session.beginTransaction();

        Patient patient = (Patient) session.createQuery ("from Patient p where p.patientId= :patientId").setInteger ("patientId", patientId).uniqueResult();
        Doctor doctor = (Doctor) session.createQuery ("from Doctor d where d.id= :doctorId").setInteger ("doctorId", doctorId).uniqueResult();

        Appointment appointments = new Appointment ();
        appointments.setPatient(patient);
        appointments.setDoctor(doctor);
        appointments.setDate(date);

        session.persist(appointments);
        session.getTransaction().commit();
        session.close();
        return appointments;
    }

    public static List<Appointment> getAppointmentsByPatientId(int patientId) {
        Session session = DBConnection.getSession();
        List<Appointment> appointments = session.createQuery("from Appointment a where a.patient.patientId = :patientId").setInteger("patientId", patientId).list();
        session.close();
        return appointments;
    }

    public static Appointment updateAppointment(Appointment appointment, int newDoctorId, Date date) {
        Session session = DBConnection.getSession();
        session.beginTransaction();
        Query query = session.createQuery ("from Appointment A where A.id = :appointmentId");
        Appointment updatedAppointment = (Appointment) query.setInteger ("appointmentId", appointment.getId ()).uniqueResult ();
        updatedAppointment.setDoctor ((Doctor) session.createQuery ("from Doctor d where d.id = :doctorId").setInteger ("doctorId", newDoctorId).uniqueResult ());
        updatedAppointment.setDate(date);
        session.update(updatedAppointment);
        session.getTransaction().commit();
        session.close();
        return updatedAppointment;
    }

    public static void deleteAppointment(int appointmentId) {
        Session session = DBConnection.getSession();
        session.beginTransaction();
        Appointment appointment = (Appointment) session.get(Appointment.class, appointmentId);
        session.delete(appointment);
        session.getTransaction().commit();
        session.close();
    }

    public static Appointment getAppointmentById(int appointmentId) {
        Session session = DBConnection.getSession();
        Appointment appointment = (Appointment) session.get(Appointment.class, appointmentId);
        session.close();
        return appointment;
    }

}