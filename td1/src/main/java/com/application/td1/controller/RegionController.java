package com.application.td1.controller;

import com.application.td1.model.JobsEntity;
import com.application.td1.model.RegionsEntity;
import com.application.td1.repository.RegionRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/region")
public class RegionController {

    @Autowired
    RegionRepository regionRepository;

    @GetMapping(value = "/{jobName}")
    public RegionsEntity findOne (@PathVariable final int jobName) {
        return regionRepository.findByRegionId(jobName);
    }
}
