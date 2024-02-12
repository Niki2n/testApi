package com.api.ligaInterview.models.requests.element;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;
@Getter
@Setter
public class UpdateElementRequestModel {
    @NotNull
    private Integer id;
    @NotNull
    @Length(max = 100)
    private String name;
    @NotNull
    @Length(max = 255)
    private String url;
    @NotNull
    private Timestamp date;

}
