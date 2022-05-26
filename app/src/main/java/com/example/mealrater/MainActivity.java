package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RatingDialogFragment.DialogListener {

    private RatedMeal meal = new RatedMeal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRateMeal();
    }

    //Handles button push for meal rating and calls RatingDialogFragment
    private void initRateMeal() {
        Button rating = findViewById(R.id.buttonRate);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                RatingDialogFragment ratingDialogFragment = new RatingDialogFragment();
                ratingDialogFragment.show(fragmentManager, "Rating");
            }
        });
    }

    @Override
    public void finishedRating(int rating) {
        int mealRating = 0;
        EditText resName = findViewById(R.id.editResturant);
        EditText dishName = findViewById(R.id.editDish);
        TextView ratingText = findViewById(R.id.textRating);
        switch (rating) {
            case 1:
                ratingText.setText("One star");
                mealRating = 1;
                break;
            case 2:
                ratingText.setText("Two stars");
                mealRating = 2;
                break;
            case 3:
                ratingText.setText("Three stars");
                mealRating = 3;
                break;
            case 4:
                ratingText.setText("Four stars");
                mealRating = 4;
                break;
            case 5:
                ratingText.setText("Five stars");
                mealRating = 5;
                break;
        }
        if (resName.getText().toString() == ""){
            Toast.makeText(this, "Please enter restaurant name", Toast.LENGTH_LONG).show();
            return;
        }
        if (dishName.getText().toString() == ""){
            Toast.makeText(this, "Please enter dish name", Toast.LENGTH_LONG).show();
            return;
        }
        if (mealRating == 0)
            Toast.makeText(this, "An Error occurred with meal rating, please try again", Toast.LENGTH_LONG).show();

        meal.setRestaurantName(resName.getText().toString());
        meal.setDishName(dishName.getText().toString());
        meal.setMealRating(mealRating);

        MealDataSource db = new MealDataSource(MainActivity.this);
        try {
            db.open();
            if (db.insertRating(meal)) {

            } else {
                throw new Exception();
            }
            db.close();
        } catch (Exception e) {Toast.makeText(this, "An Error occurred saving meal rating, please try again", Toast.LENGTH_LONG).show();

        }

    }
}