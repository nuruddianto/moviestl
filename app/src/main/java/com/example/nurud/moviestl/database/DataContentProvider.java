package com.example.nurud.moviestl.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by SRIN on 1/11/2017.
 */
public class DataContentProvider extends ContentProvider {
    private DatabaseHelper mDatabaseHelper;

    private static final int GENRE = 1000;
    private static final int CITY_THEATRE = 1001;
    private static final String PROVIDER_NAME = "com.example.nurud.moviestl";
    private static final String BASE_PATH = DatabaseHelper.NAME + "/";
    private static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME);

    //Basic Uri
    public static final Uri GENRE_URI = Uri.withAppendedPath(CONTENT_URI, BASE_PATH + GenreTable.TABLE_NAME);
    public static final Uri CITY_THEATRE_URI = Uri.withAppendedPath(CONTENT_URI, BASE_PATH + CityTheatreTable.TABLE_NAME);

    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(PROVIDER_NAME, BASE_PATH + GenreTable.TABLE_NAME, GENRE);
        URI_MATCHER.addURI(PROVIDER_NAME, BASE_PATH + CityTheatreTable.TABLE_NAME, CITY_THEATRE);
    }

    @Override
    public boolean onCreate() {
        mDatabaseHelper = DatabaseHelper.getsInstance(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return uri != null ? uri.toString() : null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        long id;
        int uriType = URI_MATCHER.match(uri);
        switch (uriType){
            case GENRE:
                id = db.insert(GenreTable.TABLE_NAME, null, values);
                break;
            case CITY_THEATRE:
                id = db.insert(CityTheatreTable.TABLE_NAME, null, values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: "+ uri);
        }

        Uri result = Uri.parse(BASE_PATH+"/"+id);
        getContext().getContentResolver().notifyChange(uri, null);
        return result;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        int deletedRows;

        int uriType = URI_MATCHER.match(uri);
        switch (uriType){
            case GENRE:
                deletedRows = db.delete(GenreTable.TABLE_NAME, selection, selectionArgs);
                break;
            case CITY_THEATRE:
                deletedRows = db.delete(CityTheatreTable.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: "+ uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return deletedRows;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        int updatedRows;
        int uriType = URI_MATCHER.match(uri);

        switch (uriType){
            case GENRE:
                updatedRows = db.update(GenreTable.TABLE_NAME, values, selection, selectionArgs);
                break;
            case CITY_THEATRE:
                updatedRows = db.update(CityTheatreTable.TABLE_NAME, values, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: "+uri);
        }
        return 0;
    }
}
