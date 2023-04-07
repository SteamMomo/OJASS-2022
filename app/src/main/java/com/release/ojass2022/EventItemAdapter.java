package com.release.ojass2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.List;

public class EventItemAdapter extends RecyclerView.Adapter<EventItemAdapter.MyViewHolder> {
    List<EventItemModel> mFiles;
    Context mContext;

    public EventItemAdapter(List<EventItemModel> mFiles, Context mContext) {
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

        ArrayList<String> subevents = new ArrayList<>();
        subevents.add("Sub event 1");
        subevents.add("Sub event 2");
        subevents.add("Sub event 3");
        subevents.add("Sub event 4");
        SubEventAdapter subEventAdapter = new SubEventAdapter(subevents, mContext);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setAdapter(subEventAdapter);

        EventItemModel model = mFiles.get(position);
        holder.title1.setText(model.getTitle());
        holder.category.setText(model.getCategory());
        holder.title2.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        Glide.with(mContext).load(model.getImageUrl())
                .centerCrop()
                .placeholder(R.mipmap.app_icon)
                .into(holder.image1);
        Glide.with(mContext).load(model.getImageUrl())
                .centerCrop()
                .placeholder(R.mipmap.app_icon)
                .into(holder.image2);
    }

    @Override
    public int getItemCount() {
        return mFiles.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        FoldingCell foldingCell;
        RecyclerView recyclerView;
        ImageView image1, image2;
        TextView title1, title2, category, description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foldingCell = itemView.findViewById(R.id.foldingCell);
            recyclerView = itemView.findViewById(R.id.subEventRecyclerview);
            image1 = itemView.findViewById(R.id.eventImage1);
            image2 = itemView.findViewById(R.id.eventImage2);
            title1 = itemView.findViewById(R.id.eventTitle1);
            title2 = itemView.findViewById(R.id.eventTitle2);
            category = itemView.findViewById(R.id.category);
            description = itemView.findViewById(R.id.eventDescription);
        }
    }
}
