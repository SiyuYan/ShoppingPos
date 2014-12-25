package com.thoughtworks.siyuyan.domain;

import com.thoughtworks.siyuyan.util.Promotion;

import java.util.*;

/**
 * Created by Administrator on 2014/12/23.
 */
public class PromotionMap {

    private HashMap<String, List<Promotion>> promotionmap = new HashMap<String, List<Promotion>>();

    public HashMap<String, List<Promotion>> getPromotionmap(){
        return promotionmap;
    }

    public void setPromotionMap(List<Map<String, Promotion>> promotionList) {
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
