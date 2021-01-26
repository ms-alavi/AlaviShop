package com.example.alavishop.viewmodel;

import com.example.alavishop.networkmodel.product.Image;
import com.example.alavishop.networkmodel.product.ProductResponse;

public class ProductViewModel {
    private ProductResponse mProduct;


    public ProductResponse getProduct() {
        return mProduct;
    }

    public void setProduct(ProductResponse product) {
        mProduct = product;
    }

    public ProductViewModel(ProductResponse product) {

        mProduct = product;
    }

    public String getName(){
        return mProduct.getName();
    }
    public String getPrice(){
        String str = String.format("%,d",Integer.parseInt(mProduct.getPrice()));

        return str+" تومان ";
    }

    public Image getImage(){
        return mProduct.getImages().get(0);
    }
}
