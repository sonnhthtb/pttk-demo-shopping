package pttk.dao.order;

import pttk.dao.BaseDAO;
import pttk.model.order.Order;

import java.util.List;

public interface OrderDAO extends BaseDAO {
    List<Order> findAll();
    Order findById(int id);
    void save(Order order);
    Order update(Order order);
}