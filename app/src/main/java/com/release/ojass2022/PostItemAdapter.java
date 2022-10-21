package com.release.ojass2022;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.util.List;

public class PostItemAdapter extends RecyclerView.Adapter<PostItemAdapter.MyViewHolder> {
    List<PostItemModel> mFiles;
    Context mContext;

    public PostItemAdapter(List<PostItemModel> mFiles, Context mContext) {
        this.mFiles = mFiles;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.post_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PostItemModel model = mFiles.get(position);
        holder.postTitle.setText(model.title);

        //TODO - Convert timestamp to (hours before) format
        holder.postTimestamp.setText(model.timestamp);

        holder.postDescription.setText(model.description);
        holder.likeCount.setText(model.likes.toString());
        holder.commentCount.setText(model.comments.toString());

        //TODO - Import Glide library to load images from url

        //like and post button controls
        holder.likeBtn.setOnClickListener(v -> likeBtnControls());
    }

    private void likeBtnControls() {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(mContext);
        if (account == null) {
            Toast.makeText(mContext, "User not signed in", Toast.LENGTH_SHORT).show();
            mContext.startActivity(new Intent(mContext, LoginActivity.class));
        } else {
            Toast.makeText(mContext, "User signed in", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return mFiles.size();
    }

    public void updateUI(List<PostItemModel> mFiles) {
        this.mFiles = mFiles;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView postTitle, postTimestamp, postDescription, likeCount, commentCount;
        ImageView postProfileImage, postImage, likeBtn, commentBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            postTitle = itemView.findViewById(R.id.postTitle);
            postTimestamp = itemView.findViewById(R.id.postTimestamp);
            postDescription = itemView.findViewById(R.id.postDescription);
            likeCount = itemView.findViewById(R.id.likeCount);
            commentCount = itemView.findViewById(R.id.commentCount);
            postProfileImage = itemView.findViewById(R.id.postProfileImage);
            postImage = itemView.findViewById(R.id.postImage);
            likeBtn = itemView.findViewById(R.id.postLikeButton);
            commentBtn = itemView.findViewById(R.id.postCommentButton);
        }
    }
}
