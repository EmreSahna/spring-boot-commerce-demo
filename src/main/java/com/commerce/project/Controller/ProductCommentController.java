package com.commerce.project.Controller;

import com.commerce.project.Dto.ProductCommentDto;
import com.commerce.project.Entities.ProductComment;
import com.commerce.project.Service.ProductCommentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/comment_product")
public class ProductCommentController {
    private final ProductCommentService productCommentService;

    public ProductCommentController(ProductCommentService productCommentService) {
        this.productCommentService = productCommentService;
    }

    @PostMapping
    public ResponseEntity<ProductCommentDto> createCommentProduct(@RequestBody ProductCommentDto productComment){
        productCommentService.createProductComment(productComment);
        return ResponseEntity.ok(productComment);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductComment>> getProductComments(@PathVariable String productId){
        return ResponseEntity.ok(productCommentService.getCommentsByProduct(productId));
    }

    @GetMapping("/product/{productId}/{startDate}/{endDate}")
    public ResponseEntity<List<ProductComment>> getProductCommentsByDate(@PathVariable String productId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return ResponseEntity.ok(productCommentService.getCommentsByProductAndTimePeriod(productId,startDate,endDate));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProductComment>> getUserComments(@PathVariable String userId){
        return ResponseEntity.ok(productCommentService.getCommentsByUser(userId));
    }

    @GetMapping("/user/{userId}/{startDate}/{endDate}")
    public ResponseEntity<List<ProductComment>> getUserCommentsByDate(@PathVariable String userId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return ResponseEntity.ok(productCommentService.getCommentsByUserAndTimePeriod(userId,startDate,endDate));
    }
}
