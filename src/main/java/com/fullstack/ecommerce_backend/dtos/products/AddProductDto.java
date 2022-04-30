package com.fullstack.ecommerce_backend.dtos.products;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddProductDto implements Serializable {
    private final String name;
    private final Integer price;
    private final Boolean isPublish;
}
