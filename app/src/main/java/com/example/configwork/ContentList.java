package com.example.configwork;

import android.graphics.drawable.Drawable;

public class ContentList {
    private Drawable itemImage;
    private String heading;
    private String body;

    public ContentList(Drawable itemImage, String heading, String body) {
        this.itemImage = itemImage;
        this.heading = heading;
        this.body = body;
    }

    public Drawable getItemImage() {
        return itemImage;
    }

    public String getHeading() {
        return heading;
    }

    public String getBody() {
        return body;
    }

}