package com.thoughtworks.siyuyan.domain;

import com.thoughtworks.siyuyan.model.Cart;

import java.util.Iterator;

/**
 * Created by Administrator on 2014/12/7.
 */
public class Printer {
    public void Print(PromotionAdd promotionadd, CartMap cart) {
        System.out.println("购物明细 （数量 单价 小计）");
        double beforeTotal = 0;
        double afterTotal = 0;

        Iterator<String> it = cart.getCartMap().keySet().iterator();
        while (it.hasNext()) {
            String barcode = it.next();
            Cart item = cart.getCartMap().get(barcode);
            beforeTotal += item.getTotal();
            Cart newItem = promotionadd.calculate(item);
            afterTotal += newItem.getTotal();
            System.out.println(item.getItem().getBarcode() + " " + item.getNumber() + " " + item.getItem().getPrice() + " " + newItem.getTotal());
        }

        Cart totalItem = new Cart("ITEM_TOTAL", afterTotal, 1);

        afterTotal = promotionadd.calculate(totalItem).getItem().getPrice();

        System.out.println("总计金额（优惠前 优惠后 优惠差价）");
        System.out.println(afterTotal + " " + beforeTotal + " " + afterTotal + " " + (beforeTotal - afterTotal));
    }
}
