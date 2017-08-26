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
import com.willbank.instance.Archive;

import java.util.ArrayList;

/**
 * Created by nul010 on 2017-08-26.
 */


public class ArchiveAdapter extends BaseAdapter {
    ArrayList<Archive> archiveList;
    Context con;
    LayoutInflater inflater;
    int item_layout;

    public ArchiveAdapter(ArrayList<Archive> archiveList, Context con, int item_layout) {
        this.archiveList = archiveList;
        this.con = con;
        this.item_layout = item_layout;
        this.inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return archiveList.size();
    }

    @Override
    public Archive getItem(int position) {
        return archiveList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(item_layout, parent, false);

        Archive item = archiveList.get(position);


        ImageView bg_image = (ImageView) convertView.findViewById(R.id.bg_image);
        TextView price = (TextView) convertView.findViewById(R.id.price);
        TextView author = (TextView) convertView.findViewById(R.id.author);
        TextView contents = (TextView) convertView.findViewById(R.id.contents);

        Glide.with(con).load(item.img_resource_url).into(bg_image);
        price.setText(String.format("%,d",item.price));
        author.setText(item.author);
        contents.setText(item.contents);


        return convertView;
    }
}