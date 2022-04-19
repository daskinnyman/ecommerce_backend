package com.example.ecommerce_backend.dtos.productsSkus;

import lombok.Data;

import java.io.Serializable;

@Data
public class EditProductSkuDto implements Serializable {
    private final Integer id;
    private final String name;
    private final Integer quantity;
}
