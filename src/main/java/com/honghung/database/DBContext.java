package com.honghung.database;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private  final String hostName  = "localhost";
    private  final String port = "3306";
    private final  String user = "root";
    private final String pass = "";
    private  final String databaseName = "jdbc_shopmvc";
    public  Connection  getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://"+hostName+":"+port+"/"+databaseName;
            return DriverManager.getConnection(url,user, pass);
        }catch (Exception e){
             e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DBContext dbContext = new DBContext();
        try {
            Connection con = dbContext.getConnection();
            if(con != null){
                System.out.println("Success");
            }else{
                System.out.println("Failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
