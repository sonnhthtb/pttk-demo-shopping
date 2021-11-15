package vn.grooo.service;

import vn.grooo.entity.Cart;

public interface CartService {
    Cart getCartByOrderId(int orderId);
}
