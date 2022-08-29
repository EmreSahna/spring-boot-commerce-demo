package com.commerce.project.Dto;


import javax.persistence.Column;
import java.util.Date;


public class ProductCommentDto {

    public ProductCommentDto() {
    }

    public ProductCommentDto(String comment, Date commentDate, String urun_id, String kullanici_id) {
        this.comment = comment;
        this.commentDate = commentDate;
        this.urun_id = urun_id;
        this.kullanici_id = kullanici_id;
    }

    private String comment;
    private Date commentDate;
    private String urun_id;
    private String kullanici_id;

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

    public String getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(String urun_id) {
        this.urun_id = urun_id;
    }

    public String getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(String kullanici_id) {
        this.kullanici_id = kullanici_id;
    }
}
