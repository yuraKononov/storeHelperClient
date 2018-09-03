package com.example.yurak.helperclient.Entities;

import java.io.Serializable;

/**
 * Created by yurak on 21.04.2018.
 */

public class Shop implements Serializable {

    public Shop(){}

    public Shop(String shop_name, String shop_address){
        this.shop_name = shop_name;
        this.shop_address = shop_address;
    }

    private int shop_id;
    private String shop_name;
    private String shop_address;
    private String shop_image;

    public int getShop_id() {
        return shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public String getShop_address() {
        return shop_address;
    }

    public String getShop_image() {
        return shop_image;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public void setShop_address(String shop_address) {
        this.shop_address  = shop_address;
    }

    public void setShop_image(String shop_image) {
        this.shop_image = shop_image;
    }
}
