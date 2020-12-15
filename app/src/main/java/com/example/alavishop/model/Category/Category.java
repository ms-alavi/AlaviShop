package com.example.alavishop.model.Category;

import android.media.Image;

import com.example.alavishop.model.product.ProductImage;

public class Category {
    private long id;

    private String name;

   /* private long parent;

    private long count;*/

    private String slug;

  //  private ProductImage image;

    public Category(long id, String name, String slug) {
        this.id = id;
        this.name = name;
//        this.parent = parent;
//        this.count = count;
        this.slug = slug;
    //    this.image = image;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

/*    public long getParent() {
        return parent;
    }

    public long getCount() {
        return count;
    }*/

    public String getSlug() {
        return slug;
    }

    /*public ProductImage getImage() {
        return image;
    }*/
}