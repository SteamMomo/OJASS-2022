package com.release.ojass2022;

import java.util.List;

public class EventItemModel {
    String imageUrl, eventName, eventDescription;
    List<String> subEvents;

    public EventItemModel(String imageUrl, String eventName, String eventDescription, List<String> subEvents) {
        this.imageUrl = imageUrl;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.subEvents = subEvents;
    }
}
