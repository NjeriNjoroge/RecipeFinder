package com.example.gnjoroge.recipefinder.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gnjoroge.recipefinder.R;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */

//to display the questions asked in the same activity
public class PostFragment extends Fragment {




    public PostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);


    }



}
