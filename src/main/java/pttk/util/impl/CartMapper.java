package pttk.util.impl;

import pttk.model.user.User;
import pttk.model.order.Cart;
import pttk.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper implements RowMapper<Cart> {

    @Override
    public Cart mapRow(ResultSet rs) {
        try {
            Cart cart = new Cart();
            User customer = new User();
            customer.setId(rs.getInt("CustomerID"));
            cart.setCustomer(customer);
            cart.setId(rs.getInt("ID"));
            cart.setCartStatus(rs.getString("CartStatus"));
            cart.setTotalPrice(rs.getFloat("TotalPrice"));
            return cart;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
