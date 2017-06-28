package com.c2.retrofit_prac2;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by anant bansal on 6/28/2017.
 */

public interface post {

    @GET("/posts/{id}")
    Call<posts> getpost(@Path("id")int i);

    @GET("/posts")
    Call<ArrayList<posts>>getposts();

    @GET("/posts/{id}/comments")
    Call<ArrayList<postsComment>>getpostComments(@Path("id") int id);

    @GET("/comments")
    Call<ArrayList<postsComment>>getComments();


}
