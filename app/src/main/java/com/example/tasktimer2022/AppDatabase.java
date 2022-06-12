package com.example.tasktimer2022;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Basic database class for the application
 * the only class that should use this is AppProvider
 */

class AppDatabase extends SQLiteOpenHelper {

    private static final String TAG = "AppDatabase";
    public static final String DATABASE_NAME = "TaskTimer.db";
    public static final int DATABASE_VERSION = 1;

    //Implement AppDatabase as a Singleton
    private static AppDatabase instance = null;

    private AppDatabase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG, "AppDatabase: constructor");
    }

    /**
     * Get an instance of the app's singleton database helper object
     * @param context provider's context
     * @return a SQLite database helper object
     */
    static AppDatabase getInstance(Context context){
        if(instance == null){
            Log.d(TAG, "getInstance: creating new instance");
            instance = new AppDatabase(context);
        }
        return instance;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: starts");
        String sSQL = ""; //use string variable to facilitate logging;
//        sSQL ="CREATE TABLE TASKS (_id INTEGER PRIMARY KEY NOT NULL, Name TEXT NOT NULL, Description TEXT, SortOrder INTEGER, CategoryID INTEGER);";
        sSQL ="CREATE TABLE "
        + TasksContract.TABLE_NAME + " ("
        +TasksContract.Columns._ID + " INTEGER PRIMARY KEY NOT NULL, "
        +TasksContract.Columns.TASKS_NAME + " TEXT NOT NULL, "
        +TasksContract.Columns.TASKS_DESCRIPTION + " TEXT, "
        +TasksContract.Columns.TASKS_SORT_ORDER + " INTEGER);";


        Log.d(TAG, sSQL);
        db.execSQL(sSQL);
        Log.d(TAG, "onCreate: ends");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
