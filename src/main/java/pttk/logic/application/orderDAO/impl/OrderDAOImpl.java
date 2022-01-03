package pttk.logic.application.orderDAO.impl;

import pttk.logic.application.BaseDAOImpl;
import pttk.logic.application.customerDAO.CustomerDAO;
import pttk.logic.application.customerDAO.impl.CustomerDAOImpl;
import pttk.logic.application.orderDAO.CartDAO;
import pttk.logic.application.orderDAO.OrderDAO;
import pttk.logic.application.orderDAO.PaymentDAO;
import pttk.logic.application.orderDAO.ShipmentDAO;
import pttk.model.order.Order;
import pttk.util.impl.OrderMapper;

import java.util.List;

public class OrderDAOImpl extends BaseDAOImpl implements OrderDAO {
    private final CustomerDAO customerDAO = new CustomerDAOImpl();
    private final CartDAO cartDAO = new CartDAOImpl();
    private final ShipmentDAO shipmentDAO = new ShipmentDAOImpl();
    private final PaymentDAO paymentDAO = new PaymentDAOImpl();

    @Override
    public List<Order> findAll() {
        String sql = "SELECT * FROM `Order`";
        List<Order> orderList = query(sql, new OrderMapper());
        orderList.forEach(order -> {
            order.setCustomer(customerDAO.findById(order.getCustomer().getId()));
            order.setCart(cartDAO.findById(order.getCart().getId()));
            order.setPayment(paymentDAO.findByOrderId(order.getId()));
            order.setShipment(shipmentDAO.findByOrderId(order.getId()));
        });
        return orderList;
    }

    @Override
    public List<Order> findAllByCustomerId(int customerId) {
        String sql = "SELECT * FROM `Order` WHERE CustomerID = ? ORDER BY Date DESC";
        List<Order> orderList = query(sql, new OrderMapper(), customerId);
        orderList.forEach(order -> {
            order.setCustomer(customerDAO.findById(order.getCustomer().getId()));
            order.setCart(cartDAO.findById(order.getCart().getId()));
            order.setPayment(paymentDAO.findByOrderId(order.getId()));
            order.setShipment(shipmentDAO.findByOrderId(order.getId()));
        });
        return orderList;
    }

    @Override
    public Order findById(int id) {
        String sql = "Select * from order where id = ?";
        List<Order> orderList = query(sql, new OrderMapper(), id);
        return orderList.isEmpty() ? null : orderList.get(0);
    }

    @Override
    public void save(Order order) {
        String sql = "INSERT INTO `Order`(CustomerID, Status, CartID) VALUES(?, ? ,?)";
        Long id = insert(sql, order.getCustomer().getId(), order.getStatus(), order.getCart().getId());
        cartDAO.update(order.getCart());
        shipmentDAO.save(order.getShipment(), Math.toIntExact(id));
        paymentDAO.save(order.getPayment(), Math.toIntExact(id));
    }

    @Override
    public void update(String status, int id) {
        String sql = "update `order` set status = ? where id = ?";
        update(sql, status, id);
    }
}
