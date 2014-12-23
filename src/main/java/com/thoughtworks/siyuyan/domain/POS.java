package com.thoughtworks.siyuyan.domain;

import com.google.inject.Guice;
import com.thoughtworks.siyuyan.module.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/8.
 */
public class POS {
    public static void main(String[] args) throws IOException {

        String itemParserPath = "./src/main/resources/item.txt";
        String cartParserPath = "./src/main/resources/cart.txt";
        String discountPath = "./src/main/resources/discount_promotion.txt";
        String secondHalfPath = "./src/main/resources/second_half_price_promotion.txt";
        String reachOffPath = "./src/main/resources/reach_off_promotion.txt";

        ItemMap list = new ItemMap();
        CartMap cartMap = new CartMap(list);


        //   list.setItemMap(new ItemParser().parse(itemParserPath));
        //  cartMap.setCartMap(new CartParser().parse(cartParserPath));
        list.setItemMap(Guice.createInjector(new ItemParserModule()).getInstance(Parser.class).parse(itemParserPath));
        cartMap.setCartMap(Guice.createInjector(new CartParserModule()).getInstance(Parser.class).parse(cartParserPath));


        //   Parser discountparser = new DiscountParser();
        //   Parser SecondHalfparser = new SecondHalfParser();
        //   Parser ReachOffparser = new ReachOffParser();
        Parser discountparser = Guice.createInjector(new DiscountParserModule()).getInstance(Parser.class);
        Parser SecondHalfparser = Guice.createInjector(new SecondHalfParserModule()).getInstance(Parser.class);
        Parser ReachOffparser = Guice.createInjector(new ReachOffParserModule()).getInstance(Parser.class);


        List<Map<String, Promotion>> discountList = discountparser.parse(discountPath);
        List<Map<String, Promotion>> SecondHalfList = SecondHalfparser.parse(secondHalfPath);
        List<Map<String, Promotion>> ReachOffList = ReachOffparser.parse(reachOffPath);


//        PromotionSet promotionSet = new PromotionSet();
//        promotionSet.setDiscountList(discountList);
//        promotionSet.setSecondHalfList(SecondHalfList);
//        promotionSet.setReachOffList(ReachOffList);
        //   promotionAdd.setPromotionSet(promotionSet);

        PromotionAdd promotionAdd = new PromotionAdd();

        try {
            promotionAdd.add(discountList);
            promotionAdd.add(SecondHalfList);
            promotionAdd.add(ReachOffList);


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Printer printer = new Printer();
        printer.Print(promotionAdd, cartMap);
    }
}
