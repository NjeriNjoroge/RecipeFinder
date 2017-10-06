package com.example.gnjoroge.recipefinder.ui;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gnjoroge.recipefinder.Constants;
import com.example.gnjoroge.recipefinder.R;
import com.example.gnjoroge.recipefinder.adapters.PostDetailAdapter;
import com.example.gnjoroge.recipefinder.model.Post;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DiscussionForum extends AppCompatActivity {

    private DatabaseReference mQuestion;

    //hiding the form fields after submit
    private boolean viewGroupIsVisible = true;
    private View mViewGroup;
    private View mViewGroup1;
    private View mViewGroup2;

    //displaying the questions
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    //getting the questions
    @Bind(R.id.inputAuthor) EditText mInputAuthor;
    @Bind(R.id.inputTitle) EditText mInpuTitle;
    @Bind(R.id.inputBody) EditText mInputBody;
    @Bind(R.id.submitPost) Button mSubmitPost;

    //calling the PostDetailAdapter created
    private PostDetailAdapter mAdapter;


    ArrayList<Post> mPosts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_forum);
        ButterKnife.bind(this);



        //accessing the adapter created
        mAdapter = new PostDetailAdapter(getApplicationContext(), mPosts);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DiscussionForum.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        mSubmitPost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //collect the ids for hiding the editText fields
                mViewGroup = findViewById(R.id.titleField);
                mViewGroup1 =  findViewById(R.id.bodyField);
                mViewGroup2 =  findViewById(R.id.authorField);

                String title = mInpuTitle.getText().toString();
                mInpuTitle.setText("");
                String author = mInputAuthor.getText().toString();
                mInputAuthor.setText("");
                String body = mInputBody.getText().toString();
                mInputBody.setText("");
                String newPost = title + author + body;

                Post post = new Post(title, author,body);
                mAdapter.addPost(post);

                if(view == mSubmitPost) {
                    DatabaseReference postRef = FirebaseDatabase
                            .getInstance()
                            .getReference(Constants.FIREBASE_CHILD_POSTS);
                    postRef.push().setValue(mPosts);
                }

                //hiding the editText Fields
                if(viewGroupIsVisible) {
                    mViewGroup.setVisibility(View.GONE);
                    mViewGroup1.setVisibility(View.GONE);
                    mViewGroup2.setVisibility(View.GONE);
                    mSubmitPost.setText("Ask Question");
                } else {
                    mViewGroup.setVisibility(View.VISIBLE);
                    mViewGroup1.setVisibility(View.VISIBLE);
                    mViewGroup2.setVisibility(View.VISIBLE);
                    mSubmitPost.setText("Hide");
                }

                viewGroupIsVisible = !viewGroupIsVisible;

            }
        });




    }


}
