package pttk.service;

import pttk.entity.order.Cart;

public interface CartService {
    Cart getCartByOrderId(int orderId);
    Cart getCartByCustomerId(int customerId);
}
