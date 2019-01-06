package com.application.td1.repository;

import java.util.List;
import java.util.Optional;

import com.application.td1.model.EmployeesEntity;
import com.application.td1.model.JobsEntity;
import com.application.td1.model.Role;
import com.application.td1.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;


@RepositoryRestResource(collectionResourceRel = "users", path = "/users")
@Component
public interface RoleRepository extends JpaRepository<Role, Long>{


    Role findByRole(String username);
}