package com.example.gnjoroge.recipefinder.model;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gnjoroge on 10/4/17.
 */
@Parcel

public class Post {

    private String title;
    private String body;
    private String author;

    public Post() {}

    public Post(String title, String body, String author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }


}
