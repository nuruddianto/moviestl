package com.example.nurud.moviestl.database;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by SRIN on 1/11/2017.
 */
public class GenreTable implements BaseTable {
    public static final String TABLE_NAME = "genre";

    public static final String FIELD_ID = "id";
    public static final String FIELD_GENRE = "genre";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists " + TABLE_NAME + " (" +
                FIELD_ID + " BIGINT NOT NULL PRIMARY KEY, " +
                FIELD_GENRE + "TEXT" +
                ")");

    }

    @Override
    public void onDrop(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
    }
}
