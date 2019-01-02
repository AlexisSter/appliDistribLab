package com.application.td1.repository;

import com.application.td1.model.CountriesEntity;
import com.application.td1.model.LocationsEntity;
import com.application.td1.model.RegionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "countries", path = "/country")
@Component
public interface RegionRepository extends JpaRepository<RegionsEntity, Long> {

    List<RegionsEntity> findAll();
    RegionsEntity findByRegionId(int a);
    RegionsEntity findByRegionName(String regionName);

}
