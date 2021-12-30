package com.example.cfmatch.entities;

import com.example.cfmatch.dao.UserDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    public long id;
    public String name;
    public String email;
    public String password;
    public String description;
    private UserDao userDao;
    public ArrayList<String> interests;

    public User () {}

    public User (String email, String password, String name, String description) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.description = description;
    }
}
