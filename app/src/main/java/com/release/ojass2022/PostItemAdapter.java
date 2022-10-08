package com.release.ojass2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        ImageView postProfileImage, postImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            postTitle = itemView.findViewById(R.id.postTitle);
            postTimestamp = itemView.findViewById(R.id.postTimestamp);
            postDescription = itemView.findViewById(R.id.postDescription);
            likeCount = itemView.findViewById(R.id.likeCount);
            commentCount = itemView.findViewById(R.id.commentCount);
            postProfileImage = itemView.findViewById(R.id.postProfileImage);
            postImage = itemView.findViewById(R.id.postImage);
        }
    }
}
