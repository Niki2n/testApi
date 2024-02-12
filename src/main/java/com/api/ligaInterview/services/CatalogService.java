package com.api.ligaInterview.services;

import com.api.ligaInterview.entity.CatalogEntity;
import com.api.ligaInterview.enums.ServiceErrors;
import com.api.ligaInterview.interfaces.ICatalogService;
import com.api.ligaInterview.models.ServiceResponse;
import com.api.ligaInterview.models.requests.catalog.CreateCatalogRequestModel;
import com.api.ligaInterview.models.requests.catalog.UpdateCatalogRequestModel;
import com.api.ligaInterview.repositories.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CatalogService implements ICatalogService {
    private final CatalogRepository catalogRepository;

    @Override
    public ServiceResponse<List<CatalogEntity>> getAll() {
        var answer = IterableUtils.toList(catalogRepository.findAll());
        if(answer.isEmpty())
            // обычно для существует фабрика для создания ответов
            return new ServiceResponse<>("Empty table", ServiceErrors.NotFound);

        return new ServiceResponse<>(answer);
    }

    @Override
    public ServiceResponse<CatalogEntity> getBy(Integer id) {
        var answer = catalogRepository.findById(id);
        // обычно для существует фабрика для создания ответов
        return answer.map(ServiceResponse::new).orElseGet(() -> new ServiceResponse<>("Empty table", ServiceErrors.NotFound));

    }

    @Override
    public ServiceResponse<List<CatalogEntity>> getBy(String name) {
        var answer = catalogRepository.findByNameContaining(name);
        if(answer.isEmpty())
            // обычно для существует фабрика для создания ответов
            return new ServiceResponse<>("Empty table", ServiceErrors.NotFound);

        return new ServiceResponse<>(answer);
    }

    @Override
    public ServiceResponse<CatalogEntity> create(CreateCatalogRequestModel request) {
        var answer = new CatalogEntity();
        answer.setName(request.getName());
        try {
            catalogRepository.save(answer);
        }catch (DataIntegrityViolationException ex){
            throw ex;
        }
        catch (Exception ex){
            return new ServiceResponse(ex.getMessage());
        }

        return new ServiceResponse<>(answer);
    }

    @Override
    public ServiceResponse<CatalogEntity> update(UpdateCatalogRequestModel request) {
        var answer = catalogRepository.findById(request.getId());
        if(answer.isEmpty())
            return new ServiceResponse("entity not found");

        var element = answer.get();
        element.setName(request.getName());

        try {
            catalogRepository.save(element);
        }catch (DataIntegrityViolationException ex){
            throw ex;
        }
        catch (Exception ex){
            return new ServiceResponse(ex.getMessage());
        }
        return new ServiceResponse<>(element);
    }

    @Override
    public ServiceResponse delete(Integer id) {
        try {
            catalogRepository.deleteById(id);
        }catch (DataIntegrityViolationException ex){
            throw ex;
        }
        catch (Exception ex){
            return new ServiceResponse(ex.getMessage());
        }
        return new ServiceResponse();
    }
}
