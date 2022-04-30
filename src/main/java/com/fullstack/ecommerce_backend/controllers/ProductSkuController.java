package com.fullstack.ecommerce_backend.controllers;

import com.fullstack.ecommerce_backend.common.enums.GenericHttpResponseCode;
import com.fullstack.ecommerce_backend.common.pojos.GenericHttpResponseBody;
import com.fullstack.ecommerce_backend.dtos.productsSkus.AddProductSkuDto;
import com.fullstack.ecommerce_backend.dtos.productsSkus.EditProductSkuDto;
import com.fullstack.ecommerce_backend.models.Product;
import com.fullstack.ecommerce_backend.models.ProductSku;
import com.fullstack.ecommerce_backend.services.ProductSkuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("productSku")
public class ProductSkuController {

    @Autowired
    private ProductSkuService productSkuService;

    @PostMapping("/product/{id}")
    public ResponseEntity<GenericHttpResponseBody<Optional<ProductSku>>> createProductSku(@PathVariable Integer id ,@RequestBody AddProductSkuDto addProductSkuDto){
        ModelMapper modelMapper = new ModelMapper();
        ProductSku productSkuToAdd = modelMapper.map(addProductSkuDto,ProductSku.class);

        Optional<ProductSku> createdProductSku = this.productSkuService.createProductSku(id,productSkuToAdd);
        GenericHttpResponseBody<Optional<ProductSku>> response= new GenericHttpResponseBody<>(GenericHttpResponseCode.Success,createdProductSku);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<GenericHttpResponseBody<Iterable<ProductSku>>> listProductSku(){
        Iterable<ProductSku> productSkus = this.productSkuService.listProductSku();
        GenericHttpResponseBody<Iterable<ProductSku>> response= new GenericHttpResponseBody<>(GenericHttpResponseCode.Success, productSkus);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericHttpResponseBody<Optional<ProductSku>>> getProductSku(@PathVariable Integer id){
        Optional<ProductSku> productSku = this.productSkuService.getProductSku(id);
        GenericHttpResponseBody<Optional<ProductSku>> response= new GenericHttpResponseBody<>(GenericHttpResponseCode.Success, productSku);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<GenericHttpResponseBody<Optional<ProductSku>>> updateProductSku(@RequestBody EditProductSkuDto editProductSkuDto){
        ModelMapper modelMapper = new ModelMapper();
        ProductSku productSkuToEdit = modelMapper.map(editProductSkuDto,ProductSku.class);

        Optional<ProductSku> updatedProduct = this.productSkuService.updateProductSku(productSkuToEdit);
        GenericHttpResponseBody<Optional<ProductSku>> response = new GenericHttpResponseBody<>(GenericHttpResponseCode.Success, updatedProduct);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericHttpResponseBody<Optional<Product>>> deleteProductSku(@PathVariable Integer id){
        this.productSkuService.deleteProductSku(id);
        GenericHttpResponseBody<Optional<Product>> response = new GenericHttpResponseBody<>(GenericHttpResponseCode.Success, Optional.empty());

        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

}
