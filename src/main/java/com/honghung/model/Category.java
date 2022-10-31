package com.honghung.model;

public class Category {
    private int id;
    private String categoryName;
 private String catBanner;
    public Category(){}
    public Category(int id, String categoryName,String catBanner) {
        this.id = id;
        this.categoryName = categoryName;
        this.catBanner = catBanner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCatBanner() {
        return catBanner;
    }

    public void setCatBanner(String catBanner) {
        this.catBanner = catBanner;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
