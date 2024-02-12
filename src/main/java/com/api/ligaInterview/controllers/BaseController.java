package com.api.ligaInterview.controllers;

import com.api.ligaInterview.models.ServiceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    protected ResponseEntity mapBadServiceResponse(ServiceResponse response){
        return
             ResponseEntity
                     .status(response.getError().getCode().value())
                     .body(response.getError().getMessage());

        }
    }

