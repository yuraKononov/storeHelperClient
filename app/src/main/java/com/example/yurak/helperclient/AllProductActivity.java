package com.example.yurak.helperclient;

import android.content.Intent;
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
 * Created by yurak on 05.05.2018.
 */

public class AllProductActivity extends Fragment {

    private ProductListAdapter productListAdapter;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.activity_all_product, container, false);

        ArrayList<ProductList> test = new ArrayList<>();
        test.add(new ProductList(new Product("https://dixy.ru/upload/iblock/17d/ЦТ0038253.jpg", "test yablochko"),
                new Shop("test_name", "test_address"), 100, 10, null, null));
        test.add(new ProductList(new Product("https://dixy.ru/upload/iblock/fa6/10E0076186.jpg", "test yablochko2 a tak ge mnogo teksta, 250г"),
                new Shop("test_name", "test_address"), 100, 10, null, null));
        test.add(new ProductList(new Product("https://dixy.ru/upload/iblock/c18/DI00078738.jpg", "test mandarin"),
                new Shop("test_name", "test_address"), 100, 10, null, null));

        ArrayList<ProductList> products = new ArrayList<>();
        Bundle arg = getArguments();
        products = (ArrayList<ProductList>) arg.getSerializable("products");

        productListAdapter = new ProductListAdapter(inflater.getContext(), products);

        GridView gridView = (GridView) V.findViewById(R.id.grid_all_product_id);
        gridView.setAdapter(productListAdapter);
        gridView.setNumColumns(2);
        gridView.setVerticalSpacing(10);
        gridView.setHorizontalSpacing(10);

        final ArrayList<ProductList> finalProducts = products;
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("LOG", i + " " + l);
                Intent intent = new Intent(inflater.getContext(), SelectProductActivity.class);
                intent.putExtra("product_item", finalProducts.get(i));
                startActivity(intent);

            }
        });

        return V;
    }
}
