package com.example.alavishop.viewmodel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.alavishop.model.Category.Category;
import com.example.alavishop.model.Category.CategoryProduct;
import com.example.alavishop.networkmodel.category.CategoryResponse;
import com.example.alavishop.shop_repository.ShopRepository;

import java.util.List;


public class CategoryViewModel extends AndroidViewModel {
    private MutableLiveData<List<CategoryResponse>> mAllCategories;
    private MutableLiveData<List<CategoryResponse>> mMainCategories;
    private ShopRepository mShopRepository;

    public MutableLiveData<List<CategoryResponse>> getAllCategories() {
        return mAllCategories;
    }

    public MutableLiveData<List<CategoryResponse>> getMainCategories() {
        return mMainCategories;
    }

    public CategoryViewModel(@NonNull Application application) {
        super(application);
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
