package com.example.demo;

import com.example.demo.Models.AppRole;
import com.example.demo.Models.AppUser;
import com.example.demo.Models.DateQuerry;
import com.example.demo.Repositories.AppRoleRepository;
import com.example.demo.Repositories.AppUserRepository;
import com.example.demo.Repositories.DateQuerryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.validation.Valid;

@Controller
public class MainController {
    // VARIABLES ////////////
    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
    DateQuerryRepository dateQuerryRepository;

    LocalDate userDate=null;

    Calendar c = Calendar.getInstance();

    //Set up formatters so that you can use them later
    DateTimeFormatter dTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter shortMonthFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
    DateTimeFormatter longFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");


    // METHODS //////////////
    // Basic Security methods
    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login() {
        return "loginpage";
    }

    // Security and User Methods

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("newUser", new AppUser());
        return "registrationpage";
    }

    @PostMapping("/register")
    public String addNewUser(@Valid @ModelAttribute("newUser") AppUser newUser, BindingResult result, Model model) {

        if (result.hasErrors()) {
            System.out.println(result.toString());
            return "registrationpage";
        } else {

            model.addAttribute(newUser.getAppUsername() + " created");
            appUserRepository.save(newUser);
            AppRole r = appRoleRepository.findAppRoleByRoleName("USER");
            newUser.addRole(r);
            appUserRepository.save(newUser);
            return "redirect:/getdate";
        }
    }

    // Date and Time Methods
    @GetMapping("/getdate")
    public String getDateForProgram(Model model){
        model.addAttribute("getdate", new DateQuerry());
        return "inputpage";
    }

    @PostMapping("/getdate")
    public String processDateForProgram(@Valid @ModelAttribute("getdate") DateQuerry dateQuerry, BindingResult result,
                                        /*Authentication authentication,*/ Model model){
        if (result.hasErrors()) {
            System.out.println(result.toString());
            return "inputpage";
        } else {
            /*AppUser appUser = appUserRepository.findAppUserByAppUsername(authentication.getName());*/
            userDate = LocalDate.parse(dateQuerry.getInputDate(),dTF);
            dateQuerry.setOutputDate(userDate.format(shortMonthFormat));
            /*dateQuerry.setAppUser(appUser);*/
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
            int month= userDate.getMonthValue();
            int day=userDate.getDayOfMonth();
            if      ((month == 12 && day >= 22 && day <= 31) || (month ==  1 && day >= 1 && day <= 19))
                dateQuerry.setAstrologicalSigns("Capricorn");
            else if ((month ==  1 && day >= 20 && day <= 31) || (month ==  2 && day >= 1 && day <= 17))
                dateQuerry.setAstrologicalSigns("Aquarius");
            else if ((month ==  2 && day >= 18 && day <= 29) || (month ==  3 && day >= 1 && day <= 19))
                dateQuerry.setAstrologicalSigns("Pisces");
            else if ((month ==  3 && day >= 20 && day <= 31) || (month ==  4 && day >= 1 && day <= 19))
                dateQuerry.setAstrologicalSigns("Aries");
            else if ((month ==  4 && day >= 20 && day <= 30) || (month ==  5 && day >= 1 && day <= 20))
                dateQuerry.setAstrologicalSigns("Taurus");
            else if ((month ==  5 && day >= 21 && day <= 31) || (month ==  6 && day >= 1 && day <= 20))
                dateQuerry.setAstrologicalSigns("Gemini");
            else if ((month ==  6 && day >= 21 && day <= 30) || (month ==  7 && day >= 1 && day <= 22))
                dateQuerry.setAstrologicalSigns("Cancer");
            else if ((month ==  7 && day >= 23 && day <= 31) || (month ==  8 && day >= 1 && day <= 22))
                dateQuerry.setAstrologicalSigns("Leo");
            else if ((month ==  8 && day >= 23 && day <= 31) || (month ==  9 && day >= 1 && day <= 22))
                dateQuerry.setAstrologicalSigns("Virgo");
            else if ((month ==  9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22))
                dateQuerry.setAstrologicalSigns("Libra");
            else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21))
                dateQuerry.setAstrologicalSigns("Scorpio");
            else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21))
                dateQuerry.setAstrologicalSigns("Sagittarius");



            /*switch (month) {
                case 1:  dateQuerry.setAstrologicalSigns("Aries");
                    break;
                case 2:  dateQuerry.setAstrologicalSigns("Taurus");
                    break;
                case 3:  dateQuerry.setAstrologicalSigns("Gemini");
                    break;
                case 4:  dateQuerry.setAstrologicalSigns("Cancer");
                    break;
                case 5:  dateQuerry.setAstrologicalSigns("Leo");
                    break;
                case 6:  dateQuerry.setAstrologicalSigns("Virgo");
                    break;
                case 7:  dateQuerry.setAstrologicalSigns("Libra");
                    break;
                case 8:  dateQuerry.setAstrologicalSigns("Scorpio");
                    break;
                case 9:  dateQuerry.setAstrologicalSigns("Sagittarius");
                    break;
                case 10: dateQuerry.setAstrologicalSigns("Capricorn");
                    break;
                case 11: dateQuerry.setAstrologicalSigns("Aquarius");
                    break;
                case 12: dateQuerry.setAstrologicalSigns("Pisces");
                    break;
            }*/
            dateQuerryRepository.save(dateQuerry);
            /*appUser.addDateQuerry(dateQuerry);
            appUserRepository.save(appUser);*/
            return "redirect:/showname";
        }
    }

    @GetMapping("/showname")

    public String showName(Model model/*, Authentication authentication*/){
        /*AppUser appUser = appUserRepository.findAppUserByAppUsername(authentication.getName());*/
        model.addAttribute("listed",dateQuerryRepository.findAll());
        return "outputpage";
    }
}
