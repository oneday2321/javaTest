package com.test1;

public class User {
    private String username;
    private String password;
    private int phone;
    private String idNumber;

    public User() {
    }

    public User(String username, String password, int phone, String idNumber) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.idNumber = idNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
