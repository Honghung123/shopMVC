package com.honghung.dao;

import com.honghung.model.Cart;
import com.honghung.model.Category;

import java.util.List;

public interface ICart {
    public List<Cart> getAllCart();
    public boolean insertCart(String proName, String proImage, String proPrice, int quantity,int proId);
    public boolean updateCart(String proName, String proImage, String proPrice, int quantity,int proId, int id);
    public boolean deleteCart(int id);
    public  int getSumPrice();
}
