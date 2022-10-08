package com.release.ojass2022;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    private ArrayList <PostItemModel> posts;

    public ArrayList<PostItemModel> getPosts() {
        if (posts == null) {
            posts = new ArrayList<>();
            loadPosts();
        }
        return posts;
    }

    private void loadPosts() {
        ArrayList<PostItemModel> temp = new ArrayList<>();
        temp.add(new PostItemModel("OJASS", "123456789", "qwerty", "This is a sample description.", 10, 20));
        temp.add(new PostItemModel("OJASS", "123456789", "qwerty", "This is a sample description.", 10, 20));
        posts = temp;
    }

}
