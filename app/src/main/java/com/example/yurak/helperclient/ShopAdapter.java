package com.example.yurak.helperclient;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yurak.helperclient.Entities.ProductList;
import com.example.yurak.helperclient.Entities.Shop;

import java.util.ArrayList;

/**
 * Created by yurak on 05.05.2018.
 */

public class ShopAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Shop> objects;

    ShopAdapter(Context context, ArrayList<Shop> shops) {
        ctx = context;
        objects = shops;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int i) {
        return objects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewT = view;
        if (viewT == null) {
            viewT = lInflater.inflate(R.layout.shop_item, viewGroup, false);
        }

        Shop p = getShop(i);

        ((TextView) viewT.findViewById(R.id.shop_item_name)).setText(p.getShop_name());
        Glide.with(ctx).load(p.getShop_image()).into((ImageView) viewT.findViewById(R.id.shop_item_image));
        //new DownloadImageTask((ImageView) viewT.findViewById(R.id.shop_item_image))
        //        .execute(p.getShop_image());

        /*CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbBox);
        cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        cbBuy.setTag(position);
        cbBuy.setChecked(p.box);*/
        return viewT;
    }

    Shop getShop(int position) {
        return ((Shop) getItem(position));
    }
}
