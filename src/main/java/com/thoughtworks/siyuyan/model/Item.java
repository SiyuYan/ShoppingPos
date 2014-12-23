package com.thoughtworks.siyuyan.model;

/**
 * Created by Administrator on 2014/12/23.
 */
public class Item {
    private String barcode;
    private double price;

    public Item(String barcode, double price) {
        this.barcode = barcode;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getPrice() {
        return price;
    }

}