package com.honghung.dao.inplements;

import com.honghung.dao.IOrder;
import com.honghung.database.DBContext;
import com.honghung.model.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOOrder extends DBConnectAbtract implements IOrder {
    @Override
    public List<Order> getAllOrder() {
        String sql  = "Select * from orders";
        List<Order> listOrder = new ArrayList<>();
        try {
            this.conn =  new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                listOrder.add(
                        new Order(
                                Integer.parseInt( resultSet.getString(1)),
                                Integer.parseInt( resultSet.getString(2)),
                                Integer.parseInt( resultSet.getString(3)),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                Integer.parseInt( resultSet.getString(7)),
                                Integer.parseInt( resultSet.getString(8)),
                                resultSet.getString(9),
                                resultSet.getDate(10),
                                Integer.parseInt( resultSet.getString(11))
                        )
                );
            }
            return  listOrder;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insertOrder(int proId,int category,int brandId,  String proName, String proImage,  String proPrice, int quantity,String username) {
        String sql = "Insert into orders(catId,brandId,proName,proImage,proPrice,quantity,proId,username ) values(?,?,?,?,?,?,?,? )";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1,category);
            preparedStmt.setInt(2,brandId);
            preparedStmt.setString(3,proName);
            preparedStmt.setString(4,proImage);
            preparedStmt.setString(5,proPrice);
            preparedStmt.setInt(6,quantity);
            preparedStmt.setInt(7,proId);
            preparedStmt.setString(8,username);
            preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getSumPrice() {
        String sql = "select  sum(proPrice*quantity) from orders";
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

    @Override
    public boolean deleteOrder(int id) {
        String sql = "Delete from orders where id = ?";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = this.conn.prepareStatement(sql);
            this.preparedStmt.setInt(1,id);
            this.preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

            DAOOrder cart = new DAOOrder();
        System.out.println(cart);
    }
}
