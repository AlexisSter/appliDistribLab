package com.application.td1.repository;
import java.util.List;

import com.application.td1.model.CountriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;


@RepositoryRestResource(collectionResourceRel = "countries", path = "/country")
    @Component
    public interface CountryRepository extends JpaRepository<CountriesEntity, Long>{
        List<CountriesEntity> findAll();
        CountriesEntity findByCountryName(String name);
    }

