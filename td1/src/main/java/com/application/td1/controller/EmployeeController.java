package com.application.td1.controller;

import com.application.td1.ObjectMapperUtils;
import com.application.td1.model.EmployeesEntity;
import com.application.td1.model.EmployeesEntityDTO;
import com.application.td1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path="/employee")
public class EmployeeController {



    @Autowired
    private EmployeeRepository employeeRepository;



    @GetMapping(value = "/all")
    public List<EmployeesEntity> findAll () {
        return employeeRepository.findAll();
    }

    //@GetMapping(value = "/{employeeName}")
    //public JobsEntity findOne (@PathVariable final String employeeName) {
      //  return employeeRepository.findByJobTitle(employeeName);
    //}

    @GetMapping(value = "/salary/{val}")
    public List<EmployeesEntityDTO> findSalary (@PathVariable final String val) {
        List<EmployeesEntity> a = employeeRepository.findByFirstName(val);
        List<EmployeesEntityDTO> employeeDTO = ObjectMapperUtils.mapAll(a, EmployeesEntityDTO.class);
        return employeeDTO;
    }














}
