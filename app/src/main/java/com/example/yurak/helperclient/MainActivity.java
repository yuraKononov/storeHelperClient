package com.example.yurak.helperclient;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TabHost;

import com.example.yurak.helperclient.Entities.Product;
import com.example.yurak.helperclient.Entities.ProductList;
import com.example.yurak.helperclient.Entities.Shop;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements HttpRequestGetProduct.CallBack,
                                                              HttpRequestGetShop.CallBack{

    private FragmentTabHost mTabHost;
    private ProductListAdapter productListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpRequestGetProduct httpRequestGetProduct = new HttpRequestGetProduct();
        httpRequestGetProduct.setCallBack(this);
        httpRequestGetProduct.execute();

        HttpRequestGetShop httpRequestGetShop = new HttpRequestGetShop();
        httpRequestGetShop.setCallBack(this);
        httpRequestGetShop.execute();

        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

    }

    @Override
    public void setProductList(ArrayList<ProductList> products) {
        Bundle arg = new Bundle();
        arg.putSerializable("products", products);

        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Все товары"),
                AllProductActivity.class, arg);

    }

    @Override
    public void setShop(ArrayList<Shop> shops) {
        Bundle arg = new Bundle();
        arg.putSerializable("shop", shops);

        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("Магазины"),
                ShopsActivity.class, arg);
    }
}
