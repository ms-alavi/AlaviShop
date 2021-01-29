package com.example.alavishop.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.alavishop.networkmodel.product.ProductResponse;
import com.example.alavishop.shop_repository.ShopRepository;
import com.example.alavishop.utilities.QueryPreferences;

import java.util.List;

public class ShopViewModel extends AndroidViewModel {

    private ShopRepository mShopRepository;

    private final MutableLiveData<List<ProductResponse>> mBestRateProductsLiveData;
    private final MutableLiveData<List<ProductResponse>> mNewestProductsLiveData;
    private final MutableLiveData<List<ProductResponse>> mPopularProductsLiveData;
    private final MutableLiveData<List<ProductResponse>> mSortProductsListMutableLiveData;
    private final MutableLiveData<List<ProductResponse>> mSortProductsListMutableLiveDataWithCategory;

    public MutableLiveData<List<ProductResponse>> getSortProductsListMutableLiveDataWithCategory() {
        return mSortProductsListMutableLiveDataWithCategory;
    }

    public MutableLiveData<List<ProductResponse>> getBestRateProductsLiveData() {
        return mBestRateProductsLiveData;
    }

    public MutableLiveData<List<ProductResponse>> getNewestProductsLiveData() {
        return mNewestProductsLiveData;
    }

    public MutableLiveData<List<ProductResponse>> getPopularProductsLiveData() {
        return mPopularProductsLiveData;
    }

    public MutableLiveData<ProductResponse> getSingleProduct(int productId){
        return mShopRepository.getSingleProduct(productId);
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

    public void fetchSortProductListAsync(int categoryId
            ,String orderBy
            ,String order
            ,String search
            ,int page){
        mShopRepository.fetchSortedProductList(orderBy,order,search,page);
    }
    public void fetchSortedProductListWithCategoryAsync(int categoryId
            ,String orderBy
            ,String order
            ,String search
            ,int page){
        mShopRepository.fetchSortedProductListWithCategory(categoryId,orderBy,order,search,page);
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
    public ShopViewModel(@NonNull Application application) {
        super(application);

        mShopRepository = new ShopRepository();
        mSortProductsListMutableLiveData = mShopRepository.getSortProductsListMutableLiveDataWithCategory();
        mBestRateProductsLiveData = mShopRepository.getBestRateProductsLiveData();
        mNewestProductsLiveData = mShopRepository.getNewestProductsLiveData();
        mPopularProductsLiveData = mShopRepository.getPopularProductsLiveData();
        mSortProductsListMutableLiveDataWithCategory = mShopRepository.getSortProductsListMutableLiveDataWithCategory();
    }

}
