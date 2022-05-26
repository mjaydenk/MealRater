package com.example.mealrater;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MealDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mymeals.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_MEAL =
            "create table meals (_id integer primary key autoincrement, "
            + "restaurant text not null, dish text, rating integer);";

    public MealDBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MEAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MainActivity.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        +newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS meals");
        onCreate(db);
    }
}
