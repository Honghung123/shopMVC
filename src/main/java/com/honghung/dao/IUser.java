package com.honghung.dao;

import com.honghung.model.UserModel;

public  interface   IUser {
    UserModel getUserByUsernameAndPass(String username, String password);
    public UserModel getUserRegisterByUsernameAndPass(String username, String password);
    UserModel getUserById(int id);
    public UserModel getUserRegisterById(int id);
    boolean insertUser(String username, String name, String province,String image, String email, String address, String country, String phone, String password) ;
    boolean insertUserRegister(String username, String name, String province,String image, String email, String address, String country, String phone, String password) ;
    boolean deleteUserRegister( );
}
