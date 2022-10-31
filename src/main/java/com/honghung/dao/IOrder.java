package com.honghung.dao;

import com.honghung.model.Order;

import java.util.List;

public interface IOrder {
    public List<Order> getAllOrder();

    public boolean insertOrder(int proId,int category,int brandId,  String proName, String proImage,  String proPrice, int quantity,String username);

    public int getSumPrice();

    public boolean deleteOrder(int id);
}
