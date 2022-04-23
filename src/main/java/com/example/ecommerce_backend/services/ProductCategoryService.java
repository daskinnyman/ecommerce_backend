package com.example.ecommerce_backend.services;

import com.example.ecommerce_backend.models.ProductCategory;
import com.example.ecommerce_backend.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    public ProductCategory createProductCategory(ProductCategory productCategoryToAdd){
        return this.productCategoryRepository.save(productCategoryToAdd);
    }

    public Iterable<ProductCategory> listProductCategory(){
        return this.productCategoryRepository.findAll();
    }

    public Optional<ProductCategory> getProductCategory(Integer id){
        return this.productCategoryRepository.findById(id);
    }

    public Optional<ProductCategory> updateProductCategory(ProductCategory productCategoryToEdit){
        Optional<ProductCategory> productCategory = this.productCategoryRepository.findById(productCategoryToEdit.getId());

        if(!productCategory.isPresent()){
            return Optional.empty();
        }

        ProductCategory updatedProductCategory = this.productCategoryRepository.save(productCategoryToEdit);

        return  Optional.of(updatedProductCategory);
    }

    public void deleteProductCategory(Integer id){
        Optional<ProductCategory> productCategory = this.productCategoryRepository.findById(id);

        if(!productCategory.isPresent()){
            return;
        }

        this.productCategoryRepository.delete(productCategory.get());
    }
}
