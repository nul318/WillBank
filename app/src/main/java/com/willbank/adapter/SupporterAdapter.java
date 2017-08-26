package com.willbank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.willbank.R;
import com.willbank.instance.Supporter;

import java.util.ArrayList;

/**
 * Created by nul010 on 2017-08-26.
 */


public class SupporterAdapter extends BaseAdapter {
    ArrayList<Supporter> supporterList;
    Context con;
    LayoutInflater inflater;
    int item_layout;
    public SupporterAdapter(ArrayList<Supporter> supporterList, Context con, int item_layout){
        this.supporterList = supporterList;
        this.con = con;
        this.item_layout = item_layout;
        this.inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return supporterList.size();
    }

    @Override
    public Supporter  getItem(int position) {
        return supporterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(item_layout, parent, false);
        Supporter item = supporterList.get(position);
        ImageView profileImage = (ImageView) convertView.findViewById(R.id.profile_image);
        TextView author = (TextView) convertView.findViewById(R.id.author);
        TextView comment = (TextView) convertView.findViewById(R.id.comment);


        Glide.with(con).load(item.img_resource_url).into(profileImage);
        author.setText(item.author);
        comment.setText(item.comment);

        return convertView;
    }
}