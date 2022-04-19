package com.example.ecommerce_backend.dtos.products;

import lombok.Data;
import java.io.Serializable;
import java.util.Collection;

@Data
public class EditProductDto implements Serializable {
    private final Integer id;
    private final String name;
    private final Integer price;
    private final Boolean isPublish;
    private final Integer categoryId;
    private final Collection<Integer> skusIds;
}
