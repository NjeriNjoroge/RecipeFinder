package com.example.gnjoroge.recipefinder.ui;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

import static java.security.AccessController.getContext;


public class DiscussionForum extends AppCompatActivity {

    private DatabaseReference mQuestion;

    //displaying the questions
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    //getting the questions
    @Bind(R.id.inputAuthor) EditText mInputAuthor;
    @Bind(R.id.inputTitle) EditText mInputTitle;
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

                String title = mInputTitle.getText().toString();
                mInputTitle.setText("");
                //validating field is not empty
                if(TextUtils.isEmpty(title)) {
                    mInputTitle.setError("Title cannot be left empty");
                    return;
                }

                String author = mInputAuthor.getText().toString();
                mInputAuthor.setText("");
                //validating field is not empty
                if(TextUtils.isEmpty(author)) {
                    mInputAuthor.setError("Author cannot be left empty");
                    return;
                }

                String body = mInputBody.getText().toString();
                mInputBody.setText("");
                //validating field is not empty
                if(TextUtils.isEmpty(body)) {
                    mInputBody.setError("Body cannot be left empty");
                    return;
                }

                String newPost = title + author + body;

                Post post = new Post(title, author,body);
                mAdapter.addPost(post);



                //saving to Firebase
                if(view == mSubmitPost) {
                    DatabaseReference postRef = FirebaseDatabase
                            .getInstance()
                            .getReference(Constants.FIREBASE_CHILD_POSTS);
                    postRef.push().setValue(mPosts);
                }


            }


        });




    }


}
