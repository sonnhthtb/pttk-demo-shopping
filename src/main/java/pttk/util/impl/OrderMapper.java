package pttk.util.impl;

import pttk.model.order.Cart;
import pttk.model.order.Order;
import pttk.model.user.User;
import pttk.util.RowMapper;

import java.sql.ResultSet;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs) {
        try {
            Order order = new Order();
            order.setId(rs.getInt("ID"));
            order.setDate(rs.getDate("Date"));
            order.setStatus(rs.getString("Status"));
            Cart cart = new Cart();
            cart.setId(rs.getInt("CartID"));
            order.setCart(cart);
            User customer = new User();
            customer.setId(rs.getInt("UserID"));
            order.setCustomer(customer);
            return order;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
