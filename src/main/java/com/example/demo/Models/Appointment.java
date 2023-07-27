package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Data;

import javax.print.Doc;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    private Date appointmentDate;

    private LocalTime appointmentTime;

    @ManyToOne
    @JoinColumn
    private Doctor doctor;

    @ManyToOne
    @JoinColumn
    private User user;
}
