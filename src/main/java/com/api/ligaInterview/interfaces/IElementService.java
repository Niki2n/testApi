package com.api.ligaInterview.interfaces;


import com.api.ligaInterview.entity.ElementEntity;
import com.api.ligaInterview.models.ServiceResponse;
import com.api.ligaInterview.models.requests.element.CreateElementRequestModel;
import com.api.ligaInterview.models.requests.element.UpdateElementRequestModel;

import java.util.List;

public interface IElementService {
    ServiceResponse<List<ElementEntity>> getAll();
    ServiceResponse<ElementEntity> getBy(Integer id);
    ServiceResponse<List<ElementEntity>> getBy(String name);
    ServiceResponse<ElementEntity> create(CreateElementRequestModel request);
    ServiceResponse<ElementEntity> update(UpdateElementRequestModel request);
    ServiceResponse delete(Integer id);

}
