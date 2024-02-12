package com.api.ligaInterview.mappers;

import com.api.ligaInterview.dtos.ElementDto;
import com.api.ligaInterview.entity.ElementEntity;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;
import java.util.List;

@Mapper
public interface ElementMapper extends Converter<ElementEntity, ElementDto> {
    ElementDto convert(ElementEntity source);
    List<ElementDto> convert(Collection<ElementEntity> source);
}
