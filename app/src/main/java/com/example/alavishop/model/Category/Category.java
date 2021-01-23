package com.example.alavishop.model.Category;

import com.example.alavishop.model.product.ProductImage;

public class Category {
    private int mId;
    private String mName;
    private int mParent;
    private ProductImage mImage;

    public Category(int id, String name, int parent, ProductImage image) {
        mId = id;
        mName = name;
        mParent = parent;
        mImage = image;
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

    public int getParent() {
        return mParent;
    }

    public void setParent(int parent) {
        mParent = parent;
    }

    public ProductImage getImage() {
        return mImage;
    }

    public void setImage(ProductImage image) {
        mImage = image;
    }
}
