package com.thoughtworks.siyuyan.parser;

import com.thoughtworks.siyuyan.model.Cart;
import com.thoughtworks.siyuyan.domain.Parser;

/**
 * Created by Administrator on 2014/11/23.
 */
public class CartParser extends Parser<Cart> {
    @Override
    public Cart convert(String line) {
        Integer amount = 1;
        if (line.split("-").length > 1) {
            amount = Integer.parseInt(line.split("-")[1]);
        }
        return new Cart(line.split("-")[0], 0, amount);
    }


}