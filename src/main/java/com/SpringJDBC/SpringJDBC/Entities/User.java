package com.SpringJDBC.SpringJDBC.Entities;

import java.sql.Date;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private Date date_of_account_creation;

    public User(){}

    public User(String name, String email, String password) {
        java.util.Date date = new java.util.Date();
        this.id = name+email+password;
        this.name = name;
        this.email = email;
        this.password = password;
        this.date_of_account_creation = Date.valueOf(""+(date.getYear()+1900)+"-"+date.getMonth()+"-"+date.getDay());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate_of_account_creation() {
        return date_of_account_creation;
    }

    public void setDate_of_account_creation(Date date_of_account_creation) {
        this.date_of_account_creation = date_of_account_creation;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", date_of_account_creation=" + date_of_account_creation +
                '}';
    }
}
