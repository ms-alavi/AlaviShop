package com.example.alavishop.shop_repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.alavishop.model.Product;
import com.example.alavishop.network.NetworkParams;
import com.example.alavishop.network.retrofit.RetrofitInstance;
import com.example.alavishop.network.retrofit.ShopService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShopRepository {
    public static final String SR = "SR";
    public static final String REPOSITORY = "REPOSITORY";

    private List<Product> mProducts;
    private ShopService mShopService;
    private final MutableLiveData<List<Product>> mBestRateProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Product>> mNewestProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Product>> mPopularProductsLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Product>> getBestRateProductsLiveData() {
        return mBestRateProductsLiveData;
    }

    public MutableLiveData<List<Product>> getNewestProductsLiveData() {
        return mNewestProductsLiveData;
    }

    public MutableLiveData<List<Product>> getPopularProductsLiveData() {
        return mPopularProductsLiveData;
    }

    public List<Product> getProducts() {
        return mProducts;
    }

    public void setProducts(List<Product> products) {
        mProducts = products;
    }

    public ShopRepository() {
        Retrofit retrofit = RetrofitInstance.getInstance().getRetrofit();
        mShopService = retrofit.create(ShopService.class);

    }


    public void fetchBestRateProductsAsync() {

        Call<List<Product>> call =
                mShopService.orderedListItems(NetworkParams.getBestRateProducts());

        call.enqueue(new Callback<List<Product>>() {

            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> items = response.body();

                mBestRateProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchNewestProductsAsync() {
        Call<List<Product>> call =
                mShopService.orderedListItems(NetworkParams.getNewestProducts());

        call.enqueue(new Callback<List<Product>>() {

            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> items = response.body();

                mNewestProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchPopularProductsAsync() {
        Call<List<Product>> call =
                mShopService.orderedListItems(NetworkParams.getPopularProducts());

        call.enqueue(new Callback<List<Product>>() {

            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> items = response.body();

                mPopularProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }


}
