package vn.grooo.dao.impl;

import vn.grooo.dao.BaseDAO;
import vn.grooo.dao.OrderItemDAO;
import vn.grooo.entity.OrderItem;
import vn.grooo.util.impl.OrderItemMapper;

import java.util.List;

public class OrderItemDAOImpl extends BaseDAOImpl<OrderItem> implements OrderItemDAO {
    @Override
    public OrderItem save(OrderItem orderItem, Long orderId) {
        String sql = "INSERT INTO order_item (product_id, quantity, order_id) VALUES(?, ?, ?)";
        Long id = insert(sql, orderItem.getProduct().getId(), orderItem.getQuantity(), orderId);
        return findById(id);
    }

    @Override
    public List<OrderItem> findByOrderId(Long id) {
        String sql = "SELECT * FROM order_item WHERE order_id = ?";
        return query(sql, new OrderItemMapper(), id);
    }

    @Override
    public OrderItem findById(Long id) {
        String sql = "SELECT * FROM order_item WHERE id =?";
        List<OrderItem> orderItems = query(sql, new OrderItemMapper(), id);
        return orderItems.isEmpty() ? null : orderItems.get(0);
    }
}
