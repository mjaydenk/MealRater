package com.example.mealrater;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class RatingDialogFragment extends DialogFragment {

    float rating;

    public interface DialogListener {
        void finishedRating (int rating);
    }

    public RatingDialogFragment () {

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.ratingdialog, container);

        getDialog().setTitle("Give rating");

        Button saveBtn = view.findViewById(R.id.buttonSave);
        final RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rating = ratingBar.getRating();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveItem((int) rating);
            }
        });
        return view;
    }

    private void saveItem (int rating) {
        DialogListener activity = (DialogListener) getActivity();
        activity.finishedRating(rating);
        getDialog().dismiss();
    }
}
