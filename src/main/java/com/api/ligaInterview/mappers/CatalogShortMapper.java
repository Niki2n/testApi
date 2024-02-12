package com.api.ligaInterview.mappers;

import com.api.ligaInterview.dtos.CatalogShortDto;
import com.api.ligaInterview.entity.CatalogEntity;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;
import java.util.List;

@Mapper
public interface CatalogShortMapper extends Converter<CatalogEntity, CatalogShortDto> {
    CatalogShortDto convert(CatalogEntity source);
    List<CatalogShortDto> convert(Collection<CatalogEntity> source);
}
