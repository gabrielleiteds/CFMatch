package com.example.cfmatch.entities;

public class User {

    private String email;
    private String password;

    User (String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail () {
        return this.email;
    }

    public String getPassword () {
        return this.password;
    }

}
