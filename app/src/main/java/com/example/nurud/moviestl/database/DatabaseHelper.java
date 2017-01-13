package com.example.nurud.moviestl.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nurud on 1/10/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;

    public static final String NAME = "moviestl";
    public static final int DATABASE_VERSION = 28;

    private static final BaseTable[] ALL_TABLE = {
            new CityTheatreTable(),
            new GenreTable()
    };

    private DatabaseHelper(Context context) {
        super(context, NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getsInstance(Context context){
        sInstance = new DatabaseHelper(context.getApplicationContext());
        return  sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for(BaseTable table : ALL_TABLE){
            table.onCreate(db);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void deleteDatabase(SQLiteDatabase db){
        for(BaseTable table : ALL_TABLE){
            table.onDrop(db);
        }
    }
}
