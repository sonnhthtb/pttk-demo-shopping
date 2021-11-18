package pttk.service.impl;

import pttk.dao.cart.CartDAO;
import pttk.dao.cart.impl.CardDAOImpl;
import pttk.model.order.Cart;
import pttk.service.CartService;

public class CartServiceimpl implements CartService {

    private final CartDAO cartDAO = new CardDAOImpl();

    @Override
    public Cart getCartByOrderId(int orderId) {
        return null;
    }

    @Override
    public Cart getCartByCustomerId(int customerId) {
        return null;
    }
}
