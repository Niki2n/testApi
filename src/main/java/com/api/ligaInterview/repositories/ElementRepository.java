package com.api.ligaInterview.repositories;

import com.api.ligaInterview.entity.ElementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ElementRepository extends CrudRepository<ElementEntity, Integer> {
    List<ElementEntity> findByName(String name);
}
