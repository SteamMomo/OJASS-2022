package com.release.ojass2022;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.release.ojass2022.activities.ShowImageActivity;

import java.util.ArrayList;

public class GalleryItemAdapter extends RecyclerView.Adapter<GalleryItemAdapter.MyViewHolder>{

    private ArrayList<GalleryItemModel> gallery;
    private Context context;

    public GalleryItemAdapter(ArrayList<GalleryItemModel> gallery, Context context) {
        this.gallery = gallery;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GalleryItemModel model=gallery.get(position);
        holder.image.setImageResource(context.getResources().
                getIdentifier(model.getImage(),"drawable",context.getPackageName()));
        holder.image.setOnClickListener(view -> {
            Intent intent = new Intent(context, ShowImageActivity.class);
            intent.putExtra("imageName", gallery.get(position).getImage());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return gallery.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.galleryImage);
        }
    }
}
