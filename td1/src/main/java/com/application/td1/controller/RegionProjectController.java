package com.application.td1.controller;
import com.application.td1.model.*;
import com.application.td1.repository.*;
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
@RequestMapping(value = "/region")
public class RegionProjectController {



    @Autowired
    private RegionRepository regionRepository;

    //@PreAuthorize("hasAnyRole('ADMIN')")
    //@RequestMapping(value = "/charge",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    //public String update(Model model) {
    //    model.addAttribute("form", new FormCountry());
    //    return "index";
    //}




    @PreAuthorize("hasAnyRole('AD_PRES','AC_ACCOUNT','AC_MGR','FI_ACCOUNT','FI_MGR','SA_MAN','SA_REP')")
    @RequestMapping(value = "/regions",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String region (Model model) {
        List<RegionsEntity> a = regionRepository.findAll();

        model.addAttribute("region",a);
        model.addAttribute("regionDelete", new FormRegion());
        model.addAttribute("regionAdd", new FormRegion());
        model.addAttribute("regionEdit", new FormRegion());

        return "regions";

    }
    @PreAuthorize("hasAnyRole('AD_PRES')")
    @PostMapping(value = "/delete")
    public String delete (@ModelAttribute("regionDelete") FormRegion job, Model model) {
        RegionsEntity b = regionRepository.findByRegionId(job.getRegionId());





        regionRepository.delete(b);


        region(model);
        return "regions";

    }
    @PreAuthorize("hasAnyRole('AD_PRES')")
    @PostMapping(value = "/add")
    public String add (@ModelAttribute("regionAdd") FormRegion region, Model model) {
        int id = region.getRegionId();
        Optional<RegionsEntity> opt = Optional.ofNullable(regionRepository.findByRegionId(id));
        if(opt.isPresent()){
            System.out.println("Error country already exist");

        }
        else{
            RegionsEntity a= new RegionsEntity();
            a.setRegionId(region.getRegionId());
            a.setRegionName(region.getRegionName());


            regionRepository.save(a);


        }


        region(model);
        return "regions";
    }
    @PreAuthorize("hasAnyRole('AD_PRES')")
    @PostMapping(value = "/edit")
    public String edit (@ModelAttribute("regionEdit") FormRegion region, Model model) {
        int id = region.getRegionId();
        Optional<RegionsEntity> opt = Optional.ofNullable(regionRepository.findByRegionId(id));
        if (opt.isPresent()) {
            RegionsEntity b = opt.get();
            b.setRegionId(region.getRegionId());
            b.setRegionName(region.getRegionName());

            regionRepository.save(b);
        }



        region(model);
        return "regions";

    }
    public static class FormRegion {
        private Integer regionId;
        private String regionName;

        public Integer getRegionId() {
            return regionId;
        }

        public String getRegionName() {
            return regionName;
        }

        public void setRegionId(Integer regionId) {
            this.regionId = regionId;
        }

        public void setRegionName(String regionName) {
            this.regionName = regionName;
        }
    }





}