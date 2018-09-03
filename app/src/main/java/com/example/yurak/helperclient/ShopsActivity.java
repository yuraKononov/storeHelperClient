package com.example.yurak.helperclient;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.yurak.helperclient.Entities.Product;
import com.example.yurak.helperclient.Entities.ProductList;
import com.example.yurak.helperclient.Entities.Shop;

import java.util.ArrayList;

/**
 * Created by yurak on 01.05.2018.
 */

public class ShopsActivity extends Fragment{

    private ShopAdapter shopAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.activity_shops, container, false);

        ArrayList<ProductList> test = new ArrayList<>();
        test.add(new ProductList(new Product("https://dixy.ru/upload/iblock/17d/ЦТ0038253.jpg", "test yablochko"),
                new Shop("test_name", "test_address"), 100, 10, null, null));
        test.add(new ProductList(new Product("https://dixy.ru/upload/iblock/fa6/10E0076186.jpg", "test yablochko2 a tak ge mnogo teksta, 250г"),
                new Shop("test_name", "test_address"), 100, 10, null, null));
        test.add(new ProductList(new Product("https://dixy.ru/upload/iblock/c18/DI00078738.jpg", "test mandarin"),
                new Shop("test_name", "test_address"), 100, 10, null, null));

        ArrayList<Shop> shops = new ArrayList<>();
        Bundle arg = getArguments();
        shops = (ArrayList<Shop>) arg.getSerializable("shop");

        shopAdapter = new ShopAdapter(inflater.getContext(), shops);

        GridView gridView = (GridView) V.findViewById(R.id.grid_shop_id);
        gridView.setAdapter(shopAdapter);
        gridView.setNumColumns(2);
        gridView.setVerticalSpacing(10);
        gridView.setHorizontalSpacing(10);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("LOG", i + " " + l);

            }
        });

        return V;
    }
}