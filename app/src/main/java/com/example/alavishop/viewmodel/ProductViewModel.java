package com.example.alavishop.viewmodel;

import com.example.alavishop.networkmodel.product.Image;
import com.example.alavishop.networkmodel.product.WebserviceProductModel;

public class ProductViewModel {
    private WebserviceProductModel mProduct;


    public WebserviceProductModel getProduct() {
        return mProduct;
    }

    public void setProduct(WebserviceProductModel product) {
        mProduct = product;
    }

    public ProductViewModel(WebserviceProductModel product) {

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
    public Image getImage(){
        return mProduct.getImages().get(0);
    }
}
