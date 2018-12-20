package com.application.td1.repository;

import java.util.List;

import com.application.td1.model.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;


@RepositoryRestResource(collectionResourceRel = "jobs", path = "/job")
    @Component
    public interface JobRepository extends JpaRepository<JobsEntity, Long>{
        List<JobsEntity> findAll();
        JobsEntity findByJobTitle(String name);
        JobsEntity findByJobId(String id);
        List<JobsEntity> findByMinSalaryIsAfterOrderByMinSalaryDesc(Integer val);
    }