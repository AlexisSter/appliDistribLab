package com.application.td1.controller;
import com.application.td1.model.DepartmentsEntity;
import com.application.td1.model.EmployeesEntity;
import com.application.td1.model.JobsEntity;
import com.application.td1.repository.DepartmentRepository;
import com.application.td1.repository.EmployeeRepository;
import com.application.td1.repository.JobRepository;
import com.application.td1.service.CustomUserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/user")
@Controller

public class UserController {



    @Autowired
    private CustomUserServiceDetail userService;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/register")
    public String registerForm(Model model) {
        List<JobsEntity> job = jobRepository.findAll();
        List<DepartmentsEntity> department = departmentRepository.findAll();
        model.addAttribute("user", new FormUser());
        model.addAttribute("job", job);
        model.addAttribute("department", department);
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(@Valid FormUser user, BindingResult bindingResult, Model model) {

        DepartmentsEntity u = departmentRepository.findByDepartmentId(user.getDepartment());
        EmployeesEntity userEntity = new EmployeesEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        userEntity.setDepartmentId(u);
        userEntity.setPhoneNumber(user.getPhoneNumber());



        Optional<EmployeesEntity> o = employeeRepository.findByEmail(user.getEmail());
        if(o.isPresent()){
            System.out.println("error email already exist");
            model.addAttribute("error","yes");
            registerForm(model);
            return "register";
        }
        else{
            userService.create(userEntity,user.getJob());
            model.addAttribute("error","no");
            return "app-login";

        }




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

        private String job;
        private int department;
        private String phoneNumber;

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

        public String getJob() {
            return job;
        }

        public int getDepartment() {
            return department;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public void setDepartment(int department) {
            this.department = department;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

}