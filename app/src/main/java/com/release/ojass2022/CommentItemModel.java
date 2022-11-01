package com.release.ojass2022;

public class CommentItemModel
{

    String authorIdentity, comment, time, authorID, cID, pID, imageUri, downUri, flag;

    public CommentItemModel(String authorIdentity, String comment, String time, String authorID, String cID, String pID, String downUri, String imageUri, String flag) {
        this.authorIdentity = authorIdentity;
        this.comment = comment;
        this.time = time;
        this.authorID = authorID;
        this.cID = cID;
        this.pID = pID;
        this.downUri = downUri;
        this.flag = flag;
    }



}
