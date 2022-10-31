package com.honghung.dao;

import com.honghung.model.Product;

import java.util.List;

public interface IProduct {
    public List<Product> getAllProduct();
    public List<Product> getAllProductLimit(int start, int limit);
    public List<Product> getNewestProducts(int amount);
    public List<Product> getProductsByBrand(int brandId);
    public List<Product> getProductsBySearch(String search, int start , int limit);
    public Product getProductById(int id) ;
    public List<Product> getProductsByCatId(int catId);
    public boolean insertProduct(String name,int category, int brand ,String image, String price, String short_desc,String detail_desc,int discount );
    public boolean updateProduct(int id,String name, int category, int brand, String image, String price, String short_desc, String detail_desc, int discount);
   public  boolean deleteProduct(int id);
   public  int getAmountProduct();
}
