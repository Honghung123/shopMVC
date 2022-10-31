package com.honghung.dao.inplements;

import com.honghung.dao.ICategory;
import com.honghung.database.DBContext;
import com.honghung.model.Category;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCategory extends DBConnectAbtract implements ICategory {
    @Override
    public List<Category> getAllCategory() {
        String sql  = "Select * from category";
        List<Category> listCat = new ArrayList<>();
        try {
            this.conn =  new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                listCat.add(
                        new Category(
                                Integer.parseInt( resultSet.getString(1)),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        )
                );
            }
            return  listCat;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Category> randomBanner(int id){
        String sql  = "Select * from category ORDER BY RAND() LIMIT ?";
        List<Category> listCat = new ArrayList<>();
        try {
            this.conn =  new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setInt(1,id);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                listCat.add(
                        new Category(
                                Integer.parseInt( resultSet.getString(1)),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        )
                );
            }
            return  listCat;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insertCategory(String catName,String banner) {
        String sql = "Insert into category(catName,catBanner) values(?,?)";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1,catName);
            preparedStmt.setString(2,banner);
            preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateCategory(String name,String banner,int id) {
        String sql = "update category set catName = ? , catBanner = ?  where id = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1,name);
            preparedStmt.setString(2,banner);
            preparedStmt.setInt(3,id);
            preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCategory(int id) {
        String sql = "delete from category  where id = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1,id);
            preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category getCatByName(String name) {
        name = name.toLowerCase();
        String sql = "select * from  category where LOWER(catName) = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1,name);
            this.resultSet = preparedStmt.executeQuery();
            while (this.resultSet.next()){
                return new Category(
                        Integer.parseInt(resultSet.getString(1)),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Category getCatById(int catId) {
        String sql = "select * from  category where id = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1,catId);
            this.resultSet = preparedStmt.executeQuery();
            while (this.resultSet.next()){
                return new Category(
                        Integer.parseInt(resultSet.getString(1)),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
