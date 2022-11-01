package com.release.ojass2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CommentItemAdapter extends RecyclerView.Adapter<CommentItemAdapter.MyViewHolder> {

    private final Context context;
    private ArrayList<CommentItemModel> mFiles;

    public CommentItemAdapter(Context context, ArrayList<CommentItemModel> mFiles)
    {
        this.context = context;
        this.mFiles = mFiles;
    }

    @NonNull
    @Override
    public CommentItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.comment_item_layout, parent, false);
        return new CommentItemAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mFiles.size();
    }


    /***
     * Method to delete comments
     * @param cID
     * @param pID
     * @param it
     */
    private void deleteComment(String cID, String pID, int it) {


    }

    /**
     * Method to add new comments
     * @param comments
     */
    public void updateData(ArrayList<CommentItemModel> comments) {
        mFiles = comments;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
