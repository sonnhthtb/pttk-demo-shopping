package vn.grooo.util.impl;

import vn.grooo.entity.Order;
import vn.grooo.entity.Product;
import vn.grooo.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {

    private final UserDAO userDAO = new UserDAOImpl();
    private final OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

    @Override
    public Order mapRow(ResultSet resultSet) {
        try {
            Order order = new Order();
            order.setId(resultSet.getLong("id"));
            order.setTotalPrice(resultSet.getFloat("total_price"));
            order.setTotalAmount(resultSet.getInt("total_amount"));
            order.setStatus(resultSet.getString("status"));
            order.setUser(userDAO.findById(resultSet.getLong("user_id")));
            order.setOrderItems(orderItemDAO.findByOrderId(order.getId()));
            if (resultSet.getTimestamp("created_at") != null) {
                order.setCreatedAt(resultSet.getTimestamp("created_at"));
            }
            if (resultSet.getString("updated_at") != null) {
                order.setUpdatedAt(resultSet.getTimestamp("updated_at"));
            }
            order.setIsDeleted(resultSet.getBoolean("is_deleted"));
            return order;
        } catch (SQLException e) {
            return null;
        }
    }
}
