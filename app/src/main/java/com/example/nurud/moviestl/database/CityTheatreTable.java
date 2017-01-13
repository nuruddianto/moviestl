package com.example.nurud.moviestl.database;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by SRIN on 1/10/2017.
 */
public class CityTheatreTable implements BaseTable {
    public static final String TABLE_NAME = "city_theatre";

    public static final String FIELD_ID = "id";
    public static final String FIELD_CITY = "city";

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists " + TABLE_NAME + " (" +
                FIELD_ID + "BIGINT NOT NULL PRIMARY KEY," +
                FIELD_CITY + "TEXT" +
                ")");
    }

    public void onDrop(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
    }
}
