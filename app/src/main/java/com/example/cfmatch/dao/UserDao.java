package com.example.cfmatch.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.cfmatch.Database;
import com.example.cfmatch.entities.User;

public class UserDao {
    private Database connection;
    private SQLiteDatabase database;

    UserDao (Context context) {
        connection = new Database(context);
        database = connection.getWritableDatabase();
    }

    public long insert (@NonNull User user) {
        ContentValues values = new ContentValues();
        values.put("email", user.email);
        values.put("password", user.password);
        return database.insert("user", null, values);
    }
}
