package com.application.td1.controller;
import com.application.td1.model.CountriesEntity;
import com.application.td1.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/country")
public class CountriesController {
        @Autowired
        private CountryRepository countryRepository;

        @GetMapping(value = "/all")
        public List<CountriesEntity> findAll () {
            // @ResponseBody means the returned String is the response, not a view name
            // @RequestParam means it is a parameter from the GET or POST request
            return countryRepository.findAll();
        }

    @GetMapping(value = "/{countryName}")
    public CountriesEntity findOne (@PathVariable final String countryName) {
        return countryRepository.findByCountryName(countryName);
    }

    }
