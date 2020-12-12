package com.example.alavishop.network.retrofit;

import com.example.alavishop.model.Product;



import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ShopService {

    @GET("products")
    Call<List<Product>> orderedListItems(@QueryMap Map<String, String> options);


}
