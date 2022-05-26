package com.example.mealrater;

public class RatedMeal {

    //The meal ID isn't used in this assignment
    //but if project expanded on to view stored ratings, then it'd be needed
    private int mealID;
    private String restaurantName;
    private String dishName;
    int mealRating;

    public RatedMeal () {
        mealID = -1;
    }

    public int getMealID() {
        return mealID;
    }
    public String getRestaurantName () {return restaurantName;}
    public String getDishName () {return dishName;}
    public int getMealRating() {return mealRating;}

    public void setMealID (int i) {mealID = i;}
    public void setRestaurantName (String r) {restaurantName = r;}
    public void setDishName (String r) {dishName = r;}
    public void setMealRating(int mealRating) {this.mealRating = mealRating;}
}
