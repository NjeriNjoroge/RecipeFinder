package com.example.gnjoroge.recipefinder.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gnjoroge.recipefinder.R;
import com.example.gnjoroge.recipefinder.model.Post;
import com.example.gnjoroge.recipefinder.ui.DiscussionForum;
import com.example.gnjoroge.recipefinder.ui.DiscussionForumFragment;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gnjoroge on 10/5/17.
 */

//adapter to be used in PostFragment

public class PostDetailAdapter extends RecyclerView.Adapter<PostDetailAdapter.PostViewHolder> {

    private static final String TAG = "PostDetailAdapter";
    private ArrayList<Post> mPosts = new ArrayList<>();
    private Context mContext;

    public PostDetailAdapter(Context context, ArrayList<Post> posts) {
        mContext = context;
        mPosts = posts;
    }

    public void addPost(Post post){
        mPosts.add(post);
        notifyDataSetChanged();
    }

    @Override
    public PostDetailAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_post, parent, false);
        PostViewHolder viewHolder = new PostViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PostDetailAdapter.PostViewHolder holder, int position) {
        holder.bindPost(mPosts.get(position));
    }

    @Override
    public int getItemCount() {

        return mPosts.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.title) TextView mTitle;
        @Bind(R.id.body) TextView mBody;
        @Bind(R.id.author) TextView mAuthor;

        private Context mContext;

        public PostViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, DiscussionForum.class);
            intent.putExtra("position", itemPosition);
//            intent.putExtra("posts", Parcel.wrap(mPosts));
            mContext.startActivity(intent);

        }

        public void bindPost(Post post) {

            mTitle.setText(post.getTitle());
            mBody.setText(post.getBody());
            mAuthor.setText(post.getAuthor());
        }
    }
}
