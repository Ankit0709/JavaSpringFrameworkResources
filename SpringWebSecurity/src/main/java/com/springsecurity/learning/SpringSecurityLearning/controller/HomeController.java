package com.springsecurity.learning.SpringSecurityLearning.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/","/index"})
    public String homePage(){
        return "home";
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }
    @RequestMapping("/logout-success")
    public String logoutPage(){
        return "logout";
    }

    @RequestMapping("/userPage")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userPage(){
        return "user";
    }

    @RequestMapping("/adminPage")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminPage(){
        return "admin";
    }
}
