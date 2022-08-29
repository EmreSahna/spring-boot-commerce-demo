package com.commerce.project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_comment")
public class ProductComment {

    public ProductComment() {
    }

    public ProductComment(String comment, Date commentDate, Product product, User user) {
        this.comment = comment;
        this.commentDate = commentDate;
        this.product = product;
        this.user = user;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(length = 500)
    private String comment;
    private Date commentDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "urunId", nullable = false)
    @JsonIgnore
    private Product product;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kullaniciId", nullable = false)
    @JsonIgnore
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
