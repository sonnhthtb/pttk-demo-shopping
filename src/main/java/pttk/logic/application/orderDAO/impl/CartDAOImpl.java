package pttk.logic.application.orderDAO.impl;

import pttk.logic.application.BaseDAOImpl;
import pttk.logic.application.bookDAO.LineItemBookDAO;
import pttk.logic.application.bookDAO.impl.LineItemBookDAOImpl;
import pttk.logic.application.orderDAO.CartDAO;
import pttk.model.order.Cart;
import pttk.util.impl.CartMapper;

import java.util.List;

public class CartDAOImpl extends BaseDAOImpl implements CartDAO {

    private final LineItemBookDAO lineItemBookDAO = new LineItemBookDAOImpl();

    @Override
    public Cart getCartByCustomerId(int customerId, String status) {
        String sql = "SELECT * FROM cart WHERE CustomerId = ? and CartStatus = ?";
        List<Cart> cartList = query(sql, new CartMapper(), customerId, status);
        if (!cartList.isEmpty()) {
            return findById(cartList.get(0).getId());
        }
        return null;
    }

    @Override
    public Cart findById(int id) {
        String sql = "SELECT * FROM cart WHERE ID = ?";
        List<Cart> cartList = query(sql, new CartMapper(), id);
        cartList.forEach(cart -> {
            cart.setLineItemBooks(lineItemBookDAO.findByCartId(cart.getId()));
        });
        return cartList.isEmpty() ? null : cartList.get(0);
    }

    @Override
    public Long create(int customerId) {
        String sql = "insert into cart(customerId, cartStatus, totalPrice) value (?,?,?)";
        Long ans = insert(sql, customerId, "active", 0);
        return ans;
    }

    @Override
    public Cart update(Cart cart) {
        String sql = "UPDATE Cart SET TotalPrice = ?, CartStatus = ? WHERE id = ?";
        update(sql, cart.getTotalPrice(), cart.getCartStatus(), cart.getId());
        return cart;
    }
}
