package com.example.alavishop.network.retrofit;

import com.example.alavishop.model.Category.Category;
import com.example.alavishop.model.Category.CategoryProduct;
import com.example.alavishop.model.product.Product;
import com.example.alavishop.networkmodel.product.WebserviceProductModel;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ShopService {

    @GET("products")
    Call<List<WebserviceProductModel>> orderedListItems(@QueryMap Map<String, String> options);

    @GET("products/categories/?per_page=100")
    Call<List<Category>> getAllCategories();
    @GET("products/categories/?parent=0")
    Call<List<Category>> getMainCategories();

    @GET("products/?featured=true")
    Call<List<WebserviceProductModel>> getFeaturedProducts();

    @GET("products/?featured=true")
    Call<List<WebserviceProductModel>> getAllProductWithPageFeatured
            (@Query("page") String pageNumber,
             @Query("orderby") String orderBy,
             @Query("order") String order,
             @Query("attribute_term") String... attributes);


    @GET("products/?")
    Call<List<WebserviceProductModel>> getProductsSubCategoires(@Query("page") String pageNumber, @Query("category") String categoryId
            , @Query("orderby") String orderBy, @Query("order") String order, @Query("attribute_term") String... attributes);

    @GET("products/?")
    Call<List<WebserviceProductModel>> searchProducts(@Query("page") String pageNumber, @Query("search") String productName
            , @Query("orderby") String orderBy, @Query("order") String order, @Query("attribute_term") String... attributes);

    /*
        @GET("products?")
        Call<List<Product>> getReleatedProducts(@Query("include") String... releateds);*/
    @GET("products?")
    Call<List<WebserviceProductModel>> getReleatedProducts(@Query("include") String... realated);


    @GET("products/?")
    Call<List<WebserviceProductModel>> getAllProductWithPage(@Query("page") String pageNumber, @Query("orderby") String orderBy, @Query("order") String order,
                                              @Query("attribute_term") String... attributes);

}
