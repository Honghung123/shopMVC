package com.honghung.dao.inplements;

import com.honghung.dao.ICart;
import com.honghung.database.DBContext;
import com.honghung.model.Cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCart extends DBConnectAbtract implements ICart {
    @Override
    public List<Cart> getAllCart() {
        String sql  = "Select * from cart";
        List<Cart> listCart = new ArrayList<>();
        try {
            this.conn =  new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                listCart.add(
                        new Cart(
                                Integer.parseInt( resultSet.getString(1)),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                Integer.parseInt( resultSet.getString(5)),
                                Integer.parseInt( resultSet.getString(6))
                        )
                );
            }
            return  listCart;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insertCart(String proName, String proImage, String proPrice, int quantity,int proId) {
        String sql = "Insert into cart(proName,proImage,proPrice,quantity,proId) values(?,?,?,?,?)";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1,proName);
            preparedStmt.setString(2,proImage);
            preparedStmt.setString(3,proPrice);
            preparedStmt.setInt(4,quantity);
            preparedStmt.setInt(5,proId);
            preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateCart(String proName, String proImage, String proPrice, int quantity, int proId,int id) {
        String sql = "update cart set proName = ?, proImage=?, proPrice = ?,quantity=?, proId = ?   where id = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1,proName);
            preparedStmt.setString(2,proImage);
            preparedStmt.setString(3,proPrice);
            preparedStmt.setInt(4,quantity);
            preparedStmt.setInt(5,proId);
            preparedStmt.setInt(6,id);
            preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCart(int id) {
        String sql = "delete from cart  where id = ?";
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
    public int getSumPrice() {
        String sql = "select  sum(proPrice*quantity) from cart";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = this.conn.prepareStatement(sql);
            this.resultSet = this.preparedStmt.executeQuery();
            while (this.resultSet.next()){
                return this.resultSet.getInt(1);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static void main(String[] args) {

            DAOCart cart = new DAOCart();
            int result = cart.getSumPrice();
        System.out.println(result);
    }
}
