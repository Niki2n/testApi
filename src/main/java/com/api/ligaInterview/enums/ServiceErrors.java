package com.api.ligaInterview.enums;

public enum ServiceErrors {
    NotFound(404),
    ServerError(500),
    Conflict(409);
    public final int code;
    public int value(){
        return code;
    }
    ServiceErrors(int label) {
        this.code = label;
    }
}
