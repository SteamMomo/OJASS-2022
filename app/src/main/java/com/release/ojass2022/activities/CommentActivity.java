package com.release.ojass2022.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.release.ojass2022.CommentItemAdapter;
import com.release.ojass2022.CommentItemModel;
import com.release.ojass2022.R;

import java.util.ArrayList;

public class CommentActivity extends AppCompatActivity {

    ImageView authorProfile, postImage, sendBtn;
    EditText editText;
    TextView commentAuthorName, postDescription, commentAuthorIdentity, commentTimePassed;

    CardView  commentProfileCard;
    LinearLayout commentAuthorDescription;

    ArrayList<String> imageUrls = new ArrayList<>();
    ArrayList<CommentItemModel> comments = new ArrayList<CommentItemModel>();
//    FirebaseUser user;
    String postProfileStr, authorNameStr, authorIdentityStr, finalDurationStr, postTitleStr, postDescriptionStr, postIdStr;
    Toolbar toolbar;
    RecyclerView commentRecyclerView;
    CommentItemAdapter commentItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
    }


    /**
     * Add new comments methods
     */
    private void addComment() {


    }


    private void initializations() {
        commentAuthorName = findViewById(R.id.commentAuthorName);
        postImage = findViewById(R.id.postImage);
        authorProfile = findViewById(R.id.authorProfile);
        postDescription = findViewById(R.id.postDescription);
        commentAuthorIdentity = findViewById(R.id.commentAuthorIdentity);
        commentTimePassed = findViewById(R.id.commentTimePassed);
        commentProfileCard = findViewById(R.id.commentProfileCard);
        commentAuthorDescription = findViewById(R.id.commentAuthorDescription);
        toolbar = findViewById(R.id.commentToolbar);
        sendBtn = findViewById(R.id.sendComment);
        editText = findViewById(R.id.commentEditText);
        commentRecyclerView = findViewById(R.id.commentRecyclerView);
//        user = FirebaseAuth.getInstance().getCurrentUser();
    }
}