package com.fullstack.ecommerce_backend.common.enums;

public enum GenericHttpResponseCode {
    Success(0),
    Failed(1);

    private final Integer responseCode;
    GenericHttpResponseCode(Integer responseCode){
        this.responseCode = responseCode;
    }

    public Integer getResponseCode(){
        return this.responseCode;
    }
}
