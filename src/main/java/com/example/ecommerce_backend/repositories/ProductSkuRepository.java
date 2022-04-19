package com.example.ecommerce_backend.repositories;

import com.example.ecommerce_backend.models.ProductSku;
import org.springframework.data.repository.CrudRepository;

public interface ProductSkuRepository extends CrudRepository<ProductSku, Integer> {
}