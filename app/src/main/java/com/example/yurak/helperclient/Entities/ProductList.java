package com.example.yurak.helperclient.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yurak on 21.04.2018.
 */

public class ProductList implements Serializable{

    public ProductList(){}

    public ProductList(Product product, Shop shop, double price, double discont, Date discont_begin, Date discont_end) {
        this.product = product;
        this.shop = shop;
        this.price = price;
        this.discont = discont;
        this.discont_begin = discont_begin;
        this.discont_end = discont_end;
    }

    private Product product;
    private Shop shop;
    private double price;
    private double discont;
    private Date discont_begin;
    private Date discont_end;

    public Product getProduct() {
        return product;
    }

    public Shop getShop() {
        return shop;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscont() {
        return discont;
    }

    public Date getDiscont_begin() {
        return discont_begin;
    }

    public Date getDiscont_end() {
        return discont_end;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscont(double discont) {
        this.discont = discont;
    }

    public void setDiscont_begin(Date discont_begin) {
        this.discont_begin = discont_begin;
    }

    public void setDiscont_end(Date discont_end) {
        this.discont_end = discont_end;
    }
}

