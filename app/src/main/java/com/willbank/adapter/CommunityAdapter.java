package com.willbank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.willbank.R;
import com.willbank.instance.Community;

import java.util.ArrayList;

/**
 * Created by nul010 on 2017-08-26.
 */


public class CommunityAdapter extends BaseAdapter {
    ArrayList<Community> communityList;
    Context con;
    LayoutInflater inflater;
    int item_layout;
    public CommunityAdapter(ArrayList<Community> communityList, Context con, int item_layout){
        this.communityList = communityList;
        this.con = con;
        this.item_layout = item_layout;
        this.inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return communityList.size();
    }

    @Override
    public Community getItem(int position) {
        return communityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(item_layout, parent, false);

        Community item = communityList.get(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.profile_image);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView count = (TextView) convertView.findViewById(R.id.count);
        TextView date = (TextView) convertView.findViewById(R.id.date);

        imageView.setImageResource(item.img_resource_url);
        title.setText(item.title);
        count.setText(String.valueOf(item.count));
        date.setText(item.date);

        return convertView;
    }
}