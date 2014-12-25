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
    private ItemMap itemMap;

    public CartMap(ItemMap itemmap) {
        this.itemMap = itemmap;
    }

    public void setCartMap(List<Cart> itemList) {//list to map
        try {
            Iterator<Cart> it = itemList.iterator();
            while (it.hasNext()) {
                Cart cart = it.next();
                Cart existItem = cartMap.get(cart.getItem().getBarcode());

                Cart newCart = new Cart(cart.getItem().getBarcode(),
                        itemMap.getItem(cart.getItem().getBarcode()).getPrice(),
                        cart.getNumber() + (existItem == null ? 0 : existItem.getNumber()));

                cartMap.put(cart.getItem().getBarcode(), newCart);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Map<String, Cart> getCartMap() {
        return cartMap;
    }
}
