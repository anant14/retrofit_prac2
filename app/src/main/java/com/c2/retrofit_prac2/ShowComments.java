package com.c2.retrofit_prac2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowComments extends AppCompatActivity {

    RecyclerView rv_comments;
    post2Adapter Post2Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_comments);

        rv_comments= (RecyclerView) findViewById(R.id.rv_comment);

        post postapi = Retro.getClient().create(post.class);

        postapi.getComments().enqueue(new Callback<ArrayList<postsComment>>() {
            @Override
            public void onResponse(Call<ArrayList<postsComment>> call, Response<ArrayList<postsComment>> response) {
                Post2Adapter=new post2Adapter(ShowComments.this,response.body());
                rv_comments.setLayoutManager(new LinearLayoutManager(ShowComments.this));
                rv_comments.setAdapter(Post2Adapter);
            }
            @Override
            public void onFailure(Call<ArrayList<postsComment>> call, Throwable t) {
            }
        });

        postapi.getpostComments(getIntent().getIntExtra("id",0)).enqueue(new Callback<ArrayList<postsComment>>() {
            @Override
            public void onResponse(Call<ArrayList<postsComment>> call, Response<ArrayList<postsComment>> response) {
                Post2Adapter=new post2Adapter(ShowComments.this,response.body());
                rv_comments.setLayoutManager(new LinearLayoutManager(ShowComments.this));
                rv_comments.setAdapter(Post2Adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<postsComment>> call, Throwable t) {

            }
        });
    }
}
