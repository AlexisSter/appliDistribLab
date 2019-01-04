package com.application.td1.repository;

import com.application.td1.model.DepartmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

@RepositoryRestResource(collectionResourceRel = "countries", path = "/country")
@Component
public interface DepartmentRepository extends JpaRepository<DepartmentsEntity, Long> {

    DepartmentsEntity findByDepartmentId(int id);

}
