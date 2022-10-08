package com.release.ojass2022;

public class PostItemModel {

    String title, timestamp, imageUrl, description;
    Integer likes, comments;

    public PostItemModel(String title, String timestamp, String imageUrl, String description, Integer likes, Integer comments) {
        this.title = title;
        this.timestamp = timestamp;
        this.imageUrl = imageUrl;
        this.description = description;
        this.likes = likes;
        this.comments = comments;
    }
}
