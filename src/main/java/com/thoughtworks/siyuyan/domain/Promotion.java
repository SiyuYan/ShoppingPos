package com.thoughtworks.siyuyan.domain;

import com.thoughtworks.siyuyan.model.Cart;

/**
 * Created by Administrator on 2014/12/7.
 */
public interface Promotion  {
    public Cart calculate(Cart item);
}
