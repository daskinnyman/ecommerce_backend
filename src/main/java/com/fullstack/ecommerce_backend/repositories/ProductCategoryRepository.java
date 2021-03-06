package com.fullstack.ecommerce_backend.repositories;

import com.fullstack.ecommerce_backend.models.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
}