package com.api.ligaInterview.repositories;

import com.api.ligaInterview.entity.CatalogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CatalogRepository extends CrudRepository<CatalogEntity, Integer> {
    List<CatalogEntity> findByNameContaining(String name);
}
