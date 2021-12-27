package com.example.cfmatch;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    private static final String name = "cf_match";
    private static final int version = 1;

    private String createUserSQL = "create table user(id integer primary key autoincrement, " +
            "name varchar(50)," +
            "email varhar(50))";

    public Database (Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUserSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
