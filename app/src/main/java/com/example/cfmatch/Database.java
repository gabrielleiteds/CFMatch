package com.example.cfmatch;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    private static final String name = "cf_match";
    private static final int version = 24;

    private String createUserSQL = "create table user(id integer primary key autoincrement, " +
            "password varchar(50)," +
            "email varchar(50)," +
            "description text," +
            "name varchar(50))";

    private String createInterestSQL = "create table interest(id integer primary key autoincrement, " +
            "title text)";

    private String createInterestUserSQL = "create table "
            + "interest_user" + " ("
            + "id" + " integer primary key autoincrement, "
            + "userId" + " integer, "
            + "interestId" + " integer, "
            + " FOREIGN KEY(userId) REFERENCES user(id), "
            + " FOREIGN KEY(interestId) REFERENCES interest(id));";

    private String populateInterest = "insert into interest (title) VALUES('Administração');";

    public Database (Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUserSQL);
        db.execSQL(createInterestSQL);
        db.execSQL(createInterestUserSQL);
        db.execSQL(populateInterest);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS interest");
        db.execSQL("DROP TABLE IF EXISTS interest_user");
        onCreate(db);
    }
}
