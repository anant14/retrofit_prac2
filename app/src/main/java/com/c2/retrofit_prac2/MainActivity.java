package com.c2.retrofit_prac2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static final String TAG="main_activity";
    Button btndownpost;
    Button btndowncomment;

    ArrayList<posts> pl;
    postAdapter PostAdapter;
    post2Adapter Post2Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btndownpost= (Button) findViewById(R.id.dwnpost);
        btndowncomment= (Button) findViewById(R.id.dwncomment);


        btndownpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ShowPost.class);
                startActivity(i);
            }
        });

        btndowncomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ShowComments.class);
                startActivity(i);
            }
        });



    }
}
 /*    postapi.getpost(1).enqueue(new Callback<posts>() {
         @Override
         public void onResponse(Call<posts> call, Response<posts> response) {
             Log.d(TAG, "onResponse: "+response.body().getTitle());
         }

         @Override
         public void onFailure(Call<posts> call, Throwable t) {
             Log.d(TAG, "onFailure: "+t);
         }
     });*/