package com.example.demo.Models;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class DateQuerry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String inputDate;

    private String outputDate;

    private String sexChoice;

    private String maleName;

    private String femaleName;

    private String dayOfWeek;

    private String dayCharacterists;

    private String chineseZodiac;

    private String astrologicalSigns;

    @Transient
    LocalDate userDate=null;
    @Transient
    DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Transient
    DateTimeFormatter shortMonthFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");

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

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(String outputDate) {
        this.outputDate = outputDate;
    }

    public String getDayCharacterists() {
        return dayCharacterists;
    }

    public void setDayCharacterists(String dayCharacterists) {
        this.dayCharacterists = dayCharacterists;
    }

    public String getChineseZodiac() {
        return chineseZodiac;
    }

    public void setChineseZodiac(String chineseZodiac) {
        this.chineseZodiac = chineseZodiac;
    }

    public String getAstrologicalSigns() {
        return astrologicalSigns;
    }

    public void setAstrologicalSigns(String astrologicalSigns) {
        this.astrologicalSigns = astrologicalSigns;
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
