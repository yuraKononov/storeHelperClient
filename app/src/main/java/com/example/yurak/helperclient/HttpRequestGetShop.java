package com.example.yurak.helperclient;

import android.os.AsyncTask;
import android.util.Log;

import com.example.yurak.helperclient.Entities.Shop;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yurak on 05.05.2018.
 */

public class HttpRequestGetShop extends AsyncTask<Void, Void, ArrayList<Shop>> {

    private CallBack callBack;

    public void setCallBack(final CallBack callBack){
        this.callBack = callBack;
    }

    @Override
    protected ArrayList<Shop> doInBackground(Void... voids) {
        try {
            final String url = "http://192.168.43.94:8080/shop/get_all";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<Shop[]> test = restTemplate.getForEntity(url,
                    Shop[].class);
            ArrayList<Shop> shops = new ArrayList<>(Arrays.asList(test.getBody()));
            return shops;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Shop> shops) {
        //productListAdapter = new ProductListAdapter(this, products);
        //productListAdapter.setProductLists(products);

        if(callBack != null)
            callBack.setShop(shops);
    }

    public interface CallBack {
        public void setShop(ArrayList<Shop> shops);
    }
}