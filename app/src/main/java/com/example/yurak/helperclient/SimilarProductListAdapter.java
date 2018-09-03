package com.example.yurak.helperclient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yurak.helperclient.Entities.ProductList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by yurak on 19.05.2018.
 */

public class SimilarProductListAdapter extends RecyclerView.Adapter<SimilarProductListAdapter.ProductViewHolder> {

    private List<ProductList> productListsList = new ArrayList<>();

    SimilarProductListAdapter(List<ProductList> products){
        productListsList = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_item, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = 350;
        view.setLayoutParams(layoutParams);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bind(productListsList.get(position));
    }

    @Override
    public int getItemCount() {
        return productListsList.size();
    }

    public void setItems(Collection<ProductList> productLists){
        productListsList.addAll(productLists);
        notifyDataSetChanged();
    }

    public void clearItems() {
        productListsList.clear();
        notifyDataSetChanged();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        private ImageView productPicture;
        private TextView productName;
        private TextView discount;
        private ImageView shopImage;
        private TextView shopName;

        public ProductViewHolder(View itemView) {
            super(itemView);

            productPicture = (ImageView) itemView.findViewById(R.id.product_picture);
            productName = (TextView) itemView.findViewById(R.id.product_name);
            discount = (TextView) itemView.findViewById(R.id.discount);
            shopImage = (ImageView) itemView.findViewById(R.id.shop_image);
            shopName = (TextView) itemView.findViewById(R.id.shop_name);
        }

        public void bind(ProductList productList){
            Glide.with(itemView.getContext()).load(productList.getProduct().getImage()).into(productPicture);
            productName.setText(productList.getProduct().getProduct_name());
            discount.setText(String.valueOf(productList.getDiscont()));
            Glide.with(itemView.getContext()).load(productList.getShop().getShop_image()).into(shopImage);
            shopName.setText(productList.getShop().getShop_name());
        }
    }
}
