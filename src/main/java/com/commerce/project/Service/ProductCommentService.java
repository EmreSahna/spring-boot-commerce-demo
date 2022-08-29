package com.commerce.project.Service;

import com.commerce.project.Dto.ProductCommentDto;
import com.commerce.project.Entities.Product;
import com.commerce.project.Entities.ProductComment;
import com.commerce.project.Entities.User;
import com.commerce.project.Exception.NotFoundException;
import com.commerce.project.Repository.ProductCommentRepository;
import com.commerce.project.Repository.ProductRepository;
import com.commerce.project.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductCommentService {
    private final ProductCommentRepository productCommentRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductCommentService(ProductCommentRepository productCommentRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.productCommentRepository = productCommentRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public List<ProductComment> getCommentsByProduct(String productId){
        Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product not found."));
        return productCommentRepository.findAllByProduct_Id(product.getId());
    }

    public List<ProductComment> getCommentsByProductAndTimePeriod(String productId, Date startDate, Date endDate){
        Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product not found."));
        return productCommentRepository.findAllByProduct_IdAndCommentDateGreaterThanAndCommentDateLessThan(productId,startDate,endDate);
    }

    public List<ProductComment> getCommentsByUser(String userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found."));
        return productCommentRepository.findAllByUser_Id(user.getId());
    }

    public List<ProductComment> getCommentsByUserAndTimePeriod(String userId, Date startDate, Date endDate){
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found."));
        return productCommentRepository.findAllByUser_IdAndCommentDateGreaterThanAndCommentDateLessThan(userId,startDate,endDate);
    }

    public void createProductComment(ProductCommentDto productComment) {
        ProductComment productCommentReal = new ProductComment();
        productCommentReal.setComment(productComment.getComment());
        productCommentReal.setCommentDate(productComment.getCommentDate());
        productCommentReal.setUser(userRepository.findById(productComment.getKullanici_id()).orElseThrow(() -> new NotFoundException("User not found!")));
        productCommentReal.setProduct(productRepository.findById(productComment.getUrun_id()).orElseThrow(() -> new NotFoundException("Product not found!")));
        productCommentRepository.save(productCommentReal);
    }
}
