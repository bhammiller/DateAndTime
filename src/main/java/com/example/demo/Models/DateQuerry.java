package com.example.demo.Models;

import javax.persistence.*;

@Entity
public class DateQuerry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String inputDate;

    private String sexChoice;

    private String maleName;

    private String femaleName;

    // Variable Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getSexChoice() {
        return sexChoice;
    }

    public void setSexChoice(String sexChoice) {
        this.sexChoice = sexChoice;
    }

    public String getMaleName() {
        return maleName;
    }

    public void setMaleName(String maleName) {
        this.maleName = maleName;
    }

    public String getFemaleName() {
        return femaleName;
    }

    public void setFemaleName(String femaleName) {
        this.femaleName = femaleName;
    }

    // Contructors

    public DateQuerry() {
    }

    // Connection to AppUser
    @ManyToOne
    @JoinColumn
    private AppUser appUser;

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
