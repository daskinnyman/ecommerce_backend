package com.example.ecommerce_backend.services;

import com.example.ecommerce_backend.models.Product;
import com.example.ecommerce_backend.models.ProductSku;
import com.example.ecommerce_backend.repositories.ProductSkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductSkuService {

    @Autowired
    ProductService productService;
    @Autowired
    ProductSkuRepository productSkuRepository;

    public Optional<ProductSku> createProductSku(Integer productId,ProductSku productSkuToAdd){
        Optional<Product> product = this.productService.getProduct(productId);

        ProductSku productSku = new ProductSku();

        if(!product.isPresent()){
            return Optional.empty();
        }

        productSku.setName(productSkuToAdd.getName());
        productSku.setQuantity(productSkuToAdd.getQuantity());
        productSku.setProduct(product.get());
        ProductSku createdProduct = this.productSkuRepository.save(productSku);

        return Optional.of(createdProduct);
    }

    public Iterable<ProductSku> listProductSku(){
        return this.productSkuRepository.findAll();
    }

    public Optional<ProductSku> getProductSku(Integer id){
        return this.productSkuRepository.findById(id);
    }

    public Optional<ProductSku> updateProductSku(ProductSku productSkuToEdit){
        Optional<ProductSku> productSku = this.productSkuRepository.findById(productSkuToEdit.getId());

        if(!productSku.isPresent()){
            return Optional.empty();
        }

        productSkuToEdit.setProduct(productSku.get().getProduct());
        ProductSku updatedProduct = this.productSkuRepository.save(productSkuToEdit);
        return Optional.of(updatedProduct);
    }

    public void deleteProductSku(Integer id){
        Optional<ProductSku> productSku = this.productSkuRepository.findById(id);

        if(!productSku.isPresent()){
            return;
        }

        this.productSkuRepository.delete(productSku.get());
    }
}
