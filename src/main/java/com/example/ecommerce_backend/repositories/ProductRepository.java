package com.example.ecommerce_backend.repositories;

import com.example.ecommerce_backend.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}