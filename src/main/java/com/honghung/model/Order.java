package com.honghung.model;

import java.util.Date;

public class Order {
    private int id;
    private int proId;
    private String proName;
    private String proImage;
    private String proPrice;
    private int quantity;

    private int categoryId;
    private int brandId;
    private String username;

    private int status;
    private Date date;
    public Order(){}

    public Order(int id,int categoryId, int brandId, String proName, String proImage, String proPrice, int quantity, int proId,String username,Date date,int status) {
        this.id = id;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.username = username;
        this.proId = proId;
        this.proName = proName;
        this.proImage = proImage;
        this.proPrice = proPrice;
        this.quantity = quantity;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public String getProPrice() {
        return proPrice;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
