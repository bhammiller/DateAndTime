package com.example.demo;

import com.example.demo.Models.AppRole;
import com.example.demo.Models.AppUser;
import com.example.demo.Models.DateQuerry;
import com.example.demo.Repositories.AppRoleRepository;
import com.example.demo.Repositories.AppUserRepository;
import com.example.demo.Repositories.DateQuerryRepository;
import com.example.demo.Services.DateMethodsService;
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

    @Autowired
    DateMethodsService dateFacts;

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
            dateQuerryRepository.save(dateQuerry);
            /*AppUser appUser = appUserRepository.findAppUserByAppUsername(authentication.getName());*/
           /* userDate = LocalDate.parse(dateQuerry.getInputDate(),dTF);
            dateQuerry.setOutputDate(userDate.format(shortMonthFormat));*/
            /*dateQuerry.setAppUser(appUser);*/
            dateFacts.addChineseZodiacYears(dateQuerry);
            dateFacts.addDayCharacter(dateQuerry);
            dateFacts.addWesternZodiac(dateQuerry);
            dateQuerryRepository.save(dateQuerry);
            dateFacts.addTodayHoroscope(dateQuerry);
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
