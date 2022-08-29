package com.commerce.project.Service;

import com.commerce.project.Entities.Product;
import com.commerce.project.Exception.NotFoundException;
import com.commerce.project.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByExpired(){
        return productRepository.getProductsBySktLessThan(new Date());
    }

    public List<Product> getProductsByNotExpired(){
        List<Product> products = new ArrayList<>();

        List<Product> haveExpireDate = productRepository.getProductsBySktGreaterThan(new Date());
        for (Product item : haveExpireDate) {
            products.add(item);
        }

        List<Product> notHaveExpireDate = productRepository.getProductsBySktIsNull();
        for (Product item: notHaveExpireDate) {
            products.add(item);
        }

        return products;
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }
}
