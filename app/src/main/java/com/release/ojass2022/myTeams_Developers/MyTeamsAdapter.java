package com.release.ojass2022.myTeams_Developers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.release.ojass2022.R;

import java.util.List;

public class MyTeamsAdapter extends RecyclerView.Adapter<MyTeamsAdapter.MyViewHolder> {

    List<MyTeamsModel> mFiles;
    Context mContext;

    public MyTeamsAdapter(List<MyTeamsModel> mFiles, Context mContext) {
        this.mFiles = mFiles;
        this.mContext = mContext;
    }



    @NonNull
    @Override
    public MyTeamsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.my_team_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTeamsAdapter.MyViewHolder holder, int position) {

        MyTeamsModel model = mFiles.get(position);
        holder.person_name.setText(model.p_name);
        holder.person_post.setText(model.p_post);


    }

    @Override
    public int getItemCount() {
        return mFiles.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView person_name, person_post;
        ImageView person_image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           person_image = itemView.findViewById(R.id.person_image);
           person_name = itemView.findViewById(R.id.person_name);
           person_post = itemView.findViewById(R.id.person_post);
        }
    }
}
