package com.api.ligaInterview.handlers;

import com.api.ligaInterview.enums.ServiceErrors;
import com.api.ligaInterview.models.ErrorModel;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalSqlExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handleSQLException(DataIntegrityViolationException ex) {
        // Log the exception
        return ResponseEntity
                .status(409)
                .body(new ErrorModel(ServiceErrors.NotFound, ex.getMessage())) ;
    }
}
