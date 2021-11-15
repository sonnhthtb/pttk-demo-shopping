package pttk.service;

import pttk.entity.Cart;

public interface CartService {
    Cart getCartByOrderId(int orderId);
}
