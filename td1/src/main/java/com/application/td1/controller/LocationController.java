package com.application.td1.controller;
import com.application.td1.model.*;
import com.application.td1.repository.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/locations")
public class LocationController {



    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private CountryRepository countryRepository;

    //@PreAuthorize("hasAnyRole('ADMIN')")
    //@RequestMapping(value = "/charge",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    //public String update(Model model) {
    //    model.addAttribute("form", new FormCountry());
    //    return "index";
    //}




    @PreAuthorize("hasAnyRole('AD_PRES','AC_ACCOUNT','AC_MGR','FI_ACCOUNT','FI_MGR','SA_MAN','SA_REP')")
    @RequestMapping(value = "/locations",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String location (Model model) {
        List<LocationsEntity> a = locationRepository.findAll();
        List<CountriesEntity> b = countryRepository.findAll();
        model.addAttribute("location",a);
        model.addAttribute("country",b);
        model.addAttribute("locationDelete", new FormLocation());
        model.addAttribute("locationAdd", new FormLocation());
        model.addAttribute("locationEdit", new FormLocation());

        return "locations";

    }
    @PreAuthorize("hasAnyRole('AD_PRES','AC_ACCOUNT','AC_MGR','FI_ACCOUNT','FI_MGR')")
    @PostMapping(value = "/delete")
    public String delete (@ModelAttribute("locationDelete") FormLocation location, Model model) {
        LocationsEntity b = locationRepository.findByLocationId(location.getLocationId());





        locationRepository.delete(b);


        location(model);
        return "locations";

    }
    @PreAuthorize("hasAnyRole('AD_PRES','AC_ACCOUNT','AC_MGR','FI_ACCOUNT','FI_MGR')")
    @PostMapping(value = "/add")
    public String add (@ModelAttribute("locationAdd") FormLocation location, Model model) {
        int id = location.getLocationId();
        Optional<LocationsEntity> opt = Optional.ofNullable(locationRepository.findByLocationId(id));
        if(opt.isPresent()){
            System.out.println("Error country already exist");

        }
        else{
            LocationsEntity a= new LocationsEntity();
            a.setLocationId(location.getLocationId());
            a.setCity(location.getCity());
            a.setPostalCode(location.getPostalCode());
            a.setStateProvince(location.getStateProvince());
            a.setStreetAddress(location.getStreetAddress());

            String name = location.getCountryId();

            Optional<CountriesEntity> t = Optional.ofNullable(countryRepository.findByCountryId(name));
            if(t.isPresent()) {

                CountriesEntity i = t.get();
                a.setCountryId(i);
                locationRepository.save(a);
            }
            else{
                System.out.println("error");
            }




        }


        location(model);
        return "locations";
    }
    @PreAuthorize("hasAnyRole('AD_PRES','AC_ACCOUNT','AC_MGR','FI_ACCOUNT','FI_MGR')")
    @PostMapping(value = "/edit")
    public String edit (@ModelAttribute("locationEdit") FormLocation location, Model model) {
        int id = location.getLocationId();
        Optional<LocationsEntity> opt = Optional.ofNullable(locationRepository.findByLocationId(id));
        if(opt.isPresent()){
            LocationsEntity a = opt.get();
            a.setLocationId(location.getLocationId());
            a.setCity(location.getCity());
            a.setPostalCode(location.getPostalCode());
            a.setStateProvince(location.getStateProvince());
            a.setStreetAddress(location.getStreetAddress());

            String name = location.getCountryId();

            Optional<CountriesEntity> t = Optional.ofNullable(countryRepository.findByCountryId(name));
            if(t.isPresent()) {
                CountriesEntity i = t.get();
                a.setCountryId(i);
                locationRepository.save(a);
            }
            else{
                System.out.println("error");
            }



        }
        else{

            System.out.println("Error country already exist");





        }


        location(model);
        return "locations";

    }
    public static class FormLocation {
        private Integer locationId;
        private String streetAddress;
        private String postalCode;
        private String city;
        private String stateProvince;
        private String countryId;

        public Integer getLocationId() {
            return locationId;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public String getCity() {
            return city;
        }

        public String getStateProvince() {
            return stateProvince;
        }

        public String getCountryId() {
            return countryId;
        }

        public void setLocationId(Integer locationId) {
            this.locationId = locationId;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setStateProvince(String stateProvince) {
            this.stateProvince = stateProvince;
        }

        public void setCountryId(String countryId) {
            this.countryId = countryId;
        }
    }





}