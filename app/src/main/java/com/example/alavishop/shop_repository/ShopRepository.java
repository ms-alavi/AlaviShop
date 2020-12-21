package com.example.alavishop.shop_repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.alavishop.model.product.Product;
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
    //code for product category


    private List<Product> mProducts;
    private ShopService mShopService;

    private final MutableLiveData<List<Product>> mBestRateProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Product>> mNewestProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Product>> mPopularProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Product>> mDigitalProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Product>> mClothesProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Product>> mCreativityProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Product>> mSuperMarketProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Product>> mHealthProductsLiveData = new MutableLiveData<>();


    public MutableLiveData<List<Product>> getBestRateProductsLiveData() {
        return mBestRateProductsLiveData;
    }

    public MutableLiveData<List<Product>> getNewestProductsLiveData() {
        return mNewestProductsLiveData;
    }

    public MutableLiveData<List<Product>> getPopularProductsLiveData() {
        return mPopularProductsLiveData;
    }

    public MutableLiveData<List<Product>> getDigitalProductsLiveData() {
        return mDigitalProductsLiveData;
    }

    public MutableLiveData<List<Product>> getClothesProductsLiveData() {
        return mClothesProductsLiveData;
    }

    public MutableLiveData<List<Product>> getCreativityProductsLiveData() {
        return mCreativityProductsLiveData;
    }

    public MutableLiveData<List<Product>> getSuperMarketProductsLiveData() {
        return mSuperMarketProductsLiveData;
    }

    public MutableLiveData<List<Product>> getHealthProductsLiveData() {
        return mHealthProductsLiveData;
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


    public void fetchHealthProductsAsync() {
        Call<List<Product>> call =
                mShopService.orderedListItems(NetworkParams.getHealthProducts());

        call.enqueue(new Callback<List<Product>>() {

            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> items = response.body();

                mHealthProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchClothesProductsAsync() {
        Call<List<Product>> call =
                mShopService.orderedListItems(NetworkParams.getClothesProducts());

        call.enqueue(new Callback<List<Product>>() {

            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> items = response.body();

                mClothesProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchMarketProductsAsync() {
        Call<List<Product>> call =
                mShopService.orderedListItems(NetworkParams.getMarketProducts());

        call.enqueue(new Callback<List<Product>>() {

            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> items = response.body();

                mSuperMarketProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchDigitalProductsAsync() {
        Call<List<Product>> call =
                mShopService.orderedListItems(NetworkParams.getDigitalProducts());

        call.enqueue(new Callback<List<Product>>() {

            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> items = response.body();

                mDigitalProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchCreativityProductsAsync() {
        Call<List<Product>> call =
                mShopService.orderedListItems(NetworkParams.getCreativityProducts());

        call.enqueue(new Callback<List<Product>>() {

            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> items = response.body();

                mCreativityProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }


}
