package com.thoughtworks.siyuyan.domain;

import com.thoughtworks.siyuyan.model.Cart;
import com.thoughtworks.siyuyan.util.Promotion;

import java.util.*;

/**
 * Created by Administrator on 2014/12/8.
 */
public class PromotionAdd implements Promotion {

    private HashMap<String, List<Promotion>> promotionmap = new HashMap<String, List<Promotion>>();

    public PromotionAdd(PromotionMap promotionMap){
        this.promotionmap = promotionMap.getPromotionmap();
    }

    public Cart calculate(Cart cart) {
        Cart promotioncart = cart;
        if (promotionmap.containsKey(cart.getItem().getBarcode())) {
            Iterator<Promotion> it = promotionmap.get(cart.getItem().getBarcode()).iterator();
            while (it.hasNext()) {
                Promotion promotion = it.next();
                promotioncart = promotion.calculate(promotioncart);
            }
        }
        return promotioncart;
    }


    }
