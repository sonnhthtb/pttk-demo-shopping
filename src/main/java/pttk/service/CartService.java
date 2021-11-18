package pttk.service;

import pttk.model.order.Cart;

public interface CartService {
    Cart getCartByOrderId(int orderId);
    Cart getCartByCustomerId(int customerId);
}
