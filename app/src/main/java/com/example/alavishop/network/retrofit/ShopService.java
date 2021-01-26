package com.example.alavishop.network.retrofit;

import com.example.alavishop.model.Category.Category;
import com.example.alavishop.network.NetworkParams;
import com.example.alavishop.networkmodel.category.CategoryResponse;
import com.example.alavishop.networkmodel.product.ProductResponse;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ShopService {

    @GET("products")
    Call<List<ProductResponse>> orderedListItems(@QueryMap Map<String, String> options);

    @GET(NetworkParams.RetrofitConst.BASE_URL + "products" + NetworkParams.RetrofitConst.KEY_AND_SECRET)
    Call<List<ProductResponse>> getSortedProductsListWithCategory
            (@Query("category") int category
                    , @Query("order") String order
                    , @Query("orderby") String orderBy
                    , @Query("page") int page
                    , @Query("search") String search
                    , @Query("attribute") String attribute
                    , @Query("attribute_term") List<Integer> attributeTerm);

    @GET(NetworkParams.RetrofitConst.BASE_URL + "products" + NetworkParams.RetrofitConst.KEY_AND_SECRET)
    Call<List<ProductResponse>> getSortedProductsList
            (@Query("order") String order,
             @Query("orderby") String orderBy
                    , @Query("page") int page
                    , @Query("search") String search
                    , @Query("attribute") String attribute
                    , @Query("attribute_term") List<Integer> attributeTerm);

    @GET("products/categories")
    Call<List<CategoryResponse>> getAllCategories(@QueryMap Map<String, String> options);

    @GET("products/{id}")
    Call<ProductResponse> getSingleProduct(@Path("id") int productId, @QueryMap Map<String, String> options);

    @GET("products/?featured=true")
    Call<List<ProductResponse>> getFeaturedProducts();

    @GET("products/?featured=true")
    Call<List<ProductResponse>> getAllProductWithPageFeatured
            (@Query("page") String pageNumber,
             @Query("orderby") String orderBy,
             @Query("order") String order,
             @Query("attribute_term") String... attributes);


    @GET("products/?")
    Call<List<ProductResponse>> getProductsSubCategories(@Query("page") String pageNumber
            , @Query("category") String categoryId
            , @Query("orderby") String orderBy
            , @Query("order") String order
            , @Query("attribute_term") String... attributes);

    @GET("products/?")
    Call<List<ProductResponse>> searchProducts(@Query("page") String pageNumber, @Query("search") String productName
            , @Query("orderby") String orderBy, @Query("order") String order, @Query("attribute_term") String... attributes);

    /*
        @GET("products?")
        Call<List<Product>> getRelatedProducts(@Query("include") String... relates);*/
    @GET("products?")
    Call<List<ProductResponse>> getRelatedProducts(@Query("include") String... related);


    @GET("products/?")
    Call<List<ProductResponse>> getAllProductWithPage(@Query("page") String pageNumber
            , @Query("orderby") String orderBy
            , @Query("order") String order
            , @Query("attribute_term") String... attributes);

}
