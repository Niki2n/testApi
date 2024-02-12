package com.api.ligaInterview.controllers;

import com.api.ligaInterview.dtos.ElementDto;
import com.api.ligaInterview.entity.ElementEntity;
import com.api.ligaInterview.interfaces.IElementService;
import com.api.ligaInterview.mappers.ElementMapper;
import com.api.ligaInterview.models.requests.element.CreateElementRequestModel;
import com.api.ligaInterview.models.requests.element.UpdateElementRequestModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/element")
@RequiredArgsConstructor
public class ElementController extends BaseController{
    private final IElementService elementService;

    @GetMapping
    public ResponseEntity getAll(){
        var response = elementService.getAll();
        return response.isSuccess() ?
                ResponseEntity.ok().body(mapEntity(response.getResponse()))
                : mapBadServiceResponse(response);
    }
    @GetMapping(value = "/by")
    public ResponseEntity getAll(String name){
        var response = elementService.getBy(name);
        return response.isSuccess() ?
                ResponseEntity.ok().body(mapEntity(response.getResponse()))
                : mapBadServiceResponse(response);
    }

    @PostMapping
    public ResponseEntity createByDetermination(@Valid @RequestBody CreateElementRequestModel request){
        var response = elementService.create(request);
        return response.isSuccess() ?
                ResponseEntity.ok().body(mapEntity(response.getResponse()))
                : mapBadServiceResponse(response);
    }
    @PutMapping
    public ResponseEntity updateByDetermination(@Valid @RequestBody UpdateElementRequestModel request){
        var response = elementService.update(request);
        return response.isSuccess() ?
                ResponseEntity.ok().body(mapEntity(response.getResponse()))
                : mapBadServiceResponse(response);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Integer id){
        var response = elementService.delete(id);
        return response.isSuccess() ?
                ResponseEntity.ok().build()
                : mapBadServiceResponse(response);
    }

    private ElementDto mapEntity(ElementEntity element){
        var mapper = Mappers.getMapper(ElementMapper.class);

        return mapper.convert(element);
    }

    private List<ElementDto> mapEntity(List<ElementEntity> elements){
        var mapper = Mappers.getMapper(ElementMapper.class);

        return elements.stream().map(e -> mapper.convert(e)).toList();
    }
}
