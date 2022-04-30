package com.fullstack.ecommerce_backend.dtos.productCategories;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddProductCategoryDto implements Serializable {
    private final String name;
    private final Integer parentId;
}
