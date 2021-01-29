package com.example.alavishop.network;

import java.util.HashMap;
import java.util.Map;

public class NetworkParams {
    public static class RetrofitConst {
        public static final String BASE_URL = "https://woocommerce.maktabsharif.ir/wp-json/wc/v3/";
        public static final String CONSUMER_KEY = "ck_9fc06c2a7292f136b852aceda63740458feb20e1";
        public static final String CONSUMER_SECRET = "cs_5608c8ad5f3ce5b02ac5c629fcad909da759f63a";
        public static final String KEY_AND_SECRET =
                "?consumer_key=ck_9fc06c2a7292f136b852aceda63740458feb20e1&consumer_secret=cs_5608c8ad5f3ce5b02ac5c629fcad909da759f63a" ;
    }

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

    public static class OrderTag{
        public static final String MOST_VISITING_PRODUCT = "popularity";
        public static final String MOST_RATING_PRODUCT = "rating";
        public static final String MOST_NEWEST_PRODUCT = "date";
        public static final String PRICE_PRODUCT = "price";
    }

    public static final Map<String, String> BASE_OPTIONS = new HashMap<String, String>() {{
        put("consumer_key", CONSUMER_KEY);
        put("consumer_secret", CONSUMER_SECRET);
    }};


    public static Map<String, String> getPopularProducts() {
        Map<String, String> popularProducts = new HashMap<>();
        popularProducts.putAll(BASE_OPTIONS);
        popularProducts.put("orderby", ORDER_BY_POPULARITY);
        popularProducts.put("order", ORDER_ASC);

        return popularProducts;
    }

    public static Map<String, String> getBestRateProducts() {
        Map<String, String> bestRatingProducts = new HashMap<>();
        bestRatingProducts.putAll(BASE_OPTIONS);
        bestRatingProducts.put("orderby", ORDER_BY_RATING);
        bestRatingProducts.put("order", ORDER_ASC);
        return bestRatingProducts;
    }

    public static Map<String, String> getNewestProducts() {
        Map<String, String> newestProducts = new HashMap<>();
        newestProducts.putAll(BASE_OPTIONS);
        newestProducts.put("orderby", ORDER_BY_DATE);
        newestProducts.put("order", ORDER_ASC);
        return newestProducts;
    }

    public static Map<String, String> AddKeyAndUser() {
        Map<String, String> keyAndUser = new HashMap<>();
        keyAndUser.putAll(BASE_OPTIONS);
        return keyAndUser;
    }

    public static Map<String, String> getAllCategories() {
        Map<String, String> allCategories = new HashMap<>();
        allCategories.putAll(BASE_OPTIONS);
        allCategories.put("per_page", "100");
        return allCategories;
    }

    public static Map<String, String> getMainCategories() {
        Map<String, String> mainCategories = new HashMap<>();
        mainCategories.putAll(BASE_OPTIONS);
        mainCategories.put("parent", "0");
        return mainCategories;
    }


    public static Map<String, String> getSortedProductsListWithCategory(int page
            ,int category
            ,String order
            ,String orderBy
            ,String search) {
        Map<String, String> sortedProduct = new HashMap<>();
        sortedProduct.putAll(BASE_OPTIONS);
        sortedProduct.put("page", page+"");
        sortedProduct.put("category", category+ "");
        sortedProduct.put("orderby", orderBy);
        sortedProduct.put("order", order);
        sortedProduct.put("search", search);
        return sortedProduct;
    }

    public static Map<String, String> getSortedProductsList(int page
            , String order
            , String orderBy
            , String search) {
        Map<String, String> sortedProduct = new HashMap<>();
        sortedProduct.putAll(BASE_OPTIONS);
        sortedProduct.put("page", page + "");
        sortedProduct.put("orderby", orderBy);
        sortedProduct.put("order", order);
        sortedProduct.put("search", search);
        return sortedProduct;
    }


}
