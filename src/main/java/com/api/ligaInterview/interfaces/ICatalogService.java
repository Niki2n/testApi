package com.api.ligaInterview.interfaces;


import com.api.ligaInterview.entity.CatalogEntity;
import com.api.ligaInterview.models.ServiceResponse;
import com.api.ligaInterview.models.requests.catalog.CreateCatalogRequestModel;
import com.api.ligaInterview.models.requests.catalog.UpdateCatalogRequestModel;

import java.util.List;

public interface ICatalogService {
    ServiceResponse<List<CatalogEntity>> getAll();
    ServiceResponse<CatalogEntity> getBy(Integer id);
    ServiceResponse<List<CatalogEntity>> getBy(String name);
    ServiceResponse<CatalogEntity> create(CreateCatalogRequestModel request);
    ServiceResponse<CatalogEntity> update(UpdateCatalogRequestModel request);
    ServiceResponse delete(Integer id);

}
