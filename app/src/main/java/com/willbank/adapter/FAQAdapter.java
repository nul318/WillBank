package com.willbank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.willbank.R;

import java.util.ArrayList;

/**
 * Created by nul010 on 2017-08-26.
 */


public class FAQAdapter extends BaseAdapter {
    ArrayList<String> faqList;
    Context con;
    LayoutInflater inflater;
    int item_layout;
    public FAQAdapter(ArrayList<String> faqList, Context con, int item_layout){
        this.faqList = faqList;
        this.con = con;
        this.item_layout = item_layout;
        this.inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return faqList.size();
    }

    @Override
    public String  getItem(int position) {
        return faqList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(item_layout, parent, false);

        TextView idx = (TextView) convertView.findViewById(R.id.idx);
        TextView comment = (TextView) convertView.findViewById(R.id.comment);

        idx.setText(String.valueOf(position+1));
        comment.setText(faqList.get(position));

        return convertView;
    }
}