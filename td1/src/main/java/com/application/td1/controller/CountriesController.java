package com.application.td1.controller;
import com.application.td1.model.CountriesEntity;
import com.application.td1.model.EmployeesEntity;
import com.application.td1.model.JobsEntity;
import com.application.td1.model.RegionsEntity;
import com.application.td1.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="/countries")
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

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/charge",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String update(Model model) {
        model.addAttribute("form", new FormCountry());
        return "update";
    }





    @RequestMapping(value = "/allcountries",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String findA (Model model) {
        List<CountriesEntity> a = countryRepository.findAll();

        model.addAttribute("smokeTests",a);

        return "hello";

    }


    @PostMapping("/update")
    public String greetingSubmit(@ModelAttribute("form") FormCountry form, Model model) {
            String id = form.getCountryId();
        Optional<CountriesEntity> opt = Optional.ofNullable(countryRepository.findByCountryId(id));
        if(opt.isPresent()){
            CountriesEntity a= opt.get();
            a.setCountryName(form.getCountryName());
            countryRepository.save(a);

        }
        else{
            System.out.println("Error country not existing");

        }
        findA(model);
        return "hello";

    }

    public static class FormCountry {

        private  static String countryId;

        private  static String countryName;

        private static String regionName;

        public  void setCountryId(String id) {
            FormCountry.countryId = id;
        }

        public  void setCountryName(String countryName) {
            FormCountry.countryName = countryName;
        }



        public  String getCountryId() {
            return countryId;
        }

        public  String getCountryName() {
            return countryName;
        }

        public static String getRegionName() {
            return regionName;
        }

        public static void setRegionName(String regionName) {
            FormCountry.regionName = regionName;
        }
    }
}