package com.main.project.java.Service;

import com.main.project.java.Entity.Product;
import com.main.project.java.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();

    }
    public void saveProduct(Product product){
        this.productRepository.save(product);

    }
    public Product getProductById(int productId){
        Optional<Product> optional = productRepository.findById(productId);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException("---------- Product not found---------- " + productId);
        }
        return product;
    }

    public void deleteProductById(int productId){
        this.productRepository.deleteById(productId);

    }
}
