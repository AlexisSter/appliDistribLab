package com.application.td1.repository;

import java.util.List;

import com.application.td1.model.EmployeesEntity;
import com.application.td1.model.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;


@RepositoryRestResource(collectionResourceRel = "employee", path = "/employee")
@Component
public interface EmployeeRepository extends JpaRepository<EmployeesEntity, Long>{
    List<EmployeesEntity> findAll();

    List<EmployeesEntity> findByFirstName(String val);
    EmployeesEntity findByEmployeeId(Integer val);

}