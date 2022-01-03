package pttk.logic.application.orderDAO;

import pttk.logic.application.BaseDAO;
import pttk.model.order.Order;

import java.util.List;

public interface OrderDAO extends BaseDAO {
    List<Order> findAll();

    List<Order> findAllByCustomerId(int customerId);

    Order findById(int id);

    void save(Order order);

    void update(String status, int id);
}
