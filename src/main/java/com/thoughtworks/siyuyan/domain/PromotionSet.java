package com.thoughtworks.siyuyan.domain;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/18.
 */
public class PromotionSet {

    List<Map<String, Promotion>> discountList;
    List<Map<String, Promotion>> SecondHalfList;
    List<Map<String, Promotion>> ReachOffList;



    public void setDiscountList(List<Map<String, Promotion>> discountList) {
        this.discountList = discountList;
    }

    public void setSecondHalfList(List<Map<String, Promotion>> secondHalfList) {
        SecondHalfList = secondHalfList;
    }

    public void setReachOffList(List<Map<String, Promotion>> reachOffList) {
        ReachOffList = reachOffList;
    }
}

