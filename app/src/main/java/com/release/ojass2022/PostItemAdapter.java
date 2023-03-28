package com.release.ojass2022;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.release.ojass2022.activities.CommentActivity;
import com.release.ojass2022.activities.LoginActivity;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostItemAdapter extends RecyclerView.Adapter<PostItemAdapter.MyViewHolder> {
    List<PostItemModel> mFiles;
    Context mContext;
    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://ojass-backend.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();
    UserClient userClient = retrofit.create(UserClient.class);

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
        holder.commentBtn.setOnClickListener(v -> commentBtnControls());
    }

    private void commentBtnControls() {

    }

    private void likeBtnControls() {

    }

    private void postRequest(GoogleSignInAccount acc) {
        String token = acc.getIdToken();
        User user = new User(token);
        Call<ResponseBody> call = userClient.sendToken(user);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                Toast.makeText(mContext, "Token sent" + response, Toast.LENGTH_SHORT).show();
                Log.wtf("Token Response", String.valueOf(response));
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Toast.makeText(mContext, "Error :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFiles.size();
    }

    public void updateUI(List<PostItemModel> mFiles) {
        this.mFiles = mFiles;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
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
