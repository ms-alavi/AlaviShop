package com.example.alavishop.viewmodel;

import com.example.alavishop.model.product.Product;
import com.example.alavishop.model.product.ProductImage;

public class ProductViewModel {
    private Product mProduct;


    public Product getProduct() {
        return mProduct;
    }

    public void setProduct(Product product) {
        mProduct = product;
    }

    public ProductViewModel( Product product) {

        mProduct = product;
    }

    public String getName(){
        return mProduct.getName();
    }
    public String getPrice(){
        String str = String.format("%,d",Integer.parseInt(mProduct.getPrice()));

        return str+" تومان ";
    }

    //TODO : changing to mipmap
    public ProductImage getImage(){
        return mProduct.getImages().get(0);
    }
}
