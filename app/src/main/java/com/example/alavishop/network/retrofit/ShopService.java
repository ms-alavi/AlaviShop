package com.example.alavishop.network.retrofit;

import com.example.alavishop.model.Category.Category;
import com.example.alavishop.model.customer.Customer;
import com.example.alavishop.model.product.Product;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ShopService {

    @GET("products")
    Call<List<Product>> orderedListItems(@QueryMap Map<String, String> options);

    @GET("products/categories/?per_page=100")
    Call<List<Category>> getAllCategories();

    @GET("products/?featured=true")
    Call<List<Product>> getFeaturedProducts();

    @GET("products/?featured=true")
    Call<List<Product>> getAllProductWithPageFeatured
            (@Query("page") String pageNumber,
             @Query("orderby") String orderBy,
             @Query("order") String order,
             @Query("attribute_term") String... attributes);


    @GET("products/?")
    Call<List<Product>> getProductsSubCategoires(@Query("page") String pageNumber, @Query("category") String categoryId
            , @Query("orderby") String orderBy, @Query("order") String order, @Query("attribute_term") String... attributes);

    @GET("products/?")
    Call<List<Product>> searchProducts(@Query("page") String pageNumber, @Query("search") String productName
            , @Query("orderby") String orderBy, @Query("order") String order, @Query("attribute_term") String... attributes);

    /*
        @GET("products?")
        Call<List<Product>> getReleatedProducts(@Query("include") String... releateds);*/
    @GET("products?")
    Call<List<Product>> getReleatedProducts(@Query("include") String... realated);


    @GET("products/?")
    Call<List<Product>> getAllProductWithPage(@Query("page") String pageNumber, @Query("orderby") String orderBy, @Query("order") String order,
                                              @Query("attribute_term") String... attributes);

}
