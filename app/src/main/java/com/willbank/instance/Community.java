package com.willbank.instance;

/**
 * Created by nul010 on 2017-08-26.
 */


public class Community {
    public int img_resource_url;
    public String title;
    public int count;
    public String date;
    public Community(int img_resource_url, String title, int count, String date){
        this.img_resource_url = img_resource_url;
        this.title = title;
        this.count = count;
        this.date = date;
    }


}