package vn.grooo.util.impl;

import vn.grooo.dao.ProductDAO;
import vn.grooo.dao.impl.ProductDAOImpl;
import vn.grooo.entity.Order;
import vn.grooo.entity.OrderItem;
import vn.grooo.util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemMapper implements RowMapper<OrderItem> {

    private final ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public OrderItem mapRow(ResultSet resultSet) {
        try {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(resultSet.getLong("id"));
            orderItem.setQuantity(resultSet.getInt("quantity"));
            orderItem.setProduct(productDAO.findById(resultSet.getLong("product_id")));
            if (resultSet.getTimestamp("created_at") != null) {
                orderItem.setCreatedAt(resultSet.getTimestamp("created_at"));
            }
            if (resultSet.getString("updated_at") != null) {
                orderItem.setUpdatedAt(resultSet.getTimestamp("updated_at"));
            }
            orderItem.setIsDeleted(resultSet.getBoolean("is_deleted"));
            return orderItem;
        } catch (SQLException e) {
            return null;
        }
    }
}
