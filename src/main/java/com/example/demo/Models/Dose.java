package com.example.demo.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "dose")
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Primary key

    @Column(unique = true)
    private String doseId;

    @CreationTimestamp
    private Date vaccinationDate;

    //unidirectional mapping
    @OneToOne
    @JoinColumn
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoseId() {
        return doseId;
    }

    public void setDoseId(String doseId) {
        this.doseId = doseId;
    }

    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(Date vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }
}
