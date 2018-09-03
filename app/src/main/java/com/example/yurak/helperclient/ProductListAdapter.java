package com.example.yurak.helperclient;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yurak.helperclient.Entities.ProductList;

import java.util.ArrayList;

public class ProductListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<ProductList> objects;
    ProductListAdapter(Context context, ArrayList<ProductList> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setProductLists(ArrayList<ProductList> products){
        objects = products;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.product_list_item, parent, false);
        }

        ProductList p = getProductList(position);

        ((TextView) view.findViewById(R.id.product_name)).setText(p.getProduct().getProduct_name());
        ((TextView) view.findViewById(R.id.discount)).setText(p.getDiscont() + "");
        Glide.with(ctx).load(p.getProduct().getImage()).into((ImageView) view.findViewById(R.id.product_picture));

        ((TextView) view.findViewById(R.id.shop_name)).setText(p.getShop().getShop_name());
        Glide.with(ctx).load(p.getShop().getShop_image()).into((ImageView) view.findViewById(R.id.shop_image));

        /*CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbBox);
        cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        cbBuy.setTag(position);
        cbBuy.setChecked(p.box);*/
        return view;
    }

    ProductList getProductList(int position) {
        return ((ProductList) getItem(position));
    }
}
