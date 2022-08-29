package com.commerce.project.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product {

    public Product() {
    }

    public Product(String name, Integer price, Date skt) {
        this.name = name;
        this.price = price;
        this.skt = skt;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;
    private Integer price;

    @Column(nullable = true)
    private Date skt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getSkt() {
        return skt;
    }

    public void setSkt(Date skt) {
        this.skt = skt;
    }
}
