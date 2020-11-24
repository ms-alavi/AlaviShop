package com.example.alavishop.model;

public class ProductImages {
    private int mId;
    private String mUrl;

    public ProductImages(int id, String url) {
        mId = id;
        mUrl = url;
    }



    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
