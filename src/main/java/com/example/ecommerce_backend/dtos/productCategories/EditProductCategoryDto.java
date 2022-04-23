package com.example.ecommerce_backend.dtos.productCategories;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
public class EditProductCategoryDto implements Serializable {
    private final Integer id;
    private final String name;
    private final Integer parentId;
    private final Collection<Integer> childIds;
}
