package com.example.yurak.helperclient;

import android.os.AsyncTask;
import android.util.Log;

import com.example.yurak.helperclient.Entities.ProductList;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yurak on 14.05.2018.
 */

public class HttpRequestGetSimilarProduct extends AsyncTask<Integer, Void, ArrayList<ProductList>> {

private CallBack callBack;

public void setCallBack(final CallBack callBack){
        this.callBack = callBack;
}

    @Override
    protected ArrayList<ProductList> doInBackground(Integer... params) {
        try {
            final String url = "http://192.168.43.94:8080/product_list/get_similar/" +
                    "s_id=" + params[0] + "&p_id=" + params[1];
            Log.d("Params1; ",params[0].toString() + " " + params[1].toString());
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<ProductList[]> test = restTemplate.getForEntity(url,
                    ProductList[].class);
            ArrayList<ProductList> productLists = new ArrayList<>(Arrays.asList(test.getBody()));
            return productLists;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(ArrayList<ProductList> productLists) {

        if(callBack != null)
            callBack.setSimilarProductList(productLists);
    }

    public interface CallBack {
        public void setSimilarProductList(ArrayList<ProductList> productLists);
    }

}
