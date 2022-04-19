package com.example.ecommerce_backend.controllers;

import com.example.ecommerce_backend.dtos.products.AddProductDto;
import com.example.ecommerce_backend.dtos.products.EditProductDto;
import com.example.ecommerce_backend.models.Product;
import com.example.ecommerce_backend.services.ProductService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping()
    public Product createProduct(@RequestBody AddProductDto addProductDto){
        ModelMapper modelMapper = new ModelMapper();
        Product productToAdd = modelMapper.map(addProductDto,Product.class);
        return this.productService.createProduct(productToAdd);
    }

    @GetMapping()
    public Iterable<Product> listProduct(){
       return this.productService.listProducts();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable Integer productId){
        return this.productService.getProduct(productId);
    }

    @PutMapping("/{productId}")
    public void updateProduct(@PathVariable Integer productId, @RequestBody EditProductDto editProductDto){
        ModelMapper modelMapper = new ModelMapper();
        Product productToEdit = modelMapper.map(editProductDto,Product.class);
        this.productService.updateProduct(productId, productToEdit);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Integer productId){
        this.productService.deleteProduct(productId);
    }
}
