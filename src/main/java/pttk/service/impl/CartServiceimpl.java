package pttk.service.impl;

import pttk.dao.cart.CartDAO;
import pttk.dao.cart.impl.CardDAOImpl;
import pttk.model.book.ItemBook;
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
        return cartDAO.getCartByCustomerId(customerId);
    }

    @Override
    public Boolean addBookToCart(ItemBook itemBook) {
        return null;
    }

    @Override
    public Boolean addClothesToCart(ItemBook itemBook) {
        return null;
    }

    @Override
    public Long create(int customerId) {
        return cartDAO.create(customerId);
    }
}
