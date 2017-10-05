package com.example.gnjoroge.recipefinder.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gnjoroge.recipefinder.R;
import com.example.gnjoroge.recipefinder.adapters.PostDetailAdapter;
import com.example.gnjoroge.recipefinder.model.Post;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gnjoroge on 10/4/17.
 */

public class DiscussionForumFragment extends Fragment {



    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.second_layout, container, false);

        return myView;
    }


}
