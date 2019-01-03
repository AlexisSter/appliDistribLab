package com.application.td1.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "/graph",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String graph(Model model) {

        return "graph";
    }


}
