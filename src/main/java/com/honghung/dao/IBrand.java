package com.honghung.dao;

import com.honghung.model.Brand;
import com.honghung.model.Category;

import java.util.List;

public interface IBrand {
    public List<Brand> getAllBrand();
    public boolean insertBrand(String name,String logo);
    public boolean updateBrand(String name,String logo,int id);
    public boolean deleteBrand(int id);
    public  Brand getBrandByName(String name);
    public  Brand getBrandById(int id);
    public List<Brand> getTopBrands(int amount);

}
