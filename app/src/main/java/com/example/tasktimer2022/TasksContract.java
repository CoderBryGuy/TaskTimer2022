package com.example.tasktimer2022;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import java.net.URI;

import static com.example.tasktimer2022.AppProvider.CONTENT_AUTHORITY;
import static com.example.tasktimer2022.AppProvider.CONTENT_AUTHORITY_URI;

class TasksContract {

    static final String TABLE_NAME = "Tasks";

    //Tasks fields
    public static class Columns{
        public static final String _ID = BaseColumns._ID;
        public static final String TASKS_NAME = "Name";
        public static final String TASKS_DESCRIPTION = "Description";
        public static final String TASKS_SORT_ORDER = "SortOrder";

        private Columns(){
            //private constructor to prevent instantiation
        }
    }

    /**
     * The URI to access the Tasks Table
     */
    public static final Uri CONTENT_URI = Uri.withAppendedPath(CONTENT_AUTHORITY_URI, TABLE_NAME);

    static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + CONTENT_AUTHORITY + "." + TABLE_NAME;
    static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + "." + TABLE_NAME;

    static Uri buildTaskUri(long taskId){
        return ContentUris.withAppendedId(CONTENT_URI,taskId);
    }

    static long getTaskId(Uri uri){
        return ContentUris.parseId(uri);
    }



}
