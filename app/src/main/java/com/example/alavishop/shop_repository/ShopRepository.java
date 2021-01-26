package com.example.alavishop.shop_repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.alavishop.network.NetworkParams;
import com.example.alavishop.network.retrofit.RetrofitInstance;
import com.example.alavishop.network.retrofit.ShopService;
import com.example.alavishop.networkmodel.category.CategoryResponse;
import com.example.alavishop.networkmodel.product.ProductResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopRepository {
    public static final String SR = "SR";
    //code for product category

    public static final String TAG = "ShopRepository";

    private List<ProductResponse> mProducts;

    private final MutableLiveData<List<ProductResponse>> mBestRateProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<ProductResponse>> mNewestProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<ProductResponse>> mSortProductsListMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<ProductResponse>> mPopularProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<ProductResponse>> mDigitalProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<ProductResponse>> mClothesProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<ProductResponse>> mCreativityProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<ProductResponse>> mSuperMarketProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<ProductResponse>> mHealthProductsLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<CategoryResponse>> mAllCategoriesLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<CategoryResponse>> mMainCategoriesLiveData = new MutableLiveData<>();
    private MutableLiveData<ProductResponse> singleProductMutableLiveData;

    public MutableLiveData<List<ProductResponse>> getSortProductsListMutableLiveData() {
        return mSortProductsListMutableLiveData;
    }

    public MutableLiveData<List<CategoryResponse>> getMainCategoriesLiveData() {
        return mMainCategoriesLiveData;
    }

    public MutableLiveData<List<CategoryResponse>> getAllCategoriesLiveData() {
        return mAllCategoriesLiveData;
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

    public MutableLiveData<List<ProductResponse>> getDigitalProductsLiveData() {
        return mDigitalProductsLiveData;
    }

    public MutableLiveData<List<ProductResponse>> getClothesProductsLiveData() {
        return mClothesProductsLiveData;
    }

    public MutableLiveData<List<ProductResponse>> getCreativityProductsLiveData() {
        return mCreativityProductsLiveData;
    }

    public MutableLiveData<List<ProductResponse>> getSuperMarketProductsLiveData() {
        return mSuperMarketProductsLiveData;
    }

    public MutableLiveData<List<ProductResponse>> getHealthProductsLiveData() {
        return mHealthProductsLiveData;
    }


    public List<ProductResponse> getProducts() {
        return mProducts;
    }

    public void setProducts(List<ProductResponse> products) {
        mProducts = products;
    }

    public ShopRepository() {
     /*   Retrofit retrofit = RetrofitInstance.getRetrofit();
        mShopService = retrofit.create(ShopService.class);*/

    }


    public void fetchBestRateProductsAsync() {

        RetrofitInstance
                .getRetrofit()
                .create(ShopService.class)
                .orderedListItems(NetworkParams.getBestRateProducts())
                .enqueue(new Callback<List<ProductResponse>>() {

                    @Override
                    public void onResponse(Call<List<ProductResponse>> call, Response<List<ProductResponse>> response) {
                        List<ProductResponse> items = response.body();

                        mBestRateProductsLiveData.setValue(items);
                    }

                    @Override
                    public void onFailure(Call<List<ProductResponse>> call, Throwable t) {
                        Log.e(TAG, t.getMessage(), t);
                    }
                });
    }

    public void fetchNewestProductsAsync() {
        RetrofitInstance
                .getRetrofit()
                .create(ShopService.class)
                .orderedListItems(NetworkParams.getNewestProducts())
                .enqueue(new Callback<List<ProductResponse>>() {

                    @Override
                    public void onResponse(Call<List<ProductResponse>> call, Response<List<ProductResponse>> response) {
                        List<ProductResponse> items = response.body();

                        mNewestProductsLiveData.setValue(items);
                    }

                    @Override
                    public void onFailure(Call<List<ProductResponse>> call, Throwable t) {
                        Log.e(TAG, t.getMessage(), t);
                    }
                });
    }

    public void fetchPopularProductsAsync() {
        RetrofitInstance
                .getRetrofit()
                .create(ShopService.class)
                .orderedListItems(NetworkParams.getPopularProducts())
                .enqueue(new Callback<List<ProductResponse>>() {

                    @Override
                    public void onResponse(Call<List<ProductResponse>> call, Response<List<ProductResponse>> response) {
                        if (response.isSuccessful()) {
                            List<ProductResponse> items = response.body();

                            mPopularProductsLiveData.setValue(items);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ProductResponse>> call, Throwable t) {
                        Log.e(TAG, t.getMessage(), t);
                    }
                });
    }


    public void fetchHealthProductsAsync() {
        RetrofitInstance
                .getRetrofit()
                .create(ShopService.class)
                .orderedListItems(NetworkParams.getHealthProducts())
                .enqueue(new Callback<List<ProductResponse>>() {

                    @Override
                    public void onResponse(Call<List<ProductResponse>> call, Response<List<ProductResponse>> response) {
                        List<ProductResponse> items = response.body();

                        mHealthProductsLiveData.setValue(items);
                    }

                    @Override
                    public void onFailure(Call<List<ProductResponse>> call, Throwable t) {
                        Log.e(TAG, t.getMessage(), t);
                    }
                });
    }

    public void fetchClothesProductsAsync() {
        RetrofitInstance
                .getRetrofit()
                .create(ShopService.class)
                .orderedListItems(NetworkParams.getClothesProducts())
                .enqueue(new Callback<List<ProductResponse>>() {

                    @Override
                    public void onResponse(Call<List<ProductResponse>> call, Response<List<ProductResponse>> response) {
                        List<ProductResponse> items = response.body();

                        mClothesProductsLiveData.setValue(items);
                    }

                    @Override
                    public void onFailure(Call<List<ProductResponse>> call, Throwable t) {
                        Log.e(TAG, t.getMessage(), t);
                    }
                });
    }

    public void fetchMarketProductsAsync() {
        RetrofitInstance
                .getRetrofit()
                .create(ShopService.class)
                .orderedListItems(NetworkParams.getMarketProducts())
                .enqueue(new Callback<List<ProductResponse>>() {

                    @Override
                    public void onResponse(Call<List<ProductResponse>> call, Response<List<ProductResponse>> response) {
                        List<ProductResponse> items = response.body();

                        mSuperMarketProductsLiveData.setValue(items);
                    }

                    @Override
                    public void onFailure(Call<List<ProductResponse>> call, Throwable t) {
                        Log.e(TAG, t.getMessage(), t);
                    }
                });
    }

    public void fetchDigitalProductsAsync() {
        RetrofitInstance
                .getRetrofit()
                .create(ShopService.class)
                .orderedListItems(NetworkParams.getDigitalProducts())

        .enqueue(new Callback<List<ProductResponse>>() {

            @Override
            public void onResponse(Call<List<ProductResponse>> call, Response<List<ProductResponse>> response) {
                List<ProductResponse> items = response.body();

                mDigitalProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<ProductResponse>> call, Throwable t) {
                Log.e(TAG, t.getMessage(), t);
            }
        });
    }

    public void fetchCreativityProductsAsync() {
        RetrofitInstance
                .getRetrofit()
                .create(ShopService.class)
                .orderedListItems(NetworkParams.getCreativityProducts())

        .enqueue(new Callback<List<ProductResponse>>() {

            @Override
            public void onResponse(Call<List<ProductResponse>> call, Response<List<ProductResponse>> response) {
                List<ProductResponse> items = response.body();

                mCreativityProductsLiveData.setValue(items);
            }

            @Override
            public void onFailure(Call<List<ProductResponse>> call, Throwable t) {
                Log.e(TAG, t.getMessage(), t);
            }
        });
    }

    public void fetchAllCategoriesAsync() {
        RetrofitInstance
                .getRetrofit()
                .create(ShopService.class)
                .getAllCategories(NetworkParams.getAllCategories())
        .enqueue(new Callback<List<CategoryResponse>>() {
            @Override
            public void onResponse(Call<List<CategoryResponse>> call, Response<List<CategoryResponse>> response) {
                    List<CategoryResponse> items = response.body();
                    mAllCategoriesLiveData.setValue(items);
              /*  } else {
                    Log.e(TAG, "response is not successful");
                }*/

            }

            @Override
            public void onFailure(Call<List<CategoryResponse>> call, Throwable t) {
                Log.e(TAG, t.getMessage(), t);
            }
        });
    }

    public void fetchMainCategoriesAsync() {
        RetrofitInstance
                .getRetrofit()
                .create(ShopService.class)
                .getAllCategories(NetworkParams.getMainCategories())

        .enqueue(new Callback<List<CategoryResponse>>() {
            @Override
            public void onResponse(Call<List<CategoryResponse>> call, Response<List<CategoryResponse>> response) {

                    List<CategoryResponse> items = response.body();
                    mMainCategoriesLiveData.setValue(items);
              /*  } else {
                    Log.e(TAG, "response is not successful");
                }*/
            }

            @Override
            public void onFailure(Call<List<CategoryResponse>> call, Throwable t) {
                Log.e(TAG, t.getMessage(), t);
            }
        });
    }

    public MutableLiveData<ProductResponse> getSingleProduct(int productId) {
        singleProductMutableLiveData = new MutableLiveData<>();
        RetrofitInstance.getRetrofit().create(ShopService.class).getSingleProduct(productId,NetworkParams.AddKeyAndUser())
                .enqueue(new Callback<ProductResponse>() {
                    @Override
                    public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                        if (response.isSuccessful()) {
                            singleProductMutableLiveData.setValue(response.body());
                        } else {
                            singleProductMutableLiveData = null;
                        }
                    }

                    @Override
                    public void onFailure(Call<ProductResponse> call, Throwable t) {
                        singleProductMutableLiveData = null;
                    }
                });
        return singleProductMutableLiveData;
    }

    public void fetchSortedProductList(int categoryId, String orderBy
            , String order, String search, int page, String attribute, List<Integer> attributeTerm) {
        if (categoryId == 0) {
            RetrofitInstance.getRetrofit().create(ShopService.class).getSortedProductsList(order,
                    orderBy
                    , page
                    , search
                    , attribute
                    , attributeTerm).enqueue(new Callback<List<ProductResponse>>() {
                @Override
                public void onResponse(Call<List<ProductResponse>> call, Response<List<ProductResponse>> response) {
                    if (response.isSuccessful()) {
                        mSortProductsListMutableLiveData.setValue(response.body());

                    }
                }

                @Override
                public void onFailure(Call<List<ProductResponse>> call, Throwable t) {

                }
            });
        } else {
            RetrofitInstance.getRetrofit().create(ShopService.class).getSortedProductsListWithCategory(categoryId, order,
                    orderBy, page, search, attribute, attributeTerm).enqueue(new Callback<List<ProductResponse>>() {
                @Override
                public void onResponse(Call<List<ProductResponse>> call, Response<List<ProductResponse>> response) {
                    if (response.isSuccessful()) {
                        mSortProductsListMutableLiveData.setValue(response.body());

                    }
                }

                @Override
                public void onFailure(Call<List<ProductResponse>> call, Throwable t) {
                }
            });
        }
    }


}
