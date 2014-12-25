package com.thoughtworks.siyuyan.parser;

import com.thoughtworks.siyuyan.promotions.DiscountPromotion;
import com.thoughtworks.siyuyan.util.Parser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/11/23.
 */
public class DiscountParser extends Parser<Map<String, DiscountPromotion>> {
    @Override
    public Map<String, DiscountPromotion> convert(String line) {

        Map<String, DiscountPromotion> map = new HashMap<String, DiscountPromotion>();

        map.put(line.split(":")[0], new DiscountPromotion(Double.parseDouble(line.split(":")[1])));
        return map;
    }


}

