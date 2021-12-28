package com.example.cfmatch.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.cfmatch.Database;
import com.example.cfmatch.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Database connection;
    private SQLiteDatabase database;

    public UserDao(Context context) {
        connection = new Database(context);
        database = connection.getWritableDatabase();
    }

    public long insert (User user) {
        ContentValues values = new ContentValues();
        values.put("email", user.email);
        values.put("password", user.password);
        values.put("description", user.description);
        values.put("name", user.name);

        return database.insert("user", null, values);
    }

    public List<User> getAll () {
        List<User> users = new ArrayList<>();
        Cursor cursor = database.query("user",
                new String[]{"id", "name", "email", "password", "description"},
                null, null, null, null, null
        );

        while(cursor.moveToNext()) {
            User user = new User();
            user.id = cursor.getInt(0);
            user.name = cursor.getString(1);
            user.email = cursor.getString(2);
            user.password = cursor.getString(3);
            user.description = cursor.getString(4);
            users.add(user);
        }

        return users;

    }
}
