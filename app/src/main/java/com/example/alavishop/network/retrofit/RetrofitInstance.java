package com.example.alavishop.network.retrofit;

import com.example.alavishop.model.customer.Customer;
import com.example.alavishop.model.product.Product;
import com.example.alavishop.network.NetworkParams;
import com.example.alavishop.network.retrofit.deserializer.GetProductsDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static RetrofitInstance sInstance;
    private final Retrofit mRetrofit;

    public static RetrofitInstance getInstance() {
        if (sInstance == null)
            sInstance = new RetrofitInstance();

        return sInstance;
    }

    private static Converter.Factory createGsonConverterProduct() {
        Type typeProduct = new TypeToken<List<Product>>() {
        }.getType();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(typeProduct, new GetProductsDeserializer());
        gsonBuilder.registerTypeAdapter(typeProduct, new GetProductsDeserializer());
        Gson gson = gsonBuilder.create();

        return GsonConverterFactory.create(gson);
    }
    private static Converter.Factory createGsonConverterCustomer() {
        Type typeCustomer= new TypeToken<List<Customer>>() {
        }.getType();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(typeCustomer, new GetProductsDeserializer());
        gsonBuilder.registerTypeAdapter(typeCustomer, new GetProductsDeserializer());
        Gson gson = gsonBuilder.create();

        return GsonConverterFactory.create(gson);
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    private RetrofitInstance() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(NetworkParams.BASE_URL)
                .addConverterFactory(createGsonConverterProduct())
               .addConverterFactory(createGsonConverterCustomer())
                .build();
    }
}
