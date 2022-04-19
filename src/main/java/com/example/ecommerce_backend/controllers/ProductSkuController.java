package com.example.ecommerce_backend.controllers;

import com.example.ecommerce_backend.models.ProductSku;
import com.example.ecommerce_backend.repositories.ProductSkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("productSku")
public class ProductSkuController {

    @Autowired
    private ProductSkuRepository productSkuRepository;

    @GetMapping()
    public Iterable<ProductSku> getProductSkus(){
        return this.productSkuRepository.findAll();
    }
}
