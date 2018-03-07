package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Horoscope {
    private String date;
    private String horoscope;
    private String sunsign;

    public Horoscope() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public String getSunsign() {
        return sunsign;
    }

    public void setSunsign(String sunsign) {
        this.sunsign = sunsign;
    }

    @Override
    public String toString() {
        return "Horoscope{" +
                "date='" + date + '\'' +
                ", horoscope='" + horoscope + '\'' +
                ", sunsign='" + sunsign + '\'' +
                '}';
    }
}
