package com.commerce.project.Repository;

import com.commerce.project.Entities.Product;
import com.commerce.project.Entities.ProductComment;
import com.commerce.project.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductCommentRepository extends JpaRepository<ProductComment,String> {
    List<ProductComment> findAllByProduct_Id(String productId);
    List<ProductComment> findAllByProduct_IdAndCommentDateGreaterThanAndCommentDateLessThan(String productId, Date startDate, Date endDate);
    List<ProductComment> findAllByUser_Id(String userId);
    List<ProductComment> findAllByUser_IdAndCommentDateGreaterThanAndCommentDateLessThan(String productId, Date startDate, Date endDate);

}
