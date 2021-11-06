package vn.grooo.dao;

import vn.grooo.entity.Order;

import java.util.List;

public interface OrderDAO extends BaseDAO<Order>{

    Order save(Order order);
    void update(Order order);
    List<Order> findOrderByUserId(Long id);
    Order findById(Long id);
    List<Order> findAll();
    List<Order> findAll(int offset, int limit);
    int getTotalItem();

}
