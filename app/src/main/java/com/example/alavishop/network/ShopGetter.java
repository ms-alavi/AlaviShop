package com.example.alavishop.network;

import android.net.Uri;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ShopGetter {
    private String BASE_URL="https://woocommerce.maktabsharif.ir/wp-json/wc/v3/products ";

    public byte[] getByteUrl(String urlSpec)throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            InputStream inputStream = connection.getInputStream();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() + ": with " + urlSpec);
            }
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            byte[] result = outputStream.toByteArray();

            inputStream.close();
            outputStream.close();

            return result;
        } finally {
           connection .disconnect();
        }
    }
    public String getRecentUrl() {
        Uri uri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendQueryParameter("consumer_key", "ck_f025265e3479f7bee8e93bffe5685517b93ec27d")
                .appendQueryParameter("consumer_secret", "cs_27b19e572ac9cf1333d4d53f7082a15e9fb6a2b0")
                .build();

        return uri.toString();
    }

    public String getUrlString(String url) throws IOException {
        return new String(getByteUrl(url));
    }
}
