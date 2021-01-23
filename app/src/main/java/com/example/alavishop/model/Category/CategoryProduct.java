package com.example.alavishop.model.Category;

import android.media.Image;

import androidx.annotation.Nullable;

import com.example.alavishop.model.product.ProductImage;

import java.io.Serializable;

public class CategoryProduct implements Serializable {
    private long id;

    private String name;

    private String slug;

    public CategoryProduct(long id, String name, String slug) {
        this.id = id;
        this.name = name;
        this.slug = slug;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getSlug() {
        return slug;
    }
}