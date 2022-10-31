package com.honghung.dao.inplements;

import com.honghung.dao.IProduct;
import com.honghung.database.DBContext;
import com.honghung.model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProduct extends DBConnectAbtract implements IProduct {
    @Override
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from product";
        try{
        this.conn = new DBContext().getConnection();
        this.preparedStmt = conn.prepareStatement(sql);
        this.resultSet = this.preparedStmt.executeQuery();
        while(this.resultSet.next()){
            list.add(new Product(
                    this.resultSet.getInt(1),
                    this.resultSet.getString(2),
                    this.resultSet.getInt(3),
                    this.resultSet.getInt(4),
                    this.resultSet.getString(5),
                    this.resultSet.getString(6),
                    this.resultSet.getString(7),
                    this.resultSet.getString(8),
                    this.resultSet.getInt(9)
            ));
        }
        return list;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getAllProductLimit(int start , int limit) {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from product limit ? , ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setInt(1, start);
            this.preparedStmt.setInt(2,limit);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                list.add(new Product(
                        this.resultSet.getInt(1),
                        this.resultSet.getString(2),
                        this.resultSet.getInt(3),
                        this.resultSet.getInt(4),
                        this.resultSet.getString(5),
                        this.resultSet.getString(6),
                        this.resultSet.getString(7),
                        this.resultSet.getString(8),
                        this.resultSet.getInt(9)
                ));
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getProductsBySearch(String search,int start, int limit) {
        List<Product> list = new ArrayList<>();
        search = "%"+search.toLowerCase()+ "%";
        System.out.println(search);
        String sql = "Select * from product where LOWER(name) like ? order by id desc limit ? , ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setString(1, search);
            this.preparedStmt.setInt(2, start);
            this.preparedStmt.setInt(3,limit);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                list.add(new Product(
                        this.resultSet.getInt(1),
                        this.resultSet.getString(2),
                        this.resultSet.getInt(3),
                        this.resultSet.getInt(4),
                        this.resultSet.getString(5),
                        this.resultSet.getString(6),
                        this.resultSet.getString(7),
                        this.resultSet.getString(8),
                        this.resultSet.getInt(9)
                ));
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getNewestProducts(int amount) {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from product order by id desc limit ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setInt(1,amount);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                list.add(new Product(
                        this.resultSet.getInt(1),
                        this.resultSet.getString(2),
                        this.resultSet.getInt(3),
                        this.resultSet.getInt(4),
                        this.resultSet.getString(5),
                        this.resultSet.getString(6),
                        this.resultSet.getString(7),
                        this.resultSet.getString(8),
                        this.resultSet.getInt(9)
                ));
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getProductsByCatId(int catId) {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from product where category = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setInt(1,catId);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                list.add(new Product(
                        this.resultSet.getInt(1),
                        this.resultSet.getString(2),
                        this.resultSet.getInt(3),
                        this.resultSet.getInt(4),
                        this.resultSet.getString(5),
                        this.resultSet.getString(6),
                        this.resultSet.getString(7),
                        this.resultSet.getString(8),
                        this.resultSet.getInt(9)
                ));
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getProductsByBrand(int brandId) {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from product where brand = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setInt(1,brandId);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                list.add(new Product(
                        this.resultSet.getInt(1),
                        this.resultSet.getString(2),
                        this.resultSet.getInt(3),
                        this.resultSet.getInt(4),
                        this.resultSet.getString(5),
                        this.resultSet.getString(6),
                        this.resultSet.getString(7),
                        this.resultSet.getString(8),
                        this.resultSet.getInt(9)
                ));
            }
            return list;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product getProductById(int id) {
        String sql = "Select * from product where id = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setInt(1,id);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                return new Product(
                        this.resultSet.getInt(1),
                        this.resultSet.getString(2),
                        this.resultSet.getInt(3),
                        this.resultSet.getInt(4),
                        this.resultSet.getString(5),
                        this.resultSet.getString(6),
                        this.resultSet.getString(7),
                        this.resultSet.getString(8),
                        this.resultSet.getInt(9)
                );
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean insertProduct(String name, int category,int brand, String image, String price, String short_desc, String detail_desc, int discount) {
        String sql = "Insert into product(name,category,brand,image,price,short_desc,detail_desc,discount) values(?,?,?,?,?,?,?,?)";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setString(1,name);
            this.preparedStmt.setInt(2,category);
            this.preparedStmt.setInt(3,brand);
            this.preparedStmt.setString(4,image);
            this.preparedStmt.setString(5,price);
            this.preparedStmt.setString(6,short_desc);
            this.preparedStmt.setString(7,detail_desc);
            this.preparedStmt.setInt(8,discount);
           this.preparedStmt.executeUpdate();
           return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateProduct(int id,String name, int category,int brand, String image, String price, String short_desc, String detail_desc, int discount) {
        String sql = "update product set name = ?, category = ? , brand = ? , image = ?, price = ? , short_desc  = ?, detail_desc = ? , discount =?  where id = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setString(1,name);
            this.preparedStmt.setInt(2,category);
            this.preparedStmt.setInt(3,brand);
            this.preparedStmt.setString(4,image);
            this.preparedStmt.setString(5,price);
            this.preparedStmt.setString(6,short_desc);
            this.preparedStmt.setString(7,detail_desc);
            this.preparedStmt.setInt(8,discount);
            this.preparedStmt.setInt(9,id);
            this.preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        String sql = "delete from product where id = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setInt(1,id);
            this.preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getAmountProduct() {
        int amount = 0;
        String sql = "select count(*) from product ";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.resultSet = this.preparedStmt.executeQuery();
            while (this.resultSet.next()){
                amount =  this.resultSet.getInt(1);
                return amount;
            }
            return 0;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
