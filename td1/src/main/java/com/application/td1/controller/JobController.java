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
        Optional<JobsEntity> opt = jobRepository.findById(JobUpdateQuery.getId());
        if(opt.isPresent()){
            opt.get();
            jobRepository.save(opt);
        }
        else{
            System.out.println("Error job not existing");
            return null;
        }

    }


    public static class JobUpdateQuery {

        String id;
        String newTitle;

        public void setId(String id) {
            this.id = id;
        }

        public void setNewTitle(String newTitle) {
            this.newTitle = newTitle;
        }

        public String getId() {
            return id;
        }

        public String getNewTitle() {
            return newTitle;
        }
    }


}
