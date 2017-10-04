package com.example.gnjoroge.recipefinder.ui;

import android.app.Fragment;

import android.os.Bundle;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;


import com.example.gnjoroge.recipefinder.R;

/**
 * Created by gnjoroge on 10/4/17.
 */

public class RecipeFinderFragment extends Fragment {


    View myView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        myView = inflater.inflate(R.layout.activity_recipe_display, container, false);

        return myView;
    }
}
