package com.example.alavishop.network.retrofit.deserializer;

import com.example.alavishop.model.Category.Category;
import com.example.alavishop.model.customer.Billing;
import com.example.alavishop.model.customer.Customer;
import com.example.alavishop.model.product.Product;
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

public class GetCustomersDeserializer implements JsonDeserializer<List<Customer>> {
    @Override
    public List<Customer> deserialize(JsonElement json
            , Type typeOfT
            , JsonDeserializationContext context) throws JsonParseException {
        List<Customer> customers = new ArrayList<>();
        JsonArray jsonArray=json.getAsJsonArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject customerObject = jsonArray.get(i).getAsJsonObject();

            int id = customerObject.get("id").getAsInt();
            String name = customerObject.get("first_name").getAsString();
            String lastName = customerObject.get("last_name").getAsString();
            String username = customerObject.get("username").getAsString();
            String email = customerObject.get("email").getAsString();
            Billing billing=extractBilling(customerObject);

            Customer customer = new Customer(id,name,lastName,email,billing,username);
            customers.add(customer);
        }
        return customers;
    }

    private Billing extractBilling(JsonObject object) {
          String name=object.get("first_name").getAsString();
          String lastName=object.get("last_name").getAsString();
          String firstAddress=object.get("address_1").getAsString();
          String secondAddress=object.get("address_2").getAsString();
          String city=object.get("city").getAsString();
          String country=object.get("country").getAsString();
          String email=object.get("email").getAsString();
          String phone=object.get("phone").getAsString();
          String postCode=object.get("postcode").getAsString();
        Billing billing=new Billing(  name,   lastName,
                firstAddress,   secondAddress,   city,
                country,   email,   phone,   postCode);
        return billing;

    }
}
