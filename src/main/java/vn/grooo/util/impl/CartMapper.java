package vn.grooo.util.impl;

import vn.grooo.entity.Cart;
import vn.grooo.entity.Customer;
import vn.grooo.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper implements RowMapper<Cart> {

    @Override
    public Cart mapRow(ResultSet rs) {
        try{
            Cart cart = new Cart();
            Customer customer = new Customer();
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
