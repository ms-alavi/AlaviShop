package com.example.alavishop.network.retrofit;

import com.example.alavishop.model.Product;
import com.example.alavishop.model.ProductImage;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetProductsDeserializer implements JsonDeserializer<List<Product>> {

    @Override
    public List<Product> deserialize(
            JsonElement json,
            Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        List<Product> items = new ArrayList<>();
        JsonArray jsonArray=json.getAsJsonArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject productObject = jsonArray.get(i).getAsJsonObject();

            int id = productObject.get("id").getAsInt();
            String name = productObject.get("name").getAsString();
            String href= extractHref(productObject);
            String price = productObject.get("price").getAsString();
            String description = productObject.get("description").getAsString();
            List<ProductImage> images = extractImages(productObject);
            String slug=productObject.get("slug").getAsString();

            Product item = new Product(id,name,images,price,href,description);
            items.add(item);
        }

        return items;
    }


    private List<ProductImage> extractImages(JsonObject productObject) throws JsonParseException {
        JsonArray ImageArray=productObject.getAsJsonArray("images");
        List<ProductImage> images=new ArrayList<>();
        for (int i = 0; i <ImageArray.size() ; i++) {
            JsonObject jsonObject=ImageArray.get(i).getAsJsonObject();
            int id=jsonObject.get("id").getAsInt();
            String url=jsonObject.get("src").getAsString();
            ProductImage productImages=new ProductImage(id,url);
            images.add(productImages);
        }
        return images;
    }

    private String extractHref(JsonObject  productObject) throws JsonParseException {
        JsonObject links = productObject.getAsJsonObject("_links");
        JsonArray self = links.getAsJsonArray("self");
        //TODO : fix here don't use of getString
        JsonObject hrefObject=self.get(0).getAsJsonObject();
        String href=hrefObject.get("href").getAsString();
        return href;
    }


}
