/*
package com.example.demo;

import com.example.demo.Models.DateQuerry;
import com.example.demo.Repositories.DateQuerryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class DayMethods {

    @Autowired
    DateQuerryRepository dateQuerryRepository;

    public void setDayValues(DateQuerry dateQuerry){
        userDate = LocalDate.parse(inputdate,dTF);
        DayOfWeek dow = userDate.getDayOfWeek();
        switch (dow){

            case MONDAY:  dateQuerry.setMaleName("Kojo");
                dateQuerry.setFemaleName("Adjoa");
                dateQuerry.setDayOfWeek("Monday");
                dateQuerry.setDayCharacterists("Calm,peaceful");
                break;
            case TUESDAY:  dateQuerry.setMaleName("Kwabena");
                dateQuerry.setFemaleName("Abena");
                dateQuerry.setDayOfWeek("Tuesday");
                dateQuerry.setDayCharacterists("Warrior, fierce, compassionate");
                break;
            case WEDNESDAY:  dateQuerry.setMaleName("Kweku");
                dateQuerry.setFemaleName("Akua");
                dateQuerry.setDayOfWeek("Wednesday");
                dateQuerry.setDayCharacterists("Advocate, controlling");
                break;
            case THURSDAY:  dateQuerry.setMaleName("Yaw");
                dateQuerry.setFemaleName("Yaa");
                dateQuerry.setDayOfWeek("Thursday");
                dateQuerry.setDayCharacterists("Confrontational, aggressive");
                break;
            case FRIDAY:  dateQuerry.setMaleName("Kofi");
                dateQuerry.setFemaleName("Afua");
                dateQuerry.setDayOfWeek("Friday");
                dateQuerry.setDayCharacterists("Adventurous, creative, innovative");
                break;
            case SATURDAY:  dateQuerry.setMaleName("Kwame");
                dateQuerry.setFemaleName("Ama");
                dateQuerry.setDayOfWeek("Saturday");
                dateQuerry.setDayCharacterists("The ancient wise one.");
                break;
            case SUNDAY:  dateQuerry.setMaleName("Kwesi");
                dateQuerry.setFemaleName("Akosua");
                dateQuerry.setDayOfWeek("Sunday");
                dateQuerry.setDayCharacterists("Born leader, guide, protector");
                break;

        }


    }
}
*/
