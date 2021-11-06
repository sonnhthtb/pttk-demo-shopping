package vn.grooo.service;

import vn.grooo.entity.Order;

import java.util.List;

public interface OrderService {
    Order save(Order order);
    void update(Long id, String status);
    List<Order> findByUserId(Long id);
    List<Order> findAll();
    List<Order> findAll(int offset, int limit);
    int getTotalItem();
}
