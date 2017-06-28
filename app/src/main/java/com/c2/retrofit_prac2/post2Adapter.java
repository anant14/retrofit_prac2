package com.c2.retrofit_prac2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by anant bansal on 6/28/2017.
 */

public class post2Adapter extends RecyclerView.Adapter<post2Adapter.holderC> {

    Context c;
    ArrayList<postsComment> pc;
    public post2Adapter(Context c, ArrayList<postsComment>pc) {
        this.c=c;
        this.pc=pc;
    }

    @Override
    public holderC onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new holderC(li.inflate(R.layout.post_comment,parent,false));
    }

    @Override
    public void onBindViewHolder(holderC holder, int position) {
        postsComment p=pc.get(position);

        holder.tv_postId.setText(String.valueOf(p.getPostid()));
        holder.tv_id.setText(String.valueOf(p.getId()));
        holder.tv_name.setText(p.getName());
        holder.tv_email.setText(p.getEmail());
        holder.tv_body.setText(p.getBody());
    }

    @Override
    public int getItemCount() {
        return pc.size();
    }

    public class holderC extends RecyclerView.ViewHolder{
        TextView tv_postId;
        TextView tv_id;
        TextView tv_name;
        TextView tv_email;
        TextView tv_body;

        public holderC(View itemView) {
            super(itemView);
            tv_postId= (TextView) itemView.findViewById(R.id.tv_postId);
            tv_id= (TextView) itemView.findViewById(R.id.tv_id);
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
            tv_email= (TextView) itemView.findViewById(R.id.tv_email);
            tv_body= (TextView) itemView.findViewById(R.id.tv_body);
        }
    }
}
