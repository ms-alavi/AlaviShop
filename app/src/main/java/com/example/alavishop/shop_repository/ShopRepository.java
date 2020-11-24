package com.example.alavishop.shop_repository;
import android.util.Log;
import com.example.alavishop.model.Product;
import com.example.alavishop.model.ProductImages;
import com.example.alavishop.network.ShopGetter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopRepository {
    public static final String SR = "SR";
    private ShopGetter mGetter;

    private List<Product> mProducts;

    public List<Product> getProducts() {
        return mProducts;
    }

    public void setProducts(List<Product> products) {
        mProducts = products;
    }

    public ShopRepository() {
        mGetter = new ShopGetter();
    }

    //this method must run on background thread.
    public List<Product> getItems() {
        String url = mGetter.getRecentUrl();
        try {
            String response = mGetter.getUrlString(url);
            Log.d(SR, "response: " + response);
            List<Product> items =parseJson(response);
            return items;
        } catch (IOException  | JSONException e) {
            Log.e(SR, e.getMessage(), e);
            return null;
        }
    }


    private List<Product> parseJson(String response) throws JSONException {
        List<Product> items = new ArrayList<>();

        JSONArray  jsonArray=new JSONArray(response);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject productObject = jsonArray.getJSONObject(i);

            if (!productObject.has("url_s"))
                continue;

            int id = productObject.getInt("id");
            String name = productObject.getString("name");
            String href= extractHref(productObject);
            String price = productObject.getString("price");
            String description = productObject.getString("description");
            List<ProductImages> images = extractImages(productObject);

            Product item = new Product(id,name,images,price,href,description);
            items.add(item);
        }

        return items;
    }

    private List<ProductImages> extractImages(JSONObject productObject) throws JSONException {
        JSONArray ImageArray=productObject.getJSONArray("images");
        List<ProductImages> images=new ArrayList<>();
        for (int i = 0; i <ImageArray.length() ; i++) {
            JSONObject jsonObject=ImageArray.getJSONObject(i);
            int id=jsonObject.getInt("id");
            String url=jsonObject.getString("src");
            ProductImages productImages=new ProductImages(id,url);
            images.add(productImages);
        }
        return images;
    }

    private String extractHref(JSONObject productObject) throws JSONException {
        JSONArray links = productObject.getJSONArray("_links");
        JSONArray self = links.getJSONArray(0);
        String href=self.getString(0);
        return href;
    }
}
