/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nam_Nguyen
 */
public class Cart {
      private HashMap<String, Items> cartItems;

    public Cart() {
        cartItems = new HashMap<>();
    }

    public Cart(HashMap<String, Items> cartItems) {
        this.cartItems = cartItems;
    }

    public HashMap<String, Items> getCartItems() {
        return cartItems;
    }

    public void setCartItems(HashMap<String, Items> cartItems) {
        this.cartItems = cartItems;
    }

    // insert to cart
    public void plusToCart(String key, Items item) {
        boolean check = cartItems.containsKey(key);
        if (check) {
            int quantity_old = item.getQuantity();
            item.setQuantity(quantity_old + 1);
            cartItems.put(key, item);
        } else {
            cartItems.put(key, item);
        }
    }

    // sub to cart
    public void subToCart(String key, Items item) {
        boolean check = cartItems.containsKey(key);
        if (check) {
            int quantity_old = item.getQuantity();
            if (quantity_old < 1) {
                cartItems.remove(key);
            } else {
                item.setQuantity(quantity_old);
                cartItems.put(key, item);
            }
        }
    }

    // remove to cart
    public void removeToCart(String key) {
        boolean check = cartItems.containsKey(key);
        if (check) {
            cartItems.remove(key);
        }
    }

    // count item
    public int countItem() {
        return cartItems.size();
    }
    public int countQty(){
        int count = 0;
        // count = price * quantity
        for (Map.Entry<String, Items> list : cartItems.entrySet()) {
            count += list.getValue().getQuantity();
        }
        return count;
    }

    // sum total 
    public int totalCart() {
        int count = 0;
        // count = price * quantity
        for (Map.Entry<String, Items> list : cartItems.entrySet()) {
            count += (list.getValue().getProduct().getPrice()*(100-list.getValue().getProduct().getDiscountProduct())/100) * list.getValue().getQuantity();
        }
        return count;
    }
}
