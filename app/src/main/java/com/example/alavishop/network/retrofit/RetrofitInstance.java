package com.example.alavishop.network.retrofit;

import com.example.alavishop.model.Category.CategoryProduct;
import com.example.alavishop.model.customer.Customer;
import com.example.alavishop.model.product.Product;
import com.example.alavishop.network.NetworkParams;
import com.example.alavishop.network.retrofit.deserializer.GetProductsDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;
    private static Retrofit mapRetrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(NetworkParams.RetrofitConst.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
/*
    public static Retrofit getMapRetrofit() {
        if (mapRetrofit == null) {
            mapRetrofit = new Retrofit.Builder().baseUrl(NetworkParams.RetrofitConst.BASE_URL_GEOCODING_MAP_IR)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mapRetrofit;
    }*/

}
