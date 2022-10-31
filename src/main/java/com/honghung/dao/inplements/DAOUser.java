package com.honghung.dao.inplements;

import com.honghung.dao.IUser;
import com.honghung.database.DBContext;
import com.honghung.model.UserModel;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOUser extends DBConnectAbtract implements IUser {
    @Override
    public UserModel getUserByUsernameAndPass(String username, String email) {
        String sql  = "Select * from user_account where username = ? or email = ? limit 1";
        try {
            this.conn =  new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setString(1,username);
            this.preparedStmt.setString(2,email);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                return new UserModel(
                        Integer.parseInt( resultSet.getString(1)),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public UserModel getUserRegisterByUsernameAndPass(String username, String password) {
        String sql  = "Select * from user_register where username = ? and password = ?";
        try {
            this.conn =  new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setString(1,username);
            this.preparedStmt.setString(2,password);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                return new UserModel(
                        Integer.parseInt( resultSet.getString(1)),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public UserModel getUserById(int id) {
        String sql  = "Select * from user_account where id = ?";
        try {
            this.conn =  new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setInt(1,id);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                return new UserModel(
                        Integer.parseInt( resultSet.getString(1)),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public UserModel getUserRegisterById(int id) {
        String sql  = "Select * from user_register where id = ?";
        try {
            this.conn =  new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setInt(1,id);
            this.resultSet = this.preparedStmt.executeQuery();
            while(this.resultSet.next()){
                return new UserModel(
                        Integer.parseInt( resultSet.getString(1)),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean insertUser(String username, String name, String province,String image, String email, String address, String country, String phone, String password) {
        String sql = "insert into user_account(username,name,province,image,email,address,country, phone,password) values (?,?,?,?,?,?,?,?,?)";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setString(1,username);
            this.preparedStmt.setString(2,name);
            this.preparedStmt.setString(3,province);
            this.preparedStmt.setString(4,image);
            this.preparedStmt.setString(5,email);
            this.preparedStmt.setString(6,address);
            this.preparedStmt.setString(7,country);
            this.preparedStmt.setString(8,phone);
            this.preparedStmt.setString(9,password);
            preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean insertUserRegister(String username, String name, String province,String image ,String email, String address, String country, String phone, String password) {
        String sql = "insert into user_register(username,name,province,image,email,address,country, phone,password) values (?,?,?,?,?,?,?,?,?)";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            this.preparedStmt.setString(1,username);
            this.preparedStmt.setString(2,name);
            this.preparedStmt.setString(3,province);
            this.preparedStmt.setString(4,image);
            this.preparedStmt.setString(5,email);
            this.preparedStmt.setString(6,address);
            this.preparedStmt.setString(7,country);
            this.preparedStmt.setString(8,phone);
            this.preparedStmt.setString(9,password);
            preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean deleteUserRegister() {
        String sql = "delete from user_register  ";
        try{
            this.conn = new DBContext().getConnection();
            this.preparedStmt = conn.prepareStatement(sql);
            preparedStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        UserModel userModel = new DAOUser().getUserByUsernameAndPass("hung","hung");
        System.out.println(userModel);
    }
}
