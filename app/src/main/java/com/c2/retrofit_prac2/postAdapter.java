package com.c2.retrofit_prac2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by anant bansal on 6/28/2017.
 */

public class postAdapter extends RecyclerView.Adapter<postAdapter.holder> {
        public static final String TAG="postAdapter";
    Context c;
    ArrayList<posts> pl=new ArrayList<>();

    public postAdapter(ArrayList<posts> pl, Context c) {
        this.c=c;
        this.pl=pl;
    }

    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new holder(li.inflate(R.layout.post_base,parent,false));

    }

    @Override
    public void onBindViewHolder(holder holder, int position) {
        final posts p=pl.get(position);
        holder.tv_id.setText(String.valueOf(p.getId()));
        holder.tv_body.setText(p.getBody());
        holder.tv_title.setText(p.getTitle());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(c,ShowComments.class);
                i.putExtra("id",p.getId());
                c.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pl.size();
    }

    public class holder extends RecyclerView.ViewHolder{
        TextView tv_id;
        TextView tv_body;
        TextView tv_title;
        View rootView;
        public holder(View itemView) {
            super(itemView);
            tv_id= (TextView) itemView.findViewById(R.id.tv_id);
            tv_body= (TextView) itemView.findViewById(R.id.tv_body);
            tv_title= (TextView) itemView.findViewById(R.id.tv_title);
            rootView=itemView;
        }
    }
}
