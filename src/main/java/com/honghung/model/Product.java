package com.honghung.model;

public class Product {
    private int id;
    private String name;
    private int category;
    private int brand;
    private String image;
    private String price;
    private String short_desc;
    private String detail_desc;
    private int discount;

    public Product(){}
    public Product(int id, String name, int category, int brand, String image, String price, String short_desc, String detail_desc, int discount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.image = image;
        this.price = price;
        this.short_desc = short_desc;
        this.detail_desc = detail_desc;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getDetail_desc() {
        return detail_desc;
    }

    public void setDetail_desc(String detail_desc) {
        this.detail_desc = detail_desc;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", image='" + image + '\'' +
                ", price='" + price + '\'' +
                ", short_desc='" + short_desc + '\'' +
                ", detail_desc='" + detail_desc + '\'' +
                ", discount=" + discount +
                '}';
    }
}
