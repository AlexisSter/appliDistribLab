package com.application.td1.controller;

import com.application.td1.model.JobsEntity;
import com.application.td1.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
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

        static String id;
        static String newTitle;

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
