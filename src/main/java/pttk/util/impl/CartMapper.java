package pttk.util.impl;

import pttk.model.order.Cart;
import pttk.model.user.User;
import pttk.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper implements RowMapper<Cart> {

    @Override
    public Cart mapRow(ResultSet rs) {
        try {
            Cart cart = new Cart();
            User customer = new User();
            customer.setId(rs.getInt("UserID"));
            cart.setCustomer(customer);
            cart.setId(rs.getInt("ID"));
            cart.setStatus(rs.getString("Status"));
            cart.setTotalPrice(rs.getFloat("TotalPrice"));
            return cart;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
