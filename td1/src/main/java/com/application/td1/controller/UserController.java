package com.application.td1.controller;
import com.application.td1.model.CountriesEntity;
import com.application.td1.model.EmployeesEntity;
import com.application.td1.model.JobsEntity;
import com.application.td1.model.Users;
import com.application.td1.repository.CountryRepository;
import com.application.td1.repository.UserRepository;
import com.application.td1.service.CustomUserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/user")
@Controller

public class UserController {
    @Autowired
    private UserRepository countryRepository;

    @GetMapping(value = "/all")
    public String findAll () {

        return "HELLO";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/secured/all")
    public String findOne () {
        return "HELLO SECURED";
    }

    @Autowired
    private CustomUserServiceDetail userService;

    @GetMapping("/register")
    public String registerForm(Model model) {

        model.addAttribute("user", new Users());
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(@Valid Users user, BindingResult bindingResult, Model model) {


        userService.createUser(user);

        return "hello";

    }



}