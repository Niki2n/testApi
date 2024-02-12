package com.api.ligaInterview.models.requests.catalog;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCatalogRequestModel extends CreateCatalogRequestModel{
    @NotNull
    private Integer id;
}
