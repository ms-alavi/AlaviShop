package com.example.alavishop.network.retrofit.deserializer;

import com.example.alavishop.model.Category.Category;
import com.example.alavishop.model.Category.CategoryProduct;
import com.example.alavishop.model.customer.Billing;
import com.example.alavishop.model.customer.Customer;
import com.example.alavishop.model.product.ProductImage;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetCategoryDeserializer implements JsonDeserializer<List<Category>> {
    @Override
    public List<Category> deserialize(JsonElement json
            , Type typeOfT
            , JsonDeserializationContext context) throws JsonParseException {
        List<Category> categories = new ArrayList<>();
        JsonArray jsonArray=json.getAsJsonArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject categoryObject = jsonArray.get(i).getAsJsonObject();

            int id = categoryObject.get("id").getAsInt();
            int parent = categoryObject.get("parent").getAsInt();
            String name = categoryObject.get("first_name").getAsString();
            ProductImage image=extractProductImage(categoryObject);


            Category category = new Category(id,name,parent,image);
            categories.add(category);
        }
        return categories;
    }
    private ProductImage extractProductImage(JsonObject categoryObject) {
        return new ProductImage(categoryObject.get("id").getAsInt()
                , categoryObject.get("src").getAsString());
    }

}
