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

    public void createProductSku(Integer productId,ProductSku productSkuToAdd){
        Optional<Product> product = this.productService.getProduct(productId);

        ProductSku productSku = new ProductSku();

        if(!product.isPresent()){
            return;
        }

        productSku.setName(productSkuToAdd.getName());
        productSku.setQuantity(productSkuToAdd.getQuantity());
        productSku.setProduct(product.get());

        this.productSkuRepository.save(productSku);
    }

    public Iterable<ProductSku> listProductSku(){
        return this.productSkuRepository.findAll();
    }

    public Optional<ProductSku> getProductSku(Integer id){
        return this.productSkuRepository.findById(id);
    }

    public void updateProductSku(ProductSku productSkuToEdit){
        Optional<ProductSku> productSku = this.productSkuRepository.findById(productSkuToEdit.getId());

        if(!productSku.isPresent()){
            return;
        }

        productSkuToEdit.setProduct(productSku.get().getProduct());
        this.productSkuRepository.save(productSkuToEdit);
    }

    public void deleteProductSku(Integer id){
        Optional<ProductSku> productSku = this.productSkuRepository.findById(id);

        if(!productSku.isPresent()){
            return;
        }

        this.productSkuRepository.delete(productSku.get());
    }
}
