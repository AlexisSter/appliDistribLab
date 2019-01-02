package com.application.td1.controller;

import com.application.td1.model.JobsEntity;
import com.application.td1.repository.JobRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller


public class pageController {



    //@PreAuthorize("hasAnyRole('USER')")
    @RequestMapping(value = "/home",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String home(Model model) {

        return "home";
    }
    @RequestMapping(value = "/",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String home1(Model model) {

        return "home";
    }

    @RequestMapping(value = "/table",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String table(Model model) {

        return "index";
    }

}
