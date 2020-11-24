package com.example.alavishop.model;

import android.media.Image;

import java.util.List;

public class Product {
    private int mId;
    private String mName;
    private String mPrice;
    private String mUrl;
    private String mDescription;
    private List<ProductImages> mImages;


    public Product(int id ,String name, List<ProductImages> images, String price, String url,String description) {
        mUrl=url;
        mId=id;
        mName = name;
        mPrice = price;
        mImages=images;
        mDescription=description;
    }

    public Product() {
    }

    public List<ProductImages> getImages() {
        return mImages;
    }

    public void setImages(List<ProductImages> images) {
        mImages = images;
    }
    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
