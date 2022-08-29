package com.commerce.project.Repository;

import com.commerce.project.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> getProductsBySktLessThan(Date time);
    List<Product> getProductsBySktGreaterThan(Date time);
    List<Product> getProductsBySktIsNull();
}
