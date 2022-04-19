package com.example.ecommerce_backend.controllers;

import com.example.ecommerce_backend.dtos.productsSkus.AddProductSkuDto;
import com.example.ecommerce_backend.dtos.productsSkus.EditProductSkuDto;
import com.example.ecommerce_backend.models.ProductSku;
import com.example.ecommerce_backend.services.ProductSkuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("productSku")
public class ProductSkuController {

    @Autowired
    private ProductSkuService productSkuService;

    @ResponseBody
    @PostMapping("/product/{id}")
    public void createProductSku(@PathVariable Integer id ,@RequestBody AddProductSkuDto addProductSkuDto){
        ModelMapper modelMapper = new ModelMapper();
        ProductSku productSkuToAdd = modelMapper.map(addProductSkuDto,ProductSku.class);
        this.productSkuService.createProductSku(id,productSkuToAdd);
    }
    @GetMapping()
    public Iterable<ProductSku> listProductSku(){
        return this.productSkuService.listProductSku();
    }

    @GetMapping("/{id}")
    public Optional<ProductSku> getProductSku(@PathVariable Integer id){
        return this.productSkuService.getProductSku(id);
    }

    @PutMapping()
    public void updateProductSku(@RequestBody EditProductSkuDto editProductSkuDto){
        ModelMapper modelMapper = new ModelMapper();
        ProductSku productSkuToEdit = modelMapper.map(editProductSkuDto,ProductSku.class);
        this.productSkuService.updateProductSku(productSkuToEdit);
    }

    @DeleteMapping("/{id}")
    public void deleteProductSku(@PathVariable Integer id){
        this.productSkuService.deleteProductSku(id);
    }

}
