package com.honghung.dao;

import com.honghung.model.Category;

import java.util.List;

public interface ICategory {
    public List<Category> getAllCategory();
    public List<Category> randomBanner(int id);
    public boolean insertCategory(String name,String banner);
    public boolean updateCategory(String name,String banner, int id);
    public boolean deleteCategory(int id);
    public  Category getCatByName(String name);
    public  Category getCatById(int id);
}
