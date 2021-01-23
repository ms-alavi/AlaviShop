package com.example.alavishop.viewmodel;


import androidx.lifecycle.MutableLiveData;

import com.example.alavishop.model.Category.Category;
import com.example.alavishop.model.Category.CategoryProduct;
import com.example.alavishop.shop_repository.ShopRepository;

import java.util.List;


public class CategoryViewModel {
    private MutableLiveData<List<Category>> mAllCategories;
    private MutableLiveData<List<Category>> mMainCategories;
    private ShopRepository mShopRepository;

    public MutableLiveData<List<Category>> getAllCategories() {
        return mAllCategories;
    }

    public MutableLiveData<List<Category>> getMainCategories() {
        return mMainCategories;
    }

    public CategoryViewModel() {
        mShopRepository = new ShopRepository();
        mAllCategories = mShopRepository.getAllCategoriesLiveData();
        mMainCategories = mShopRepository.getMainCategoriesLiveData();

    }

    public void fetchAllCategoriesAsync() {
        mShopRepository.fetchAllCategoriesAsync();
    }

    public void fetchMainCategoriesAsync() {
        mShopRepository.fetchMainCategoriesAsync();
    }
}
