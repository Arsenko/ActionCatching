package com.example.configwork;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;

public class ContentList {
    private Drawable itemImage;
    private String heading;
    private String body;
    private boolean itemCheck;

    public ContentList(Drawable itemImage,String heading,String body,boolean itemCheck){
        this.itemImage=itemImage;
        this.heading=heading;
        this.body=body;
        this.itemCheck=itemCheck;
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

    public boolean getItemCheck() {
        return itemCheck;
    }
}
