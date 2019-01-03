package com.application.td1.repository;

import com.application.td1.model.CountriesEntity;
import com.application.td1.model.LocationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "countries", path = "/country")
@Component
public interface LocationRepository extends JpaRepository<LocationsEntity, Long> {


    LocationsEntity findByLocationId(int id);
    List<LocationsEntity> findByCountryId(CountriesEntity id);
}
