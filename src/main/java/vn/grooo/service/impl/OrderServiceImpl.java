package vn.grooo.service.impl;

import vn.grooo.dao.OrderDAO;
import vn.grooo.dao.OrderItemDAO;
import vn.grooo.dao.ProductDAO;
import vn.grooo.dao.UserDAO;
import vn.grooo.dao.impl.OrderDAOImpl;
import vn.grooo.dao.impl.OrderItemDAOImpl;
import vn.grooo.dao.impl.ProductDAOImpl;
import vn.grooo.dao.impl.UserDAOImpl;
import vn.grooo.entity.Order;
import vn.grooo.entity.OrderItem;
import vn.grooo.entity.UserEntity;
import vn.grooo.service.OrderService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO = new OrderDAOImpl();
    private final OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private final ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public Order save(Order order) {
        order.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        Order newOrder = orderDAO.save(order);
        List<OrderItem> orderItems = new ArrayList<>();
        for(OrderItem orderItem: order.getOrderItems()) {
            OrderItem newOrderItem = orderItemDAO.save(orderItem, newOrder.getId());
            orderItems.add(newOrderItem);
        }
        newOrder.setOrderItems(orderItems);
        return newOrder;
    }

    @Override
    public void update(Long id, String status) {
        Order order = orderDAO.findById(id);
        order.setStatus(status);
        order.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        orderDAO.update(order);
    }

    @Override
    public List<Order> findByUserId(Long id) {
        List<Order> orders = orderDAO.findOrderByUserId(id);
        for(Order order : orders) {
            List<OrderItem> orderItems = orderItemDAO.findByOrderId(order.getId());
            order.setOrderItems(orderItems);
        }
        return orders;
    }

    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public List<Order> findAll(int offset, int limit) {
        return orderDAO.findAll(offset, limit);
    }

    @Override
    public int getTotalItem() {
        return orderDAO.getTotalItem();
    }

}
