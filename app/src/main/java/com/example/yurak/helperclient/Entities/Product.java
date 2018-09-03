package com.example.yurak.helperclient.Entities;

import java.io.Serializable;

/**
 * Created by yurak on 21.04.2018.
 */

public class Product implements Serializable {

    public Product(){}

    public Product(String image, String product_name){
        this.image = image;
        this.product_name = product_name;
    }

    private int product_id;
    private String image;
    private String product_name;


    public int getProduct_id() {
        return product_id;
    }

    public String getImage() {
        return image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "Product[id_product=" + product_id + ", product_name=" + product_name;
    }
}