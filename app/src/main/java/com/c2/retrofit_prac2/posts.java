package com.c2.retrofit_prac2;

/**
 * Created by anant bansal on 6/28/2017.
 */

public class posts {

    int id;
    String title;
    String body;

    public posts(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
