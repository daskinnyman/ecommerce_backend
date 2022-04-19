package com.example.ecommerce_backend.controllers;

import com.example.ecommerce_backend.models.ProductCategory;
import com.example.ecommerce_backend.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @GetMapping()
    public Iterable<ProductCategory> getCategories(){
        return this.productCategoryRepository.findAll();
    }
}
