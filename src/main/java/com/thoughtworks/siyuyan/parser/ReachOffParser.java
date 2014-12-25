package com.thoughtworks.siyuyan.parser;

import com.thoughtworks.siyuyan.promotions.ReachOffPromotion;
import com.thoughtworks.siyuyan.util.Parser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/7.
 */
public class ReachOffParser extends Parser<Map<String, ReachOffPromotion>> {
    @Override
    public Map<String, ReachOffPromotion> convert(String line) {
        Map<String, ReachOffPromotion> map = new HashMap<String, ReachOffPromotion>();

        map.put(line.split(":")[0], new ReachOffPromotion(Double.parseDouble(line.split(":")[1]), Double.parseDouble(line.split(":")[2])));

        return map;

    }
}


