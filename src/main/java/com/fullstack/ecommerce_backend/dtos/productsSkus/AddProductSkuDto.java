package com.fullstack.ecommerce_backend.dtos.productsSkus;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddProductSkuDto implements Serializable {
    private final String name;
    private final Integer quantity;
}
