package com.thoughtworks.siyuyan.promotions;

import com.thoughtworks.siyuyan.model.Cart;
import com.thoughtworks.siyuyan.util.Promotion;

/**
 * Created by Administrator on 2014/12/7.
 */
public class DiscountPromotion implements Promotion {
    private double rate;

   public DiscountPromotion(double rate) {this.rate = rate;}

   public double getRate() {return rate;}

    @Override
    public Cart calculate(Cart item) {
        return new Cart(item.getItem().getBarcode(), item.getItem().getPrice() * rate / 100, item.getNumber());
    }
}
