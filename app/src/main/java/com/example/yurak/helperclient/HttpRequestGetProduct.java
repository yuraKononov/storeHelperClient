package com.example.yurak.helperclient;

import android.os.AsyncTask;
import android.util.Log;

import com.example.yurak.helperclient.Entities.ProductList;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

public class HttpRequestGetProduct extends AsyncTask<Void, Void, ArrayList<ProductList>> {

    private CallBack callBack;

    public void setCallBack(final CallBack callBack){
        this.callBack = callBack;
    }

    @Override
    protected ArrayList<ProductList> doInBackground(Void... voids) {
        try {
            final String url = "http://192.168.43.94:8080/product_list/get_all";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<ProductList[]> test = restTemplate.getForEntity(url,
                    ProductList[].class);
            ArrayList<ProductList> products = new ArrayList<>(Arrays.asList(test.getBody()));
            return products;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<ProductList> products) {

        if(callBack != null)
            callBack.setProductList(products);
    }

    public interface CallBack {
        public void setProductList(ArrayList<ProductList> products);
    }
}
