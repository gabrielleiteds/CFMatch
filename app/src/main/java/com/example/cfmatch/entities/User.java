package com.example.cfmatch.entities;

import java.io.Serializable;

public class User implements Serializable {

    public int id;
    public String name;
    public String email;
    public String password;
    public String description;

    public User () {

    }

    public User (String email, String password, String name, String description) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.description = description;
    }

}
