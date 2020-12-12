package com.example.alavishop.model;

import java.io.Serializable;

public class ProductImage implements Serializable {
    private int mId;
    private String mUrl;

    public ProductImage(int id, String url) {
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
