package com.thoughtworks.siyuyan.domain;

import com.thoughtworks.siyuyan.model.Cart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2014/12/8. ylei@thoughtworks.com
 */
public class CartMap {
    private Map<String, Cart> cartMap = new HashMap<String, Cart>();
    private ItemMap list;

    public CartMap(ItemMap list) {
        this.list = list;
    }

    public void setCartMap(List<Cart> itemList) {
        try {
            Iterator<Cart> it = itemList.iterator();
            while (it.hasNext()) {
                Cart item = it.next();
                Cart existItem = cartMap.get(item.getItem().getBarcode());

                int newNumber = item.getNumber() + (existItem == null ? 0 : existItem.getNumber());
                double price = list.getItem(item.getItem().getBarcode()).getPrice();

                Cart newItem = new Cart(item.getItem().getBarcode(), price, newNumber);
                cartMap.put(item.getItem().getBarcode(), newItem);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Map<String, Cart> getCartMap() {
        return cartMap;
    }
}
