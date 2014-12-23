package com.thoughtworks.siyuyan.promotions;

import com.thoughtworks.siyuyan.model.Cart;
import com.thoughtworks.siyuyan.domain.Promotion;

/**
 * Created by Administrator on 2014/12/7.
 */
public class ReachOffPromotion implements Promotion {
    private double reach;
    private double off;


    public ReachOffPromotion(double reach, double off) {
        this.reach = reach;
        this.off = off;
    }

    public double getReach() {
        return reach;
    }

    public double getOff() {
        return off;
    }

    @Override
    public Cart calculate(Cart item) {
        double total = item.getTotal();
        double newtotal = total;
        while (newtotal >= reach) {
            total -= off;
            newtotal -= off;
            newtotal -= reach;
        }
        return new Cart(item.getItem().getBarcode(), total / item.getNumber(), item.getNumber());
    }


}
