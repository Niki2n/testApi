package com.api.ligaInterview.models;

import com.api.ligaInterview.enums.ServiceErrors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorModel {
    private ServiceErrors code;
    private String message;

    public ErrorModel(ServiceErrors code, String message) {
        this.code = code;
        this.message = message;
    }
}
