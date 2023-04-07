package com.release.ojass2022;

import com.google.firebase.database.PropertyName;

import java.util.ArrayList;
import java.util.List;

public class EventItemModel {
    private float id;
    private String category;
    private String title;
    private String description;
    private String imageUrl;

    private ArrayList<String> subEvents;

    public void setSubEvents(ArrayList<String> subEvents) {
        this.subEvents = subEvents;
    }

    public ArrayList<String> getSubEvents() {
        return subEvents;
    }
// Getter Methods

    public float getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
