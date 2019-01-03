package com.application.td1.controller;
import com.application.td1.model.*;
import com.application.td1.repository.*;
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
@RequestMapping(value = "/department")
public class DepartmentsController {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    //@PreAuthorize("hasAnyRole('ADMIN')")
    //@RequestMapping(value = "/charge",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    //public String update(Model model) {
    //    model.addAttribute("form", new FormCountry());
    //    return "index";
    //}





    @RequestMapping(value = "/departments",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String departments (Model model) {
        List<DepartmentsEntity> a = departmentRepository.findAll();
        List<LocationsEntity> c = locationRepository.findAll();
        List<EmployeesEntity> b = employeeRepository.findAll();
        model.addAttribute("department",a);
        model.addAttribute("country", new CountriesController.FormCountry());
        model.addAttribute("countryAdd", new CountriesController.FormCountry());
        model.addAttribute("countryEdit", new CountriesController.FormCountry());
        model.addAttribute("location",c);
        model.addAttribute("employee",b);
        return "departments";

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

        departments(model);
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


        departments(model);
        return "countries";
    }
    @PostMapping(value = "/edit")
    public String edit (@ModelAttribute("countryEdit") CountriesController.FormCountry country, Model model) {
        String id = country.getCountryId();
        Optional<CountriesEntity> opt = Optional.ofNullable(countryRepository.findByCountryId(id));
        if(opt.isPresent()){
            CountriesEntity b= opt.get();

            b.setCountryId(country.getCountryId());
            b.setCountryName(country.getCountryName());
            String name = country.getRegionName();

            System.out.println(name);
            Optional<RegionsEntity> t = Optional.ofNullable(regionRepository.findByRegionName(name));
            if(t.isPresent()) {
                //System.out.println(t.getRegionId());
                //System.out.println(t.getRegionName());
                RegionsEntity i = t.get();
                b.setRegionId(i);
            }
            else{
                System.out.println("error");
            }
            countryRepository.save(b);

        }
        else{
            System.out.println("Error country already exist");







        }


        departments(model);
        return "countries";
    }





}