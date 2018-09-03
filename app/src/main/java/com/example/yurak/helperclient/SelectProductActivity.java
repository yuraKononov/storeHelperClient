package com.example.yurak.helperclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.yurak.helperclient.Entities.ProductList;

import java.util.ArrayList;

public class SelectProductActivity extends AppCompatActivity implements HttpRequestGetSimilarProduct.CallBack {

    ProductList productList;
    private RecyclerView recyclerView;
    private SimilarProductListAdapter similarProductListAdapter;
    private TextView selectProductName;
    private TextView selectProductShopName;
    private TextView selectProductDiscount;
    private TextView selectProductDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_product);

        productList = (ProductList) getIntent().getExtras().getSerializable("product_item");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new SpacesItemDecoration(10));

        selectProductName = (TextView) findViewById(R.id.select_product_name);
        selectProductShopName = (TextView) findViewById(R.id.select_product_shop_name);
        selectProductDiscount = (TextView) findViewById(R.id.select_product_discount);
        selectProductDate  = (TextView) findViewById(R.id.select_product_date);

        HttpRequestGetSimilarProduct httpRequestGetSimilarProduct = new HttpRequestGetSimilarProduct();
        httpRequestGetSimilarProduct.setCallBack(this);
        httpRequestGetSimilarProduct.execute(productList.getShop().getShop_id(), productList.getProduct().getProduct_id());

        Glide.with(this).load(productList.getProduct().getImage()).into((ImageView) findViewById(R.id.select_product_image));
        selectProductName.setText(productList.getProduct().getProduct_name());
        selectProductShopName.setText(productList.getShop().getShop_name());
        selectProductDiscount.setText("Акция! " + (int)productList.getDiscont() + "%" + ", Старая цена - "
                + (int)(productList.getPrice() + (productList.getPrice() * (-productList.getDiscont() / 100)))
                + "руб, Новая цена - " + (int)productList.getPrice() + "руб");
        selectProductDate.setText(productList.getDiscont_begin().toString() + " - " + productList.getDiscont_end().toString());
    }

    @Override
    public void setSimilarProductList(final ArrayList<ProductList> products) {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(SelectProductActivity.this, LinearLayoutManager.HORIZONTAL,
                false));

        similarProductListAdapter = new SimilarProductListAdapter(products);
        recyclerView.setAdapter(similarProductListAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView,
                new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(SelectProductActivity.this, SelectProductActivity.class);
                intent.putExtra("product_item", products.get(position));
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private String getMonth(int a){
        switch (a){
            case 1: return "Января";
            case 2: return "Февраля";
            case 3: return "Марта";
            case 4: return "Апреля";
            case 5: return "Мая";
            case 6: return "Июня";
            case 7: return "Июля";
            case 8: return "Августа";
            case 9: return "Сентября";
            case 10: return "Октября";
            case 11: return "Ноября";
            case 12: return "Декабря";
        }
        return "Error";
    }
}
