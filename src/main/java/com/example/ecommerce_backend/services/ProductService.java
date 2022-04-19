package com.example.ecommerce_backend.services;

import com.example.ecommerce_backend.models.Product;
import com.example.ecommerce_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product productToAdd){
        return this.productRepository.save(productToAdd);
    }
    public Iterable<Product> listProducts(){
        return this.productRepository.findAll();
    }

    public Optional<Product> getProduct(Integer id){
        return this.productRepository.findById(id);
    }

    public void updateProduct(Integer productId, Product productToEdit){
        Optional<Product> product = this.getProduct(productId);
        if(!product.isPresent()){
           return;
        }

        this.productRepository.save(productToEdit);
    }

    public void deleteProduct(Integer id){
        Optional<Product> product =  this.getProduct(id);

        if(!product.isPresent()){
            return;
        }

        this.productRepository.delete(product.get());
    }


}
