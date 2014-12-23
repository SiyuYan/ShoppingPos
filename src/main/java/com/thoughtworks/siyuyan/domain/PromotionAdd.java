package com.thoughtworks.siyuyan.domain;

import com.thoughtworks.siyuyan.model.Cart;

import java.util.*;

/**
 * Created by Administrator on 2014/12/8.
 */
public class PromotionAdd {

    private HashMap<String, List<Promotion>> promotionmap = new HashMap<String, List<Promotion>>();

    public Cart calculate(Cart item) {
        Cart promotionitem = item;
        if (promotionmap.containsKey(item.getItem().getBarcode())) {
            Iterator<Promotion> it = promotionmap.get(item.getItem().getBarcode()).iterator();
            while (it.hasNext()) {
                Promotion promotion = it.next();
                promotionitem = promotion.calculate(promotionitem);
            }
        }
        return promotionitem;
    }

       public void add( List<Map<String, Promotion>> promotionList) {
        try {
            Iterator<Map<String, Promotion>> it = promotionList.iterator();
            while (it.hasNext()) {
                Map<String, Promotion> map = it.next();
                Iterator iter = map.entrySet().iterator();
                Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iter.next();

                List<Promotion> proList;
                if (promotionmap.containsKey(entry.getKey())) {
                    proList = promotionmap.get(entry.getKey());
                } else {
                    proList = new LinkedList<Promotion>();
                }
                proList.add(map.get(entry.getKey()));
                promotionmap.put(entry.getKey(), proList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
