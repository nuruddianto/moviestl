package com.example.nurud.moviestl.database;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by SRIN on 1/10/2017.
 */
public interface BaseTable {

    void onCreate(SQLiteDatabase db);

    void onDrop(SQLiteDatabase db);
}
