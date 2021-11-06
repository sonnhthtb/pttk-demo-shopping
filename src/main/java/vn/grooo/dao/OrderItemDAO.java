package vn.grooo.dao;

import vn.grooo.entity.OrderItem;

import java.util.List;

public interface OrderItemDAO extends BaseDAO<OrderItem>{
    OrderItem save(OrderItem orderItem, Long orderId);
    List<OrderItem> findByOrderId(Long id);
    OrderItem findById(Long id);
}
