package com.fullstack.ecommerce_backend.common.pojos;

import com.fullstack.ecommerce_backend.common.enums.GenericHttpResponseCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericHttpResponseBody<T> {
    private Integer code;
    private T Data;
    private String message = "";

    public GenericHttpResponseBody(GenericHttpResponseCode code, T data){
        this.code = code.getResponseCode();
        this.Data = data;
    }

    public GenericHttpResponseBody(GenericHttpResponseCode code, T data, String message){
        this.code = code.getResponseCode();
        this.Data = data;
        this.message = message;
    }
}
