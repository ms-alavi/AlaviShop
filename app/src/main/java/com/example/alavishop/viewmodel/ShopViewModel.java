package com.example.alavishop.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.alavishop.model.product.Product;
import com.example.alavishop.shop_repository.ShopRepository;
import com.example.alavishop.utilities.QueryPreferences;

import java.util.List;

public class ShopViewModel extends AndroidViewModel {
    public static final String BEST_RATE_PRODUCT = "bestRateProduct";
    public static final String NEWEST_PRODUCT = "NewestProduct";
    public static final String POPULAR_PRODUCT = "popularProduct";
    private ShopRepository mShopRepository;

    private final MutableLiveData<List<Product>> mBestRateProductsLiveData;
    private final MutableLiveData<List<Product>> mNewestProductsLiveData;
    private final MutableLiveData<List<Product>> mPopularProductsLiveData;

    public MutableLiveData<List<Product>> getBestRateProductsLiveData() {
        return mBestRateProductsLiveData;
    }

    public MutableLiveData<List<Product>> getNewestProductsLiveData() {
        return mNewestProductsLiveData;
    }

    public MutableLiveData<List<Product>> getPopularProductsLiveData() {
        return mPopularProductsLiveData;
    }


    public ShopViewModel(@NonNull Application application) {
        super(application);
        mShopRepository = new ShopRepository();

        mBestRateProductsLiveData = mShopRepository.getBestRateProductsLiveData();
        mNewestProductsLiveData = mShopRepository.getNewestProductsLiveData();
        mPopularProductsLiveData = mShopRepository.getPopularProductsLiveData();
    }


    public void fetchBestRateProductsAsync() {
        mShopRepository.fetchBestRateProductsAsync();
    }

    public void fetchNewestProductsAsync() {
        mShopRepository.fetchNewestProductsAsync();
    }

    public void fetchPopularProductsAsync() {
        mShopRepository.fetchPopularProductsAsync();
    }

    public void fetchItems(@Nullable String method) {
        String query = QueryPreferences.getSearchQuery(getApplication());
        if (query != null) {
            //TODO: add search
            // fetchSearchItemsAsync(query);
        } else {
            fetchBestRateProductsAsync();
            fetchNewestProductsAsync();
            fetchPopularProductsAsync();
        }
    }




    public void setQueryInPreferences(String query) {
        QueryPreferences.setSearchQuery(getApplication(), query);
    }

    public String getQueryFromPreferences() {
        return QueryPreferences.getSearchQuery(getApplication());
    }
}
