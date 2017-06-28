package com.c2.retrofit_prac2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowPost extends AppCompatActivity {

    RecyclerView rv_post;
    postAdapter PostAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_post);

        rv_post= (RecyclerView) findViewById(R.id.rv_post);
        post postapi = Retro.getClient().create(post.class);

        postapi.getposts().enqueue(new Callback<ArrayList<posts>>() {
            @Override
            public void onResponse(Call<ArrayList<posts>> call, Response<ArrayList<posts>> response) {
                PostAdapter=new postAdapter(response.body(),ShowPost.this);
                rv_post.setLayoutManager(new LinearLayoutManager(ShowPost.this));
                rv_post.setAdapter(PostAdapter);
            }
            @Override
            public void onFailure(Call<ArrayList<posts>> call, Throwable t) {
            }
        });
    }
}
