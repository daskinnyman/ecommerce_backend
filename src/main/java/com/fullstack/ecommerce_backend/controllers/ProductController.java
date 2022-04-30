package com.fullstack.ecommerce_backend.controllers;

import com.fullstack.ecommerce_backend.common.enums.GenericHttpResponseCode;
import com.fullstack.ecommerce_backend.common.pojos.GenericHttpResponseBody;
import com.fullstack.ecommerce_backend.dtos.products.AddProductDto;
import com.fullstack.ecommerce_backend.dtos.products.EditProductDto;
import com.fullstack.ecommerce_backend.models.Product;
import com.fullstack.ecommerce_backend.services.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping()
    public ResponseEntity<GenericHttpResponseBody<Product>> createProduct(@RequestBody AddProductDto addProductDto){
        ModelMapper modelMapper = new ModelMapper();
        Product productToAdd = modelMapper.map(addProductDto,Product.class);

        Product productAdded = this.productService.createProduct(productToAdd);
        GenericHttpResponseBody<Product> response = new GenericHttpResponseBody<>(GenericHttpResponseCode.Success,productAdded);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<GenericHttpResponseBody<Iterable<Product>>> listProduct(){
        Iterable<Product> products = this.productService.listProducts();
        GenericHttpResponseBody<Iterable<Product>> response = new GenericHttpResponseBody<>(GenericHttpResponseCode.Success,products);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GenericHttpResponseBody<Optional<Product>>> getProduct(@PathVariable Integer productId){
        Optional<Product> product = this.productService.getProduct(productId);
        GenericHttpResponseBody<Optional<Product>> response = new GenericHttpResponseBody<>(GenericHttpResponseCode.Success,product);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<GenericHttpResponseBody<Optional<Product>>> updateProduct(@RequestBody EditProductDto editProductDto){
        ModelMapper modelMapper = new ModelMapper();
        Product productToEdit = modelMapper.map(editProductDto,Product.class);

        Optional<Product> productEdited = this.productService.updateProduct(productToEdit);
        GenericHttpResponseBody<Optional<Product>> response = new GenericHttpResponseBody<>(GenericHttpResponseCode.Success,productEdited);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<GenericHttpResponseBody<Optional<Product>>> deleteProduct(@PathVariable Integer productId){
        this.productService.deleteProduct(productId);
        GenericHttpResponseBody<Optional<Product>> response = new GenericHttpResponseBody<>(GenericHttpResponseCode.Success,Optional.empty());

        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}
