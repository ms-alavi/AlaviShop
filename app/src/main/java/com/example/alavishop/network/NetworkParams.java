package com.example.alavishop.network;

import java.util.HashMap;
import java.util.Map;

public class NetworkParams {

    public static final String BASE_URL = "https://woocommerce.maktabsharif.ir/wp-json/wc/v3/";
    public static final String CONSUMER_KEY ="ck_f025265e3479f7bee8e93bffe5685517b93ec27d";
    public static final String CONSUMER_SECRET ="cs_27b19e572ac9cf1333d4d53f7082a15e9fb6a2b0";
    public static final String ORDER_BY_RATING ="rating";
    public static final String ORDER_BY_POPULARITY ="popularity";
    public static final String ORDER_BY_PRICE ="price";
    public static final String ORDER_BY_DATE ="date";
    public static final String ORDER_ASC="asc";
    public static final String ORDER_DESC="desc";


    public static final Map<String, String> BASE_OPTIONS = new HashMap<String, String>() {{
        put("consumer_key", CONSUMER_KEY);
        put("consumer_secret", CONSUMER_SECRET);
    }};

    public static Map<String, String> getPopularProducts() {
        Map<String, String> popularProducts= new HashMap<>();
        popularProducts.putAll(BASE_OPTIONS);
        popularProducts.put("orderby", ORDER_BY_POPULARITY);
        popularProducts.put("order", ORDER_ASC);

        return popularProducts;
    }    public static Map<String, String> getNewestProducts() {
        Map<String, String> newestProducts= new HashMap<>();
        newestProducts.putAll(BASE_OPTIONS);
        newestProducts.put("orderby", ORDER_BY_DATE);
        newestProducts.put("order", ORDER_ASC);

        return newestProducts;
    }

    public static Map<String, String> getBestRateProducts() {
        Map<String, String> bestRatingProducts= new HashMap<>();
        bestRatingProducts.putAll(BASE_OPTIONS);
        bestRatingProducts.put("orderby", ORDER_BY_RATING);
        bestRatingProducts.put("order", ORDER_ASC);
        return bestRatingProducts;
    }

}
