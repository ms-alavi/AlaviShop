package com.example.alavishop.shop_repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.alavishop.model.Category.Category;
import com.example.alavishop.model.Category.CategoryProduct;
import com.example.alavishop.model.product.Product;
import com.example.alavishop.network.NetworkParams;
import com.example.alavishop.network.retrofit.RetrofitInstance;
import com.example.alavishop.network.retrofit.ShopService;
import com.example.alavishop.networkmodel.product.WebserviceProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShopRepository {
    public static final String SR = "SR";
    public static final String REPOSITORY = "REPOSITORY";
    //code for product category


    private List<WebserviceProductModel> mProducts;
    private ShopService mShopService;

    private final MutableLiveData<List<WebserviceProductModel>> mBestRateProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<WebserviceProductModel>> mNewestProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<WebserviceProductModel>> mPopularProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<WebserviceProductModel>> mDigitalProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<WebserviceProductModel>> mClothesProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<WebserviceProductModel>> mCreativityProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<WebserviceProductModel>> mSuperMarketProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<WebserviceProductModel>> mHealthProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Category>> mAllCategoriesLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<Category>> mMainCategoriesLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Category>> getMainCategoriesLiveData() {
        return mMainCategoriesLiveData;
    }

    public MutableLiveData<List<Category>> getAllCategoriesLiveData() {
        return mAllCategoriesLiveData;
    }

    public MutableLiveData<List<WebserviceProductModel>> getBestRateProductsLiveData() {
        return mBestRateProductsLiveData;
    }

    public MutableLiveData<List<WebserviceProductModel>> getNewestProductsLiveData() {
        return mNewestProductsLiveData;
    }

    public MutableLiveData<List<WebserviceProductModel>> getPopularProductsLiveData() {
        return mPopularProductsLiveData;
    }

    public MutableLiveData<List<WebserviceProductModel>> getDigitalProductsLiveData() {
        return mDigitalProductsLiveData;
    }

    public MutableLiveData<List<WebserviceProductModel>> getClothesProductsLiveData() {
        return mClothesProductsLiveData;
    }

    public MutableLiveData<List<WebserviceProductModel>> getCreativityProductsLiveData() {
        return mCreativityProductsLiveData;
    }

    public MutableLiveData<List<WebserviceProductModel>> getSuperMarketProductsLiveData() {
        return mSuperMarketProductsLiveData;
    }

    public MutableLiveData<List<WebserviceProductModel>> getHealthProductsLiveData() {
        return mHealthProductsLiveData;
    }


    public List<WebserviceProductModel> getProducts() {
        return mProducts;
    }

    public void setProducts(List<WebserviceProductModel> products) {
        mProducts = products;
    }

    public ShopRepository() {
        Retrofit retrofit = RetrofitInstance.getRetrofit();
        mShopService = retrofit.create(ShopService.class);

    }


    public void fetchBestRateProductsAsync() {

        Call<List<WebserviceProductModel>> call =
                mShopService.orderedListItems(NetworkParams.getBestRateProducts());

        call.enqueue(new Callback<List<WebserviceProductModel>>() {

            @Override
            public void onResponse(Call<List<WebserviceProductModel>> call, Response<List<WebserviceProductModel>> response) {
                List<WebserviceProductModel> items = response.body();

                mBestRateProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<WebserviceProductModel>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchNewestProductsAsync() {
        Call<List<WebserviceProductModel>> call =
                mShopService.orderedListItems(NetworkParams.getNewestProducts());

        call.enqueue(new Callback<List<WebserviceProductModel>>() {

            @Override
            public void onResponse(Call<List<WebserviceProductModel>> call, Response<List<WebserviceProductModel>> response) {
                List<WebserviceProductModel> items = response.body();

                mNewestProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<WebserviceProductModel>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchPopularProductsAsync() {
        Call<List<WebserviceProductModel>> call =
                mShopService.orderedListItems(NetworkParams.getPopularProducts());

        call.enqueue(new Callback<List<WebserviceProductModel>>() {

            @Override
            public void onResponse(Call<List<WebserviceProductModel>> call, Response<List<WebserviceProductModel>> response) {
                List<WebserviceProductModel> items = response.body();

                mPopularProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<WebserviceProductModel>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }


    public void fetchHealthProductsAsync() {
        Call<List<WebserviceProductModel>> call =
                mShopService.orderedListItems(NetworkParams.getHealthProducts());

        call.enqueue(new Callback<List<WebserviceProductModel>>() {

            @Override
            public void onResponse(Call<List<WebserviceProductModel>> call, Response<List<WebserviceProductModel>> response) {
                List<WebserviceProductModel> items = response.body();

                mHealthProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<WebserviceProductModel>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchClothesProductsAsync() {
        Call<List<WebserviceProductModel>> call =
                mShopService.orderedListItems(NetworkParams.getClothesProducts());

        call.enqueue(new Callback<List<WebserviceProductModel>>() {

            @Override
            public void onResponse(Call<List<WebserviceProductModel>> call, Response<List<WebserviceProductModel>> response) {
                List<WebserviceProductModel> items = response.body();

                mClothesProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<WebserviceProductModel>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchMarketProductsAsync() {
        Call<List<WebserviceProductModel>> call =
                mShopService.orderedListItems(NetworkParams.getMarketProducts());

        call.enqueue(new Callback<List<WebserviceProductModel>>() {

            @Override
            public void onResponse(Call<List<WebserviceProductModel>> call, Response<List<WebserviceProductModel>> response) {
                List<WebserviceProductModel> items = response.body();

                mSuperMarketProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<WebserviceProductModel>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchDigitalProductsAsync() {
        Call<List<WebserviceProductModel>> call =
                mShopService.orderedListItems(NetworkParams.getDigitalProducts());

        call.enqueue(new Callback<List<WebserviceProductModel>>() {

            @Override
            public void onResponse(Call<List<WebserviceProductModel>> call, Response<List<WebserviceProductModel>> response) {
                List<WebserviceProductModel> items = response.body();

                mDigitalProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<WebserviceProductModel>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchCreativityProductsAsync() {
        Call<List<WebserviceProductModel>> call =
                mShopService.orderedListItems(NetworkParams.getCreativityProducts());

        call.enqueue(new Callback<List<WebserviceProductModel>>() {

            @Override
            public void onResponse(Call<List<WebserviceProductModel>> call, Response<List<WebserviceProductModel>> response) {
                List<WebserviceProductModel> items = response.body();

                mCreativityProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<WebserviceProductModel>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchAllCategoriesAsync() {
        Call<List<Category>> call =
                mShopService.getAllCategories();

        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                List<Category> items = response.body();
                mAllCategoriesLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }

    public void fetchMainCategoriesAsync() {
        Call<List<Category>> call =
                mShopService.getMainCategories();

        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                List<Category> items = response.body();
                mMainCategoriesLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.e(REPOSITORY, t.getMessage(), t);
            }
        });
    }


}
