package com.honghung.model;

public class Cart {
    private int id;
    private String proName;
    private String proImage;
    private String proPrice;
    private int quantity;

    private int proId;

    public Cart(){}

    public Cart(int id, String proName, String proImage, String proPrice, int quantity , int proId) {
        this.id = id;
        this.proName = proName;
        this.proImage = proImage;
        this.proPrice = proPrice;
        this.quantity = quantity;
        this.proId = proId;
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

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", proName='" + proName + '\'' +
                ", proImage='" + proImage + '\'' +
                ", proPrice='" + proPrice + '\'' +
                ", quantity=" + quantity +
                ", proId=" + proId +
                '}';
    }
}
