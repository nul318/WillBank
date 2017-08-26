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
import com.willbank.instance.Talk;

import java.util.ArrayList;

/**
 * Created by nul010 on 2017-08-26.
 */


public class TalkAdapter extends BaseAdapter {
    ArrayList<Talk> talkList;
    Context con;
    LayoutInflater inflater;
    int item_layout;
    public TalkAdapter(ArrayList<Talk> talkList, Context con, int item_layout){
        this.talkList = talkList;
        this.con = con;
        this.item_layout = item_layout;
        this.inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }




    @Override
    public int getCount() {
        return talkList.size();
    }

    @Override
    public Talk getItem(int position) {
        return talkList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(item_layout, parent, false);

        Talk item = talkList.get(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.profile_image);


        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView count = (TextView) convertView.findViewById(R.id.count);
        TextView date = (TextView) convertView.findViewById(R.id.date);

//        imageView.setImageResource(item.img_resource_url);
        Glide.with(con).load(item.img_resource_url).into(imageView);
        title.setText(item.title);
        count.setText(String.valueOf(item.count) + " 명 참여중");
        date.setText(item.date);

        return convertView;
    }
}