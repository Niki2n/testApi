package com.api.ligaInterview.models;

import com.api.ligaInterview.enums.ServiceErrors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResponse <T>{
    private ErrorModel error;
    private T response;

    public boolean isSuccess(){
        return error == null;
    }

    public ServiceResponse(String errorMessage, ServiceErrors errorCode) {
        this.error = new ErrorModel(errorCode, errorMessage);
    }

    public ServiceResponse(T response) {
        this.response = response;
    }
    /**Success response
     */
    public ServiceResponse() {
    }
}
