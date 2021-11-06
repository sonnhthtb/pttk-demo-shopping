package vn.grooo.dao.impl;

import vn.grooo.dao.OrderDAO;
import vn.grooo.entity.Order;
import vn.grooo.util.impl.OrderMapper;

import java.util.List;

public class OrderDAOImpl extends BaseDAOImpl<Order> implements OrderDAO {

    @Override
    public Order save(Order order) {
        String sql = "INSERT INTO `order` (total_price, total_amount, user_id, created_at) VALUES (?, ?, ?, ?)";
        Long id = insert(sql, order.getTotalPrice(), order.getTotalAmount(), order.getUser().getId(), order.getCreatedAt());
        return findById(id);
    }

    @Override
    public void update(Order order) {
        String sql = "UPDATE `Order` SET status = ?, updated_at = ? WHERE id = ?";
        update(sql, order.getStatus(), order.getUpdatedAt(), order.getId());
    }

    @Override
    public List<Order> findOrderByUserId(Long id) {
        String sql = "SELECT * FROM `order` WHERE user_id = ?";
        return query(sql, new OrderMapper(), id);
    }

    @Override
    public Order findById(Long id) {
        String sql = "SELECT * FROM `order` WHERE id = ?";
        List<Order> orders = query(sql, new OrderMapper(), id);
         return orders.isEmpty() ? null : orders.get(0);
    }

    @Override
    public List<Order> findAll() {
        String sql = "SELECT * FROM `order`";
        return query(sql, new OrderMapper());
    }

    @Override
    public List<Order> findAll(int offset, int limit) {
        String sql = "SELECT * FROM `order` LIMIT ? , ?";
        return query(sql, new OrderMapper(), offset, limit);
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM `order` WHERE is_deleted = 0";
        return count(sql);
    }
}
