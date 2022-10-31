package com.honghung.dao.inplements;

import com.honghung.dao.IBrand;
import com.honghung.database.DBContext;
import com.honghung.model.Brand;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOBrand extends DBConnectAbtract implements IBrand {
    @Override
    public List<Brand> getAllBrand() {
        String sql  = "Select * from brand";
        List<Brand> listBrand = new ArrayList<>();
        try {
            this.conn =  new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                listBrand.add(
                        new Brand(
                                Integer.parseInt( resultSet.getString(1)),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        )
                );
            }
            return  listBrand;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insertBrand(String brandName,String logo) {
        String sql = "Insert into brand(brandName,brandLogo) values(?,?)";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1,brandName);
            preparedStmt.setString(2,logo);
            preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateBrand(String name,String logo,int id) {
        String sql = "update brand set brandName = ? , brandLogo = ?  where id = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1,name);
            preparedStmt.setString(2,logo);
            preparedStmt.setInt(3,id);
            preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean deleteBrand(int id) {
        String sql = "delete from brand  where id = ?";
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
    public Brand getBrandByName(String name) {
        name = name.toLowerCase();
        String sql = "select * from  brand where LOWER(brandName) = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1,name);
            this.resultSet = preparedStmt.executeQuery();
            while (this.resultSet.next()){
                return new Brand(
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

    public Brand getBrandById(int brandId) {
        String sql = "select * from  brand where id = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1,brandId);
            this.resultSet = preparedStmt.executeQuery();
            while (this.resultSet.next()){
                return new Brand(
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

    // Get top amount brands which has the most products
    @Override
    public List<Brand> getTopBrands(int amount) {
        String sql  = "SELECT * from brand where id in (SELECT brand as id  FROM product GROUP BY brand having COUNT(brand)>2 order by COUNT(brand) desc) limit ?";
        List<Brand> listBrand = new ArrayList<>();
        try {
            this.conn =  new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setInt(1,amount);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                listBrand.add(
                        new Brand(
                                Integer.parseInt( resultSet.getString(1)),
                                resultSet.getString(2),
                                resultSet.getString(3)
                        )
                );
            }
            return  listBrand;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
