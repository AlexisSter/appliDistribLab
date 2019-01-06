package com.application.td1.controller;
import com.application.td1.model.CountriesEntity;
import com.application.td1.model.EmployeesEntity;
import com.application.td1.model.JobsEntity;
import com.application.td1.model.Users;
import com.application.td1.repository.CountryRepository;
import com.application.td1.repository.RoleRepository;
import com.application.td1.repository.UserRepository;
import com.application.td1.service.CustomUserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;
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

        model.addAttribute("user", new FormUser());
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(@Valid FormUser user, BindingResult bindingResult, Model model) {
        Users userEntity = new Users();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        userService.create(userEntity,user.getRole());

        return "app-login";

    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("app-login");
        return modelAndView;
    }
    @GetMapping("/logout")
    public ModelAndView logout() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("app-login");
        return modelAndView;
    }

    public static class FormUser{
        private String firstName;

        private String lastName;

        private String email;

        private String password;

        private String role;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

}