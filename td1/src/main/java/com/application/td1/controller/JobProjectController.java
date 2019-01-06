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
@RequestMapping(value = "/jobs")
public class JobProjectController {



    @Autowired
    private JobRepository jobRepository;

    //@PreAuthorize("hasAnyRole('ADMIN')")
    //@RequestMapping(value = "/charge",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    //public String update(Model model) {
    //    model.addAttribute("form", new FormCountry());
    //    return "index";
    //}




    @PreAuthorize("hasAnyRole('ADMIN','ACC_FIN')")
    @RequestMapping(value = "/jobs",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String job (Model model) {
        List<JobsEntity> a = jobRepository.findAll();

        model.addAttribute("job",a);
        model.addAttribute("jobDelete", new FormJob());
        model.addAttribute("jobAdd", new FormJob());
        model.addAttribute("jobEdit", new FormJob());

        return "jobs";

    }
    @PreAuthorize("hasAnyRole('ADMIN','ACC_FIN')")
    @PostMapping(value = "/delete")
    public String delete (@ModelAttribute("jobDelete") FormJob job, Model model) {
        JobsEntity b = jobRepository.findByJobId(job.getJobId());





        jobRepository.delete(b);


        job(model);
        return "jobs";

    }
    @PreAuthorize("hasAnyRole('ADMIN','ACC_FIN')")
    @PostMapping(value = "/add")
    public String add (@ModelAttribute("jobAdd") FormJob job, Model model) {
        String id = job.getJobId();
        Optional<JobsEntity> opt = Optional.ofNullable(jobRepository.findByJobId(id));
        if(opt.isPresent()){
            System.out.println("Error country already exist");

        }
        else{
            JobsEntity a= new JobsEntity();
            a.setJobId(job.getJobId());
            a.setJobTitle(job.getJobTitle());
            a.setMaxSalary(job.getMaxSalary());
            a.setMinSalary(job.getMinSalary());

            jobRepository.save(a);


        }


        job(model);
        return "jobs";
    }
    @PreAuthorize("hasAnyRole('ADMIN','ACC_FIN')")
    @PostMapping(value = "/edit")
    public String edit (@ModelAttribute("jobEdit") FormJob job, Model model) {
        String id = job.getJobId();
        Optional<JobsEntity> opt = Optional.ofNullable(jobRepository.findByJobId(id));
        if (opt.isPresent()) {
            JobsEntity b = opt.get();
            b.setJobId(job.getJobId());
            b.setJobTitle(job.getJobTitle());
            b.setMaxSalary(job.getMaxSalary());
            b.setMinSalary(job.getMinSalary());
            jobRepository.save(b);
        }



        job(model);
        return "jobs";

    }
    public static class FormJob {
        private String jobId;
        private String jobTitle;
        private Integer minSalary;
        private Integer maxSalary;

        public String getJobId() {
            return jobId;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public Integer getMinSalary() {
            return minSalary;
        }

        public Integer getMaxSalary() {
            return maxSalary;
        }

        public void setJobId(String jobId) {
            this.jobId = jobId;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public void setMinSalary(Integer minSalary) {
            this.minSalary = minSalary;
        }

        public void setMaxSalary(Integer maxSalary) {
            this.maxSalary = maxSalary;
        }
    }





}