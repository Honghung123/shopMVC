package com.honghung.model;

public class Brand {
    private int id;
    private String brandName;
    private String brandLogo;

    public Brand(){}
    public Brand(int id, String brandName,String brandLogo) {
        this.id = id;
        this.brandName = brandName;
        this.brandLogo = brandLogo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", brandLogo='" + brandLogo + '\'' +
                '}';
    }
}
