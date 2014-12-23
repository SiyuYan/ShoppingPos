package com.thoughtworks.siyuyan.model;

/**
 * Created by Administrator on 2014/12/23.
 */
public class Cart {

    private Item item;
    private int number;
    public Cart(String barcode, double price, int number) {
        item = new Item(barcode, price);
        this.number = number;
    }
    public Item getItem() {
        return item;
    }
    public int getNumber() {
        return number;
    }
    public double getTotal() {
        return number * item.getPrice();
    }

}