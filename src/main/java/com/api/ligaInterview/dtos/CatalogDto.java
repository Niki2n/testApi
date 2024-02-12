package com.api.ligaInterview.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CatalogDto {
    private Integer id;
    private String name;
    private List<ElementDto> elements;
}
