package com.example.demo.Services;

import com.example.demo.Horoscope;
import com.example.demo.Models.DateQuerry;
import com.example.demo.Repositories.DateQuerryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class DateMethodsService {
    @Autowired
    DateQuerryRepository dateQuerryRepository;

    LocalDate userDate=null;

    //Set up formatters so that you can use them later
    DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter shortMonthFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
    DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");

    public void addDayCharacter(DateQuerry dateQuerry){
        userDate = LocalDate.parse(dateQuerry.getInputDate(),dTF);
        dateQuerry.setOutputDate(userDate.format(shortMonthFormat));
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
        dateQuerryRepository.save(dateQuerry);
    }

    public void addWesternZodiac(DateQuerry dateQuerry){
        userDate = LocalDate.parse(dateQuerry.getInputDate(),dTF);
        int month= userDate.getMonthValue();
        int day=userDate.getDayOfMonth();
        if      ((month == 12 && day >= 22 && day <= 31) || (month ==  1 && day >= 1 && day <= 19))
            dateQuerry.setAstrologicalSigns("capricorn");
        else if ((month ==  1 && day >= 20 && day <= 31) || (month ==  2 && day >= 1 && day <= 17))
            dateQuerry.setAstrologicalSigns("aquarius");
        else if ((month ==  2 && day >= 18 && day <= 29) || (month ==  3 && day >= 1 && day <= 19))
            dateQuerry.setAstrologicalSigns("pisces");
        else if ((month ==  3 && day >= 20 && day <= 31) || (month ==  4 && day >= 1 && day <= 19))
            dateQuerry.setAstrologicalSigns("aries");
        else if ((month ==  4 && day >= 20 && day <= 30) || (month ==  5 && day >= 1 && day <= 20))
            dateQuerry.setAstrologicalSigns("taurus");
        else if ((month ==  5 && day >= 21 && day <= 31) || (month ==  6 && day >= 1 && day <= 20))
            dateQuerry.setAstrologicalSigns("gemini");
        else if ((month ==  6 && day >= 21 && day <= 30) || (month ==  7 && day >= 1 && day <= 22))
            dateQuerry.setAstrologicalSigns("cancer");
        else if ((month ==  7 && day >= 23 && day <= 31) || (month ==  8 && day >= 1 && day <= 22))
            dateQuerry.setAstrologicalSigns("leo");
        else if ((month ==  8 && day >= 23 && day <= 31) || (month ==  9 && day >= 1 && day <= 22))
            dateQuerry.setAstrologicalSigns("virgo");
        else if ((month ==  9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22))
            dateQuerry.setAstrologicalSigns("libra");
        else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21))
            dateQuerry.setAstrologicalSigns("scorpio");
        else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21))
            dateQuerry.setAstrologicalSigns("sagittarius");
        dateQuerryRepository.save(dateQuerry);
    }

    public void addChineseZodiacYears(DateQuerry dateQuerry){
        userDate = LocalDate.parse(dateQuerry.getInputDate(),dTF);
        int yearNum =userDate.getYear();
        switch (yearNum % 12) {
            case 0:  dateQuerry.setChineseZodiac("Monkey");
                break;
            case 1:  dateQuerry.setChineseZodiac("Rooster");
                break;
            case 2:  dateQuerry.setChineseZodiac("Dog");
                break;
            case 3:  dateQuerry.setChineseZodiac("Pig");
                break;
            case 4:  dateQuerry.setChineseZodiac("Rat");
                break;
            case 5:  dateQuerry.setChineseZodiac("Ox");
                break;
            case 6:  dateQuerry.setChineseZodiac("Tiger");
                break;
            case 7:  dateQuerry.setChineseZodiac("Rabbit");
                break;
            case 8:  dateQuerry.setChineseZodiac("Dragon");
                break;
            case 9: dateQuerry.setChineseZodiac("Snake");
                break;
            case 10: dateQuerry.setChineseZodiac("Horse");
                break;
            case 11: dateQuerry.setChineseZodiac("Sheep");
                break;
        }
        dateQuerryRepository.save(dateQuerry);
    }

    public void  addTodayHoroscope(DateQuerry dateQuerry){
        RestTemplate restTemplate = new RestTemplate();
        String sunsign = dateQuerry.getAstrologicalSigns();
        Horoscope horoscope=restTemplate.getForObject("http://horoscope-api.herokuapp.com/horoscope/today/" + sunsign,Horoscope.class);
        String thisHoroscope=horoscope.getHoroscope();
        thisHoroscope=thisHoroscope.replace("['","");
        thisHoroscope=thisHoroscope.replace("']","");
        dateQuerry.setTodaysHoroscope(thisHoroscope);
        dateQuerryRepository.save(dateQuerry);
    }
    public void addTommorrowHoroscope(){

    }
}
