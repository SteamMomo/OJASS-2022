package com.release.ojass2022;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.release.ojass2022.myTeams_Developers.MyTeamsModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class MainViewModel extends ViewModel {
    private ArrayList <PostItemModel> posts;
    private ArrayList <EventItemModel> events;
    private ArrayList<GalleryItemModel> gallery;

    private ArrayList<MyTeamsModel> myteams;

    public ArrayList<PostItemModel> getPosts() {
        if (posts == null) {
            posts = new ArrayList<>();
            loadPosts();
        }
        return posts;
    }

    private void loadPosts() {
        ArrayList<PostItemModel> temp = new ArrayList<>();
        temp.add(new PostItemModel("OJASS", "2 days ago", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "2 days ago", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "2 days ago", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "2 days ago", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "2 days ago", "qwerty", "This is a sample description.", 10, 20));

        posts = temp;
    }

    public ArrayList<GalleryItemModel> getGallery(){
        if(gallery == null){
            gallery = new ArrayList<>();
            loadGallery();
        }
        return gallery;
    }

    private void loadGallery(){
        ArrayList<GalleryItemModel> temp = new ArrayList<>();
        temp.add(new GalleryItemModel("ojasslogo"));
        temp.add(new GalleryItemModel("ojasslogo"));
        temp.add(new GalleryItemModel("ojasslogo"));
        temp.add(new GalleryItemModel("ojasslogo"));
        temp.add(new GalleryItemModel("ojasslogo"));
        temp.add(new GalleryItemModel("ojasslogo"));
        temp.add(new GalleryItemModel("ojasslogo"));
        gallery = temp;
    }

    public ArrayList<MyTeamsModel> getTeams()
    {
        if(myteams == null)
        {
            myteams = new ArrayList<>();
            loadTeams();

        }
        return myteams;
    }

    private void loadTeams()
    {
        ArrayList<MyTeamsModel> temp = new ArrayList<>();
        temp.add(new MyTeamsModel("imageurl", "Guddu", "Android"));
        temp.add(new MyTeamsModel("imageurl", "Guddu", "Android"));
        temp.add(new MyTeamsModel("imageurl", "Guddu", "Android"));
        temp.add(new MyTeamsModel("imageurl", "Guddu", "Android"));
        temp.add(new MyTeamsModel("imageurl", "Guddu", "Android"));
        temp.add(new MyTeamsModel("imageurl", "Guddu", "Android"));

        myteams = temp;
    }

}
