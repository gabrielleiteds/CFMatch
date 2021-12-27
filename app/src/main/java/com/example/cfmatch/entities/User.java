package com.example.cfmatch.entities;

public class User {

    public int uid;

    public String email;

    public String password;

    public User (String email, String password) {
        this.email = email;
        this.password = password;
    }

}
