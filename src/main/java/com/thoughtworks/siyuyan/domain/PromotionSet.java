package com.thoughtworks.siyuyan.domain;

import com.thoughtworks.siyuyan.util.Promotion;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/18.
 * 该类暂未使用，准备在pos使用促销手段时，管理各个促销手段
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

