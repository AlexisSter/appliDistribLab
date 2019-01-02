package com.application.td1.controller;

import com.application.td1.model.JobsEntity;
import com.application.td1.repository.JobRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Api(value="/customer",description="Job Controller",produces ="application/json")
@RequestMapping(path="/job")
public class JobController {



    @Autowired
    private JobRepository jobRepository;

    @GetMapping(value = "/all")
    public List<JobsEntity> findAll () {
        return jobRepository.findAll();
    }

    @GetMapping(value = "/{jobName}")
    public JobsEntity findOne (@PathVariable final String jobName) {
        return jobRepository.findByJobTitle(jobName);
    }

    @GetMapping(value = "/salary/{val}")
    public List<JobsEntity> findSalary (@PathVariable final Integer val) {
        return jobRepository.findByMinSalaryIsAfterOrderByMinSalaryDesc(val);
    }

    @PostMapping(value = "/update", consumes={"application/json"})
    public JobsEntity  updateJob (@RequestBody JobUpdateQuery updateQuery) {
        Optional<JobsEntity> opt = Optional.ofNullable(jobRepository.findByJobId(JobUpdateQuery.getId()));
        if(opt.isPresent()){
            JobsEntity a= opt.get();
            a.setJobTitle(JobUpdateQuery.getNewTitle());
            jobRepository.save(a);
            return a;
        }
        else{
            System.out.println("Error job not existing");
            return null;
        }
    }


    public static class JobUpdateQuery {

        private static String id;
        private static String newTitle;
        public void setId(String id) {
            this.id = id;
        }

        public void setNewTitle(String newTitle) {
            this.newTitle = newTitle;
        }

        public static  String  getId() {
            return id;
        }

        public static String getNewTitle() {
            return newTitle;
        }
    }


}
