package com.release.ojass2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.List;

public class EventItemAdapter extends RecyclerView.Adapter<EventItemAdapter.MyViewHolder> {
    List<PostItemModel> mFiles;
    Context mContext;

    public EventItemAdapter(List<PostItemModel> mFiles, Context mContext) {
        this.mFiles = mFiles;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public EventItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.event_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventItemAdapter.MyViewHolder holder, int position) {
        holder.foldingCell.setOnClickListener(v -> holder.foldingCell.toggle(false));
    }

    @Override
    public int getItemCount() {
        return mFiles.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        FoldingCell foldingCell;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foldingCell = itemView.findViewById(R.id.foldingCell);
        }
    }
}
