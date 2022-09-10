package com.test1;

public class User {
    private String username;
    private String password;
    private String phone;
    private String idNumber;

    public User() {
    }
    //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 夹带一个私货
    public User(String username, String password, String phone, String idNumber) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
