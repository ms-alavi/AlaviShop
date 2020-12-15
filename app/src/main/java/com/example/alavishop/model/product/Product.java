package com.example.alavishop.model.product;

import com.example.alavishop.model.Category.Category;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private int mId;
    private String mName;
    private String mPrice;
    private String mUrl;
    private String mDescription;
    private List<ProductImage> mImages;
    private List<Category> mCategories;


    public Product(int id , String name, List<ProductImage> images, String price,
                   String url, String description,List<Category> categories) {
        mUrl=url;
        mId=id;
        mName = name;
        mCategories=categories;
        mPrice = price;
        mImages=images;
        mDescription=description;
    }

    public Product() {
    }
    public List<Category> getCategories() {
        return mCategories;
    }

    public void setCategories(List<Category> categories) {
        mCategories = categories;
    }
    public List<ProductImage> getImages() {
        return mImages;
    }

    public void setImages(List<ProductImage> images) {
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
        return fixText(mDescription);
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public static String fixText(String string) {

        StringBuilder text = new StringBuilder();

        if (string != null) {
            for (Character character : string.toCharArray()) {
                if (character.equals('<') || character.equals('>') || character.equals('/') ||
                        character.equals('p') || character.equals('b') || character.equals('r')) {
                } else
                    text.append(character);
            }
        }

        return text.toString();
    }
}
