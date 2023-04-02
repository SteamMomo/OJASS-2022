package com.release.ojass2022;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.release.ojass2022.myTeams_Developers.MyTeamsModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    private ArrayList <PostItemModel> posts;
    private ArrayList <PostItemModel> events;
    private ArrayList<GalleryItemModel> gallery;

    private ArrayList<MyTeamsModel> myteams;

    public ArrayList<PostItemModel> getPosts() {
        if (posts == null) {
            posts = new ArrayList<>();
            loadPosts();
        }
        return posts;
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

    private void loadPosts() {
        ArrayList<PostItemModel> temp = new ArrayList<>();
        temp.add(new PostItemModel("OJASS", "2 days ago", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "2 days ago", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "2 days ago", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "2 days ago", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "2 days ago", "qwerty", "This is a sample description.", 10, 20));

        posts = temp;
    }

    public ArrayList<PostItemModel> getEvents() {
        if (events == null) {
            events = new ArrayList<>();
            loadEvents();
        }
        return events;
    }

    private void loadEvents() {
        ArrayList<PostItemModel> temp = new ArrayList<>();
        temp.add(new PostItemModel("OJASS", "123456789", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "123456789", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "123456789", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "123456789", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "123456789", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "123456789", "qwerty", "This is a sample description.", 10, 20));
        events = temp;
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

}
