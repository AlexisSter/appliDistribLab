package com.application.td1.repository;

import com.application.td1.model.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "employee", path = "/employee")
@Component
public interface EmployeeRepository extends JpaRepository<EmployeesEntity, Long>{
    List<EmployeesEntity> findAll();
    List<EmployeesEntity> findByFirstName(String val);
    List<EmployeesEntity> findAllByOrderBySalary();
    EmployeesEntity findByEmployeeId(Integer val);


    Optional<EmployeesEntity> findByEmail(String name);

}