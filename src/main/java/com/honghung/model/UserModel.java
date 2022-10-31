package com.honghung.model;

public class UserModel {
    private int id;
    private String name;
    private String username;
    private String province;
    private String image;
    private String email;
    private String country;
    private String address;
    private String phone;
    private String password;

    public UserModel() {
    }

    public UserModel(int id, String name, String username, String province,String image ,String email, String address, String country, String phone, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.province = province;
        this.image =   image;
        this.email = email;
        this.address = address;
        this.country = country;
        this.phone = phone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String city) {
        this.province = city;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", province='" + province + '\'' +
                ", image='" + image + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
