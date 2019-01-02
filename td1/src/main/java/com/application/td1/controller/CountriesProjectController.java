package com.application.td1.controller;
import com.application.td1.model.*;
import com.application.td1.repository.CountryRepository;
import com.application.td1.repository.LocationRepository;
import com.application.td1.repository.RegionRepository;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/country")
public class CountriesProjectController {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private RegionRepository regionRepository;


    //@PreAuthorize("hasAnyRole('ADMIN')")
    //@RequestMapping(value = "/charge",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    //public String update(Model model) {
    //    model.addAttribute("form", new FormCountry());
    //    return "index";
    //}





    @RequestMapping(value = "/countries",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String findA (Model model) {
        List<CountriesEntity> a = countryRepository.findAll();
        List<RegionsEntity> c = regionRepository.findAll();
        model.addAttribute("smokeTests",a);
        model.addAttribute("country", new CountriesController.FormCountry());
        model.addAttribute("countryAdd", new CountriesController.FormCountry());
        model.addAttribute("region",c);
        return "countries";

    }

    @PostMapping(value = "/delete")
    public String delete (@ModelAttribute("country") CountriesController.FormCountry country, Model model) {
        CountriesEntity b = countryRepository.findByCountryId(country.getCountryId());

        Optional<List<LocationsEntity>> opt = Optional.ofNullable(locationRepository.findByCountryId(b));
        if(opt.isPresent()){
            List<LocationsEntity> a = opt.get();
            for(int i=0; i<a.size(); i++)
                locationRepository.delete(a.get(i));






        }
        else{
            System.out.println("Error country not existing");

        }


        CountriesEntity a = countryRepository.findByCountryId(country.getCountryId());
        countryRepository.delete(a);

        System.out.println("test");

        findA(model);
        return "countries";

    }

    @PostMapping(value = "/add")
    public String add (@ModelAttribute("countryAdd") CountriesController.FormCountry country, Model model) {
        String id = country.getCountryId();
        Optional<CountriesEntity> opt = Optional.ofNullable(countryRepository.findByCountryId(id));
        if(opt.isPresent()){
            System.out.println("Error country already exist");

        }
        else{
            CountriesEntity a= new CountriesEntity();
            a.setCountryId(country.getCountryId());
            a.setCountryName(country.getCountryName());
            String name = country.getRegionName();
            System.out.println("debut:"+name.substring(0,name.length()-2)+":fin");
            System.out.println(name);
            Optional<RegionsEntity> t = Optional.ofNullable(regionRepository.findByRegionName(name));
            if(t.isPresent()) {
                //System.out.println(t.getRegionId());
                //System.out.println(t.getRegionName());
                RegionsEntity i = t.get();
                a.setRegionId(i);
            }
            else{
                System.out.println("error");
            }



            countryRepository.save(a);


        }


        findA(model);
        return "countries";
    }





}