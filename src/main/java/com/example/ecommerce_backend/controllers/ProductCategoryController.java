package com.example.ecommerce_backend.controllers;

import com.example.ecommerce_backend.common.enums.GenericHttpResponseCode;
import com.example.ecommerce_backend.common.pojos.GenericHttpResponseBody;
import com.example.ecommerce_backend.dtos.productCategories.AddProductCategoryDto;
import com.example.ecommerce_backend.dtos.products.EditProductDto;
import com.example.ecommerce_backend.models.ProductCategory;
import com.example.ecommerce_backend.services.ProductCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("productCategory")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping()
    public ResponseEntity<GenericHttpResponseBody<ProductCategory>> createProductCategory(@RequestBody AddProductCategoryDto addProductCategoryDto){
        ModelMapper modelMapper = new ModelMapper();
        System.out.println(addProductCategoryDto.getName());
        ProductCategory productCategoryToAdd = modelMapper.map(addProductCategoryDto,ProductCategory.class);

        System.out.println(productCategoryToAdd.getName());
        ProductCategory productCategoryAdded = this.productCategoryService.createProductCategory(productCategoryToAdd);
        GenericHttpResponseBody<ProductCategory> response = new GenericHttpResponseBody<>(GenericHttpResponseCode.Success,productCategoryAdded);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<GenericHttpResponseBody<Iterable<ProductCategory>>> listProductCategory(){
        Iterable<ProductCategory> productCategories = this.productCategoryService.listProductCategory();
        GenericHttpResponseBody<Iterable<ProductCategory>> response = new GenericHttpResponseBody<>(GenericHttpResponseCode.Success, productCategories);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericHttpResponseBody<Optional<ProductCategory>>> getProductCategory(@PathVariable Integer id){
        Optional<ProductCategory> productCategory = this.productCategoryService.getProductCategory(id);
        GenericHttpResponseBody<Optional<ProductCategory>> response = new GenericHttpResponseBody<>(GenericHttpResponseCode.Success, productCategory);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<GenericHttpResponseBody<Optional<ProductCategory>>> updateProductCategory(@RequestBody EditProductDto editProductDto){
        ModelMapper modelMapper = new ModelMapper();
        ProductCategory productCategoryToEdit = modelMapper.map(editProductDto,ProductCategory.class);

        Optional<ProductCategory> updatedProductCategory = this.productCategoryService.updateProductCategory(productCategoryToEdit);
        GenericHttpResponseBody<Optional<ProductCategory>> response = new GenericHttpResponseBody<>(GenericHttpResponseCode.Success,updatedProductCategory);

        return  new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericHttpResponseBody<Optional<ProductCategory>>> deleteProductCategory(@PathVariable Integer id){
        this.productCategoryService.deleteProductCategory((id));
        GenericHttpResponseBody<Optional<ProductCategory>> response = new GenericHttpResponseBody<>(GenericHttpResponseCode.Success,Optional.empty());

        return  new ResponseEntity<>(response,HttpStatus.OK);
    }
}
