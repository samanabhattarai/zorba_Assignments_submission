package com.servletdemo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"appointments"})
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private Integer id;
    @Column(name="doctor_name")
    private String name;
    @Column(name="specialization")
    private String specialization;
    @Column(name="mobile")
    private String mobile;
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments = new HashSet<> ();

}
