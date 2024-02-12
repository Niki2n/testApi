package com.api.ligaInterview.mappers;

import com.api.ligaInterview.dtos.CatalogDto;
import com.api.ligaInterview.entity.CatalogEntity;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;
import java.util.List;

@Mapper(uses = ElementMapper.class)
public interface CatalogMapper extends Converter<CatalogEntity, CatalogDto> {
    CatalogDto convert(CatalogEntity source);
    List<CatalogDto> convert(Collection<CatalogEntity> source);
}
