package com.example.alavishop.network;

import java.util.HashMap;
import java.util.Map;

public class NetworkParams {

    public static final String BASE_URL = "https://woocommerce.maktabsharif.ir/wp-json/wc/v3/";
    public static final String CONSUMER_KEY = "ck_f025265e3479f7bee8e93bffe5685517b93ec27d";
    public static final String CONSUMER_SECRET = "cs_27b19e572ac9cf1333d4d53f7082a15e9fb6a2b0";
    public static final String ORDER_BY_RATING = "rating";
    public static final String ORDER_BY_POPULARITY = "popularity";
    public static final String ORDER_BY_PRICE = "price";
    public static final String ORDER_BY_DATE = "date";
    public static final String ORDER_ASC = "asc";
    public static final String ORDER_DESC = "desc";

    public static final int DIGITAL_CODE = 52;
    public static final int CLOTHES_CODE = 62;
    public static final int CREATIVITY_CODE = 76;
    public static final int SUPERMARKET_CODE = 81;
    public static final int HEALTH_CODE = 121;


    public static final Map<String, String> BASE_OPTIONS = new HashMap<String, String>() {{
        put("consumer_key", CONSUMER_KEY);
        put("consumer_secret", CONSUMER_SECRET);
    }};

    public static Map<String, String> getPopularProducts() {
        Map<String, String> popularProducts = new HashMap<>();
        popularProducts.putAll(BASE_OPTIONS);
        // popularProducts.put("per_page", "100");
        popularProducts.put("orderby", ORDER_BY_POPULARITY);
        popularProducts.put("order", ORDER_ASC);

        return popularProducts;
    }

    public static Map<String, String> getNewestProducts() {
        Map<String, String> newestProducts = new HashMap<>();
        newestProducts.putAll(BASE_OPTIONS);
        newestProducts.put("orderby", ORDER_BY_DATE);
        newestProducts.put("order", ORDER_ASC);
        // newestProducts.put("per_page", "100");
        return newestProducts;
    }

    public static Map<String, String> getBestRateProducts() {
        Map<String, String> bestRatingProducts = new HashMap<>();
        bestRatingProducts.putAll(BASE_OPTIONS);
        bestRatingProducts.put("orderby", ORDER_BY_RATING);
        bestRatingProducts.put("order", ORDER_ASC);
        //TODO:
        //    bestRatingProducts.put("per_page", "100");
        return bestRatingProducts;
    }

    public static Map<String, String> getHealthProducts() {
        Map<String, String> products = new HashMap<>();
        products.putAll(BASE_OPTIONS);
        //TODO: get another page for products
        //products.put("page", i+"");
        products.put("category", HEALTH_CODE + "");
        return products;
    }

    public static Map<String, String> getDigitalProducts() {
        Map<String, String> products = new HashMap<>();
        products.putAll(BASE_OPTIONS);
        //TODO: get another page for products
        //products.put("page", i+"");
        products.put("category", DIGITAL_CODE + "");
        return products;
    }

    public static Map<String, String> getClothesProducts() {
        Map<String, String> products = new HashMap<>();
        products.putAll(BASE_OPTIONS);
        //TODO: get another page for products
        //products.put("page", i+"");
        products.put("category", CLOTHES_CODE + "");
        return products;
    }

    public static Map<String, String> getMarketProducts() {
        Map<String, String> products = new HashMap<>();
        products.putAll(BASE_OPTIONS);
        //TODO: get another page for products
        //products.put("page", i+"");
        products.put("category", SUPERMARKET_CODE + "");
        return products;
    }

    public static Map<String, String> getCreativityProducts() {
        Map<String, String> products = new HashMap<>();
        products.putAll(BASE_OPTIONS);
        //TODO: get another page for products
        //products.put("page", i+"");
        products.put("category", CREATIVITY_CODE + "");
        return products;
    }


}
