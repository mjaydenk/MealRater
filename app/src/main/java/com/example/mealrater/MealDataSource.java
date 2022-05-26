package com.example.mealrater;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class MealDataSource {

    private SQLiteDatabase database;
    private final MealDBHelper dbHelper;

    public MealDataSource (Context context) {
        dbHelper = new MealDBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {dbHelper.close();}

    public boolean insertRating (RatedMeal ratedMeal) {
        boolean test;
        ContentValues values = new ContentValues();

        values.put("restaurant", ratedMeal.getRestaurantName());
        values.put("dish", ratedMeal.getDishName());
        values.put("rating", ratedMeal.getMealRating());

        test = database.insert("meals", null, values) > 0;
        return test;
    }
}
