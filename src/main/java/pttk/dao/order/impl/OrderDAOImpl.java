package pttk.dao.order.impl;

import pttk.dao.BaseDAO;
import pttk.dao.BaseDAOImpl;
import pttk.dao.customer.CustomerDAO;
import pttk.dao.customer.impl.CustomerDAOImpl;
import pttk.dao.order.CartDAO;
import pttk.dao.order.OrderDAO;
import pttk.dao.order.PaymentDAO;
import pttk.dao.order.ShipmentDAO;
import pttk.model.book.LineItemBook;
import pttk.model.order.Order;
import pttk.util.impl.LineItemBookMapper;
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
    public Order findById(int id) {
        return null;
    }

    @Override
    public void save(Order order) {
        String sql = "INSERT INTO `Order`(CustomerID, CartID) VALUES(?,?)";
        Long id  = insert(sql, order.getCustomer().getId(), order.getCart().getId());
        cartDAO.update(order.getCart());
        shipmentDAO.save(order.getShipment(), Math.toIntExact(id));
        paymentDAO.save(order.getPayment(), Math.toIntExact(id));
    }

    @Override
    public Order update(Order order) {
        return null;
    }
}
