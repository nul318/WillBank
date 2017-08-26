package com.willbank.instance;

/**
 * Created by nul010 on 2017-08-26.
 */


public class Archive {
    public int img_resource_url;
    public String contents;
    public String author;
    public int price;

    public Archive(int img_resource_url, String contents, String author, int price){
        this.img_resource_url = img_resource_url;
        this.contents = contents;
        this.author = author;
        this.price = price;
    }


}