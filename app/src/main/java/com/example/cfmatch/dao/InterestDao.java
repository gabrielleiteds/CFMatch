package com.example.cfmatch.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.cfmatch.Database;
import com.example.cfmatch.entities.Interest;

import java.util.ArrayList;
import java.util.List;

public class InterestDao {
    private Database connection;
    private SQLiteDatabase database;

    public InterestDao(Context context) {
        connection = new Database(context);
        database = connection.getWritableDatabase();
    }

    public long insert (Interest interest) {
        ContentValues values = new ContentValues();
        values.put("title", interest.title);


        return database.insert("interest", null, values);
    }

    public List<Interest> getAll () {
        List<Interest> interests = new ArrayList<>();
        Cursor cursor = database.query("interest",
                new String[]{"id", "title"},
                null, null, null, null, null
        );

        while(cursor.moveToNext()) {
            Interest interest = new Interest();
            interest.id = cursor.getInt(0);
            interest.title = cursor.getString(1);
            interests.add(interest);
        }

        return interests;
    }
}
