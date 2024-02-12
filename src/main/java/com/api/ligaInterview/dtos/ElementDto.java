package com.api.ligaInterview.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
public class ElementDto {
    private Integer id;
    private String name;
    private String url;
    private Timestamp date;
}
