package com.release.ojass2022;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubEventAdapter extends RecyclerView.Adapter<SubEventAdapter.MyViewHolder> {
    List<String> subEvents;
    Context context;

    public SubEventAdapter(List<String> subEvents, Context context) {
        this.subEvents = subEvents;
        this.context = context;
    }

    @NonNull
    @Override
    public SubEventAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.subevent_item_model, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubEventAdapter.MyViewHolder holder, int position) {
        holder.subEevntName.setOnClickListener(v ->
                context.startActivity(new Intent(context,EventDetailsActivity.class)));
        holder.subEevntName.setText(subEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return subEvents.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView subEevntName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            subEevntName = itemView.findViewById(R.id.subEventName);
        }
    }

}
