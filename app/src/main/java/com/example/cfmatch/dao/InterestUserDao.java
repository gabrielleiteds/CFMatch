package com.example.cfmatch.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.cfmatch.Database;
import com.example.cfmatch.entities.UserInterest;

import java.util.ArrayList;
import java.util.List;

public class InterestUserDao {
    private Database connection;
    private SQLiteDatabase database;

    public InterestUserDao(Context context) {
        connection = new Database(context);
        database = connection.getWritableDatabase();
    }

    public long insert (UserInterest userInterest) {
        ContentValues values = new ContentValues();
        values.put("userId", userInterest.userId);
        values.put("interestId", userInterest.interestId);

        return database.insert("interest_user", null, values);
    }

    public List<UserInterest> getAll () {
        List<UserInterest> userInterests = new ArrayList<>();
        Cursor cursor = database.query("interest_user",
                new String[]{"id", "userId", "interestId"},
                null, null, null, null, null
        );

        while(cursor.moveToNext()) {
            UserInterest userInterest = new UserInterest();
            userInterest.id = cursor.getInt(0);
            userInterest.userId = cursor.getInt(1);
            userInterest.interestId = cursor.getInt(2);

            userInterests.add(userInterest);
        }

        return userInterests;
    }
}
