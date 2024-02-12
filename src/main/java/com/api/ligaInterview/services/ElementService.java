package com.api.ligaInterview.services;



import com.api.ligaInterview.entity.CatalogEntity;
import com.api.ligaInterview.entity.ElementEntity;
import com.api.ligaInterview.enums.ServiceErrors;
import com.api.ligaInterview.interfaces.IElementService;
import com.api.ligaInterview.models.ServiceResponse;
import com.api.ligaInterview.models.requests.element.CreateElementRequestModel;
import com.api.ligaInterview.models.requests.element.UpdateElementRequestModel;
import com.api.ligaInterview.repositories.ElementRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ElementService implements IElementService {
    private final ElementRepository elementRepository;

    @Override
    public ServiceResponse<List<ElementEntity>> getAll() {
        var answer = IterableUtils.toList(elementRepository.findAll());
        if(answer.isEmpty())
            // обычно для существует фабрика для создания ответов
            return new ServiceResponse<>("Empty table", ServiceErrors.NotFound);

        return new ServiceResponse<>(answer);
    }

    @Override
    public ServiceResponse<ElementEntity> getBy(Integer id) {
        var answer = elementRepository.findById(id);
        // обычно для существует фабрика для создания ответов
        return answer.map(ServiceResponse::new).orElseGet(() -> new ServiceResponse<>("Empty table", ServiceErrors.NotFound));

    }

    @Override
    public ServiceResponse<List<ElementEntity>> getBy(String name) {
        var answer = elementRepository.findByName(name);
        if(answer.isEmpty())
            // обычно для существует фабрика для создания ответов
            return new ServiceResponse<>("Empty table", ServiceErrors.NotFound);

        return new ServiceResponse<>(answer);
    }

    @Override
    public ServiceResponse<ElementEntity> create(CreateElementRequestModel request) {
        var answer = new ElementEntity();
        answer.setCatalog(new CatalogEntity(request.getCatalogId()));
        answer.setName(request.getName());
        answer.setUrl(request.getUrl());
        answer.setDate(request.getDate());
        try {
            elementRepository.save(answer);
        }catch (DataIntegrityViolationException ex){
            throw ex;
        }
        catch (Exception ex){
            return new ServiceResponse(ex.getMessage());
        }

        return new ServiceResponse<>(answer);
    }

    @Override
    public ServiceResponse<ElementEntity> update(UpdateElementRequestModel request) {
        var answer = elementRepository.findById(request.getId());
        if(answer.isEmpty())
            return new ServiceResponse("entity not found");

        var element = answer.get();
        element.setDate(request.getDate());
        element.setName(request.getName());
        element.setUrl(request.getUrl());

        try {
            elementRepository.save(element);
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
            elementRepository.deleteById(id);
        }catch (DataIntegrityViolationException ex){
            throw ex;
        }
        catch (Exception ex){
            return new ServiceResponse(ex.getMessage());
        }
        return new ServiceResponse();
    }
}
