package com.example.ecommerce_backend.dtos.productCategories;

import com.example.ecommerce_backend.models.ProductCategory;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddProductCategoryDto implements Serializable {
    private final String name;
    private final Integer parentId;
}
