package com.commerce.project.Controller;

import com.commerce.project.Entities.Product;
import com.commerce.project.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        productService.createProduct(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/expired")
    public ResponseEntity<List<Product>> getProductsByExpired(){
        return ResponseEntity.ok(productService.getProductsByExpired());
    }

    @GetMapping("/notexpired")
    public ResponseEntity<List<Product>> getProductsByNotExpired(){
        return ResponseEntity.ok(productService.getProductsByNotExpired());
    }
}
