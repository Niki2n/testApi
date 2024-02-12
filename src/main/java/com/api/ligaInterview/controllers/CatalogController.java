package com.api.ligaInterview.controllers;

import com.api.ligaInterview.entity.CatalogEntity;
import com.api.ligaInterview.interfaces.ICatalogService;
import com.api.ligaInterview.mappers.CatalogMapper;
import com.api.ligaInterview.mappers.CatalogShortMapper;
import com.api.ligaInterview.models.requests.catalog.CreateCatalogRequestModel;
import com.api.ligaInterview.models.requests.catalog.UpdateCatalogRequestModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor
public class CatalogController extends BaseController{
    private final ICatalogService catalogService;

    @GetMapping(value = "list")
    public ResponseEntity getAll(){
        var response = catalogService.getAll();
        return response.isSuccess() ?
                ResponseEntity.ok().body(mapEntity(response.getResponse(), true))
                : mapBadServiceResponse(response);
    }
    @GetMapping()
    public ResponseEntity get(Integer id){
        var response = catalogService.getBy(id);
        return response.isSuccess() ?
                ResponseEntity.ok().body(mapEntity(response.getResponse(), false))
                : mapBadServiceResponse(response);
    }
    @GetMapping(value = "/by")
    public ResponseEntity getAll(String name){
        var response = catalogService.getBy(name);
        return response.isSuccess() ?
                ResponseEntity.ok().body(mapEntity(response.getResponse(), false))
                : mapBadServiceResponse(response);
    }

    @PostMapping
    public ResponseEntity createByDetermination(@Valid @RequestBody CreateCatalogRequestModel request){
        var response = catalogService.create(request);
        return response.isSuccess() ?
                ResponseEntity.ok().body(mapEntity(response.getResponse(), false))
                : mapBadServiceResponse(response);
    }
    @PutMapping
    public ResponseEntity updateByDetermination(@Valid @RequestBody UpdateCatalogRequestModel request){
        var response = catalogService.update(request);
        return response.isSuccess() ?
                ResponseEntity.ok().body(mapEntity(response.getResponse(), false))
                : mapBadServiceResponse(response);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Integer id){
        var response = catalogService.delete(id);
        return response.isSuccess() ?
                ResponseEntity.ok().build()
                : mapBadServiceResponse(response);
    }

    private Object mapEntity(CatalogEntity catalog, boolean isShort){
        var mapper = isShort ? Mappers.getMapper(CatalogShortMapper.class)
                :
                Mappers.getMapper(CatalogMapper.class);

        return mapper.convert(catalog);
    }

    private List<?> mapEntity(List<CatalogEntity> elements, boolean isShort){
        var mapper = isShort ? Mappers.getMapper(CatalogShortMapper.class)
                :
                Mappers.getMapper(CatalogMapper.class);

        return elements.stream().map(e -> mapper.convert(e)).toList();
    }
}
