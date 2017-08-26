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
import com.willbank.instance.Rank;

import java.util.ArrayList;

/**
 * Created by nul010 on 2017-08-26.
 */


public class RankAdapter extends BaseAdapter {
    ArrayList<Rank> rankList;
    Context con;
    LayoutInflater inflater;
    int item_layout;
    public RankAdapter(ArrayList<Rank> rankList, Context con, int item_layout){
        this.rankList = rankList;
        this.con = con;
        this.item_layout = item_layout;
        this.inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }




    @Override
    public int getCount() {
        return rankList.size();
    }

    @Override
    public Rank getItem(int position) {
        return rankList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(item_layout, parent, false);

        Rank item = rankList.get(position);

        TextView idx = (TextView) convertView.findViewById(R.id.idx);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.profile_image);
        TextView author = (TextView) convertView.findViewById(R.id.author);
        TextView price = (TextView) convertView.findViewById(R.id.price);


        idx.setText(String.valueOf(position+1));

//        imageView.setImageResource(item.img_resource_url);
        Glide.with(con).load(item.img_resource_url).into(imageView);
        author.setText(item.author);
        price.setText(String.format("%,d",item.price));

        return convertView;
    }
}